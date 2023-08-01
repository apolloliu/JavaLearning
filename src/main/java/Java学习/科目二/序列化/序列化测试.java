package Java学习.科目二.序列化;

import java.io.Serializable;

public class 序列化测试 {
    transient int a = 1;

    public static void main(String[] args) {
//        序列化测试 序列化测试 = new 序列化测试();
//        System.out.println(序列化测试.a);

        SerializableClass2 serializableClass2 = new SerializableClass2();
    }
}
