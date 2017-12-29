package section2.quiz;

public class CapitalizeFirstLetter {

    public static void main(String[] args) {

        String lowercaseString = "this is a very long lower case string";

        if (lowercaseString.length() > 0) {
            lowercaseString = Character.toUpperCase(lowercaseString.charAt(0)) + lowercaseString.substring(1, lowercaseString.length());
        }
        System.out.println(lowercaseString);
    }
}
