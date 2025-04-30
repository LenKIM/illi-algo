package org.example._08_braces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/2504
 */
class Main_2504_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
                valueStack.push(0);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    break;
                }
                stack.pop();
                int currentCount = valueStack.pop();
                int newValue = currentCount == 0 ? 2 : currentCount * 2;
                calculateCurrentValue(valueStack, newValue);
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    break;
                }
                stack.pop();
                int currentCount = valueStack.pop();
                int newValue = currentCount == 0 ? 3 : currentCount * 3;
                calculateCurrentValue(valueStack, newValue);
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(valueStack.stream().mapToInt(i -> i).sum());
        }
    }

    private static void calculateCurrentValue(Stack<Integer> valueStack, int newValue) {
        if (!valueStack.isEmpty()) {
            Integer pop = valueStack.pop();
            valueStack.push(pop + newValue);
        } else {
            valueStack.push(newValue);
        }
    }
}
