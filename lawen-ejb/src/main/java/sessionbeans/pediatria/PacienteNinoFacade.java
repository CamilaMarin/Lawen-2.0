/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.pediatria;

import entities.pediatria.PacienteNino;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Francisco Avello
 */
@Stateless
public class PacienteNinoFacade extends AbstractFacade<PacienteNino> implements PacienteNinoFacadeLocal {

    @PersistenceContext(unitName = "pingeso_lawen-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacienteNinoFacade() {
        super(PacienteNino.class);
    }
    
}
