package section3;

//public final class Teacher extends Person
public class Teacher extends Person {

    private String school;

    private double baseSalary;

    private int numYearsAtSchool;

    public Teacher(String name, String birthDate, String school, double baseSalary, int numYearsAtSchool) {
        super(name, birthDate);
        this.school = school;
        this.baseSalary = baseSalary;
        this.numYearsAtSchool = numYearsAtSchool;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getNumYearsAtSchool() {
        return numYearsAtSchool;
    }

    public void setNumYearsAtSchool(int numYearsAtSchool) {
        this.numYearsAtSchool = numYearsAtSchool;
    }

    @Override
    public void printInfo() {
        System.out.println("I am a teacher and i was born on " + getBirthDate() + ".");
    }

    public final double getSalary() {
        return getNumYearsAtSchool() * 1000 + baseSalary;
    }

    @Override
    public void doSomething() {
        System.out.println("This person is a teacher who has a salary of " + getBaseSalary() + ".");
    }
}
