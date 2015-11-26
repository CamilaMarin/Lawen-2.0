/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.adultoMayor;

import entities.adultoMayor.EsferaClinicaPSAM;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface EsferaClinicaPSAMFacadeLocal {

    void create(EsferaClinicaPSAM esferaClinicaPSAM);

    void edit(EsferaClinicaPSAM esferaClinicaPSAM);

    void remove(EsferaClinicaPSAM esferaClinicaPSAM);

    EsferaClinicaPSAM find(Object id);

    List<EsferaClinicaPSAM> findAll();

    List<EsferaClinicaPSAM> findRange(int[] range);

    int count();
    
}
