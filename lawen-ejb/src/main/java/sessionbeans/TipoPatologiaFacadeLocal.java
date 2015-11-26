/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.TipoPatologia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface TipoPatologiaFacadeLocal {

    void create(TipoPatologia tipoPatologia);

    void edit(TipoPatologia tipoPatologia);

    void remove(TipoPatologia tipoPatologia);

    TipoPatologia find(Object id);

    List<TipoPatologia> findAll();

    List<TipoPatologia> findRange(int[] range);

    int count();
    
}
