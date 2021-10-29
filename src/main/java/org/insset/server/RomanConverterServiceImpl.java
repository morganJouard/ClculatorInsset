/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;
import org.insset.shared.DateUtils;

/**
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements RomanConverterService {

    @Override
    public String convertDateYears(String dateStr) throws IllegalArgumentException {
        int[] date = DateUtils.convertDateStringToIntArray(dateStr);

        return String.format("%s/%s/%s", this.convertArabeToRoman(date[0]), this.convertArabeToRoman(date[1]), this.convertArabeToRoman(date[2]));
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        int sum = 0;
        int nbrLength = nbr.length();

        for(int charPosition = 0; charPosition < nbrLength; charPosition++)
        {
            if (charPosition != nbrLength - 1
                    && DateUtils.mapRomanToInt.get(nbr.charAt(charPosition)) < DateUtils.mapRomanToInt.get(nbr.charAt(charPosition + 1))
            ) {
                sum += DateUtils.mapRomanToInt.get(nbr.charAt(charPosition + 1)) -
                        DateUtils.mapRomanToInt.get(nbr.charAt(charPosition));
                charPosition++;
            }
            else
            {
                sum += DateUtils.mapRomanToInt.get(nbr.charAt(charPosition));
            }
        }

        return sum;
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        int l = DateUtils.mapIntToRoman.floorKey(nbr);

        if (nbr == l) {
            return DateUtils.mapIntToRoman.get(nbr);
        }

        return DateUtils.mapIntToRoman.get(l) + convertArabeToRoman(nbr - l);
    }
}
