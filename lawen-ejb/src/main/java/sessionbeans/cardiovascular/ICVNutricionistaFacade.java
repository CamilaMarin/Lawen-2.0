/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.CartolaSeguimientoCCV;
import entities.cardiovascular.FichaNutricionista;
import entities.cardiovascular.ICVNutricionista;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matias
 */
@Stateless
public class ICVNutricionistaFacade extends AbstractFacade<ICVNutricionista> implements ICVNutricionistaFacadeLocal {
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
    public ICVNutricionistaFacade() {
        super(ICVNutricionista.class);
    }
    
    /**
     * Persiste objeto 
     * @param object 
     */
    public void persist(Object object) {
        em.persist(object);
    }
    
      /***
     * @param cartola
     * @param ficha
     * @param nutri
     * @param enf
     * Permite la persistencia en CartolaSeguimientoCCV,FichaNutricionista,ICVNutricionista
     * Guarda los elementos selected en la base de datos
     * Permite que se conecten los elementos de ficha y el CCV con la cartola de seguimiento
     */
        @Override
    public void realizarPago(CartolaSeguimientoCCV cartola, FichaNutricionista ficha, ICVNutricionista nutri) {
        
        
        persist(cartola);
        persist(ficha);
        
        nutri.setCartolaToNutri(cartola);
        nutri.setFechaAtencionNutri(cartola.getFecha_control());
        nutri.setFichaNutri(ficha);
        persist(nutri);

    }
    
    
}
