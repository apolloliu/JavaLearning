package Java学习.科目二.编程实践;

public class 异常比较 {
    static String get() {
//        return "get";
        return null;
    }
    public static void main(String[] args) {
//        if (get().equals("get")) {
//            System.out.println("get");
//        }
        if ("get".equals(get())) {
            System.out.println("get");
        } else {
            System.out.println("null");
        }

//        if (Object.equals(get(), "get")) {
//            System.out.println("get");
//        } else {
//            System.out.println("null");
//        }
    }
}
