package section12;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        class TimeZone {

            public String region;

            public String specificArea;

            public TimeZone(String nonFormattedTimeZone) {
                String[] items = nonFormattedTimeZone.split("/");
                region = items[0];
                if (items.length > 1) {
                    specificArea = items[1];
                }
            }

            @Override
            public String toString() {
                return specificArea;
            }
        }

        LocalTime localTime = LocalTime.of(5, 10);
        System.out.println(localTime);
        localTime = localTime.minus(1, ChronoUnit.HOURS);
        System.out.println(localTime);

        LocalDate localDate = LocalDate.of(2015, Month.MAY, 20);
        System.out.println(localDate);
        localDate = localDate.plusDays(1);
        System.out.println(localDate);
        localDate = localDate.plusDays(11);
        System.out.println(localDate);

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);
        localDateTime = localDateTime.plusMinutes(10);
        System.out.println(localDateTime);

        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
//        zoneIds.stream()
//                .sorted()
//                .forEach((zoneId) -> System.out.println(zoneId));
        Map<String, List<TimeZone>> timeZoneMap = zoneIds.stream()
                .map((timeZone) -> new TimeZone(timeZone))
                .collect(Collectors.groupingBy((formattedTimeZone) -> formattedTimeZone.region));
        timeZoneMap.entrySet().stream()
                .forEach((timeZoneList) -> {
                    System.out.println(timeZoneList.getKey());
                    timeZoneList.getValue()
                            .stream()
                            .sorted((a, b) -> a.region.compareTo(b.region))
                            .forEach((timeZone) -> {
                                System.out.println(timeZone.specificArea);
                            });
                    System.out.println("-------");
                });

        System.out.println(timeZoneMap);

        ZonedDateTime losAngeles = ZonedDateTime.of(localDateTime, ZoneId.of("America/Los_Angeles"));
        System.out.println(losAngeles);
        long secondsFromEpoch = losAngeles.toEpochSecond();
        LocalDateTime berlinDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(secondsFromEpoch), ZoneId.of("Europe/Rome"));
        System.out.println(berlinDateTime);

        Period period = Period.between(localDateTime.toLocalDate(), localDateTime.toLocalDate().plusDays(10));
        System.out.println(period.getDays());

        Duration duration = Duration.between(localDateTime, localDateTime.plusHours(2));
        System.out.println(duration.getSeconds());

        String formattedDateTime = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(formattedDateTime);
        formattedDateTime = localDateTime.format(DateTimeFormatter.ISO_TIME);
        System.out.println(formattedDateTime);
        formattedDateTime = localDateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(formattedDateTime);
    }
}
