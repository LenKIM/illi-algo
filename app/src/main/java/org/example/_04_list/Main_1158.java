package org.example._04_list;

import java.io.*;
import java.util.StringTokenizer;

class Main_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] pre = new int[5001];
        int[] nxt = new int[5001];
        int len = 0;
        for (int i = 1; i <= N; ++i) {
            pre[i] = (i == 1) ? N : i - 1;
            nxt[i] = (i == N) ? 1 : i + 1;
            ++len;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("<");
        int i = 1;
        for (int cur = 1; len != 0; cur = nxt[cur]) {
            // K번째 일때 제거
            if (i == K) {

                int curNxtValue = nxt[cur];
                pre[curNxtValue] = pre[cur];

                int curPreValue = pre[cur];
                nxt[curPreValue] = nxt[cur];

                if (len == 1) {
                    builder.append(cur);
                } else {
                    builder.append(cur).append(", ");
                }
                i = 1;
                --len;
            } else ++i;
        }
        builder.append(">");

        bw.write(builder.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
