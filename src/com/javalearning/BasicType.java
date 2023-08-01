package com.javalearning;

import java.util.*;
public class BasicType {
    public String address;
    public BasicType(String address) {
        this.address = address;
    }
    public int hashCode() {
        int res = address.hashCode();
        return res;
    }
    public static void main(String[] args) {
//        short s = 1;
//        s = s + 1;
//        System.out.println(s);
//
        boolean match = "12".matches("/b0[xX][0-9a-fA-F]+b/");
        System.out.println(match);
        boolean match1 = "0XDEADBEEF".matches("/b0[xX][0-9a-fA-F]+b/");
        System.out.println(match1);
        String reg = "\\w";
        System.out.println("xxxx".matches(reg));

//        Map<String, String> map = new HashMap<>();
//        map.put("1", "a");
//        map.put("2", "b");
//        List<String> list = new ArrayList<>();
//        list.addAll(map.values());
//        list.addAll(Collections.singleton("c"));
//        System.out.println(list);
    }
}
