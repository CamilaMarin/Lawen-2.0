/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.pediatria;

import entities.pediatria.CartolaControlesNino;
import entities.pediatria.PacienteNino;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Francisco Avello
 */
@Local
public interface CartolaControlesNinoFacadeLocal {

    void create(CartolaControlesNino cartolaControlesNino);

    void edit(CartolaControlesNino cartolaControlesNino);

    void remove(CartolaControlesNino cartolaControlesNino);

    CartolaControlesNino find(Object id);

    List<CartolaControlesNino> findAll();

    List<CartolaControlesNino> findRange(int[] range);

    int count();
       
    public void crearCartola(PacienteNino nino, CartolaControlesNino cartolaControl);

}
