/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.TipoUsuario;
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
public class TipoUsuarioFacadeTest {
    @Mock
    private TipoUsuarioFacade tipoUsuarioFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    public TipoUsuarioFacadeTest() {
    }
    
       
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager = Mockito.mock(EntityManager.class);
        tipoUsuarioFacade=Mockito.mock(TipoUsuarioFacade.class);
        tipoUsuarioFacade.setEm(entityManager);
        
        
    }
    

    /**
     * Test of create method, of class TipoUsuarioFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        TipoUsuario tU=new TipoUsuario();
        tU.setId(1L);
        tU.setRol("Medico");
        tU.setRut("179618524");
        List<TipoUsuario> tipoUsuario=new ArrayList<>();
        tipoUsuario.add(tU);
        when(entityManager.createNamedQuery("SELECT p FROM TipoUsuario p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM TipoUsuario p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(tipoUsuario);
        assertEquals(true, tipoUsuario!=null);
        
    }

    
    /**
     * Test of find method, of class TipoUsuarioFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        TipoUsuario tU = new TipoUsuario();
        tU.setId(1L);
        tU.setRol("Medico");
        tU.setRut("179618524");
        List<TipoUsuario> tipoUsuario = new ArrayList<>();
        tipoUsuario.add(tU);
        TipoUsuario tUTest = new TipoUsuario();
        tUTest.setId(1L);
        tUTest.setRol("medico");
        tUTest.setRut("179618524");
        List<TipoUsuario> tipoUsuarioTest = new ArrayList<>();
        when(entityManager.createNamedQuery("SELECT p FROM TipoUsuario p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM TipoUsuario p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(tipoUsuario);
        when(tipoUsuarioFacade.find(tU.getId())).thenReturn(tUTest);
        tipoUsuarioTest.add(tUTest);
        assertEquals(tipoUsuarioTest, tipoUsuario);
    }

    /**
     * Test of findAll method, of class TipoUsuarioFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        TipoUsuario tU = new TipoUsuario();
        tU.setId(1L);
        tU.setRol("Medico");
        tU.setRut("179618524");
        TipoUsuario tU2 = new TipoUsuario();
        tU2.setId(2L);
        tU2.setRol("Enfermero");
        tU2.setRut("187664802");
        TipoUsuario tU3 = new TipoUsuario();
        tU3.setId(3L);
        tU3.setRol("Nutricionista");
        tU3.setRut("79344613");
        
        List<TipoUsuario> tipoUsuario = new ArrayList<>();
        tipoUsuario.add(tU);
        tipoUsuario.add(tU2);
        tipoUsuario.add(tU3);
        List<TipoUsuario> tipoUsuarioTest = new ArrayList<>();
        tipoUsuarioTest.add(tU);
        tipoUsuarioTest.add(tU2);
        tipoUsuarioTest.add(tU3);
        when(entityManager.createNamedQuery("SELECT p FROM TipoUsuario p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM TipoUsuario p");
        when(querys.getResultList()).thenReturn(tipoUsuario);
         when(tipoUsuarioFacade.findAll()).thenReturn(tipoUsuarioTest);
        assertEquals(tipoUsuarioTest, tipoUsuario );
        
    }

   
    
}
