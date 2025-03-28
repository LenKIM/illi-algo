package org.example._05_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());


        Stack<Integer> stack = new Stack<>();
        while (N-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int i = Integer.parseInt(tokenizer.nextToken());
            if (i == 0) {
                stack.pop();
                continue;
            }

            stack.push(i);
        }

        System.out.println(stack.stream().mapToInt(c -> c).sum());

    }
}
