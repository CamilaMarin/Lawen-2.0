/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.adultoMayor;

import entities.adultoMayor.CartolaSeguimientoPSAM;
import entities.adultoMayor.EsferaClinicaPSAM;
import entities.adultoMayor.EsferaFuncionalPSAM;
import entities.adultoMayor.EsferaMentalPSAM;
import entities.adultoMayor.EsferaSocialPSAM;
import entities.adultoMayor.FichaAdultoMayor;
import entities.adultoMayor.IngresoPSAM;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
public class IngresoPSAMFacade extends AbstractFacade<IngresoPSAM> implements IngresoPSAMFacadeLocal {
    @PersistenceContext(unitName = "pingeso_lawen-ejb_ejb_1.0PU")
    private EntityManager em;
    /**
     * Persiste objeto 
     * @param object 
     */
    public void persist(Object object) {
        em.persist(object);
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
      /**
     * Retorna el entity manager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresoPSAMFacade() {
        super(IngresoPSAM.class);
    }
    
    @Override
    /***
     * @param cartola
     * @param ficha
     * @param esferaCli
     * @param esferaFun
     * @param esferaMen
     * @param esferaSo
     * @param ingPSAM
     * Permite la persistencia en IngresoPSAM
     * Guarda los elementos selected en la base de datos
     * Permite que se conecten los elementos de ficha y el PSAM con la cartola de seguimiento
     */
    public void crearFichaPSAM(CartolaSeguimientoPSAM cartola, FichaAdultoMayor ficha, 
            EsferaClinicaPSAM esferaCli, EsferaFuncionalPSAM esferaFun, 
            EsferaMentalPSAM esferaMen, EsferaSocialPSAM esferaSo,
            IngresoPSAM ingPSAM) {
        
        
            persist(cartola);
            persist(esferaCli);
            persist(esferaFun);
            persist(esferaMen);
            persist(esferaSo);


            ficha.setEsferaCli(esferaCli);
            ficha.setEsferaFu(esferaFun);
            ficha.setEsferaMen(esferaMen);
            ficha.setEsferaSo(esferaSo);
            persist(ficha);
            ingPSAM.setCartolaPSAM(cartola);
            ingPSAM.setFichaAdultoMayor(ficha);
            persist(ingPSAM);
    }
    
}
