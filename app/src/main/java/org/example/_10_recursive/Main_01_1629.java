package org.example._10_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1629
//자연수 A를 B번 곱한 수를 알고 싶다.
// 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
// 거듭 제곱 분할
// a^b 를 쪼개는데, 짝수 일때, a^b = (a^b/2)^2
class Main_01_1629 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long result = pow(a, b, c);
        System.out.println(result);
    }

    /**
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    private static long pow(long a, long b, long c) {
        if (b == 1) return a % c;
        long val = pow(a, b / 2, c);
        val = val * val % c;
        if (b % 2 == 0) return val;
        return val * a % c;
    }
}
