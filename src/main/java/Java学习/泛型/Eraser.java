package Java学习.泛型;

import java.util.List;

public class Eraser<T extends Number> {
    T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public <T extends List> T show(T t) {
        return t;
    }
}
