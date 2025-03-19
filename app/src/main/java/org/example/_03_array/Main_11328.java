package org.example._03_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_11328 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();
            isStrfry(first, second);
        }
    }

    private static void isStrfry(String first, String second) {
        int[] arr = new int[27];
        char[] charArray = first.toCharArray();
        for (char value : charArray) {
            int i1 = value - 'a';
            arr[i1]++;
        }

        char[] charArray1 = second.toCharArray();
        for (char c : charArray1) {
            int i1 = c - 'a';
            arr[i1]--;
        }
        Arrays.stream(arr).filter(i -> i != 0)
                .findFirst()
                .ifPresentOrElse(
                        i -> {
                            System.out.println("Impossible");;
                        }, () -> System.out.println("Possible"));
    }
}
