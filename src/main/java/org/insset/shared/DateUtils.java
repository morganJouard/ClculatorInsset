package org.insset.shared;

import java.util.TreeMap;

public class DateUtils {
    public final static TreeMap<Integer, String> mapIntToRoman = new TreeMap<Integer, String>() {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    public final static TreeMap<Character, Integer> mapRomanToInt = new TreeMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int[] convertDateStringToIntArray(String dateStr) throws IllegalArgumentException {
        String[] date = dateStr.split("/");

        if (date.length != 3) {
            throw new IllegalArgumentException("Invalid date format.");
        }

        int[] result = new int[]{0, 0, 0};

        for (int dateIndex = 0; dateIndex < date.length; dateIndex++) {
            result[dateIndex] = Integer.parseInt(date[dateIndex]);
        }

        return result;
    }
}
