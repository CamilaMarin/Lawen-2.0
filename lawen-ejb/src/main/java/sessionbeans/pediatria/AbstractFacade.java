/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.pediatria;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Francisco Avello
 * @param <T>
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();
/**
 *  Hace la persistencia al objeto de una entidad para crearlo
 * @param entity 
 */
    public void create(T entity) {
        getEntityManager().persist(entity);
    }
/**
 *  Hace la persistencia al objeto de una entidad para crearlo
 * @param entity 
 */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }
/**
 *  Hace la persistencia al objeto de una entidad para crearlo
 * @param entity 
 */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
/**
 * Busca objeto por id
 * @param id
 * @return objeto por id
 */
    
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
/**
 * Equivalente a un between en SQL
 * @param range
 * @return lista de objetos que cumple el criterio
 */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
/**
 *  Equivalente a un COUNT en sql
 * @return entero con la cantidad segun criterio
 */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
