package org.example._09_BFS;

import java.io.*;
import java.util.*;

public class Main_19_2146 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y, dist, islandId;

        Point(int x, int y, int dist, int islandId) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.islandId = islandId;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 섬 번호 마킹
        int islandId = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    markIsland(i, j, islandId++);
                }
            }
        }

        // 2. 가장자리 육지를 큐에 넣고 BFS
        int result = Integer.MAX_VALUE;
        for (int id = 2; id < islandId; id++) {
            result = Math.min(result, bfs(id));
        }

        System.out.println(result);
    }

    // DFS로 섬 번호 붙이기
    static void markIsland(int x, int y, int id) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = id;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (isInRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    map[nx][ny] = id;
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
    }

    // BFS로 다른 섬까지의 최소 거리 찾기
    static int bfs(int islandId) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        // 시작점: 현재 섬의 모든 육지에서 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == islandId) {
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (isInRange(ni, nj) && map[ni][nj] == 0) {
                            q.offer(new Point(i, j, 0, islandId));
                            visited[i][j] = true;
                            break; // 한 방향만 바다여도 가장자리
                        }
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (!isInRange(nx, ny) || visited[nx][ny]) continue;

                // 바다일 경우 다리 연장
                if (map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, p.dist + 1, p.islandId));
                }
                // 다른 섬에 도달했을 경우
                else if (map[nx][ny] != p.islandId) {
                    return p.dist;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}