package section11.quiz;

import java.io.*;
import java.util.ArrayList;

public class WriteNumbersToFile {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            integers.add((int) (Math.random() * 100));
        }

        String content = "";
        for (Integer number: integers) {
            content += number + "\n";
        }

        File writeNumbersToFile = new File("writeNumbersToFile.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(writeNumbersToFile)){
            fileOutputStream.write(content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("writeNumbersToFileWithBufferedReader.txt"))){
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
