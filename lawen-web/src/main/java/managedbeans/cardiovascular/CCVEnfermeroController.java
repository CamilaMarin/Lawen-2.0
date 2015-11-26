package managedbeans.cardiovascular;


import entities.cardiovascular.CCVEnfermero;

import managedbeans.cardiovascular.util.JsfUtil;
import managedbeans.cardiovascular.util.JsfUtil.PersistAction;
import sessionbeans.cardiovascular.CCVEnfermeroFacadeLocal;

import java.io.Serializable;
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
import managedbeans.PacienteController;
import sessionbeans.PacienteFacadeLocal;

@Named("cCVEnfermeroController")
@SessionScoped
public class CCVEnfermeroController implements Serializable {

    @EJB
    private CCVEnfermeroFacadeLocal ejbFacade;
    
    @EJB
    private PacienteFacadeLocal pacienteFacade;
    private List<CCVEnfermero> items = null;
    private CCVEnfermero selected;
    private float imcIn;
    private String diagnosticoIn;
    private PacienteController pa;
    private String tabaco;

    public CCVEnfermeroController() {
    }

    public PacienteFacadeLocal getPacienteFacade() {
        return pacienteFacade;
    }

    public String getTabaco() {
        return tabaco;
    }

    public void setTabaco(String tabaco) {
        this.tabaco = tabaco;
    }
    
    
    
    public float getImcIn() {
        return imcIn;
    }

    public void setImcIn(float imcIn) {
        this.imcIn = imcIn;
    }

    public String getDiagnosticoIn() {
        return diagnosticoIn;
    }

    public void setDiagnosticoIn(String diagnosticoIn) {
        this.diagnosticoIn = diagnosticoIn;
    }

    
    public CCVEnfermero getSelected() {
        return selected;
    }

    public void setSelected(CCVEnfermero selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CCVEnfermeroFacadeLocal getFacade() {
        return ejbFacade;
    }

    public CCVEnfermero prepareCreate() {
        selected = new CCVEnfermero();
        initializeEmbeddableKey();
        return selected;
    }

    public PacienteController getPa() {
        return pa;
    }

    public void setPa(PacienteController pa) {
        this.pa = pa;
    }
    
    /***
     * Crea la relacion entre la cartola y la Ficha
     * @param cont
     * @param fich
     * @param pac
     * @param edad
     * @param diabetico
     * @param hipertenso
     * @param dilipidemia
     * @param ACV
     * @param IAM
     * @return 
     */
     public String crearCCV( CartolaSeguimientoCCVController cont, FichaEnfermeroController fich, PacienteController pac, int edad, boolean diabetico, boolean hipertenso, boolean dilipidemia, boolean ACV, boolean IAM,boolean prediabetes ){
                
                pac.setSelected(cont.getSelected().getPaciente());
                pac.getSelected().setDiabetico(diabetico);
                pac.getSelected().setDislipidemico(dilipidemia);
                pac.getSelected().setHipertencion(hipertenso);
                pac.getSelected().setACV(ACV);
                pac.getSelected().setIAM(IAM);
                pac.getSelected().setPrediabetes(prediabetes);
                pac.update();
                prepareCreate();
                if(tabaco.equals("Si")){
                    cont.getSelected().setTabaco(true);
                }
                else cont.getSelected().setTabaco(false);
                cont.getSelected().setIAM(IAM);
                cont.getSelected().setACV(ACV);
                cont.getSelected().setImc(imcIn);
                cont.getSelected().setDiagnostico_nutricional(diagnosticoIn);
                cont.getSelected().setEdad_paciente(edad);
                getFacade().crearFicha(cont.getSelected(), fich.getSelected(), selected);//toma los objetos y llama al session bean realizar pago
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("", new FacesMessage("Se ha creado la ficha con éxito."));
                cont.setSelected(null);
                fich.setSelected(null);
                pac.setSelected(null);
                selected = null;
                tabaco= null;
                imcIn = 0;
                diagnosticoIn = null;
                return "/faces/cCVEnfermero/List?faces-redirect=true";
       
        
        
    }
    
      public void buttonAction() {
      addMessage("Se ha actualizado la tabla!");
    }
     public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CCVEnfermeroCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CCVEnfermeroUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CCVEnfermeroDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

     public List<CCVEnfermero> getItems() {
       
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

    public CCVEnfermero getCCVEnfermero(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<CCVEnfermero> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CCVEnfermero> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CCVEnfermero.class)
    public static class CCVEnfermeroControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CCVEnfermeroController controller = (CCVEnfermeroController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cCVEnfermeroController");
            return controller.getCCVEnfermero(getKey(value));
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
            if (object instanceof CCVEnfermero) {
                CCVEnfermero o = (CCVEnfermero) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CCVEnfermero.class.getName()});
                return null;
            }
        }

    }

}
