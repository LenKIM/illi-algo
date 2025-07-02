package org.example._12_sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main_10_11652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long num = sc.nextLong();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long result = 0;
        int maxCount = 0;

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            long key = entry.getKey();
            int value = entry.getValue();

            if (value > maxCount || (value == maxCount && key < result)) {
                result = key;
                maxCount = value;
            }
        }

        System.out.println(result);
    }
}
