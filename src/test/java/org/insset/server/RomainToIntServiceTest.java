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
public class RomainToIntServiceTest {
    
    public RomainToIntServiceTest() {
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
     * Test of romainToInt method, of class RomainToIntService.
     */
    @Test
    public void testRomainToInt() {
       RomainToIntService instance = new RomainToIntService();

        String nbRoman = "";
        int expResult = 0;
        int result = instance.romainToInt(nbRoman);
        assertEquals(expResult, result);
        nbRoman = "IX";
        expResult = 9;
        result = instance.romainToInt(nbRoman);
        assertEquals(expResult, result);
    }
    
}
