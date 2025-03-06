package org.example._0x02;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class _10871 {

    @Test
    void main() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        String[] s1 = s.split(" ");

        String collect = Arrays.stream(s1)
                .filter(a -> Integer.parseInt(a) > X)
                .collect(Collectors.joining(" "));




    }


    //http://dyndy.tistory.com/106 참고
    public class Main {

        public static void main(String[] args) throws IOException {


        }
    }

}
