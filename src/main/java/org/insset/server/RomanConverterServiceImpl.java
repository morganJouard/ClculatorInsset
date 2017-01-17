/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    private Map<Integer, String> correspondanceRomainDecimal = new TreeMap<Integer, String>(Collections.reverseOrder()) {
        {
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

        }
    };

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        String resultat = "";
      
        String[] date = nbr.split("\\/|-");
        resultat = convertArabeToRoman(Integer.valueOf(date[0])) + 
                "/" + convertArabeToRoman(Integer.valueOf(date[1]))+
                "/" + convertArabeToRoman(Integer.valueOf(date[2]));
         
        return resultat;
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        //Implement your code
        return 3;
    }

    @Override
    public String convertArabeToRoman(Integer input) throws IllegalArgumentException {
        String string = "";
        
        for(Integer i : correspondanceRomainDecimal.keySet()) {
            while(input >= i)
            {
                string += correspondanceRomainDecimal.get(i);
                input-=i;
            }
        }
               
        return string;
    }
}
