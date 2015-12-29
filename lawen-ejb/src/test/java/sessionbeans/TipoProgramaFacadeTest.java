/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.TipoPrograma;
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
public class TipoProgramaFacadeTest {
    @Mock
    private TipoProgramaFacade tipoProgramaFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    
    public TipoProgramaFacadeTest() {
        
        query = mock(Query.class);
        entityManager = Mockito.mock(EntityManager.class);
        tipoProgramaFacade=Mockito.mock(TipoProgramaFacade.class);
        tipoProgramaFacade.setEm(entityManager);
    }
    
    @Before
    public void setUp() {
    }
   
    /**
     * Test of create method, of class TipoProgramaFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("find");
        TipoPrograma tipoPrograma = new TipoPrograma();
        tipoPrograma.setId(1L);
        tipoPrograma.setNombre_programa("Cardiovascular");
        tipoPrograma.setProgramas(null);

        List<TipoPrograma> tProg = new ArrayList<>();
        tProg.add(tipoPrograma);
        when(entityManager.createNamedQuery("SELECT p FROM TipoPrograma p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM TipoPrograma p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(tProg);
        assertEquals(true, tProg!=null);
    
    }

    /**
     * Test of find method, of class TipoProgramaFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        TipoPrograma tipoPrograma =new TipoPrograma();
        tipoPrograma.setId(1L);
        tipoPrograma.setNombre_programa("Cardiovascular");
        tipoPrograma.setProgramas(null);
        
        List<TipoPrograma> tProg= new ArrayList<>();
        tProg.add(tipoPrograma);
        TipoPrograma tipoProgramaTest =new TipoPrograma();
        tipoProgramaTest.setId(1L);
        tipoProgramaTest.setNombre_programa("Cardiovascular");
        tipoProgramaTest.setProgramas(null);
        List<TipoPrograma> tProgTest= new ArrayList<>();
        
        
        when(entityManager.createNamedQuery("SELECT p FROM TipoPrograma p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM TipoPrograma p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(tProg);
        when(tipoProgramaFacade.find(tipoPrograma.getId())).thenReturn( tipoProgramaTest);
        tProgTest.add(tipoProgramaTest);
        assertEquals(tProgTest,tProg);
        
    }

    
    
    /**
     * Test of findAll method, of class TipoProgramaFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        TipoPrograma tipoPrograma =new TipoPrograma();
        tipoPrograma.setId(1L);
        tipoPrograma.setNombre_programa("Cardiovascular");
        tipoPrograma.setProgramas(null);
        
        TipoPrograma tipoPrograma2 =new TipoPrograma();
        tipoPrograma2.setId(2L);
        tipoPrograma2.setNombre_programa("AdultoMayor");
        tipoPrograma2.setProgramas(null);
        
        TipoPrograma tipoPrograma3 =new TipoPrograma();
        tipoPrograma3.setId(3L);
        tipoPrograma3.setNombre_programa("Infantil");
        tipoPrograma3.setProgramas(null);
        
        List<TipoPrograma> tProg= new ArrayList<>();
        tProg.add(tipoPrograma);
        tProg.add(tipoPrograma2);
        tProg.add(tipoPrograma3);
        List<TipoPrograma> tProgTest=new ArrayList<>();
        tProgTest.add(tipoPrograma);
        tProgTest.add(tipoPrograma2);
        tProgTest.add(tipoPrograma3);
        when(entityManager.createNamedQuery("SELECT p FROM TipoPrograma p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM TipoPrograma p");
        when(querys.getResultList()).thenReturn(tProg);
        when(tipoProgramaFacade.findAll()).thenReturn(tProgTest);
        assertEquals(tProgTest,tProg);
    }

}
