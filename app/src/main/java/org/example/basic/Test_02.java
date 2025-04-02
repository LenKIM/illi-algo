package org.example.basic;

import java.util.HashSet;

class Test_02 {

    public int solution(String S) {
        HashSet<String> objects = new HashSet<>();
        char[] charArray = S.toCharArray();
        int sum = 0;

        for (char c : charArray) {
            sum = sum + getAnInt(c);
        }


        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int originNumber = getAnInt(c);
            for (int j = 0; j <= 9; j++) {
                if (originNumber == j) {
                    continue;
                }

                int targetSum = sum - originNumber + j;
                if (targetSum % 3 == 0) {
                    charArray[i] = (char) (j + '0');
                    objects.add(String.valueOf(charArray));
                    charArray[i] = c;
                }
            }

            if (sum % 3 == 0) {
                objects.add(S);
            }
        }
        return objects.size();
    }

    private static int getAnInt(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        int solution = new Test_02().solution("33");
        System.out.println(solution);
    }
}
