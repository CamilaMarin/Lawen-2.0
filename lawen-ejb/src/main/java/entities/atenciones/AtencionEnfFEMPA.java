/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.atenciones;

import entities.Paciente;
import entities.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author daniel
 */
@Entity
public class AtencionEnfFEMPA implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_empa")
    private Long id;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Usuario profesional_empa;
    
    @JoinColumn(nullable = false)
    @ManyToOne
    private Paciente paciente_empa;
    
    @NotNull(message = "Debe ingresar una Fecha de atención")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaEmpa;
    
    private Integer edad_paciente_emp;
    
    // Item 1: Ambos generos de 15 a 64 años 
    
    private float peso_emp;
    private float talla_emp;
    private float imc_emp;
    private Integer presion_aterial1_emp;
    private Integer presion_aterial2_emp;
    private Integer puntaje_audit;
    private boolean bebedor_problema;
    private boolean tabaquismo;
    
    // DM2 
    private Integer valor_glicemia;
    @Size(max=150)
    private String indicacion_glicemia;
    // DLP
    private Integer valor_colesterol_total;
    @Size(max=150)
    private String indicacion_colesterol;
    
    // Sintomas respiratorios
    
    private boolean baciloscopia;
    private Integer escala_abreviada_deteccion_depresion;
    private Integer pauta_alimentacion_saludable;
    @Size(max=1500)
    private String indicaciones_referencias;
    
    // Item 2: Solo mujeres.
    
    // Sección A: 24 a 64 años - Cancer cervicouterino
    @Size(max=30)
    private String pap; // Se solicita - Pendiente - Negativo - Positivo
    @Size(max=200)
    private String pap_observaciones;
    
    // Seccion B: 15 a 50 años - Cancer de mamas
    @Size(max=200)
    private String examen_fisico_mamas; 
    @Size(max=30)
    private String mamografia; //Se solicita - Pendiente - Negativo - Positivo
    @Size(max=200)
    private String mamografia_observaciones;
    
    // Seccion C: Embarazadas
    private boolean VDRL;
    @Size(max=50)
    private String VDRL_obs;
    private boolean test_ELISA;
    
    
    ////
    
    @Size(max=1500)
    private String indicaciones_referencias2;
    
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getProfesional_empa() {
        return profesional_empa;
    }

    public void setProfesional_empa(Usuario profesional_empa) {
        this.profesional_empa = profesional_empa;
    }

    public Paciente getPaciente_empa() {
        return paciente_empa;
    }

    public void setPaciente_empa(Paciente paciente_empa) {
        this.paciente_empa = paciente_empa;
    }

    public Date getFechaEmpa() {
        return fechaEmpa;
    }

    public void setFechaEmpa(Date fechaEmpa) {
        this.fechaEmpa = fechaEmpa;
    }

    public Integer getEdad_paciente_emp() {
        return edad_paciente_emp;
    }

    public void setEdad_paciente_emp(Integer edad_paciente_emp) {
        this.edad_paciente_emp = edad_paciente_emp;
    }

    public float getPeso_emp() {
        return peso_emp;
    }

    public void setPeso_emp(float peso_emp) {
        this.peso_emp = peso_emp;
    }

    public float getTalla_emp() {
        return talla_emp;
    }

    public void setTalla_emp(float talla_emp) {
        this.talla_emp = talla_emp;
    }

    public float getImc_emp() {
        return imc_emp;
    }

    public void setImc_emp(float imc_emp) {
        this.imc_emp = imc_emp;
    }

    public Integer getPresion_aterial1_emp() {
        return presion_aterial1_emp;
    }

    public void setPresion_aterial1_emp(Integer presion_aterial1_emp) {
        this.presion_aterial1_emp = presion_aterial1_emp;
    }

    public Integer getPresion_aterial2_emp() {
        return presion_aterial2_emp;
    }

    public void setPresion_aterial2_emp(Integer presion_aterial2_emp) {
        this.presion_aterial2_emp = presion_aterial2_emp;
    }

    public Integer getPuntaje_audit() {
        return puntaje_audit;
    }

    public void setPuntaje_audit(Integer puntaje_audit) {
        this.puntaje_audit = puntaje_audit;
    }

    public boolean isBebedor_problema() {
        return bebedor_problema;
    }

    public void setBebedor_problema(boolean bebedor_problema) {
        this.bebedor_problema = bebedor_problema;
    }

    public boolean isTabaquismo() {
        return tabaquismo;
    }

    public void setTabaquismo(boolean tabaquismo) {
        this.tabaquismo = tabaquismo;
    }

    public Integer getValor_glicemia() {
        return valor_glicemia;
    }

    public void setValor_glicemia(Integer valor_glicemia) {
        this.valor_glicemia = valor_glicemia;
    }

    public String getIndicacion_glicemia() {
        return indicacion_glicemia;
    }

    public void setIndicacion_glicemia(String indicacion_glicemia) {
        this.indicacion_glicemia = indicacion_glicemia;
    }

    public Integer getValor_colesterol_total() {
        return valor_colesterol_total;
    }

    public void setValor_colesterol_total(Integer valor_colesterol_total) {
        this.valor_colesterol_total = valor_colesterol_total;
    }

    public String getIndicacion_colesterol() {
        return indicacion_colesterol;
    }

    public void setIndicacion_colesterol(String indicacion_colesterol) {
        this.indicacion_colesterol = indicacion_colesterol;
    }

    public boolean isBaciloscopia() {
        return baciloscopia;
    }

    public void setBaciloscopia(boolean baciloscopia) {
        this.baciloscopia = baciloscopia;
    }

    public Integer getEscala_abreviada_deteccion_depresion() {
        return escala_abreviada_deteccion_depresion;
    }

    public void setEscala_abreviada_deteccion_depresion(Integer escala_abreviada_deteccion_depresion) {
        this.escala_abreviada_deteccion_depresion = escala_abreviada_deteccion_depresion;
    }

    public Integer getPauta_alimentacion_saludable() {
        return pauta_alimentacion_saludable;
    }

    public void setPauta_alimentacion_saludable(Integer pauta_alimentacion_saludable) {
        this.pauta_alimentacion_saludable = pauta_alimentacion_saludable;
    }

    public String getIndicaciones_referencias() {
        return indicaciones_referencias;
    }

    public void setIndicaciones_referencias(String indicaciones_referencias) {
        this.indicaciones_referencias = indicaciones_referencias;
    }

    public String getPap() {
        return pap;
    }

    public void setPap(String pap) {
        this.pap = pap;
    }

    public String getPap_observaciones() {
        return pap_observaciones;
    }

    public void setPap_observaciones(String pap_observaciones) {
        this.pap_observaciones = pap_observaciones;
    }

    public String getExamen_fisico_mamas() {
        return examen_fisico_mamas;
    }

    public void setExamen_fisico_mamas(String examen_fisico_mamas) {
        this.examen_fisico_mamas = examen_fisico_mamas;
    }

    public String getMamografia() {
        return mamografia;
    }

    public void setMamografia(String mamografia) {
        this.mamografia = mamografia;
    }

    public String getMamografia_observaciones() {
        return mamografia_observaciones;
    }

    public void setMamografia_observaciones(String mamografia_observaciones) {
        this.mamografia_observaciones = mamografia_observaciones;
    }

    public boolean isVDRL() {
        return VDRL;
    }

    public void setVDRL(boolean VDRL) {
        this.VDRL = VDRL;
    }

    public String getVDRL_obs() {
        return VDRL_obs;
    }

    public void setVDRL_obs(String VDRL_obs) {
        this.VDRL_obs = VDRL_obs;
    }

    public boolean isTest_ELISA() {
        return test_ELISA;
    }

    public void setTest_ELISA(boolean test_ELISA) {
        this.test_ELISA = test_ELISA;
    }

    public String getIndicaciones_referencias2() {
        return indicaciones_referencias2;
    }

    public void setIndicaciones_referencias2(String indicaciones_referencias2) {
        this.indicaciones_referencias2 = indicaciones_referencias2;
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
        if (!(object instanceof AtencionEnfFEMPA)) {
            return false;
        }
        AtencionEnfFEMPA other = (AtencionEnfFEMPA) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.atenciones.AtencionEnfFEMPA[ id=" + id + " ]";
    }
    
}
