package Java学习.科目二.编程实践;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class 控制语句 {
    public static void main(String[] args) {
        String[] strs = {"1", "2", "3"};
        List<String> list = new ArrayList<>(Arrays.asList(strs));
//        remove_fun1(list);
//        remove_fun2(list);
        remove_fun3(list);
    }

    static void remove_fun1(List<String> list) {
        for(String item : list) {
            System.out.println(item);
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
    }

    static void remove_fun2(List<String> list) {
        list.removeIf(item -> "1".equals(item));
        System.out.println(list);
    }

    static void remove_fun3(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
