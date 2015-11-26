///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans;
//
//import entities.Paciente;
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
//public class PacienteFacadeTest {
//    @Mock
//    private PacienteFacade pacienteFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query; 
//    
//    public PacienteFacadeTest() {
//    }
//    
//    
//    @Before
//    public void setUp() {
//        
//        query = mock(Query.class);
//        entityManager =Mockito.mock(EntityManager.class);
//        pacienteFacade= Mockito.mock(PacienteFacade.class);
//        pacienteFacade.setEm(entityManager);
//        
//        
//    }
// 
//
//    /**
//     * Test of create method, of class PacienteFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        //crear paciente
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
//        List<Paciente> pacientes=new ArrayList<>();
//        pacientes.add(paciente);
//        when(entityManager.createNamedQuery("SELECT p FROM Paciente p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM Paciente p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(pacientes);
//        assertEquals(true, pacientes!=null);
//    }
//
//        /**
//     * Test of find method, of class PacienteFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        //crear paciente
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
//        List<Paciente> pacientes=new ArrayList<>();
//        pacientes.add(paciente);
//        Paciente pacienteTest = new Paciente();
//        pacienteTest.setId(1L);
//        pacienteTest.setRut_paciente("179618524");
//        pacienteTest.setNombres_paciente("Jean");
//        pacienteTest.setApellidoPaterno_paciente("Pla");
//        pacienteTest.setFechaNacimiento_paciente(date);
//        
//        List<Paciente> pacientesTest=new ArrayList<>();
//        
//        
//        
//        when(entityManager.createNamedQuery("SELECT p FROM Paciente p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM Paciente p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(pacientes);
//        when(pacienteFacade.find(paciente.getId())).thenReturn(pacienteTest);
//        pacientesTest.add(pacienteTest);
//        assertEquals(pacientesTest, pacientes);
//        
//    }
//
//    
//    /**
//     * Test of findAll method, of class PacienteFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
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
//         //crear paciente2
//        Paciente paciente2 = new Paciente();
//        paciente2.setId(2L);
//        paciente2.setRut_paciente("187764802");
//        paciente2.setNombres_paciente("Juan");
//        paciente2.setApellidoPaterno_paciente("Perez");
//        SimpleDateFormat simpleDateFormat2 =new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date2;
//        date2 = simpleDateFormat2.parse("06/06/1989");
//        paciente2.setFechaNacimiento_paciente(date2);
//        
//         //crear paciente3
//        Paciente paciente3 = new Paciente();
//        paciente3.setId(3L);
//        paciente3.setRut_paciente("79344613");
//        paciente3.setNombres_paciente("Maria");
//        paciente3.setApellidoPaterno_paciente("Meza");
//        SimpleDateFormat simpleDateFormat3 =new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date3;
//        date3 = simpleDateFormat3.parse("12/12/1999");
//        paciente3.setFechaNacimiento_paciente(date3);
//        
//        List<Paciente> pacientes =new ArrayList<>();
//        pacientes.add(paciente);
//        pacientes.add(paciente2);
//        pacientes.add(paciente3);
//        
//        List<Paciente> pacientesTest =new ArrayList<>();
//        pacientesTest.add(paciente);
//        pacientesTest.add(paciente2);
//        pacientesTest.add(paciente3);
//        
//        when(entityManager.createNamedQuery("SELECT a FROM Paciente a")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT a FROM Paciente a");
//        when(querys.getResultList()).thenReturn(pacientes);
//        when(pacienteFacade.findAll()).thenReturn(pacientesTest);
//         assertEquals(pacientesTest, pacientes);
//        
//         
//        
//        
//    }
//
//       
//}