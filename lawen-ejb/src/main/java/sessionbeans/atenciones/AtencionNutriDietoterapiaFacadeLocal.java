/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.atenciones;

import entities.atenciones.AtencionNutriDietoterapia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface AtencionNutriDietoterapiaFacadeLocal {

    void create(AtencionNutriDietoterapia atencionNutriDietoterapia);

    void edit(AtencionNutriDietoterapia atencionNutriDietoterapia);

    void remove(AtencionNutriDietoterapia atencionNutriDietoterapia);

    AtencionNutriDietoterapia find(Object id);

    List<AtencionNutriDietoterapia> findAll();

    List<AtencionNutriDietoterapia> findRange(int[] range);

    int count();
    
}
