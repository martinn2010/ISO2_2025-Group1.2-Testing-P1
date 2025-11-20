package app;

import domain.InvalidDateException;
import domain.LeapYearCalculator;
import domain.MyDate;
import ui.ConsoleReader;
import ui.ConsoleWriter;
import ui.InvalidUserInputException;

public class LeapYearApp {

    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();

        try {
            // El usuario introduce una fecha tipo 2024-02-29 en una línea
            MyDate date = reader.readDate();

            boolean isLeap = LeapYearCalculator.isLeapYear(date);

            if (isLeap) {
                writer.printLine("LEAP");
            } else {
                writer.printLine("NO_LEAP");
            }

        } catch (InvalidUserInputException e) {
            writer.printLine("INPUT_ERROR: " + e.getMessage());
        } catch (InvalidDateException e) {
            writer.printLine("DATE_ERROR: " + e.getMessage());
        }
    }
}
