/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Medicamentos;
import entities.MedicamentosCartola;
import entities.cardiovascular.CartolaSeguimientoCCV;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import managedbeans.cardiovascular.CartolaSeguimientoCCVController;
import managedbeans.cardiovascular.util.JsfUtil;
import managedbeans.cardiovascular.util.JsfUtil.PersistAction;
import sessionbeans.MedicamentosCartolaFacadeLocal;

/**
 *
 * @author Beban
 */
@Named(value = "medicamentosCartolaController")
@Dependent
public class MedicamentosCartolaController {

    @EJB
    private MedicamentosCartolaFacadeLocal medicamentosCartolaFacade;  
    private List<MedicamentosCartola> items = null;
    private List<MedicamentosCartola> itemsElim = null;
    private MedicamentosCartola selected;
    private CartolaSeguimientoCCV seleccionado;
    private List<String> selectedIds = null;  
    @Inject
    private MedicamentosController medicamentosCar;
    @Inject
    private CartolaSeguimientoCCVController cartolaCar;
    private List<Medicamentos> faltantesmedicamentos=null;
     

    /**
     * Creates a new instance of MedicamentosCartolaController
     */
    public MedicamentosCartolaController() {
    }

    public MedicamentosCartolaFacadeLocal getMedicamentosCartolaFacade() {
        return medicamentosCartolaFacade;
    }

    public CartolaSeguimientoCCV getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(CartolaSeguimientoCCV seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<String> getSelectedIds() {
        return selectedIds;
    }

    public void setSelectedIds(List<String> selectedIds) {
        this.selectedIds = selectedIds;
    }
    
    public MedicamentosController getSubProg() {
        return medicamentosCar;
    }

    public void setSubProg(MedicamentosController medicamentosCar) {
        this.medicamentosCar = medicamentosCar;
    }

    public void setEjbFacade(MedicamentosCartolaFacadeLocal medicamentosCartolaFacade) {
        this.medicamentosCartolaFacade = medicamentosCartolaFacade;
    }

    public MedicamentosCartola getSelected() {
        return selected;
    }

    public void setSelected(MedicamentosCartola selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private MedicamentosCartolaFacadeLocal getFacade() {
        return medicamentosCartolaFacade;
    }

    public MedicamentosCartola prepareCreate() {
        selected = new MedicamentosCartola();
        initializeEmbeddableKey();
        return selected;
    }
    
    public String prueba(CartolaSeguimientoCCV cartola) {
        cartolaCar.setSelected(seleccionado);
        System.out.println("ESTOY CON " + cartolaCar.getSelected().getId());
        return "/faces/cartola/CartolaSeguimientoCCVToMedicamentosCartola.xhtml?faces-redirect=true";
    }
    
    public String create(CartolaSeguimientoCCV cartola, List<String> idsSeleccionados) {
        FacesContext context = FacesContext.getCurrentInstance();
        for (int i = 0; i < idsSeleccionados.size(); i++) {
            Medicamentos medicamentoscar;
            medicamentoscar = medicamentosCar.getMedicamento(Long.valueOf(idsSeleccionados.get(i)));            
            if(findMedicamentoCartola(cartola,medicamentoscar)==null){                
                prepareCreate();
                selected.setIdCartolaseguimiento(cartola);
                selected.setIdMedicamentosCartola(medicamentoscar);
                persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MedicamentosCartolaCreated") + " a medicamentosCarrama de " + medicamentosCar.getNombres());
                if (!JsfUtil.isValidationFailed()) {
                    items = null;    // Invalidate list of items to trigger re-query.
                }                
                context.addMessage("", new FacesMessage("Ingresado correctamente al medicamentosCarrama de " + medicamentosCar.getNombres()));
            }           
        }
        return "/faces/cartola/List.xhtml?faces-redirect=true";
    }
    
    public void update() {        
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MedicamentosCartolaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MedicamentosCartolaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remueve la seleccion
            items = null;    // Invalida la lista para gatillar re-query
        }
    }

    public List<MedicamentosCartola> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    public List<MedicamentosCartola> obtenerMedicamentosCartolasCartolaSeguimientoCCV() {
        return getFacade().findbyCartola(seleccionado);
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
    
       public MedicamentosCartola findMedicamentoCartola(CartolaSeguimientoCCV cartola, Medicamentos medicamento) {
        getItems();
        for (MedicamentosCartola item : items) {
            if (cartola.getId().equals(item.getIdCartolaseguimiento()) && medicamento.getIdMedicamento().equals(item.getIdMedicamento())) {
                return item;
            }
        }
        return null;
    }
    
    public MedicamentosCartola FindObjetbyCartolaSeguimientoCCV(CartolaSeguimientoCCV cartola) {
        getItems();
        for (MedicamentosCartola item : items) {
            if (cartola.getId().equals(item.getIdCartolaseguimiento().getId())) {
                return item;
            }
        }
        return null;
    }
    
    public List<Medicamentos> findFaltantes(CartolaSeguimientoCCV cartola) {
        faltantesmedicamentos= medicamentosCar.getMedicamentosFacade().findAll();
        getItems();
        for (MedicamentosCartola item : items) {
            if (item.getIdCartolaseguimiento().getId().equals(cartola.getId())) {
                for (int i =0; i<faltantesmedicamentos.size();i++){
                    if (item.getIdMedicamentosCartola().equals(faltantesmedicamentos.get(i))){
                        faltantesmedicamentos.remove(i);
                    }                    
                }
            }            
        }
        return faltantesmedicamentos;
    }

    public MedicamentosCartola getMedicamentosCartola(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<MedicamentosCartola> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<MedicamentosCartola> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = MedicamentosCartola.class)
    public static class MedicamentosCartolaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MedicamentosCartolaController controller = (MedicamentosCartolaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "medicamentosCarramaController");
            return controller.getMedicamentosCartola(getKey(value));
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
            if (object instanceof MedicamentosCartola) {
                MedicamentosCartola o = (MedicamentosCartola) object;
                return getStringKey(o.getIdMedicamentosCartola());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), MedicamentosCartola.class.getName()});
                return null;
            }
        }

    }

}
