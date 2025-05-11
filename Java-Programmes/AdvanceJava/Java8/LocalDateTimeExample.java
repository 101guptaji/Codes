import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample {
    static void LocalDataTimeApi(){
        LocalDate date = LocalDate.now();
        System.out.println("Current Date: "+date);

        LocalTime time = LocalTime.now();
        System.out.println("Current Time: "+time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: "+dateTime);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-YYYY hh:mm:ss:a");

        String formatedDateTime = dateTime.format(format);
        System.out.println("Formated Date Time: "+formatedDateTime);

        LocalDate date2 = LocalDate.of(1998, 10, 13);
        System.out.println("Birthday: "+date2);

        // printing date with current time.
        LocalDateTime specificDate = dateTime.withDayOfMonth(07).withMonth(12).withYear(2000);
        System.out.println("Specific date with current time: "+specificDate.format(format));

        // gap
        Period gap = Period.between(date, date2);
        System.out.println("My Age :"+gap);

        LocalTime time2 = LocalTime.of(03, 10, 00);
        Duration timeGap = Duration.between(time2, time);
        System.out.println("TIme gap: " +timeGap);
    }
    public static void main(String[] args) {
        LocalDataTimeApi();
    }
}
