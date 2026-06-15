import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    static void checkDifference(LocalDate d1, LocalDate d2) {

        if (d1.isAfter(d2)) {
            LocalDate temp = d1;
            d1 = d2;
            d2 = temp;
        }

        if (d1.plusMonths(1).equals(d2)) {
            System.out.println("Exactly 1 month apart");
        } else if (d2.isBefore(d1.plusMonths(1))) {
            System.out.println("Less than 1 month apart");
        } else {
            System.out.println("More than 1 month apart");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MM yyyy");

        System.out.print("Enter first date (dd MM yyyy): ");
        String date1 = sc.nextLine();

        System.out.print("Enter second date (dd MM yyyy): ");
        String date2 = sc.nextLine();

        LocalDate d1 = LocalDate.parse(date1, formatter);
        LocalDate d2 = LocalDate.parse(date2, formatter);

        checkDifference(d1, d2);

        sc.close();
    }
}
