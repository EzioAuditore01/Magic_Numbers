package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Property {

    private static final Property instance = new Property();

    private Property() {
    }

    public static Property getInstance() {
        return instance;
    }

    Numbers numbrs = Numbers.getInstance();


    // Prints all properties by two numbers entered
    public void twoNumbersProp(long a, long b) {

        for (long i = a; i < (a + b); i++) {
            printProperties(i);

        }
    }

    // Prints properties
    public void printProperties(long i) {
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

        if (numbrs.evenOdd(i)) {
            even = ",even";
        }

        if (!numbrs.evenOdd(i)) {
            odd = ",odd";
        }
        if (numbrs.isBuzz(i)) {
            buzz = ",buzz";
        }

        if (numbrs.isDuck(i)) {
            duck = ",duck";
        }

        if (numbrs.isPalindrom(i)) {
            palindrom = ",palindrom";
        }

        if (numbrs.isGapful(i)) {
            gap = ",gapful";
        }

        if (numbrs.isSpy(i)) {
            spy = ",spy";
        }
        if (numbrs.isSunny(i)) {
            sunny = ",sunny";
        }
        if (numbrs.isPerfectSquare(i)) {
            square = ",square";
        }

        if (numbrs.isJumping(i)) {
            jumping = ",jumping";
        }

        if (numbrs.isHappy(i)) {
            happy = ",happy";
        }

        if (!numbrs.isHappy(i)) {
            sad = ",sad";
        }


        String output = i + " is " + even + odd + buzz + duck + palindrom + gap + spy + sunny + square + jumping + happy + sad;
        String newOutput = output.replaceFirst(",", "");

        System.out.println(newOutput);
    }

        // Return a list of legal properties
        public static ArrayList<String> listOfProperties() {
            ArrayList<String> list = new ArrayList<>();
            String[] properties = {"buzz", "duck", "palindromic", "gapful", "spy", "even", "odd", "sunny", "square", "jumping", "happy", "sad",
                    "-buzz", "-duck", "-palindromic", "-gapful", "-spy", "-even", "-odd", "-sunny", "-square", "-jumping", "-happy", "-sad"};

            list.addAll(Arrays.asList(properties));


        return list;



    }

    // This method filters two numbers by single property
    public void filterByProperty(long a, long b, String property) {

        for (long i = a; i < (a + b); i++) {
            // if we want to exclude property from our list of numbers.
            if (property.startsWith("-")) {

                if (!isProperty(i, property.substring(1))) {

                    printProperties(i);

                } else {
                    b++;
                }
            } else if (isProperty(i, property)) {

                printProperties(i);
            } else {
                b++;
            }
        }
    }

    // Property check by single number
    public boolean isProperty(long number, String property) {

        if (property.equalsIgnoreCase("buzz")) {
            return numbrs.isBuzz(number);
        }
        if (property.equalsIgnoreCase("duck")) {
            return numbrs.isDuck(number);
        }
        if (property.equalsIgnoreCase("palindromic")) {
            return numbrs.isPalindrom(number);
        }

        if (property.equalsIgnoreCase("gapful")) {
            return numbrs.isGapful(number);
        }

        if (property.equalsIgnoreCase("spy")) {

            return numbrs.isSpy(number);
        }

        if (property.equalsIgnoreCase("even")) {
            return numbrs.evenOdd(number);
        }

        if (property.equalsIgnoreCase("odd")) {
            return !numbrs.evenOdd(number);
        }

        if (property.equalsIgnoreCase("square")) {
            return numbrs.isPerfectSquare(number);
        }

        if (property.equalsIgnoreCase("sunny")) {
            return numbrs.isSunny(number);
        }

        if (property.equalsIgnoreCase("jumping")) {
            return numbrs.isJumping(number);
        }

        if (property.equalsIgnoreCase("happy")) {
            return numbrs.isHappy(number);
        }

        if (property.equalsIgnoreCase("sad")) {
            return !numbrs.isHappy(number);
        }

        return false;
    }

    // The method tells us which properties are wrong
    public ArrayList<String> whichPropertiesAreWrong(ArrayList<String> list) {
        ArrayList<String> listOfWrongProp = new ArrayList<>();

        for (String s : list) {
            if (!(listOfProperties().contains(s.toLowerCase()))) {
                listOfWrongProp.add(s);
            }
        }

        return listOfWrongProp;
    }

    // Prints multiple numbers and their related properties according to user parameters
    public void multipleFilterByProperty(long a, long b, ArrayList<String> list) {
        int helper;
        for (long i = a; i < (a + b); i++) {
            helper = 0;
            for (String s : list) {
                if (s.startsWith("-") && (!isProperty(i, s.substring(1)))) {
                    helper++;
                } else if (isProperty(i, s)) {
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
    public void getPropertiesSingeNumber(long number) {

        System.out.println("Properties of " + number);
        System.out.println("         even: " + numbrs.evenOdd(number));
        System.out.println("         odd: " + !numbrs.evenOdd(number));
        System.out.println("         buzz: " + numbrs.isBuzz(number));
        System.out.println("         duck: " + numbrs.isDuck(number));
        System.out.println("         palindromic: " + numbrs.isPalindrom(number));
        System.out.println("         gapful: " + numbrs.isGapful(number));
        System.out.println("         spy: " + numbrs.isSpy(number));
        System.out.println("         square: " + numbrs.isPerfectSquare(number));
        System.out.println("         sunny: " + numbrs.isSunny(number));
        System.out.println("         jumping: " + numbrs.isJumping(number));
        System.out.println("         happy: " + numbrs.isHappy(number));
        System.out.println("         sad: " + !numbrs.isHappy(number));
    }

    // Checks if there are duplicate properties entered
    public <T> boolean hasDuplicate(ArrayList<String> allProperties) {
        Set<String> set = new HashSet<>();
        // Set#add returns false if the set does not change, which
        // indicates that a duplicate element has been added.
        for (String each : allProperties) if (!set.add(each)) return true;
        return false;
    }

}
