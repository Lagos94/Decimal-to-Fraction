/*By Juan Lagos
* CSC 201
* Professor Tanes Kanchanawanchai
* Assignment 13 Chapter 13
* Decimals to fractions!
* Due Date: 11/12/17*/

import java.math.BigInteger;
import java.util.Scanner;

public class Dec2Frac {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        while (input.hasNextDouble()) {
            Double entry = input.nextDouble();
            System.out.print("The Fraction number is "+dec2frac(entry));
            System.out.print("\nEnter another value (or press Ctrl+D to end): ");
        }
    }

    public static String dec2frac(double decimal) {
        int decimalDigits = String.valueOf(decimal).length() - String.valueOf(decimal).indexOf('.') + 1; // Count the digits after the decimal point // for example 0.75 has two digits
        BigInteger numerator = BigInteger.valueOf((long) (decimal * Math.pow(10, decimalDigits))); // multiply the given decimal value with 10 to the power of however many digits after decimal point.
        BigInteger denominator = BigInteger.valueOf((long) (Math.pow(10, decimalDigits)));       // 10 to the power of the number of digits after decimal is the denominator
        int gcd = numerator.gcd(denominator).intValue();                                           // calculate the greatest common divisor of both denominator & numerator
        if (gcd > 1) {                                                                             // for example: gcd(25,100) = 25
            return String.valueOf(numerator.intValue() / gcd) + " / " + String.valueOf(denominator.intValue() / gcd);  // return (25/25) / (100/25) = 1/4
        } else {
            return String.valueOf(numerator) + " / " + String.valueOf(denominator);              // if gcd = 1 which means nothing to simplify just return numerator / denominator
        }
    }
}