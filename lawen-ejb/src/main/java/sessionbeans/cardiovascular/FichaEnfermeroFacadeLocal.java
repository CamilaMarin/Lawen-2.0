/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.FichaEnfermero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface FichaEnfermeroFacadeLocal {

    void create(FichaEnfermero fichaEnfermero);

    void edit(FichaEnfermero fichaEnfermero);

    void remove(FichaEnfermero fichaEnfermero);

    FichaEnfermero find(Object id);

    List<FichaEnfermero> findAll();

    List<FichaEnfermero> findRange(int[] range);

    int count();
    
}
