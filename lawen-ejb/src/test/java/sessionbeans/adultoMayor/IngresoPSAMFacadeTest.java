///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.adultoMayor;
//
//import entities.adultoMayor.IngresoPSAM;
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
//public class IngresoPSAMFacadeTest {
//    @Mock
//    private IngresoPSAMFacade ingresoPSAMFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    
//    public IngresoPSAMFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        ingresoPSAMFacade=Mockito.mock(IngresoPSAMFacade.class);
//        ingresoPSAMFacade.setEm(entityManager);
//    }
//
//    /**
//     * Test of create method, of class IngresoPSAMFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        IngresoPSAM ingreso = new IngresoPSAM();
//        ingreso.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        ingreso.setFechaIngresoPSAM(date);
//        List<IngresoPSAM> ingresos =new ArrayList<>();
//        ingresos.add(ingreso);
//        when(entityManager.createNamedQuery("SELECT p FROM IngresoPSAM p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM IngresoPSAM p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(ingresos);
//        assertEquals(true, ingresos!=null);
//        
//        
//    }
//
//    
//    /**
//     * Test of find method, of class IngresoPSAMFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        IngresoPSAM ingreso = new IngresoPSAM();
//        ingreso.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        ingreso.setFechaIngresoPSAM(date);
//        IngresoPSAM ingresoTest = new IngresoPSAM();
//        ingresoTest.setId(1L);
//        ingresoTest.setFechaIngresoPSAM(date);
//        List<IngresoPSAM> ingresos = new ArrayList<>();
//        ingresos.add(ingreso);
//        List<IngresoPSAM> ingresosTest = new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM IngresoPSAM p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM IngresoPSAM p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(ingresos);
//        when(ingresoPSAMFacade.find(ingreso.getId())).thenReturn(ingresoTest);
//        ingresosTest.add(ingresoTest);
//        assertEquals(ingresosTest, ingresos);
//    }
//
//    /**
//     * Test of findAll method, of class IngresoPSAMFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        IngresoPSAM ingreso = new IngresoPSAM();
//        ingreso.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        ingreso.setFechaIngresoPSAM(date);
//        IngresoPSAM ingreso2 = new IngresoPSAM();
//        ingreso2.setId(1L);
//        ingreso2.setFechaIngresoPSAM(date);
//        List<IngresoPSAM> ingresos = new ArrayList<>();
//        ingresos.add(ingreso);
//        ingresos.add(ingreso2);
//        List<IngresoPSAM> ingresosTest = new ArrayList<>();
//        ingresosTest.add(ingreso);
//        ingresosTest.add(ingreso2);
//        when(entityManager.createNamedQuery("SELECT p FROM IngresoPSAM p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM IngresoPSAM p");
//        when(querys.getResultList()).thenReturn(ingresos);
//        when(ingresoPSAMFacade.findAll()).thenReturn(ingresosTest);
//        assertEquals(ingresosTest, ingresos);
//        
//    }
//
//    
//}
