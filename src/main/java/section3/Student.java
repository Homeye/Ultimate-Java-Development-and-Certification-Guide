package section3;

public class Student extends Person {

    private String gpa;

    public Student(String name, String birthDate, String gpa) {
        super(name, birthDate);
        this.gpa = gpa;
    }

    public String getGpa() {
        return gpa;
    }

    @Override
    public void printInfo() {
        System.out.println("I am a student and i was born on " + getBirthDate() + ".");
    }
}
