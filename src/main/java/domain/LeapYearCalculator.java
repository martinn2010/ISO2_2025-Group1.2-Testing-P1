package domain;
public final class LeapYearCalculator {

    private LeapYearCalculator() {
    }

    public static boolean isLeapYear(MyDate date) {
        boolean result;
        int year = date.getYear();

        result = isLeapYear(year);

        return result;
    }

    public static boolean isLeapYear(int year) {
        boolean isLeap;

        if (year % 400 == 0) {
            isLeap = true;
        } else if (year % 100 == 0) {
            isLeap = false;
        } else if (year % 4 == 0) {
            isLeap = true;
        } else {
            isLeap = false;
        }

        return isLeap;
    }
}
