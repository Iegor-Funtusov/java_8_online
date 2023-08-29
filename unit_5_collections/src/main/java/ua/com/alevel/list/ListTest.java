package ua.com.alevel.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    private List<Integer> integerArrayList = new ArrayList<>();
    private List<Integer> integerLinkedList = new LinkedList<>();
    private static final int SIZE = 100_000;

    public void test() {
//        for (int i = 0; i < 50; i++) {
//            add();
//        }
        add();
//        get();
//        update();
        delete();
    }

    private void add() {
        integerArrayList.clear();
        integerLinkedList.clear();
        System.out.println("integerArrayList add");
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            integerArrayList.add(i); // O(1)
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("integerArrayList finish: " + end);
        System.out.println("integerLinkedList add");
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            integerLinkedList.add(i); // O(n) -> O(1)
        }
        end = System.currentTimeMillis() - start;
        System.out.println("integerLinkedList finish: " + end);
    }

    private void get() {
        System.out.println();
        System.out.println("integerArrayList read");
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            integerArrayList.get(i); // O(1)
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("integerArrayList finish: " + end);
        System.out.println("integerLinkedList read");
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            integerLinkedList.get(i); // O(n)
        }
        end = System.currentTimeMillis() - start;
        System.out.println("integerLinkedList finish: " + end);
    }

    private void update() {
        System.out.println();
        System.out.println("integerArrayList update");
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            integerArrayList.set(i, i * 2); // O(1)
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("integerArrayList finish: " + end);
        System.out.println("integerLinkedList update");
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            integerLinkedList.set(i, i * 2); // O(n)
        }
        end = System.currentTimeMillis() - start;
        System.out.println("integerLinkedList finish: " + end);
    }

    private void delete() {
        System.out.println();
        System.out.println("integerArrayList delete");
        long start = System.currentTimeMillis();

//        for (Integer integer : integerArrayList) {
//            System.out.println("integer = " + integer);
//        }

        Iterator<Integer> iterator = integerArrayList.iterator();
        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//            System.out.println("next = " + next);
            iterator.next();
            iterator.remove();
        }

        long end = System.currentTimeMillis() - start;
        System.out.println("integerArrayList finish: " + end);
        System.out.println("integerLinkedList delete");
        start = System.currentTimeMillis();
        iterator = integerLinkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        end = System.currentTimeMillis() - start;
        System.out.println("integerLinkedList finish: " + end);
    }
}
