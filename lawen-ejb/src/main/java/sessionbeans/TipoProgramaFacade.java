/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.TipoPrograma;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
public class TipoProgramaFacade extends AbstractFacade<TipoPrograma> implements TipoProgramaFacadeLocal {
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
    
     /**
     * Super: obtener subclass
     */
    public TipoProgramaFacade() {
        super(TipoPrograma.class);
    }
    
}
