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

    
    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
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

}
