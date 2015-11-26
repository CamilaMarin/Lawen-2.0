package managedbeans;

import entities.TipoUsuario;
import entities.Usuario;
import managedbeans.util.JsfUtil;
import managedbeans.util.JsfUtil.PersistAction;
import sessionbeans.UsuarioFacadeLocal;
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

@Named("usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioFacadeLocal ejbFacade;
    private List<Usuario> items = null;
    private Usuario selected;
    private List<Usuario> allitems = null;
    private List<Usuario> solohabilitados = null;

    public UsuarioController() {
    }

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UsuarioFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Usuario prepareCreate() {
        selected = new Usuario();
        initializeEmbeddableKey();
        return selected;
    }

    public void crearUsuarioyTipo(UsuarioController usuario, TipoUsuarioController tipousuario) {
        String rut = selected.getRut();

        rut = rut.toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        rut = rut.substring(0, rut.length() - 1) + "-" + rut.substring(rut.length() - 1, rut.length());

        selected.setRut(rut);
        selected.setHabilitado(true);
        if (Existrut(rut)) {

            FacesContext context = FacesContext.getCurrentInstance();
            JsfUtil.addErrorMessage("El rut ingresado para el usuario ya existe");
        } else {
            getFacade().CrearUsuario(usuario.getSelected(), tipousuario.getSelected());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage("Se ha creado el nuevo Usuario con exito"));
        }

    }

    public void create() {

        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UsuarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsuarioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UsuarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Usuario> getItems() {

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

                    msg = "Ha ocurrido un error procesando su solicitud.\n Rut repetidos";
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

    public Usuario getUsuario(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Usuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }
    /*Solo quiero los que no esten habilitados*/

    public List<Usuario> getItemsAvailableSelectOne() {
        int i = 0;
        allitems = getFacade().findAll();
        items = new ArrayList<>();
        for (Usuario objetos : allitems) {
            if (objetos.isHabilitado() && objetos.getTipousuario().getRol().equals("ADMIN") == false) {
                items.add(objetos);
            }

            i++;
        }

        return items;
    }

    public List<Usuario> getAllItems() {
        allitems = getFacade().findAll();
        if (allitems == null) {
            allitems = new ArrayList<Usuario>();
        }
        return allitems;
    }

    public boolean Existrut(String rut) {
        getAllItems();//todos los items
        for (Usuario item : allitems) {//para cada item de Preingreso de la bd
            if (rut.equals(item.getRut())) {//si el objeto a comparar es igual al rut de entrada
                return true;//se retorna
            }
        }
        return false;//si no se encuentra retorna nulo
    }

    public Usuario FindUsuariobyRut(String rut) {
        getAllItems();//todos los items
        for (Usuario item : allitems) {//para cada item de Preingreso de la bd
            if (rut.equals(item.getRut())) {//si el objeto a comparar es igual al rut de entrada
                setSelected(item);
                return item;//se retorna
            }
        }
        return null;//si no se encuentra retorna nulo
    }

    public String HabilitadoSTring(boolean habilitado) {
        if (habilitado) {
            return "Habilitado";
        } else {
            return "Deshabilitado";
        }

    }

    @FacesConverter(forClass = Usuario.class)
    public static class UsuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioController controller = (UsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioController");
            return controller.getUsuario(getKey(value));
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
            if (object instanceof Usuario) {
                Usuario o = (Usuario) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Usuario.class.getName()});
                return null;
            }
        }

    }

}
