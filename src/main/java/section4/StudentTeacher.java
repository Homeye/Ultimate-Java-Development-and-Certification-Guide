package section4;

import section3.Teacher;

public class StudentTeacher extends Teacher {

    private String studentTeacherSchool;

    public StudentTeacher(String name, String birthDate, String school, double baseSalary, int numYearsAtSchool, String studentTeacherSchool) {
        super(name, birthDate, school, baseSalary, numYearsAtSchool);
        this.studentTeacherSchool = studentTeacherSchool;
    }

//    @Override
//    public double getSalary() {
//        return super.getSalary() + 10000;
//    }
}
