package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LeapYearCalculatorMyDateTest {

    @Test
    void isLeapYear_withValidDate_leap() throws Exception {
        MyDate date = new MyDate(2024, 2, 29);
        assertTrue(LeapYearCalculator.isLeapYear(date));
    }

    @Test
    void isLeapYear_withValidDate_notLeap() throws Exception {
        MyDate date = new MyDate(2023, 1, 1);
        assertFalse(LeapYearCalculator.isLeapYear(date));
    }

    @Test
    void isLeapYear_invalidDate_throwsExceptionBeforeCall() {
        assertThrows(InvalidDateException.class, () -> new MyDate(2023, 2, 29));
    }
    @Test
    void constructor_withInvalidYear_throwsException() {
        assertThrows(InvalidDateException.class, () -> {
            new MyDate(-1, 1, 1);
        });
    }
    @Test
    void constructor_withMonthZero_throwsException() {
        assertThrows(InvalidDateException.class, () -> {
            new MyDate(2024, 0, 10);
        });
    }
    @Test
    void constructor_withMonthThirteen_throwsException() {
        assertThrows(InvalidDateException.class, () -> {
            new MyDate(2024, 13, 10);
        });
    }
    @Test
    void constructor_february29_nonLeapYear_throwsException() {
        assertThrows(InvalidDateException.class, () -> {
            new MyDate(2023, 2, 29);
        });
    }
    @Test
    void constructor_day31_inApril_throwsException() {
        assertThrows(InvalidDateException.class, () -> {
            new MyDate(2024, 4, 31);
        });
    }


}
