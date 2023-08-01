package Java学习.科目二;

import java.io.IOException;
import java.sql.SQLException;

public class 受检异常复写 {

}

class A {
    void f() throws IOException {
        throw new IOException();
    }
}

class B extends A {
//    void f() throws SQLException, IOException {
//        throw new SQLException();
//    }
}