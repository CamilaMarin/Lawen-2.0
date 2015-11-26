///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.cardiovascular;
//
//import entities.Paciente;
//import entities.TipoPrograma;
//import entities.cardiovascular.PreingresoD2;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import org.mockito.runners.MockitoJUnitRunner;
//
///**
// *
// * @author jeanpierre
// */
//@RunWith(MockitoJUnitRunner.class)
//public class PreingresoD2FacadeTest {
//    @Mock 
//    private PreingresoD2Facade preingresoD2facade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    public PreingresoD2FacadeTest() {
//    }
//        
//    @Before
//    public void setUp() {
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        preingresoD2facade=Mockito.mock(PreingresoD2Facade.class);
//        preingresoD2facade.setEm(entityManager);
//    }
//    
//    
//
//    /**
//     * Test of create method, of class PreingresoD2Facade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        PreingresoD2 pre2 = new PreingresoD2();
//        pre2.setId(1L);
//
//        //crear paciente
//        Paciente paciente = new Paciente();
//        paciente.setId(1L);
//        paciente.setRut_paciente("179618524");
//        paciente.setNombres_paciente("Jean");
//        paciente.setApellidoPaterno_paciente("Pla");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        paciente.setFechaNacimiento_paciente(date);
//
//        //crea tipo de programa
//        TipoPrograma tipoPrograma = new TipoPrograma();
//        tipoPrograma.setId(1L);
//        tipoPrograma.setNombre_programa("Cardiovascular");
//        tipoPrograma.setProgramas(null);
//
//        pre2.setTipoprograma(tipoPrograma);
//
//        List<PreingresoD2> preingreso2 = new ArrayList<>();
//        preingreso2.add(pre2);
//        when(entityManager.createNamedQuery("SELECT p FROM PreingresoD2 p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM PreingresoD2 p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(preingreso2);
//        assertEquals(true, preingreso2 != null);
//    }
//
//    
//
//    /**
//     * Test of find method, of class PreingresoD2Facade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        PreingresoD2 pre2 = new PreingresoD2();
//        pre2.setId(1L);
//        
//         //crear paciente
//        Paciente paciente = new Paciente();
//        paciente.setId(1L);
//        paciente.setRut_paciente("179618524");
//        paciente.setNombres_paciente("Jean");
//        paciente.setApellidoPaterno_paciente("Pla");
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        paciente.setFechaNacimiento_paciente(date);
//              
//        //crea tipo de programa
//        
//        TipoPrograma tipoPrograma =new TipoPrograma();
//        tipoPrograma.setId(1L);
//        tipoPrograma.setNombre_programa("Cardiovascular");
//        tipoPrograma.setProgramas(null);
//        
//        pre2.setTipoprograma(tipoPrograma);
//        
//        List<PreingresoD2> preingreso2 = new ArrayList<>();
//        preingreso2.add(pre2);
//        PreingresoD2 pre2Test = new PreingresoD2();
//        pre2Test.setId(1L);
//        pre2Test.setPacientes(paciente);
//        pre2Test.setTipoprograma(tipoPrograma);
//        
//        List<PreingresoD2> preingreso2Test = new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM PreingresoD2 p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM PreingresoD2 p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(preingreso2);
//        when(preingresoD2facade.find(pre2.getId())).thenReturn(pre2Test);
//        preingreso2Test.add(pre2Test);
//        assertEquals(preingreso2Test, preingreso2);
//      
//    }
//
//    /**
//     * Test of findAll method, of class PreingresoD2Facade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        PreingresoD2 pre2 = new PreingresoD2();
//        pre2.setId(1L);
//        
//         //crear paciente
//        Paciente paciente = new Paciente();
//        paciente.setId(1L);
//        paciente.setRut_paciente("179618524");
//        paciente.setNombres_paciente("Jean");
//        paciente.setApellidoPaterno_paciente("Pla");
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        paciente.setFechaNacimiento_paciente(date);
//              
//        //crea tipo de programa
//        
//        TipoPrograma tipoPrograma =new TipoPrograma();
//        tipoPrograma.setId(1L);
//        tipoPrograma.setNombre_programa("Cardiovascular");
//        tipoPrograma.setProgramas(null);
//        
//        pre2.setTipoprograma(tipoPrograma);
//              
//        PreingresoD2 pre22 = new PreingresoD2();
//        pre22.setId(1L);
//        pre22.setPacientes(paciente);
//        pre22.setTipoprograma(tipoPrograma);
//        PreingresoD2 pre23 = new PreingresoD2();
//        pre23.setId(1L);
//        pre23.setPacientes(paciente);
//        pre23.setTipoprograma(tipoPrograma);
//        
//        List<PreingresoD2> preingreso2 = new ArrayList<>();
//        preingreso2.add(pre2);
//        preingreso2.add(pre22);
//        preingreso2.add(pre23);
//        
//        List<PreingresoD2> preingreso2Test = new ArrayList<>();
//        preingreso2Test.add(pre2);
//        preingreso2Test.add(pre22);
//        preingreso2Test.add(pre23);
//        when(entityManager.createNamedQuery("SELECT p FROM PreingresoD2 p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM PreingresoD2 p");
//        when(querys.getResultList()).thenReturn(preingreso2);
//        when(preingresoD2facade.findAll()).thenReturn(preingreso2Test);
//        
//        assertEquals(preingreso2Test, preingreso2);
//        
//    }
//
//    
//}
