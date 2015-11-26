///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.adultoMayor;
//
//import entities.adultoMayor.EsferaFuncionalPSAM;
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
//public class EsferaFuncionalPSAMFacadeTest {
//    @Mock
//    private EsferaFuncionalPSAMFacade esferaFuncionalPSAMFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    public EsferaFuncionalPSAMFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        esferaFuncionalPSAMFacade=Mockito.mock(EsferaFuncionalPSAMFacade.class);
//        esferaFuncionalPSAMFacade.setEm(entityManager);
//    }
//
//    /**
//     * Test of create method, of class EsferaFuncionalPSAMFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        EsferaFuncionalPSAM eFuncional = new EsferaFuncionalPSAM();
//        eFuncional.setId(1L);
//        List<EsferaFuncionalPSAM> esferas = new ArrayList<>();
//        esferas.add(eFuncional);
//        when(entityManager.createNamedQuery("SELECT p FROM EsferaFuncionalPSAM p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM EsferaFuncionalPSAM p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(esferas);
//        assertEquals(true, esferas!=null);
//    }
//    
//    /**
//     * Test of find method, of class EsferaFuncionalPSAMFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        EsferaFuncionalPSAM eFuncional = new EsferaFuncionalPSAM();
//        eFuncional.setId(1L);
//        EsferaFuncionalPSAM eFuncionalTest = new EsferaFuncionalPSAM();
//        eFuncionalTest.setId(1L);
//        List<EsferaFuncionalPSAM> esferas = new ArrayList<>();
//        esferas.add(eFuncional);
//        List<EsferaFuncionalPSAM> esferasTest = new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM EsferaFuncionalPSAM p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM EsferaFuncionalPSAM p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(esferas);
//        when(esferaFuncionalPSAMFacade.find(eFuncional.getId())).thenReturn(eFuncionalTest);
//        esferasTest.add(eFuncionalTest);
//        assertEquals(esferasTest, esferas);
//    }
//
//    /**
//     * Test of findAll method, of class EsferaFuncionalPSAMFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        EsferaFuncionalPSAM eFuncional = new EsferaFuncionalPSAM();
//        eFuncional.setId(1L);
//        EsferaFuncionalPSAM eFuncional2 = new EsferaFuncionalPSAM();
//        eFuncional2.setId(2L);
//        List<EsferaFuncionalPSAM> esferas = new ArrayList<>();
//        esferas.add(eFuncional);
//        esferas.add(eFuncional2);
//        List<EsferaFuncionalPSAM> esferasTest = new ArrayList<>();
//        esferasTest.add(eFuncional);
//        esferasTest.add(eFuncional2);
//        when(entityManager.createNamedQuery("SELECT p FROM EsferaFuncionalPSAM p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM EsferaFuncionalPSAM p");
//        when(querys.getResultList()).thenReturn(esferas);
//        when(esferaFuncionalPSAMFacade.findAll()).thenReturn(esferasTest);
//        assertEquals(esferasTest, esferas);
//    }
//
//}
