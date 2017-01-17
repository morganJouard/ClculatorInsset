/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class RomanConverterServiceImplTest {
    
    public RomanConverterServiceImplTest() {
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
     * Test of convertDateYears method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertDateYears() {
        System.out.println("convertDateYears");
        String nbr = "";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "";
        String result = instance.convertDateYears(nbr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertRomanToArabe() {
        System.out.println("convertRomanToArabe");
        String nbr = "";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        Integer expResult = null;
        Integer result = instance.convertRomanToArabe(nbr);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertArabeToRoman method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertArabeToRomanOK() {
        System.out.println("convertArabeToRoman");
        Integer nbr = 16;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "XVI";
        String result = instance.convertArabeToRoman(nbr);
        assertEquals(expResult, result);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConvertArabeToRomanLessThanOne() {
        System.out.println("convertArabeToRomanInvalidInput");
        Integer nbr = 0;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String result = instance.convertArabeToRoman(nbr);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConvertArabeToRomanMoreThanTwoThousand() {
        System.out.println("convertArabeToRomanInvalidInput");
        Integer nbr = 2001;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String result = instance.convertArabeToRoman(nbr);
    }
}
