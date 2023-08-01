package Java学习.科目二.反射;

public class 实例化 {
    public static void main(String[] args) {
        try {
            Target target = (Target) Class.forName("Target").newInstance();
        } catch (InstantiationException e) {
            System.out.println(1);
        } catch (IllegalAccessException e) {
            System.out.println(2);
        } catch (ClassNotFoundException e) {
            System.out.println(3);
        }
        System.out.println(Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE);
    }
}


class Target {
    private Integer i;

//    public Target() {
//        System.out.println("Target()");
//    }

    public Target(Integer i) {
        System.out.println("Target()");
        this.i = i;
    }
}