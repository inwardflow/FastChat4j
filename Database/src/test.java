import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String dateString = "2023年7月13日";

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy[年][.]")
                .appendPattern("M[月][.]")
                .appendPattern("d[日]")
                .toFormatter();

        try {
            LocalDate date = LocalDate.parse(dateString, formatter);
            String mysqlDatetime = date.toString();

            System.out.println("MySQL Datetime: " + mysqlDatetime);
        } catch (DateTimeParseException e) {
            System.out.println("无效的日期。");
        }
    }
}
