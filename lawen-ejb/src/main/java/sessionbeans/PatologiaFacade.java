/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Patologia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
public class PatologiaFacade extends AbstractFacade<Patologia> implements PatologiaFacadeLocal {
    @PersistenceContext(unitName = "pingeso_lawen-ejb_ejb_1.0PU")
    
    private EntityManager em;

    @Override
     /**
     * Retorna el entity manager
     */
    protected EntityManager getEntityManager() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
    public PatologiaFacade() {
        super(Patologia.class);
    }
    
}
