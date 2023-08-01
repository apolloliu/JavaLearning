package Java学习.科目二.接口继承;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.stream.Collectors;

public class TestInter implements Inter {

    @Override
    public void show() {
        System.out.println("TestInter show");
    }

    public static void main(String[] args) {
        TestInter testInter = new TestInter();
        testInter.show();
        testInter.show2();
    }
}
