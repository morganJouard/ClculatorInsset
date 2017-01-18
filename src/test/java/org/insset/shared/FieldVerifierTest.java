/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.shared;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author user
 */
public class FieldVerifierTest {
    
    @Test
    public void testIsValidDateOK() {
        FieldVerifier instance = new FieldVerifier();
        boolean resExpected = true;
        boolean resultat = instance.isValidDate("14/04/2016");
        
         assertEquals(resExpected, resultat);
    }
    
    @Test
    public void testIsValidDateKO() {
        FieldVerifier instance = new FieldVerifier();
        boolean resExpected = false;
        boolean resultat = instance.isValidDate("14/04/24016");
        
        assertEquals(resExpected, resultat);
    }
    
    @Test
    public void testIsValidDecimalOK() {
        FieldVerifier instance = new FieldVerifier();
        boolean resExpected = true;
        boolean resultat = instance.isValidDecimal(198);
        
        assertEquals(resExpected, resultat);
    }
    
    @Test
    public void testIsValidDecimalKo() {
        FieldVerifier instance = new FieldVerifier();
        boolean resExpected = false;
        boolean resultat = instance.isValidDecimal(19898);
        
        assertEquals(resExpected, resultat);
    }
    
    @Test
    public void testIsValidNameOk() {
        FieldVerifier instance = new FieldVerifier();
        boolean resExpected = true;
        boolean resultat = instance.isValidName("Name");
        
        assertEquals(resExpected, resultat);
    }
    
    @Test
    public void testIsValidNameKo() {
        FieldVerifier instance = new FieldVerifier();
        boolean resExpected = false;
        boolean resultat = instance.isValidName("");
        
        assertEquals(resExpected, resultat);
    }
}
