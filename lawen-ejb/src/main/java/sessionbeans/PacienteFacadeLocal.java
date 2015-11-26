/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Paciente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface PacienteFacadeLocal {

    void create(Paciente paciente);

    void edit(Paciente paciente);

    void remove(Paciente paciente);

    Paciente find(Object id);

    List<Paciente> findAll();

    List<Paciente> findRange(int[] range);

    int count();
    


    List<Paciente> findbyPacienteActivo();
    List<Paciente> findbyPacientePasivoFallecimiento();
    List<Paciente> findbyPacientePasivoTraslado();
    List<Paciente> findbyPacientePasivoPrevision();
    List<Paciente> findbyPacienteRut(String rut);
    
    Paciente findByPacienteId(long id);

    List<Paciente> findByGenero(String genero);

}
