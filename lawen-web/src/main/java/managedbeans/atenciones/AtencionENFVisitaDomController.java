package managedbeans.atenciones;

import entities.atenciones.AtencionENFVisitaDom;
import managedbeans.atenciones.util.JsfUtil;
import managedbeans.atenciones.util.JsfUtil.PersistAction;
import sessionbeans.atenciones.AtencionENFVisitaDomFacadeLocal;

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

@Named("atencionENFVisitaDomController")
@SessionScoped
public class AtencionENFVisitaDomController implements Serializable {

    @EJB
    private AtencionENFVisitaDomFacadeLocal ejbFacade;
    private List<AtencionENFVisitaDom> items = null;
    private AtencionENFVisitaDom selected;
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
           
        if(getSelected().getPaciente_visita().getFechaNacimiento_paciente()==null){
            //System.out.println("nulo");
            
            edad=0;
        }
        else{
        Date date = getSelected().getPaciente_visita().getFechaNacimiento_paciente();
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
    
    
    
    public AtencionENFVisitaDomController() {
    }

    public AtencionENFVisitaDom getSelected() {
        return selected;
    }

    public void setSelected(AtencionENFVisitaDom selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AtencionENFVisitaDomFacadeLocal getFacade() {
        return ejbFacade;
    }

    public AtencionENFVisitaDom prepareCreate() {
        selected = new AtencionENFVisitaDom();
        initializeEmbeddableKey();
        return selected;
    }
    public void cancel() {
        setSelected(null);
    }
    public void create(int edad) {
        getSelected().setEdad_paciente(edad);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AtencionENFVisitaDomCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        selected = null;
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AtencionENFVisitaDomUpdated"));
        selected = null;
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AtencionENFVisitaDomDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<AtencionENFVisitaDom> getItems() {
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

    public AtencionENFVisitaDom getAtencionENFVisitaDom(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<AtencionENFVisitaDom> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<AtencionENFVisitaDom> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = AtencionENFVisitaDom.class)
    public static class AtencionENFVisitaDomControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AtencionENFVisitaDomController controller = (AtencionENFVisitaDomController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "atencionENFVisitaDomController");
            return controller.getAtencionENFVisitaDom(getKey(value));
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
            if (object instanceof AtencionENFVisitaDom) {
                AtencionENFVisitaDom o = (AtencionENFVisitaDom) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AtencionENFVisitaDom.class.getName()});
                return null;
            }
        }

    }

}
