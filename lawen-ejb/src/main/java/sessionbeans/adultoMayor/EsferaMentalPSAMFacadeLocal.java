/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.adultoMayor;

import entities.adultoMayor.EsferaMentalPSAM;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface EsferaMentalPSAMFacadeLocal {

    void create(EsferaMentalPSAM esferaMentalPSAM);

    void edit(EsferaMentalPSAM esferaMentalPSAM);

    void remove(EsferaMentalPSAM esferaMentalPSAM);

    EsferaMentalPSAM find(Object id);

    List<EsferaMentalPSAM> findAll();

    List<EsferaMentalPSAM> findRange(int[] range);

    int count();
    
}
