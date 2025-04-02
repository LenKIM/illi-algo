package org.example._05_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");

        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= s.length; i++) {
            int height = Integer.parseInt(s[i - 1]);

            while (!stack.isEmpty() && stack.peek().left < height) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                sb.append(stack.peek().right).append(" ");
            } else {
                sb.append(0 + " ");
            }

            stack.push(new Pair<>(height, i));
        }
        System.out.println(sb);
    }

    private static class Pair<L, R> {

        L left;
        R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }
    }
}
