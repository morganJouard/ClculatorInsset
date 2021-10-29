 /*
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 package org.insset.client.service;

 import org.insset.server.RomanConverterServiceImpl;
 import org.junit.After;
 import org.junit.AfterClass;
 import org.junit.Assert;
 import org.junit.Before;
 import org.junit.BeforeClass;

 /**
  * @author user
  */
 public class RomanConverterTest {

     private final RomanConverterServiceImpl instance = new RomanConverterServiceImpl();

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
      */
     /*@org.junit.Test(expected = IllegalArgumentException.class)
     public void testConvertArabeToRomanNOK() {
         instance.convertArabeToRoman(3000);
     }*/

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

     /**
      * Test de la methode convertRomanToArabe
      **/
     /*@org.junit.Test(expected = IllegalArgumentException.class)
     public void testConvertRomanToArabeNOK() {
         instance.convertRomanToArabe("MMMCMLVIII");
     }*/

     /**
      * Test de la methode convertRomanToArabe
      */
     @org.junit.Test
     public void testConvertRomanToArabOK() {
         Assert.assertEquals(new Integer(435), instance.convertRomanToArabe("CDXXXV"));
     }

     /**
      * Test de la methode convertDateYears
      */
     /*@org.junit.Test(expected = IllegalArgumentException.class)
     public void testConvertDateYearsNOK() {
         instance.convertDateYears("04/06");
     }*/

     /**
      * Test de la methode convertDateYears
      */
     @org.junit.Test(expected = NumberFormatException.class)
     public void testConvertDateYearsNotNumber() {
         instance.convertDateYears("YY/MM/MMMM");
     }

     /**
      * Test de la methode convertDateYears
      */
     @org.junit.Test
     public void testConvertDateYearsOK() {
         Assert.assertEquals("VII/XII/MCMXCV", instance.convertDateYears("07/12/1995"));
     }
 }
