package section6;

public abstract class Animal implements ActivityClient {

    @Override
    public void doSomething(int value) {
        System.out.println("I am an animal.");
    }

    public abstract void walk();

    public void eat() {
        System.out.println("I am eating!");
    }
}
