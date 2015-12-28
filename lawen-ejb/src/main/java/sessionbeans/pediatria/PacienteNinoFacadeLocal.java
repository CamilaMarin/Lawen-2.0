/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.pediatria;

import entities.pediatria.PacienteNino;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Francisco Avello
 */
@Local
public interface PacienteNinoFacadeLocal {

    void create(PacienteNino pacienteNino);

    void edit(PacienteNino pacienteNino);

    void remove(PacienteNino pacienteNino);

    PacienteNino find(Object id);

    List<PacienteNino> findAll();

    List<PacienteNino> findRange(int[] range);

    int count();
    
    List<PacienteNino> findbyPacienteNinoActivo();    
}
