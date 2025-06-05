package org.example._10_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_03_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = getZOrder(N, r, c);
        System.out.println(result);
    }

    static int getZOrder(int n, int r, int c) {
        if (n == 0) return 0;

        int half = 1 << (n - 1); // 2^(n-1)
//      (int)Math.pow(2, n - 1);
        int area = half * half;

        if (r < half && c < half) {
            // 1사분면
            return getZOrder(n - 1, r, c);
        } else if (r < half && c >= half) {
            // 2사분면
            return area + getZOrder(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            // 3사분면
            return 2 * area + getZOrder(n - 1, r - half, c);
        } else {
            // 4사분면
            return 3 * area + getZOrder(n - 1, r - half, c - half);
        }
    }
}