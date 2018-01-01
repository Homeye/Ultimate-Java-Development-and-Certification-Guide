package section8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Person person = new Person("Willy", 20, new Person.Address("298 Chick Filee Drive", "New York City", "New York"));

        Person builderPerson1 = new Person.Builder()
                .name("Willy")
                .age(20)
                .address(new Person.Address.Builder().street("298 Chick Filee Drive").city("New York City").state("New York").create())
                .create();

        Person builderPerson2 = new Person.Builder()
                .name("Sammy")
                .age(20)
                .address(new Person.Address.Builder().street("298 Willy Wonka Drive").city("New York City").state("New York").create())
                .create();

        Person builderPerson3 = new Person.Builder()
                .name("Joey")
                .age(20)
                .address(new Person.Address.Builder().street("298 Antarctica Drive").city("New York City").state("New York").create())
                .create();

        ArrayList<Person> personArrayList = new ArrayList<>(Arrays.asList(new Person[]{builderPerson1, builderPerson2, builderPerson3}));
        for (Person personFromList : personArrayList) {
            System.out.println(personFromList.getName());
        }

        System.out.println("-------");

        personArrayList.forEach((loopItem) -> {
            System.out.println(loopItem.getName());
        });

        System.out.println("-------");

        personArrayList.stream().filter(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return !person.getName().equals("Willy");
            }
        }).forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person.getName());
            }
        });

        System.out.println("-------");

        personArrayList.stream()
                .filter((person1) -> !person1.getName().equals("Willy") || person1.getAge() == 20)
                .forEach((person1) -> System.out.println(person1.getName()));
    }
}
