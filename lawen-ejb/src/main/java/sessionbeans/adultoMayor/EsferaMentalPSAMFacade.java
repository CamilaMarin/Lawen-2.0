/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.adultoMayor;

import entities.adultoMayor.EsferaMentalPSAM;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
public class EsferaMentalPSAMFacade extends AbstractFacade<EsferaMentalPSAM> implements EsferaMentalPSAMFacadeLocal {
    @PersistenceContext(unitName = "pingeso_lawen-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    
    public EsferaMentalPSAMFacade() {
        super(EsferaMentalPSAM.class);
    }
    
}
