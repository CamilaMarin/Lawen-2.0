///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.cardiovascular;
//
//import entities.cardiovascular.CCVEnfermero;
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
//public class CCVEnfermeroFacadeTest {
//    @Mock
//    private CCVEnfermeroFacade ccvEnfermeroFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    
//    public CCVEnfermeroFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        ccvEnfermeroFacade=Mockito.mock(CCVEnfermeroFacade.class);
//        ccvEnfermeroFacade.setEm(entityManager);
//    }
//
//    /**
//     * Test of create method, of class CCVEnfermeroFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        CCVEnfermero ccvEnf= new CCVEnfermero();
//        ccvEnf.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        ccvEnf.setFechaAtencionEnf(date);
//        List<CCVEnfermero> enf = new ArrayList<>();
//        enf.add(ccvEnf);
//        when(entityManager.createNamedQuery("SELECT p FROM CCVEnfermero p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM CCVEnfermero p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(enf);
//        assertEquals(true, enf!=null);
//        
//    }
//
//   
//
//    /**
//     * Test of find method, of class CCVEnfermeroFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        CCVEnfermero ccvEnf = new CCVEnfermero();
//        ccvEnf.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        ccvEnf.setFechaAtencionEnf(date);
//        CCVEnfermero ccvEnfTest = new CCVEnfermero();
//        ccvEnfTest.setId(1L);
//        ccvEnfTest.setFechaAtencionEnf(date);
//        List<CCVEnfermero> enf = new ArrayList<>();
//        enf.add(ccvEnf);
//        List<CCVEnfermero> enfTest = new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM CCVEnfermero p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM CCVEnfermero p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(enf);
//        when(ccvEnfermeroFacade.find(ccvEnf.getId())).thenReturn(ccvEnfTest);
//        enfTest.add(ccvEnfTest);
//        assertEquals(enfTest, enf);
//       
//    }
//
//    /**
//     * Test of findAll method, of class CCVEnfermeroFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        CCVEnfermero ccvEnf = new CCVEnfermero();
//        ccvEnf.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        ccvEnf.setFechaAtencionEnf(date);
//        CCVEnfermero ccvEnf2 = new CCVEnfermero();
//        ccvEnf2.setId(2L);
//        ccvEnf2.setFechaAtencionEnf(date);
//        List<CCVEnfermero> enf = new ArrayList<>();
//        enf.add(ccvEnf);
//        enf.add(ccvEnf2);
//        List<CCVEnfermero> enfTest = new ArrayList<>();
//        enfTest.add(ccvEnf);
//        enfTest.add(ccvEnf2);
//        when(entityManager.createNamedQuery("SELECT p FROM CCVEnfermero p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM CCVEnfermero p");
//        when(querys.getResultList()).thenReturn(enf);
//        when(ccvEnfermeroFacade.findAll()).thenReturn(enfTest);
//        
//        assertEquals(enfTest, enf);
//    }
//
//    
//    
//    
//}
