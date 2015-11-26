/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.atenciones;

import entities.atenciones.AtencionNutriEmbarazada;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface AtencionNutriEmbarazadaFacadeLocal {

    void create(AtencionNutriEmbarazada atencionNutriEmbarazada);

    void edit(AtencionNutriEmbarazada atencionNutriEmbarazada);

    void remove(AtencionNutriEmbarazada atencionNutriEmbarazada);

    AtencionNutriEmbarazada find(Object id);

    List<AtencionNutriEmbarazada> findAll();

    List<AtencionNutriEmbarazada> findRange(int[] range);

    int count();
    
}
