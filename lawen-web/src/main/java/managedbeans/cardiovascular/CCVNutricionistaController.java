package managedbeans.cardiovascular;

import entities.cardiovascular.CCVNutricionista;
import managedbeans.cardiovascular.util.JsfUtil;
import managedbeans.cardiovascular.util.JsfUtil.PersistAction;
import sessionbeans.cardiovascular.CCVNutricionistaFacadeLocal;

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


@Named("cCVNutricionistaController")
@SessionScoped
public class CCVNutricionistaController implements Serializable {

    @EJB
    private CCVNutricionistaFacadeLocal ejbFacade;
    private List<CCVNutricionista> items = null;
    private CCVNutricionista selected;
    private String tabaco;

    public CCVNutricionistaController() {
    }

    public CCVNutricionista getSelected() {
        return selected;
    }

    public void setSelected(CCVNutricionista selected) {
        this.selected = selected;
    }

           public String getTabaco() {
        return tabaco;
    }

    public void setTabaco(String tabaco) {
        this.tabaco = tabaco;
    }
    
    
    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CCVNutricionistaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public CCVNutricionista prepareCreate() {
        selected = new CCVNutricionista();
        initializeEmbeddableKey();
        return selected;
    }
    /***
     * Crea la relacion entre la cartola y la Ficha
     * @param cont
     * @param fich
     * @param pac
     * @param edad
     * @param diabetico
     * @param ACV
     * @param hipertenso
     * @param dilipidemia
     * @param IAM
     * @return 
     */
     public String crearCCV( CartolaSeguimientoCCVController cont, FichaNutricionistaController fich, PacienteController pac, int edad, boolean diabetico, boolean hipertenso, boolean dilipidemia, boolean ACV, boolean IAM,boolean prediabetes, boolean intolerancia_glucosa,boolean resistencia_insulina){
        pac.setSelected(cont.getSelected().getPaciente());
        pac.getSelected().setDiabetico(diabetico);
        pac.getSelected().setDislipidemico(dilipidemia);
        pac.getSelected().setHipertencion(hipertenso);
        pac.getSelected().setACV(ACV);
        pac.getSelected().setIAM(IAM);
        pac.getSelected().setPrediabetes(prediabetes);
        pac.getSelected().setIntolerancia_glucosa(intolerancia_glucosa);
        pac.getSelected().setResistencia_insulina(resistencia_insulina);
        pac.update();
        if(tabaco.equals("Si")){
                    cont.getSelected().setTabaco(tabaco);
                }
        else cont.getSelected().setTabaco(tabaco);
        cont.getSelected().setIAM(IAM);
        cont.getSelected().setACV(ACV);
        cont.getSelected().setEdad_paciente(edad);
        prepareCreate();
        getFacade().crearFicha(cont.getSelected(), fich.getSelected(), selected);//toma los objetos y llama al session bean realizar pago
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("", new FacesMessage("Se ha creado la ficha con éxito."));
        
        cont.setSelected(null);
        fich.setSelected(null);
        pac.setSelected(null);
        selected = null;
        tabaco= null;
        return "/faces/cCVNutricionista/List?faces-redirect=true";
    }
    
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CCVNutricionistaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CCVNutricionistaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CCVNutricionistaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CCVNutricionista> getItems() {
   
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

    public CCVNutricionista getCCVNutricionista(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<CCVNutricionista> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CCVNutricionista> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CCVNutricionista.class)
    public static class CCVNutricionistaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CCVNutricionistaController controller = (CCVNutricionistaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cCVNutricionistaController");
            return controller.getCCVNutricionista(getKey(value));
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
            if (object instanceof CCVNutricionista) {
                CCVNutricionista o = (CCVNutricionista) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CCVNutricionista.class.getName()});
                return null;
            }
        }

    }

}
