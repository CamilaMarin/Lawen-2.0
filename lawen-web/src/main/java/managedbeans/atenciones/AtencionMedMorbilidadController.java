package managedbeans.atenciones;

import entities.atenciones.AtencionMedMorbilidad;
import managedbeans.atenciones.util.JsfUtil;
import managedbeans.atenciones.util.JsfUtil.PersistAction;
import sessionbeans.atenciones.AtencionMedMorbilidadFacadeLocal;

import java.io.Serializable;
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

@Named("atencionMedMorbilidadController")
@SessionScoped
public class AtencionMedMorbilidadController implements Serializable {

    @EJB
    private AtencionMedMorbilidadFacadeLocal ejbFacade;
    private List<AtencionMedMorbilidad> items = null;
    private AtencionMedMorbilidad selected;
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
        //System.out.println(""+getSelected().getPaciente().getFechaNacimiento_paciente());
        try{
           
        if(getSelected().getPaciente_mrb().getFechaNacimiento_paciente()==null){
            //System.out.println("nulo");
            
            edad=0;
        }
        else{
        Date date = getSelected().getPaciente_mrb().getFechaNacimiento_paciente();
        edad= pacientecontroller.Age(date);
        if(edad<0)
            edad=0;
        //System.out.println("edad quedo como"+edad);
        
        }
        }
        catch(Exception e){
            //System.out.println("error");
            edad=0;
        }
        
       
    }
    
    
    public AtencionMedMorbilidadController() {
    }

    public AtencionMedMorbilidad getSelected() {
        return selected;
    }

    public void setSelected(AtencionMedMorbilidad selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AtencionMedMorbilidadFacadeLocal getFacade() {
        return ejbFacade;
    }

    public AtencionMedMorbilidad prepareCreate() {
        selected = new AtencionMedMorbilidad();
        initializeEmbeddableKey();
        return selected;
    }
    public void cancel() {
        setSelected(null);
    }
    public void create(int edad) {
        getSelected().setEdadMorb(edad);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AtencionMedMorbilidadCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        selected = null;
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AtencionMedMorbilidadUpdated"));
        selected = null;
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AtencionMedMorbilidadDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<AtencionMedMorbilidad> getItems() {
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

    public AtencionMedMorbilidad getAtencionMedMorbilidad(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<AtencionMedMorbilidad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<AtencionMedMorbilidad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = AtencionMedMorbilidad.class)
    public static class AtencionMedMorbilidadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AtencionMedMorbilidadController controller = (AtencionMedMorbilidadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "atencionMedMorbilidadController");
            return controller.getAtencionMedMorbilidad(getKey(value));
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
            if (object instanceof AtencionMedMorbilidad) {
                AtencionMedMorbilidad o = (AtencionMedMorbilidad) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AtencionMedMorbilidad.class.getName()});
                return null;
            }
        }

    }

}
