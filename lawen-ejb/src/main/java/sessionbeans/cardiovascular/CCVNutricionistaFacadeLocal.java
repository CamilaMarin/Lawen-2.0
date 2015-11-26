/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.CCVNutricionista;
import entities.cardiovascular.CartolaSeguimientoCCV;
import entities.cardiovascular.FichaNutricionista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface CCVNutricionistaFacadeLocal {

    void create(CCVNutricionista cCVNutricionista);

    void edit(CCVNutricionista cCVNutricionista);

    void remove(CCVNutricionista cCVNutricionista);

    CCVNutricionista find(Object id);

    List<CCVNutricionista> findAll();

    List<CCVNutricionista> findRange(int[] range);

    int count();
    
    public void crearFicha(CartolaSeguimientoCCV cartola, FichaNutricionista ficha, CCVNutricionista nutri);
    
}
