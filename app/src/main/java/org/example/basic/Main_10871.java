/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        String[] s1 = s.split(" ");

        String collect = Arrays.stream(s1)
                .filter(a -> Integer.parseInt(a) < X)
                .collect(Collectors.joining(" "));

        System.out.println(collect);


    }
}
