package managedbeans;

import com.itextpdf.text.pdf.BaseFont;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import entities.Paciente;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import managedbeans.util.JsfUtil;
import managedbeans.util.JsfUtil.PersistAction;
import sessionbeans.PacienteFacadeLocal;
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
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.joda.time.LocalDate;
import org.joda.time.Years;

@Named("pacienteController")
@SessionScoped
public class PacienteController implements Serializable {

    @EJB
    private PacienteFacadeLocal ejbFacade;
    private List<Paciente> items = null;
    private Paciente selected;
    private List<Paciente> allitems = null;
    @Inject
    private UtilidadesController ut;

    public PacienteController() {
    }

    /**
     *
     * @return objeto Paciente
     */
    public Paciente getSelected() {
        return selected;
    }

    /**
     *
     * @param selected setea el objeto Paciente
     */
    public void setSelected(Paciente selected) {
        this.selected = selected;
    }

    /**
     *
     */
    protected void setEmbeddableKeys() {
    }

    /**
     *
     */
    protected void initializeEmbeddableKey() {
    }

    /**
     * Comunica el managed bean con el session obteniendo el ejbFacade
     *
     * @return objeto Facade
     */
    private PacienteFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<Paciente> getAllItems() {
        allitems = getFacade().findAll();
        if (allitems == null) {
            allitems = new ArrayList<Paciente>();
        }
        return allitems;
    }

    public Paciente FindObjetbyRut(String rut) {
        getAllItems();//todos los items
        for (Paciente item : allitems) {//para cada item de Preingreso de la bd
            if (rut.equals(item.getRut_paciente())) {//si el objeto a comparar es igual al rut de entrada
                setSelected(item);//seleccione ese objeto
                return selected;//se retorna
            }
        }
        return null;//si no se encuentra retorna nulo
    }

    public boolean isActivo(Paciente paciente) {
        try {

            if (paciente.getEstado().equals("Activo")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;

        }
    }

    public boolean isExistPaciente(Paciente paciente) {
        try {
            getAllItems();//todos los items
            for (Paciente item : allitems) {//para cada item de Preingreso de la bd
                if (paciente.getId() == item.getId()) {//si el objeto a comparar es igual al rut de entrada
                    return true;//se retorna
                }
            }
            return false;
        } catch (Exception e) {
            return false;

        }

    }

    public int Age(Date date) {
        try {
            LocalDate birthdate = new LocalDate(date);
            LocalDate now = new LocalDate();
            Years age = Years.yearsBetween(birthdate, now);
            int valor = age.getYears();

            return valor;
        } catch (Exception e) {
            return 0;
        }

    }
    /*
     Se prepara para crear los objetos para posterior insercion
     */

    public Paciente prepareCreate() {
        selected = new Paciente();
        initializeEmbeddableKey();
        return selected;
    }
    /*
    
     */

    public void create() {
        String rut = selected.getRut_paciente();
        rut = rut.toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");

        rut = rut.substring(0, rut.length() - 1) + "-" + rut.substring(rut.length() - 1, rut.length());
        selected.setEstado("Activo");
        selected.setRut_paciente(rut);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PacienteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalida la lista para gatillar re-query
        }
        selected = null;
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        final Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.LETTER);
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "lawen-logo-pdf.png";
        Image imagen;
        imagen = Image.getInstance(logo);
        imagen.setAlignment(Image.RIGHT);
        imagen.setCompressionLevel(0);
        imagen.scaleAbsolute(117, 40);
        pdf.addTitle("Ficha electrónica");
        pdf.add(imagen);

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        String url = request.getRequestURI().toString();
        Paragraph paragraph = new Paragraph();
        paragraph.setSpacingAfter(15);
        Color naranjo = new Color(255, 102, 0);
        Font f = new Font(BaseFont.ASCENT, 25.0f, Font.UNDERLINE, naranjo);
        paragraph.setFont(f);
        paragraph.add("Ficha paciente:");
        pdf.add(paragraph);
        paragraph = new Paragraph();
        paragraph.add("\n\n");
        if (selected != null) {
            paragraph.add("RUT:  ");
            paragraph.add(selected.getRut_paciente() + "\n");
            paragraph.add("Nombre:  ");
            paragraph.add(selected.getNombres_paciente() + "\n");
            paragraph.add("Apellidos:  ");
            paragraph.add(selected.getApellidoPaterno_paciente() + " " + selected.getApellidoMaterno_paciente() + "\n");
            paragraph.add("Fecha de naciemiento:  ");
            paragraph.add(selected.getFechaNacimiento_paciente() + "\n");
            paragraph.add("Género:  ");
            paragraph.add(selected.getGenero_paciente() + "\n");
            paragraph.add("e-mail:  ");
            paragraph.add(selected.getEmail_paciente() + "\n");
            paragraph.add("Dirección:  ");
            paragraph.add(selected.getDireccion_paciente() + "\n");
            paragraph.add("Nacionalidad:  ");
            paragraph.add(selected.getNacionalidad_paciente() + "\n");
            paragraph.add("Etnia?:  ");
            paragraph.add(ut.booleanos(selected.isEtnia()) + "\n");
            paragraph.add("Etnia:  ");
            paragraph.add(selected.getEtnia_paciente() + "\n");
            paragraph.add("Ocupación:  ");
            paragraph.add(selected.getOcupacion_paciente() + "\n");
            paragraph.add("Telefono 1:  ");
            paragraph.add(selected.getTelefono1() + "\n");
            paragraph.add("Telefono 2:  ");
            paragraph.add(selected.getTelefono2() + "\n");
            paragraph.add("Estado Civil:  ");
            paragraph.add(selected.getEstadoCivil_paciente() + "\n");
            paragraph.add("Estudios:  ");
            paragraph.add(selected.getEscolaridad_paciente() + "\n");
            paragraph.add("Sector:  ");
            paragraph.add(selected.getSector_paciente() + "\n");
            paragraph.add("Previsión:  ");
            paragraph.add(selected.getPrevision_paciente() + "\n");
            paragraph.add("Fecha inscripción:  ");
            if (selected.getFechaInscripcion_paciente() != null) {
                paragraph.add(selected.getFechaInscripcion_paciente() + "\n");
            } else {
                paragraph.add("No registrado\n");
            }
            paragraph.add("Número ficha:  ");
            paragraph.add(selected.getNumeroFicha_paciente() + "\n");
            paragraph.add("Número registro:  ");
            paragraph.add(selected.getNumeroRegistro_paciente() + "\n");
            paragraph.add("Alcohol:  ");
            paragraph.add(ut.booleanos(selected.isAlcohol_paciente()) + "\n");
            paragraph.add("Tabaco:  ");
            paragraph.add(selected.getTabaco_paciente() + "\n");
            paragraph.add("Drogas:  ");
            paragraph.add(ut.booleanos(selected.isDrogas_paciente()) + "\n");
            paragraph.add("Hospitalizaciones:  ");
            paragraph.add(selected.getHospitalizaciones_paciente() + "\n");
            paragraph.add("Alergias:  ");
            paragraph.add(selected.getAlergias_paciente() + "\n");
            paragraph.add("Antecedentes Quirúrjicos:  ");
            paragraph.add(selected.getAnteQuirurjicos_paciente() + "\n");
            paragraph.add("Antecedentes Obstétricos:  ");
            paragraph.add(selected.getAnteObstetricos_paciente() + "\n");
            paragraph.add("Actividad Física:  ");
            paragraph.add(selected.getActividadFisica_paciente() + "\n");
            paragraph.add("Patologías Crónicas\n");

            paragraph.add("Hipertensión:  ");
            paragraph.add(ut.booleanos(selected.isHipertencion()) + "\n");
            paragraph.add("Diabético:  ");
            paragraph.add(ut.booleanos(selected.isDiabetico()) + "\n");
            paragraph.add("Dislipidemico:  ");
            paragraph.add(ut.booleanos(selected.isDislipidemico()) + "\n");
            paragraph.add("Pre-diabético:  ");
            paragraph.add(ut.booleanos(selected.isPrediabetes()) + "\n");
            paragraph.add("Resistencia a la Insulina:  ");
            paragraph.add(ut.booleanos(selected.isResistencia_insulina()) + "\n");
            paragraph.add("Intolerancia a la Glucosa:  ");
            paragraph.add(ut.booleanos(selected.isIntolerancia_glucosa())+ "\n");
            paragraph.add("Antecedentes\n");
            paragraph.add("De infarto:  ");
            paragraph.add(ut.booleanos(selected.isIAM()) + "\n");
            paragraph.add("De enfermedad cerebro vascular:  ");
            paragraph.add(ut.booleanos(selected.isACV()) + "\n");

        }

        paragraph.setAlignment(Element.ALIGN_LEFT);
        pdf.add(paragraph);

    }

    public void cancel() {

        selected = null;
    }
    /*
     Actualiza el objeto y lo persiste
     */

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PacienteUpdated"));
        selected = null;
    }

    public void updateInICV() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PacienteUpdated"));

    }
    /*
     delete objeto selected
     */

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PacienteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remueve la seleccion
            items = null;    // Invalida la lista para gatillar re-query
        }
    }

    /**
     * *
     * retorna los items
     *
     * @return lista de pacientes para consultas
     */
    public List<Paciente> getItems() {

        items = getFacade().findAll();

        return items;
    }

    /**
     * *
     *
     * @param persistAction
     * @param successMessage
     */
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

    /**
     *
     * @param id
     * @return
     */
    public Paciente getPaciente(java.lang.Long id) {
        return getFacade().find(id);
    }

    /**
     *
     * @return
     */
    public List<Paciente> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    /**
     *
     * @return
     */
    public List<Paciente> getItemsAvailableSelectOne() {
       
        return getFacade().findbyPacienteActivo();
    }
    
    
    
       public List<Paciente> getItemsAvailableSelectOnebyGenero() {
        return getFacade().findByGenero("Femenino");
    }

    /**
     * *
     * Clase converter para Paciente Codigo autogenerado
     */
    @FacesConverter(forClass = Paciente.class)
    public static class PacienteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PacienteController controller = (PacienteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pacienteController");
            return controller.getPaciente(getKey(value));
        }

        /**
         *
         * @param value
         * @return
         */
        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        /**
         *
         * @param value
         * @return
         */
        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        /**
         * *
         *
         * @param facesContext
         * @param component
         * @param object
         * @return
         */
        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Paciente) {
                Paciente o = (Paciente) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Paciente.class.getName()});
                return null;
            }
        }

    }

}
