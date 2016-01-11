/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Paciente;
import entities.Subprograma;
import java.text.ParseException;
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
public class SubprogramaFacadeTest {
    private static SubprogramaFacade mockSubprogramaFacade;
    private static Subprograma subprograma1;
    private static Subprograma subprograma2;
    private static Paciente paciente;
    
    public SubprogramaFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mockSubprogramaFacade=mock(SubprogramaFacade.class);
        paciente=new Paciente();
        paciente.setId(1L);
        
        subprograma1= new Subprograma();
        subprograma1.setId(1L);
        subprograma1.setPaciente(paciente);
        
        subprograma2=new Subprograma();
        subprograma2.setId(2L);
        subprograma2.setPaciente(paciente);
        
        List<Subprograma> subprogramas=new ArrayList<>();
        subprogramas.add(subprograma1); 
        subprogramas.add(subprograma2); 
        
        when(mockSubprogramaFacade.findbyPaciente(paciente)).thenReturn(subprogramas);      
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testFindbyPaciente() throws ParseException{
        System.out.println("testFindbyPaciente");
        Paciente expPaciente=new Paciente();
        expPaciente.setId(1L);
        
        Subprograma expSubprograma1=new Subprograma();
        expSubprograma1.setId(1L);
        expSubprograma1.setPaciente(expPaciente);
        
        Subprograma expSubprograma2=new Subprograma();
        expSubprograma2.setId(2L);
        expSubprograma2.setPaciente(expPaciente);
        
        List<Subprograma> expSubprogramas=new ArrayList<>();
        expSubprogramas.add(expSubprograma1);
        expSubprogramas.add(expSubprograma2);
        
        assertEquals(expSubprogramas, mockSubprogramaFacade.findbyPaciente(expPaciente));
    }
}
