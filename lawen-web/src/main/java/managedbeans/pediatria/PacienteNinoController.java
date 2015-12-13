package managedbeans.pediatria;

import entities.pediatria.PacienteNino;
import managedbeans.pediatria.util.JsfUtil;
import managedbeans.pediatria.util.JsfUtil.PersistAction;
import sessionbeans.pediatria.PacienteNinoFacadeLocal;

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

@Named("pacienteNinoController")
@SessionScoped
public class PacienteNinoController implements Serializable {

    @EJB
    private PacienteNinoFacadeLocal ejbFacade;
    private List<PacienteNino> items = null;
    private PacienteNino selected;

    public PacienteNinoController() {
    }

    public PacienteNino getSelected() {
        return selected;
    }

    public void setSelected(PacienteNino selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PacienteNinoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public PacienteNino prepareCreate() {
        selected = new PacienteNino();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        String rut = selected.getRut_nino();
        rut = rut.toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");

        rut = rut.substring(0, rut.length() - 1) + "-" + rut.substring(rut.length() - 1, rut.length());
        selected.setEstado_paciente_nino("Activo");
        selected.setRut_nino(rut);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PacienteNinoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PacienteNinoUpdated"));
        selected = null;
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PacienteNinoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PacienteNino> getItems() {
        items = getFacade().findAll();
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
                    msg = "Ha ocurrido un error procesando su solicitud.\n Rut repetidos";
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

    public PacienteNino getPacienteNino(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<PacienteNino> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PacienteNino> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PacienteNino.class)
    public static class PacienteNinoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PacienteNinoController controller = (PacienteNinoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pacienteNinoController");
            return controller.getPacienteNino(getKey(value));
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
            if (object instanceof PacienteNino) {
                PacienteNino o = (PacienteNino) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PacienteNino.class.getName()});
                return null;
            }
        }

    }

}
