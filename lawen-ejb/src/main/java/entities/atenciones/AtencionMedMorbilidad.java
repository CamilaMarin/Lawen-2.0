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
public class AtencionMedMorbilidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_morbilidad")
    private Long id;
    
    @NotNull(message = "Debe ingresar una Fecha de atención")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaAtencion_morb;
    
    @JoinColumn(nullable = false)
    @ManyToOne
    private Usuario profesional_morb;
    
    @JoinColumn(nullable = false) 
    @ManyToOne
    private Paciente paciente_mrb;
    
    private int edadMorb;
    @Size(max=1000)
    private String anamnesis_morb;
    

    
    // Signos vitales
    private Integer presion_arterial1;
    private Integer presion_arterial2;
    private Integer frecuencia_cardiaca;
    private Float temperatura;
    private Integer frecuencia_respiratoria;
    private Integer dolor;
    private Integer saturacion_oxigeno;
    
    // medidas antropometricas
    
    private Float peso_morb;
    private Float talla_morb;
    private Float imc_morb;
     @Size(max=50)
    private String diagnostico_nutricional_mrb;
    
    //
    
    @Size(max=500)
    private String examen_fisico;
    @Size(max=50)
    private String hipotesis_diagnostiva;
    @Size(max=50)
    private String diagnostivo_mrb;
    @Size(max=500)
    private String indicaciones;
    @Size(max=1000)
    private String tratamiento_famacologico;
    @Size(max=1500)
    private String examenes;
    @Size(max=1000)
    private String referencias_mrb;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaAtencion_morb() {
        return fechaAtencion_morb;
    }

    public void setFechaAtencion_morb(Date fechaAtencion_morb) {
        this.fechaAtencion_morb = fechaAtencion_morb;
    }

    public Usuario getProfesional_morb() {
        return profesional_morb;
    }

    public void setProfesional_morb(Usuario profesional_morb) {
        this.profesional_morb = profesional_morb;
    }

    public Paciente getPaciente_mrb() {
        return paciente_mrb;
    }

    public void setPaciente_mrb(Paciente paciente_mrb) {
        this.paciente_mrb = paciente_mrb;
    }

    

    public int getEdadMorb() {
        return edadMorb;
    }

    public void setEdadMorb(int edadMorb) {
        this.edadMorb = edadMorb;
    }

    public String getAnamnesis_morb() {
        return anamnesis_morb;
    }

    public void setAnamnesis_morb(String anamnesis_morb) {
        this.anamnesis_morb = anamnesis_morb;
    }

    public Integer getPresion_arterial1() {
        return presion_arterial1;
    }

    public void setPresion_arterial1(Integer presion_arterial1) {
        this.presion_arterial1 = presion_arterial1;
    }

    public Integer getPresion_arterial2() {
        return presion_arterial2;
    }

    public void setPresion_arterial2(Integer presion_arterial2) {
        this.presion_arterial2 = presion_arterial2;
    }

    public Integer getFrecuencia_cardiaca() {
        return frecuencia_cardiaca;
    }

    public void setFrecuencia_cardiaca(Integer frecuencia_cardiaca) {
        this.frecuencia_cardiaca = frecuencia_cardiaca;
    }

    public Float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Float temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getFrecuencia_respiratoria() {
        return frecuencia_respiratoria;
    }

    public void setFrecuencia_respiratoria(Integer frecuencia_respiratoria) {
        this.frecuencia_respiratoria = frecuencia_respiratoria;
    }

    public Integer getDolor() {
        return dolor;
    }

    public void setDolor(Integer dolor) {
        this.dolor = dolor;
    }

    public Integer getSaturacion_oxigeno() {
        return saturacion_oxigeno;
    }

    public void setSaturacion_oxigeno(Integer saturacion_oxigeno) {
        this.saturacion_oxigeno = saturacion_oxigeno;
    }

    public Float getPeso_morb() {
        return peso_morb;
    }

    public void setPeso_morb(Float peso_morb) {
        this.peso_morb = peso_morb;
    }

    public Float getTalla_morb() {
        return talla_morb;
    }

    public void setTalla_morb(Float talla_morb) {
        this.talla_morb = talla_morb;
    }

    public Float getImc_morb() {
        return imc_morb;
    }

    public void setImc_morb(Float imc_morb) {
        this.imc_morb = imc_morb;
    }

    public String getDiagnostico_nutricional_mrb() {
        return diagnostico_nutricional_mrb;
    }

    public void setDiagnostico_nutricional_mrb(String diagnostico_nutricional_mrb) {
        this.diagnostico_nutricional_mrb = diagnostico_nutricional_mrb;
    }

    public String getExamen_fisico() {
        return examen_fisico;
    }

    public void setExamen_fisico(String examen_fisico) {
        this.examen_fisico = examen_fisico;
    }

    public String getHipotesis_diagnostiva() {
        return hipotesis_diagnostiva;
    }

    public void setHipotesis_diagnostiva(String hipotesis_diagnostiva) {
        this.hipotesis_diagnostiva = hipotesis_diagnostiva;
    }

    public String getDiagnostivo_mrb() {
        return diagnostivo_mrb;
    }

    public void setDiagnostivo_mrb(String diagnostivo_mrb) {
        this.diagnostivo_mrb = diagnostivo_mrb;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public String getTratamiento_famacologico() {
        return tratamiento_famacologico;
    }

    public void setTratamiento_famacologico(String tratamiento_famacologico) {
        this.tratamiento_famacologico = tratamiento_famacologico;
    }

    public String getExamenes() {
        return examenes;
    }

    public void setExamenes(String examenes) {
        this.examenes = examenes;
    }

    public String getReferencias_mrb() {
        return referencias_mrb;
    }

    public void setReferencias_mrb(String referencias_mrb) {
        this.referencias_mrb = referencias_mrb;
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
        if (!(object instanceof AtencionMedMorbilidad)) {
            return false;
        }
        AtencionMedMorbilidad other = (AtencionMedMorbilidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.atenciones.AtencionMedMorbilidad[ id=" + id + " ]";
    }
    
}
