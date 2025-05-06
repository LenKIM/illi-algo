package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_02_2178 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] isVisited;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        int n, m = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String xx = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = xx.charAt(j) - '0';
            }
        }
        isVisited = new boolean[n][m];
        isVisited[0][0] = true;
        bfs(0, 0, n, m);
        System.out.println(arr[n - 1][m - 1]);
    }

    private static void bfs(int x, int y, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int nowX = cur[0];
            int nowY = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = nowX + dx[k];
                int ny = nowY + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (isVisited[nx][ny] || arr[nx][ny] == 0) continue;
                queue.add(new int[]{nx, ny});
                arr[nx][ny] = arr[nowX][nowY] + 1;
                isVisited[nx][ny] = true;
            }
        }
    }
}
