package org.example._07_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main_5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            String p = br.readLine(); // 연산자 문자열
            int n = Integer.parseInt(br.readLine()); // 배열 길이

            String input = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();

            // 배열 파싱
            input = input.substring(1, input.length() - 1); // [] 제거
            if (!input.isEmpty()) {
                String[] elements = input.split(",");
                for (String el : elements) {
                    deque.add(Integer.parseInt(el));
                }
            }

            boolean reversed = false;
            boolean error = false;

            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    reversed = !reversed;
                } else { // D
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (reversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (error) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                while (!deque.isEmpty()) {
                    sb.append(reversed ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }

                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
