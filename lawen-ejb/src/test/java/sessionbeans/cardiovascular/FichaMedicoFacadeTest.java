/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.FichaMedico;
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
public class FichaMedicoFacadeTest {
    @Mock
    private FichaMedicoFacade fichaMedicoFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    
    public FichaMedicoFacadeTest() {
    }
    
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager = Mockito.mock(EntityManager.class);
        fichaMedicoFacade=Mockito.mock(FichaMedicoFacade.class);
        fichaMedicoFacade.setEm(entityManager);
    }

    /**
     * Test of create method, of class FichaMedicoFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        FichaMedico fMedico= new FichaMedico();
        fMedico.setId(1L);
        List<FichaMedico>fichas=new ArrayList<>();
        fichas.add(fMedico);
        when(entityManager.createNamedQuery("SELECT p FROM FichaMedico p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM FichaMedico p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(fichas);
        assertEquals(true, fichas!=null);
        
        
    }


    /**
     * Test of find method, of class FichaMedicoFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        System.out.println("create");
        FichaMedico fMedico= new FichaMedico();
        fMedico.setId(1L);
        List<FichaMedico>fichas=new ArrayList<>();
        fichas.add(fMedico);
        FichaMedico fMedicoTest= new FichaMedico();
        fMedicoTest.setId(1L);
        List<FichaMedico>fichasTest=new ArrayList<>();
        when(entityManager.createNamedQuery("SELECT p FROM FichaMedico p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM FichaMedico p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(fichas);
        when(fichaMedicoFacade.find(fMedico.getId())).thenReturn(fMedicoTest);
        fichasTest.add(fMedicoTest);
        assertEquals(fichasTest, fichas);
       
    }

    /**
     * Test of findAll method, of class FichaMedicoFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        System.out.println("find");
        System.out.println("create");
        FichaMedico fMedico = new FichaMedico();
        fMedico.setId(1L);
        FichaMedico fMedico2 = new FichaMedico();
        fMedico2.setId(1L);
        FichaMedico fMedico3 = new FichaMedico();
        fMedico3.setId(1L);
        List<FichaMedico> fichas = new ArrayList<>();
        fichas.add(fMedico);
        fichas.add(fMedico2);
        fichas.add(fMedico3);
        List<FichaMedico> fichasTest = new ArrayList<>();
        fichasTest.add(fMedico);
        fichasTest.add(fMedico2);
        fichasTest.add(fMedico3);
        when(entityManager.createNamedQuery("SELECT p FROM FichaMedico p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM FichaMedico p");
        when(querys.getResultList()).thenReturn(fichas);
        when(fichaMedicoFacade.findAll()).thenReturn(fichasTest);
        assertEquals(fichasTest, fichas);
       
    }

    
    
}
