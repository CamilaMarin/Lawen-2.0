/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.pediatria;

import entities.pediatria.PacienteNino;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 *
 * @author IHC
 */
public class PacienteNinoFacadeTest {
    private static PacienteNinoFacade mockPacienteNinoFacade;
    private static PacienteNino pacientenino1;
    private static PacienteNino pacientenino2;
    
    public PacienteNinoFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        mockPacienteNinoFacade=mock(PacienteNinoFacade.class);
        pacientenino1=new PacienteNino();
        pacientenino1.setId(1L);
        pacientenino1.setNombres_nino("Claudia Irene");
        pacientenino1.setApellidoPaterno_nino("Guzmán");
        pacientenino1.setApellidoMaterno_nino("Silva");
        pacientenino1.setRut_nino("17708786-6");
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        pacientenino1.setFechaNacimiento_nino(date);
        pacientenino1.setEstado_paciente_nino("Activo");
        
        
        pacientenino2=new PacienteNino();
        pacientenino2.setId(2L);
        pacientenino2.setNombres_nino("Alexis Rolando");
        pacientenino2.setApellidoPaterno_nino("Casanueva");
        pacientenino2.setApellidoMaterno_nino("Ojeda");
        pacientenino2.setRut_nino("18204469-5");
        date = simpleDateFormat.parse("12/12/1999");
        pacientenino2.setFechaNacimiento_nino(date);
        pacientenino2.setEstado_paciente_nino("Pasivo");

        
        List<PacienteNino> pacientesnino=new ArrayList<>();
        pacientesnino.add(pacientenino1);
        
        when(mockPacienteNinoFacade.findbyPacienteNinoActivo()).thenReturn(pacientesnino);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testFindbyActivo() throws ParseException{
        System.out.println("findbyActivo");
        PacienteNino expResult = new PacienteNino();
        expResult.setId(1L);
        expResult.setNombres_nino("Claudia Irene");
        expResult.setApellidoPaterno_nino("Guzmán");
        expResult.setApellidoMaterno_nino("Silva");
        expResult.setRut_nino("17708786-6");
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        date = simpleDateFormat.parse("12/12/1999");
        expResult.setFechaNacimiento_nino(date);
        expResult.setEstado_paciente_nino("Activo");
        
        PacienteNino expResult1 =new PacienteNino();
        expResult1.setId(2L);
        expResult1.setNombres_nino("Alexis Rolando");
        expResult1.setApellidoPaterno_nino("Casanueva");
        expResult1.setApellidoMaterno_nino("Ojeda");
        expResult1.setRut_nino("18204469-5");
        date = simpleDateFormat.parse("12/12/1999");
        expResult1.setFechaNacimiento_nino(date);
        expResult1.setEstado_paciente_nino("Pasivo");
        
        List<PacienteNino> explist=new ArrayList<>();
        explist.add(expResult);
        
        assertEquals(explist, mockPacienteNinoFacade.findbyPacienteNinoActivo());
    }
        
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
}
