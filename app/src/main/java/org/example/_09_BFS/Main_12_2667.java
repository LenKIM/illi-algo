package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main_12_2667 {
    static int[][] map = new int[26][26];
    static boolean[][] isVisited = new boolean[26][26];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }


        List<Integer> counts = new ArrayList<>();
        for (int col = 0; col < T; col++) {
            for (int row = 0; row < T; row++) {
                int num = map[col][row];
                if (num == 0) continue;
                if (!isVisited[col][row] && map[col][row] == 1) {
                    counts.add(bfs(col, row));
                }
            }
        }
        Collections.sort(counts);
        System.out.println(counts.size());
        for (int count : counts) {
            System.out.println(count);
        }
    }

    private static Integer bfs(int col, int row) {
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{col, row});
        isVisited[col][row] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = poll[0] + dx[i];
                int nCol = poll[1] + dy[i];

                if (nRow >= 0 && nCol >= 0 && nRow < T && nCol < T) {
                    if (!isVisited[nRow][nCol] && map[nRow][nCol] == 1) {
                        isVisited[nRow][nCol] = true;
                        q.add(new int[]{nRow, nCol});
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
