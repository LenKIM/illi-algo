package org.example.basic;

class Test_01 {

    int solution(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;

//        if (X == Y) {
//            for (int j = 0; j < N; j++) {
//                if (A[j] == X) {
//                    nX++;
//                    if (nX % 2 == 0) result = j;
//                }
//            }
//            return result;
//        }

        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            if (A[i] == Y)
                nY += 1;
            if (nX == nY && nX > 0) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int solution = new Test_01()
                .solution(7, 7, new int[]{7,7,7});
        System.out.println(solution);
    }
}
