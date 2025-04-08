package org.example._06_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

class Main_10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String s = br.readLine();
            if (s.startsWith("push")) {
                String[] input = s.split(" ");
                int x = Integer.parseInt(input[1]);
                deque.addFirst(x);
            } else if (s.startsWith("pop")) {

                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    Integer integer = deque.pollLast();
                    sb.append(integer).append("\n");
                }

            } else if (s.startsWith("size")) {
                sb.append(deque.size()).append("\n");
            } else if (s.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (s.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque.peekLast()).append("\n");
                }
            } else if (s.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque.peekFirst()).append("\n");
                }
            }
        }
        System.out.println(sb);

    }
}
