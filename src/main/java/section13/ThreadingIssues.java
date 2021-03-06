package section13;

import java.util.ArrayList;

public class ThreadingIssues {

    public static void main(String[] args) {

        Counter counter = new Counter();

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.add();
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.sub();
                }
            });
            t1.start();
            t2.start();
            threads.add(t1);
            threads.add(t2);
        }
        threads.stream().forEach((thread) -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(counter.getX());
    }
}
