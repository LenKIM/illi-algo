package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/6593
 */
class Main_15_6593 {
    private static int L, R, C; // 1 ~ 30 사이
    private static final char GOLD = '#';
    private static final char EMPTY = '.';
    private static final char START = 'S';
    private static final char EXIT = 'E';


    private static char[][][] map;
    private static boolean[][][] isVisited;
    private static int[] dx = {1, -1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            isVisited = new boolean[L][R][C];

            Deque<int[]> deque = new LinkedList<>();
            for (int h = 0; h < L; h++) {
                for (int col = 0; col < R; col++) {
                    String s = br.readLine();
                    for (int row = 0; row < C; row++) {
                        char c = s.charAt(row);
                        if (START == c) {
                            deque.add(new int[]{h, col, row});
                            isVisited[h][col][row] = true;
                        }
                        map[h][col][row] = c;
                    }
                }
                br.readLine();
            }
            int count = 0;
            boolean isOut = false;
            while (!deque.isEmpty()) {

                int size = deque.size();
                count++;

                for (int i = 0; i < size; i++) {
                    int[] poll = deque.poll();
                    int cH = poll[0];
                    int cCol = poll[1];
                    int cRow = poll[2];
                    if (map[cH][cCol][cRow] == EXIT) {
                        isOut = true;
                        count--;
                        break;
                    }
                    for (int j = 0; j < dx.length; j++) {
                        int nextRow = cRow + dx[j];
                        int nextCol = cCol + dy[j];
                        int nextH = cH + dz[j];

                        if (nextH >= 0 && nextH < L
                            && nextCol >= 0 && nextCol < R
                            && nextRow >= 0 && nextRow < C
                            && !isVisited[nextH][nextCol][nextRow]
                            && (map[nextH][nextCol][nextRow] == EMPTY || map[nextH][nextCol][nextRow] == EXIT)) {

                            isVisited[nextH][nextCol][nextRow] = true;
                            deque.add(new int[]{nextH, nextCol, nextRow});
                        }

                    }


                }

                if (isOut) break;

            }
            if (isOut) {
                System.out.println("Escaped in " + count + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
    }
}
