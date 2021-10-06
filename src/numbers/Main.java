package numbers;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//        write your code here
        start();
    }

    //Start method of the program
    private static void start() {
        Property proprty = Property.getInstance();
        Welcome.printInstructions();

        //Main loop - logic
        while (true) {
            System.out.println("Enter a request: >");

            Scanner scan = new Scanner(System.in);

            String number = scan.nextLine();
            String[] parts = number.split(" ");
            long firstNumber = Long.parseLong(parts[0]);

            //IF user inputs 2 numbers user first number and parse second
            if (parts.length == 2) {
                int secondNumber = Integer.parseInt(parts[1]);
                if (secondNumber < 1) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }

                proprty.twoNumbersProp(firstNumber, secondNumber);
                continue;
            }


            //IF user inputs 3 numbers use first number and parse second and use third as String
            if (parts.length == 3) {
                long secondNumber = Long.parseLong(parts[1]);
                String property = parts[2].toLowerCase();


                if (!(proprty.listOfProperties().contains(property))) {
                    System.out.println("The property " + "[" + property + "]" + " is wrong.");
                    System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                } else {

                    proprty.filterByPropery(firstNumber, secondNumber, parts[2].toLowerCase());
                }
                continue;
            }

            if (parts.length > 3) {

                ArrayList<String> propertyList = new ArrayList<>();
                int secondNumber = Integer.parseInt(parts[1]);
                for (int i = 2; i < parts.length; i++) {
                    propertyList.add(parts[i]);

                }


                // Here i am checking if the user has passed 1 or multiple WRONG properties and prints them on screen
                // And informs user about available properties
                // Just like in isItExclusiveModified method this method/logic is used in terms
                // of prevention of code redundancy and large code.(Example commented lines/code above this comment)
                if (proprty.whichPropertiesAreWrong(propertyList).size() > 1) {
                    ArrayList<String> listOfWrongs = proprty.whichPropertiesAreWrong(propertyList);
                    System.out.print("The properties " + "[");
                    for (int i = 0; i < listOfWrongs.size(); i++) {
                        if (i == listOfWrongs.size() - 1) {
                            System.out.print(listOfWrongs.get(i).toUpperCase() + "]" + " are wrong.");
                        } else {
                            System.out.print(listOfWrongs.get(i).toUpperCase() + ", ");
                        }
                    }
                    System.out.println();
                    System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                    continue;

                } else if (proprty.whichPropertiesAreWrong(propertyList).size() == 1) {
                    ArrayList<String> listOfWrongs = proprty.whichPropertiesAreWrong(propertyList);
                    System.out.print("The property " + "[");
                    System.out.print(listOfWrongs.get(0).toUpperCase() + "]" + " is wrong.");
                    System.out.println();
                    System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                    continue;
                }
                // Checking if there are mutually exclusive props.- parts[] are used to include "-" or not
                if (!(ErrorHandler.isItExclusiveModified(propertyList).isEmpty())) {

                    StringBuilder sb = new StringBuilder();
                    for (String prop : ErrorHandler.isItExclusiveModified(propertyList)) {

                        sb.append(prop.toUpperCase() + " ");
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    System.out.println("The request contains mutually exclusive properties: " + "[" + sb + "]");
                    System.out.println("There are no numbers with these properties.");
                    continue;
                }


                proprty.multipleFilterByProperty(firstNumber, secondNumber, propertyList);
                continue;
            }


            //IF user inputs 1 number
            if (firstNumber < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else if (firstNumber == 0) {
                System.out.println("Goodbye!");
                break;
            } else {
                proprty.getPropertiesSingeNumber(firstNumber);

            }
        }

    }


}



