package section5;

public class Main {

    public static void main(String[] args) {

        Person person = new Person("Andy Abstract", "April 1, 1990") {
            @Override
            public void printInfo() {
                System.out.println("lalala");
            }
        };

        person.printInfo();

        System.out.println("-------");

        Teacher teacher1 = new Teacher("Alexis Brown", "05/07/1980", "San Diego State", 50000, 20);
        System.out.println(teacher1.getSubject().getSubjectName());
//        Teacher.Subject teacher1Subject = teacher1.new Subject("Biology");
        Teacher.Subject teacher1Subject = new Teacher.Subject("Biology");
        teacher1.setSubject(teacher1Subject);
        System.out.println(teacher1.getSubject().getSubjectName());
    }
}
