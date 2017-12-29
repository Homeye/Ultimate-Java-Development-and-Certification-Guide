package section6;

public interface ActivityClient {

    default void defaultActivity() {
        System.out.println("This is the default activity.");
    }

    void doSomething(int value);
}
