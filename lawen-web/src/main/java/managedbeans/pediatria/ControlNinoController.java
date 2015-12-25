package managedbeans.pediatria;

import entities.pediatria.CartolaControlesNino;
import entities.pediatria.ControlNino;
import entities.pediatria.PacienteNino;
import managedbeans.pediatria.util.JsfUtil;
import managedbeans.pediatria.util.JsfUtil.PersistAction;
import sessionbeans.pediatria.ControlNinoFacadeLocal;

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

@Named("controlNinoController")
@SessionScoped
public class ControlNinoController implements Serializable {

    @EJB
    private ControlNinoFacadeLocal ejbFacade;
    private List<ControlNino> items = null;
    private ControlNino selected;
    private List<ControlNino> allitems =null;
    
    public ControlNinoController() {
    }

    public ControlNino getSelected() {
        return selected;
    }

    public void setSelected(ControlNino selected) {
        this.selected = selected;
    }
    
    public List<ControlNino> getAllItems(){
    allitems = getFacade().findAll();
    if(allitems==null){
        allitems= new ArrayList<ControlNino>();
    }
    return allitems;
    }
    
    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ControlNinoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ControlNino prepareCreate() {
        selected = new ControlNino();
        initializeEmbeddableKey();
        return selected;
    }

   
     public String create(CartolaControlesNino cartola) {       
        selected.setCartolaControlesNino(cartola);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ControlNinoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("", new FacesMessage("Control creado con éxito"));
        return "/faces/pacienteNino/NinoToPediatria.xhtml?faces-redirect=true";
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ControlNinoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ControlNinoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ControlNino> getItems() {
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

    public ControlNino getControlNino(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<ControlNino> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ControlNino> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ControlNino.class)
    public static class ControlNinoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ControlNinoController controller = (ControlNinoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "controlNinoController");
            return controller.getControlNino(getKey(value));
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
            if (object instanceof ControlNino) {
                ControlNino o = (ControlNino) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ControlNino.class.getName()});
                return null;
            }
        }

    }
    
    public ControlNino getObjetobyId(Long id){
        getAllItems();//todos los items
        for(ControlNino item: allitems){//para cada item de Preingreso de la bd
            if(id.equals(item.getCartolaControlesNino().getPacienteNino().getId())){//si el objeto a comparar es igual al id de entrada
                setSelected(item);//seleccione ese objeto
                return selected;//se retorna
            }
        }
        return null;//si no se encuentra retorna nulo
    }
    
}
