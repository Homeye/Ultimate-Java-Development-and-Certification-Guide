package section7;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList objects = new ArrayList<>();
        objects.add("Hello");
        objects.add("Willy");
        objects.add("Joey");
        objects.add(1);
        objects.add(new Thread());
        for (Object object : objects) {
            System.out.println(object);
        }

        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("Willy");
        strings.add("Joey");
        strings.add("Sammy");
        Collections.sort(strings);
        for (String string : strings) {
            System.out.println(string);
        }

        System.out.println("-------");

        OracleArrayList<String> stringOracleArrayList = new OracleArrayList<>();
        for (int i = 0; i < 10; i++) {
            stringOracleArrayList.add("String " + Integer.toString(i));
        }
        for (int i = 0; i < stringOracleArrayList.size(); i++) {
            System.out.println(stringOracleArrayList.get(i));
        }

        OracleArrayList<Integer> integerOracleArrayList = new OracleArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerOracleArrayList.add(i);
        }
        for (int i = 0; i < integerOracleArrayList.size(); i++) {
            System.out.println(integerOracleArrayList.get(i));
        }

        System.out.println("-------");

        class Holder<K, V> {
            private K key;

            private V value;

            public Holder(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        ArrayList<Holder<Integer, String>> holderArrayList = new ArrayList<>();
        holderArrayList.add(new Holder<>(10, "Bob"));
        holderArrayList.add(new Holder<>(20, "Willy"));
        holderArrayList.add(new Holder<>(23423423, "Emily"));
        holderArrayList.add(new Holder<>(2123230, "Samantha"));
        for (Holder<Integer, String> holder : holderArrayList) {
            System.out.println(holder.value + " " + holder.key);
        }

        int desiredId = 23423423;
        for (Holder<Integer, String> holder : holderArrayList) {
            if (holder.key == desiredId) {
                System.out.println(holder.value);
                break;
            }
        }

        HashMap<Integer, String> schoolRecords = new HashMap<>();
        schoolRecords.put(10, "Bob");
        schoolRecords.put(20, "Willy");
        schoolRecords.put(23423423, "Emily");
        schoolRecords.put(2123230, "Samantha");
        String studentName = schoolRecords.get(2123230);
//        String studentName = schoolRecords.get(2123230000);
        if (studentName != null) {
            System.out.println(studentName);
        } else {
            System.out.println("We couldn't find a student for that id.");
        }

        System.out.println("-------");

        OracleHashMap<Integer, String> stringOracleHashMap = new OracleHashMap<>(new OracleHashMap.HashProvider<Integer>() {
            @Override
            public int getHash(Integer key) {
                return key;
            }
        });
        stringOracleHashMap.put(100, "Sally");
        stringOracleHashMap.put(23, "Willy");
        stringOracleHashMap.put(40, "Joey");
        String result1 = stringOracleHashMap.get(23);
//        String result1 = oracleHashMap.get(101);
        if (result1 != null) {
            System.out.println(result1);
        } else {
            System.out.println("Couldn't find item in hashmap.");
        }

        OracleHashMap<String, Integer> integerOracleHashMap = new OracleHashMap<>(new OracleHashMap.HashProvider<String>() {
            @Override
            public int getHash(String key) {
                int sum = 0;
                for (int i = 0; i < key.length(); i++) {
                    sum += key.charAt(i) * i;
                }
                return sum;
            }
        });
        integerOracleHashMap.put("Sally", 100);
        integerOracleHashMap.put("yllaS", 23);
        integerOracleHashMap.put("Joey", 40);
        int result2 = integerOracleHashMap.get("Sally");
        System.out.println("Id number is: " + result2);

        System.out.println("-------");

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Willy");
        treeSet.add("Joey");
        treeSet.add("Banana");
        System.out.println(treeSet); //Binary Search Tree (O(log(N)))

        Deque<String> deque = new LinkedList<>();
        deque.addFirst("First");
        deque.addLast("Last");
        deque.push("Beginning of array");
        System.out.println(deque);
        deque.pop(); //delete first
        System.out.println(deque);
    }
}
