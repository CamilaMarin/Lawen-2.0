///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.atenciones;
//
//import entities.atenciones.AtencionEnfFEMPA;
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
//public class AtencionEnfFEMPAFacadeTest {
//    @Mock
//    private AtencionEnfFEMPAFacade atencionEnfFEMPAFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    public AtencionEnfFEMPAFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        atencionEnfFEMPAFacade=Mockito.mock(AtencionEnfFEMPAFacade.class);
//        atencionEnfFEMPAFacade.setEm(entityManager);
//    }
//
//    /**
//     * Test of create method, of class AtencionEnfFEMPAFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        AtencionEnfFEMPA empa = new AtencionEnfFEMPA();
//        empa.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        empa.setFechaEmpa(date);
//        List<AtencionEnfFEMPA> atencion = new ArrayList<>();
//        atencion.add(empa);
//        when(entityManager.createNamedQuery("SELECT p FROM AtencionEnfFEMPA p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionEnfFEMPA p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(atencion);
//        assertEquals(true, atencion != null);
//        
//    }
//
//   /**
//     * Test of find method, of class AtencionEnfFEMPAFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        AtencionEnfFEMPA empa = new AtencionEnfFEMPA();
//        empa.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        empa.setFechaEmpa(date);
//        AtencionEnfFEMPA empaTest = new AtencionEnfFEMPA();
//        empaTest.setId(1L);
//        empaTest.setFechaEmpa(date);
//        List<AtencionEnfFEMPA> atencion = new ArrayList<>();
//        atencion.add(empa);
//        List<AtencionEnfFEMPA> atencionTest = new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM AtencionEnfFEMPA p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionEnfFEMPA p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(atencion);
//        when(atencionEnfFEMPAFacade.find(empa.getId())).thenReturn(empaTest);
//        atencionTest.add(empaTest);
//        assertEquals(atencionTest, atencion);
//    }
//
//    /**
//     * Test of findAll method, of class AtencionEnfFEMPAFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        AtencionEnfFEMPA empa = new AtencionEnfFEMPA();
//        empa.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        empa.setFechaEmpa(date);
//        AtencionEnfFEMPA empa2 = new AtencionEnfFEMPA();
//        empa2.setId(1L);
//        empa2.setFechaEmpa(date);
//        List<AtencionEnfFEMPA> atencion = new ArrayList<>();
//        atencion.add(empa);
//        atencion.add(empa2);
//        List<AtencionEnfFEMPA> atencionTest = new ArrayList<>();
//        atencionTest.add(empa);
//        atencionTest.add(empa2);
//        when(entityManager.createNamedQuery("SELECT p FROM AtencionEnfFEMPA p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionEnfFEMPA p");
//        when(querys.getResultList()).thenReturn(atencion);
//        when(atencionEnfFEMPAFacade.findAll()).thenReturn(atencionTest);
//        
//        assertEquals(atencionTest, atencion);
//       
//    }
//
//}
