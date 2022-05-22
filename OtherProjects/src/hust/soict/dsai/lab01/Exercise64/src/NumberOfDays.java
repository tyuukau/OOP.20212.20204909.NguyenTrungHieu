import java.util.*;
// Exercise 6.4
public class NumberOfDays {

    static List<String> monthName = new ArrayList<>(Arrays.asList("jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec",
            "january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december",
            "jan.", "feb.", "mar.", "apr.", "may", "june", "july", "aug.", "sep.", "oct.", "nov.", "dec.",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));

    public static void main(String[] args) {
        boolean valid = true;
        do {
            valid = true;
            Scanner input = new Scanner(System.in);
            System.out.println("Which year?");
            String inputYear = input.nextLine();
            System.out.println("Which month?");
            String inputMonth = input.nextLine().toLowerCase();

            if (validInput(inputYear, inputMonth)) {
                int year = Integer.valueOf(inputYear);
                int month = monthIndex(inputMonth);
                System.out.println("Number of days: " + daysOfMonth(year, month));
            } else {
                System.out.println("Enter valid month and year!");
                valid = false;
            }
        } while (valid == false);
    }

    public static boolean validInput(String inputYear, String inputMonth) {
        return isInteger(inputYear) && monthIndex(inputMonth) > 0;
    }

    public static boolean isInteger(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static int monthIndex(String inputMonth) {
        return monthName.indexOf(inputMonth) % 12 + 1;
    }

    public static int daysOfMonth(int year, int month) {
        int[] normYearMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapYearMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leapYear = ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0);
        int days = leapYear ? leapYearMonth[month - 1] : normYearMonth[month - 1];
        return days;
    }
}