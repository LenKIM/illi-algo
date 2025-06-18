package org.example._11_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 정수로 이루어진 수열이 있을 때,
 * 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 */
class Main_03_1182 {


    private static int S;
    private static int N;
    private static int [] arr = new int[30];
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        func(0, 0);
        if (S == 0) cnt--;
        System.out.println(cnt);
    }

    private static void func(int cur, int tot) {
        if (cur == N) {
            if (tot == S) cnt++;
            return;
        }
        func(cur+1, tot);
        func(cur+1, tot+arr[cur]);
    }
}
