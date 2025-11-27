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
        System.out.println ("Please introduce a date <YYYY-MM-DD>:");
        try {
            MyDate date = reader.readDate();

            boolean isLeap = LeapYearCalculator.isLeapYear(date);

            if (isLeap) {
                writer.printLine("The year is leap");
            } else {
                writer.printLine("The year is not leap");
            }

        } catch (InvalidUserInputException e) {
            writer.printLine("Error in input: " + e.getMessage());
        } catch (InvalidDateException e) {
            writer.printLine("Error in date: " + e.getMessage());
        }
    }
}
