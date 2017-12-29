package section4;

import java.util.Date;

public class Assignment {

    private String assignmentName;

    private String className;

    private Date assignmentDueDate;

    public static final int ASSIGNMENT_DEFAULT_SCORE = 20;

    public Assignment(String assignmentName, String className, Date assignmentDueDate) {
        this.assignmentName = assignmentName;
        this.className = className;
        this.assignmentDueDate = assignmentDueDate;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getAssignmentDueDate() {
        return assignmentDueDate;
    }

    public void setAssignmentDueDate(Date assignmentDueDate) {
        this.assignmentDueDate = assignmentDueDate;
    }

    public static Assignment getFarthestInPastAssignment(Assignment[] assignments) {
        long date = Long.MAX_VALUE;
        Assignment farthestAssignment = null;
        for (Assignment assignment : assignments) {
            if (assignment.getAssignmentDueDate().getTime() < date) {
                date = assignment.getAssignmentDueDate().getTime();
                farthestAssignment = assignment;
            }
        }
        return farthestAssignment;
    }
}
