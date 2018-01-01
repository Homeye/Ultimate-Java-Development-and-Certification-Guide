package section9;

import section8.Person;

import java.util.HashMap;
import java.util.function.BiPredicate;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, Person> hashMap = new HashMap<>();
        Person p1 = new Person("Willy", 20, new Person.Address("298 Chick Filee Drive", "New York City", "New York"));
        Person p2 = new Person("Sammy", 20, new Person.Address("298 Willy Wonka Drive", "New York City", "New York"));
        Person p3 = new Person("Joey", 20, new Person.Address("298 Antarctica Drive", "New York City", "New York"));
        hashMap.put(0, p1);
        hashMap.put(1, p2);
        hashMap.put(2, p3);
        hashMap.forEach((Integer key, Person value) -> {
            System.out.println(value.getName());
        });

        BiPredicate<Integer, Person> personTest = (Integer k, Person p) -> p.getAge() < 50 && k > 1;
        BiPredicate<Integer, Person> anonyTest = new BiPredicate<Integer, Person>() {
            @Override
            public boolean test(Integer integer, Person person) {
                return person.getAge() < 50 && integer > 1;
            }
        };
        if (personTest.test(3, p2)) {
            System.out.println("Predicate passed test!");
        } else {
            System.out.println("Predicate failed test!");
        }

        if (anonyTest.test(1, p2)) {
            System.out.println("Predicate passed test!");
        } else {
            System.out.println("Predicate failed test!");
        }
    }
}
