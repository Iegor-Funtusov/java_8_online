package ua.com.alevel;

public class MatList<E extends Number> {

    private Number[] elements = new Number[10];

    public void test() {
        Object o = new Object();
        E e = (E) o;
    }
}
