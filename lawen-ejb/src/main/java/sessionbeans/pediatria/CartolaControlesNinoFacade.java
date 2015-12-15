/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.pediatria;

import entities.pediatria.CartolaControlesNino;
import entities.pediatria.PacienteNino;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Francisco Avello
 */
@Stateless
public class CartolaControlesNinoFacade extends AbstractFacade<CartolaControlesNino> implements CartolaControlesNinoFacadeLocal {

    @PersistenceContext(unitName = "pingeso_lawen-ejb_ejb_1.0PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CartolaControlesNinoFacade() {
        super(CartolaControlesNino.class);
    }
    
    @Override
    public void crearCartola(PacienteNino nino, CartolaControlesNino cartolaControl) {
        
        cartolaControl.setPacienteNino(nino);     
       
        persist(cartolaControl);
        
    }
    
}
