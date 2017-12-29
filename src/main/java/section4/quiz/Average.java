package section4.quiz;

public class Average {

    public static double average(double... doubles) {
        double sum = 0;
        for (double doubleNum : doubles) {
            sum += doubleNum;
        }
        return sum / doubles.length;
    }

    public static void main(String[] args) {

        double[] doubles = {10.0, 11.2, 4.4, 3.7, 22.4};
        System.out.println(average(doubles));
    }
}
