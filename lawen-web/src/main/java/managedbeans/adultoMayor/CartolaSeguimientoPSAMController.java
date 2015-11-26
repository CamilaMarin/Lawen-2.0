package managedbeans.adultoMayor;

import managedbeans.adultoMayor.censo.CensoSeccionA;
import entities.adultoMayor.CartolaSeguimientoPSAM;
import managedbeans.adultoMayor.util.JsfUtil;
import managedbeans.adultoMayor.util.JsfUtil.PersistAction;
import sessionbeans.adultoMayor.CartolaSeguimientoPSAMFacadeLocal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.inject.Inject;
import managedbeans.PacienteController;

@Named("cartolaSeguimientoPSAMController")
@SessionScoped
public class CartolaSeguimientoPSAMController implements Serializable {

    @EJB
    private CartolaSeguimientoPSAMFacadeLocal ejbFacade;
    private List<CartolaSeguimientoPSAM> items = null;
    private CartolaSeguimientoPSAM selected;
    @Inject
    private PacienteController pacientecontroller;
    private int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void handleKeyEvent() {

        try {

            if (getSelected().getPaciente().getFechaNacimiento_paciente() == null) {

                edad = 0;
            } else {
                Date date = getSelected().getPaciente().getFechaNacimiento_paciente();
                edad = pacientecontroller.Age(date);
                if (edad < 0) {
                    edad = 0;
                }

            }
        } catch (Exception e) {

            edad = 0;
        }

    }

    public CartolaSeguimientoPSAMController() {
    }

    public CartolaSeguimientoPSAM getSelected() {
        return selected;
    }

    public void setSelected(CartolaSeguimientoPSAM selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CartolaSeguimientoPSAMFacadeLocal getFacade() {
        return ejbFacade;
    }

    public CartolaSeguimientoPSAM prepareCreate() {
        selected = new CartolaSeguimientoPSAM();
        initializeEmbeddableKey();
        return selected;
    }

    public void create(int edad) {
        selected.setEdad(edad);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CartolaSeguimientoPSAMCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        selected = null;
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CartolaSeguimientoPSAMUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CartolaSeguimientoPSAMDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CartolaSeguimientoPSAM> getItems() {
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

    public CartolaSeguimientoPSAM getCartolaSeguimientoPSAM(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<CartolaSeguimientoPSAM> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CartolaSeguimientoPSAM> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CartolaSeguimientoPSAM.class)
    public static class CartolaSeguimientoPSAMControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CartolaSeguimientoPSAMController controller = (CartolaSeguimientoPSAMController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cartolaSeguimientoPSAMController");
            return controller.getCartolaSeguimientoPSAM(getKey(value));
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
            if (object instanceof CartolaSeguimientoPSAM) {
                CartolaSeguimientoPSAM o = (CartolaSeguimientoPSAM) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CartolaSeguimientoPSAM.class.getName()});
                return null;
            }
        }

    }

}
