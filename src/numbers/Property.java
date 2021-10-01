package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Property {

    String property;

    // Prints all properties by two numbers entered
    public static void twoNumbersProp(long a, long b) {

        for (long i = a; i < (a + b); i++) {
            printProperties(i);

        }
    }

    // Prints properties
    public static void printProperties(long i) {
        String even = "";
        String odd = "";
        String buzz = "";
        String duck = "";
        String palindrom = "";
        String gap = "";
        String spy = "";
        String sunny = "";
        String square = "";
        String jumping = "";
        String happy = "";
        String sad = "";

        if (Numbers.evenOdd(i)) {
            even = ",even";
        }

        if (!Numbers.evenOdd(i)) {
            odd = ",odd";
        }
        if (Numbers.buzzNumber(i)) {
            buzz = ",buzz";
        }

        if (Numbers.duckOrNot(i)) {
            duck = ",duck";
        }

        if (Numbers.palindrom(i)) {
            palindrom = ",palindrom";
        }

        if (Numbers.gapfullOrnot(i)) {
            gap = ",gapful";
        }

        if (Numbers.spyOrNot(i)) {
            spy = ",spy";
        }
        if (Numbers.isItSunny(i)) {
            sunny = ",sunny";
        }
        if (Numbers.isItPerfectSquare(i)) {
            square = ",square";
        }

        if (Numbers.isItJumping(i)) {
            jumping = ",jumping";
        }

        if (Numbers.isItHappy(i)) {
            happy = ",happy";
        }

        if (!Numbers.isItHappy(i)) {
            sad = ",sad";
        }


        String output = i + " is " + even + odd + buzz + duck + palindrom + gap + spy + sunny + square + jumping + happy + sad;
        String newO = output.replaceFirst(",", "");

        System.out.println(newO);
    }

    // Return a list of legal properties
    public static ArrayList<String> listOfProperties() {
        ArrayList<String> list = new ArrayList<>();
        String[] properties = {"buzz", "duck", "palindromic", "gapful", "spy", "even", "odd", "sunny", "square", "jumping", "happy", "sad",
                "-buzz", "-duck", "-palindromic", "-gapful", "-spy", "-even", "-odd", "-sunny", "-square", "-jumping", "-happy", "-sad"};

        list.addAll(Arrays.asList(properties));

        return list;


    }

    // This method filters two numbers by sinlge property
    public static void filterByPropery(long a, long b, String property) {

        for (long i = a; i < (a + b); i++) {
            // if we want to exclude property from our list of numbers.
            if (property.startsWith("-")) {

                if (!isItProperty(i, property.substring(1))) {

                    printProperties(i);

                } else {
                    b++;
                }
            } else if (isItProperty(i, property)) {

                printProperties(i);
            } else {
                b++;
            }
        }
    }

    // Property check by single number
    public static boolean isItProperty(long number, String property) {


        if (property.equalsIgnoreCase("buzz")) {
            return Numbers.buzzNumber(number);
        }
        if (property.equalsIgnoreCase("duck")) {
            return Numbers.duckOrNot(number);
        }
        if (property.equalsIgnoreCase("palindromic")) {
            return Numbers.palindrom(number);
        }

        if (property.equalsIgnoreCase("gapful")) {
            return Numbers.gapfullOrnot(number);
        }

        if (property.equalsIgnoreCase("spy")) {

            return Numbers.spyOrNot(number);
        }

        if (property.equalsIgnoreCase("even")) {
            return Numbers.evenOdd(number);
        }

        if (property.equalsIgnoreCase("odd")) {
            return !Numbers.evenOdd(number);
        }

        if (property.equalsIgnoreCase("square")) {
            return Numbers.isItPerfectSquare(number);
        }

        if (property.equalsIgnoreCase("sunny")) {
            return Numbers.isItSunny(number);
        }

        if (property.equalsIgnoreCase("jumping")) {
            return Numbers.isItJumping(number);
        }

        if (property.equalsIgnoreCase("happy")) {
            return Numbers.isItHappy(number);
        }

        if (property.equalsIgnoreCase("sad")) {
            return !Numbers.isItHappy(number);
        }

        return false;
    }

    // The method tells us which properties are wrong
    public static ArrayList<String> whichPropertiesAreWrong(ArrayList<String> list) {
        ArrayList<String> listOfWrongProp = new ArrayList<>();

        for (String s : list) {

            if (!(listOfProperties().contains(s.toLowerCase()))) {
                listOfWrongProp.add(s);
            }
        }

        return listOfWrongProp;
    }

    // Prints multiple numbers and their related properties according to user parameters
    public static void multipleFilterByProperty(long a, long b, ArrayList<String> list) {

        int helper;
        for (long i = a; i < (a + b); i++) {
            helper = 0;
            for (String s : list) {
                if (s.startsWith("-") && (!isItProperty(i, s.substring(1)))) {
                    helper++;
                } else if (isItProperty(i, s)) {

                    helper++;
                }
            }
            if (helper == list.size()) {

                printProperties(i);
            } else {
                b++;
            }


        }
    }

    //Prints properties by input number
    public static void getPropertiesSingeNumber(long number) {

        System.out.println("Properties of " + number);
        System.out.println("         even: " + Numbers.evenOdd(number));
        System.out.println("         odd: " + !Numbers.evenOdd(number));
        System.out.println("         buzz: " + Numbers.buzzNumber(number));
        System.out.println("         duck: " + Numbers.duckOrNot(number));
        System.out.println("         palindromic: " + Numbers.palindrom(number));
        System.out.println("         gapful: " + Numbers.gapfullOrnot(number));
        System.out.println("         spy: " + Numbers.spyOrNot(number));
        System.out.println("         square: " + Numbers.isItPerfectSquare(number));
        System.out.println("         sunny: " + Numbers.isItSunny(number));
        System.out.println("         jumping: " + Numbers.isItJumping(number));
        System.out.println("         happy: " + Numbers.isItHappy(number));
        System.out.println("         sad: " + !Numbers.isItHappy(number));
    }

    // Checks if there are duplicate properties entered
    public static <T> boolean hasDuplicate(ArrayList<String> allProperties) {
        Set<String> set = new HashSet<>();
        // Set#add returns false if the set does not change, which
        // indicates that a duplicate element has been added.
        for (String each : allProperties) if (!set.add(each)) return true;
        return false;
    }

}
