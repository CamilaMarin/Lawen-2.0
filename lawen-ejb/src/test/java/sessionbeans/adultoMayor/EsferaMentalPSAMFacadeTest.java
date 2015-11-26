///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.adultoMayor;
//
//import entities.adultoMayor.EsferaMentalPSAM;
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
//public class EsferaMentalPSAMFacadeTest {
//    @Mock
//    private EsferaMentalPSAMFacade esferaMentalPSAMFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    
//    public EsferaMentalPSAMFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        esferaMentalPSAMFacade=Mockito.mock(EsferaMentalPSAMFacade.class);
//        esferaMentalPSAMFacade.setEm(entityManager);
//        
//    }
//
//    /**
//     * Test of create method, of class EsferaMentalPSAMFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        EsferaMentalPSAM eMental = new EsferaMentalPSAM();
//        eMental.setId(1L);
//        List<EsferaMentalPSAM> esferas = new ArrayList<>();
//        esferas.add(eMental);
//        when(entityManager.createNamedQuery("SELECT p FROM EsferaMentalPSAM p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM EsferaMentalPSAM p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(esferas);
//        assertEquals(true, esferas!=null);
//        
//    }    
//    /**
//     * Test of find method, of class EsferaMentalPSAMFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        EsferaMentalPSAM eMental = new EsferaMentalPSAM();
//        eMental.setId(1L);
//        EsferaMentalPSAM eMentalTest = new EsferaMentalPSAM();
//        eMentalTest.setId(1L);
//        List<EsferaMentalPSAM> esferas = new ArrayList<>();
//        esferas.add(eMental);
//        List<EsferaMentalPSAM> esferasTest = new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM EsferaMentalPSAM p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM EsferaMentalPSAM p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(esferas);
//        when(esferaMentalPSAMFacade.find(eMental.getId())).thenReturn(eMentalTest);
//        esferasTest.add(eMentalTest);
//        assertEquals(esferasTest, esferas);
//    }
//
//    /**
//     * Test of findAll method, of class EsferaMentalPSAMFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        EsferaMentalPSAM eMental = new EsferaMentalPSAM();
//        eMental.setId(1L);
//        EsferaMentalPSAM eMental2 = new EsferaMentalPSAM();
//        eMental2.setId(2L);
//        List<EsferaMentalPSAM> esferas = new ArrayList<>();
//        esferas.add(eMental);
//        esferas.add(eMental2);
//        List<EsferaMentalPSAM> esferasTest = new ArrayList<>();
//        esferasTest.add(eMental);
//        esferasTest.add(eMental2);
//        when(entityManager.createNamedQuery("SELECT p FROM EsferaMentalPSAM p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM EsferaMentalPSAM p");
//        when(querys.getResultList()).thenReturn(esferas);
//        when(esferaMentalPSAMFacade.findAll()).thenReturn(esferasTest);
//        assertEquals(esferasTest, esferas);
//    }   
//}
