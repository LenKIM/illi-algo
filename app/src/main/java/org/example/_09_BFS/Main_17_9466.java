package org.example._09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * * 텀 프로젝트
 * 1,2,3,4,5,6,7
 * 3,1,3,7,3,4,6*
 * <p>
 * 이렇게 있으면, 3과 4,7,6 팀을 이룬다
 * 방문 여부 배열과, 팀 완성 여부 배열 나눠서 계산해야 한다.*
 * 1. 혼자 팀을 하고 싶어하는 사람을 선택한 사람은 팀을 이룰 수 없다*
 * 2. 팀을 이루기 위해서는 서로를 선택해야만 한다.*
 * 출력은 팀에 속하지 못한 학생들의 수를 표현하기*
 * * * *
 */
class Main_17_9466 {

    private static int[] arr;
    private static boolean[] visit, done; // 방문, 팀 편성 완료 배열
    private static int count; // 팀 완성 인원 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visit = new boolean[n + 1];
            done = new boolean[n + 1];
            count = 0;

            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (!done[i]){
                    dfs(i);

                }
            }
        }
    }

    private static void dfs(int n) {
        if (visit[n]) {
            done[n] = true;
            count++;
        } else {
            visit[n] = true;
        }

        if (!done[arr[n]]) {
            dfs(arr[n]);
        }
        visit[n] = false;
        done[n] = true;
    }

}
