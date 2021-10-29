package org.insset.client.service;

import org.insset.server.PercentagesConverterServiceImpl;
import org.junit.*;

import java.util.Arrays;

public class PercentagesConverterTest {
    private final PercentagesConverterServiceImpl instance = new PercentagesConverterServiceImpl();

    public PercentagesConverterTest() {
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
     * Test de la methode calculateFinalPrice
     */
    @org.junit.Test
    public void testCalculateFinalPrice() {
        Assert.assertArrayEquals(new Double[]{80., 20.}, instance.calculateFinalPrice(100, 20));
    }

    /**
     * Test de la methode calculateBasePrice
     */
    @org.junit.Test
    public void testCalculateBasePrice() {
        Assert.assertArrayEquals(
                new Double[]{20., 100.},
                instance.calculateBasePrice(80, 20)
        );
    }

    /**
     * Test de la methode divide
     */
    @org.junit.Test
    public void testDivide() {
        Assert.assertEquals(
                new Double(5),
                instance.divide(100., 20.)
        );
    }

    /**
     * Test de la methode divide
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testDivideWithDivisorZero() {
        instance.divide(100., 0.);
    }
}
