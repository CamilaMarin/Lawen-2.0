/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Patologia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface PatologiaFacadeLocal {

    void create(Patologia patologia);

    void edit(Patologia patologia);

    void remove(Patologia patologia);

    Patologia find(Object id);

    List<Patologia> findAll();

    List<Patologia> findRange(int[] range);

    int count();
    
}
