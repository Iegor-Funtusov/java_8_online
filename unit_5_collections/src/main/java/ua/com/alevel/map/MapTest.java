package ua.com.alevel.map;

import ua.com.alevel.Car;
import ua.com.alevel.CarComparator;
import ua.com.alevel.Student;

import java.util.*;

public class MapTest {

    private Map<Student, String> hashMap = new HashMap<>();
    private Map<Student, String> linkedHashMap = new LinkedHashMap<>();
    private Map<Student, String> treeMap = new TreeMap<>();

    public void test() {
//        hashMap.put(new Student("test1", 25), "test1");
//        hashMap.put(new Student("test88", 26), "test2");
//        hashMap.put(new Student("test22", 28), "test3");
//        hashMap.put(new Student("test56", 27), "test4");
//        hashMap.put(new Student("test41", 30), "test5");
//
//        hashMap.forEach((k, v) -> {
//            System.out.println("k = " + k);
//            System.out.println("v = " + v);
//        });
//
//        System.out.println();
//
//        linkedHashMap.put(new Student("test1", 25), "test1");
//        linkedHashMap.put(new Student("test88", 26), "test2");
//        linkedHashMap.put(new Student("test22", 28), "test3");
//        linkedHashMap.put(new Student("test56", 27), "test4");
//        linkedHashMap.put(new Student("test41", 30), "test5");
//
//        linkedHashMap.forEach((k, v) -> {
//            System.out.println("k = " + k);
//            System.out.println("v = " + v);
//        });
//
//        System.out.println();
//
        treeMap.put(new Student("test1", 25), "test1");
        treeMap.put(new Student("test88", 26), "test3");
        treeMap.put(new Student("test22", 26), "test2");
        treeMap.put(new Student("test56", 27), "test4");
        treeMap.put(new Student("test41", 30), "test5");

        treeMap.forEach((k, v) -> {
            System.out.println("k = " + k);
            System.out.println("v = " + v);
        });

//        Map<Car, String> carMap = new TreeMap<>(new Comparator<Car>() {
//            @Override
//            public int compare(Car o1, Car o2) {
//                return 0;
//            }
//        });
        Map<Car, String> carMap = new TreeMap<>(new CarComparator());

        carMap.put(new Car("BMW"), "some");
        carMap.put(new Car("Mersedes"), "some");
        carMap.put(new Car("Audi"), "some");

        carMap.forEach((k, v) -> {
            System.out.println("k = " + k);
        });


//        Student student1 = new Student("test1", 25);
//        Student student2 = new Student("test2", 25);

//        System.out.println(student1.compareTo(student2));
    }
}
