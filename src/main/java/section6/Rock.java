package section6;

public class Rock implements NonMovableActivityClient {

    @Override
    public void onUseRequested() {
        System.out.println("I am being used!");
    }

    @Override
    public void doSomething(int value) {
        System.out.println("I can't do anything on my own - I'm a rock!");
    }

    @Override
    public void test() {
        System.out.println("i am being tested!");
    }

    @Override
    public void defaultActivity() {
        System.out.println("This is rock's default implementation.");
    }
}
