/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.atenciones;

import entities.atenciones.AtencionEnfFEMPA;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface AtencionEnfFEMPAFacadeLocal {

    void create(AtencionEnfFEMPA atencionEnfFEMPA);

    void edit(AtencionEnfFEMPA atencionEnfFEMPA);

    void remove(AtencionEnfFEMPA atencionEnfFEMPA);

    AtencionEnfFEMPA find(Object id);

    List<AtencionEnfFEMPA> findAll();

    List<AtencionEnfFEMPA> findRange(int[] range);

    int count();
    
}
