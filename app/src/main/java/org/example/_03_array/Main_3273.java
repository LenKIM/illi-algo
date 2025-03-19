package org.example._03_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_3273 {

    private static int N;
    private static int[] ints;
    private static int x;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ints = new int[201];

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            ints[value + 100]++;
        }
        x = Integer.parseInt(br.readLine());

        System.out.println(ints[x + 100]);
    }
}
