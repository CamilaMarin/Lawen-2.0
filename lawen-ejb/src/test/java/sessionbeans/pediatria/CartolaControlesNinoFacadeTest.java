/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.pediatria;

import entities.pediatria.CartolaControlesNino;
import entities.pediatria.PacienteNino;
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
public class CartolaControlesNinoFacadeTest {
    
    private static CartolaControlesNinoFacade mockCartolaControlesNinoFacade;
    private static CartolaControlesNino cartolanino1;
    private static CartolaControlesNino cartolanino2;
    private static PacienteNino pacientenino;
    
    public CartolaControlesNinoFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mockCartolaControlesNinoFacade = mock(CartolaControlesNinoFacade.class);
        pacientenino = new PacienteNino();
        pacientenino.setId(1L);
        
        cartolanino1 = new CartolaControlesNino();
        cartolanino1.setId(1L);
        cartolanino1.setPacienteNino(pacientenino);
        
        cartolanino2 = new CartolaControlesNino();
        cartolanino2.setId(2L);
        cartolanino2.setPacienteNino(pacientenino);
        
        List<CartolaControlesNino> cartolas=new ArrayList<>();
        cartolas.add(cartolanino1);
        cartolas.add(cartolanino2);
        
        when(mockCartolaControlesNinoFacade.findByPacienteNino(pacientenino)).thenReturn(cartolas);
    }
    
    @After
    public void tearDown() {
    }
    @Test 
    public void testFindByPacienteNino() throws Exception {
        PacienteNino expPacientenino = new PacienteNino();
        expPacientenino.setId(1L);
        
        CartolaControlesNino expCartola1 = new CartolaControlesNino();
        expCartola1.setId(1L);
        expCartola1.setPacienteNino(expPacientenino);
        
        CartolaControlesNino expCartola2 = new CartolaControlesNino();
        expCartola2.setId(2L);
        expCartola2.setPacienteNino(expPacientenino);
        
        List<CartolaControlesNino> expCartolas = new ArrayList<>();
        expCartolas.add(expCartola1);
        expCartolas.add(expCartola2);
        
        assertEquals(expCartolas, mockCartolaControlesNinoFacade.findByPacienteNino(expPacientenino));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
}
