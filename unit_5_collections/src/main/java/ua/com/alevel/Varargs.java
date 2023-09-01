package ua.com.alevel;

public class Varargs {

    public void some1(Object ... objects) {
        for (Object object : objects) {
            System.out.println("object = " + object);
        }
    }

    public void some2(Object[] objects) {}
}
