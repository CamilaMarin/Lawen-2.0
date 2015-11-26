///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans;
//
//import entities.TipoPatologia;
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
//public class TipoPatologiaFacadeTest {
//    @Mock
//    private TipoPatologiaFacade tipoPatologiaFacade; 
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    
//    public TipoPatologiaFacadeTest() {
//    }
//    
//        
//    @Before
//    public void setUp() {
//        query = mock(Query.class);
//        entityManager =Mockito.mock(EntityManager.class);
//        tipoPatologiaFacade=Mockito.mock(TipoPatologiaFacade.class);
//        tipoPatologiaFacade.setEm(entityManager);
//        
//    }
//    
//    
//    /**
//     * Test of create method, of class TipoPatologiaFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        TipoPatologia tP = new TipoPatologia();
//        tP.setId(1L);
//        tP.setNombre_patologia("Diabetes");
//        tP.setPatologias(null);
//        
//        List<TipoPatologia> tipos =new ArrayList<>();
//        tipos.add(tP);
//        when(entityManager.createNamedQuery("SELECT p FROM TipoPatologia p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM TipoPatologia p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(tipos);
//        assertEquals(true,tipos!=null);
//        
//    }
//
//   
//    /**
//     * Test of Find method, of class TipoPatologiaFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        TipoPatologia tP = new TipoPatologia();
//        tP.setId(1L);
//        tP.setNombre_patologia("Diabetes");
//        tP.setPatologias(null);
//
//        List<TipoPatologia> tipos = new ArrayList<>();
//        tipos.add(tP);
//        TipoPatologia tPTest = new TipoPatologia();
//        tPTest.setId(1L);
//        tPTest.setNombre_patologia("Diabetes");
//        tPTest.setPatologias(null);
//        List<TipoPatologia> tiposTest = new ArrayList<>();
//       
//        when(entityManager.createNamedQuery("SELECT p FROM TipoPatologia p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM TipoPatologia p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(tipos);
//        when(tipoPatologiaFacade.find(tP.getId())).thenReturn(tPTest);
//        tiposTest.add(tPTest);
//        assertEquals(tiposTest, tipos);
//    }
//    /**
//     * Test of findAll method, of class TipoPatologiaFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        TipoPatologia tP = new TipoPatologia();
//        tP.setId(1L);
//        tP.setNombre_patologia("Diabetes");
//        tP.setPatologias(null);
//        
//        TipoPatologia tP2 = new TipoPatologia();
//        tP.setId(2L);
//        tP.setNombre_patologia("Hipertension");
//        tP.setPatologias(null);
//        
//        TipoPatologia tP3 = new TipoPatologia();
//        tP.setId(3L);
//        tP.setNombre_patologia("Tuberculosis");
//        tP.setPatologias(null);
//        
//
//        List<TipoPatologia> tipos = new ArrayList<>();
//        tipos.add(tP);
//        tipos.add(tP2);
//        tipos.add(tP3);
//        List<TipoPatologia> tiposTest = new ArrayList<>();
//        tiposTest.add(tP);
//        tiposTest.add(tP2);
//        tiposTest.add(tP3);
//       
//        when(entityManager.createNamedQuery("SELECT p FROM TipoPatologia p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM TipoPatologia p");
//        when(querys.getResultList()).thenReturn(tipos);
//        when(tipoPatologiaFacade.findAll()).thenReturn(tiposTest);
//        assertEquals(tiposTest, tipos);
//        
//       
//    }
//
//   
//}
