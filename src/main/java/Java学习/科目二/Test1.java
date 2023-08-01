package Java学习.科目二;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        try {
            System.out.println("Hello World! aa: " + func());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static int func() throws Exception {
        for (int i = 0; i < 1; i++) {
            try {
                throw new Exception("bb");
            } catch (Exception e) {
//                System.out.println("cc");
//                System.exit(0);
                throw e;
            } finally {
                continue;
            }
        }
        return 0;
    }
}
