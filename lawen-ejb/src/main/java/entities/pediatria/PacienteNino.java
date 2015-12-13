/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.pediatria;

import java.io.Serializable;
import static javax.persistence.CascadeType.ALL;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Francisco Avello
 */
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"rut_nino"} )})
public class PacienteNino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_nino")
    private Long id;
    
    private String establecimiento_nino;
    private String fichaClinica_nino;
    private String sector_nino;
    
    @NotNull(message = "Debe ingresar un Rut")
    private String rut_nino;
    @NotNull(message = "Debe ingresar un Nombre")
    private String nombres_nino;
    @NotNull(message = "Debe ingresar un Apellido Paterno")
    private String apellidoPaterno_nino;
    @NotNull(message = "Debe ingresar un Apellido Materno")
    private String apellidoMaterno_nino;
    @NotNull(message = "Debe ingresar la Fecha de Nacimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaNacimiento_nino;
    
    private String genero_nino;    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaInscripcion_nino;
    
    private String nombreMadre_nino;
    private Integer edadMadre_nino;
    private String escolaridadMadre_nino;
    private String ocupacionMadre_nino;
    private String sistemaSaludMadre_nino;
    
    private String nombrePadre_nino;
    private Integer edadPadre_nino;
    private String escolaridadPadre_nino;
    private String ocupacionPadre_nino;
    private String sistemaSaludPadre_nino;
    
    private String domicilio_nino;
    private String unidadVecinal_nino;
    private String comuna_nino;
    private String telefono_nino;   
    
    // Datos de Nacimiento
    
    
    
    private Integer edadGestacional_nino;
    private Float peso_nino;
    private Float talla_nino;
    private Float pCraneano_nino;
    private String tipoParto_nino;
    private Integer apgar_nino;
    private String vitDDosis_nino;
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaPeriodo_nino;
    private String antecedentesPerinatales_nino;
    private String estado_paciente_nino;

    public String getEstablecimiento_nino() {
        return establecimiento_nino;
    }

    public void setEstablecimiento_nino(String establecimiento_nino) {
        this.establecimiento_nino = establecimiento_nino;
    }

    public String getFichaClinica_nino() {
        return fichaClinica_nino;
    }

    public void setFichaClinica_nino(String fichaClinica_nino) {
        this.fichaClinica_nino = fichaClinica_nino;
    }

    public String getSector_nino() {
        return sector_nino;
    }

    public void setSector_nino(String sector_nino) {
        this.sector_nino = sector_nino;
    }

    public String getNombres_nino() {
        return nombres_nino;
    }

    public void setNombres_nino(String nombres_nino) {
        this.nombres_nino = nombres_nino;
    }

    public String getApellidoPaterno_nino() {
        return apellidoPaterno_nino;
    }

    public void setApellidoPaterno_nino(String apellidoPaterno_nino) {
        this.apellidoPaterno_nino = apellidoPaterno_nino;
    }

    public String getApellidoMaterno_nino() {
        return apellidoMaterno_nino;
    }

    public void setApellidoMaterno_nino(String apellidoMaterno_nino) {
        this.apellidoMaterno_nino = apellidoMaterno_nino;
    }

    public String getEstado_paciente_nino() {
        return estado_paciente_nino;
    }

    public void setEstado_paciente_nino(String estado_paciente_nino) {
        this.estado_paciente_nino = estado_paciente_nino;
    }

    public String getRut_nino() {
        return rut_nino;
    }

    public void setRut_nino(String rut_nino) {
        this.rut_nino = rut_nino;
    }

    public Date getFechaNacimiento_nino() {
        return fechaNacimiento_nino;
    }

    public void setFechaNacimiento_nino(Date fechaNacimiento_nino) {
        this.fechaNacimiento_nino = fechaNacimiento_nino;
    }

    public String getGenero_nino() {
        return genero_nino;
    }

    public void setGenero_nino(String genero_nino) {
        this.genero_nino = genero_nino;
    }

    public Date getFechaInscripcion_nino() {
        return fechaInscripcion_nino;
    }

    public void setFechaInscripcion_nino(Date fechaInscripcion_nino) {
        this.fechaInscripcion_nino = fechaInscripcion_nino;
    }

    public String getNombreMadre_nino() {
        return nombreMadre_nino;
    }

    public void setNombreMadre_nino(String nombreMadre_nino) {
        this.nombreMadre_nino = nombreMadre_nino;
    }

    public Integer getEdadMadre_nino() {
        return edadMadre_nino;
    }

    public void setEdadMadre_nino(Integer edadMadre_nino) {
        this.edadMadre_nino = edadMadre_nino;
    }

    public String getEscolaridadMadre_nino() {
        return escolaridadMadre_nino;
    }

    public void setEscolaridadMadre_nino(String escolaridadMadre_nino) {
        this.escolaridadMadre_nino = escolaridadMadre_nino;
    }

    public String getOcupacionMadre_nino() {
        return ocupacionMadre_nino;
    }

    public void setOcupacionMadre_nino(String ocupacionMadre_nino) {
        this.ocupacionMadre_nino = ocupacionMadre_nino;
    }

    public String getSistemaSaludMadre_nino() {
        return sistemaSaludMadre_nino;
    }

    public void setSistemaSaludMadre_nino(String sistemaSaludMadre_nino) {
        this.sistemaSaludMadre_nino = sistemaSaludMadre_nino;
    }

    public String getNombrePadre_nino() {
        return nombrePadre_nino;
    }

    public void setNombrePadre_nino(String nombrePadre_nino) {
        this.nombrePadre_nino = nombrePadre_nino;
    }

    public Integer getEdadPadre_nino() {
        return edadPadre_nino;
    }

    public void setEdadPadre_nino(Integer edadPadre_nino) {
        this.edadPadre_nino = edadPadre_nino;
    }

    public String getEscolaridadPadre_nino() {
        return escolaridadPadre_nino;
    }

    public void setEscolaridadPadre_nino(String escolaridadPadre_nino) {
        this.escolaridadPadre_nino = escolaridadPadre_nino;
    }

    public String getOcupacionPadre_nino() {
        return ocupacionPadre_nino;
    }

    public void setOcupacionPadre_nino(String ocupacionPadre_nino) {
        this.ocupacionPadre_nino = ocupacionPadre_nino;
    }

    public String getSistemaSaludPadre_nino() {
        return sistemaSaludPadre_nino;
    }

    public void setSistemaSaludPadre_nino(String sistemaSaludPadre_nino) {
        this.sistemaSaludPadre_nino = sistemaSaludPadre_nino;
    }

    public String getDomicilio_nino() {
        return domicilio_nino;
    }

    public void setDomicilio_nino(String domicilio_nino) {
        this.domicilio_nino = domicilio_nino;
    }

    public String getUnidadVecinal_nino() {
        return unidadVecinal_nino;
    }

    public void setUnidadVecinal_nino(String unidadVecinal_nino) {
        this.unidadVecinal_nino = unidadVecinal_nino;
    }

    public String getComuna_nino() {
        return comuna_nino;
    }

    public void setComuna_nino(String comuna_nino) {
        this.comuna_nino = comuna_nino;
    }

    public String getTelefono_nino() {
        return telefono_nino;
    }

    public void setTelefono_nino(String telefono_nino) {
        this.telefono_nino = telefono_nino;
    }

    public Integer getEdadGestacional_nino() {
        return edadGestacional_nino;
    }

    public void setEdadGestacional_nino(Integer edadGestacional_nino) {
        this.edadGestacional_nino = edadGestacional_nino;
    }

    public Float getPeso_nino() {
        return peso_nino;
    }

    public void setPeso_nino(Float peso_nino) {
        this.peso_nino = peso_nino;
    }

    public Float getTalla_nino() {
        return talla_nino;
    }

    public void setTalla_nino(Float talla_nino) {
        this.talla_nino = talla_nino;
    }

    public Float getpCraneano_nino() {
        return pCraneano_nino;
    }

    public void setpCraneano_nino(Float pCraneano_nino) {
        this.pCraneano_nino = pCraneano_nino;
    }

    public String getTipoParto_nino() {
        return tipoParto_nino;
    }

    public void setTipoParto_nino(String tipoParto_nino) {
        this.tipoParto_nino = tipoParto_nino;
    }

    public Integer getApgar_nino() {
        return apgar_nino;
    }

    public void setApgar_nino(Integer apgar_nino) {
        this.apgar_nino = apgar_nino;
    }

    public String getVitDDosis_nino() {
        return vitDDosis_nino;
    }

    public void setVitDDosis_nino(String vitDDosis_nino) {
        this.vitDDosis_nino = vitDDosis_nino;
    }

    public Date getFechaPeriodo_nino() {
        return fechaPeriodo_nino;
    }

    public void setFechaPeriodo_nino(Date fechaPeriodo_nino) {
        this.fechaPeriodo_nino = fechaPeriodo_nino;
    }

    public String getAntecedentesPerinatales_nino() {
        return antecedentesPerinatales_nino;
    }

    public void setAntecedentesPerinatales_nino(String antecedentesPerinatales_nino) {
        this.antecedentesPerinatales_nino = antecedentesPerinatales_nino;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof PacienteNino)) {
            return false;
        }
        PacienteNino other = (PacienteNino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.pediatria.PacienteNino[ id=" + id + " ]";
    }
    
}
