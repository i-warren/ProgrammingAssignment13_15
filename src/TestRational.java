import java.math.BigInteger;
import java.util.Scanner;

/**
 * Program prompts user to enter two rational numbers.
 * These numbers are added, subtracted, multiplied and divided.
 * They are also compared using equals() and comparedTo()
 * @author Isaac Warren
 */

public class TestRational {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create Scanner object

        //Prompt user to enter a rational number. Store numerator and Denominator
        System.out.print("Enter the first rational number (num denom): ");
        BigInteger numerator = input.nextBigInteger();
        BigInteger denominator = input.nextBigInteger();

        // Create first Rational object
        Rational rational1 = new Rational(numerator, denominator);

        //Prompt user to enter a rational number. Store numerator and Denominator
        System.out.print("Enter the second rational number  (num denom): ");
        numerator = input.nextBigInteger();
        denominator = input.nextBigInteger();

        // Create second Rational object
        Rational rational2 = new Rational(numerator, denominator);

        // Print output of operations
        System.out.println(rational1 + " + " +
                rational2 + " = " +
                (rational1.add(rational2)));

        System.out.println(rational1 + " - " +
                rational2 + " = " +
                (rational1.subtract(rational2)));

        System.out.println(rational1 + " * " +
                rational2 + " = " +
                (rational1.multiply(rational2)));

        System.out.println(rational1 + " / " +
                rational2 + " = " +
                (rational1.divide(rational2)));

        System.out.println(rational2 + " is " +
                rational2.doubleValue());

        System.out.println(rational1 + " equals " +
                rational2 + ": " +
                rational1.equals(rational2));

        System.out.println(rational1 + " compared to " +
                rational2 + ": " +
                rational1.compareTo(rational2));

    }
}
