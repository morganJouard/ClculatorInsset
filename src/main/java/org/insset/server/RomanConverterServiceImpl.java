/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements RomanConverterService {

    private final static TreeMap<Integer, String> mapIntToRoman = new TreeMap<Integer, String>() {{
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

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException, NumberFormatException {
        int[] date;

        date = Arrays.stream(nbr.split("/")).mapToInt(Integer::parseInt).toArray();

        if (date.length != 3 || date[0] < 1 || date[0] > 31 || date[1] < 1 || date[1] > 12 || date[2] < 0 || date[2] > 2000) {
            throw new IllegalArgumentException();
        }

        return String.format("%s/%s/%s", this.convertArabeToRoman(date[0]), this.convertArabeToRoman(date[1]), this.convertArabeToRoman(date[2]));
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        //Implement your code
        return 3;
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        if (nbr < 1 || nbr > 2000) {
            throw new IllegalArgumentException();
        }

        int l = mapIntToRoman.floorKey(nbr);

        if (nbr == l) {
            return mapIntToRoman.get(nbr);
        }

        return mapIntToRoman.get(l) + convertArabeToRoman(nbr - l);
    }
}
