/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.CCVMedico;
import entities.cardiovascular.CartolaSeguimientoCCV;
import entities.cardiovascular.FichaMedico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface CCVMedicoFacadeLocal {

    void create(CCVMedico cCVMedico);

    void edit(CCVMedico cCVMedico);

    void remove(CCVMedico cCVMedico);

    CCVMedico find(Object id);

    List<CCVMedico> findAll();

    List<CCVMedico> findRange(int[] range);

    int count();
    
    public void realizarPago(CartolaSeguimientoCCV cartola, FichaMedico ficha, CCVMedico med);
    
}
