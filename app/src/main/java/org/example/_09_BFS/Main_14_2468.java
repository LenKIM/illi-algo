package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14_2468 {

    private static int N;
    private static StringTokenizer st;
    private static int[][] map;
    private static int max, min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[101][101];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] > max) {
                    max = map[i][j];
                }

                if (map[i][j] < min) {
                    min = map[i][j];
                }
            }
        }

        int total = 0;
        for (int height = min; height <= max; height++) {

            int a = bfs(height);

            if (total < a) {
                total = a;
            }
        }
        System.out.println(total);

    }

    private static int[] dRow = {-1, 1, 0, 0};
    private static int[] dCol = {0, 0, 1, -1};

    private static int bfs(int height) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[N + 1][N + 1];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (map[i][j] >= height) {
                    queue.add(new Point(i, j));
                    if (isVisited[i][j]) continue;

                    isVisited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point cur = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nX = cur.x + dRow[k];
                            int nY = cur.y + dCol[k];

                            if (nX < 0 || nY < 0 || nX >= N || nY >= N) continue;
                            if (isVisited[nX][nY]) continue;
                            if (map[nX][nY] <= height - 1) continue;

                            isVisited[nX][nY] = true;
                            queue.add(new Point(nX, nY));
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}