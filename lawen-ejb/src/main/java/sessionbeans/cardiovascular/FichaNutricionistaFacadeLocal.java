/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.FichaNutricionista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface FichaNutricionistaFacadeLocal {

    void create(FichaNutricionista fichaNutricionista);

    void edit(FichaNutricionista fichaNutricionista);

    void remove(FichaNutricionista fichaNutricionista);

    FichaNutricionista find(Object id);

    List<FichaNutricionista> findAll();

    List<FichaNutricionista> findRange(int[] range);

    int count();
    
}
