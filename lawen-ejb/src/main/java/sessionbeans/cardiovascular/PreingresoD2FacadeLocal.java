/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.PreingresoD2;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author matias
 */
@Local
public interface PreingresoD2FacadeLocal {

    void create(PreingresoD2 preingresoD2);

    void edit(PreingresoD2 preingresoD2);

    void remove(PreingresoD2 preingresoD2);

    PreingresoD2 find(Object id);

    List<PreingresoD2> findAll();

    List<PreingresoD2> findRange(int[] range);

    int count();
    
}
