package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_16_2206 {
    private static int N;
    private static int M;

    private static char[][] map;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, 0, 1, false));
        int[] ni = {0, 0, -1, 1};
        int[] nj = {-1, 1, 0, 0};
        boolean[][][] visited = new boolean[N][M][2];

        while (!q.isEmpty()) {
            Loc cur = q.poll();

            if (cur.i == N - 1 && cur.j == M - 1) {
                System.out.println(cur.count);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nni = cur.i + ni[d];
                int nnj = cur.j + nj[d];

                if (nni < 0 || nni >= N || nnj < 0 || nnj >= M) continue;

                int nextCount = cur.count + 1;
                if (map[nni][nnj] == '0') { // 벽이 아니면
                    if (!cur.destroyed && !visited[nni][nnj][0]) { // 부순 벽이 여태까지 없었다면
                        q.add(new Loc(nni, nnj, nextCount, false));
                        visited[nni][nnj][0] = true;
                    } else if (cur.destroyed && !visited[nni][nnj][1]) { // 벽을 이미 한번 부셨더라면
                        q.add(new Loc(nni, nnj, nextCount, true));
                        visited[nni][nnj][1] = true;
                    }

                } else if (map[nni][nnj] == '1') { // 벽이면?

                    if (!cur.destroyed) {
                        q.add(new Loc(nni, nnj, nextCount, true));
                        visited[nni][nnj][1] = true;
                    }
                }
            }
        }
        System.out.println("-1");
    }

    private static class Loc {
        private final int i;
        private final int j;
        private final int count;
        private final boolean destroyed;

        public Loc(int i, int j, int count, boolean destroyed) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.destroyed = destroyed;
        }
    }
}
