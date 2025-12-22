package domain;

public class MyDate {

    private final int year;
    private final int month;
    private final int day;

    public MyDate(int year, int month, int day) throws InvalidDateException {
        validate(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private void validate(int year, int month, int day) throws InvalidDateException {
        validateYear(year);
        validateMonth(month);
        validateDay(year, month, day);
    }

    private void validateYear(int year) throws InvalidDateException {
        if (year < 0) {
            throw new InvalidDateException("Year cannot be negative: " + year);
        }
    }

    private void validateMonth(int month) throws InvalidDateException {
        if (month < 1 || month > 12) {
            throw new InvalidDateException("Month must be between 1 and 12: " + month);
        }
    }

    private void validateDay(int year, int month, int day) throws InvalidDateException {
        int maxDay = daysInMonth(year, month);

        if (day < 1 || day > maxDay) {
            throw new InvalidDateException(
                "Day " + day + " is not valid for month " + month + " and year " + year
            );
        }
    }

    private int daysInMonth(int year, int month) {
        int days;

        if (month == 2) {
            if (LeapYearCalculator.isLeapYear(year)) {
                days = 29;
            } else {
                days = 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else {
            days = 31;
        }

        return days;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        String m = month < 10 ? "0" + month : String.valueOf(month);
        String d = day   < 10 ? "0" + day   : String.valueOf(day);
        return year + "-" + m + "-" + d;
    }
}
