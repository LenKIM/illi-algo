package org.example._12_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main_09_1431 {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            strings.add(br.readLine());
        }

        List<String> collect = strings.stream()
                .sorted((o1, o2) -> {
                    if (o1.length() < o2.length()) {
                        return -1;
                    }

                    if (o1.length() > o2.length()) {
                        return 1;
                    }

                    int o1Number = getNumbers(o1);
                    int o2Number = getNumbers(o2);

                    if (o1Number == o2Number) {
                        return o1.compareTo(o2);
                    }

                    return Integer.compare(o1Number, o2Number);
                }).toList();

        for (String s : collect) {
            System.out.println(s);
        }
    }

    private static int getNumbers(String o1) {
        char[] chars = o1.toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                int i1 = aChar - '0';
                sum += i1;
            }
        }
        return sum;
    }
}
