/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.CartolaSeguimientoCCV;
import entities.cardiovascular.FichaMedico;
import entities.cardiovascular.ICVMedico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author matias
 */
@Local
public interface ICVMedicoFacadeLocal {

    void create(ICVMedico iCVMedico);

    void edit(ICVMedico iCVMedico);

    void remove(ICVMedico iCVMedico);

    ICVMedico find(Object id);

    List<ICVMedico> findAll();

    List<ICVMedico> findRange(int[] range);

    int count();
    
    public void realizarPago(CartolaSeguimientoCCV cartola, FichaMedico ficha, ICVMedico med);
}
