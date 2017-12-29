package section5;

public class Teacher extends Person {

    private String school;

    private double baseSalary;

    private int numYearsAtSchool;

    private Subject subject;

    public Teacher(String name, String birthDate, String school, double baseSalary, int numYearsAtSchool) {
        super(name, birthDate);
        this.school = school;
        this.baseSalary = baseSalary;
        this.numYearsAtSchool = numYearsAtSchool;
        this.subject = new Subject("History");
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
        System.out.println("I am a teacher.");
    }

    public final double getSalary() {
        return getNumYearsAtSchool() * 1000 + baseSalary;
    }

    @Override
    public void doSomething() {
        System.out.println("This person is a teacher who has a salary of " + getBaseSalary() + ".");
    }

    //    public class Subject {
    public static class Subject {

        private String subjectName;

        public Subject(String subjectName) {
            this.subjectName = subjectName;
        }

        public String getSubjectName() {
            return subjectName;
        }

//        public void printTeacherInfo() {
//            System.out.println(school);
//        }
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
