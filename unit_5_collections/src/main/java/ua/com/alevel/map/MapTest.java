package ua.com.alevel.map;

import ua.com.alevel.Student;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

    private Map<Student, String> hashMap = new HashMap<>();
    private Map<Student, String> linkedHashMap = new LinkedHashMap<>();
    private Map<String, String> treeMap = new TreeMap<>();

    public void test() {
        hashMap.put(new Student("test1", 25), "test1");
        hashMap.put(new Student("test88", 26), "test2");
        hashMap.put(new Student("test22", 28), "test3");
        hashMap.put(new Student("test56", 27), "test4");
        hashMap.put(new Student("test41", 30), "test5");

        hashMap.forEach((k, v) -> {
            System.out.println("k = " + k);
            System.out.println("v = " + v);
        });

        System.out.println();

        linkedHashMap.put(new Student("test1", 25), "test1");
        linkedHashMap.put(new Student("test88", 26), "test2");
        linkedHashMap.put(new Student("test22", 28), "test3");
        linkedHashMap.put(new Student("test56", 27), "test4");
        linkedHashMap.put(new Student("test41", 30), "test5");

        linkedHashMap.forEach((k, v) -> {
            System.out.println("k = " + k);
            System.out.println("v = " + v);
        });
    }
}
