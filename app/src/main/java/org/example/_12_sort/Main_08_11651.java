package org.example._12_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main_08_11651 {
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        Point [] points = new Point[N];
        for (int i = 0; i < N; i++) {
            String[] aa =  sc.nextLine().split(" ");
            points[i] = new Point(Integer.parseInt(aa[0]), Integer.parseInt(aa[1]));
        }


        Arrays.sort(points, Point.yCom);

        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i].x + " "+points[i].y);
        }

    }

    static class Point {

        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Comparator<Point> xCom = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x - o2.x == 0){
                    return o1.y- o2.y;
                } else {
                    return o1.x - o2.x;
                }
            }
        };

        public static Comparator<Point> yCom = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.y - o2.y == 0){
                    return o1.x- o2.x;
                } else {
                    return o1.y - o2.y;
                }
            }
        };
    }
}
