package section7.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class DescendingList {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            integers.add(random.nextInt(1000));
        }
//        Collections.sort(integers);
//        Collections.reverse(integers);

        Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                }
                return 0;
            }
        });

        System.out.println(integers);
    }
}
