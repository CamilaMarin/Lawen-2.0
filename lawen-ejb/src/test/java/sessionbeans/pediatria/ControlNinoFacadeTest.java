/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.pediatria;

import entities.pediatria.CartolaControlesNino;
import entities.pediatria.ControlNino;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author IHC
 */
public class ControlNinoFacadeTest {
    
    private static ControlNinoFacade mockControlNinoFacade;
    private static ControlNino controlnino;
    private static ControlNino controlnino1;
    private static CartolaControlesNino cartolanino;
    
    public ControlNinoFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        mockControlNinoFacade = mock(ControlNinoFacade.class);
        cartolanino= new CartolaControlesNino();
        cartolanino.setId(1L);
        
        controlnino= new ControlNino();
        controlnino.setId(1L);
        controlnino.setCartolaControlesNino(cartolanino);
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        controlnino.setFechaControl(date);
        
        controlnino1= new ControlNino();
        controlnino1.setId(2L);
        controlnino1.setCartolaControlesNino(cartolanino);
        date = simpleDateFormat.parse("12/12/2015");
        controlnino1.setFechaControl(date);
        
        List<ControlNino> controles1=new ArrayList<>();
        controles1.add(controlnino);
        controles1.add(controlnino1);
        
        List<ControlNino> controles2=new ArrayList<>();
        controles2.add(controlnino1);
        
        when(mockControlNinoFacade.findLastControl(controles1)).thenReturn(controles2);
        when(mockControlNinoFacade.findbyCartola(cartolanino.getId())).thenReturn(controles1);
    }
    
    
    @After
    public void tearDown() {
    }
    
    @Test 
    public void testFindLastControl() throws Exception {
        System.out.println("findLastControl");
        CartolaControlesNino extCartola = new CartolaControlesNino();
        extCartola.setId(1L);
        
        ControlNino expControl1 = new ControlNino();
        expControl1.setId(1L);
        expControl1.setCartolaControlesNino(extCartola);
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        expControl1.setFechaControl(date);
        
        ControlNino expControl2 = new ControlNino();
        expControl2.setId(2L);
        expControl2.setCartolaControlesNino(extCartola);
        date = simpleDateFormat.parse("12/12/2015");
        expControl2.setFechaControl(date);
        
        List<ControlNino> expControles1=new ArrayList<>();
        expControles1.add(expControl1);
        expControles1.add(expControl2);
        
        List<ControlNino> expControles2=new ArrayList<>();
        expControles2.add(expControl2);
        
        assertEquals(expControles2, mockControlNinoFacade.findLastControl(expControles1));
    }
    
    @Test 
    public void testFindByCartola() throws Exception {
        System.out.println("findbyLastControl");
        CartolaControlesNino expCartola = new CartolaControlesNino();
        expCartola.setId(1L);
        
        ControlNino expControl1 = new ControlNino();
        expControl1.setId(1L);
        expControl1.setCartolaControlesNino(expCartola);
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        expControl1.setFechaControl(date);
        
        ControlNino expControl2 = new ControlNino();
        expControl2.setId(2L);
        expControl2.setCartolaControlesNino(expCartola);
        date = simpleDateFormat.parse("12/12/2015");
        expControl2.setFechaControl(date);
        
        List<ControlNino> expControles1=new ArrayList<>();
        expControles1.add(expControl1);
        expControles1.add(expControl2);
        
        assertEquals(expControles1, mockControlNinoFacade.findbyCartola(expCartola.getId()));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
}
