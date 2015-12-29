/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Paciente;
import entities.Patologia;
import entities.TipoPatologia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import javax.persistence.Query;

/**
 *
 * @author jeanpierre
 */
@RunWith(MockitoJUnitRunner.class)
public class PatologiaFacadeTest {
    @Mock
    private PatologiaFacade patologiaFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;    
    
    public PatologiaFacadeTest() {
    }
   
    
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager =Mockito.mock(EntityManager.class);
        patologiaFacade = Mockito.mock(PatologiaFacade.class);
        patologiaFacade.setEm(entityManager);
        
    }
    
  

    /**
     * Test of create method, of class PatologiaFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("Probando Create");
        Patologia pat=new Patologia();
        pat.setId(1L);
        
        //crear paciente
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setRut_paciente("179618524");
        paciente.setNombres_paciente("Jean");
        paciente.setApellidoPaterno_paciente("Pla");
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        paciente.setFechaNacimiento_paciente(date);
        pat.setPaciente(paciente);
        
        // crea tipo patologia
        
        TipoPatologia tipoPatologia= new TipoPatologia();
        tipoPatologia.setId(1L);
        tipoPatologia.setNombre_patologia("Diabetes");
        tipoPatologia.setPatologias(null);
        
        pat.setPatologia(tipoPatologia);
                
        List<Patologia> patologia =new ArrayList<>();
        patologia.add(pat);
        
          
        when(entityManager.createNamedQuery("SELECT p FROM Patologia p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM Patologia p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(patologia);
        //when(patologiaFacade.findAll()).thenReturn(patTest);
        assertEquals(true, patologia!=null);
    }
   
   
    /**
     * Test of find method, of class PatologiaFacade.
     */
    @Test
    public void testFind() throws Exception {
        
         System.out.println("Probando Remove");
        Patologia pat=new Patologia();
        pat.setId(1L);
        
        //crear paciente
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setRut_paciente("179618524");
        paciente.setNombres_paciente("Jean");
        paciente.setApellidoPaterno_paciente("Pla");
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        paciente.setFechaNacimiento_paciente(date);
        pat.setPaciente(paciente);
        
        // crea tipo patologia
        
        TipoPatologia tipoPatologia= new TipoPatologia();
        tipoPatologia.setId(1L);
        tipoPatologia.setNombre_patologia("Diabetes");
        tipoPatologia.setPatologias(null);
        
        pat.setPatologia(tipoPatologia);
                
        List<Patologia> patologia =new ArrayList<>();
        patologia.add(pat);
        
        Patologia patTest=new Patologia();
        patTest.setId(1L);
        patTest.setPaciente(paciente);
        patTest.setPatologia(tipoPatologia);
        
        List<Patologia> patologiaTest =new ArrayList<>();
        
        when(entityManager.createNamedQuery("SELECT p FROM Patologia p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM Patologia p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(patologia);
        when(patologiaFacade.find(pat.getId())).thenReturn(patTest);
        patologiaTest.add(patTest);
        assertEquals(patologiaTest, patologia);
       
    }

     /**
     * Test of findAll method, of class PatologiaFacade.
     */
    @Test
    public void testFindAll() throws ParseException {
        System.out.println("Probando FindAll");
        //Se crea patologia
        Patologia p1=new Patologia();
        p1.setId(1L);
        
        //Se crea nuevo paciente
        
        Paciente paciente=new Paciente();
        paciente.setId(1L);
        paciente.setRut_paciente("179618524");
        paciente.setNombres_paciente("Jean");
        paciente.setApellidoPaterno_paciente("Pla");
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        paciente.setFechaNacimiento_paciente(date);
        p1.setPaciente(paciente);
        
        // crea nueva tipo patologia
       
        TipoPatologia tipoPatologia= new TipoPatologia();
        tipoPatologia.setId(1L);
        tipoPatologia.setNombre_patologia("Diabetes");
        tipoPatologia.setPatologias(null);
        
        p1.setPatologia(tipoPatologia);
        
        // parte p2
        
        Patologia p2=new Patologia();
        p2.setId(1L);          
        p2.setPaciente(paciente);                      
        p2.setPatologia(tipoPatologia);
        
        // parte p3
        
        Patologia p3=new Patologia();
        p3.setId(1L);          
        p3.setPaciente(paciente);                      
        p3.setPatologia(tipoPatologia);
        
        List<Patologia> pat =new ArrayList<>();
        pat.add(p1);
        pat.add(p2);
        pat.add(p3);
        
        List<Patologia> patTest =new ArrayList<>();
        patTest.add(p2);
        patTest.add(p1);
        patTest.add(p3);
        
        when(entityManager.createNamedQuery("SELECT a FROM Patologia a")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT a FROM Patologia a");
        when(querys.getResultList()).thenReturn(pat);
        when(patologiaFacade.findAll()).thenReturn(patTest);
        assertEquals(patTest, pat);
    }
   
    
}
