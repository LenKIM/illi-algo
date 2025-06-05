package org.example._10_recursive;

import java.util.Scanner;

class Main_04_17478 {

    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursive(0);
        System.out.println(sb);
    }

    static void recursive(int depth) {
        String indent = "____".repeat(depth);

        sb.append(indent).append("\"재귀함수가 뭔가요?\"\n");

        if (depth == N) {
            sb.append(indent).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        } else {
            sb.append(indent).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에...\n");
            sb.append(indent).append("마을 사람들은 모두 그 선생님에게 질문을 했고...\n");
            sb.append(indent).append("그 선생님은 모두에게 이렇게 답변하였지.\"\n");

            recursive(depth + 1);
        }

        sb.append(indent).append("라고 답변하였지.\n");
    }
}
