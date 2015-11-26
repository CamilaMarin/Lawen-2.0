///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.adultoMayor;
//
//import entities.adultoMayor.FichaAdultoMayor;
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
//public class FichaAdultoMayorFacadeTest {
//    
//    @Mock
//    private FichaAdultoMayorFacade fichaAdultoMayorFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    
//    public FichaAdultoMayorFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        fichaAdultoMayorFacade=Mockito.mock(FichaAdultoMayorFacade.class);
//        fichaAdultoMayorFacade.setEm(entityManager);
//    }
//
//    /**
//     * Test of create method, of class FichaAdultoMayorFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        FichaAdultoMayor fAM = new FichaAdultoMayor();
//        fAM.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        fAM.setFechaIngresoPSAM(date);
//        List<FichaAdultoMayor> fichas = new ArrayList<>();
//        fichas.add(fAM);
//        when(entityManager.createNamedQuery("SELECT p FROM FichaAdultoMayor p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM FichaAdultoMayor p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(fichas);
//        assertEquals(true, fichas!=null);
//       
//    }
//
//    /**
//     * Test of edit method, of class FichaAdultoMayorFacade.
//     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        FichaAdultoMayor fAM = new FichaAdultoMayor();
//        fAM.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        fAM.setFechaIngresoPSAM(date);
//        FichaAdultoMayor fAMTest = new FichaAdultoMayor();
//        fAMTest.setId(1L);
//        fAMTest.setFechaIngresoPSAM(date);
//        List<FichaAdultoMayor> fichas = new ArrayList<>();
//        fichas.add(fAM);
//        List<FichaAdultoMayor> fichasTest = new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM FichaAdultoMayor p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM FichaAdultoMayor p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(fichas);
//        when(fichaAdultoMayorFacade.find(fAM.getId())).thenReturn(fAMTest);
//        fichasTest.add(fAMTest);
//        assertEquals(fichasTest, fichas);
//        
//    }
//
//    
//    /**
//     * Test of find method, of class FichaAdultoMayorFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        FichaAdultoMayor fAM = new FichaAdultoMayor();
//        fAM.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        fAM.setFechaIngresoPSAM(date);
//        FichaAdultoMayor fAM2 = new FichaAdultoMayor();
//        fAM2.setId(1L);
//        fAM2.setFechaIngresoPSAM(date);
//        List<FichaAdultoMayor> fichas = new ArrayList<>();
//        fichas.add(fAM);
//        fichas.add(fAM2);
//        List<FichaAdultoMayor> fichasTest = new ArrayList<>();
//        fichasTest.add(fAM);
//        fichasTest.add(fAM2);
//        when(entityManager.createNamedQuery("SELECT p FROM FichaAdultoMayor p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM FichaAdultoMayor p");
//        when(querys.getResultList()).thenReturn(fichas);
//        when(fichaAdultoMayorFacade.findAll()).thenReturn(fichasTest);
//        assertEquals(fichasTest, fichas);
//        
//    }
//
//    /**
//     * Test of findAll method, of class FichaAdultoMayorFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        
//    }
//
//    
//}
