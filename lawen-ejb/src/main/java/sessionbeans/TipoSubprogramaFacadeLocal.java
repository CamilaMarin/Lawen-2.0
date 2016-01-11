/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.TipoSubprograma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Francisco Avello
 */
@Local
public interface TipoSubprogramaFacadeLocal {

    void create(TipoSubprograma tipoSubprograma);

    void edit(TipoSubprograma tipoSubprograma);

    void remove(TipoSubprograma tipoSubprograma);

    TipoSubprograma find(Object id);

    List<TipoSubprograma> findAll();

    List<TipoSubprograma> findRange(int[] range);

    int count();
    
}
