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
public class AtencionENFVisitaDom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_visita")
    private Long id;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Usuario profesional_visita;
    
    @JoinColumn(nullable = false)
    @ManyToOne
    private Paciente paciente_visita;
    
    @NotNull(message = "Debe ingresar una Fecha de atención")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaVista;
    
    private Integer edad_paciente;
    @Size(max=1500)
    private String integrantes_grupo_familiar;
    
    /// Carecteristicas de la vivienda
    // Solida - Ligera
    @Size(max=30)
    private String estructura_vivienda;
    private boolean hacinamiento;
    // Adecuado - Contaminado
    @Size(max=30)
    private String condiciones_medio_ambiente;
    private boolean riesgo_accidentes;
    private boolean animales_en_casa;
    @Size(max=500)
    private String obervaciones_vivienda;

    @Size(max=300)
    private String situacion_socioeconomica;
    @Size(max=500)
    private String factores_de_riesgo;
    @Size(max=500)
    private String factores_protectores;
    @Size(max=1500)
    private String observaciones_generales;
    @Size(max=1500)
    private String plan_de_accion;
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getProfesional_visita() {
        return profesional_visita;
    }

    public void setProfesional_visita(Usuario profesional_visita) {
        this.profesional_visita = profesional_visita;
    }

    public Paciente getPaciente_visita() {
        return paciente_visita;
    }

    public void setPaciente_visita(Paciente paciente_visita) {
        this.paciente_visita = paciente_visita;
    }

    public Date getFechaVista() {
        return fechaVista;
    }

    public void setFechaVista(Date fechaVista) {
        this.fechaVista = fechaVista;
    }

    public Integer getEdad_paciente() {
        return edad_paciente;
    }

    public void setEdad_paciente(Integer edad_paciente) {
        this.edad_paciente = edad_paciente;
    }

    public String getIntegrantes_grupo_familiar() {
        return integrantes_grupo_familiar;
    }

    public void setIntegrantes_grupo_familiar(String integrantes_grupo_familiar) {
        this.integrantes_grupo_familiar = integrantes_grupo_familiar;
    }

    public String getEstructura_vivienda() {
        return estructura_vivienda;
    }

    public void setEstructura_vivienda(String estructura_vivienda) {
        this.estructura_vivienda = estructura_vivienda;
    }

    public boolean isHacinamiento() {
        return hacinamiento;
    }

    public void setHacinamiento(boolean hacinamiento) {
        this.hacinamiento = hacinamiento;
    }

    public String getCondiciones_medio_ambiente() {
        return condiciones_medio_ambiente;
    }

    public void setCondiciones_medio_ambiente(String condiciones_medio_ambiente) {
        this.condiciones_medio_ambiente = condiciones_medio_ambiente;
    }

    public boolean isRiesgo_accidentes() {
        return riesgo_accidentes;
    }

    public void setRiesgo_accidentes(boolean riesgo_accidentes) {
        this.riesgo_accidentes = riesgo_accidentes;
    }

    public boolean isAnimales_en_casa() {
        return animales_en_casa;
    }

    public void setAnimales_en_casa(boolean animales_en_casa) {
        this.animales_en_casa = animales_en_casa;
    }

    public String getObervaciones_vivienda() {
        return obervaciones_vivienda;
    }

    public void setObervaciones_vivienda(String obervaciones_vivienda) {
        this.obervaciones_vivienda = obervaciones_vivienda;
    }

    public String getSituacion_socioeconomica() {
        return situacion_socioeconomica;
    }

    public void setSituacion_socioeconomica(String situacion_socioeconomica) {
        this.situacion_socioeconomica = situacion_socioeconomica;
    }

    public String getFactores_de_riesgo() {
        return factores_de_riesgo;
    }

    public void setFactores_de_riesgo(String factores_de_riesgo) {
        this.factores_de_riesgo = factores_de_riesgo;
    }

    public String getFactores_protectores() {
        return factores_protectores;
    }

    public void setFactores_protectores(String factores_protectores) {
        this.factores_protectores = factores_protectores;
    }

    public String getObservaciones_generales() {
        return observaciones_generales;
    }

    public void setObservaciones_generales(String observaciones_generales) {
        this.observaciones_generales = observaciones_generales;
    }

    public String getPlan_de_accion() {
        return plan_de_accion;
    }

    public void setPlan_de_accion(String plan_de_accion) {
        this.plan_de_accion = plan_de_accion;
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
        if (!(object instanceof AtencionENFVisitaDom)) {
            return false;
        }
        AtencionENFVisitaDom other = (AtencionENFVisitaDom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.atenciones.AtencionENFVisitaDom[ id=" + id + " ]";
    }
    
}
