package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 3차원에서 토마토가 모두다 익는 시간 계산
 */
class Main_08_7569 {

    private static int MM;
    private static int NN;
    private static int H;
    private static int[] dx = {1, -1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        MM = Integer.parseInt(st.nextToken());
        NN = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        boolean[][][] isVisited = new boolean[H][NN][MM];

        int[][][] map = new int[H][NN][MM];
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < NN; j++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                for (int k = 0; k < MM; k++) {

                    map[i][j][k] = Integer.parseInt(token.nextToken());
                    if (map[i][j][k] == 1) {
                        deque.add(new int[]{i, j, k});
                        isVisited[i][j][k] = true;
                    }

                }
            }
        }
        boolean isAll = false;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < NN; j++) {
                for (int k = 0; k < MM; k++) {
                    if (map[i][j][k] == 0) {
                        isAll = true;
                        break;
                    }
                }
            }
        }

        if (!isAll) {
            System.out.println("0");
            return;
        }

        int count = -1;
        while (!deque.isEmpty()) {

            int size = deque.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] poll = deque.poll();
                int cz = poll[0];
                int cy = poll[1];
                int cx = poll[2];
                for (int j = 0; j < 6; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];
                    int nz = cz + dz[j];

                    if (nx >= MM || nx < 0) continue;
                    if (ny >= NN || ny < 0) continue;
                    if (nz >= H || nz < 0) continue;
                    if (isVisited[nz][ny][nx]) continue;
                    if (map[nz][ny][nx] == -1) continue;
                    if (map[nz][ny][nx] == 1) continue;

                    isVisited[nz][ny][nx] = true;
                    map[nz][ny][nx] = 1;
                    deque.add(new int[]{nz, ny, nx});
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < NN; j++) {
                for (int k = 0; k < MM; k++) {
                    if (map[i][j][k] == 0) {
                        count = -1;
                    }

                }
            }
        }
        System.out.println(count);
    }
}
