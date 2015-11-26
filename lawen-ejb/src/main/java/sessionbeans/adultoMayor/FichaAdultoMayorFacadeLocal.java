/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.adultoMayor;

import entities.adultoMayor.FichaAdultoMayor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface FichaAdultoMayorFacadeLocal {

    void create(FichaAdultoMayor fichaAdultoMayor);

    void edit(FichaAdultoMayor fichaAdultoMayor);

    void remove(FichaAdultoMayor fichaAdultoMayor);

    FichaAdultoMayor find(Object id);

    List<FichaAdultoMayor> findAll();

    List<FichaAdultoMayor> findRange(int[] range);

    int count();
    
}
