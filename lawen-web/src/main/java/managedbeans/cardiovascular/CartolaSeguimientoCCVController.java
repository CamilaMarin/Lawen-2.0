package managedbeans.cardiovascular;

import entities.Medicamentos;
import entities.Paciente;
import entities.cardiovascular.CartolaSeguimientoCCV;
import managedbeans.util.JsfUtil;
import managedbeans.util.JsfUtil.PersistAction;
import sessionbeans.cardiovascular.CartolaSeguimientoCCVFacadeLocal;

import java.io.Serializable;
import java.util.ArrayList;
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

@Named("cartolaSeguimientoCCVController")
@SessionScoped
public class CartolaSeguimientoCCVController implements Serializable {

    @EJB
    private CartolaSeguimientoCCVFacadeLocal ejbFacade;
    private List<CartolaSeguimientoCCV> items = null;
    private CartolaSeguimientoCCV selected;
    private List<CartolaSeguimientoCCV> allitems =null;
    @Inject
    private PacienteController pacientecontroller;
    private int edad;
    private boolean diabetes;
    private boolean hipertencion;
    private boolean dislipidemico;
    private boolean IAM;
    private boolean ACV;
    private boolean prediabetes;
    private boolean resistencia_insulina;
    private boolean intolerancia_glucosa;
    private List<Medicamentos> guardar_medicamentos =null;

    public List<Medicamentos> getGuardar_medicamentos() {
        return guardar_medicamentos;
    }

    public void setGuardar_medicamentos(List<Medicamentos> guardar_medicamentos) {
        this.guardar_medicamentos = guardar_medicamentos;
    }

    
    public boolean isResistencia_insulina() {
        return resistencia_insulina;
    }

    public void setResistencia_insulina(boolean resistencia_insulina) {
        this.resistencia_insulina = resistencia_insulina;
    }

    public boolean isIntolerancia_glucosa() {
        return intolerancia_glucosa;
    }

    public void setIntolerancia_glucosa(boolean intolerancia_glucosa) {
        this.intolerancia_glucosa = intolerancia_glucosa;
    }  
    public CartolaSeguimientoCCVFacadeLocal getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(CartolaSeguimientoCCVFacadeLocal ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<CartolaSeguimientoCCV> getAllitems() {
        return allitems;
    }

    public void setAllitems(List<CartolaSeguimientoCCV> allitems) {
        this.allitems = allitems;
    }

    public PacienteController getPacientecontroller() {
        return pacientecontroller;
    }

    public void setPacientecontroller(PacienteController pacientecontroller) {
        this.pacientecontroller = pacientecontroller;
    }

    public boolean isHipertencion() {
        return hipertencion;
    }

    public void setHipertencion(boolean hipertencion) {
        this.hipertencion = hipertencion;
    }

    public boolean isDislipidemico() {
        return dislipidemico;
    }

    public void setDislipidemico(boolean dislipidemico) {
        this.dislipidemico = dislipidemico;
    }

    public boolean isPrediabetes() {
        return prediabetes;
    }

    public void setPrediabetes(boolean prediabetes) {
        this.prediabetes = prediabetes;
    }

 
    
    
    

    public boolean isIAM() {
        return IAM;
    }

    public void setIAM(boolean IAM) {
        this.IAM = IAM;
    }

    public boolean isACV() {
        return ACV;
    }

    public void setACV(boolean ACV) {
        this.ACV = ACV;
    }
    
    
    
    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }
    
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public CartolaSeguimientoCCVController() {
    }
    
    public void handleKeyEvent() {
        //System.out.println(""+getSelected().getPaciente().getFechaNacimiento_paciente());
        try{
           
        if(getSelected().getPaciente().getFechaNacimiento_paciente()==null){
            //System.out.println("nulo");
            
            edad=0;
        }
        else{
        Date date = getSelected().getPaciente().getFechaNacimiento_paciente();
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
      
    public void cambiarDiabetes(){
        
           
        
        diabetes = getSelected().getPaciente().isDiabetico();

     
    }
     public void cambiarHipertencion(){
        hipertencion = getSelected().getPaciente().isHipertencion();
    }
    public void cambiarDislipidemico(){
        
           
        
        dislipidemico = getSelected().getPaciente().isDislipidemico();

     
    }
        public void cambiarPrediabetes(){
        
           
        
        prediabetes = getSelected().getPaciente().isPrediabetes();

     
    }
           
        public void cambiarIntolerancia_glucosa(){
        
           
        
        intolerancia_glucosa = getSelected().getPaciente().isIntolerancia_glucosa();

     
    }        
            public void cambiarResistencia_insulina(){
        
           
        
        resistencia_insulina = getSelected().getPaciente().isResistencia_insulina();

     
    }
    
    public void cambiarIAM(){
        
           
        
        IAM = getSelected().getPaciente().isIAM();

     
    }
    public void cambiarACV(){
        
           
        
        ACV = getSelected().getPaciente().isACV();

     
    }
    
    public int handleICVEvent(Paciente paciente) {
        //System.out.println(""+getSelected().getPaciente().getFechaNacimiento_paciente());
        try{
           
        if(paciente.getFechaNacimiento_paciente()==null){
            //System.out.println("nulo");
            
            return 0;
        }
        else{
            
        ACV = paciente.isACV();
        diabetes = paciente.isDiabetico();
        resistencia_insulina=paciente.isResistencia_insulina();
        intolerancia_glucosa=paciente.isIntolerancia_glucosa();
        dislipidemico = paciente.isDislipidemico();
        hipertencion = paciente.isHipertencion();
        IAM = paciente.isIAM();
        prediabetes=paciente.isPrediabetes();
        
        Date date = paciente.getFechaNacimiento_paciente();
        int edad_cal= pacientecontroller.Age(date);
        if(edad_cal<0)
            return 0;
        return edad_cal;
        //System.out.println("edad quedo como"+edad);
        
        }
        }
        catch(Exception e){
            //System.out.println("error");
            return 0;
        }
        
       
    }
    
    
    
    
    
    public CartolaSeguimientoCCV getSelected() {
        return selected;
    }

    public void setSelected(CartolaSeguimientoCCV selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CartolaSeguimientoCCVFacadeLocal getFacade() {
        return ejbFacade;
    }

    public CartolaSeguimientoCCV prepareCreate() {
        selected = new CartolaSeguimientoCCV();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CartolaSeguimientoCCVCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CartolaSeguimientoCCVUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CartolaSeguimientoCCVDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CartolaSeguimientoCCV> getItems() {
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

    public CartolaSeguimientoCCV getCartolaSeguimientoCCV(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<CartolaSeguimientoCCV> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CartolaSeguimientoCCV> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CartolaSeguimientoCCV.class)
    public static class CartolaSeguimientoCCVControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CartolaSeguimientoCCVController controller = (CartolaSeguimientoCCVController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cartolaSeguimientoCCVController");
            return controller.getCartolaSeguimientoCCV(getKey(value));
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
            if (object instanceof CartolaSeguimientoCCV) {
                CartolaSeguimientoCCV o = (CartolaSeguimientoCCV) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CartolaSeguimientoCCV.class.getName()});
                return null;
            }
        }

    }
    
    
     public List<CartolaSeguimientoCCV> getAllItems(){
    allitems = getFacade().findAll();
    if(allitems==null){
        allitems= new ArrayList<CartolaSeguimientoCCV>();
    }
    return allitems;
    }
    /**
     * 
     * @param rut 
     * @return objeto preingresod1
     * Funcion que busca dentro de todos los items de preingreso el valor que es igual al rut de entrada
     * 
     */
    public CartolaSeguimientoCCV getObjetobyRut(String rut){
        getAllItems();//todos los items
        for(CartolaSeguimientoCCV item: allitems){//para cada item de Preingreso de la bd
            if(rut.equals(item.getPaciente().getRut_paciente())){//si el objeto a comparar es igual al rut de entrada
                setSelected(item);//seleccione ese objeto
                return selected;//se retorna
            }
        }
        return null;//si no se encuentra retorna nulo
    }
    
    
    

}
