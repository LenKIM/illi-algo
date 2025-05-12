package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main_06_10026 {
    private static int N;
    private static int[][] map = new int[101][101];
    private static int[][] greenRedMap = new int[101][101];
    private static boolean[][] isVisited = new boolean[101][101];

    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, 1, -1};
    private static final int RED = 'R' - 'A';
    private static final int BLUE = 'B' - 'A';
    private static final int GREEN = 'G' - 'A';


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                int i1 = charArray[j] - 'A';
                map[i][j] = i1;
            }
        }
        int totalCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (!isVisited[i][j]) {
                    queue.add(new int[]{i, j});
                    totalCount++;
                    bfs(queue);
                }


            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == RED) {
                    map[i][j] = GREEN;
                }
            }
        }
        isVisited = new boolean[101][101];
        int abnormal_count = 0;
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    queue.add(new int[]{i, j});
                    abnormal_count++;
                    bfs(queue);
                }
            }
        }
        System.out.println(totalCount + " " + abnormal_count);


    }

    private static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cx = poll[0];
            int cy = poll[1];
            int currentChar = map[cx][cy];
            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (currentChar != map[nx][ny]) continue;
                if (isVisited[nx][ny]) continue;
                isVisited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }

        }
    }
}
