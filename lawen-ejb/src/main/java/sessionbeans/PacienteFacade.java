/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Paciente;
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
public class PacienteFacade extends AbstractFacade<Paciente> implements PacienteFacadeLocal {
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
    
    
    public PacienteFacade() {
        super(Paciente.class);
    }

    @Override
    public List<Paciente> findbyPacienteActivo() {
        Query query;
        query = em.createNamedQuery("Paciente.findByEstado")
                .setParameter("estado", "Activo");
        return query.getResultList();  
                
    }
    
    
    @Override
    public List<Paciente> findbyPacientePasivoFallecimiento() {
        Query query;
        query = em.createNamedQuery("Paciente.findByEstado")
                .setParameter("estado", "Pasivo por fallecimiento");
        return query.getResultList();  
                
    }
    
    @Override
    public List<Paciente> findbyPacientePasivoTraslado() {
        Query query;
        query = em.createNamedQuery("Paciente.findByEstado")
                .setParameter("estado", "Pasivo por traslado");
        return query.getResultList();  
                
    }
    
    @Override
    public List<Paciente> findbyPacientePasivoPrevision() {
        Query query;
        query = em.createNamedQuery("Paciente.findByEstado")
                .setParameter("estado", "Pasivo por cambio de prevision");
        return query.getResultList();  
                
    }
    
    
    @Override
    public Paciente findByPacienteId(long id) {
        Query query;
        query = em.createNamedQuery("Paciente.findByPacienteId")
                .setParameter("id", id);
        
        return (Paciente) query.getSingleResult();  
                
    }
    
    
    @Override
    public List<Paciente> findbyPacienteRut(String rut) {
        Query query;
        query = em.createNamedQuery("Paciente.findByPacienteRut")
                .setParameter("rut_paciente", rut);
        return query.getResultList();  
                
    }

    @Override
    public List<Paciente> findByGenero(String genero) {
        Query query;
        query = em.createNamedQuery("Paciente.findbyGenero")
                .setParameter("genero_paciente", genero);
        return query.getResultList();
    }

   

}
