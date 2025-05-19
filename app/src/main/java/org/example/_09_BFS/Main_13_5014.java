package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main_13_5014 {
    private static int F;
    private static int S;
    private static int G;
    private static int U;
    private static int D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 총 F층 으로 이루어짐.
        // 스타트링크가 있는 층은 G층
        // 강호가 있는 층은 S층
        // 강호가 탄 엘베는 버튼 2개
        // U 버튼 / D 버튼
        // 첫줄 F S G U D. (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000)
        // 최솟값

        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[1000001];
        int[] distance = new int[1000001];
        boolean exit = false;

        Deque<Integer> deque = new LinkedList<>();
        distance[S] = 0;
        deque.add(S);
        visited[S] = true;


        while (!deque.isEmpty()) {
            Integer poll = deque.poll();

            if (poll == G) {
                exit = true;
                break;
            }

            if (poll + U >= 1 && poll + U <= F && !visited[poll + U]) {
                int nextTemp = poll + U;
                distance[nextTemp] = distance[poll] + 1;
                visited[nextTemp] = true;
                deque.offer(nextTemp);
            }

            if (poll - D >= 1 && poll - D <= F && !visited[poll - D]) {
                int nextTemp = poll - D;
                distance[nextTemp] = distance[poll] + 1;
                visited[nextTemp] = true;
                deque.offer(nextTemp);
            }
        }

        if (exit) {
            System.out.println(distance[G]);
        } else {
            System.out.println("use the stairs");
        }
    }
}
