/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.adultoMayor;

import entities.adultoMayor.CartolaSeguimientoPSAM;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author jeanpierre
 */
@RunWith(MockitoJUnitRunner.class)
public class CartolaSeguimientoPSAMFacadeTest {
    @Mock
    private CartolaSeguimientoPSAMFacade cartolaSeguimientoPSAMFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    
    public CartolaSeguimientoPSAMFacadeTest() {
    }
    
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager = Mockito.mock(EntityManager.class);
        cartolaSeguimientoPSAMFacade=Mockito.mock(CartolaSeguimientoPSAMFacade.class);
        cartolaSeguimientoPSAMFacade.setEm(entityManager);
    }

    /**
     * Test of create method, of class CartolaSeguimientoPSAMFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        CartolaSeguimientoPSAM cartola=new CartolaSeguimientoPSAM();
        cartola.setId(1L);
        List<CartolaSeguimientoPSAM> cartolas= new ArrayList<>();
        cartolas.add(cartola);
        when(entityManager.createNamedQuery("SELECT p FROM CartolaSeguimientoPSAM p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM CartolaSeguimientoPSAM p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(cartolas);
        assertEquals(true, cartolas!=null);
    }
    /**
     * Test of find method, of class CartolaSeguimientoPSAMFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        CartolaSeguimientoPSAM cartola=new CartolaSeguimientoPSAM();
        cartola.setId(1L);
        CartolaSeguimientoPSAM cartolaTest=new CartolaSeguimientoPSAM();
        cartolaTest.setId(1L);
        List<CartolaSeguimientoPSAM> cartolas= new ArrayList<>();
        cartolas.add(cartola);
        List<CartolaSeguimientoPSAM> cartolasTest= new ArrayList<>();
        when(entityManager.createNamedQuery("SELECT p FROM CartolaSeguimientoPSAM p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM CartolaSeguimientoPSAM p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(cartolas);
        when(cartolaSeguimientoPSAMFacade.find(cartola.getId())).thenReturn(cartolaTest);
        cartolasTest.add(cartolaTest);
        assertEquals(cartolasTest, cartolas);
        
    }

    /**
     * Test of findAll method, of class CartolaSeguimientoPSAMFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        CartolaSeguimientoPSAM cartola = new CartolaSeguimientoPSAM();
        cartola.setId(1L);
        CartolaSeguimientoPSAM cartola2 = new CartolaSeguimientoPSAM();
        cartola2.setId(2L);
        List<CartolaSeguimientoPSAM> cartolas = new ArrayList<>();
        cartolas.add(cartola);
        cartolas.add(cartola2);
        List<CartolaSeguimientoPSAM> cartolasTest = new ArrayList<>();
        cartolasTest.add(cartola);
        cartolasTest.add(cartola2);
        when(entityManager.createNamedQuery("SELECT p FROM CartolaSeguimientoPSAM p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM CartolaSeguimientoPSAM p");
        when(querys.getResultList()).thenReturn(cartolas);
        when(cartolaSeguimientoPSAMFacade.findAll()).thenReturn(cartolasTest);
        assertEquals(cartolasTest, cartolas);
    }
        
}
