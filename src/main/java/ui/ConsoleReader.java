package ui;

import domain.InvalidDateException;
import domain.MyDate;

import java.util.Scanner;

public class ConsoleReader {

    private final Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public int readInt() throws InvalidUserInputException {
        int value;
        String line;

        line = scanner.nextLine();

        try {
            value = Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            throw new InvalidUserInputException("Input is not a valid integer: \"" + line + "\"", e);
        }

        return value;
    }

    public double readDouble() throws InvalidUserInputException {
        double value;
        String line;

        line = scanner.nextLine();

        try {
            value = Double.parseDouble(line.trim());
        } catch (NumberFormatException e) {
            throw new InvalidUserInputException("Input is not a valid double: \"" + line + "\"", e);
        }

        return value;
    }

    public String readString() {
        String line;
        line = scanner.nextLine();
        return line;
    }

    public MyDate readDate() throws InvalidUserInputException, InvalidDateException {
        MyDate date;
        String line;

        line = scanner.nextLine().trim();

        String[] parts = line.split("-");

        if (parts.length != 3) {
            throw new InvalidUserInputException(
                "Date must be in format YYYY-MM-DD. Provided: \"" + line + "\""
            );
        }

        int year;
        int month;
        int day;

        try {
            year = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            day = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new InvalidUserInputException("Date contains non-numeric values: \"" + line + "\"", e);
        }

        date = new MyDate(year, month, day);

        return date;
    }
}
