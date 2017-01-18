/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {
    
    static String convertitEnDecimal(java.lang.String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();
        /* operation to be performed on upper cases even if user 
           enters roman values in lower case chars */
        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
            
        }
        return Integer.toString(decimal);
        
    }

    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }
    
     static String additif(int x, char un, char cinq) {
        String s = "";
        if (x >= 5) {
            s = s + cinq;
        }
        switch (x % 5) {
            case 1:
                s = s + un;
                break;
            case 2:
                s = s + un + un;
                break;
            case 3:
                s = s + un + un + un;
                break;
            case 4:
                s = s + un + un + un + un;
                break;
        }
        return s;
    }

    static String soustractif(int x, char un, char cinq, char dix) {
        String s = "";
        switch (x) {
            case 0:
                s = "";
                break;
            case 1:
                s = s + un;
                break;
            case 2:
                s = s + un + un;
                break;
            case 3:
                s = s + un + un + un;
                break;
            case 4:
                s = s + un + cinq;
                break;
            case 5:
                s = s + cinq;
                break;
            case 6:
                s = s + cinq + un;
                break;
            case 7:
                s = s + cinq + un + un;
                break;
            case 8:
                s = s + cinq + un + un + un;
                break;
            case 9:
                s = s + un + dix;
                break;
            default: s = "???";
        }
        return s;
    }
    
    static String convertitEnRomains(int n, boolean simplifie){
        if(n >= 1 && n <= 2000){
            int unites = n % 10;
            int dizaines = (n / 10) % 10;
            int centaines = (n / 100) % 10;
            int milliers= (n / 1000) % 1000;
            if(simplifie){
                return (additif(milliers, 'M', '?') + additif(centaines, 'C', 'D') + additif(dizaines, 'X', 'L')+ additif(unites, 'I', 'V'));
            }else {
                return (soustractif(milliers, 'M', '?', '?') + soustractif(centaines, 'C', 'D', 'M') + soustractif(dizaines, 'X', 'L', 'C')+ soustractif(unites, 'I', 'V','X'));
            }
            
        }else return "Nombre impossible à écrire en chiffres romains.";
    }

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        //Implement your code
        return new Integer(convertitEnDecimal(nbr));
    }
   

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        //Implement your code
        return new String(convertitEnRomains(nbr, false));
    }

}
