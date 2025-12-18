package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyDateTest {

    // --- EACH USE TEST CASES (del PDF) ---

    @Test
    void invalidYear_negative() {
        assertThrows(InvalidDateException.class, () -> new MyDate(-1, 1, 1));
    }

    @Test
    void validLeapYearDate() throws Exception {
        MyDate d = new MyDate(0, 2, 29);
        assertEquals(0, d.getYear());
    }

    @Test
    void invalidMonthTooHigh() {
        assertThrows(InvalidDateException.class, () -> new MyDate(1, 13, 1));
    }

    @Test
    void invalidDayForMonth() {
        assertThrows(InvalidDateException.class, () -> new MyDate(1, 12, 32));
    }

    @Test
    void validNonLeapDate() throws Exception {
        MyDate d = new MyDate(2023, 1, 31);
        assertEquals(2023, d.getYear());
    }

    @Test
    void february29_nonLeapYear_invalid() {
        assertThrows(InvalidDateException.class, () -> new MyDate(2023, 2, 29));
    }
    @Test
    void february28_nonLeapYear_valid() throws Exception {
        MyDate d = new MyDate(2023, 2, 28);
        assertEquals(28, d.getDay());
    }
    @Test
    void april30_valid() throws Exception {
        MyDate d = new MyDate(2024, 4, 30);
        assertEquals(30, d.getDay());
    }
    @Test
    void january31_valid() throws Exception {
        MyDate d = new MyDate(2024, 1, 31);
        assertEquals(31, d.getDay());
    }
    @Test
    void invalidMonthZero() {
        assertThrows(InvalidDateException.class, () -> {
            new MyDate(2024, 0, 10);
        });
    }
    @Test
    void invalidDayZero() {
        assertThrows(InvalidDateException.class, () -> {
            new MyDate(2024, 1, 0);
        });
    }
    @Test
    void toString_withLeadingZeros() throws Exception {
        MyDate d = new MyDate(2024, 2, 3);
        assertEquals("2024-02-03", d.toString());
    }
    @Test
    void toString_withoutLeadingZeros() throws Exception {
        MyDate d = new MyDate(2024, 11, 13);
        assertEquals("2024-11-13", d.toString());
    }



    @Test
    void february29_leapYear_valid() throws Exception {
        MyDate d = new MyDate(2024, 2, 29);
        assertEquals(29, d.getDay());
    }

    // Continúa con los demás Each-Use si quieres subir + cobertura
}
