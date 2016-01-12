/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.subprogramas;

import entities.subprogramas.TarjetaIdentificacionIRA;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import sessionbeans.subprogramas.TarjetaIdentificacionIRAFacadeLocal;

import managedbeans.subprogramas.util.JsfUtil;
import managedbeans.subprogramas.util.JsfUtil.PersistAction;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Francisco Avello
 */
@Named(value = "tarjetaIdentificacionIRAController")
@SessionScoped
public class TarjetaIdentificacionIRAController implements Serializable {

    @EJB
    private TarjetaIdentificacionIRAFacadeLocal ejbFacade;
    private List<TarjetaIdentificacionIRA> items = null;
    private TarjetaIdentificacionIRA selected;

    public TarjetaIdentificacionIRAController() {
    }

    public TarjetaIdentificacionIRA getSelected() {
        return selected;
    }

    public void setSelected(TarjetaIdentificacionIRA selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TarjetaIdentificacionIRAFacadeLocal getFacade() {
        return ejbFacade;
    }

    public TarjetaIdentificacionIRA prepareCreate() {
        selected = new TarjetaIdentificacionIRA();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TarjetaIdentificacionIRACreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TarjetaIdentificacionIRAUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TarjetaIdentificacionIRADeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TarjetaIdentificacionIRA> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public TarjetaIdentificacionIRA getTarjetaIdentificacionIRA(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<TarjetaIdentificacionIRA> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TarjetaIdentificacionIRA> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TarjetaIdentificacionIRA.class)
    public static class TarjetaIdentificacionIRAControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TarjetaIdentificacionIRAController controller = (TarjetaIdentificacionIRAController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tarjetaIdentificacionIRAController");
            return controller.getTarjetaIdentificacionIRA(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TarjetaIdentificacionIRA) {
                TarjetaIdentificacionIRA o = (TarjetaIdentificacionIRA) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TarjetaIdentificacionIRA.class.getName()});
                return null;
            }
        }

    }

}

