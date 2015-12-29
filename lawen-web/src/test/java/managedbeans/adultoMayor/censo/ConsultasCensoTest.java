///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package managedbeans.adultoMayor.censo;
//
//import entities.Paciente;
//import entities.Usuario;
//import entities.adultoMayor.CartolaSeguimientoPSAM;
//import entities.adultoMayor.IngresoPSAM;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//import sessionbeans.adultoMayor.CartolaSeguimientoPSAMFacadeLocal;
//
///**
// *
// * @author jeanpierre
// */
//@RunWith(MockitoJUnitRunner.class)
//public class ConsultasCensoTest {
//    @Mock
//    private ConsultasCensoTest consultaCensoTest;
//    @Mock
//    private EntityManager entityManager;
//    @Mock
//    private Query query;
//    public ConsultasCensoTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        query = mock(Query.class);
//        entityManager = Mockito.mock(EntityManager.class);
//        consultaCensoTest=Mockito.mock(ConsultasCensoTest.class);
//        consultaCensoTest.entityManager=entityManager;
//    }
//
//   
//
//    /**
//     * Test of isCensable method, of class ConsultasCenso.
//     */
//    @Test
//    public void testIsCensable() throws ParseException {
//        System.out.println("isCensable");
//        ConsultasCenso consulta = new ConsultasCenso();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        System.out.println("no es censable porque es mayor a 1 año de antiguedad con el sistema");
//        date = simpleDateFormat.parse("12/12/1999");
//        assertEquals(false, consulta.isCensable(date));
//        System.out.println("Es censable porque no es mayor de un año de antiguedad");    
//        date = simpleDateFormat.parse("12/12/2020");
//        assertEquals(true, consulta.isCensable(date));
//       
//    }
//
//
//    /**
//     * Test of CheckRealizado method, of class ConsultasCenso.
//     */
//    @Test
//    public void testCheckRealizado() {
//        System.out.println("CheckRealizado");
//        long id = 1L;
//        long id2 = 3L;
//        long id3 = 3L;
//        long id4 = 4L;
//        long id5 = 5L;
//        
//        ArrayList<Long> ids = new ArrayList();
//        ids.add(id);
//        ids.add(id2);
//        ids.add(id3);
//        ids.add(id4);
//        ids.add(id5);
//                
//        ConsultasCenso instance = new ConsultasCenso();
//                 
//        assertEquals(true, instance.CheckRealizado(1L, ids));
//        assertEquals(false, instance.CheckRealizado(10L, ids));
//        
//        
//    }
//
//    /**
//     * Test of censoPSAMSeccionA method, of class ConsultasCenso.
//     */
//    @Test
//    public void testCensoPSAMSeccionA() throws ParseException {
//        System.out.println("censoPSAMSeccionA");
//        
//        //cartola seguimiento 1
//        
//        CartolaSeguimientoPSAM psam=new CartolaSeguimientoPSAM();
//        psam.setId(1L);
//        psam.setAntiguedad_programa("nuevo");
//        psam.setClasificacion_barthel("moderado");
//        psam.setClasificacion_efam("autovalente sin riesgo");
//        psam.setClasificacion_folstein(null);
//        psam.setClasificacion_pfeffer("normal");
//        psam.setClasificacion_yesavage("depresión leve");
//        psam.setEdad(76);
//        psam.setEstado_nutricional("obeso");
//        psam.setPaciente_institucionalizado(false);
//        psam.setRealiza_actividadFisica(false);
//        psam.setSospecha_maltrato(false);
//        psam.setSospecha_maltrato_obs("no se encontro");
//        psam.setValoracion_riesgo("normal");
//        Paciente paciente = new Paciente();
//        paciente.setId(1L);
//        paciente.setRut_paciente("166036267");
//        paciente.setNombres_paciente("Daniel");
//        paciente.setApellidoPaterno_paciente("Araya");
//        paciente.setGenero_paciente("masculino");
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date;
//        date = simpleDateFormat.parse("01/06/1955");
//        paciente.setFechaNacimiento_paciente(date);
//        psam.setPaciente(paciente);
//        Usuario user = new Usuario();
//        user.setId(1L);
//        user.setRut("179618524");
//        user.setPassword("admin");
//        user.setNombres_usuario("sebastian");
//        user.setApellidoPaterno_usuario("Meza");
//        psam.setProfesional(user);
//        
//        CartolaSeguimientoPSAM psam2=new CartolaSeguimientoPSAM();
//        psam2.setId(1L);
//        psam2.setAntiguedad_programa("nuevo");
//        psam2.setClasificacion_barthel("leve");
//        psam2.setClasificacion_efam("autovalente von riesgo");
//        psam2.setClasificacion_folstein(null);
//        psam2.setClasificacion_pfeffer("normal");
//        psam2.setClasificacion_yesavage("normal");
//        psam2.setEdad(55);
//        psam2.setEstado_nutricional("normal");
//        psam2.setPaciente_institucionalizado(false);
//        psam2.setRealiza_actividadFisica(false);
//        psam2.setSospecha_maltrato(false);
//        psam2.setSospecha_maltrato_obs("no se encontro");
//        psam2.setValoracion_riesgo("normal");
//        Paciente paciente2 = new Paciente();
//        paciente2.setId(1L);
//        paciente2.setRut_paciente("79344613");
//        paciente2.setNombres_paciente("Maria");
//        paciente2.setApellidoPaterno_paciente("Vargas");
//        paciente2.setGenero_paciente("femenino");
//        
//        date = simpleDateFormat.parse("01/06/1968");
//        paciente.setFechaNacimiento_paciente(date);
//        psam2.setPaciente(paciente);
//        Usuario user2 = new Usuario();
//        user2.setId(2L);
//        user2.setRut("187664802");
//        user2.setPassword("medico");
//        user2.setNombres_usuario("Daniel");
//        user2.setApellidoPaterno_usuario("Quinteros");
//        psam2.setProfesional(user);
//        
//        List <CartolaSeguimientoPSAM> elements = new ArrayList<>();
//        elements.add(psam);
//        elements.add(psam2);
//        
//        List <CartolaSeguimientoPSAM> elementsTest = new ArrayList<>();
//        elementsTest.add(psam);
//        elementsTest.add(psam2);
//        
//        
//        
//        when(entityManager.createNamedQuery("SELECT p FROM CartolaSeguimientoPSAM p WHERE p.id = :1L")).thenReturn(query);
//        Query querys = entityManager.createNamedQuery("SELECT p FROM Paciente p WHERE p.id = :1L");
//        when(querys.getResultList()).thenReturn(elements);
//        assertEquals(elementsTest,elements);
//    }
//
//   
//   
//    
//}
