/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.Paciente;
import entities.cardiovascular.CartolaSeguimientoCCV;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface CartolaSeguimientoCCVFacadeLocal {

    void create(CartolaSeguimientoCCV cartolaSeguimientoCCV);

    void edit(CartolaSeguimientoCCV cartolaSeguimientoCCV);

    void remove(CartolaSeguimientoCCV cartolaSeguimientoCCV);

    CartolaSeguimientoCCV find(Object id);

    List<CartolaSeguimientoCCV> findAll();

    List<CartolaSeguimientoCCV> findRange(int[] range);

    int count();

    List<CartolaSeguimientoCCV> findByPaciente(Paciente paciente);
    
}
