/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.CCVMedico;
import java.text.SimpleDateFormat;
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
public class CCVMedicoFacadeTest {
    @Mock
    private CCVMedicoFacade ccvMedicoFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    
    public CCVMedicoFacadeTest() {
    }
    
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager = Mockito.mock(EntityManager.class);
        ccvMedicoFacade=Mockito.mock(CCVMedicoFacade.class);
        ccvMedicoFacade.setEm(entityManager);
                
    }

    /**
     * Test of create method, of class CCVMedicoFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        CCVMedico ccvM= new CCVMedico();
        ccvM.setId(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        ccvM.setFechaAtencionMed(date);
        List<CCVMedico> medico=new ArrayList<>();
        medico.add(ccvM);
        when(entityManager.createNamedQuery("SELECT p FROM CCVMedico p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM CCVMedico p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(medico);
        assertEquals(true, medico!=null);
    }

    /**
     * Test of find method, of class CCVMedicoFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        CCVMedico ccvM = new CCVMedico();
        ccvM.setId(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        ccvM.setFechaAtencionMed(date);
        List<CCVMedico> medico = new ArrayList<>();
        medico.add(ccvM);
        CCVMedico ccvMTest = new CCVMedico();
        ccvMTest.setId(1L);
        ccvMTest.setFechaAtencionMed(date);
        List<CCVMedico> medicoTest = new ArrayList<>();
        when(entityManager.createNamedQuery("SELECT p FROM CCVMedico p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM CCVMedico p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(medico);
        when(ccvMedicoFacade.find(ccvM.getId())).thenReturn(ccvMTest);
        medicoTest.add(ccvMTest);
        assertEquals(medicoTest, medico);
        
    }

    /**
     * Test of findAll method, of class CCVMedicoFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        CCVMedico ccvM = new CCVMedico();
        ccvM.setId(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        ccvM.setFechaAtencionMed(date);
        
        CCVMedico ccvM2 = new CCVMedico();
        ccvM2.setId(2L);
        ccvM2.setFechaAtencionMed(date);
        List<CCVMedico> medico = new ArrayList<>();
        medico.add(ccvM);
        medico.add(ccvM2);
        List<CCVMedico> medicoTest = new ArrayList<>();
        medicoTest.add(ccvM);
        medicoTest.add(ccvM2);
        when(entityManager.createNamedQuery("SELECT p FROM CCVMedico p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM CCVMedico p");
        when(querys.getResultList()).thenReturn(medico);
        when(ccvMedicoFacade.findAll()).thenReturn(medicoTest);
        
        assertEquals(medicoTest, medico);
    }

    
        
}
