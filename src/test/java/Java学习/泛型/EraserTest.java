package Java学习.泛型;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class EraserTest {
    @Test
    public void test() {
        Eraser<Integer> eraser = new Eraser<>();
        eraser.setKey(1);
        assertEquals(1, eraser.getKey());
        Class<? extends Eraser> clzz = eraser.getClass();
        Field[] declaredFields = clzz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName() + " : " + field.getType().getSimpleName() );
        }

        System.out.println("--------------------------------");
        Method[] declaredMethods = clzz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName() + " : " + method.getReturnType().getSimpleName());
        }
    }

}