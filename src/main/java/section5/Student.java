package section5;

import section4.Assignment;

import java.util.Date;

public class Student extends Person {

    private final int MAX_ASSIGNMENTS = 20;

    private double gpa;

    private Assignment currentAssignment;

    private Assignment[] studentAssignments;

    private int currentNumAssignments;

    public Student(String name, String birthDate, double gpa) {
        super(name, birthDate);
        this.gpa = gpa;
        studentAssignments = new Assignment[MAX_ASSIGNMENTS];
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Assignment getCurrentAssignment() {
        return currentAssignment;
    }

    public void setCurrentAssignment(Assignment currentAssignment) {
        this.currentAssignment = currentAssignment;
    }

    public void setCurrentAssignment(String currentAssignmentName) {
        currentAssignment = new Assignment(currentAssignmentName, "Default Class", new Date());
    }

    public void addAssignment(Assignment assignment) {
        if (currentNumAssignments < MAX_ASSIGNMENTS) {
            studentAssignments[currentNumAssignments] = assignment;
            currentNumAssignments++;
        }
    }

    public void addAssignment(Assignment... assignments) {
        for (Assignment assignment : assignments) {
            addAssignment(assignment);
        }
    }

    @Override
    public void printInfo() {
        System.out.println("I am a student.");
        System.out.println("I am a student and i was born on " + getBirthDate() + ".");
        if (studentAssignments[0] != null) {
            System.out.println("These are the assignments that belong to user: " + getName());
            for (int i = 0; i < currentNumAssignments; i++) {
                System.out.println(studentAssignments[i].getAssignmentName());
            }
        }
    }

    public void printAssignmentInfo() {
        if (getCurrentAssignment() != null) {
            System.out.println(getCurrentAssignment().getAssignmentName() + ", " + getCurrentAssignment().getAssignmentDueDate());
        }
    }

    @Override
    public String toString() {
        return getName() + " " + getGpa();
    }

    @Override
    public void doSomething() {
        System.out.println("This person is a student.");
    }
}
