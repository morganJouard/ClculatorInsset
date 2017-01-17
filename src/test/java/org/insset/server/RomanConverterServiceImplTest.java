/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import junit.framework.Assert;
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
        
        Assert.assertEquals("Test good convertion arabe to roman", resExpected, result);
    }
    
    @Test
    public void testConvertArabeToRomankO() {
//        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
//        String resExpected = "Le nombre est incorrect, il doit être entre 1 et 2000";
//        String result = instance.convertArabeToRoman(2484);
//        
//        Assert.assertEquals("Test wrong convertion arabe to roman", resExpected, result);
    }
}
