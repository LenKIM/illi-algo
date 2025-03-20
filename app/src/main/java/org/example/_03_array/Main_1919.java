package org.example._03_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_1919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        // 동일한 것을 찾고. 나머지에서 빼기
        int[] arr = new int[27];

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            arr[c - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            arr[c - 'a']--;
        }

        int result = 0;
        for (int i1 : arr) {
            result += Math.abs(i1);
        }

        System.out.println(result);
    }
}
