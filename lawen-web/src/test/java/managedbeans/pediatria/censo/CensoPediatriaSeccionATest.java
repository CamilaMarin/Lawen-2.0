/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.pediatria.censo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IHC
 */
public class CensoPediatriaSeccionATest {
    
    public CensoPediatriaSeccionATest() {
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
     * Test of getColumnName1 method, of class CensoSeccionA.
     */
    @Test
    public void testGetColumnName1() {
        System.out.println("getColumnName1");
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
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
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
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
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
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
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        instance.setColumnName2(columnName2);
        String result=instance.getColumnName2();
        assertEquals(columnName2, result);
        
    }
    
    /**
     * Test of getNumerodeNinosPediatria method, of class CensoSeccionA.
     */
    @Test
    public void testGetNumerodeNinoPediatria(){
        System.out.println("getNumerodeNinosPediatria");
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        int respEsperada=0;
        instance.setNumerodeNinosPediatria(0);
        int result = instance.getNumerodeNinosPediatria();
        assertEquals(respEsperada, result);
    }
    /**
     * Test of setNumerodeNinosPediatria method, of class CensoSeccionA.
     */
    @Test
    public void testSetNumerodeNinoPediatria(){
        System.out.println("setNumerodeNinosPediatria");
        int cantidad=1;
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        instance.setNumerodeNinosPediatria(cantidad);
        int result=instance.getNumerodeNinosPediatria();
        assertEquals(cantidad, result);
    }
    
     /**
     * Test of getPesoEdadMenosUno method, of class CensoSeccionA.
     */
    @Test
    public void testGetPesoEdadMenosUno(){
        System.out.println("getPesoEdadMenosUno");
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        int respEsperada=0;
        instance.setPesoEdadMenosUno(0);
        int result = instance.getPesoEdadMenosUno();
        assertEquals(respEsperada, result);
    }
    /**
     * Test of setPesoEdadMenosUno method, of class CensoSeccionA.
     */
    @Test
    public void testSetPesoEdadMenosUno(){
        System.out.println("setPesoEdadMenosUno");
        int cantidad=1;
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        instance.setPesoEdadMenosUno(cantidad);
        int result=instance.getPesoEdadMenosUno();
        assertEquals(cantidad, result);
    }
     /**
     * Test of getPesoEdadMenosDos method, of class CensoSeccionA.
     */
    @Test
    public void testGetPesoEdadMenosDos(){
        System.out.println("getPesoEdadMenosDos");
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        int respEsperada=0;
        instance.setPesoEdadMenosDos(0);
        int result = instance.getPesoEdadMenosDos();
        assertEquals(respEsperada, result);
    }
    /**
     * Test of setPesoEdadMenosDos method, of class CensoSeccionA.
     */
    @Test
    public void testSetPesoEdadMenosDos(){
        System.out.println("setPesoEdadMenosDos");
        int cantidad=1;
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        instance.setPesoEdadMenosDos(cantidad);
        int result=instance.getPesoEdadMenosDos();
        assertEquals(cantidad, result);
    }
     /**
     * Test of getPesoEdadMenosTotal method, of class CensoSeccionA.
     */
    @Test
    public void testGetPesoEdadMenosTotal(){
        System.out.println("getPesoEdadMenosTotal");
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        int respEsperada=0;
        instance.setPesoEdadMenosTotal(0);
        int result = instance.getPesoEdadMenosTotal();
        assertEquals(respEsperada, result);
    }
    /**
     * Test of setPesoEdadMenosTotal method, of class CensoSeccionA.
     */
    @Test
    public void testSetPesoEdadMenosTotal(){
        System.out.println("setPesoEdadMenosTotal");
        int cantidad=1;
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        instance.setPesoEdadMenosTotal(cantidad);
        int result=instance.getPesoEdadMenosTotal();
        assertEquals(cantidad, result);
    }
     /**
     * Test of getPesoTallaMasDos method, of class CensoSeccionA.
     */
    @Test
    public void testGetPesoTallaMasDos(){
        System.out.println("getPesoTallaMasDos");
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        int respEsperada=0;
        instance.setPesoTallaMasDos(0);
        int result = instance.getPesoTallaMasDos();
        assertEquals(respEsperada, result);
    }
    /**
     * Test of setPesoTallaMasDos method, of class CensoSeccionA.
     */
    @Test
    public void testSetPesoTallaMasDos(){
        System.out.println("setPesoTallaMasDos");
        int cantidad=1;
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        instance.setPesoTallaMasDos(cantidad);
        int result=instance.getPesoTallaMasDos();
        assertEquals(cantidad, result);
    }
     /**
     * Test of getPesoTallaMasUno method, of class CensoSeccionA.
     */
    @Test
    public void testGetPesoTallaMasUno(){
        System.out.println("getPesoTallaMasUno");
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        int respEsperada=0;
        instance.setPesoTallaMasUno(0);
        int result = instance.getPesoTallaMasUno();
        assertEquals(respEsperada, result);
    }
    /**
     * Test of setPesoTallaMasUno method, of class CensoSeccionA.
     */
    @Test
    public void testSetPesoTallaMasUno(){
        System.out.println("setPesoTallaMasUno");
        int cantidad=1;
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        instance.setPesoTallaMasUno(cantidad);
        int result=instance.getPesoTallaMasUno();
        assertEquals(cantidad, result);
    }
     /**
     * Test of getPesoTallaMasTotal method, of class CensoSeccionA.
     */
    @Test
    public void testGetPesoTallaMasTotal(){
        System.out.println("getPesoTallaMasTotal");
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        int respEsperada=0;
        instance.setPesoTallaMasTotal(0);
        int result = instance.getPesoTallaMasTotal();
        assertEquals(respEsperada, result);
    }
    /**
     * Test of setPesoTallaMasTotal method, of class CensoSeccionA.
     */
    @Test
    public void testSetPesoTallaMasTotal(){
        System.out.println("setPesoTallaMasTotal");
        int cantidad=1;
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        instance.setPesoTallaMasTotal(cantidad);
        int result=instance.getPesoTallaMasTotal();
        assertEquals(cantidad, result);
    }
     /**
     * Test of getPesoTallaMenosUno method, of class CensoSeccionA.
     */
    @Test
    public void testGetPesoTallaMenosUno(){
        System.out.println("getPesoTallaMenosUno");
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        int respEsperada=0;
        instance.setPesoTallaMenosUno(0);
        int result = instance.getPesoTallaMenosUno();
        assertEquals(respEsperada, result);
    }
    /**
     * Test of setPesoTallaMenosUno method, of class CensoSeccionA.
     */
    @Test
    public void testSetPesoTallaMenosUno(){
        System.out.println("setPesoTallaMenosUno");
        int cantidad=1;
        CensoPediatriaSeccionA instance = new CensoPediatriaSeccionA();
        instance.setPesoTallaMenosUno(cantidad);
        int result=instance.getPesoTallaMenosUno();
        assertEquals(cantidad, result);
    }
    
}
