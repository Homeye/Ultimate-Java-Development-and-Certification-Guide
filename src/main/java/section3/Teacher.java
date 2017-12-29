package section3;

public class Teacher extends Person {

    private String school;

    private double salary;

    public Teacher(String name, String birthDate, String school, double salary) {
        super(name, birthDate);
        this.school = school;
        this.salary = salary;
    }

    @Override
    public void printInfo() {
        System.out.println("I am a teacher and i was born on " + getBirthDate() + ".");
    }
}
