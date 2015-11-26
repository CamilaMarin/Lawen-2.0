/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.atenciones;

import entities.atenciones.AtencionMedMorbilidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface AtencionMedMorbilidadFacadeLocal {

    void create(AtencionMedMorbilidad atencionMedMorbilidad);

    void edit(AtencionMedMorbilidad atencionMedMorbilidad);

    void remove(AtencionMedMorbilidad atencionMedMorbilidad);

    AtencionMedMorbilidad find(Object id);

    List<AtencionMedMorbilidad> findAll();

    List<AtencionMedMorbilidad> findRange(int[] range);

    int count();
    
}
