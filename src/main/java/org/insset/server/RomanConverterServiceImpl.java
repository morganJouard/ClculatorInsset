/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.HashMap;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

        private static final String[] ROMAINS_UNITE = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] ROMAINS_DIZAINE = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ROMAINS_CENTENAIRE = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] ROMAINS_MILLENAIRE = {"", "M", "MM", "MMM"};
    
    
    @Override
    public String convertDateYears(String date) throws IllegalArgumentException {
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

    @Override
    public Integer convertRomanToArabe(String nbRoman) throws IllegalArgumentException {
        int result = 0;
        int prevValue = 0;

        // Créez un dictionnaire pour mapper les caractères romains à leurs valeurs
        HashMap<Character, Integer> romanToInteger = new HashMap<>();
        romanToInteger.put('I', 1);
        romanToInteger.put('V', 5);
        romanToInteger.put('X', 10);
        romanToInteger.put('L', 50);
        romanToInteger.put('C', 100);
        romanToInteger.put('D', 500);
        romanToInteger.put('M', 1000);

        // Parcourez la chaîne du nombre romain de droite à gauche
        for (int i = nbRoman.length() - 1; i >= 0; i--) {
            char romanChar = nbRoman.charAt(i);
            int value = romanToInteger.get(romanChar);

            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }

            prevValue = value;
        }

        return result;
    }
    
    @Override
    public String convertArabeToRoman(Integer number) throws IllegalArgumentException {
        if (number < 1 || number > 2000) {
            throw new IllegalArgumentException("le nombre doit etre entre 1 et 2000.");
        }
        
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanSymbols = {"M", "CM", "D","CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder romanNumber = new StringBuilder();
        int i = 0;
        
        while (number > 0) {
            if(number >= values[i]) {
                romanNumber.append(romanSymbols[i]);
                number -= values[i];
            } else {
                i++;
            }
        }
        
        return romanNumber.toString();
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
