package org.example._07_deque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Main_1021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 큐의 크기
        int m = sc.nextInt(); // 뽑을 수의 개수

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i); // 초기 큐 설정
        }

        int totalMoves = 0;

        for (int i = 0; i < m; i++) {
            int target = sc.nextInt();

            int idx = 0;
            for (int val : deque) {
                if (val == target) break;
                idx++;
            }

            // 왼쪽으로 회전하는 게 빠를지, 오른쪽이 빠를지 판단
            int leftRotations = idx;
            int rightRotations = deque.size() - idx;

            if (leftRotations <= rightRotations) {
                // 왼쪽으로 이동
                for (int j = 0; j < leftRotations; j++) {
                    deque.addLast(deque.removeFirst());
                }
                totalMoves += leftRotations;
            } else {
                // 오른쪽으로 이동
                for (int j = 0; j < rightRotations; j++) {
                    deque.addFirst(deque.removeLast());
                }
                totalMoves += rightRotations;
            }

            // 맨 앞에 온 원소 제거
            deque.removeFirst();
        }

        System.out.println(totalMoves);
    }
}
