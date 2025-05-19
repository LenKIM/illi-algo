package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main_11_2583 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        boolean[][] isVisited = new boolean[M][N];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    map[i][j] = 1;
                    isVisited[i][j] = true;
                }
            }
        }


        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Deque<int[]> deque = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (isVisited[i][j]) continue;
                if (map[i][j] == 1) continue;

                deque.add(new int[]{i, j});
                int count = 1;
                while (!deque.isEmpty()) {
                    int[] currentPoint = deque.poll();
                    int cx = currentPoint[0];
                    int cy = currentPoint[1];

                    for (int k = 0; k < 4; k++) {
                        int nx = cx + dx[k];
                        int ny = cy + dy[k];

                        if (nx >= M|| nx < 0) continue;
                        if (ny >= N|| ny < 0) continue;
                        if (isVisited[ny][nx]) continue;
                        if (map[ny][nx] == 1) continue;

                        count++;
                        deque.add(new int[]{nx, ny});
                        isVisited[nx][ny] = true;
                    }

                }
                builder.append(count).append(" ");
            }


        }
        System.out.println(builder);;
    }
}