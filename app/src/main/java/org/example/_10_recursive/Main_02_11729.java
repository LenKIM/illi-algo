package org.example._10_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_02_11729 {

    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 3, 2);  // from=1, to=3, via=2

        System.out.println(count);
        System.out.println(sb);
    }

    public static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            count++;
            return;
        }

        // 1단계: n-1개를 보조 기둥으로 이동
        hanoi(n - 1, from, via, to);

        // 2단계: 가장 큰 원판을 목적지로 이동
        sb.append(from).append(" ").append(to).append("\n");
        count++;

        // 3단계: 보조 기둥의 n-1개를 목적지로 이동
        hanoi(n - 1, via, to, from);
    }
}
