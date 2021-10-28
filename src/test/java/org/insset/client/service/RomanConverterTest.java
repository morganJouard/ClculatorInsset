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
      */
     /*@org.junit.Test
     public void testConvertRomanToArabOK() {
         Assert.assertTrue(
                 new Integer(1027).equals(
                         instance.convertRomanToArabe("MXXVII")
                 ));
     }*/


     /**
      * Test de la methode convertDateYears
      */
     @org.junit.Test
     public void testConvertDateYearsOK() {
         Assert.assertEquals("VII/XII/MCMXCV", instance.convertDateYears("07/12/1995"));
     }
 }
