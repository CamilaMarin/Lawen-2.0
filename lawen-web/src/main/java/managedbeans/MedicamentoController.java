package managedbeans;

import entities.Medicamentos;
import managedbeans.util.JsfUtil;
import managedbeans.util.JsfUtil.PersistAction;
import sessionbeans.MedicamentoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("MedicamentoController")
@SessionScoped
public class MedicamentoController implements Serializable {

    @EJB
    private MedicamentoFacadeLocal ejbFacade;
    private List<Medicamentos> items = null;
    private Medicamentos selected;
    private List<Medicamentos> allitems = null;

    public MedicamentoController() {
    }

    public Medicamentos getSelected() {
        return selected;
    }

    public void setSelected(Medicamentos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private MedicamentoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Medicamentos prepareCreate() {
        selected = new Medicamentos();
        initializeEmbeddableKey();
        return selected;
    }


    public void create() {

        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MedicamentoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MedicamentoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MedicamentoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Medicamentos> getItems() {

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

    public Medicamentos getMedicamentos(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Medicamentos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }
    /*Solo quiero los que no esten habilitados*/


    public List<Medicamentos> getAllItems() {
        allitems = getFacade().findAll();
        if (allitems == null) {
            allitems = new ArrayList<>();
        }
        return allitems;
    }



    @FacesConverter(forClass = Medicamentos.class)
    public static class MedicamentoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MedicamentoController controller = (MedicamentoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "medicamentoController");
            return controller.getMedicamentos(getKey(value));
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
            if (object instanceof Medicamentos) {
                Medicamentos o = (Medicamentos) object;
                return getStringKey(o.getIdMedicamento());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Medicamentos.class.getName()});
                return null;
            }
        }

    }

}
