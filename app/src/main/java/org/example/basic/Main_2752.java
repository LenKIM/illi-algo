package org.example.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Main_2752 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String collect = Arrays.stream(Arrays.stream(br.readLine().split(" ")).toArray())
                .sorted()
                .map(c -> (String) (c))
                .collect(Collectors.joining(" "));
        System.out.println(collect);


    }
}
