package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LeapYearCalculatorIntTest {

    // YEAR % 400 == 0 → TRUE
    @Test
    void divisibleBy400() {
        assertTrue(LeapYearCalculator.isLeapYear(2000));
    }

    // YEAR % 100 == 0 → FALSE
    @Test
    void divisibleBy100Not400() {
        assertFalse(LeapYearCalculator.isLeapYear(1900));
    }

    // YEAR % 4 == 0 → TRUE
    @Test
    void divisibleBy4Not100() {
        assertTrue(LeapYearCalculator.isLeapYear(2024));
    }

    // Otherwise → FALSE
    @Test
    void notLeap() {
        assertFalse(LeapYearCalculator.isLeapYear(2023));
    }

    // MC/DC (del PDF)
    @Test
    void mcdc_A_true() {
        assertTrue(LeapYearCalculator.isLeapYear(2000)); // A=1
    }

    @Test
    void mcdc_B_true() {
        assertFalse(LeapYearCalculator.isLeapYear(1900)); // B=1
    }

    @Test
    void mcdc_C_true() {
        assertTrue(LeapYearCalculator.isLeapYear(2024)); // C=1
    }
}
