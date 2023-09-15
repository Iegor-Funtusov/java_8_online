package ua.com.alevel;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 5, 3, 7, 90, 2, 5);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
//        Collections.sort(list);

        System.out.println("list = " + list);
        for (Integer integer : list) {
            if (integer % 2 != 0) {
                list1.add(integer);
            }
        }

        System.out.println("list1 = " + list1);

        for (int i = 0; i < list1.size(); i++) {
            int count = 0;
            for (int i1 = 0; i1 < list1.size(); i1++) {
                if (list1.get(i) == list1.get(i1)) {
                    ++count;
                }
            }
            if (count == 1) {
                list2.add(list1.get(i));
            }
        }

        System.out.println("list2 = " + list2);

        Stream<Integer> integerStream = list1.stream();

        System.out.println("list = " + list);
        List<Integer> integerList = integerStream
                .distinct()
                .filter(i -> i % 2 != 0)
                .sorted()
                .toList();
        System.out.println("integerList = " + integerList);

        int sum = 0;
        for (Integer integer : list) {
            if (integer % 2 != 0) {
                sum += integer;
            }
        }
        System.out.println("sum = " + sum);

        sum = list.stream()
                .filter(i -> i % 2 != 0)
                .reduce((i1, i2) -> i1 + i2)
                .orElse(0);
        System.out.println("sum = " + sum);


        System.out.println();

        //1 Stream<Integer> integerStream = list.stream();
        //2 Stream<String> stringStream = Stream.of("cdafsd", "fdaf", "fsdasa");
        //3 Stream<String> stringStream = Arrays.stream(new String[]{"fdsas", "fsdafs", "fdsafs"});
        // 4 Stream.Builder<String> builder = Stream.builder();
        // Stream<String> stringStream = builder.add("fdsafasd").add("fddsa").add("fsdafdasf").build();

//        IntStream intStream = IntStream.range(0, 90);
        IntStream intStream = IntStream.rangeClosed(0, 90);
        List<Integer> integers = intStream.boxed().toList(); // convert int stream to stream of int
        System.out.println("integers = " + integers);

//        List<Integer> integers1 = [0 .. 100];

        for (int i = 0; i < 100; i++) {
            // add to some collections
        }

        System.out.println();
        List<Integer> newList = integers.stream()
//                .filter(i -> i % 2 == 0)
                .filter(StreamMain::isEven)
                .skip(5)
                .sorted()
                .limit(10)
                .peek(element -> System.out.println("element = " + element))
                .map(element -> element * 2)
                .toList();
        System.out.println("newList = " + newList);


        sum = Stream.of("1", "fds", "55", "fdas")
                .filter(el -> el.matches("[0-9]*"))
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println("sum = " + sum);
        sum = Stream.of("1", "fds", "55", "fdas")
                .filter(el -> el.matches("[0-9]*"))
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println("sum = " + sum);

        int max = Stream.of("1", "fds", "55", "fdas")
                .filter(el -> el.matches("[0-9]*"))
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(0);
        System.out.println("max = " + max);

        boolean any = Stream.of("1", "fds", "55", "fdas")
                .anyMatch(el -> el.matches("[0-9]*"));
        System.out.println("any = " + any);
        boolean all = Stream.of("1", "fds", "55", "fdas")
                .allMatch(el -> el.matches("[0-9]*"));
        System.out.println("all = " + all);
        boolean none = Stream.of("1", "fds", "55", "fdas")
                .noneMatch(el -> el.matches("[0-9]*"));
        System.out.println("none = " + none);


        C c = new C();
//        Integer i = c.getB().getA().getIntegerA();

//        i = c?.b?.a?.getIntegerA();

        Integer i = 0;
        B b = c.getB();
        if (b != null) {
            A a = b.getA();
            if (a != null) {
                i = a.getIntegerA();
            }
        }
        System.out.println("i = " + i);

//        Optional<B> optionalB = Optional.ofNullable(c.getB());
//
//        A a = Optional
//                .ofNullable(optionalB.get())
//                .map(e -> e.getA())
//                .orElse(new A());

        List<Student> students = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            Student student = new Student();
            student.setFirstName(String.valueOf(j));
            student.setLastName(UUID.randomUUID().toString());
            students.add(student);
        }
        System.out.println("students = " + students);

        List<StudentDto> studentDtoList = new ArrayList<>();
//        1 for (Student student : students) {
//            StudentDto studentDto = new StudentDto();
//            studentDto.setFullName(student.getFirstName() + " " + student.getLastName());
//            studentDtoList.add(studentDto);
//        }
//        2 for (Student student : students) {
//            studentDtoList.add(new StudentDto(student));
//        }

//        studentDtoList = students.stream().map((Student s) -> new StudentDto(s)).toList();
        studentDtoList = students.stream().map(StudentDto::new).toList();
        System.out.println("studentDtoList = " + studentDtoList);
    }

    public static boolean isEven(Integer element) {
        return element % 2 == 0;
    }
}