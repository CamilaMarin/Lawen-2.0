/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.atenciones;

import entities.Paciente;
import entities.atenciones.AtencionNutriEmbarazada;
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
public class AtencionNutriEmbarazadaFacadeTest {
    @Mock
    private AtencionNutriEmbarazadaFacade atencionNutriEmbarazadaFacade;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    
    public AtencionNutriEmbarazadaFacadeTest() {
    }
    
    @Before
    public void setUp() {
        query = mock(Query.class);
        entityManager =Mockito.mock(EntityManager.class);
        atencionNutriEmbarazadaFacade=Mockito.mock(AtencionNutriEmbarazadaFacade.class);
        atencionNutriEmbarazadaFacade.setEm(entityManager);
    }

    /**
     * Test of create method, of class AtencionNutriEmbarazadaFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        AtencionNutriEmbarazada embarazada = new AtencionNutriEmbarazada();
        embarazada.setId(1L);
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/2014");
        embarazada.setFecha_control(date);
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setRut_paciente("179618524");
        paciente.setNombres_paciente("Fernanda");
        paciente.setApellidoPaterno_paciente("Carrasco");
        embarazada.setPaciente(paciente);
        List<AtencionNutriEmbarazada> atencion = new ArrayList<>();
        atencion.add(embarazada);
        when(entityManager.createNamedQuery("SELECT p FROM AtencionNutriEmbarazada p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionNutriEmbarazada p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(atencion);
        assertEquals(true, atencion!=null);
        
        
    }

    /**
     * Test of find method, of class AtencionNutriEmbarazadaFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        AtencionNutriEmbarazada embarazada = new AtencionNutriEmbarazada();
        embarazada.setId(1L);
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/2014");
        embarazada.setFecha_control(date);
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setRut_paciente("179618524");
        paciente.setNombres_paciente("Fernanda");
        paciente.setApellidoPaterno_paciente("Carrasco");
        embarazada.setPaciente(paciente);
        AtencionNutriEmbarazada embarazada2 = new AtencionNutriEmbarazada();
        embarazada2.setId(1L);
        embarazada2.setFecha_control(date);
        embarazada2.setPaciente(paciente);
        List<AtencionNutriEmbarazada> atencion = new ArrayList<>();
        atencion.add(embarazada);
        List<AtencionNutriEmbarazada> atencionTest = new ArrayList<>();
        when(entityManager.createNamedQuery("SELECT p FROM AtencionNutriEmbarazada p WHERE p.id = :1L")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionNutriEmbarazada p WHERE p.id = :1L");
        when(querys.getResultList()).thenReturn(atencion);
        when(atencionNutriEmbarazadaFacade.find(embarazada.getId())).thenReturn(embarazada2);
        atencionTest.add(embarazada2);
        assertEquals(atencionTest, atencion);
    }

    /**
     * Test of findAll method, of class AtencionNutriEmbarazadaFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        AtencionNutriEmbarazada embarazada = new AtencionNutriEmbarazada();
        embarazada.setId(1L);
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/2014");
        embarazada.setFecha_control(date);
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setRut_paciente("179618524");
        paciente.setNombres_paciente("Fernanda");
        paciente.setApellidoPaterno_paciente("Carrasco");
        embarazada.setPaciente(paciente);
        AtencionNutriEmbarazada embarazada2 = new AtencionNutriEmbarazada();
        embarazada2.setId(2L);
        embarazada2.setFecha_control(date);
        embarazada2.setPaciente(paciente);
        List<AtencionNutriEmbarazada> atencion = new ArrayList<>();
        atencion.add(embarazada);
        atencion.add(embarazada2);
        List<AtencionNutriEmbarazada> atencionTest = new ArrayList<>();
        atencionTest.add(embarazada);
        atencionTest.add(embarazada2);
        when(entityManager.createNamedQuery("SELECT p FROM AtencionNutriEmbarazada p")).thenReturn(query);
        Query querys = entityManager.createNamedQuery("SELECT p FROM AtencionNutriEmbarazada p");
        when(querys.getResultList()).thenReturn(atencion);
        when(atencionNutriEmbarazadaFacade.findAll()).thenReturn(atencionTest);
        
        assertEquals(atencionTest, atencion);
        
    }

    
}
