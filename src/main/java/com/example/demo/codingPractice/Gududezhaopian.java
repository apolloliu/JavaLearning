package com.example.demo.codingPractice;

import java.io.*;
import java.util.*;

public class Gududezhaopian {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(bf.readLine());
        char[] s = bf.readLine().toCharArray();
        long res = 0;
        long[] l = new long[n];
        long[] r = new long[n];
        for(int i = 0, h = 0, g = 0; i < n; i++) {
            if(s[i] == 'G') {
                l[i] = h;
                h = 0;
                g++;
            }
            else {
                l[i] = g;
                g = 0;
                h++;
            }
        }
        for(int i = n - 1, h = 0, g = 0; i >= 0; i--) {
            if(s[i] == 'G') {
                r[i] = h;
                h = 0;
                g++;
            }
            else {
                r[i] = g;
                g = 0;
                h++;
            }
        }
        for(int i = 0; i < n; i++) {
//            if(s[i] == 'G') {
                res += l[i] * r[i];
//                if(l[i] == 0)
                    res += Math.max(0, r[i] - 1);
//                if(r[i] == 0)
                    res += Math.max(0, l[i] - 1);
//            }
        }
//        for(int i = 0; i < n; i++) {
//            System.out.printf("%d %d %d\n", i, l[i], r[i]);
//        }
//        out.print(res);
//        out.flush();
        System.out.println(res);
    }
}
