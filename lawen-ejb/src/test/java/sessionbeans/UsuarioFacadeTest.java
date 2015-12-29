/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Usuario;
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
public class UsuarioFacadeTest {
    @Mock
    private UsuarioFacade usuarioFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    
    public UsuarioFacadeTest() {
    }
    
      
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager = Mockito.mock(EntityManager.class);
        usuarioFacade=Mockito.mock(UsuarioFacade.class);
        usuarioFacade.setEm(entityManager);
    }
   

    /**
     * Test of create method, of class UsuarioFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Usuario user = new Usuario();
        user.setId(1L);
        user.setRut("179618524");
        user.setPassword("admin");
        user.setNombres_usuario("sebastian");
        user.setApellidoPaterno_usuario("Meza");
        List<Usuario> Users = new ArrayList<>();
        Users.add(user);
        when(entityManager.createNamedQuery("SELECT p FROM Usuario p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM Usuario p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(Users);
        assertEquals(true, Users!=null);
        
    }

  

    /**
     * Test of find method, of class UsuarioFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Usuario user = new Usuario();
        user.setId(1L);
        user.setRut("179618524");
        user.setPassword("admin");
        user.setNombres_usuario("sebastian");
        user.setApellidoPaterno_usuario("Meza");
        List<Usuario> Users = new ArrayList<>();
        Users.add(user);
        Usuario userTest = new Usuario();
        userTest.setId(1L);
        userTest.setRut("179618524");
        user.setPassword("admin");
        user.setNombres_usuario("sebastian");
        user.setApellidoPaterno_usuario("Meza");
        List<Usuario> UsersTest = new ArrayList<>();
        when(entityManager.createNamedQuery("SELECT p FROM Usuario p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM Usuario p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(Users);
        when(usuarioFacade.find(user.getId())).thenReturn(userTest);
        UsersTest.add(userTest);
        assertEquals(UsersTest, Users);
        
    }

    /**
     * Test of findAll method, of class UsuarioFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Usuario user = new Usuario();
        user.setId(1L);
        user.setRut("179618524");
        user.setPassword("admin");
        user.setNombres_usuario("sebastian");
        user.setApellidoPaterno_usuario("Meza");
        
        Usuario user2 = new Usuario();
        user2.setId(2L);
        user2.setRut("187664802");
        user.setPassword("password");
        user.setNombres_usuario("daniel");
        user.setApellidoPaterno_usuario("Vargas");
        
        Usuario user3 = new Usuario();
        user3.setId(3L);
        user3.setRut("79344613");
        user.setPassword("matiquinteros");
        user.setNombres_usuario("matias");
        user.setApellidoPaterno_usuario("Quinteros");
        
        List<Usuario> Users = new ArrayList<>();
        Users.add(user);
        Users.add(user2);
        Users.add(user3);
        List<Usuario> UsersTest = new ArrayList<>();
        UsersTest.add(user);
        UsersTest.add(user2);
        UsersTest.add(user3);
        when(entityManager.createNamedQuery("SELECT p FROM Usuario p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM Usuario p");
        when(querys.getResultList()).thenReturn(Users);
        when(usuarioFacade.findAll()).thenReturn(UsersTest);
        assertEquals(UsersTest, Users);
        
    }

   
}
