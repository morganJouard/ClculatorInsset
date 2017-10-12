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
 * @author talend
 */
public class SoldeConverterServiceImplTest {
    SoldeConverterServiceImpl serviceSolde;
    
    public SoldeConverterServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        serviceSolde = new SoldeConverterServiceImpl();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of CalculMontantFinal method, of class SoldeConverterServiceImpl.
     */
    @Test
    public void testCalculMontantFinal() {
        //Given
        float montant = 18.00f;
        
        //When
        float resultat = serviceSolde.CalculMontantFinal(montant, 10);
        
        //Then
        assertEquals(16.20, resultat, 0.1);
    }
    
    @Test
    public void testCalculMontantFinal0() {
        //Given
        float montant = 0.00f;
        
        //When
        float resultat = serviceSolde.CalculMontantFinal(montant, 10);
        
        //Then
        assertEquals(0, resultat, 0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculMontantFinalSup2000() {
        //Given
        float montant = 2500.00f;
        
        //When
        float resultat = serviceSolde.CalculMontantFinal(montant, 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculMontantFinalException() {
        //Given
        float montant = -45.00f;
        
        //When
        float resultat = serviceSolde.CalculMontantFinal(montant, 10);
    }

    /**
     * Test of CalculMontantDepart method, of class SoldeConverterServiceImpl.
     */
    @Test
    public void testCalculMontantDepart() {
        //Given
        float montant = 45.00f;
        
        //When
        float resultat = serviceSolde.CalculMontantDepart(montant, 10);
        
        //Then
        assertEquals(50, resultat, 0.1);
    }
    
    @Test
    public void testCalculMontantDepart0() {
        //Given
        float montant = 0.00f;
        
        //When
        float resultat = serviceSolde.CalculMontantDepart(montant, 10);
        
        //Then
        assertEquals(0, resultat, 0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculMontantDepartSup2000() {
        //Given
        float montant = 2500.00f;
        
        //When
        float resultat = serviceSolde.CalculMontantDepart(montant, 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculMontantDepartException() {
        //Given
        float montant = -45.00f;
        
        //When
        float resultat = serviceSolde.CalculMontantDepart(montant, 10);
    }

    /**
     * Test of CalculRemise method, of class SoldeConverterServiceImpl.
     */
    @Test
    public void testCalculRemise() {
        //Given
        float montantDep = 50.00f;
        float montantFin = 45.00f;
        
        //When
        float resultat = serviceSolde.CalculRemise(montantDep, montantFin);
        
        //Then
        assertEquals(5, Math.abs(resultat), 0.1);
    }
    
    @Test
    public void testCalculRemise0(){
        //Given
        float montantDep = 0.00f;
        float montantFin = 0.00f;
        
        //When
        float resultat = serviceSolde.CalculRemise(montantDep, montantFin);
        
        //Then
        assertEquals(0, Math.abs(resultat), 0.1);
    }
    
}
