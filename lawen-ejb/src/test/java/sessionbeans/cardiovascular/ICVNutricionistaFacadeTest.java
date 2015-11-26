///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.cardiovascular;
//
//import entities.cardiovascular.ICVNutricionista;
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
//public class ICVNutricionistaFacadeTest {
//    @Mock
//    private ICVNutricionistaFacade icvNutricionistaFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    public ICVNutricionistaFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        icvNutricionistaFacade=Mockito.mock(ICVNutricionistaFacade.class);
//        icvNutricionistaFacade.setEm(entityManager);
//    }
//
//    /**
//     * Test of create method, of class ICVNutricionistaFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        ICVNutricionista icvN = new ICVNutricionista();
//        icvN.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        icvN.setFechaAtencionNutri(date);
//        List<ICVNutricionista> nut = new ArrayList<>();
//        nut.add(icvN);
//        when(entityManager.createNamedQuery("SELECT p FROM ICVNutricionista p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM ICVNutricionista p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(nut);
//        assertEquals(true, nut != null);
//       
//    }    
//    /**
//     * Test of find method, of class ICVNutricionistaFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        ICVNutricionista icvN = new ICVNutricionista();
//        icvN.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        icvN.setFechaAtencionNutri(date);
//        ICVNutricionista icvNTest = new ICVNutricionista();
//        icvNTest.setId(1L);
//        icvNTest.setFechaAtencionNutri(date);
//        List<ICVNutricionista> nut = new ArrayList<>();
//        nut.add(icvN);
//        List<ICVNutricionista> nutTest = new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM ICVNutricionista p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM ICVNutricionista p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(nut);
//        when(icvNutricionistaFacade.find(icvN.getId())).thenReturn(icvNTest);
//        nutTest.add(icvNTest);
//        assertEquals(nutTest, nut);
//    }
//
//    /**
//     * Test of findAll method, of class ICVNutricionistaFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        ICVNutricionista icvN = new ICVNutricionista();
//        icvN.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        icvN.setFechaAtencionNutri(date);
//        ICVNutricionista icvN2 = new ICVNutricionista();
//        icvN2.setId(1L);
//        icvN2.setFechaAtencionNutri(date);
//        List<ICVNutricionista> nut = new ArrayList<>();
//        nut.add(icvN);
//        nut.add(icvN2);
//        List<ICVNutricionista> nutTest = new ArrayList<>();
//        nutTest.add(icvN);
//        nutTest.add(icvN2);
//        when(entityManager.createNamedQuery("SELECT p FROM ICVNutricionista p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM ICVNutricionista p");
//        when(querys.getResultList()).thenReturn(nut);
//        when(icvNutricionistaFacade.findAll()).thenReturn(nutTest);
//        
//        assertEquals(nutTest, nut);
//    }
//    
//}
