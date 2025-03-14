package org.example._03_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

class Main_10808 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char a = 'a';
        char z = 'z';
        int count = z - a;
        int[] arr = new int[count + 1];

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            int i1 = c - 'a';
            arr[i1] = arr[i1] + 1;
        }

        String collect = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}
