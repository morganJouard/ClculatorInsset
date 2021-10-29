package org.insset.shared;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> packing because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is note translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

    /**
     * Verifies that the specified name is valid for our service.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param name the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidName(String name) {
        if ((name == null) || (name.isEmpty())) {
            return false;
        }
        return true;
    }

    /**
     * Verifies that the specified value is valide.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param name the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidDecimal(Integer nbr) {
        return nbr >= 1 && nbr <= 2000;
    }

    public static boolean isValidRoman(String nbr) {
        int nbrLength = nbr.length();

        if (nbrLength == 0 || (nbr.contains("MM") && nbrLength > 2)) {
            return false;
        }

        for (int charPosition = 0; charPosition < nbrLength; charPosition++) {
            if (!DateUtils.mapRomanToInt.containsKey(nbr.charAt(charPosition))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidDate(String dateStr) {
        int[] date;

        try {
            date = DateUtils.convertDateStringToIntArray(dateStr);
        }
        catch (Exception e) {
            return false;
        }

        return date.length == 3 && date[0] >= 1 && date[0] <= 31 && date[1] >= 1 && date[1] <= 12 && date[2] >= 0 && date[2] <= 2000;
    }

    public static boolean isValidEnteredPrice(int price) {
        return price >= 0 && price <= 10000;
    }

    public static boolean isValidPercentage(int percentage) {
        return percentage > 0 && percentage <= 100;

    }

    public static boolean isValidDivisionOperands(int dividend, int diviser) {
        return dividend >= 0 && dividend <= 10000 & diviser > 0 && diviser <= 10000;
    }
}
