package ua.com.alevel.set;

import ua.com.alevel.Student;

import java.util.*;

public class SetTest {

    Set<Student> hashSet = new HashSet<>();
    Set<Student> linkedHashSet = new LinkedHashSet<>();
    Set<Student> treeSet = new TreeSet<>();

    Map<Student, Object> hashMap = new HashMap<>();

    public void test() {
        hashSet.add(new Student("fdsfsd", 70));
        hashSet.add(new Student("fdsfsd", 70));
        hashSet.add(new Student("fdsfsd", 70));
        hashSet.add(new Student("fdsfsd", 70));

        hashMap.put(new Student("fgsffa", 89), null);
        hashMap.put(new Student("fgsffa", 89), null);
        hashMap.put(new Student("fgsffa", 89), null);
        hashMap.put(new Student("fgsffa", 89), null);
        hashMap.put(new Student("fgsffa", 89), null);
    }
}
