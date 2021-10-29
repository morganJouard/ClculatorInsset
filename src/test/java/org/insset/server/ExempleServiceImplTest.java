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
public class ExempleServiceImplTest {
    
    public ExempleServiceImplTest() {
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
     * Test of inverserChaine method, of class ExempleServiceImpl.
     */
    @org.junit.Test
    public void testInverserChaine() {
        String input = "noyon";
        ExempleServiceImpl instance = new ExempleServiceImpl();
        String expResult = "noyon";
        String result = instance.inverserChaine(input);
        assertEquals(expResult, result);
    }
    
}
