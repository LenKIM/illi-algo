package org.example._07_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

class Main_10866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {

            String command = br.readLine();

            if (command.startsWith("push_back")) {
                String[] s = command.split(" ");
                int v = Integer.parseInt(s[1]);
                deque.addLast(v);
            } else if (command.startsWith("push_front")) {
                String[] s = command.split(" ");
                int v = Integer.parseInt(s[1]);
                deque.addFirst(v);
            } else if (command.startsWith("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    Integer integer = deque.pollFirst();
                    sb.append(integer).append("\n");
                }

            } else if (command.startsWith("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    Integer integer = deque.pollLast();
                    sb.append(integer).append("\n");
                }
            } else if (command.startsWith("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.startsWith("empty")) {
                if (deque.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command.startsWith("front")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque.peekFirst()).append("\n");
                }
            } else if (command.startsWith("back")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);

    }
}
