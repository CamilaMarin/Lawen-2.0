/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.adultoMayor;

import entities.adultoMayor.CartolaSeguimientoPSAM;
import entities.adultoMayor.EsferaClinicaPSAM;
import entities.adultoMayor.EsferaFuncionalPSAM;
import entities.adultoMayor.EsferaMentalPSAM;
import entities.adultoMayor.EsferaSocialPSAM;
import entities.adultoMayor.FichaAdultoMayor;
import entities.adultoMayor.IngresoPSAM;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface IngresoPSAMFacadeLocal {

    void create(IngresoPSAM ingresoPSAM);

    void edit(IngresoPSAM ingresoPSAM);

    void remove(IngresoPSAM ingresoPSAM);

    IngresoPSAM find(Object id);

    List<IngresoPSAM> findAll();

    List<IngresoPSAM> findRange(int[] range);

    int count();
    
    public void crearFichaPSAM(CartolaSeguimientoPSAM cartola, FichaAdultoMayor ficha, 
            EsferaClinicaPSAM esferaCli, EsferaFuncionalPSAM esferaFun, 
            EsferaMentalPSAM esferaMen, EsferaSocialPSAM esferaSo,
            IngresoPSAM ingPSAM);
        
    
}
