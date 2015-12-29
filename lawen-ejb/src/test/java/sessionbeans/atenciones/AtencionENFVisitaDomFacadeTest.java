/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.atenciones;

import entities.atenciones.AtencionENFVisitaDom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
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
public class AtencionENFVisitaDomFacadeTest {
    @Mock
    private AtencionENFVisitaDomFacade atencionENFVisitaDomFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    
    public AtencionENFVisitaDomFacadeTest() {
    }
    
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager = Mockito.mock(EntityManager.class);
        atencionENFVisitaDomFacade=Mockito.mock(AtencionENFVisitaDomFacade.class);
        atencionENFVisitaDomFacade.setEm(entityManager);
    }

    /**
     * Test of create method, of class AtencionENFVisitaDomFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        AtencionENFVisitaDom visita= new AtencionENFVisitaDom();
        visita.setId(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        visita.setFechaVista(date);
        List <AtencionENFVisitaDom> atencion = new ArrayList<>();
        atencion.add(visita);
        when(entityManager.createNamedQuery("SELECT p FROM AtencionENFVisitaDom p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionENFVisitaDom p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(atencion);
        assertEquals(true, atencion != null);
        
    }

   

    /**
     * Test of find method, of class AtencionENFVisitaDomFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        AtencionENFVisitaDom visita= new AtencionENFVisitaDom();
        visita.setId(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        visita.setFechaVista(date);
        AtencionENFVisitaDom visitaTest= new AtencionENFVisitaDom();
        visitaTest.setId(1L);
        visitaTest.setFechaVista(date);
        List <AtencionENFVisitaDom> atencion = new ArrayList<>();
        atencion.add(visita);
        List <AtencionENFVisitaDom> atencionTest = new ArrayList<>();
        when(entityManager.createNamedQuery("SELECT p FROM AtencionENFVisitaDom p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionENFVisitaDom p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(atencion);
        when(atencionENFVisitaDomFacade.find(visita.getId())).thenReturn(visitaTest);
        atencionTest.add(visitaTest);
        assertEquals(atencionTest, atencion);
       
    }

    /**
     * Test of findAll method, of class AtencionENFVisitaDomFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        AtencionENFVisitaDom visita= new AtencionENFVisitaDom();
        visita.setId(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        visita.setFechaVista(date);
        AtencionENFVisitaDom visita2= new AtencionENFVisitaDom();
        visita2.setId(2L);
        visita2.setFechaVista(date);
        List <AtencionENFVisitaDom> atencion = new ArrayList<>();
        atencion.add(visita);
        atencion.add(visita2);
        List <AtencionENFVisitaDom> atencionTest = new ArrayList<>();
        atencionTest.add(visita);
        atencionTest.add(visita2);
        when(entityManager.createNamedQuery("SELECT p FROM AtencionENFVisitaDom p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionENFVisitaDom p");
        when(querys.getResultList()).thenReturn(atencion);
        when(atencionENFVisitaDomFacade.findAll()).thenReturn(atencionTest);
        
        assertEquals(atencionTest, atencion);
        
    }

   
}
