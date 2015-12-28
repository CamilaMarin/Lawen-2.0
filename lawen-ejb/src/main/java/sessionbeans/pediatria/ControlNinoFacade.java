/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.pediatria;

import entities.pediatria.CartolaControlesNino;
import entities.pediatria.ControlNino;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Francisco Avello
 */
@Stateless
public class ControlNinoFacade extends AbstractFacade<ControlNino> implements ControlNinoFacadeLocal {

    @PersistenceContext(unitName = "pingeso_lawen-ejb_ejb_1.0PU")
    private EntityManager em;
    
     public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ControlNinoFacade() {
        super(ControlNino.class);
    }
    
    @Override
    public List<ControlNino> findbyCartola(long id) {
        Query query;
        query = em.createNamedQuery("ControlNino.findbyCartola")
                .setParameter("cartola_id", id);
        return query.getResultList(); 
                
    }
    
    @Override
    public List<ControlNino> findLastControl(List<ControlNino> controles) {
        Query query;
        query = em.createNamedQuery("ControlNino.findLastControl");
        return query.getResultList();                
    }
    
}
