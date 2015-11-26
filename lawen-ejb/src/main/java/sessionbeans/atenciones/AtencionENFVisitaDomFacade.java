/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.atenciones;

import entities.atenciones.AtencionENFVisitaDom;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
public class AtencionENFVisitaDomFacade extends AbstractFacade<AtencionENFVisitaDom> implements AtencionENFVisitaDomFacadeLocal {
    @PersistenceContext(unitName = "pingeso_lawen-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public AtencionENFVisitaDomFacade() {
        super(AtencionENFVisitaDom.class);
    }
    
}
