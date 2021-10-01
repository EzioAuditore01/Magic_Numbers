package numbers;

import java.util.ArrayList;

public class ErrorHandler {

    public static ArrayList<String> isItExclusiveModified(ArrayList<String> list) {
        ArrayList<String> listOfExclusives = new ArrayList<>();

        if (list.contains("even") && list.contains("odd")) {
            listOfExclusives.add("even");
            listOfExclusives.add("odd");
        }

        if (list.contains("even") && list.contains("-even")) {
            listOfExclusives.add("even");
            listOfExclusives.add("-even");
        }

        if (list.contains("odd") && list.contains("-odd")) {
            listOfExclusives.add("odd");
            listOfExclusives.add("-odd");
        }


        if (list.contains("-even") && list.contains("-odd")) {
            listOfExclusives.add("-even");
            listOfExclusives.add("-odd");
        }


        if (list.contains("duck") && list.contains("spy")) {
            listOfExclusives.add("duck");
            listOfExclusives.add("spy");
        }

        if (list.contains("-duck") && list.contains("-spy")) {
            listOfExclusives.add("-duck");
            listOfExclusives.add("-spy");
        }

        if (list.contains("duck") && list.contains("-duck")) {
            listOfExclusives.add("duck");
            listOfExclusives.add("-duck");
        }

        if (list.contains("spy") && list.contains("-spy")) {
            listOfExclusives.add("spy");
            listOfExclusives.add("-spy");
        }


        if (list.contains("sunny") && list.contains("square")) {
            listOfExclusives.add("sunny");
            listOfExclusives.add("square");
        }

        if (list.contains("-sunny") && list.contains("-square")) {
            listOfExclusives.add("-sunny");
            listOfExclusives.add("-square");
        }

        if (list.contains("sunny") && list.contains("-sunny")) {
            listOfExclusives.add("sunny");
            listOfExclusives.add("-sunny");
        }

        if (list.contains("square") && list.contains("-square")) {
            listOfExclusives.add("square");
            listOfExclusives.add("-square");
        }


        if (list.contains("happy") && list.contains("sad")) {
            listOfExclusives.add("happy");
            listOfExclusives.add("sad");
        }

        if (list.contains("-happy") && list.contains("-sad")) {
            listOfExclusives.add("-happy");
            listOfExclusives.add("-sad");
        }

        if (list.contains("happy") && list.contains("-happy")) {
            listOfExclusives.add("happy");
            listOfExclusives.add("-happy");
        }

        if (list.contains("sad") && list.contains("-sad")) {
            listOfExclusives.add("sad");
            listOfExclusives.add("-sad");
        }


        return listOfExclusives;
    }
}
