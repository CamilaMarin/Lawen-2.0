///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.adultoMayor;
//
//import entities.adultoMayor.EsferaSocialPSAM;
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
//public class EsferaSocialPSAMFacadeTest {
//    @Mock
//    private EsferaSocialPSAMFacade esferaSocialPSAMFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    public EsferaSocialPSAMFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        esferaSocialPSAMFacade=Mockito.mock(EsferaSocialPSAMFacade.class);
//        esferaSocialPSAMFacade.setEm(entityManager);
//    }
//
//    /**
//     * Test of create method, of class EsferaSocialPSAMFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        EsferaSocialPSAM eSocial = new EsferaSocialPSAM();
//        eSocial.setId(1L);
//        List<EsferaSocialPSAM> esferas = new ArrayList<>();
//        esferas.add(eSocial);
//        when(entityManager.createNamedQuery("SELECT p FROM EsferaSocialPSAM p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM EsferaSocialPSAM p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(esferas);
//        assertEquals(true, esferas!=null);
//        
//    }    
//    /**
//     * Test of find method, of class EsferaSocialPSAMFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        EsferaSocialPSAM eSocial = new EsferaSocialPSAM();
//        eSocial.setId(1L);
//        EsferaSocialPSAM eSocialTest = new EsferaSocialPSAM();
//        eSocialTest.setId(1L);
//        List<EsferaSocialPSAM> esferas = new ArrayList<>();
//        esferas.add(eSocial);
//        List<EsferaSocialPSAM> esferasTest = new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM EsferaSocialPSAM p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM EsferaSocialPSAM p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(esferas);
//        when(esferaSocialPSAMFacade.find(eSocial.getId())).thenReturn(eSocialTest);
//        esferasTest.add(eSocialTest);
//        assertEquals(esferasTest, esferas);
//    }
//
//    /**
//     * Test of findAll method, of class EsferaSocialPSAMFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        EsferaSocialPSAM eSocial = new EsferaSocialPSAM();
//        eSocial.setId(1L);
//        EsferaSocialPSAM eSocial2 = new EsferaSocialPSAM();
//        eSocial2.setId(2L);
//        List<EsferaSocialPSAM> esferas = new ArrayList<>();
//        esferas.add(eSocial);
//        esferas.add(eSocial2);
//        List<EsferaSocialPSAM> esferasTest = new ArrayList<>();
//        esferasTest.add(eSocial);
//        esferasTest.add(eSocial2);
//        when(entityManager.createNamedQuery("SELECT p FROM EsferaSocialPSAM p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM EsferaSocialPSAM p");
//        when(querys.getResultList()).thenReturn(esferas);
//        when(esferaSocialPSAMFacade.findAll()).thenReturn(esferasTest);
//        assertEquals(esferasTest, esferas);
//    }   
//    
//}
