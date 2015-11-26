/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.PreingresoD1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matias
 */
@Stateless
public class PreingresoD1Facade extends AbstractFacade<PreingresoD1> implements PreingresoD1FacadeLocal {
    @PersistenceContext(unitName = "pingeso_lawen-ejb_ejb_1.0PU")
    private EntityManager em;
   /**
     * Retorna el entity manager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    /**
     * Super: obtener subclass
     */
    public PreingresoD1Facade() {
        super(PreingresoD1.class);
    }
    
}
