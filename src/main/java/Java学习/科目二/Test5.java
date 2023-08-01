package Java学习.科目二;

import java.util.stream.Stream;

public class Test5 {
    public static void main(String[] args) {
//		String[] s = new String[5];
        Stream.of(1, 2, 3).sorted().forEach(System.out::println);
        Test t = new Test();
//        t.records[0] = new Record();
        t.records[0].x = 10;
        t.records[0].value = "value";
        System.out.println(t.records[0].x);
        System.out.println(t.records[0].value);
    }
}

class Test {
    public Record[] records;

    public Test() {
        records = new Record[5];
    }

}

class Record {
    public int x;

    public String value;
}

