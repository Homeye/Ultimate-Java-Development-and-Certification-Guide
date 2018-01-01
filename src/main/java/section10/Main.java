package section10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));

//        integers.stream().forEach(i -> System.out.println(i));

//        integers.stream()
//                .filter((i) -> {
//                    System.out.println("Inside the filter: " + Integer.toString(i));
//                    return i < 5 ? true : false; //Ternary operator
//                })
//                .forEach(i -> System.out.println(i));

//        //Wrong order
//        integers.stream()
//                .sorted((a, b) -> {
//                    System.out.println("Sorting items!");
//                    return Integer.compare(b, a);
//                })
//                .filter((i) -> {
//                    System.out.println("Inside the filter: " + Integer.toString(i));
//                    return i < 5 ? true : false;
//                })
//                .forEach(i -> System.out.println(i));

        integers.stream()
                .filter((i) -> {
                    System.out.println("Inside the filter: " + Integer.toString(i));
                    return i < 5 ? true : false;
                })
                .sorted((a, b) -> {
                    System.out.println("Sorting items!");
                    return Integer.compare(b, a);
                })
                .forEach(i -> System.out.println(i));

        System.out.println("-------");

        class Person {

            public int age;

            public String name;

            public Person(int age, String name) {
                this.age = age;
                this.name = name;
            }

            @Override
            public String toString() {
                return age + " " + name;
            }
        }

        Person[] peopleArray = {new Person(10, "Sally"), new Person(20, "Joey"), new Person(30, "Willy"),
                new Person(10, "Smithy"), new Person(30, "Joe")};
        ArrayList<Person> people = new ArrayList<>(Arrays.asList(peopleArray));

//        people = new ArrayList<>(
//                people.stream()
//        .filter((person) -> person.age <= 20)
//        .collect(Collectors.toList())
//        );
//
//        people.stream().forEach((person) -> System.out.println(person.age + " " +person.name));

        Map<Integer, List<Person>> groupedPeople = people.stream().collect(Collectors.groupingBy((p) -> p.age));
        System.out.println(groupedPeople);
    }
}
