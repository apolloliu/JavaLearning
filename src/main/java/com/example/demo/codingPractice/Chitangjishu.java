package com.example.demo.codingPractice;

import java.io.*;
import java.util.*;

public class Chitangjishu {
    private static final int N = 1010;
    private static final int M = 8;
    private static int n, m;
    private static char a[][] = new char[N][N];
    private static boolean st[][] = new boolean[N][N];
    private static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    private static int[] dy = {1, -1, 0, -1, 1, 0, -1, 1};

    public static boolean go(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void dfs(int x, int y) {
        st[x][y] = true;
        for(int i = 0; i < M; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if(go(nx, ny) && !st[nx][ny] && a[nx][ny] == 'W') {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            // for(int j = 0; j < m; j++)
            a[i] = sc.next().toCharArray();
        }
        // Arrays.fill(st, false);

        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!st[i][j] && a[i][j] == 'W') {
                    res ++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(res);

    }
}
