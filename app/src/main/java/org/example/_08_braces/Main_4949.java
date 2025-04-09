package org.example._08_braces;

import java.io.*;
import java.util.Stack;

class Main_4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;


            String s = line.replaceAll("[a-zA-Z]", "");
            String ans = s.replaceAll("[ ]", "");

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < ans.length(); i++) {

                if (ans.charAt(i) == '(' || ans.charAt(i) == '[') {
                    stack.add(ans.charAt(i));
                } else if (ans.charAt(i) == ')') {
                    if (stack.isEmpty()) {sb.append("no\n"); break;}

                    Character peek = stack.peek();
                    if (peek.equals('(')) {
                        stack.pop();
                    } else {
                        sb.append("no\n");
                        break;
                    }
                } else if (ans.charAt(i) == ']') {
                    if (stack.isEmpty()) {sb.append("no\n"); break;}

                    Character peek = stack.peek();
                    if (peek.equals('[')) {
                        stack.pop();
                    } else {
                        sb.append("no\n");
                        break;
                    }
                } else if (ans.charAt(i) == '.') {

                    if (stack.isEmpty()) {
                        sb.append("yes\n");
                    } else {
                        sb.append("no\n");
                    }
                    break;
                }

            }
        }
        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
