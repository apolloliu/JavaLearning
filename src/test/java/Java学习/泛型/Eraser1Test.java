package Java学习.泛型;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class Eraser1Test {
    @Test
    public void test() {
        Class<Eraser1> eraser1Class = Eraser1.class;
        Method[] declaredMethods = eraser1Class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName() + " : " + declaredMethod.getReturnType().getSimpleName());
        }
    }

}