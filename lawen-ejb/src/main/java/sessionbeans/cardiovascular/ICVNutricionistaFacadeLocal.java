/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.CartolaSeguimientoCCV;
import entities.cardiovascular.FichaNutricionista;
import entities.cardiovascular.ICVNutricionista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author matias
 */
@Local
public interface ICVNutricionistaFacadeLocal {

    void create(ICVNutricionista iCVNutricionista);

    void edit(ICVNutricionista iCVNutricionista);

    void remove(ICVNutricionista iCVNutricionista);

    ICVNutricionista find(Object id);

    List<ICVNutricionista> findAll();

    List<ICVNutricionista> findRange(int[] range);

    int count();
    public void realizarPago(CartolaSeguimientoCCV cartola, FichaNutricionista ficha, ICVNutricionista nutri);
}
