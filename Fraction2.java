import java.util.InputMismatchException;
import java.util.Scanner;

public class Fraction2 implements Comparable<Fraction2> {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Limit the user to 3 tries for both fraction inputs
        Fraction2 fraction1 = getFraction2FromUser(scanner, "Enter the first fraction (numerator/denominator): ", 3);
        if (fraction1 == null) {
            System.out.println("Too many failed attempts. You are logged out.");
            return; // End the program
        }

        Fraction2 fraction2 = getFraction2FromUser(scanner, "Enter the second fraction (numerator/denominator): ", 3);
        if (fraction2 == null) {
            System.out.println("Too many failed attempts. You are logged out.");
            return; // End the program
        }

        // Compare the two fractions
        int result = fraction1.compareTo(fraction2);
        if (result > 0) {
            System.out.println(fraction1 + " > " + fraction2);
        } else if (result < 0) {
            System.out.println(fraction1 + " < " + fraction2);
        } else {
            System.out.println(fraction1 + " = " + fraction2);
        }

        scanner.close();
    }

    // Method to prompt the user to enter a fraction with a limited number of tries
    public static Fraction2 getFraction2FromUser(Scanner scanner, String prompt, int maxAttempts) {
        int attempts = 0;
        
        while (attempts < maxAttempts) {
            System.out.println(prompt);

            // Get input from the user
            String input = scanner.nextLine().trim();

            try {
                // Split the input based on "/" to get numerator and denominator
                String[] parts = input.split("/");

                if (parts.length != 2) {
                    throw new InputMismatchException("Invalid format. Please enter the fraction as numerator/denominator.");
                }

                // Parse numerator and denominator
                int numerator = Integer.parseInt(parts[0].trim());
                int denominator = Integer.parseInt(parts[1].trim());

                // Check if denominator is zero
                if (denominator == 0) {
                    throw new ArithmeticException("Denominator cannot be zero.");
                }

                // Return a new Fraction2 object
                return new Fraction2(numerator, denominator);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers for the numerator and denominator.");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

            attempts++;
            System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
        }

        // If the user exceeds the max attempts, return null
        return null;
    }

    // Private fields
    private int numerator;
    private int denominator;

    // Constructor for a fraction with numerator and denominator
    public Fraction2(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Constructor for whole numbers (denominator defaults to 1)
    public Fraction2(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    // Getters for numerator and denominator
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Method to compare two fractions (cross multiplication)
    @Override
    public int compareTo(Fraction2 other) {
        int leftSide = this.numerator * other.denominator;
        int rightSide = other.numerator * this.denominator;
        return Integer.compare(leftSide, rightSide); // Using Integer.compare for a cleaner comparison
    }

    // toString method to display fraction in "N/D" format
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
