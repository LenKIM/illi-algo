package org.example._11_backtracking;

import java.util.Scanner;

/**
 * 백트레킹으로 어떻게 해결할 수 있지?
 * 위에서부터 하나씩 놓아보면서 상태공간트리를 만든다.
 * <p>
 * 특정 좌표에 어떻게 퀀을 놓을 수 있을까?
 */
class Main_02_9663 {

    static int N;
    static int count = 0;
    static int[] col; // col[i] = i번째 행에 놓인 퀸의 열 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N];
        solve(0);
        System.out.println(count);
    }

    // row번째 행에 퀸을 놓는 함수
    static void solve(int row) {
        if (row == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            col[row] = i;
            if (isPossible(row)) {
                solve(row + 1);
            }
        }
    }

    // row번째 행에 퀸을 놓을 수 있는지 검사
    static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열이거나, 같은 대각선에 있으면 false
            if (col[row] == col[i]
                || Math.abs(row - i) == Math.abs(col[row] - col[i])) {
                return false;
            }
        }
        return true;
    }
}
