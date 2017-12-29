package section6;

public class Car implements ActivityClient, Test {

    @Override
    public void doSomething(int value) {
        System.out.println("I am a car.");
    }

    @Override
    public void test() {

    }
}
