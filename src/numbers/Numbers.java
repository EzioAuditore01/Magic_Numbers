package numbers;

import java.util.HashSet;
import java.util.Set;

public class Numbers {

    private static Numbers instance = new Numbers();

    private Numbers() {
    }

    public static Numbers getInstance() {
        return instance;
    }

    // Checking if the number is jumping or not - A number is called as a Jumping Number if all adjacent digits in it differ by 1 1234 or 4321
    public static boolean isJumping(long number) {
        String numConverted = String.valueOf(number);

        for (int i = 0; i < numConverted.length() - 1; i++) {
            if (Math.abs((int) numConverted.charAt(i) - (int) numConverted.charAt(i + 1)) != 1) {
                return false;
            }
        }
        return true;

    }

    // if the number next to the given number is a perfect square  80+1=81,square is 9
    public static boolean isSunny(long number) {
        return isPerfectSquare(number + 1);
    }

    // Check if the number is perfect square
    public static boolean isPerfectSquare(long number) {
        int square = ((int) Math.sqrt(number));
        return ((long) square * square == number);

    }

    //Check if the number is spy or not (sum of digits =  product of digits)
    //Sum=1+1+2+4=8
    //Product=1*1*2*4=8
    public static boolean isSpy(long number) {
        int sumOfDigits = 0;
        int prodOfDigits = 1;

        String numCon = String.valueOf(number);

        for (int i = 0; i < numCon.length(); i++) {
            sumOfDigits = sumOfDigits + Character.getNumericValue(numCon.charAt(i));
            prodOfDigits = prodOfDigits * Character.getNumericValue(numCon.charAt(i));
        }

        return sumOfDigits == prodOfDigits;
    }

    //Check if the number is buzz or not - Buzz number is another special number in Java that ends with digit 7 or divisible by 7
    public static boolean isBuzz(long number) {
        String exp = String.valueOf(number);
        char last = exp.charAt(exp.length() - 1);
        return number % 7 == 0 || last == '7';

    }

    //Check if the number is even or odd
    public static boolean evenOdd(long number) {
        return number % 2 == 0;
    }


    //Check if the number is palindrom or not - A palindromic number is a number that remains the same when its digits are reversed
    public static boolean isPalindrom(long number) {
        String numConverted = String.valueOf(number);
        int tracker = numConverted.length() - 1; // Used for reverse indexing

        for (int i = 0; i < numConverted.length() / 2; i++) {
            if (numConverted.charAt(i) != numConverted.charAt(tracker)) {

                return false;
            }
            tracker--;
        }

        return true;
    }

    //Check if the number is gapful or not - Gapful Number is a number N of at least 3 digits such that it is divisible by the concatenation of it’s first and last digit.
    public static boolean isGapful(long number) {

        String numConverted = String.valueOf(number);
        String firstAndLast = numConverted.charAt(0) + "" + numConverted.charAt(numConverted.length() - 1);

        int firstAndLastConv = Integer.parseInt(firstAndLast);

        return numConverted.length() >= 3 && number % firstAndLastConv == 0;
    }

    //Check if the number is duck or not - A Duck number is a positive number which has zeroes present in it,035 not but 1203  has a non leading zero
    public static boolean isDuck(long number) {
        String exp = String.valueOf(number);
        char first = exp.charAt(0);

        int count = 0;

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == 0) {
                count++;
            }
        }

        if (number > 0) {
            return (exp.contains("0") && first != '0') || (first == '0' && count > 2);

        }
        return false;


    }

    // For example, 13 is a happy number, as 1'2 + 3'2 = 10 which leads to 1'2 + 0'2 = 1
    public static boolean isHappy(long number) {
        String numConverted = String.valueOf(number);
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        while (true) {
            for (int i = 0; i < numConverted.length(); i++) {
                sum = (int) (sum + Math.pow(Character.getNumericValue(numConverted.charAt(i)), 2));
            }
            if (sum == 1) {
                return true;
            }
            if (!set.add(sum)) return false;
            numConverted = String.valueOf(sum);
            sum = 0;
        }
    }
}
