/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.TipoUsuario;
import entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matias
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
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
    
    
    public void persist(Object object) {
        em.persist(object);
    }
    /**
     * Super: obtener subclass
     */
    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public void CrearUsuario(Usuario usuario,TipoUsuario tipo) {
        tipo.setRut(usuario.getRut());
        persist(tipo);
        usuario.setTipousuario(tipo);
        persist(usuario);
        
    }
    
    
}
