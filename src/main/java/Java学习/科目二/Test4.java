package Java学习.科目二;

public class Test4 {
    public static void main(String[] args) {
        System.out.println(func());
    }
    static int func() {
        try {
            int a = 1 / 0;
            return a;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            return 2;
        }
    }
}
