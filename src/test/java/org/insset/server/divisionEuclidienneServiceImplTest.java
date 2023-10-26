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
public class divisionEuclidienneServiceImplTest {
    
    public divisionEuclidienneServiceImplTest() {
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
     * Test of divisionEuclidienne method, of class divisionEuclidienneServiceImpl.
     */
    @Test
    public void testDivisionEuclidienne() {
        System.out.println("divisionEuclidienne");
        int dividende = 785;
        int diviseur = 36;
        divisionEuclidienneServiceImpl instance = new divisionEuclidienneServiceImpl();
        int[] expResult = new int[2];
        expResult[0] = 21;
        expResult[1] = 29;
        int[] result = instance.divisionEuclidienne(dividende, diviseur);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
    }
    
}
