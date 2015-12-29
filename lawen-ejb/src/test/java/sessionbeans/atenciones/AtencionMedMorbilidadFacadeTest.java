/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.atenciones;

import entities.atenciones.AtencionMedMorbilidad;
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
public class AtencionMedMorbilidadFacadeTest {
    
    @Mock
    private AtencionMedMorbilidadFacade atencionMedMorbilidadFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    
    public AtencionMedMorbilidadFacadeTest() {
    }
    
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager = Mockito.mock(EntityManager.class);
        atencionMedMorbilidadFacade=Mockito.mock(AtencionMedMorbilidadFacade.class);
        atencionMedMorbilidadFacade.setEm(entityManager);
    }

    /**
     * Test of create method, of class AtencionMedMorbilidadFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        AtencionMedMorbilidad morbilidad  =new AtencionMedMorbilidad();
        morbilidad.setId(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        morbilidad.setFechaAtencion_morb(date);
        List<AtencionMedMorbilidad> atencion = new ArrayList<>();
        atencion.add(morbilidad);
        when(entityManager.createNamedQuery("SELECT p FROM AtencionMedMorbilidad p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionMedMorbilidad p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(atencion);
        assertEquals(true, atencion != null);
       
    }

    
    /**
     * Test of find method, of class AtencionMedMorbilidadFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        AtencionMedMorbilidad morbilidad = new AtencionMedMorbilidad();
        morbilidad.setId(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        morbilidad.setFechaAtencion_morb(date);
        AtencionMedMorbilidad morbilidadTest = new AtencionMedMorbilidad();
        morbilidadTest.setId(1L);
        morbilidadTest.setFechaAtencion_morb(date);
        List<AtencionMedMorbilidad> atencion = new ArrayList<>();
        atencion.add(morbilidad);
        List<AtencionMedMorbilidad> atencionTest = new ArrayList<>();
        when(entityManager.createNamedQuery("SELECT p FROM AtencionMedMorbilidad p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionMedMorbilidad p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(atencion);
        when(atencionMedMorbilidadFacade.find(morbilidad.getId())).thenReturn(morbilidadTest);
        atencionTest.add(morbilidadTest);
        assertEquals(atencionTest, atencion);
    }

    /**
     * Test of findAll method, of class AtencionMedMorbilidadFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        AtencionMedMorbilidad morbilidad = new AtencionMedMorbilidad();
        morbilidad.setId(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        morbilidad.setFechaAtencion_morb(date);
        AtencionMedMorbilidad morbilidad2 = new AtencionMedMorbilidad();
        morbilidad2.setId(2L);
        morbilidad2.setFechaAtencion_morb(date);
        List<AtencionMedMorbilidad> atencion = new ArrayList<>();
        atencion.add(morbilidad);
        atencion.add(morbilidad2);
        List<AtencionMedMorbilidad> atencionTest = new ArrayList<>();
        atencionTest.add(morbilidad);
        atencionTest.add(morbilidad2);
        when(entityManager.createNamedQuery("SELECT p FROM AtencionMedMorbilidad p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionMedMorbilidad p");
        when(querys.getResultList()).thenReturn(atencion);
        when(atencionMedMorbilidadFacade.findAll()).thenReturn(atencionTest);
       
        assertEquals(atencionTest, atencion);
    }

    
}
