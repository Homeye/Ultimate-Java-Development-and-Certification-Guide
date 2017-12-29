package section3;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student("Willy", "April 20, 2000", "4.0");
        student1.printInfo();

        Person person1 = new Person("Joey", "April 10, 1990");
        person1.printInfo();

        Teacher teacher1 = new Teacher("Sally", "March 1, 1980", "UCLA", 90000);
        teacher1.printInfo();

        Teacher teacher2 = new Teacher("Wendy", "February 2, 1980", "Caltech", 90000);
        teacher2.printInfo();

        System.out.println("-------");

        Person[] personArray = {student1, person1, teacher1, teacher2};

        for (Person person : personArray) {
            person.printInfo();
        }
    }
}
