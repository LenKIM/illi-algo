package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_03_7576 {
    static int N, M;
    static int[][] ground;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        ground = new int[N][M];
        isVisited = new boolean[N][M];
        int count = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st1.nextToken());
                if (ground[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    isVisited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int curX = pos[0];
                int curY = pos[1];
                for (int k = 0; k < 4; k++) {
                    int nx = curX + dx[k];
                    int ny = curY + dy[k];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (isVisited[nx][ny]) continue;
                    if (ground[nx][ny] == -1 || ground[nx][ny] == 1) continue;
                    queue.add(new int[]{nx, ny});
                    ground[nx][ny] = 1;
                    isVisited[nx][ny] = true;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ground[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }
}
