/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.cardiovascular;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 *
 * @author daniel
 */
@Entity
public class FichaEnfermero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_fichaenfermero")
    private Long id;

    @Size(max=2000)
    private String anamnesis_enfermero;
    @Size(max=1500)
    private String descripcion_alimentacion;
    
    // Sintomatologia
    private boolean polifagia;
    private boolean polidipsia;
    private boolean poliuria;
    private boolean cefalea;
    private boolean mareos;
    private boolean tinitus;
    private boolean fotopsia;
    private String otros_sintomatologia;
    /////////
    private String examenDelPie_dm;
    
    // Pulsos pedios
    private boolean pulsosPedios_pieIzquierdo;
    private boolean pulsosPedios_pieDerecho;
    // Pulsos tibiales
    private boolean pulsosTibiales_pieIzquierdo;
    private boolean pulsosTibiales_pieDerecho;
    //////
   
    @Size(max=1500)
    private String educacion;
    private boolean entregaMeterial_educativo;
    @Size(max=1500)
    private String otrasIndicaciones;
    @Size(max=1500)
    private String referencias;
       
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

    public String getAnamnesis_enfermero() {
        return anamnesis_enfermero;
    }

    public void setAnamnesis_enfermero(String anamnesis_enfermero) {
        this.anamnesis_enfermero = anamnesis_enfermero;
    }

    public String getDescripcion_alimentacion() {
        return descripcion_alimentacion;
    }

    public void setDescripcion_alimentacion(String descripcion_alimentacion) {
        this.descripcion_alimentacion = descripcion_alimentacion;
    }

    public boolean isPolifagia() {
        return polifagia;
    }

    public void setPolifagia(boolean polifagia) {
        this.polifagia = polifagia;
    }

    public boolean isPolidipsia() {
        return polidipsia;
    }

    public void setPolidipsia(boolean polidipsia) {
        this.polidipsia = polidipsia;
    }

    public boolean isPoliuria() {
        return poliuria;
    }

    public void setPoliuria(boolean poliuria) {
        this.poliuria = poliuria;
    }

    public boolean isCefalea() {
        return cefalea;
    }

    public void setCefalea(boolean cefalea) {
        this.cefalea = cefalea;
    }

    public boolean isMareos() {
        return mareos;
    }

    public void setMareos(boolean mareos) {
        this.mareos = mareos;
    }

    public boolean isTinitus() {
        return tinitus;
    }

    public void setTinitus(boolean tinitus) {
        this.tinitus = tinitus;
    }

    public boolean isFotopsia() {
        return fotopsia;
    }

    public void setFotopsia(boolean fotopsia) {
        this.fotopsia = fotopsia;
    }

    public String getOtros_sintomatologia() {
        return otros_sintomatologia;
    }

    public void setOtros_sintomatologia(String otros_sintomatologia) {
        this.otros_sintomatologia = otros_sintomatologia;
    }

    public String getExamenDelPie_dm() {
        return examenDelPie_dm;
    }

    public void setExamenDelPie_dm(String examenDelPie_dm) {
        this.examenDelPie_dm = examenDelPie_dm;
    }

    public boolean isPulsosPedios_pieIzquierdo() {
        return pulsosPedios_pieIzquierdo;
    }

    public void setPulsosPedios_pieIzquierdo(boolean pulsosPedios_pieIzquierdo) {
        this.pulsosPedios_pieIzquierdo = pulsosPedios_pieIzquierdo;
    }

    public boolean isPulsosPedios_pieDerecho() {
        return pulsosPedios_pieDerecho;
    }

    public void setPulsosPedios_pieDerecho(boolean pulsosPedios_pieDerecho) {
        this.pulsosPedios_pieDerecho = pulsosPedios_pieDerecho;
    }

    public boolean isPulsosTibiales_pieIzquierdo() {
        return pulsosTibiales_pieIzquierdo;
    }

    public void setPulsosTibiales_pieIzquierdo(boolean pulsosTibiales_pieIzquierdo) {
        this.pulsosTibiales_pieIzquierdo = pulsosTibiales_pieIzquierdo;
    }

    public boolean isPulsosTibiales_pieDerecho() {
        return pulsosTibiales_pieDerecho;
    }

    public void setPulsosTibiales_pieDerecho(boolean pulsosTibiales_pieDerecho) {
        this.pulsosTibiales_pieDerecho = pulsosTibiales_pieDerecho;
    }

    public String getEducacion() {
        return educacion;
    }

    public void setEducacion(String educacion) {
        this.educacion = educacion;
    }

    public boolean isEntregaMeterial_educativo() {
        return entregaMeterial_educativo;
    }

    public void setEntregaMeterial_educativo(boolean entregaMeterial_educativo) {
        this.entregaMeterial_educativo = entregaMeterial_educativo;
    }

    public String getOtrasIndicaciones() {
        return otrasIndicaciones;
    }

    public void setOtrasIndicaciones(String otrasIndicaciones) {
        this.otrasIndicaciones = otrasIndicaciones;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaEnfermero)) {
            return false;
        }
        FichaEnfermero other = (FichaEnfermero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.cardiovascular.fichaEnfermero[ id=" + id + " ]";
    }
    
}
