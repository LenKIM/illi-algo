package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_18_2573 {
    static int N, M;
    static int[][][] map; // year, row, col
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 (row)
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 (col)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // row
        M = Integer.parseInt(st.nextToken()); // col
        map = new int[301][N][M]; // 연도별 맵

        Deque<int[]> q = new LinkedList<>();
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                map[0][row][col] = Integer.parseInt(st.nextToken());
                if (map[0][row][col] != 0) {
                    q.add(new int[]{row, col});
                }
            }
        }

        int level = 0;
        while (!q.isEmpty()) {
            if (isIslandSplit(level)) {
                System.out.println(level);
                return;
            }

            int size = q.size();
            boolean[][] visitedThisTurn = new boolean[N][M]; // 중복 큐 삽입 방지용
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int row = cur[0];
                int col = cur[1];

                int nearWater = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = row + dx[d];
                    int nc = col + dy[d];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                    if (map[level][nr][nc] == 0) {
                        nearWater++;
                    }
                }

                int nextValue = Math.max(0, map[level][row][col] - nearWater);
                map[level + 1][row][col] = nextValue;

                if (nextValue > 0 && !visitedThisTurn[row][col]) {
                    q.add(new int[]{row, col});
                    visitedThisTurn[row][col] = true;
                }
            }

            level++;
        }

        System.out.println(0); // 분리되기 전에 전부 녹은 경우
    }

    static boolean[][] visited;
    static int[][] currentMap;

    private static boolean isIslandSplit(int level) {
        currentMap = map[level];
        visited = new boolean[N][M];

        int componentCount = 0;
        boolean hasIce = false;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (currentMap[row][col] > 0) {
                    hasIce = true;
                    if (!visited[row][col]) {
                        bfs(row, col);
                        componentCount++;
                    }
                }
            }
        }

        if (!hasIce) {
            System.out.println(0);
            System.exit(0); // 얼음 다 녹았지만 분리 안된 경우
        }

        return componentCount >= 2;
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        visited[row][col] = true;
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (!visited[nx][ny] && currentMap[nx][ny] > 0) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}