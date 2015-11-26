/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.FichaMedico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface FichaMedicoFacadeLocal {

    void create(FichaMedico fichaMedico);

    void edit(FichaMedico fichaMedico);

    void remove(FichaMedico fichaMedico);

    FichaMedico find(Object id);

    List<FichaMedico> findAll();

    List<FichaMedico> findRange(int[] range);

    int count();
    
}
