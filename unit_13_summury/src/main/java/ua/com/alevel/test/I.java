package ua.com.alevel.test;

public abstract interface I {

    public abstract void test();

    final static class III {

        static interface III$ {

        }
    }

    default void method() {
        System.out.println("I.method");
    }
}
