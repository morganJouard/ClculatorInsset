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
 * @author insset
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

    @Test
    public void testRomainToInt() {
       RomanConverterServiceImpl instance = new RomanConverterServiceImpl();

        String nbRoman = "";
        int expResult = 0;
        int result = instance.convertRomanToArabe(nbRoman);
        assertEquals(expResult, result);
        nbRoman = "IX";
        expResult = 9;
        result = instance.convertRomanToArabe(nbRoman);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testIntToRomain() {
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        System.out.println("intToRomain");
        int number = 5;
        String expResult = "V";
        String result = instance.convertArabeToRoman(number);
        assertEquals(expResult, result);
    }
    
      @Test
    public void testDateToRomain() {
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String dateValide = "10/05/1990";
        String resultatAttendu = "X/V/MCMXC";
        String resultat = instance.convertDateYears(dateValide);
        assertEquals(resultatAttendu, resultat);

        // Test de conversion d'une autre date valide
        String autreDateValide = "01/12/2022";
        String autreResultatAttendu = "I/XII/MMXXII";
        String autreResultat = instance.convertDateYears(autreDateValide);
        assertEquals(autreResultatAttendu, autreResultat);

        // Test de conversion d'une date non valide (mois incorrect)
        String dateMoisIncorrect = "10/13/1990";
        try {
            instance.convertDateYears(dateMoisIncorrect);
            fail("La conversion d'une date non valide aurait dû générer une exception.");
        } catch (IllegalArgumentException e) {
            // Exception attendue
        }

        // Test de conversion d'une date non valide (jour incorrect)
        String dateJourIncorrect = "32/05/1990";
        try {
            instance.convertDateYears(dateJourIncorrect);
            fail("La conversion d'une date non valide aurait dû générer une exception.");
        } catch (IllegalArgumentException e) {
            // Exception attendue
        }

        // Test de conversion d'une date non valide (année négative)
        String dateAnneeNegative = "10/05/-1990";
        try {
            instance.convertDateYears(dateAnneeNegative);
            fail("La conversion d'une date non valide aurait dû générer une exception.");
        } catch (IllegalArgumentException e) {
            // Exception attendue
        }
    }
    
}
