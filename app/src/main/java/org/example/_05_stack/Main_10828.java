package org.example._05_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main_10828 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        while (N-- > 0) {

            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            String command = stringTokenizer.nextToken();
            if (command.equals("push")) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                stack.push(num);
            }

            if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            }

            if (command.equals("size")) {
                System.out.println(stack.size());
            }

            if (command.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }

            if (command.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
