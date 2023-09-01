package ua.com.alevel;

import ua.com.alevel.list.ListTest;
import ua.com.alevel.map.MapTest;

public class CollectionMain {
    public static void main(String[] args) {
//        ListTest listTest = new ListTest();
//        listTest.test();
//        MapTest mapTest = new MapTest();
//        mapTest.test();

        Tree<Integer> integerTree = new Tree<>();

        integerTree.add(4);
        integerTree.add(1);
        integerTree.add(7);
        integerTree.add(-7);
        integerTree.add(10);

        System.out.println("integerTree = " + integerTree);

        Varargs varargs = new Varargs();

        Object[] objects = new Object[10];
        varargs.some2(objects);
        varargs.some1(objects);
        varargs.some1(1, 6, 8, 5);
    }
}
