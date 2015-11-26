package sessionbeans.adultoMayor;

import entities.Paciente;
import entities.adultoMayor.CartolaSeguimientoPSAM;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author matias
 */
@Stateless
public class CartolaSeguimientoPSAMFacade extends AbstractFacade<CartolaSeguimientoPSAM> implements CartolaSeguimientoPSAMFacadeLocal {
    @PersistenceContext(unitName = "pingeso_lawen-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    
    public CartolaSeguimientoPSAMFacade() {
        super(CartolaSeguimientoPSAM.class);
    }
    
    
    /**
     * Encuentra las cartolas de los pacientes
     * @param paciente
     * @return 
     */
    @Override
    public List<CartolaSeguimientoPSAM> findByPaciente(Paciente paciente) {
        Query query;
        query = em.createNamedQuery("CartolaSeguimientoPSAM.findbyPaciente")
                .setParameter("paciente", paciente);
        return query.getResultList();
    }
    
}
