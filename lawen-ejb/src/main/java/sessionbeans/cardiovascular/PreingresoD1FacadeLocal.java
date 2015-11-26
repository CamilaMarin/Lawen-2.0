/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.PreingresoD1;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author matias
 */
@Local
public interface PreingresoD1FacadeLocal {

    void create(PreingresoD1 preingresoD1);

    void edit(PreingresoD1 preingresoD1);

    void remove(PreingresoD1 preingresoD1);

    PreingresoD1 find(Object id);

    List<PreingresoD1> findAll();

    List<PreingresoD1> findRange(int[] range);

    int count();
    
}
