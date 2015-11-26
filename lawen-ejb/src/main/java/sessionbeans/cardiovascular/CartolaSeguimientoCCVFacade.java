/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;

import entities.Paciente;
import entities.cardiovascular.CartolaSeguimientoCCV;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author daniel
 */
@Stateless
public class CartolaSeguimientoCCVFacade extends AbstractFacade<CartolaSeguimientoCCV> implements CartolaSeguimientoCCVFacadeLocal {
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
    public CartolaSeguimientoCCVFacade() {
        super(CartolaSeguimientoCCV.class);
    }
    

    @Override
    public List<CartolaSeguimientoCCV> findByPaciente(Paciente paciente) {
        Query query;
        query = em.createNamedQuery("CartolaSeguimientoCCV.findbyPaciente")
                .setParameter("paciente", paciente);
        return query.getResultList();
    }
    
    
    
    
    
}
