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

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        int Arabic = 0;
        String Roman = nbr;
        return convert(Roman, Arabic);
    }
    
    public Integer convert(String Roman, int Arabic){
        Roman = Roman.toUpperCase();
        int i = 0;
        while (i<Roman.length()){
            char letter = Roman.charAt(i);
            int number = letterToNumber(letter);
            if(number<0){
                System.out.println("Mauvais caractère");
                break;
            }
            i++;
            if(i==Roman.length()){
                Arabic += number;
            } else {
                int nextNumber = letterToNumber(Roman.charAt(i));
                if((i+2<Roman.length())){
                    int nextnextnum = letterToNumber(Roman.charAt(i+2));
                    if((number == nextNumber)&&(number == nextnextnum)){
                        System.out.println("illegal character");
                        break;
                    }
                }
                if(nextNumber > number){
                    Arabic += (nextNumber - number);
                    i++;
                } else {
                    Arabic += number;
                }
            }
        }
        return Arabic;
    }
    
    private int letterToNumber(char letter){
        switch(letter){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        //Implement your code
        return new String("XVXX");
    }

    
}
