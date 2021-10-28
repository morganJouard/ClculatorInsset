 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import java.util.Map;
import java.util.TreeMap;
import org.insset.server.RomanConverterServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author user
 */
public class RomanConverterTest {
    
    private RomanConverterServiceImpl instance = new RomanConverterServiceImpl();

    public RomanConverterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
     /**
     * Test de la methode convertArabeToRoman
     *
    @org.junit.Test(expected=IllegalArgumentException.class)
    public void testConvertArabeToRomanNOK() {
        //given
        instance.convertArabeToRoman("a");
    } */
    
     /**
     * Test de la methode convertArabeToRoman
     */
    @org.junit.Test
    public void testConvertArabeToRomanOK() {
        Assert.assertEquals(
                "MXXVII", 
                instance.convertArabeToRoman(1027)
        );
    }
   
    
}
