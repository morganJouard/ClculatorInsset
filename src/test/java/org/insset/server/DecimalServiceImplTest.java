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
public class DecimalServiceImplTest {
    
    public DecimalServiceImplTest() {
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
    public void testGetMontantDepartOK() {
        double nb = 80.0;
        double pourcentage = 20.0;
        DecimalServiceImpl instance = new DecimalServiceImpl();
        double expResult = 100.0;
        double result = instance.getMontantDepart(nb, pourcentage);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetMontantDepartNOKSup100() {
        double nb = 80.0;
        double pourcentage = 120.0;
        DecimalServiceImpl instance = new DecimalServiceImpl();
        instance.getMontantDepart(nb, pourcentage);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetMontantDepartNOKNegatif() {
        double nb = 80.0;
        double pourcentage = -20.0;
        DecimalServiceImpl instance = new DecimalServiceImpl();
        instance.getMontantDepart(nb, pourcentage);
    }
    
        @Test
    public void testDivisionEuclidienne() {
        System.out.println("divisionEuclidienne");
        int dividende = 785;
        int diviseur = 36;
        DecimalServiceImpl instance = new DecimalServiceImpl();
        int[] expResult = new int[2];
        expResult[0] = 21;
        expResult[1] = 29;
        int[] result = instance.divisionEuclidienne(dividende, diviseur);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
    }
    
}
