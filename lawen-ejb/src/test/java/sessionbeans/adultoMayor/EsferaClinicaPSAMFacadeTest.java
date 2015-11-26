///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.adultoMayor;
//
//import entities.adultoMayor.EsferaClinicaPSAM;
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
//public class EsferaClinicaPSAMFacadeTest {
//    @Mock
//    private EsferaClinicaPSAMFacade esferaClinicaPSAMFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    
//    public EsferaClinicaPSAMFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        esferaClinicaPSAMFacade=Mockito.mock(EsferaClinicaPSAMFacade.class);
//        esferaClinicaPSAMFacade.setEm(entityManager);
//    }
//
//    /**
//     * Test of create method, of class EsferaClinicaPSAMFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        EsferaClinicaPSAM eClinica = new EsferaClinicaPSAM();
//        eClinica.setId(1L);
//        List<EsferaClinicaPSAM> esferas = new ArrayList<>();
//        esferas.add(eClinica);
//        when(entityManager.createNamedQuery("SELECT p FROM EsferaClinicaPSAM p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM EsferaClinicaPSAM p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(esferas);
//        assertEquals(true, esferas!=null);
//        
//    }    
//    /**
//     * Test of find method, of class EsferaClinicaPSAMFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        EsferaClinicaPSAM eClinica = new EsferaClinicaPSAM();
//        eClinica.setId(1L);
//        EsferaClinicaPSAM eClinicaTest = new EsferaClinicaPSAM();
//        eClinicaTest.setId(1L);
//        List<EsferaClinicaPSAM> esferas = new ArrayList<>();
//        esferas.add(eClinica);
//        List<EsferaClinicaPSAM> esferasTest = new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM EsferaClinicaPSAM p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM EsferaClinicaPSAM p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(esferas);
//        when(esferaClinicaPSAMFacade.find(eClinica.getId())).thenReturn(eClinicaTest);
//        esferasTest.add(eClinicaTest);
//        assertEquals(esferasTest, esferas);
//    }
//
//    /**
//     * Test of findAll method, of class EsferaClinicaPSAMFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        EsferaClinicaPSAM eClinica = new EsferaClinicaPSAM();
//        eClinica.setId(1L);
//        EsferaClinicaPSAM eClinica2 = new EsferaClinicaPSAM();
//        eClinica2.setId(2L);
//        List<EsferaClinicaPSAM> esferas = new ArrayList<>();
//        esferas.add(eClinica);
//        esferas.add(eClinica2);
//        List<EsferaClinicaPSAM> esferasTest = new ArrayList<>();
//        esferasTest.add(eClinica);
//        esferasTest.add(eClinica2);
//        when(entityManager.createNamedQuery("SELECT p FROM EsferaClinicaPSAM p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM EsferaClinicaPSAM p");
//        when(querys.getResultList()).thenReturn(esferas);
//        when(esferaClinicaPSAMFacade.findAll()).thenReturn(esferasTest);
//        assertEquals(esferasTest, esferas);
//    }   
//    
//}
