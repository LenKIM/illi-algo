package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

class Main_20_13549 {
    static final int MAX = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] distance = new int[MAX];
        Arrays.fill(distance, -1);

        Deque<Integer> deque = new ArrayDeque<>();
        distance[start] = 0;
        deque.add(start);

        while (!deque.isEmpty()) {
            int curr = deque.poll();

            if (curr == target) {
                System.out.println(distance[curr]);
                return;
            }

            // 순간이동 (0초)
            if (2 * curr < MAX && distance[2 * curr] == -1) {
                distance[2 * curr] = distance[curr];
                deque.addFirst(2 * curr); // 앞에 넣는다
            }

            // -1 이동 (1초)
            if (curr - 1 >= 0 && distance[curr - 1] == -1) {
                distance[curr - 1] = distance[curr] + 1;
                deque.addLast(curr - 1);
            }

            // +1 이동 (1초)
            if (curr + 1 < MAX && distance[curr + 1] == -1) {
                distance[curr + 1] = distance[curr] + 1;
                deque.addLast(curr + 1);
            }
        }
    }
}
