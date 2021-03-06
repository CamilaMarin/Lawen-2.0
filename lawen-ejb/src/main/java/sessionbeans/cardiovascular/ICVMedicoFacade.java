/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.cardiovascular;


import entities.cardiovascular.CartolaSeguimientoCCV;
import entities.cardiovascular.FichaMedico;
import entities.cardiovascular.ICVMedico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matias
 */
@Stateless
public class ICVMedicoFacade extends AbstractFacade<ICVMedico> implements ICVMedicoFacadeLocal {
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
     * Persiste objeto 
     * @param object 
     */
    public void persist(Object object) {
        em.persist(object);
    }
    
        /**
     * Super: obtener subclass
     */
    public ICVMedicoFacade() {
        super(ICVMedico.class);
    }
    
    /***
     * @param cartola
     * @param ficha
     * @param enf
     * Permite la persistencia en CartolaSeguimientoCCV,FichaMedico,ICVMedico
     * Guarda los elementos selected en la base de datos
     * Permite que se conecten los elementos de ficha y el CCV con la cartola de seguimiento
     */
    @Override
    public void realizarPago(CartolaSeguimientoCCV cartola, FichaMedico ficha, ICVMedico med) {
        
        
        persist(cartola);
        persist(ficha);
        
        med.setCartola(cartola);
        med.setFechaAtencionMed(cartola.getFecha_control());
        med.setFichaMed(ficha);
       
        persist(med);

    }
    
    
    
}
