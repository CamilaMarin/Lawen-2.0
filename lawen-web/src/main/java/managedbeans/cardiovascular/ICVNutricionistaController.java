package managedbeans.cardiovascular;

import entities.cardiovascular.CartolaSeguimientoCCV;

import entities.cardiovascular.FichaNutricionista;
import entities.cardiovascular.ICVNutricionista;
import managedbeans.cardiovascular.util.JsfUtil;
import managedbeans.cardiovascular.util.JsfUtil.PersistAction;
import sessionbeans.cardiovascular.ICVNutricionistaFacadeLocal;
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
import javax.inject.Inject;
import managedbeans.PacienteController;

@Named("iCVNutricionistaController")
@SessionScoped
public class ICVNutricionistaController implements Serializable {

    @EJB
    private ICVNutricionistaFacadeLocal ejbFacade;
    private List<ICVNutricionista> items = null;
    private ICVNutricionista selected;
    private List<ICVNutricionista> allitems = null;
    @Inject
    private PacienteController pacientecontroller;
    private String tabaco = null;
    public ICVNutricionistaController() {
    }

    public ICVNutricionista getSelected() {
        return selected;
    }

    public void setSelected(ICVNutricionista selected) {
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

    private ICVNutricionistaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ICVNutricionista prepareCreate() {
        selected = new ICVNutricionista();
        initializeEmbeddableKey();
        return selected;
    }

    /**
     * Crea la relacion entre la cartola y la Ficha
     *
     * @param cont
     * @param fich
     * @param paciente
     * @param diabetico
     * @param hipertenso
     * @param dilipidemia
     * @param ACV
     * @param IAM
     * @return
     */
    public String crearCCV(CartolaSeguimientoCCV cont, FichaNutricionista fich, PacienteController paciente, boolean diabetico, boolean hipertenso, boolean dilipidemia, boolean ACV, boolean IAM, boolean prediabetes) {
        paciente.getSelected().setDiabetico(diabetico);
        paciente.getSelected().setDislipidemico(dilipidemia);
        paciente.getSelected().setHipertencion(hipertenso);
        paciente.getSelected().setACV(ACV);
        paciente.getSelected().setIAM(IAM);
        paciente.getSelected().setPrediabetes(prediabetes);
        int edad_pa = pacientecontroller.Age(paciente.getSelected().getFechaNacimiento_paciente());
        if (edad_pa < 0) {
            edad_pa = 0;
        }
        if(tabaco.equals("Si")){
            cont.setTabaco(true);
                }
        else cont.setTabaco(false);
        cont.setEdad_paciente(edad_pa);
        cont.setIngreso_reingreso("Ingreso");
        cont.setPaciente(paciente.getSelected());
        paciente.updateInICV();
        prepareCreate();
        getFacade().realizarPago(cont, fich, selected);//toma los objetos y llama al session bean realizar pago
        tabaco = null;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("", new FacesMessage("Se ha creado la ficha con éxito."));
        return "/faces/paciente/PacienteToCCV.xhtml?faces-redirect=true";
    }

    /**
     * Crea la relacion entre la cartola y la Ficha
     *
     * @param cont
     * @param fich
     * @param paciente
     * @param diabetico
     * @param hipertenso
     * @param dilipidemia
     * @param ACV
     * @param IAM
     * @param prediabetes
     * @return
     */
    public String crearCCVReingreso(CartolaSeguimientoCCV cont, FichaNutricionista fich, PacienteController paciente, boolean diabetico, boolean hipertenso, boolean dilipidemia, boolean ACV, boolean IAM, boolean prediabetes) {
        paciente.getSelected().setDiabetico(diabetico);
        paciente.getSelected().setDislipidemico(dilipidemia);
        paciente.getSelected().setHipertencion(hipertenso);
        paciente.getSelected().setACV(ACV);
        paciente.getSelected().setIAM(IAM);
        paciente.getSelected().setPrediabetes(prediabetes);
        int edad_pa = pacientecontroller.Age(paciente.getSelected().getFechaNacimiento_paciente());
        if (edad_pa < 0) {
            edad_pa = 0;
        }
        if(tabaco.equals("Si")){
            cont.setTabaco(true);
                }
        else cont.setTabaco(false);
        cont.setEdad_paciente(edad_pa);
        cont.setIngreso_reingreso("Reingreso");
        cont.setPaciente(paciente.getSelected());
        paciente.updateInICV();
        prepareCreate();
        getFacade().realizarPago(cont, fich, selected);//toma los objetos y llama al session bean realizar pago
        tabaco = null;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("", new FacesMessage("Se ha creado la ficha con éxito."));
        return "/faces/paciente/PacienteToCCV.xhtml?faces-redirect=true";
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ICVNutricionistaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ICVNutricionistaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ICVNutricionistaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ICVNutricionista> getItems() {
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

    public ICVNutricionista getICVNutricionista(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<ICVNutricionista> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ICVNutricionista> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ICVNutricionista.class)
    public static class ICVNutricionistaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ICVNutricionistaController controller = (ICVNutricionistaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "iCVNutricionistaController");
            return controller.getICVNutricionista(getKey(value));
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
            if (object instanceof ICVNutricionista) {
                ICVNutricionista o = (ICVNutricionista) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ICVNutricionista.class.getName()});
                return null;
            }
        }

    }

    /**
     * *
     * Consulto todos los datos de Preingreso y lo guarda en una lista
     *
     * @return
     */
    public List<ICVNutricionista> getAllItems() {
        allitems = getFacade().findAll();
        if (allitems == null) {
            allitems = new ArrayList<ICVNutricionista>();
        }
        return allitems;
    }

    /**
     *
     * @param rut
     * @return objeto preingresod1 Funcion que busca dentro de todos los items
     * de preingreso el valor que es igual al rut de entrada
     *
     */
    public ICVNutricionista getObjetobyRut(int id) {
        getAllItems();//todos los items

        for (ICVNutricionista item : allitems) {//para cada item de Preingreso de la bd

            if (id == item.getCartola().getPaciente().getId()) {//si el objeto a comparar es igual al rut de entrada
                setSelected(item);//seleccione ese objeto

                return selected;//se retorna
            }
        }
        return null;//si no se encuentra retorna nulo
    }

}
