package org.example._03_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main_1475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] arr = new int[10];

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            int target = c - '0';

            if (target == 6 || target == 9) {
                if (arr[6] > arr[9]) {
                    arr[9] = arr[9] + 1;
                } else {
                    arr[6] = arr[6] + 1;
                }
            } else {
                int count = arr[target];
                arr[target] = count + 1;
            }
        }

        int asInt = Arrays.stream(arr).max().getAsInt();
        System.out.println(asInt);
    }
}
