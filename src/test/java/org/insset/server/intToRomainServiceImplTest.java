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
public class intToRomainServiceImplTest {
    
    public intToRomainServiceImplTest() {
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
    public void testIntToRomain() {
        System.out.println("intToRomain");
        int number = 5;
        intToRomainServiceImpl instance = new intToRomainServiceImpl();
        String expResult = "V";
        String result = instance.intToRomain(number);
        assertEquals(expResult, result);
    }
    
}
