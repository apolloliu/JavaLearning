package Java学习.泛型;

public class Animal<T> {
    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public <T> T show(T t) {
        return t;
    }
}
