package org.insset.shared;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    public static boolean isValidDiviseur(Integer nbr) {
        if (nbr == null) {
            return false;
        }
        return true;
    }
    public static boolean isValidDividende(Integer nbr) {
        if ((nbr == null) || (nbr == 0)) {
            return false;
        }
        return true;
    }
    
    public static boolean isValidMontant(Integer nbr) {
        if (nbr == null || nbr < 0) {
            return false;
        }
        return true;
    }
    public static boolean isValidPourcent(Integer nbr) {
        if ((nbr == null) || (nbr < 0)|| (nbr > 100)) {
            return false;
        }
        return true;
    }
    
    public static boolean isValidDecimal(Integer nbr) {
        try {
            Integer.parseInt(String.valueOf(nbr));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static final String[] ROMAINS_UNITE = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] ROMAINS_DIZAINE = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ROMAINS_CENTENAIRE = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] ROMAINS_MILLENAIRE = {"", "M", "MM", "MMM"};

    public static boolean isValidRoman(String nbr) {
    for (int i = 0; i < ROMAINS_MILLENAIRE.length; i++) {
        for (int j = 0; j < ROMAINS_CENTENAIRE.length; j++) {
            for (int k = 0; k < ROMAINS_DIZAINE.length; k++) {
                for (int l = 0; l < ROMAINS_UNITE.length; l++) {
                                        String romanNumber = ROMAINS_MILLENAIRE[i] + ROMAINS_CENTENAIRE[j] + ROMAINS_DIZAINE[k] + ROMAINS_UNITE[l];
                    if (nbr.equals(romanNumber)) {
                        return true;
                    }
                }
            }
        }
    }
    return false;
                
    }
    
    public static boolean isValidDate(int jour, int mois, int annee) {
        if (annee < 1 || mois < 1 || mois > 12) {
            return false;
        }

        int[] joursParMois = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (mois == 2 && (annee % 4 == 0 && (annee % 100 != 0 || annee % 400 == 0))) {
            joursParMois[2] = 29; // Février en année bissextile
        }

        return jour >= 1 && jour <= joursParMois[mois];
    }
}
