/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.PreingresoD3;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author matias
 */
@Local
public interface PreingresoD3FacadeLocal {

    void create(PreingresoD3 preingresoD3);

    void edit(PreingresoD3 preingresoD3);

    void remove(PreingresoD3 preingresoD3);

    PreingresoD3 find(Object id);

    List<PreingresoD3> findAll();

    List<PreingresoD3> findRange(int[] range);

    int count();
    
}
