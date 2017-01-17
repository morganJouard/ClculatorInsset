/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.HashMap;
import java.util.Map;
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
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        //Implement your code
        return 3;
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        if (nbr < 1 || nbr > 2000) {
            throw new IllegalArgumentException("You need to give an integer between 1 and 2000");
        }
        
        String[] rnChars = {"M", "CM", "D", "C", "XC", "L", "X", "IX", "V", "I"};
        int[] rnVals = {1000, 900, 500, 100, 90, 50, 10, 9, 5, 1};
        String retVal = "";

        for (int i = 0; i < rnVals.length; i++) {
            int numberInPlace = nbr / rnVals[i];
            if (numberInPlace == 0) {
                continue;
            }
            retVal += numberInPlace == 4 && i > 0 ? rnChars[i] + rnChars[i - 1]
                    : new String(new char[numberInPlace]).replace("\0", rnChars[i]);
            nbr = nbr % rnVals[i];
        }
        return retVal;
    }

    /**
     * @return Map<Integer, String>
     */
    private static Map getMapping() {
        Map<Integer, String> mapping;
        mapping = new HashMap<>();
        mapping.put(1000, "M");
        mapping.put(500, "D");
        mapping.put(100, "C");
        mapping.put(50, "L");
        mapping.put(10, "X");
        mapping.put(5, "V");
        mapping.put(1, "I");

        return mapping;
    }

}
