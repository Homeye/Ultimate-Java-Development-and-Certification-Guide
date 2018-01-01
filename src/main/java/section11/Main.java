package section11;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String input = scanner.nextLine();
//            System.out.println(input);
//        }

        try {
            String s = null;
            int len = s.length();
        } catch (NullPointerException e) {
            System.out.println("Program crashed!");
        }
        System.out.println("Continue program's execution as normal.");

        File writeTest = new File("writeTest.txt");
        try {
            FileOutputStream out = new FileOutputStream(writeTest);
            out.write("Trololo".getBytes());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File wasn't found! Aborting write!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception. Couldn't finish writing the file!");
        }

        File readTest = new File("readTest.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(readTest));
//            String filecontents = bufferedReader.readLine();
//            filecontents += "\n" +bufferedReader.readLine();
//            System.out.println(filecontents);
            String out = "";
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                out += line + "\n";
            }
            System.out.println(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(readFromFile("readTest.txt"));
        System.out.println(readFromFileBetter("readTest.txt"));

        System.out.println("-------");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("obj.ser")))) {
            objectOutputStream.writeObject(new SimpleObject("these are some random contents", 1, 2, 3));
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("obj.ser")))) {
                SimpleObject data = (SimpleObject) objectInputStream.readObject();
                System.out.println(data.getContents() + " " + data.getX() + " " + data.getY() + " " + data.getZ());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        BufferedReader bufferedReader = null;
        String out = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                out += line + "\n";
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return out;
    }

    public static String readFromFileBetter(String fileName) {
        String out = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                out += line + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }
}
