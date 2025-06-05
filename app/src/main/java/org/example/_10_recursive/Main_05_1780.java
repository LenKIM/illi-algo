package org.example._10_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_05_1780 {
    private static int __1 = 0;
    private static int _0 = 0;
    private static int _1 = 0;
    private static int[][] board;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(__1);
        System.out.println(_0);
        System.out.println(_1);


    }

    private static void partition(int row, int col, int size) {
        if (checkSize(row, col, size)) {
            if (board[row][col] == 0) {
                _0++;
            } else if (board[row][col] == -1) {
                __1++;
            } else if (board[row][col] == 1) {
                _1++;
            }
            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + (newSize * 2), newSize);

        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + (newSize * 2), newSize);

        partition(row + (newSize * 2), col, newSize);
        partition(row + (newSize * 2), col + newSize, newSize);
        partition(row + (newSize * 2), col + (newSize * 2), newSize);
    }

    private static boolean checkSize(int row, int col, int size) {
        int color = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
