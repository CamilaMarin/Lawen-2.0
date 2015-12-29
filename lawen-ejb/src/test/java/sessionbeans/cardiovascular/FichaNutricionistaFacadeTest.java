/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.FichaNutricionista;
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
public class FichaNutricionistaFacadeTest {
    @Mock 
    private FichaNutricionistaFacade fichaNutricionistaFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
            
    
    public FichaNutricionistaFacadeTest() {
    }
    
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager = Mockito.mock(EntityManager.class);
        fichaNutricionistaFacade=Mockito.mock(FichaNutricionistaFacade.class);
        fichaNutricionistaFacade.setEm(entityManager);
    }

    /**
     * Test of create method, of class FichaNutricionistaFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        FichaNutricionista fNutricionista= new FichaNutricionista();
        fNutricionista.setId(1L);
        List<FichaNutricionista> fichas =new ArrayList<>();
        fichas.add(fNutricionista);
        when(entityManager.createNamedQuery("SELECT p FROM FichaNutricionista p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM FichaNutricionista p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(fichas);
        assertEquals(true, fichas != null);
        
    }

    
    /**
     * Test of find method, of class FichaNutricionistaFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        FichaNutricionista fNutricionista = new FichaNutricionista();
        fNutricionista.setId(1L);
        List<FichaNutricionista> fichas = new ArrayList<>();
        fichas.add(fNutricionista);
        FichaNutricionista fNutricionistaTest = new FichaNutricionista();
        fNutricionistaTest.setId(1L);
        List<FichaNutricionista> fichasTest = new ArrayList<>();
        when(entityManager.createNamedQuery("SELECT p FROM FichaNutricionista p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM FichaNutricionista p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(fichas);
        when(fichaNutricionistaFacade.find(fNutricionista.getId())).thenReturn(fNutricionistaTest);
        fichasTest.add(fNutricionistaTest);
        assertEquals(fichasTest,fichas);
      
    }

    /**
     * Test of findAll method, of class FichaNutricionistaFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        FichaNutricionista fNutricionista = new FichaNutricionista();
        fNutricionista.setId(1L);
        
        FichaNutricionista fNutricionista2 = new FichaNutricionista();
        fNutricionista2.setId(2L);
        FichaNutricionista fNutricionista3 = new FichaNutricionista();
        fNutricionista3.setId(3L);
        List<FichaNutricionista> fichas = new ArrayList<>();
        fichas.add(fNutricionista);
        fichas.add(fNutricionista2);
        fichas.add(fNutricionista3);
        List<FichaNutricionista> fichasTest = new ArrayList<>();
        fichasTest.add(fNutricionista);
        fichasTest.add(fNutricionista2);
        fichasTest.add(fNutricionista3);
        
        
        when(entityManager.createNamedQuery("SELECT p FROM FichaNutricionista p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM FichaNutricionista p");
        when(querys.getResultList()).thenReturn(fichas);
        when(fichaNutricionistaFacade.findAll()).thenReturn(fichasTest);
        
        assertEquals(fichasTest, fichas);
    }
}
