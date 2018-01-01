package section11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest {

    public static void testThrow() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("asdasd")));
    }

    public static String readUserData() throws FileNotFoundException, MyUncheckedException, MyCheckedException {
        return null;
    }

    public static void main(String[] args) {

        try {
            testThrow();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String s = null;
            s.length();
        } catch (NullPointerException e) {
            System.out.println("Contents are null!");
        }

        try {
            throw new MyUncheckedException();
        } catch (MyUncheckedException e) {
            e.printStackTrace();
        }

        try {
            throw new MyCheckedException();
        } catch (MyCheckedException e) {
            e.printStackTrace();
        }

        try {
            readUserData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MyCheckedException e) {
            e.printStackTrace();
        } catch (MyUncheckedException e) {
            e.printStackTrace();
        }
    }
}
