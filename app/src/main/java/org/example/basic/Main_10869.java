package org.example.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_10869 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        String result = A + B + "\n" +
                        (A - B) + "\n" +
                        (A * B) + "\n" +
                        (A / B) + "\n" +
                        (A % B) + "\n";
        System.out.println(result);
    }
}
