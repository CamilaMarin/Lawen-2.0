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
public class CensoSeccionATest {
    
    public CensoSeccionATest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getContadorAutovalenteSinRiesgo method, of class CensoSeccionA.
     */
    @Test
    public void testGetContadorAutovalenteSinRiesgo() {
        System.out.println("getContadorAutovalenteSinRiesgo");
        CensoSeccionA instance = new CensoSeccionA();
        int respEsperada = 1;
        instance.setContadorAutovalenteSinRiesgo(1);
        int result = instance.getContadorAutovalenteSinRiesgo();
        assertEquals(respEsperada, result);
        
    }

    /**
     * Test of getColumnName1 method, of class CensoSeccionA.
     */
    @Test
    public void testGetColumnName1() {
        System.out.println("getColumnName1");
        CensoSeccionA instance = new CensoSeccionA();
        String respEsperada = "columna";
        instance.setColumnName1("columna");
        String result = instance.getColumnName1();
        assertEquals(respEsperada, result);
        
    }

    /**
     * Test of setColumnName1 method, of class CensoSeccionA.
     */
    @Test
    public void testSetColumnName1() {
        System.out.println("setColumnName1");
        String columnName1 = "columna";
        CensoSeccionA instance = new CensoSeccionA();
        instance.setColumnName1(columnName1);
        String result = instance.getColumnName1();
        assertEquals(columnName1, result);
    }

    /**
     * Test of getColumnName2 method, of class CensoSeccionA.
     */
    @Test
    public void testGetColumnName2() {
        System.out.println("getColumnName2");
        CensoSeccionA instance = new CensoSeccionA();
        String respEsperada = "columna2";
        instance.setColumnName2("columna2");
        String result = instance.getColumnName2();
        assertEquals(respEsperada, result);
       
    }

    /**
     * Test of setColumnName2 method, of class CensoSeccionA.
     */
    @Test
    public void testSetColumnName2() {
        System.out.println("setColumnName2");
        String columnName2 = "columna2";
        CensoSeccionA instance = new CensoSeccionA();
        instance.setColumnName2(columnName2);
        String result=instance.getColumnName2();
        assertEquals(columnName2, result);
        
    }

    /**
     * Test of setContadorAutovalenteSinRiesgo method, of class CensoSeccionA.
     */
    @Test
    public void testSetContadorAutovalenteSinRiesgo() {
        System.out.println("setContadorAutovalenteSinRiesgo");
        int contadorAutovalenteSinRiesgo = 0;
        CensoSeccionA instance = new CensoSeccionA();
        instance.setContadorAutovalenteSinRiesgo(contadorAutovalenteSinRiesgo);
        int result =instance.getContadorAutovalenteSinRiesgo();
        assertEquals(contadorAutovalenteSinRiesgo,result);
    }

    /**
     * Test of getContadorAutovalenteConRiesgo method, of class CensoSeccionA.
     */
    @Test
    public void testGetContadorAutovalenteConRiesgo() {
        System.out.println("getContadorAutovalenteConRiesgo");
        CensoSeccionA instance = new CensoSeccionA();
        int respEsperada = 0;
        instance.setContadorAutovalenteConRiesgo(0);
        int result = instance.getContadorAutovalenteConRiesgo();
        assertEquals(respEsperada, result);
        
    }

    /**
     * Test of setContadorAutovalenteConRiesgo method, of class CensoSeccionA.
     */
    @Test
    public void testSetContadorAutovalenteConRiesgo() {
        System.out.println("setContadorAutovalenteConRiesgo");
        int contadorAutovalenteConRiesgo = 0;
        CensoSeccionA instance = new CensoSeccionA();
        instance.setContadorAutovalenteConRiesgo(contadorAutovalenteConRiesgo);
        int result=instance.getContadorAutovalenteConRiesgo();
        assertEquals(contadorAutovalenteConRiesgo,result);
    }

    /**
     * Test of getContadorRiesgoDependencia method, of class CensoSeccionA.
     */
    @Test
    public void testGetContadorRiesgoDependencia() {
        System.out.println("getContadorRiesgoDependencia");
        CensoSeccionA instance = new CensoSeccionA();
        int respEsperada = 0;
        instance.setContadorRiesgoDependencia(0);
        int result = instance.getContadorRiesgoDependencia();
        assertEquals(respEsperada, result);
        
    }

    /**
     * Test of setContadorRiesgoDependencia method, of class CensoSeccionA.
     */
    @Test
    public void testSetContadorRiesgoDependencia() {
        System.out.println("setContadorRiesgoDependencia");
        int contadorRiesgoDependencia = 0;
        CensoSeccionA instance = new CensoSeccionA();
        instance.setContadorRiesgoDependencia(contadorRiesgoDependencia);
        int result=instance.getContadorRiesgoDependencia();
        assertEquals(contadorRiesgoDependencia, result);
    }

    /**
     * Test of getSubTotalEfam method, of class CensoSeccionA.
     */
    @Test
    public void testGetSubTotalEfam() {
        System.out.println("getSubTotalEfam");
        CensoSeccionA instance = new CensoSeccionA();
        int respEsperada = 6;
        instance.setSubTotalEfam(6);
        int result = instance.getSubTotalEfam();
        assertEquals(respEsperada, result);
        
    }

    /**
     * Test of setSubTotalEfam method, of class CensoSeccionA.
     */
    @Test
    public void testSetSubTotalEfam() {
        System.out.println("setSubTotalEfam");
        int subTotalEfam = 6;
        CensoSeccionA instance = new CensoSeccionA();
        instance.setSubTotalEfam(subTotalEfam);
        int result = instance.getSubTotalEfam();
        assertEquals(6, result);
    }

    /**
     * Test of getDependentienteLeve method, of class CensoSeccionA.
     */
    @Test
    public void testGetDependentienteLeve() {
        System.out.println("getDependentienteLeve");
        CensoSeccionA instance = new CensoSeccionA();
        int respEsperada =5;
        instance.setDependentienteLeve(5);
        int result = instance.getDependentienteLeve();
        assertEquals(respEsperada, result);
        
    }

    /**
     * Test of setDependentienteLeve method, of class CensoSeccionA.
     */
    @Test
    public void testSetDependentienteLeve() {
        System.out.println("setDependentienteLeve");
        int dependentienteLeve = 5;
        CensoSeccionA instance = new CensoSeccionA();
        instance.setDependentienteLeve(dependentienteLeve);
        int result = instance.getDependentienteLeve();
        assertEquals(5, result);
    }

    /**
     * Test of getDependientemoderado method, of class CensoSeccionA.
     */
    @Test
    public void testGetDependientemoderado() {
        System.out.println("getDependientemoderado");
        CensoSeccionA instance = new CensoSeccionA();
        int respEsperada = 10;
        instance.setDependientemoderado(10);
        int result = instance.getDependientemoderado();
        assertEquals(respEsperada, result);
        
    }

    /**
     * Test of setDependientemoderado method, of class CensoSeccionA.
     */
    @Test
    public void testSetDependientemoderado() {
        System.out.println("setDependientemoderado");
        int dependientemoderado = 10;
        CensoSeccionA instance = new CensoSeccionA();
        instance.setDependientemoderado(dependientemoderado);
        int result = instance.getDependientemoderado();
        assertEquals(10, result);
    }

    /**
     * Test of getDependientegrave method, of class CensoSeccionA.
     */
    @Test
    public void testGetDependientegrave() {
        System.out.println("getDependientegrave");
        CensoSeccionA instance = new CensoSeccionA();
        int respEsperada = 15;
        instance.setDependientegrave(15);
        int result = instance.getDependientegrave();
        assertEquals(respEsperada, result);
        
    }

    /**
     * Test of setDependientegrave method, of class CensoSeccionA.
     */
    @Test
    public void testSetDependientegrave() {
        System.out.println("setDependientegrave");
        int dependientegrave = 15;
        CensoSeccionA instance = new CensoSeccionA();
        instance.setDependientegrave(dependientegrave);
        int result = instance.getDependientegrave();
        assertEquals(15, result);
    }

    /**
     * Test of getDependienteTotal method, of class CensoSeccionA.
     */
    @Test
    public void testGetDependienteTotal() {
        System.out.println("getDependienteTotal");
        CensoSeccionA instance = new CensoSeccionA();
        int respEsperada = 8;
        instance.setDependienteTotal(8);
        int result = instance.getDependienteTotal();
        assertEquals(respEsperada, result);
        
    }

    /**
     * Test of setDependienteTotal method, of class CensoSeccionA.
     */
    @Test
    public void testSetDependienteTotal() {
        System.out.println("setDependienteTotal");
        int dependienteTotal = 8;
        CensoSeccionA instance = new CensoSeccionA();
        instance.setDependienteTotal(dependienteTotal);
        int result = instance.getDependienteTotal();
        assertEquals(8, result);
    }

    /**
     * Test of getSubTotalBarthel method, of class CensoSeccionA.
     */
    @Test
    public void testGetSubTotalBarthel() {
        System.out.println("getSubTotalBarthel");
        CensoSeccionA instance = new CensoSeccionA();
        int respEsperada = 22;
        instance.setSubTotalBarthel(22);
        int result = instance.getSubTotalBarthel();
        assertEquals(respEsperada, result);
        
    }

    /**
     * Test of setSubTotalBarthel method, of class CensoSeccionA.
     */
    @Test
    public void testSetSubTotalBarthel() {
        System.out.println("setSubTotalBarthel");
        int subTotalBarthel = 22;
        CensoSeccionA instance = new CensoSeccionA();
        instance.setSubTotalBarthel(subTotalBarthel);
        int result = instance.getSubTotalBarthel();
        assertEquals(22, result);
    }

    /**
     * Test of getTotalAdutosMayoresControl method, of class CensoSeccionA.
     */
    @Test
    public void testGetTotalAdutosMayoresControl() {
        System.out.println("getTotalAdutosMayoresControl");
        CensoSeccionA instance = new CensoSeccionA();
        int respEsperada = 50;
        instance.setTotalAdutosMayoresControl(50);
        int result = instance.getTotalAdutosMayoresControl();
        assertEquals(respEsperada, result);
        
    }

    /**
     * Test of setTotalAdutosMayoresControl method, of class CensoSeccionA.
     */
    @Test
    public void testSetTotalAdutosMayoresControl() {
        System.out.println("setTotalAdutosMayoresControl");
        int totalAdutosMayoresControl = 50;
        CensoSeccionA instance = new CensoSeccionA();
        instance.setTotalAdutosMayoresControl(totalAdutosMayoresControl);
        int result = instance.getTotalAdutosMayoresControl();
        assertEquals(50, result);
    }
    
}
