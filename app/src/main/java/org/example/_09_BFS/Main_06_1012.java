package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_06_1012 {
    static int T;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            Queue<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            int count = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {

                    if (map[i][j] == 1 && !visited[i][j]) {

                        q.add(new int[]{i, j});
                        count++;
                    }

                    while (!q.isEmpty()) {
                        int[] current = q.poll();
                        int x = current[0];
                        int y = current[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                            if (visited[nx][ny]) continue;
                            if (map[nx][ny] == 0) continue;
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            System.out.println(count);
        }

    }
}
