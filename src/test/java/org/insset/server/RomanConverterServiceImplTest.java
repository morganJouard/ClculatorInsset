/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author user
 */
public class RomanConverterServiceImplTest {
    
    @Test
    public void testConvertArabeToRomanOk() {
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String resExpected = "XII";
        String result = instance.convertArabeToRoman(12);
        
        assertEquals(resExpected, result);
    }
    
    @Test
    public void testconvertDateYearsOk() {
         RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
         String resExpected = "XII/IV/MCMXCVIII";
         String result = instance.convertDateYears("12/04/1998");
         
         assertEquals(resExpected, result);
    }     
}
