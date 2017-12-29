package section4;

import section3.Person;

import java.util.Date;

public class Principal extends Person {

    private Date joinDate;

    public Principal(String name, String birthDate, Date joinDate) {
        super(name, birthDate);
        this.joinDate = joinDate;
    }

    @Override
    public void doSomething() {
        System.out.println("This person is a principal.");
    }
}
