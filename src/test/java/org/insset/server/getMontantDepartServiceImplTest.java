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
public class getMontantDepartServiceImplTest {
    
    public getMontantDepartServiceImplTest() {
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
        getMontantDepartServiceImpl instance = new getMontantDepartServiceImpl();
        double expResult = 100.0;
        double result = instance.getMontantDepart(nb, pourcentage);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetMontantDepartNOKSup100() {
        double nb = 80.0;
        double pourcentage = 120.0;
        getMontantDepartServiceImpl instance = new getMontantDepartServiceImpl();
        instance.getMontantDepart(nb, pourcentage);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetMontantDepartNOKNegatif() {
        double nb = 80.0;
        double pourcentage = -20.0;
        getMontantDepartServiceImpl instance = new getMontantDepartServiceImpl();
        instance.getMontantDepart(nb, pourcentage);
    }
    
}
