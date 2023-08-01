package Java学习.科目二.接口继承;

public interface Inter {
    public void show();

    default void show2() {
        System.out.println("Inter show2");
    }
}
