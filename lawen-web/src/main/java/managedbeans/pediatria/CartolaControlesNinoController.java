package managedbeans.pediatria;

import entities.pediatria.CartolaControlesNino;
import entities.pediatria.ControlNino;
import entities.pediatria.PacienteNino;
import managedbeans.pediatria.util.JsfUtil;
import managedbeans.pediatria.util.JsfUtil.PersistAction;
import sessionbeans.pediatria.CartolaControlesNinoFacadeLocal;

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

@Named("cartolaControlesNinoController")
@SessionScoped
public class CartolaControlesNinoController implements Serializable {

    @EJB
    private CartolaControlesNinoFacadeLocal ejbFacade;
    private List<CartolaControlesNino> items = null;
    private CartolaControlesNino selected;
    private List<CartolaControlesNino> allitems =null;
    
     
    public List<CartolaControlesNino> getAllItems(){
        allitems = getFacade().findAll();
        if(allitems==null){
            allitems= new ArrayList<CartolaControlesNino>();
        }
        return allitems;
    }
    
    public CartolaControlesNinoController() {
    }

    public CartolaControlesNino getSelected() {
        return selected;
    }

    public void setSelected(CartolaControlesNino selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CartolaControlesNinoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public CartolaControlesNino prepareCreate() {
        selected = new CartolaControlesNino();
        initializeEmbeddableKey();
        return selected;
    }

    public String create(PacienteNino paciente) {
        if(getObjetobyId(paciente.getId())==null){
            prepareCreate();
            getFacade().crearCartola(paciente, selected);
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CartolaControlesNinoCreated"));
            if (!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage("Cartola controles creada con éxito"));
            return "/faces/pacienteNino/NinoToPediatria.xhtml?faces-redirect=true";
        }
        else{
            selected = getObjetobyId(paciente.getId());
            if (!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage("Cartola controles creada con éxito"));
            return "/faces/pacienteNino/NinoToPediatria.xhtml?faces-redirect=true";
        }        
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CartolaControlesNinoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CartolaControlesNinoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    

    public List<CartolaControlesNino> getItems() {
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

    public CartolaControlesNino getCartolaControlesNino(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<CartolaControlesNino> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CartolaControlesNino> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CartolaControlesNino.class)
    public static class CartolaControlesNinoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CartolaControlesNinoController controller = (CartolaControlesNinoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cartolaControlesNinoController");
            return controller.getCartolaControlesNino(getKey(value));
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
            if (object instanceof CartolaControlesNino) {
                CartolaControlesNino o = (CartolaControlesNino) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CartolaControlesNino.class.getName()});
                return null;
            }
        }          
    }

    public CartolaControlesNino getObjetobyId(Long id){
            getAllItems();//todos los items
            for(CartolaControlesNino item: allitems){//para cada item de Preingreso de la bd
                if(id.equals(item.getPacienteNino().getId())){//si el objeto a comparar es igual al id de entrada
                    setSelected(item);//seleccione ese objeto
                    return selected;//se retorna
                }
            }
            return null;//si no se encuentra retorna nulo
        }
}
