package section3.quiz;

public class IsNegative {

    public boolean isNegative(int a) {
        return a < 0;
    }

    public static void main(String[] args) {

        System.out.println(new IsNegative().isNegative(3432));
        System.out.println(new IsNegative().isNegative(0));
        System.out.println(new IsNegative().isNegative(-2));
    }
}
