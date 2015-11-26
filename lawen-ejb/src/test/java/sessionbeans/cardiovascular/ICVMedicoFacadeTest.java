///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.cardiovascular;
//
//import entities.cardiovascular.ICVMedico;
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
//public class ICVMedicoFacadeTest {
//    @Mock
//    private ICVMedicoFacade icvMedicoFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    public ICVMedicoFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        icvMedicoFacade=Mockito.mock(ICVMedicoFacade.class);
//        icvMedicoFacade.setEm(entityManager);
//    }
//
//    /**
//     * Test of create method, of class ICVMedicoFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        ICVMedico icvM=new ICVMedico();
//        icvM.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        icvM.setFechaAtencionMed(date);
//        List<ICVMedico> med=new ArrayList<>();
//        med.add(icvM);
//        when(entityManager.createNamedQuery("SELECT p FROM ICVMedico p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM ICVMedico p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(med);
//        assertEquals(true, med!=null);
//    }   
//    /**
//     * Test of find method, of class ICVMedicoFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        ICVMedico icvM=new ICVMedico();
//        icvM.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        icvM.setFechaAtencionMed(date);
//        List<ICVMedico> med=new ArrayList<>();
//        med.add(icvM);
//        ICVMedico icvMTest=new ICVMedico();
//        icvMTest.setId(1L);
//        icvMTest.setFechaAtencionMed(date);
//        List<ICVMedico> medTest=new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM ICVMedico p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM ICVMedico p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(med);
//        when(icvMedicoFacade.find(icvM.getId())).thenReturn(icvMTest);
//        medTest.add(icvMTest);
//        assertEquals(medTest, med);
//        
//    }
//
//    /**
//     * Test of findAll method, of class ICVMedicoFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        ICVMedico icvM=new ICVMedico();
//        icvM.setId(1L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("12/12/1999");
//        icvM.setFechaAtencionMed(date);
//        
//        ICVMedico icvM2=new ICVMedico();
//        icvM2.setId(1L);
//        icvM2.setFechaAtencionMed(date);
//        List<ICVMedico> med=new ArrayList<>();
//        med.add(icvM);
//        med.add(icvM2);
//        
//        List<ICVMedico> medTest=new ArrayList<>();
//        medTest.add(icvM);
//        medTest.add(icvM2);
//        when(entityManager.createNamedQuery("SELECT p FROM ICVMedico p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM ICVMedico p");
//        when(querys.getResultList()).thenReturn(med);
//        when(icvMedicoFacade.findAll()).thenReturn(medTest);
//        
//        assertEquals(medTest, med);
//       
//    }
//
//    
//}
