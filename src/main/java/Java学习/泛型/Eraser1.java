package Java学习.泛型;

import java.util.List;

public class Eraser1 implements Info<String> {
    @Override
    public String info(String s) {
        return s;
    }
}
