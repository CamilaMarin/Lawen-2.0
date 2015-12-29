/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.adultoMayor.censo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeanpierre
 */
public class CensoSeccionBTest {
    
    public CensoSeccionBTest() {
    }
    
    @Before
    public void setUp() {
    }


    /**
     * Test of getContadorBajoPeso method, of class CensoSeccionB.
     */
    @Test
    public void testGetContadorBajoPeso() {
        System.out.println("getContadorBajoPeso");
        CensoSeccionB instance = new CensoSeccionB();
        int expResult = 10;
        instance.setContadorBajoPeso(10);
        int result = instance.getContadorBajoPeso();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setContadorBajoPeso method, of class CensoSeccionB.
     */
    @Test
    public void testSetContadorBajoPeso() {
        System.out.println("setContadorBajoPeso");
        int contadorBajoPesp = 10;
        CensoSeccionB instance = new CensoSeccionB();
        instance.setContadorBajoPeso(contadorBajoPesp);
        int result = instance.getContadorBajoPeso();
        assertEquals(10, result);
    }

    /**
     * Test of getContadorNormal method, of class CensoSeccionB.
     */
    @Test
    public void testGetContadorNormal() {
        System.out.println("getContadorNormal");
        CensoSeccionB instance = new CensoSeccionB();
        int expResult = 15;
        instance.setContadorNormal(15);
        int result = instance.getContadorNormal();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setContadorNormal method, of class CensoSeccionB.
     */
    @Test
    public void testSetContadorNormal() {
        System.out.println("setContadorNormal");
        int contadorNormal = 15;
        CensoSeccionB instance = new CensoSeccionB();
        instance.setContadorNormal(contadorNormal);
        int result = instance.getContadorNormal();
        assertEquals(15, result);
    }

    /**
     * Test of getContadorSobrepeso method, of class CensoSeccionB.
     */
    @Test
    public void testGetContadorSobrepeso() {
        System.out.println("getContadorSobrepeso");
        CensoSeccionB instance = new CensoSeccionB();
        int expResult = 20;
        instance.setContadorSobrepeso(20);
        int result = instance.getContadorSobrepeso();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setContadorSobrepeso method, of class CensoSeccionB.
     */
    @Test
    public void testSetContadorSobrepeso() {
        System.out.println("setContadorSobrepeso");
        int contadorSobrepeso = 20;
        CensoSeccionB instance = new CensoSeccionB();
        instance.setContadorSobrepeso(contadorSobrepeso);
        int result = instance.getContadorSobrepeso();
        assertEquals(20, result);
    }

    /**
     * Test of getContadorObeso method, of class CensoSeccionB.
     */
    @Test
    public void testGetContadorObeso() {
        System.out.println("getContadorObeso");
        CensoSeccionB instance = new CensoSeccionB();
        int expResult = 30;
        instance.setContadorObeso(30);
        int result = instance.getContadorObeso();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setContadorObeso method, of class CensoSeccionB.
     */
    @Test
    public void testSetContadorObeso() {
        System.out.println("setContadorObeso");
        int contadorObeso = 30;
        CensoSeccionB instance = new CensoSeccionB();
        instance.setContadorObeso(contadorObeso);
        int result = instance.getContadorObeso();
        assertEquals(30, result);
    }

    /**
     * Test of getTotalSeccionB method, of class CensoSeccionB.
     */
    @Test
    public void testGetTotalSeccionB() {
        System.out.println("getTotalSeccionB");
        CensoSeccionB instance = new CensoSeccionB();
        int expResult = 5;
        instance.setTotalSeccionB(5);
        int result = instance.getTotalSeccionB();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setTotalSeccionB method, of class CensoSeccionB.
     */
    @Test
    public void testSetTotalSeccionB() {
        System.out.println("setTotalSeccionB");
        int TotalSeccionB = 5;
        CensoSeccionB instance = new CensoSeccionB();
        instance.setTotalSeccionB(TotalSeccionB);
        int result = instance.getTotalSeccionB();
        assertEquals(5, result);
    }
    
}
