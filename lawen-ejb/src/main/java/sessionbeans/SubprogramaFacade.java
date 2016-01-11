/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Paciente;
import entities.Subprograma;
import entities.TipoSubprograma;
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
public class SubprogramaFacade extends AbstractFacade<Subprograma> implements SubprogramaFacadeLocal {

    @PersistenceContext(unitName = "pingeso_lawen-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void setEm(EntityManager em) {
        this.em = em;
    }       

    public SubprogramaFacade() {
        super(Subprograma.class);
    }
    
    @Override
    public List<Subprograma> findbyPaciente(Paciente paciente) {
        Query query;
        query = em.createNamedQuery("Subprograma.findbyPaciente")
                .setParameter("paciente", paciente);
        return query.getResultList();                  
    }   
}
