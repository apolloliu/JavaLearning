package com.example.demo.codingPractice;

import java.util.Scanner;

public class 统计次数 {
    public static int calc(int x, int k) {
        int res = 0;
        while(x > 0) {
            if(x % 10 == k) {
                res++;
            }
//            System.out.println(x);
            x /= 10;
        }
        return res;
    }
    public static void main(String[] args) throws Exception {
//        Integer n = 10;
        Address n = new Address("123");
        System.out.println("实参：" + n.address);
        change(n);
        System.out.println("实参：" + n.address);
    }

    public static void change(Address a) {
//        a = new Address("222");
        a.address = "222";
        System.out.println("形参：" + a.address);
    }
}
