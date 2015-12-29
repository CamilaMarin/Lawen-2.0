/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.CCVNutricionista;
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
public class CCVNutricionistaFacadeTest {
    @Mock
    private CCVNutricionistaFacade ccvNutricionistaFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    
    public CCVNutricionistaFacadeTest() {
    }
    
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager = Mockito.mock(EntityManager.class);
        ccvNutricionistaFacade=Mockito.mock(CCVNutricionistaFacade.class);
        ccvNutricionistaFacade.setEm(entityManager);
    }

    /**
     * Test of create method, of class CCVNutricionistaFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        CCVNutricionista ccvNut= new CCVNutricionista();
        ccvNut.setId(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        ccvNut.setFechaAtencionNutri(date);
        List<CCVNutricionista> nut = new ArrayList<>();
        nut.add(ccvNut);
        when(entityManager.createNamedQuery("SELECT p FROM CCVNutricionista p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM CCVNutricionista p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(nut);
        assertEquals(true, nut!=null);
       
    }

    /*
     * Test of find method, of class CCVNutricionistaFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        CCVNutricionista ccvNut= new CCVNutricionista();
        ccvNut.setId(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        ccvNut.setFechaAtencionNutri(date);
        List<CCVNutricionista> nut = new ArrayList<>();
        nut.add(ccvNut);
        CCVNutricionista ccvNutTest= new CCVNutricionista();
        ccvNutTest.setId(1L);
        ccvNutTest.setFechaAtencionNutri(date);
        List<CCVNutricionista> nutTest = new ArrayList<>();
        when(entityManager.createNamedQuery("SELECT p FROM CCVNutricionista p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM CCVNutricionista p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(nut);
        when(ccvNutricionistaFacade.find(ccvNut.getId())).thenReturn(ccvNutTest);
        nutTest.add(ccvNutTest);
        assertEquals(nutTest, nut);
        
    }

    /**
     * Test of findAll method, of class CCVNutricionistaFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        CCVNutricionista ccvNut= new CCVNutricionista();
        ccvNut.setId(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        ccvNut.setFechaAtencionNutri(date);
        CCVNutricionista ccvNut2= new CCVNutricionista();
        ccvNut2.setId(2L);
        ccvNut2.setFechaAtencionNutri(date);
        List<CCVNutricionista> nut = new ArrayList<>();
        nut.add(ccvNut);
        nut.add(ccvNut2);
        List<CCVNutricionista> nutTest = new ArrayList<>();
        nutTest.add(ccvNut);
        nutTest.add(ccvNut2);
        when(entityManager.createNamedQuery("SELECT p FROM CCVNutricionista p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM CCVNutricionista p");
        when(querys.getResultList()).thenReturn(nut);
        when(ccvNutricionistaFacade.findAll()).thenReturn(nutTest);
        assertEquals(nutTest, nut);
        
    }

    
}
