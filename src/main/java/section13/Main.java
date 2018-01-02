package section13;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList<Double>> randomNumLists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomNumLists.add(new ArrayList<>());
        }
        for (ArrayList<Double> randomNumList : randomNumLists) {
            for (int j = 0; j < 1000000; j++) {
                randomNumList.add(Math.random() * 100);
            }
        }

        long startTime = System.currentTimeMillis();
//        for (ArrayList<Double> arrayList : randomNumLists) {
//            Collections.sort(arrayList);
//        }
        ArrayList<Thread> joinedThreads = new ArrayList<>();
        int listNum = 0;
//        System.out.println(randomNumLists);

        for (ArrayList<Double> randomNumList : randomNumLists) {
            System.out.println("Firing new thread!");
            final int index = listNum;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Collections.sort(randomNumList);
                    System.out.println("Finished sorting list number: " + index);
                }
            });
            t.start();
//            try {
//                System.out.println("Waiting for thread to finish!");
//                t.join();
//                System.out.println("Thread finished executing!");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            joinedThreads.add(t);
//            Collections.sort(randomNumList);
            listNum++;
        }

        for (Thread thread : joinedThreads) {
            try {
                System.out.println("Waiting for thread to finish!");
                thread.join();
                System.out.println("Thread finished executing!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Program took: " + (System.currentTimeMillis() - startTime) + " milliseconds.");
//        System.out.println(randomNumLists);
    }
}
