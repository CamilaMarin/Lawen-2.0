/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.Paciente;
import entities.TipoPrograma;
import entities.cardiovascular.PreingresoD3;
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
public class PreingresoD3FacadeTest {
    @Mock 
    private PreingresoD3Facade preingresoD3facade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    
    public PreingresoD3FacadeTest() {
    }
    @Before
    public void setUp() {
        
        query = mock(Query.class);
        entityManager = Mockito.mock(EntityManager.class);
        preingresoD3facade = Mockito.mock(PreingresoD3Facade.class);
        preingresoD3facade.setEm(entityManager);
    }
   

    /**
     * Test of create method, of class PreingresoD3Facade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        PreingresoD3 pre3 = new PreingresoD3();
        pre3.setId(1L);

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

        //crea tipo de programa
        TipoPrograma tipoPrograma = new TipoPrograma();
        tipoPrograma.setId(1L);
        tipoPrograma.setNombre_programa("Cardiovascular");
        tipoPrograma.setProgramas(null);

        pre3.setTipoprograma(tipoPrograma);

        List<PreingresoD3> preingreso3 = new ArrayList<>();
        preingreso3.add(pre3);
        when(entityManager.createNamedQuery("SELECT p FROM PreingresoD3 p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM PreingresoD3 p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(preingreso3);
        assertEquals(true, preingreso3 != null);
        
    }

    
    /**
     * Test of find method, of class PreingresoD3Facade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        PreingresoD3 pre3 = new PreingresoD3();
        pre3.setId(1L);

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

        //crea tipo de programa
        TipoPrograma tipoPrograma = new TipoPrograma();
        tipoPrograma.setId(1L);
        tipoPrograma.setNombre_programa("Cardiovascular");
        tipoPrograma.setProgramas(null);

        pre3.setTipoprograma(tipoPrograma);

        List<PreingresoD3> preingreso3 = new ArrayList<>();
        preingreso3.add(pre3);
        PreingresoD3 pre3Test = new PreingresoD3();
        pre3Test.setId(1L);
        pre3Test.setPacientes(paciente);
        pre3Test.setTipoprograma(tipoPrograma);

        List<PreingresoD3> preingreso3Test = new ArrayList<>();
        when(entityManager.createNamedQuery("SELECT p FROM PreingresoD3 p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM PreingresoD3 p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(preingreso3);
        when(preingresoD3facade.find(pre3.getId())).thenReturn(pre3Test);
        preingreso3Test.add(pre3Test);
        assertEquals(preingreso3Test, preingreso3);
        
    }

    /**
     * Test of findAll method, of class PreingresoD3Facade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        PreingresoD3 pre3 = new PreingresoD3();
        pre3.setId(1L);

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

        //crea tipo de programa
        TipoPrograma tipoPrograma = new TipoPrograma();
        tipoPrograma.setId(1L);
        tipoPrograma.setNombre_programa("Cardiovascular");
        tipoPrograma.setProgramas(null);

        pre3.setTipoprograma(tipoPrograma);

        PreingresoD3 pre32 = new PreingresoD3();
        pre32.setId(1L);
        pre32.setPacientes(paciente);
        pre32.setTipoprograma(tipoPrograma);
        PreingresoD3 pre33 = new PreingresoD3();
        pre33.setId(1L);
        pre33.setPacientes(paciente);
        pre33.setTipoprograma(tipoPrograma);

        List<PreingresoD3> preingreso3 = new ArrayList<>();
        preingreso3.add(pre3);
        preingreso3.add(pre32);
        preingreso3.add(pre33);

        List<PreingresoD3> preingreso3Test = new ArrayList<>();
        preingreso3Test.add(pre3);
        preingreso3Test.add(pre32);
        preingreso3Test.add(pre33);
        when(entityManager.createNamedQuery("SELECT p FROM PreingresoD3 p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM PreingresoD3 p");
        when(querys.getResultList()).thenReturn(preingreso3);
        when(preingresoD3facade.findAll()).thenReturn(preingreso3Test);

        assertEquals(preingreso3Test, preingreso3);
        
        
    }

        
}
