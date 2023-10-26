/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

/**
 *
 * @author insset
 */
public class DateToRomainServiceImpl {

    private static final String[] ROMAINS_UNITE = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] ROMAINS_DIZAINE = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ROMAINS_CENTENAIRE = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] ROMAINS_MILLENAIRE = {"", "M", "MM", "MMM"};

    public static String dateToRomain(String date) {
        String[] parts = date.split("/");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Le format de date doit être jour/mois/année.");
        }

        int jour = Integer.parseInt(parts[0]);
        int mois = Integer.parseInt(parts[1]);
        int annee = Integer.parseInt(parts[2]);

        if (!isValidDate(jour, mois, annee)) {
            throw new IllegalArgumentException("La date n'est pas valide.");
        }

        String jourRomain = convertToRoman(jour);
        String moisRomain = convertToRoman(mois);
        String anneeRomain = convertToRoman(annee);

        return jourRomain + "/" + moisRomain + "/" + anneeRomain;
    }

    private static String convertToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("Le nombre doit être compris entre 1 et 3999.");
        }

        return ROMAINS_MILLENAIRE[num / 1000] +
               ROMAINS_CENTENAIRE[(num % 1000) / 100] +
               ROMAINS_DIZAINE[(num % 100) / 10] +
               ROMAINS_UNITE[num % 10];
    }

    private static boolean isValidDate(int jour, int mois, int annee) {
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
