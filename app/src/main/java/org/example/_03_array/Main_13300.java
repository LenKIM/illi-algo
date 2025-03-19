package org.example._03_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_13300 {
    private static int K;
    private static int N;
    private static int[] ints;
    private static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[7][2];


        // 성별과 학년
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int isWoman = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            arr[grade][isWoman] = arr[grade][isWoman] + 1;
        }

        int result = 0;
        for (int[] value : arr) {
            for (int personCount : value) {
                // K 가 최대인원
                if (personCount <= 0) {
                    continue;
                }
                int room = personCount / K;
                int rest = personCount % K;

                result = result + room;
                if (rest > 0) {
                    result = result + 1;
                }
            }
        }
        System.out.println(result);

    }
}
