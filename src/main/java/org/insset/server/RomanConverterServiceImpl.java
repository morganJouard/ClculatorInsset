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

    
    private RomainToIntService romainToIntService = new RomainToIntService();
    
    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }

    @Override
    public Integer convertRomanToArabe(String nbRoman) throws IllegalArgumentException {
        if (nbRoman == null || nbRoman.isEmpty()) {
            throw new IllegalArgumentException("Le nombre romain ne peut pas être null ou vide");
        }
        return romainToIntService.romainToInt(nbRoman);
    }
    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        //Implement your code
        return new String("XVXX");
    }

}
