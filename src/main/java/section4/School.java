package section4;

import section3.Student;
import section3.Teacher;

public class School {

    private String schoolName;

    private Principal principal;

    private Teacher[] teachers;

    private Student[] students;

    private static School instance;

    //Singleton
    public static School getInstance() {
        if (instance == null) {
            instance = new School();
        }
        return instance;
    }

    private School() {
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
