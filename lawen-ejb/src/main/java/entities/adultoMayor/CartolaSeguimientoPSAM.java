package entities.adultoMayor;

import entities.Paciente;
import entities.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author daniel
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "CartolaSeguimientoPSAM.findAll", query = "SELECT c FROM CartolaSeguimientoPSAM c"),
    @NamedQuery(name = "CartolaSeguimientoPSAM.findbyPaciente", query = "SELECT c FROM CartolaSeguimientoPSAM c WHERE c.paciente=:paciente")

})
public class CartolaSeguimientoPSAM implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_cartolaPsam")
    private Long id;
      @NotNull(message = "Debe ingresar una Fecha de atención")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaAtencion;
    
    // ESFERA CLINCA
    @JoinColumn(nullable = false)
    @ManyToOne
    private Usuario profesional;
    
    @JoinColumn(nullable = false)
    @ManyToOne
    private Paciente paciente;
    
    private Integer edad;
    // Nuevo - Antiguo
    private String antiguedad_programa;
    
    private boolean realiza_actividadFisica;
    
    
    // Mediciones
    // ("ENFLAQUECIDO (BAJO PESO)") (NORMAL) (SOBREPESO) (OBESO)
    private String estado_nutricional;
     
    // ESFERA FUNCIONAL - RIESGO CAIDAS
    
    // (Normal) (Riesgo Leve) (Alto Riesgo)
    // INFORMACIÓN: <10 seg. Normal - 11-19 seg. Riesgo Leve - >20 seg. Alto Riesgo
    private String valoracion_riesgo;
    
    // EFAM
    // ("AUTOVALENTE SIN RIESGO") ("AUTOVALENTE CON RIESGO") ("EN RIESGO DE DEPENDENCIA")
    private String clasificacion_efam;
    ////// FIN EFAM
    
    // BARTHEL
    // (TOTAL) (SEVERO) (MODERADO) (LEVE) (INDEPENDIENTE)
    private String clasificacion_barthel;
    ////// FIN BARTHEL
    

    
    /// ESFERA MENTAL
    
    /// YESAVAGE
    //(NORMAL) (DEPRESIÓN LEVE) (DEPRESIÓN ESTABLECIDA)
    private String clasificacion_yesavage;
    /////////////////////////////// FIN YESAVAGE
    
    /// PFEFFER
    // (NORMAL) (SOSPECHA DE DETERIORO COGNITIVO)
    private String clasificacion_pfeffer;
    /////////////////////////////// FIN PFEFFER
    
    /// MMSE EXTENDIDO O FOLSTEIN
    // opciones pendientes
    private String clasificacion_folstein;
    /////////////////////////////// FIN MMSE EXTENDIDO O FOLSTEIN
    
    private boolean sospecha_maltrato;
    private String sospecha_maltrato_obs;
    
    
    /// ESFERA SOCIAL
    
    private boolean paciente_institucionalizado;

    // NUEVOS ATRIBUTOS CENSO 2015
    
    private String pertenece_al_programa_mas;

    public String getPertenece_al_programa_mas() {
        return pertenece_al_programa_mas;
    }

    public void setPertenece_al_programa_mas(String pertenece_al_programa_mas) {
        this.pertenece_al_programa_mas = pertenece_al_programa_mas;
    }
    
    
    
    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getProfesional() {
        return profesional;
    }

    public void setProfesional(Usuario profesional) {
        this.profesional = profesional;
    }

    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getAntiguedad_programa() {
        return antiguedad_programa;
    }

    public void setAntiguedad_programa(String antiguedad_programa) {
        this.antiguedad_programa = antiguedad_programa;
    }

    public boolean isRealiza_actividadFisica() {
        return realiza_actividadFisica;
    }

    public void setRealiza_actividadFisica(boolean realiza_actividadFisica) {
        this.realiza_actividadFisica = realiza_actividadFisica;
    }

    public String getEstado_nutricional() {
        return estado_nutricional;
    }

    public void setEstado_nutricional(String estado_nutricional) {
        this.estado_nutricional = estado_nutricional;
    }

    public String getValoracion_riesgo() {
        return valoracion_riesgo;
    }

    public void setValoracion_riesgo(String valoracion_riesgo) {
        this.valoracion_riesgo = valoracion_riesgo;
    }

    public String getClasificacion_efam() {
        return clasificacion_efam;
    }

    public void setClasificacion_efam(String clasificacion_efam) {
        this.clasificacion_efam = clasificacion_efam;
    }

    public String getClasificacion_barthel() {
        return clasificacion_barthel;
    }

    public void setClasificacion_barthel(String clasificacion_barthel) {
        this.clasificacion_barthel = clasificacion_barthel;
    }

    public String getClasificacion_yesavage() {
        return clasificacion_yesavage;
    }

    public void setClasificacion_yesavage(String clasificacion_yesavage) {
        this.clasificacion_yesavage = clasificacion_yesavage;
    }

    public String getClasificacion_pfeffer() {
        return clasificacion_pfeffer;
    }

    public void setClasificacion_pfeffer(String clasificacion_pfeffer) {
        this.clasificacion_pfeffer = clasificacion_pfeffer;
    }

    public String getClasificacion_folstein() {
        return clasificacion_folstein;
    }

    public void setClasificacion_folstein(String clasificacion_folstein) {
        this.clasificacion_folstein = clasificacion_folstein;
    }

    public boolean isSospecha_maltrato() {
        return sospecha_maltrato;
    }

    public void setSospecha_maltrato(boolean sospecha_maltrato) {
        this.sospecha_maltrato = sospecha_maltrato;
    }

    public String getSospecha_maltrato_obs() {
        return sospecha_maltrato_obs;
    }

    public void setSospecha_maltrato_obs(String sospecha_maltrato_obs) {
        this.sospecha_maltrato_obs = sospecha_maltrato_obs;
    }

    public boolean isPaciente_institucionalizado() {
        return paciente_institucionalizado;
    }

    public void setPaciente_institucionalizado(boolean paciente_institucionalizado) {
        this.paciente_institucionalizado = paciente_institucionalizado;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartolaSeguimientoPSAM)) {
            return false;
        }
        CartolaSeguimientoPSAM other = (CartolaSeguimientoPSAM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.adultoMayor.CartolaSeguimientoPSAM[ id=" + id + " ]";
    }
    
}
