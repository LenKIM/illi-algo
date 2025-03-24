package org.example._04_list;

public class ArrayLinkedList {
    static final int MX = 1000005;
    static int[] dat = new int[MX];
    static int[] pre = new int[MX];
    static int[] nxt = new int[MX];
    static int unused = 1;

    public static void main(String[] args) {
        // pre, nxt 배열을 -1로 초기화
        for (int i = 0; i < MX; i++) {
            pre[i] = -1;
            nxt[i] = -1;
        }

        // 여기서 insert, erase 등의 메서드를 추가로 정의하여 사용하면 됩니다.
    }
}