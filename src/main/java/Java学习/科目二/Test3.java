package Java学习.科目二;

public class Test3 {
    public static void main(String[] args) {
        try {
            start();
        } catch (Exception e) {
            System.out.println("catch Exception");
        } catch (Throwable e) {
            System.out.println("catch Throwable");
        }
    }


    static void start()  {
        throw new RuntimeException();
    }
}
