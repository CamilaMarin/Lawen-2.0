/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.MedicamentosCartola;
import entities.cardiovascular.CartolaSeguimientoCCV;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Beban
 */
@Local
public interface MedicamentosCartolaFacadeLocal {

    void create(MedicamentosCartola medicamentosCartola);

    void edit(MedicamentosCartola medicamentosCartola);

    void remove(MedicamentosCartola medicamentosCartola);

    MedicamentosCartola find(Object id);

    List<MedicamentosCartola> findAll();

    List<MedicamentosCartola> findRange(int[] range);

    int count();
    List<MedicamentosCartola> findbyCartola(CartolaSeguimientoCCV cartola);
    
}
