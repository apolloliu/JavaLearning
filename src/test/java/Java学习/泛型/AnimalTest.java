package Java学习.泛型;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    public void test() {
        Animal<String> animal = new Animal<>();
        animal.setType("猫");
        assertEquals("猫", animal.getType());
        Class<? extends Animal> clzz = animal.getClass();
        Field[] declaredFields = clzz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName() + " : " + field.getType().getSimpleName() );
        }
        Method[] declaredMethods = clzz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName() + " : " + method.getReturnType().getSimpleName());
        }


        System.out.println("--------------------------------");
        Animal<Integer> animal2 = new Animal<>();
        animal2.setType(1);
        assertEquals(1, animal2.getType());
        Class<? extends Animal> clzz2 = animal2.getClass();
        Field[] declaredFields2 = clzz2.getDeclaredFields();
        for (Field field : declaredFields2) {
            System.out.println(field.getName() + " : " + field.getType().getSimpleName() );
        }

        Method[] declaredMethods2 = clzz2.getDeclaredMethods();
        for (Method method : declaredMethods2) {
            System.out.println(method.getName() + " : " + method.getReturnType().getSimpleName());
        }

        TreeSet<Integer> set = new TreeSet<>();
    }

}