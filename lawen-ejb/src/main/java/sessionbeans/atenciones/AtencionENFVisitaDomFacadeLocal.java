/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.atenciones;

import entities.atenciones.AtencionENFVisitaDom;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface AtencionENFVisitaDomFacadeLocal {

    void create(AtencionENFVisitaDom atencionENFVisitaDom);

    void edit(AtencionENFVisitaDom atencionENFVisitaDom);

    void remove(AtencionENFVisitaDom atencionENFVisitaDom);

    AtencionENFVisitaDom find(Object id);

    List<AtencionENFVisitaDom> findAll();

    List<AtencionENFVisitaDom> findRange(int[] range);

    int count();
    
}
