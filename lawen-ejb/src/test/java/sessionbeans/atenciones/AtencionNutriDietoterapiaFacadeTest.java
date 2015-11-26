///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.atenciones;
//
//import entities.Paciente;
//import entities.atenciones.AtencionNutriDietoterapia;
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
//public class AtencionNutriDietoterapiaFacadeTest {
//    @Mock
//    private AtencionNutriDietoterapiaFacade atencionNutriDietoterapiaFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    
//    public AtencionNutriDietoterapiaFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        
//        query = mock(Query.class);
//        entityManager =Mockito.mock(EntityManager.class);
//        atencionNutriDietoterapiaFacade=Mockito.mock(AtencionNutriDietoterapiaFacade.class);
//        atencionNutriDietoterapiaFacade.setEm(entityManager);
//    }   
//
//    /**
//     * Test of create method, of class AtencionNutriDietoterapiaFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        AtencionNutriDietoterapia dietoterapia = new AtencionNutriDietoterapia();
//        dietoterapia.setId(1L);
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/2014");
//        dietoterapia.setFecha_control(date);
//        Paciente paciente = new Paciente();
//        paciente.setId(1L);
//        paciente.setRut_paciente("179618524");
//        paciente.setNombres_paciente("Jean");
//        paciente.setApellidoPaterno_paciente("Pla");
//        dietoterapia.setPaciente(paciente);
//        List<AtencionNutriDietoterapia> atencion = new ArrayList<>();
//        atencion.add(dietoterapia);
//        when(entityManager.createNamedQuery("SELECT p FROM AtencionNutriDietoterapia p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionNutriDietoterapia p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(atencion);
//        assertEquals(true, atencion!=null);
//        
//        
//    }
//
//   
//    /**
//     * Test of find method, of class AtencionNutriDietoterapiaFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        AtencionNutriDietoterapia dietoterapia = new AtencionNutriDietoterapia();
//        dietoterapia.setId(1L);
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/2014");
//        dietoterapia.setFecha_control(date);
//        Paciente paciente = new Paciente();
//        paciente.setId(1L);
//        paciente.setRut_paciente("179618524");
//        paciente.setNombres_paciente("Jean");
//        paciente.setApellidoPaterno_paciente("Pla");
//        dietoterapia.setPaciente(paciente);
//        AtencionNutriDietoterapia dietoterapia2 = new AtencionNutriDietoterapia();
//        dietoterapia2.setId(1L);
//        dietoterapia2.setFecha_control(date);
//        dietoterapia2.setPaciente(paciente);
//        List<AtencionNutriDietoterapia> atencion = new ArrayList<>();
//        atencion.add(dietoterapia);
//        List<AtencionNutriDietoterapia> atencionTest = new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM AtencionNutriDietoterapia p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionNutriDietoterapia p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(atencion);
//        when(atencionNutriDietoterapiaFacade.find(dietoterapia.getId())).thenReturn(dietoterapia2);
//        atencionTest.add(dietoterapia2);
//        assertEquals(atencionTest, atencion);
//        
//    }
//
//    /**
//     * Test of findAll method, of class AtencionNutriDietoterapiaFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        AtencionNutriDietoterapia dietoterapia = new AtencionNutriDietoterapia();
//        dietoterapia.setId(1L);
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/2014");
//        dietoterapia.setFecha_control(date);
//        Paciente paciente = new Paciente();
//        paciente.setId(1L);
//        paciente.setRut_paciente("179618524");
//        paciente.setNombres_paciente("Jean");
//        paciente.setApellidoPaterno_paciente("Pla");
//        dietoterapia.setPaciente(paciente);
//        AtencionNutriDietoterapia dietoterapia2 = new AtencionNutriDietoterapia();
//        dietoterapia2.setId(2L);
//        dietoterapia2.setFecha_control(date);
//        dietoterapia2.setPaciente(paciente);
//        List<AtencionNutriDietoterapia> atencion = new ArrayList<>();
//        atencion.add(dietoterapia);
//        atencion.add(dietoterapia2);
//        List<AtencionNutriDietoterapia> atencionTest = new ArrayList<>();
//        atencionTest.add(dietoterapia);
//        atencionTest.add(dietoterapia2);
//        when(entityManager.createNamedQuery("SELECT p FROM AtencionNutriDietoterapia p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionNutriDietoterapia p");
//        when(querys.getResultList()).thenReturn(atencion);
//        when(atencionNutriDietoterapiaFacade.findAll()).thenReturn(atencionTest);
//       
//        assertEquals(atencionTest, atencion);
//    }
//
//    
//    
//}
