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


import java.util.HashMap;

public class RomainToIntService {

    public int romainToInt(String nbRoman) {
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
}
