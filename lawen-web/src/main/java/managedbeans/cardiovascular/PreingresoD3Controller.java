package managedbeans.cardiovascular;

import entities.Paciente;
import entities.cardiovascular.PreingresoD3;
import managedbeans.cardiovascular.util.JsfUtil;
import managedbeans.cardiovascular.util.JsfUtil.PersistAction;
import sessionbeans.cardiovascular.PreingresoD3FacadeLocal;

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

@Named("preingresoD3Controller")
@SessionScoped
public class PreingresoD3Controller implements Serializable {

    @EJB
    private PreingresoD3FacadeLocal ejbFacade;
    private List<PreingresoD3> items = null;
    private PreingresoD3 selected;
    private List<PreingresoD3> allitems =null;
    public PreingresoD3Controller() {
    }

    public PreingresoD3 getSelected() {
        return selected;
    }

    public void setSelected(PreingresoD3 selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PreingresoD3FacadeLocal getFacade() {
        return ejbFacade;
    }

    public PreingresoD3 prepareCreate() {
        selected = new PreingresoD3();
        initializeEmbeddableKey();
        return selected;
    }

    public String create(Paciente paciente) {
        selected.setPacientes(paciente);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PreingresoD3Created"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("", new FacesMessage("Se el cedazo con exito."));
        return "/faces/paciente/PacienteToCCV.xhtml?faces-redirect=true";
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PreingresoD3Updated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PreingresoD3Deleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PreingresoD3> getItems() {
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

    public PreingresoD3 getPreingresoD3(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<PreingresoD3> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PreingresoD3> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PreingresoD3.class)
    public static class PreingresoD3ControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PreingresoD3Controller controller = (PreingresoD3Controller) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "preingresoD3Controller");
            return controller.getPreingresoD3(getKey(value));
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
            if (object instanceof PreingresoD3) {
                PreingresoD3 o = (PreingresoD3) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PreingresoD3.class.getName()});
                return null;
            }
        }

    }

     /***
     * Consulto todos los datos de Preingreso y lo guarda en una lista
     * @return 
     */
       public List<PreingresoD3> getAllItems(){
    allitems = getFacade().findAll();
    if(allitems==null){
        allitems= new ArrayList<PreingresoD3>();
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
    public PreingresoD3 getObjetobyRut(String rut){
        getAllItems();
        for(PreingresoD3 item: allitems){//para cada item de Preingreso de la bd
            if(rut.equals(item.getPacientes().getRut_paciente())){//si el objeto a comparar es igual al rut de entrada
                setSelected(item);
                return selected;
            }
        }
        return null;
    }
    
    
    
    
    
    
}
