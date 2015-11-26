package managedbeans.adultoMayor;

import entities.adultoMayor.IngresoPSAM;
import managedbeans.adultoMayor.util.JsfUtil;
import managedbeans.adultoMayor.util.JsfUtil.PersistAction;
import sessionbeans.adultoMayor.IngresoPSAMFacadeLocal;

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
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("ingresoPSAMController")
@SessionScoped
public class IngresoPSAMController implements Serializable {

    @EJB
    private IngresoPSAMFacadeLocal ejbFacade;
    private List<IngresoPSAM> items = null;
    private IngresoPSAM selected;
    private boolean efam = false;
    private boolean barthel= true;

    public IngresoPSAMController() {
    }

    public boolean isEfam() {
        return efam;
    }

    
    public void elegirEfam(){
        efam = false;
        barthel= true;
       
    }
    
    public void elegirBarthel(){
        efam = true;
        barthel= false;
       
    }
    
    public void setEfam(boolean efam) {
        this.efam = efam;
    }

    public boolean isBarthel() {
        return barthel;
    }

    public void setBarthel(boolean barthel) {
        this.barthel = barthel;
    }
    
    public IngresoPSAM getSelected() {
        return selected;
    }

    public void setSelected(IngresoPSAM selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private IngresoPSAMFacadeLocal getFacade() {
        return ejbFacade;
    }

    public IngresoPSAM prepareCreate() {
        efam = false;
        barthel = true;
        selected = new IngresoPSAM();
        initializeEmbeddableKey();
        return selected;
    }

    public String crearCPSAM (CartolaSeguimientoPSAMController cont,
                 FichaAdultoMayorController fich,
                 EsferaClinicaPSAMController esferaCli,
                 EsferaFuncionalPSAMController esferaFu,
                 EsferaMentalPSAMController esferaMen,
                 EsferaSocialPSAMController esferaSoc,int edad){
                 System.out.println("Barthel: "+cont.getSelected().getClasificacion_barthel());
                 System.out.println("Efam: "+cont.getSelected().getClasificacion_efam());
                cont.getSelected().setEdad(edad);
                if(!efam){
                    cont.getSelected().setClasificacion_barthel("No se aplica");
                }
                else{
                    cont.getSelected().setClasificacion_efam("No se aplica");
                }
                if(cont.getSelected().getClasificacion_barthel()==null){
                    cont.getSelected().setClasificacion_barthel("No se aplica");
                }
                if(cont.getSelected().getClasificacion_efam()==null){
                    cont.getSelected().setClasificacion_efam("No se aplica");
                }
                efam = false;
                barthel = true;
                prepareCreate();
                getFacade().crearFichaPSAM(cont.getSelected(),fich.getSelected(),esferaCli.getSelected(),
                        esferaFu.getSelected(),esferaMen.getSelected(),esferaSoc.getSelected(), selected);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("", new FacesMessage("Se ha creado la ficha con éxito."));
                return "/faces/ingresoPSAM/List?faces-redirect=true";
       
    }

    
    
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("IngresoPSAMCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("IngresoPSAMUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("IngresoPSAMDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<IngresoPSAM> getItems() {
            efam = false;
            barthel = true;
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

    public IngresoPSAM getIngresoPSAM(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<IngresoPSAM> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<IngresoPSAM> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = IngresoPSAM.class)
    public static class IngresoPSAMControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            IngresoPSAMController controller = (IngresoPSAMController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ingresoPSAMController");
            return controller.getIngresoPSAM(getKey(value));
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
            if (object instanceof IngresoPSAM) {
                IngresoPSAM o = (IngresoPSAM) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), IngresoPSAM.class.getName()});
                return null;
            }
        }

    }

}
