package org.example._08_braces;

import java.io.*;
import java.util.Stack;

class Main_10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        Stack<Character> st = new Stack<>();
        char[] chars = br.readLine().toCharArray();
        int count = 0;
        int length = chars.length;
        for (int i = 0; i < length; i++) {

            char aChar = chars[i];
            if (aChar == '(') {
                st.push(aChar);
            } else if (aChar == ')' && chars[i - 1] == '(') {
                st.pop();
                count += st.size();
            } else if (aChar == ')' && st.peek() == '(') {
                st.pop();
                count += 1;
            }
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
