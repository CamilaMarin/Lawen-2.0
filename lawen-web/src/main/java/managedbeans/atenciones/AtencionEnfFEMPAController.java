package managedbeans.atenciones;

import entities.atenciones.AtencionEnfFEMPA;
import managedbeans.atenciones.util.JsfUtil;
import managedbeans.atenciones.util.JsfUtil.PersistAction;
import sessionbeans.atenciones.AtencionEnfFEMPAFacadeLocal;

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

@Named("atencionEnfFEMPAController")
@SessionScoped
public class AtencionEnfFEMPAController implements Serializable {

    @EJB
    private AtencionEnfFEMPAFacadeLocal ejbFacade;
    private List<AtencionEnfFEMPA> items = null;
    private AtencionEnfFEMPA selected;
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
           
        if(getSelected().getPaciente_empa().getFechaNacimiento_paciente()==null){
            //System.out.println("nulo");
            
            edad=0;
        }
        else{
        Date date = getSelected().getPaciente_empa().getFechaNacimiento_paciente();
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
    
    public AtencionEnfFEMPAController() {
    }

    public AtencionEnfFEMPA getSelected() {
        return selected;
    }

    public void setSelected(AtencionEnfFEMPA selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AtencionEnfFEMPAFacadeLocal getFacade() {
        return ejbFacade;
    }

    public AtencionEnfFEMPA prepareCreate() {
        selected = new AtencionEnfFEMPA();
        initializeEmbeddableKey();
        return selected;
    }
    public void cancel() {
        setSelected(null);
    }
   
    public void create(int edad) {
        getSelected().setEdad_paciente_emp(edad);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AtencionEnfFEMPACreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        selected = null;
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AtencionEnfFEMPAUpdated"));
        selected = null;
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AtencionEnfFEMPADeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<AtencionEnfFEMPA> getItems() {
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

    public AtencionEnfFEMPA getAtencionEnfFEMPA(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<AtencionEnfFEMPA> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<AtencionEnfFEMPA> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = AtencionEnfFEMPA.class)
    public static class AtencionEnfFEMPAControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AtencionEnfFEMPAController controller = (AtencionEnfFEMPAController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "atencionEnfFEMPAController");
            return controller.getAtencionEnfFEMPA(getKey(value));
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
            if (object instanceof AtencionEnfFEMPA) {
                AtencionEnfFEMPA o = (AtencionEnfFEMPA) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AtencionEnfFEMPA.class.getName()});
                return null;
            }
        }

    }

}
