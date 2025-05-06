package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_05_1697 {
    private static int N;
    private static int K;
    private static boolean[] isVisited = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        isVisited[N] = true;
        int count = -1;
        int[] jumps = {-1, 1};
        while (!queue.isEmpty()) {

            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == K) {
                    System.out.println(count);
                    return;
                }

                for (int jump : jumps) {
                    int nextJumpPoint = current + jump;
                    if (nextJumpPoint < 0 || nextJumpPoint > 100000) continue;
                    if (isVisited[nextJumpPoint]) continue;
                    isVisited[nextJumpPoint] = true;
                    queue.add(nextJumpPoint);
                }

                int e = current * 2;
                if (e >= 0 && e <= 100000 && !isVisited[e]) {
                    isVisited[e] = true;
                    queue.add(e);
                }
            }
        }
    }
}
