import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TravelPlanner {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static long calculateTripDuration(LocalDate departureDate, LocalDate returnDate) {
        return ChronoUnit.DAYS.between(departureDate, returnDate);
    }

    public static boolean validateTravelDates(LocalDate departureDate, LocalDate returnDate) {
        LocalDate today = LocalDate.now();

        if (departureDate.isBefore(today)) return false;
        if (!returnDate.isAfter(departureDate)) return false;

        long days = calculateTripDuration(departureDate, returnDate);
        if (days > 90) return false;

        return true;
    }

    public static String calculateHotelDates(LocalDate departureDate, LocalDate returnDate) {
        return "Check-in: " + departureDate.format(formatter) +
               " | Check-out: " + returnDate.format(formatter);
    }
    public static boolean tripOverlapsHoliday(LocalDate departureDate, LocalDate returnDate, LocalDate holidayDate) {
        return (holidayDate.isEqual(departureDate) || holidayDate.isEqual(returnDate) ||
               (holidayDate.isAfter(departureDate) && holidayDate.isBefore(returnDate)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LocalDate dep = null, ret = null;

        while (true) {
            System.out.println("\n1.Enter Dates");
            System.out.println("2.Trip Duration");
            System.out.println("3.Validate Dates");
            System.out.println("4.Hotel Dates");
            System.out.println("5.Check Holiday");
            System.out.println("6.Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();
            sc.nextLine();
            try {
                switch (ch) {

                    case 1:
                        System.out.print("Enter departure date (dd/MM/yyyy): ");
                        dep = LocalDate.parse(sc.nextLine(), formatter);

                        System.out.print("Enter return date (dd/MM/yyyy): ");
                        ret = LocalDate.parse(sc.nextLine(), formatter);
                        break;
                    case 2:
                        System.out.println("Duration: " + calculateTripDuration(dep, ret) + " days");
                        break;
                    case 3:
                        if (validateTravelDates(dep, ret))
                            System.out.println("Valid dates!");
                        else
                            System.out.println("Invalid dates!");
                        break;
                    case 4:
                        System.out.println(calculateHotelDates(dep, ret));
                        break;
                    case 5:
                        System.out.print("Enter holiday date (dd/MM/yyyy): ");
                        LocalDate holiday = LocalDate.parse(sc.nextLine(), formatter);

                        if (tripOverlapsHoliday(dep, ret, holiday))
                            System.out.println("Trip overlaps with holiday!");
                        else
                            System.out.println("No overlap.");
                        break;
                    case 6:
                        System.out.println("Exit...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format! Use dd/MM/yyyy");
            } catch (Exception e) {
                System.out.println("Please enter dates first!");
            }
        }
    }
}