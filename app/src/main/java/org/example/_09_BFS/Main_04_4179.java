package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_04_4179 {
    private static int N, M;
    private static char[][] ground;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static Queue<int[]> queue;
    private static Queue<int[]> fireQueue;
    private static boolean[][] isVisited;
    private static boolean[][] isFireVisited;

    private final static char WALL = '#';
    private final static char PASS = '.';
    private final static char FIRE = 'F';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ground = new char[N][M];
        isVisited = new boolean[N][M];
        isFireVisited = new boolean[N][M];

        queue = new LinkedList<>();
        fireQueue = new LinkedList<>();

        int count;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                ground[i][j] = line.charAt(j);

                if (ground[i][j] == 'J') {
                    queue.add(new int[]{i, j});
                    isVisited[i][j] = true;
                }

                if (ground[i][j] == FIRE) {
                    fireQueue.add(new int[]{i, j});
                    isFireVisited[i][j] = true;
                }
            }
        }
        count = -1;
        while (!queue.isEmpty()) {
            count++;
            if (!fireQueue.isEmpty()) {
                int fireSize = fireQueue.size();
                for (int i = 0; i < fireSize; i++) {
                    int[] poll = fireQueue.poll();
                    for (int j = 0; j < 4; j++) {
                        int nextFireX = poll[0] + dx[j];
                        int nextFireY = poll[1] + dy[j];

                        if (nextFireY < 0 || nextFireX < 0 || nextFireX >= N || nextFireY >= M) continue;
                        if (isFireVisited[nextFireX][nextFireY]) continue;
                        if (ground[nextFireX][nextFireY] == WALL) continue;

                        isFireVisited[nextFireX][nextFireY] = true;
                        ground[nextFireX][nextFireY] = FIRE;
                        fireQueue.add(new int[]{nextFireX, nextFireY});
                    }
                }
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int currentX = poll[0];
                int currentY = poll[1];

                if (currentX == 0 || currentX == N - 1 || currentY == 0 || currentY == M - 1) {
                    System.out.println(count + 1);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int nextX = currentX + dx[j];
                    int nextY = currentY + dy[j];

                    if (nextY < 0 || nextX < 0 || nextX >= N || nextY >= M) continue;
                    if (ground[nextX][nextY] == FIRE || ground[nextX][nextY] == WALL) continue;
                    if (isVisited[nextX][nextY]) continue;

                    if (ground[nextX][nextY] == PASS) {
                        queue.add(new int[]{nextX, nextY});
                        isVisited[nextX][nextY] = true;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
