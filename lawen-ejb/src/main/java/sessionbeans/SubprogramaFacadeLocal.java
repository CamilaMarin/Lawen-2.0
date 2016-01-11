/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Paciente;
import entities.Subprograma;
import entities.TipoSubprograma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Francisco Avello
 */
@Local
public interface SubprogramaFacadeLocal {

    void create(Subprograma subprograma);

    void edit(Subprograma subprograma);

    void remove(Subprograma subprograma);

    Subprograma find(Object id);

    List<Subprograma> findAll();

    List<Subprograma> findRange(int[] range);

    int count();
    
    List<Subprograma> findbyPaciente(Paciente paciente);
    
}
