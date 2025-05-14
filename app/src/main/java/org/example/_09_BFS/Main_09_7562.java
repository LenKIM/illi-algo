package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 나이트의 이동경로
 */
class Main_09_7562 {

    static int T;
    static int I; // 한 변 길이

    static int[] dRow = {2, 2, 1, 1, -2, -2, -1, -1};
    static int[] dCol = {1, -1, 2, -2, 1, -1, 2, -2};

    static Point current;
    static Point destimation;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            isVisited = new boolean[I][I];
            distance = new int[I][I];

            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            current = new Point(row, col);

            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            destimation = new Point(row, col);

            Queue<Point> q = new LinkedList<>();
            q.add(current);
            isVisited[current.row][current.col] = true;
            distance[current.row][current.col] = 0;
            while (!q.isEmpty()) {

                Point cur = q.poll();

                for (int i = 0; i < dCol.length; i++) {
                    int nextRow = cur.row + dRow[i];
                    int nextCol = cur.col + dCol[i];

                    if(nextRow >= I || nextRow < 0 || nextCol >= I || nextCol < 0) continue;
                    if(isVisited[nextRow][nextCol]) continue;

                    isVisited[nextRow][nextCol] = true;
                    distance[nextRow][nextCol] = distance[cur.row][cur.col] + 1;
                    q.add(new Point(nextRow, nextCol));
                }
            }
            System.out.println(distance[destimation.row][destimation.col]);
        }
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
