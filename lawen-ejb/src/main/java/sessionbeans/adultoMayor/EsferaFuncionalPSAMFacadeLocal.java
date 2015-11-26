/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.adultoMayor;

import entities.adultoMayor.EsferaFuncionalPSAM;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface EsferaFuncionalPSAMFacadeLocal {

    void create(EsferaFuncionalPSAM esferaFuncionalPSAM);

    void edit(EsferaFuncionalPSAM esferaFuncionalPSAM);

    void remove(EsferaFuncionalPSAM esferaFuncionalPSAM);

    EsferaFuncionalPSAM find(Object id);

    List<EsferaFuncionalPSAM> findAll();

    List<EsferaFuncionalPSAM> findRange(int[] range);

    int count();
    
}
