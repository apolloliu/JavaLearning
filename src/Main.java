import java.lang.reflect.Field;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        A x = new B();
//        System.out.println(x.test());
        System.out.println(x.sum());

        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Map<String, Integer> map = new HashMap<>();
        for (String s: list) {
            map.put(s, map.get(s) + 1);
        }
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static int calc(int x) {
        if( x == 1 ) return 1;
        else return x + calc(x-1);
    }
}

class A {
    int i = 10;
    int sum() {
        return getI() + 10;
    }

    int getI() {
        return i;
    }
}
class B extends A {
    int i = 20;
//    int test() {
//        return getI() + 20;
//    }

    int getI() {
        return i;
    }
}
class Test {
    Test() {
        System.out.println("construct");
    }
    String a = "a";
    static String b = "b";

    private String c = "c";

    private static String d = "d";

    void test() {
        System.out.println("func");
    }

    static {
        System.out.println("static block1");
    }

    {
        System.out.println("block");
    }
    static void test1() {
        System.out.println("static func");
    }

    static {
        System.out.println("static block2");
    }
}

