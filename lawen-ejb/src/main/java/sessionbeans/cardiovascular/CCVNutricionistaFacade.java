/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.cardiovascular.CCVNutricionista;
import entities.cardiovascular.CartolaSeguimientoCCV;
import entities.cardiovascular.FichaNutricionista;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
public class CCVNutricionistaFacade extends AbstractFacade<CCVNutricionista> implements CCVNutricionistaFacadeLocal {
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
    public CCVNutricionistaFacade() {
        super(CCVNutricionista.class);
    }
       /***
     * @param cartola
     * @param ficha
     * @param nutri
     * Permite la persistencia en CartolaSeguimientoCCV,FichaEnfermero,CCVNutricionista
     * Guarda los elementos selected en la base de datos
     * Permite que se conecten los elementos de ficha y el CCV con la cartola de seguimiento
     */
    @Override
    public void crearFicha(CartolaSeguimientoCCV cartola, FichaNutricionista ficha, CCVNutricionista nutri) {
        
        
        persist(cartola);
        persist(ficha);
        
        nutri.setCartolaToNutri(cartola);
        nutri.setFechaAtencionNutri(cartola.getFecha_control());
        nutri.setFichaNutri(ficha);
       
        
       
        persist(nutri);
        
    }
    
    
    
}
