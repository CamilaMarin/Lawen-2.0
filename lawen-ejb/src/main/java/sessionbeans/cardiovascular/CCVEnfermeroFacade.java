/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.CCVEnfermero;
import entities.cardiovascular.CartolaSeguimientoCCV;
import entities.cardiovascular.FichaEnfermero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
public class CCVEnfermeroFacade extends AbstractFacade<CCVEnfermero> implements CCVEnfermeroFacadeLocal {
    @PersistenceContext(unitName = "pingeso_lawen-ejb_ejb_1.0PU")
    private EntityManager em;
    /**
     * Persiste objeto 
     * @param object 
     */
    public void persist(Object object) {
        em.persist(object);
    }
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
    public CCVEnfermeroFacade() {
        super(CCVEnfermero.class);
    }
    @Override
    /***
     * @param cartola
     * @param ficha
     * @param enf
     * Permite la persistencia en CartolaSeguimientoCCV,FichaEnfermero,CCVEnfermero
     * Guarda los elementos selected en la base de datos
     * Permite que se conecten los elementos de ficha y el CCV con la cartola de seguimiento
     */
    public void crearFicha(CartolaSeguimientoCCV cartola, FichaEnfermero ficha, CCVEnfermero enf) {
        
        
        persist(cartola);
        persist(ficha);
        
        enf.setCartolaToEnf(cartola);
        enf.setFechaAtencionEnf(cartola.getFecha_control());
        enf.setFichaEnf(ficha);
        persist(enf);
    }
    
}
