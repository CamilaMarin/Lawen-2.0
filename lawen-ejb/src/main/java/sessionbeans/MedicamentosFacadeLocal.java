/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Medicamentos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Beban
 */
@Local
public interface MedicamentosFacadeLocal {

    void create(Medicamentos medicamentos);

    void edit(Medicamentos medicamentos);

    void remove(Medicamentos medicamentos);

    Medicamentos find(Object id);

    List<Medicamentos> findAll();

    List<Medicamentos> findRange(int[] range);

    int count();
    
}
