package org.example._12_sort;

import java.io.*;
import java.util.Arrays;

class Main_02_2751 {

    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빠른 출력을 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 입력값 배열에 저장
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // Arrays.sort는 Dual-Pivot Quicksort(primitive type)로 매우 빠름
        Arrays.sort(arr);

        // 정렬된 결과 출력
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }

        // 자원 해제
        bw.flush();
        bw.close();
        br.close();
    }

}
