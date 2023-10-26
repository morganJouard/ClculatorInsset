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
public class intToRomainServiceImpl {
    public String intToRomain(int number){
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
