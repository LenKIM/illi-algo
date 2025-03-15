package org.example._03_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_2577 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        char[] total = ((a * b * c) + "").toCharArray();

        int[] result = new int[10];

        for (char value : total) {
            int c1 = Integer.parseInt(String.valueOf(value));
            result[c1]++;
        }

        for (int i : result) {
            System.out.println(i);
        }
    }

    interface Main {
        static void main(String[] s) {
            var v = new java.util.Scanner(System.in);
            int i = 3, r = 1;
            for (; i-- > 0; ) r *= v.nextInt();
            var a = new int[10];
            for (; r > 0; r /= 10) a[r % 10]++;
            for (int z : a) System.out.println(z);
        }
    }
}
