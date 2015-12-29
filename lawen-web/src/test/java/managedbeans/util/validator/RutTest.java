/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.util.validator;

import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeanpierre
 */
public class RutTest {
    
    public RutTest() {
    }
    
   

     /**
     * Test of check method, of class Rut.
     */
    @Test
    public void testCheck() {
        System.out.println("Prueba a método check");
        System.out.println("Evaluando rut válido: 17.961.852-4");
        assertEquals(true, verificarRut("17.961.852-4"));
        System.out.println("Evaluando rut válido: 17961852-4");
        assertEquals(true, verificarRut("17961852-4"));
        System.out.println("Evaluando rut válido: 17.961.8524");
        assertEquals(true, verificarRut("17.961.8524"));
        System.out.println("Evaluando rut válido: 179618524");
        assertEquals(true, verificarRut("179618524"));
        System.out.println("Evaluando rut inválido: 179618e524");
        assertEquals(false, verificarRut("179618e524"));
        System.out.println("Evaluando rut inválido: 1796185244");
        assertEquals(false, verificarRut("1796185244"));
        System.out.println("Evaluando rut inválido: sin rut");
        assertEquals(false, verificarRut(" "));
    }

    public boolean verificarRut(String rut) {
        Rut varRut = new Rut();
        boolean valido = varRut.check(rut);
        return valido;
    }
    
}
