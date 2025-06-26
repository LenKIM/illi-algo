package org.example._12_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_01_2750 {
    private static int N;
    private static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = new int[N];
        int i = 0;
        while (N-- > 0) {
            input[i] = Integer.parseInt(br.readLine());
            i++;
        }

        for (int j = 0; j < input.length; j++) {
            for (int k = 0; k < input.length-j-1; k++) {
                if (input[k] > input[k + 1]) {
                    swap(k, k+1);
                }
            }
        }

        for (int k : input) {
            System.out.println(k);
        }
    }

    private static void swap(int j, int i) {
        int i1 = input[j];
        input[j] = input[i];
        input[i] = i1;
    }
}
