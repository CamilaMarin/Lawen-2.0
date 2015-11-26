package managedbeans.adultoMayor;

import entities.adultoMayor.EsferaFuncionalPSAM;
import managedbeans.adultoMayor.util.JsfUtil;
import managedbeans.adultoMayor.util.JsfUtil.PersistAction;
import sessionbeans.adultoMayor.EsferaFuncionalPSAMFacadeLocal;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("esferaFuncionalPSAMController")
@SessionScoped
public class EsferaFuncionalPSAMController implements Serializable {

    @EJB
    private EsferaFuncionalPSAMFacadeLocal ejbFacade;
    private List<EsferaFuncionalPSAM> items = null;
    private EsferaFuncionalPSAM selected;

    public EsferaFuncionalPSAMController() {
    }

    public EsferaFuncionalPSAM getSelected() {
        return selected;
    }

    public void setSelected(EsferaFuncionalPSAM selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EsferaFuncionalPSAMFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EsferaFuncionalPSAM prepareCreate() {
        selected = new EsferaFuncionalPSAM();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EsferaFuncionalPSAMCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EsferaFuncionalPSAMUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EsferaFuncionalPSAMDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EsferaFuncionalPSAM> getItems() {
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

    public EsferaFuncionalPSAM getEsferaFuncionalPSAM(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<EsferaFuncionalPSAM> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EsferaFuncionalPSAM> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EsferaFuncionalPSAM.class)
    public static class EsferaFuncionalPSAMControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EsferaFuncionalPSAMController controller = (EsferaFuncionalPSAMController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "esferaFuncionalPSAMController");
            return controller.getEsferaFuncionalPSAM(getKey(value));
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
            if (object instanceof EsferaFuncionalPSAM) {
                EsferaFuncionalPSAM o = (EsferaFuncionalPSAM) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EsferaFuncionalPSAM.class.getName()});
                return null;
            }
        }

    }

}
