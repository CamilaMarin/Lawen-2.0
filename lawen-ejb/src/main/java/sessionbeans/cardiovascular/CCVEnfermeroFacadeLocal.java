/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.CCVEnfermero;
import entities.cardiovascular.CartolaSeguimientoCCV;
import entities.cardiovascular.FichaEnfermero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface CCVEnfermeroFacadeLocal {

    void create(CCVEnfermero cCVEnfermero);

    void edit(CCVEnfermero cCVEnfermero);

    void remove(CCVEnfermero cCVEnfermero);

    CCVEnfermero find(Object id);

    List<CCVEnfermero> findAll();

    List<CCVEnfermero> findRange(int[] range);

    int count();
    
    public void crearFicha(CartolaSeguimientoCCV cartola, FichaEnfermero ficha, CCVEnfermero enf);
}
