package org.example.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_9498 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String result = "";
        if (N >= 90) {
            result = "A";
        } else if (N >= 80) {
            result = "B";
        } else if (N >= 70) {
            result = "C";
        } else if (N >= 60) {
            result = "D";
        } else {
            result = "F";
        }
        System.out.println(result);

    }
}
