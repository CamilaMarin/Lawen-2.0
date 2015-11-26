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
public class AtencionGeneralAPSE implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_apse")
    private Long id;
    
    

    @JoinColumn(nullable = false)
    @ManyToOne
    private Usuario profesional_apse;
    
 
    @ManyToOne
    private Paciente paciente_apse;
    
    @NotNull(message = "Debe ingresar una Fecha de atención")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaAtencion;
    
    @Size(max=50)
    private String nombreApse;
    @Size(max=1000)
    private String descipcionApse;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getProfesional_apse() {
        return profesional_apse;
    }

    public void setProfesional_apse(Usuario profesional_apse) {
        this.profesional_apse = profesional_apse;
    }

    public Paciente getPaciente_apse() {
        return paciente_apse;
    }

    public void setPaciente_apse(Paciente paciente_apse) {
        this.paciente_apse = paciente_apse;
    }

    

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getNombreApse() {
        return nombreApse;
    }

    public void setNombreApse(String nombreApse) {
        this.nombreApse = nombreApse;
    }

    public String getDescipcionApse() {
        return descipcionApse;
    }

    public void setDescipcionApse(String descipcionApse) {
        this.descipcionApse = descipcionApse;
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
        if (!(object instanceof AtencionGeneralAPSE)) {
            return false;
        }
        AtencionGeneralAPSE other = (AtencionGeneralAPSE) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.atenciones.AtencionGeneralAPSE[ id=" + id + " ]";
    }
    
}
