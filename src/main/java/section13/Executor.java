package section13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Executor {

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

        ArrayList<Callable<ArrayList<Double>>> callables = new ArrayList<>();
        randomNumLists.stream().forEach((listToSort) -> {
//            callables.add(new Callable<ArrayList<Double>>() {
//                @Override
//                public ArrayList<Double> call() throws Exception {
//                    Collections.sort(listToSort);
//                    return listToSort;
//                }
//            });
            callables.add(() -> {
                Collections.sort(listToSort);
                return listToSort;
            });
        });

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().availableProcessors());
        try {
            List<Future<ArrayList<Double>>> out = executorService.invokeAll(callables);
            executorService.shutdown();
//            out.stream().forEach((futureItem) -> {
//                try {
//                    futureItem.get();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//            });
//            randomNumLists.stream().forEach((sortedList) -> System.out.println(sortedList));
            randomNumLists.stream().forEach((sortedList) -> {
                double avg = sortedList.stream()
                        .mapToDouble((x) -> x)
                        .average()
                        .getAsDouble();
                System.out.println("List's average: " + avg);
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Program took: " + (System.currentTimeMillis() - startTime) + " milliseconds.");
    }
}
