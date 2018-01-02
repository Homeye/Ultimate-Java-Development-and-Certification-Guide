package section12.quiz;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeQuiz {

    public static LocalDateTime convertTimeToNewYork(LocalDateTime localDateTime) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/New_York"));
        return zonedDateTime.toLocalDateTime();
    }

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate futureDate = localDate.plusYears(1000);
        System.out.println(futureDate);
        System.out.println(futureDate.getDayOfWeek());

        LocalDateTime localDateTime = LocalDateTime.now();

        ZonedDateTime losAngeles = ZonedDateTime.of(localDateTime, ZoneId.of("America/Los_Angeles"));
        ZonedDateTime newYork = ZonedDateTime.of(losAngeles.toLocalDateTime(), ZoneId.of("America/New_York"));
        System.out.println(losAngeles);
        System.out.println(newYork);

        System.out.println("-------");

        LocalDateTime losAngelesDateTime = losAngeles.toLocalDateTime();

        System.out.println(convertTimeToNewYork(losAngelesDateTime));
    }
}
