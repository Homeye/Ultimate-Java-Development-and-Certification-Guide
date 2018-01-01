package section8.quiz;

import java.util.ArrayList;
import java.util.Random;

public class LambdaPractice {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            integers.add(random.nextInt(100));
        }

        integers.stream().forEach((integer) -> System.out.println(integer));

        System.out.println("-------");

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

//        integers.stream().forEach((integer) -> System.out.println(integer.toString() + alphabet.charAt(random.nextInt(alphabet.length()))));

        integers.stream().map((item) -> {
            return item + Character.toString(alphabet.charAt(random.nextInt(alphabet.length())));
        }).forEach((item) -> System.out.println(item));

        System.out.println("-------");

        System.out.println("String contains letter \"A:\"");

        integers.stream().map((item) -> {
            return item + Character.toString(alphabet.charAt(random.nextInt(alphabet.length())));
        }).filter((item) -> item.contains("A")).forEach((item) -> System.out.println(item));
    }
}
