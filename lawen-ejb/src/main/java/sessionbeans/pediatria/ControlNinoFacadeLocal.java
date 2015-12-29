/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.pediatria;

import entities.pediatria.CartolaControlesNino;
import entities.pediatria.ControlNino;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Francisco Avello
 */
@Local
public interface ControlNinoFacadeLocal {

    void create(ControlNino controlNino);

    void edit(ControlNino controlNino);

    void remove(ControlNino controlNino);

    ControlNino find(Object id);

    List<ControlNino> findAll();

    List<ControlNino> findRange(int[] range);

    int count();
    
    List<ControlNino> findbyCartola(long id);
    
    List<ControlNino> findLastControl(long id);
            
}
