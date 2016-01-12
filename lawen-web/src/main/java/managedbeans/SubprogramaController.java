package managedbeans;

import entities.Paciente;
import entities.Subprograma;
import entities.TipoSubprograma;
import managedbeans.util.JsfUtil;
import managedbeans.util.JsfUtil.PersistAction;
import sessionbeans.SubprogramaFacadeLocal;

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
import javax.inject.Inject;

@Named("subprogramaController")
@SessionScoped 
public class SubprogramaController implements Serializable {
    
    @EJB
    private SubprogramaFacadeLocal ejbFacade;
    private List<Subprograma> items = null;
    private List<Subprograma> itemsElim = null;
    private Subprograma selected;
    private Paciente seleccionado;
    private List<String> selectedIds = null;  
    @Inject
    private TipoSubprogramaController subProg;
    @Inject
    private PacienteController pacienteProg;
    private List<TipoSubprograma> faltantesDubProg=null;

    public Paciente getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Paciente seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<String> getSelectedIds() {
        return selectedIds;
    }

    public void setSelectedIds(List<String> selectedIds) {
        this.selectedIds = selectedIds;
    }
    
    public TipoSubprogramaController getSubProg() {
        return subProg;
    }

    public void setSubProg(TipoSubprogramaController subProg) {
        this.subProg = subProg;
    }

    public void setEjbFacade(SubprogramaFacadeLocal ejbFacade) {
        this.ejbFacade = ejbFacade;
    }
    
    public SubprogramaController() {
    }

    public Subprograma getSelected() {
        return selected;
    }

    public void setSelected(Subprograma selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SubprogramaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Subprograma prepareCreate() {
        selected = new Subprograma();
        initializeEmbeddableKey();
        return selected;
    }
    
    public String prueba(Paciente paciente) {
        pacienteProg.setSelected(seleccionado);
        return "/faces/paciente/PacienteToSubprograma.xhtml?faces-redirect=true";
    }
    
    public String create(Paciente paciente, List<String> idsSeleccionados) {
        FacesContext context = FacesContext.getCurrentInstance();
        for (int i = 0; i < idsSeleccionados.size(); i++) {
            TipoSubprograma subprog;
            subprog = subProg.getTipoSubprograma(Long.valueOf(idsSeleccionados.get(i)));            
            if(findSubprogramaPaciente(paciente,subprog)==null){                
                prepareCreate();
                selected.setPaciente(paciente);
                selected.setSubprograma(subprog);
                persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SubprogramaCreated") + " a subprograma de " + subprog.getNombre_subprograma());
                if (!JsfUtil.isValidationFailed()) {
                    items = null;    // Invalidate list of items to trigger re-query.
                }                
                context.addMessage("", new FacesMessage("Ingresado correctamente al subprograma de " + subprog.getNombre_subprograma()));
            }            
        }
        return "/faces/paciente/List.xhtml?faces-redirect=true";
    }
    
    public void update() {        
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SubprogramaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SubprogramaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remueve la seleccion
            items = null;    // Invalida la lista para gatillar re-query
        }
    }

    public List<Subprograma> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    public List<Subprograma> obtenerSubprogramasPaciente() {
        return getFacade().findbyPaciente(seleccionado);
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
    
    public Subprograma findSubprogramaPaciente(Paciente paciente, TipoSubprograma tipoSub) {
        getItems();
        for (Subprograma item : items) {
            if (paciente.getId().equals(item.getPaciente().getId()) && tipoSub.getId().equals(item.getSubprograma().getId())) {
                return item;
            }
        }
        return null;
    }
    
    public Subprograma FindObjetbyPaciente(Paciente paciente) {
        getItems();
        for (Subprograma item : items) {
            if (paciente.getId().equals(item.getPaciente().getId())) {
                return item;
            }
        }
        return null;
    }
    
    public List<TipoSubprograma> findFaltantes(Paciente paciente) {
        faltantesDubProg= subProg.getEjbFacade().findAll();
        getItems();
        for (Subprograma item : items) {
            if (item.getPaciente().getId().equals(paciente.getId())) {
                for (int i =0; i<faltantesDubProg.size();i++){
                    if (item.getSubprograma().getId().equals(faltantesDubProg.get(i).getId())){
                        faltantesDubProg.remove(i);
                    }                    
                }
            }            
        }
        return faltantesDubProg;
    }

    public Subprograma getSubprograma(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Subprograma> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Subprograma> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Subprograma.class)
    public static class SubprogramaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SubprogramaController controller = (SubprogramaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "subprogramaController");
            return controller.getSubprograma(getKey(value));
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
            if (object instanceof Subprograma) {
                Subprograma o = (Subprograma) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Subprograma.class.getName()});
                return null;
            }
        }

    }

}
