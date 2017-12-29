package section6;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal() {
            @Override
            public void walk() {

            }

            @Override
            public void doSomething(int value) {

            }
        };
        animal.eat();

        Car car = new Car();

        Rock rock = new Rock();
        rock.onUseRequested();
        rock.test();

        ActivityClient[] items = {animal, car, rock};

        for (ActivityClient item : items) {
            item.doSomething(0);
            item.defaultActivity();
        }

        System.out.println("-------");

        ActivityClient activityClient = new ActivityClient() {

            private int myVal;

            @Override
            public void doSomething(int value) {
                myVal++;
                System.out.println("This is an anonymous inner class.");
            }
        };

        class CustomClass implements ActivityClient {

            @Override
            public void doSomething(int value) {
                System.out.println("This is intended to make the concept of anonymous inner classes more clear.");
            }
        }

        AnimateActivityManager manager = new AnimateActivityManager();
        manager.accept(rock);
        manager.accept(activityClient);
        manager.accept(new CustomClass());
        manager.accept(new ActivityClient() {
            @Override
            public void doSomething(int value) {
                System.out.println("This is an anonymous inner class being provided to a method.");
            }
        });

        System.out.println("-------");

//        manager.accept(() -> System.out.println("This is a lambda expression."));
        manager.accept((value) -> System.out.println("This is a lambda expression with value " + value + "."));
    }
}
