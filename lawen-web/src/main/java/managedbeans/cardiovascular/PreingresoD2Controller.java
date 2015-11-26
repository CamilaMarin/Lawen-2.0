package managedbeans.cardiovascular;

import entities.Paciente;
import entities.cardiovascular.PreingresoD2;
import managedbeans.cardiovascular.util.JsfUtil;
import managedbeans.cardiovascular.util.JsfUtil.PersistAction;
import sessionbeans.cardiovascular.PreingresoD2FacadeLocal;

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

@Named("preingresoD2Controller")
@SessionScoped
public class PreingresoD2Controller implements Serializable {

    @EJB
    private PreingresoD2FacadeLocal ejbFacade;
    private List<PreingresoD2> items = null;
    private PreingresoD2 selected;
    private List<PreingresoD2> allitems =null;
    public PreingresoD2Controller() {
    }

    public PreingresoD2 getSelected() {
        return selected;
    }

    public void setSelected(PreingresoD2 selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PreingresoD2FacadeLocal getFacade() {
        return ejbFacade;
    }

    public PreingresoD2 prepareCreate() {
        selected = new PreingresoD2();
        initializeEmbeddableKey();
        return selected;
    }

    public String create(Paciente paciente) {
        selected.setPacientes(paciente);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PreingresoD2Created"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("", new FacesMessage("Se el cedazo con exito."));
        return "/faces/paciente/PacienteToCCV.xhtml?faces-redirect=true";
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PreingresoD2Updated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PreingresoD2Deleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PreingresoD2> getItems() {
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

    public PreingresoD2 getPreingresoD2(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<PreingresoD2> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PreingresoD2> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PreingresoD2.class)
    public static class PreingresoD2ControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PreingresoD2Controller controller = (PreingresoD2Controller) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "preingresoD2Controller");
            return controller.getPreingresoD2(getKey(value));
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
            if (object instanceof PreingresoD2) {
                PreingresoD2 o = (PreingresoD2) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PreingresoD2.class.getName()});
                return null;
            }
        }

    }
     /***
     * Consulto todos los datos de Preingreso y lo guarda en una lista
     * @return 
     */
    
    public List<PreingresoD2> getAllItems(){
    allitems = getFacade().findAll();
    if(allitems==null){
        allitems= new ArrayList<PreingresoD2>();
    }
    return allitems;
    }
     /**
     * 
     * @param rut 
     * @return objeto preingresod1
     * Funcion que busca dentro de todos los items de preingreso el valor que es igual al rut de entrada
     * 
     */
    public PreingresoD2 getObjetobyRut(String rut){
        getAllItems();
        for(PreingresoD2 item: allitems){//para cada item de Preingreso de la bd
            if(rut.equals(item.getPacientes().getRut_paciente())){//si el objeto a comparar es igual al rut de entrada
                setSelected(item);
                return selected;
            }
        }
        return null;
    }
    
    

}
