package Java学习.科目二.通配符;

import java.util.List;

public class 通配符 {
    public static void main(String[] args) {
//        List<String> list = List.of("1", "2", "3");
//        reverse(list);
        int val = 0;
        Integer a = new Integer(0);
        Integer b = new Integer(0);
        System.out.println(a == b);
        System.out.println(a == val);
    }

    static <E> void reverse(List<E> list) {
        list.sort((o1, o2) -> (int) o1 - (int)o2);
    }
}

class Target {
    public String a;
    String b;
    private String c;
}
