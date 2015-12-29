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
public interface MedicamentoFacadeLocal {

    void create(Medicamentos medicamento);

    void edit(Medicamentos medicamento);

    void remove(Medicamentos medicamento);

    Medicamentos find(Object id);

    List<Medicamentos> findAll();

    
}
