package org.example._08_braces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/2504
 */
class Main_2504 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean flag = true;
        int count = 1;
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                count *= 2;
            } else if (c == '[') {
                stack.push(c);
                count *= 3;
            } else {
                if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }

                    if (s.charAt(i - 1) == '(') {
                        // 쌍이 맞음
                        answer += count;
                    }
                    stack.pop();
                    count /= 2;

                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    }

                    if (s.charAt(i - 1) == '[') {
                        answer += count;
                    }
                    stack.pop();
                    count /= 3;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if (!flag || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
