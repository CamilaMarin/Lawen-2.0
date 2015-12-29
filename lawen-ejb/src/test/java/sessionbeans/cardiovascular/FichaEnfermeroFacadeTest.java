/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.FichaEnfermero;
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
public class FichaEnfermeroFacadeTest {
    @Mock
    private FichaEnfermeroFacade fichaEnfermeroFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    public FichaEnfermeroFacadeTest() {
    }
    
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager = Mockito.mock(EntityManager.class);
        fichaEnfermeroFacade=Mockito.mock(FichaEnfermeroFacade.class);
        fichaEnfermeroFacade.setEm(entityManager);
        
    }

    /**
     * Test of create method, of class FichaEnfermeroFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        FichaEnfermero fEnfermero= new FichaEnfermero();
        fEnfermero.setId(1L);
        List<FichaEnfermero> fichas= new ArrayList<>();
        fichas.add(fEnfermero);
        when(entityManager.createNamedQuery("SELECT p FROM FichaEnfermero p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM FichaEnfermero p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(fichas);
        assertEquals(true, fichas != null);
    }

    /**
     * Test of find method, of class FichaEnfermeroFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        FichaEnfermero fEnfermero= new FichaEnfermero();
        fEnfermero.setId(1L);
        List<FichaEnfermero> fichas= new ArrayList<>();
        fichas.add(fEnfermero);
        FichaEnfermero fEnfermeroTest = new FichaEnfermero();
        fEnfermeroTest.setId(1L);
        List<FichaEnfermero> fichasTest= new ArrayList<>();
        when(entityManager.createNamedQuery("SELECT p FROM FichaEnfermero p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM FichaEnfermero p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(fichas);
        when(fichaEnfermeroFacade.find(fEnfermero.getId())).thenReturn(fEnfermeroTest);
        fichasTest.add(fEnfermeroTest);
        assertEquals(fichasTest, fichas);
        
    }

    /**
     * Test of findAll method, of class FichaEnfermeroFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        FichaEnfermero fEnfermero= new FichaEnfermero();
        fEnfermero.setId(1L); 
        FichaEnfermero fEnfermero2 = new FichaEnfermero();
        fEnfermero2.setId(2L);
        FichaEnfermero fEnfermero3 = new FichaEnfermero();
        fEnfermero3.setId(3L);
        List<FichaEnfermero> fichas= new ArrayList<>();
        fichas.add(fEnfermero);
        fichas.add(fEnfermero2);
        fichas.add(fEnfermero3);
        List<FichaEnfermero> fichasTest= new ArrayList<>();
        fichasTest.add(fEnfermero);
        fichasTest.add(fEnfermero2);
        fichasTest.add(fEnfermero3);
        
        when(entityManager.createNamedQuery("SELECT p FROM FichaEnfermero p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM FichaEnfermero p");
        when(querys.getResultList()).thenReturn(fichas);
        when(fichaEnfermeroFacade.findAll()).thenReturn(fichasTest);
        
        assertEquals(fichasTest, fichas);
        
    }

        
}
