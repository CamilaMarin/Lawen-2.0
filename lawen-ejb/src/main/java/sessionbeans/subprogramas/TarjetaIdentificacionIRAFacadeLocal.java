/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.subprogramas;

import entities.subprogramas.TarjetaIdentificacionIRA;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Francisco Avello
 */
@Local
public interface TarjetaIdentificacionIRAFacadeLocal {

    void create(TarjetaIdentificacionIRA tarjetaIdentificacionIRA);

    void edit(TarjetaIdentificacionIRA tarjetaIdentificacionIRA);

    void remove(TarjetaIdentificacionIRA tarjetaIdentificacionIRA);

    TarjetaIdentificacionIRA find(Object id);

    List<TarjetaIdentificacionIRA> findAll();

    List<TarjetaIdentificacionIRA> findRange(int[] range);

    int count();
    
}
