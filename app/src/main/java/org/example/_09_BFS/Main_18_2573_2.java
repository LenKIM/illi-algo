package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18_2573_2 {
    static int N, M;
    static int[][][] map = new int[2][300][300]; // 현재/다음 해만 저장
    static int[] dx = {-1, 1, 0, 0}; // 상하
    static int[] dy = {0, 0, -1, 1}; // 좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                int val = Integer.parseInt(st.nextToken());
                map[0][row][col] = val;
                if (val > 0) q.add(new int[]{row, col});
            }
        }

        int year = 0;
        while (true) {
            if (isSeparated(map[year % 2])) {
                System.out.println(year);
                return;
            }

            Queue<int[]> nextQ = new LinkedList<>();
            int[][] curMap = map[year % 2];
            int[][] nextMap = new int[N][M];

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int row = cur[0], col = cur[1];
                int melt = 0;

                for (int d = 0; d < 4; d++) {
                    int nr = row + dx[d];
                    int nc = col + dy[d];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                    if (curMap[nr][nc] == 0) melt++;
                }

                int newHeight = Math.max(0, curMap[row][col] - melt);
                nextMap[row][col] = newHeight;
                if (newHeight > 0) {
                    nextQ.add(new int[]{row, col});
                }
            }

            if (nextQ.isEmpty()) {
                System.out.println(0);
                return;
            }

            map[(year + 1) % 2] = nextMap;
            q = nextQ;
            year++;
        }
    }

    static boolean isSeparated(int[][] curMap) {
        boolean[][] visited = new boolean[N][M];
        int components = 0;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (curMap[row][col] > 0 && !visited[row][col]) {
                    bfs(row, col, curMap, visited);
                    components++;
                    if (components >= 2) return true;
                }
            }
        }

        return false;
    }

    static void bfs(int row, int col, int[][] map, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dx[d];
                int nc = c + dy[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (!visited[nr][nc] && map[nr][nc] > 0) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}