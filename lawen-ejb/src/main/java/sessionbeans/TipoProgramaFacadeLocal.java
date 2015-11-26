/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.TipoPrograma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface TipoProgramaFacadeLocal {

    void create(TipoPrograma tipoPrograma);

    void edit(TipoPrograma tipoPrograma);

    void remove(TipoPrograma tipoPrograma);

    TipoPrograma find(Object id);

    List<TipoPrograma> findAll();

    List<TipoPrograma> findRange(int[] range);

    int count();
    
}
