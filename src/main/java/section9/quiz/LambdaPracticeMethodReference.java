package section9.quiz;

import java.util.ArrayList;
import java.util.Random;

public class LambdaPracticeMethodReference {

    public static String map(int item) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        return item + Character.toString(alphabet.charAt(random.nextInt(alphabet.length())));
    }

    public void Test() {
        ArrayList<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            integers.add(random.nextInt(100));
        }
        integers.stream().map(LambdaPracticeMethodReference::map).filter((item) -> item.contains("A")).forEach((item) -> System.out.println(item));
    }

    public static void main(String[] args) {

        LambdaPracticeMethodReference test = new LambdaPracticeMethodReference();
        test.Test();
    }
}
