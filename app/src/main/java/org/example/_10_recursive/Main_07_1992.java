package org.example._10_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_07_1992 {

    private static int[][] board;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String st = br.readLine();

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
            }
        }

        quadTree(0, 0, N);
        System.out.println(sb);

    }

    private static void quadTree(int x, int y, int size) {
        if (isPossible(x, y, size)) {

            sb.append(board[x][y]);
            return;
        }

        int newSize = size / 2;

        sb.append("(");
        quadTree(x, y, newSize);
        quadTree(x, y + newSize, newSize);
        quadTree(x + newSize, y, newSize);
        quadTree(x + newSize, y + newSize, newSize);
        sb.append(")");
    }

    private static boolean isPossible(int x, int y, int size) {
        int val = board[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (val != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
