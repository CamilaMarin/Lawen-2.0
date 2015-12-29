/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Paciente;
import entities.Programa;
import entities.TipoPrograma;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author jeanpierre
 */
@RunWith(MockitoJUnitRunner.class)
public class ProgramaFacadeTest {
    @Mock
    private ProgramaFacade programaFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query; 
    public ProgramaFacadeTest() {
    }
    
      
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager =Mockito.mock(EntityManager.class);
        programaFacade=Mockito.mock(ProgramaFacade.class);
        programaFacade.setEm(entityManager);
    }
    
  

    /**
     * Test of create method, of class ProgramaFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Programa programa = new Programa();
        programa.setId(1L);
        
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
        programa.setPaciente(paciente);
        
        //crea tipo de programa
        
        TipoPrograma tipoPrograma =new TipoPrograma();
        tipoPrograma.setId(1L);
        tipoPrograma.setNombre_programa("Cardiovascular");
        tipoPrograma.setProgramas(null);
        programa.setPrograma(tipoPrograma);
        
        List<Programa> programas =new ArrayList<>();
        programas.add(programa);
        
        when(entityManager.createNamedQuery("SELECT p FROM Programa p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM Programa p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(programas);
        assertEquals(true, programas!=null);              
     
    }

   
    /**
     * Test of find, of class ProgramaFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Programa programa = new Programa();
        programa.setId(1L);
        
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
        programa.setPaciente(paciente);
        
        //crea tipo de programa
        
        TipoPrograma tipoPrograma =new TipoPrograma();
        tipoPrograma.setId(1L);
        tipoPrograma.setNombre_programa("Cardiovascular");
        tipoPrograma.setProgramas(null);
        programa.setPrograma(tipoPrograma);
        
        Programa programaTest =new Programa();
        programaTest.setId(1L);
        programaTest.setPaciente(paciente);
        programaTest.setPrograma(tipoPrograma);
        
        List<Programa> programas =new ArrayList<>();
        programas.add(programa);
        List<Programa> programasTest=new ArrayList<>();
        
        
        when(entityManager.createNamedQuery("SELECT p FROM Programa p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM Programa p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(programas);
        when(programaFacade.find(tipoPrograma.getId())).thenReturn( programaTest);
        programasTest.add(programaTest);
        assertEquals(programasTest, programas);
    }

    
    /**
     * Test of findAll method, of class ProgramaFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Programa programa = new Programa();
        programa.setId(1L);

        //crear paciente
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setRut_paciente("179618524");
        paciente.setNombres_paciente("Jean");
        paciente.setApellidoPaterno_paciente("Pla");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        paciente.setFechaNacimiento_paciente(date);
        programa.setPaciente(paciente);

        //crea tipo de programa
        TipoPrograma tipoPrograma = new TipoPrograma();
        tipoPrograma.setId(1L);
        tipoPrograma.setNombre_programa("Cardiovascular");
        tipoPrograma.setProgramas(null);
        programa.setPrograma(tipoPrograma);

        Programa programa2 = new Programa();
        programa2.setId(2L);
        programa2.setPaciente(paciente);
        programa2.setPrograma(tipoPrograma);
        
        Programa programa3 = new Programa();
        programa3.setId(3L);
        programa3.setPaciente(paciente);
        programa3.setPrograma(tipoPrograma);
        
        List<Programa> programas = new ArrayList<>();
        programas.add(programa);
        programas.add(programa2);
        programas.add(programa3);
        List<Programa> programasTest = new ArrayList<>();
        programasTest.add(programa);
        programasTest.add(programa2);
        programasTest.add(programa3);
        
        when(entityManager.createNamedQuery("SELECT a FROM Programa a")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT a FROM Programa a");
        when(querys.getResultList()).thenReturn(programas);
        when(programaFacade.findAll()).thenReturn(programasTest);
        assertEquals(programasTest, programas);
        
    }

}
