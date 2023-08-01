package Java学习.科目二;

public class Test2 {
    public static void main(String[] args) {
//        JuniorClass juniorClass = new JuniorClass();
//        SeniorClass seniorClass = new JuniorClass();
//        SeniorClass seniorClass1 = new SeniorClass();
//        if (juniorClass instanceof SeniorClass) {
//            System.out.println("juniorClass instanceof SeniorClass");
//        }
    }
}

class SeniorClass {
    public SeniorClass() {
        toString();
    }

//    public SeniorClass(int i) {
//        System.out.println("SeniorClass " + i);
//    }

    @Override
    public String toString() {
        return "SeniorClass{}";
    }
}


class JuniorClass extends SeniorClass {
    private String name;
    private Integer age;

    public JuniorClass() {
//        super(666);
        super();
//        System.out.println("JuniorClass age: " + age);
        name = "JuniorClass";
//        age = Integer.valueOf("20");
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }
}