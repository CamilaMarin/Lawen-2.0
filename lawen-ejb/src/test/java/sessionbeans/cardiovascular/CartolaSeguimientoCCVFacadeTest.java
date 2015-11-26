///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sessionbeans.cardiovascular;
//
//import entities.cardiovascular.CartolaSeguimientoCCV;
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
//public class CartolaSeguimientoCCVFacadeTest {
//    @Mock
//    private CartolaSeguimientoCCVFacade cartolaSeguimientoCCVFacade;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    public CartolaSeguimientoCCVFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        cartolaSeguimientoCCVFacade=Mockito.mock(CartolaSeguimientoCCVFacade.class);
//        cartolaSeguimientoCCVFacade.setEm(entityManager);
//    }
//
//    /**
//     * Test of create method, of class CartolaSeguimientoCCVFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        CartolaSeguimientoCCV cSeguimiento= new CartolaSeguimientoCCV();
//        cSeguimiento.setId(1L);
//        List<CartolaSeguimientoCCV> cartola=new ArrayList<>();
//        cartola.add(cSeguimiento);
//        when(entityManager.createNamedQuery("SELECT p FROM CartolaSeguimientoCCV p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM CartolaSeguimientoCCV p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(cartola);
//        assertEquals(true, cartola != null);
//    }
//
//   
//    /**
//     * Test of find method, of class CartolaSeguimientoCCVFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        CartolaSeguimientoCCV cSeguimiento = new CartolaSeguimientoCCV();
//        cSeguimiento.setId(1L);
//        List<CartolaSeguimientoCCV> cartola = new ArrayList<>();
//        cartola.add(cSeguimiento);
//        CartolaSeguimientoCCV cSeguimientoTest = new CartolaSeguimientoCCV();
//        cSeguimientoTest.setId(1L);
//        List<CartolaSeguimientoCCV> cartolaTest = new ArrayList<>();
//        when(entityManager.createNamedQuery("SELECT p FROM CartolaSeguimientoCCV p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM CartolaSeguimientoCCV p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(cartola);
//        when(cartolaSeguimientoCCVFacade.find(cSeguimiento.getId())).thenReturn(cSeguimientoTest);
//        cartolaTest.add(cSeguimientoTest);
//        assertEquals(cartolaTest, cartola);
//    }
//
//    /**
//     * Test of findAll method, of class CartolaSeguimientoCCVFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        CartolaSeguimientoCCV cSeguimiento = new CartolaSeguimientoCCV();
//        cSeguimiento.setId(1L);
//        CartolaSeguimientoCCV cSeguimiento2 = new CartolaSeguimientoCCV();
//        cSeguimiento2.setId(2L);
//        CartolaSeguimientoCCV cSeguimiento3 = new CartolaSeguimientoCCV();
//        cSeguimiento3.setId(3L);
//        List<CartolaSeguimientoCCV> cartola = new ArrayList<>();
//        cartola.add(cSeguimiento);
//        cartola.add(cSeguimiento2);
//        cartola.add(cSeguimiento3);
//       
//        List<CartolaSeguimientoCCV> cartolaTest = new ArrayList<>();
//        cartolaTest.add(cSeguimiento);
//        cartolaTest.add(cSeguimiento2);
//        cartolaTest.add(cSeguimiento3);
//        when(entityManager.createNamedQuery("SELECT p FROM CartolaSeguimientoCCV p")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM CartolaSeguimientoCCV p");
//        when(querys.getResultList()).thenReturn(cartola);
//        //when(cartolaSeguimientoCCVFacade.findAll()).thenReturn(cartolaTest);
//        assertEquals(cartolaTest, cartola);
//        
//    }
//
//    
//    
//}
