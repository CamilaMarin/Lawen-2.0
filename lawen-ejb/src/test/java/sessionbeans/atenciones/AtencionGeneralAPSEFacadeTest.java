///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.atenciones;
//
//import entities.atenciones.AtencionGeneralAPSE;
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
//public class AtencionGeneralAPSEFacadeTest {
//    @Mock
//    private AtencionGeneralAPSEFacade atencionGeneralAPSEFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    
//    public AtencionGeneralAPSEFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        atencionGeneralAPSEFacade=Mockito.mock(AtencionGeneralAPSEFacade.class);
//        atencionGeneralAPSEFacade.setEm(entityManager);
//    }
//
//    /**
//     * Test of create method, of class AtencionGeneralAPSEFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        AtencionGeneralAPSE apse = new AtencionGeneralAPSE();
//        apse.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        apse.setFechaAtencion(date);
//        List<AtencionGeneralAPSE> atencion = new ArrayList<>();
//        atencion.add(apse);
//        when(entityManager.createNamedQuery("SELECT p FROM AtencionGeneralAPSE p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionGeneralAPSE p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(atencion);
//        assertEquals(true, atencion != null);
//        
//    }
//
//    
//    /**
//     * Test of find method, of class AtencionGeneralAPSEFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        AtencionGeneralAPSE apse = new AtencionGeneralAPSE();
//        apse.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        apse.setFechaAtencion(date);
//        AtencionGeneralAPSE apseTest = new AtencionGeneralAPSE();
//        apseTest.setId(1L);
//        apseTest.setFechaAtencion(date);
//        List<AtencionGeneralAPSE> atencion = new ArrayList<>();
//        atencion.add(apse);
//        List<AtencionGeneralAPSE> atencionTest = new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM AtencionGeneralAPSE p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionGeneralAPSE p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(atencion);
//        when(atencionGeneralAPSEFacade.find(apse.getId())).thenReturn(apseTest);
//        atencionTest.add(apseTest);
//        assertEquals(atencionTest,atencion);
//        
//    }
//
//    /**
//     * Test of findAll method, of class AtencionGeneralAPSEFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        AtencionGeneralAPSE apse = new AtencionGeneralAPSE();
//        apse.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        apse.setFechaAtencion(date);
//        AtencionGeneralAPSE apse2 = new AtencionGeneralAPSE();
//        apse2.setId(2L);
//        apse2.setFechaAtencion(date);
//        List<AtencionGeneralAPSE> atencion = new ArrayList<>();
//        atencion.add(apse);
//        atencion.add(apse2);
//        List<AtencionGeneralAPSE> atencionTest = new ArrayList<>();
//        atencionTest.add(apse);
//        atencionTest.add(apse2);
//        when(entityManager.createNamedQuery("SELECT p FROM AtencionGeneralAPSE p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionGeneralAPSE p");
//        when(querys.getResultList()).thenReturn(atencion);
//        when(atencionGeneralAPSEFacade.findAll()).thenReturn(atencionTest);
//        assertEquals(atencionTest,atencion);
//    }
//
//   
//}
