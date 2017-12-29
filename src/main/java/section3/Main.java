package section3;

import section4.Assignment;
import section4.Principal;
import section4.School;
import section4.StudentTeacher;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student("Willy", "April 20, 2000", 4.0);
        student1.printInfo();

        Person person1 = new Person("Joey", "April 10, 1990");
        person1.printInfo();

        Teacher teacher1 = new Teacher("Sally", "March 1, 1980", "UCLA", 90000, 10);
        teacher1.printInfo();

        Teacher teacher2 = new Teacher("Wendy", "February 2, 1980", "Caltech", 90000, 15);
        teacher2.printInfo();

        System.out.println("-------");

        Person[] personArray = {student1, person1, teacher1, teacher2};

        for (Person person : personArray) {
            person.printInfo();
        }

        System.out.println("-------");

        Date date1 = new Date();
        Assignment assignment1 = new Assignment("Calculus HW", "Calculus", date1);

        student1.setCurrentAssignment(assignment1);
        student1.printAssignmentInfo();
        System.out.println(student1);
        student1.setCurrentAssignment("Biology project");
        student1.printAssignmentInfo();

        System.out.println("-------");

        System.out.println(teacher1.getSalary());
        System.out.println(teacher2.getSalary());

        StudentTeacher studentTeacher1 = new StudentTeacher("Mikey", "04/24/1990", "UCLA", 20000, 1, "UC Davis");
        System.out.println(studentTeacher1.getSalary());

        System.out.println("-------");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1980);
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.DATE, 23);

        Principal principal = new Principal("Alex Smith", "03/23/1965", calendar.getTime());
        principal.doSomething();
        Teacher teacher3 = new Teacher("Alexis Brown", "05/07/1980", "San Diego State", 50000, 20);
        teacher3.doSomething();
        student1.doSomething();

        doSomething(student1);
        doSomething(principal);
        doSomething(teacher3);

        System.out.println("-------");

        Assignment[] assignments = {
                new Assignment("Bio HW", "Biology", new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000)),
                new Assignment("Calculus HW", "Calculus", new Date()),
                new Assignment("English HW", "English", new Date()),
                new Assignment("Computer Science HW", "CS", new Date()),
                new Assignment("History HW", "History", new Date())
        };

        Assignment farthestInPast = Assignment.getFarthestInPastAssignment(assignments);
        int defScore = Assignment.ASSIGNMENT_DEFAULT_SCORE;
        System.out.println(farthestInPast.getAssignmentName());
        System.out.println(defScore);

        System.out.println("-------");

        School school = School.getInstance();
        school.setPrincipal(principal);
        otherFunction();
        System.out.println(school.getPrincipal().getName());

        System.out.println("-------");

        for (Assignment assignment : assignments) {
            student1.addAssignment(assignment);
        }
        student1.addAssignment(new Assignment("Bio HW2", "Biology", new Date()), new Assignment("Calculus HW2", "Calculus", new Date()));
        student1.printInfo();
    }

    public static void doSomething(Person person) {
        if (person instanceof Student) {
            System.out.println("This person is a student.");
        } else if (person instanceof Teacher) {
            Teacher castedTeacher = (Teacher) person;
            System.out.println("This person is a teacher who has a salary of " + castedTeacher.getBaseSalary() + ".");
        } else if (person instanceof Principal) {
            System.out.println("This person is a principal.");
        }
    }

    public static void otherFunction() {
        otherFunction2();
    }

    public static void otherFunction2() {
        School sameSchool = School.getInstance();
    }
}
