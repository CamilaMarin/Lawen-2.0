/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.MedicamentosCartola;
import entities.cardiovascular.CartolaSeguimientoCCV;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Beban
 */
@Stateless
public class MedicamentosCartolaFacade extends AbstractFacade<MedicamentosCartola> implements MedicamentosCartolaFacadeLocal {

    @PersistenceContext(unitName = "pingeso_lawen-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
     public void setEm(EntityManager em) {
        this.em = em;
    }   

    public MedicamentosCartolaFacade() {
        super(MedicamentosCartola.class);
    }
    
    @Override
    public List<MedicamentosCartola> findbyCartola(CartolaSeguimientoCCV cartola) {
        Query query;
        query = em.createNamedQuery("MedicamentosCartola.findbyCartola")
                .setParameter("cartola", cartola);
        return query.getResultList();                  
    }   
    
}
