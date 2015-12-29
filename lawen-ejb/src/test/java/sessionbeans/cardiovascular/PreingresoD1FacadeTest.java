/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.Paciente;
import entities.TipoPrograma;
import entities.cardiovascular.PreingresoD1;
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
public class PreingresoD1FacadeTest {
    @Mock 
    private PreingresoD1Facade preingresoD1facade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    public PreingresoD1FacadeTest() {
    }
    
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager = Mockito.mock(EntityManager.class);
        preingresoD1facade=Mockito.mock(PreingresoD1Facade.class);
        preingresoD1facade.setEm(entityManager);
        
    }

    /**
     * Test of create method, of class PreingresoD1Facade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        PreingresoD1 pre1 = new PreingresoD1();
        pre1.setId(1L);
        
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
              
        //crea tipo de programa
        
        TipoPrograma tipoPrograma =new TipoPrograma();
        tipoPrograma.setId(1L);
        tipoPrograma.setNombre_programa("Cardiovascular");
        tipoPrograma.setProgramas(null);
        
        pre1.setTipoprograma(tipoPrograma);
        
        List<PreingresoD1> preingreso1 = new ArrayList<>();
        preingreso1.add(pre1);
        when(entityManager.createNamedQuery("SELECT p FROM PreingresoD1 p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM PreingresoD1 p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(preingreso1);
        assertEquals(true, preingreso1!=null);
    }

    
    /**
     * Test of find method, of class PreingresoD1Facade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        PreingresoD1 pre1 = new PreingresoD1();
        pre1.setId(1L);
        
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
              
        //crea tipo de programa
        
        TipoPrograma tipoPrograma =new TipoPrograma();
        tipoPrograma.setId(1L);
        tipoPrograma.setNombre_programa("Cardiovascular");
        tipoPrograma.setProgramas(null);
        
        pre1.setTipoprograma(tipoPrograma);
        
        List<PreingresoD1> preingreso1 = new ArrayList<>();
        preingreso1.add(pre1);
        PreingresoD1 pre1Test = new PreingresoD1();
        pre1Test.setId(1L);
        pre1Test.setPacientes(paciente);
        pre1Test.setTipoprograma(tipoPrograma);
        
        List<PreingresoD1> preingreso1Test = new ArrayList<>();
        when(entityManager.createNamedQuery("SELECT p FROM PreingresoD1 p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM PreingresoD1 p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(preingreso1);
        when(preingresoD1facade.find(pre1.getId())).thenReturn(pre1Test);
        preingreso1Test.add(pre1Test);
        assertEquals(preingreso1Test, preingreso1);
     
    }

    /**
     * Test of findAll method, of class PreingresoD1Facade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        PreingresoD1 pre1 = new PreingresoD1();
        pre1.setId(1L);
        
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
              
        //crea tipo de programa
        
        TipoPrograma tipoPrograma =new TipoPrograma();
        tipoPrograma.setId(1L);
        tipoPrograma.setNombre_programa("Cardiovascular");
        tipoPrograma.setProgramas(null);
        
        pre1.setTipoprograma(tipoPrograma);
              
        PreingresoD1 pre12 = new PreingresoD1();
        pre12.setId(1L);
        pre12.setPacientes(paciente);
        pre12.setTipoprograma(tipoPrograma);
        PreingresoD1 pre13 = new PreingresoD1();
        pre13.setId(1L);
        pre13.setPacientes(paciente);
        pre13.setTipoprograma(tipoPrograma);
        
        List<PreingresoD1> preingreso1 = new ArrayList<>();
        preingreso1.add(pre1);
        preingreso1.add(pre12);
        preingreso1.add(pre13);
        
        List<PreingresoD1> preingreso1Test = new ArrayList<>();
        preingreso1Test.add(pre1);
        preingreso1Test.add(pre12);
        preingreso1Test.add(pre13);
        when(entityManager.createNamedQuery("SELECT p FROM PreingresoD1 p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM PreingresoD1 p");
        when(querys.getResultList()).thenReturn(preingreso1);
        when(preingresoD1facade.findAll()).thenReturn(preingreso1Test);
        
        assertEquals(preingreso1Test, preingreso1);
      
    }

    
}
