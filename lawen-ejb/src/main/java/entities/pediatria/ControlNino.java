/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.pediatria;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Francisco Avello
 */
@Entity
@NamedQueries({
      @NamedQuery(name = "ControlNino.findbyCartola", query = "SELECT c FROM ControlNino c WHERE c.cartolaControlesNino.id = :cartola_id"),
      @NamedQuery(name = "ControlNino.findLastControl", query = "SELECT c FROM ControlNino c WHERE c.cartolaControlesNino.id = :cartola_id ORDER BY c.id DESC")
})
public class ControlNino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String identificadorControl;
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaControl;
    private String controlReevaluacion;
    @NotNull(message = "Debe ingresar la Edad en meses")
    private Integer edadControl;
        private Float pesoControl;
        private Float tallaControl;
        private Integer circunferenciaCranealControl;
        private String pesoEdadControl;
        private String pesoTallaControl;
        private String tallaEdadControl;
        private String desarrolloPsicomotorControl;
        private String alimentacionRecibeControl;
        private String estadoNutricionalControl;
        private String riesgoMalnutricion;
        @Temporal(javax.persistence.TemporalType.DATE)
        private java.util.Date fechaIngresoEstmulacionControl;
        @Temporal(javax.persistence.TemporalType.DATE)
        private java.util.Date fechaEgresoEstmulacionControl;
        private Boolean figuraPaternaControl;
        private String examinadorControl;
        @Temporal(javax.persistence.TemporalType.DATE)
        private java.util.Date fechaProximaCitacionControl; 
        private String presionArterialControl;
        private String controlIRAControl;
        private String visitaDomiciliaria;
        private String tallerNadiePerfecto;
        private String entregaMaterialesEstimulacionControl;
        private String examinadorProximoControl;

    public String getRiesgoMalnutricion() {
        return riesgoMalnutricion;
    }

    public void setRiesgoMalnutricion(String riesgoMalnutricion) {
        this.riesgoMalnutricion = riesgoMalnutricion;
    }    
        
    public String getIdentificadorControl() {
        return identificadorControl;
    }

    public void setIdentificadorControl(String identificadorControl) {
        this.identificadorControl = identificadorControl;
    }        
        
    public String getExaminadorProximoControl() {
        return examinadorProximoControl;
    }

    public void setExaminadorProximoControl(String examinadorProximoControl) {
        this.examinadorProximoControl = examinadorProximoControl;
    }    

    public Date getFechaControl() {
        return fechaControl;
    }

    public void setFechaControl(Date fechaControl) {
        this.fechaControl = fechaControl;
    }    
        
    public String getControlReevaluacion() {
        return controlReevaluacion;
    }

    public void setControlReevaluacion(String controlReevaluacion) {
        this.controlReevaluacion = controlReevaluacion;
    }

    public String getPresionArterialControl() {
        return presionArterialControl;
    }

    public void setPresionArterialControl(String presionArterialControl) {
        this.presionArterialControl = presionArterialControl;
    }

    public String getControlIRAControl() {
        return controlIRAControl;
    }

    public void setControlIRAControl(String controlIRAControl) {
        this.controlIRAControl = controlIRAControl;
    }

    public String getVisitaDomiciliaria() {
        return visitaDomiciliaria;
    }

    public void setVisitaDomiciliaria(String visitaDomiciliaria) {
        this.visitaDomiciliaria = visitaDomiciliaria;
    }

    public String getTallerNadiePerfecto() {
        return tallerNadiePerfecto;
    }

    public void setTallerNadiePerfecto(String tallerNadiePerfecto) {
        this.tallerNadiePerfecto = tallerNadiePerfecto;
    }

    public String getEntregaMaterialesEstimulacionControl() {
        return entregaMaterialesEstimulacionControl;
    }

    public void setEntregaMaterialesEstimulacionControl(String entregaMaterialesEstimulacionControl) {
        this.entregaMaterialesEstimulacionControl = entregaMaterialesEstimulacionControl;
    }        
        

    @JoinColumn(nullable = false)
    @ManyToOne
    private CartolaControlesNino cartolaControlesNino;

    public CartolaControlesNino getCartolaControlesNino() {
        return cartolaControlesNino;
    }

    public void setCartolaControlesNino(CartolaControlesNino cartolaControlesNino) {
        this.cartolaControlesNino = cartolaControlesNino;
    }
            
    public Integer getEdadControl() {
        return edadControl;
    }

    public void setEdadControl(Integer edadControl) {
        this.edadControl = edadControl;
    }

    public Float getPesoControl() {
        return pesoControl;
    }

    public void setPesoControl(Float pesoControl) {
        this.pesoControl = pesoControl;
    }

    public Float getTallaControl() {
        return tallaControl;
    }

    public void setTallaControl(Float tallaControl) {
        this.tallaControl = tallaControl;
    }

    public Integer getCircunferenciaCranealControl() {
        return circunferenciaCranealControl;
    }

    public void setCircunferenciaCranealControl(Integer circunferenciaCranealControl) {
        this.circunferenciaCranealControl = circunferenciaCranealControl;
    }

    public String getPesoEdadControl() {
        return pesoEdadControl;
    }

    public void setPesoEdadControl(String pesoEdadControl) {
        this.pesoEdadControl = pesoEdadControl;
    }

    public String getPesoTallaControl() {
        return pesoTallaControl;
    }

    public void setPesoTallaControl(String pesoTallaControl) {
        this.pesoTallaControl = pesoTallaControl;
    }

    public String getTallaEdadControl() {
        return tallaEdadControl;
    }

    public void setTallaEdadControl(String tallaEdadControl) {
        this.tallaEdadControl = tallaEdadControl;
    }

    public String getDesarrolloPsicomotorControl() {
        return desarrolloPsicomotorControl;
    }

    public void setDesarrolloPsicomotorControl(String desarrolloPsicomotorControl) {
        this.desarrolloPsicomotorControl = desarrolloPsicomotorControl;
    }

    public String getAlimentacionRecibeControl() {
        return alimentacionRecibeControl;
    }

    public void setAlimentacionRecibeControl(String alimentacionRecibeControl) {
        this.alimentacionRecibeControl = alimentacionRecibeControl;
    }

    public String getEstadoNutricionalControl() {
        return estadoNutricionalControl;
    }

    public void setEstadoNutricionalControl(String estadoNutricionalControl) {
        this.estadoNutricionalControl = estadoNutricionalControl;
    }

    public Date getFechaIngresoEstmulacionControl() {
        return fechaIngresoEstmulacionControl;
    }

    public void setFechaIngresoEstmulacionControl(Date fechaIngresoEstmulacionControl) {
        this.fechaIngresoEstmulacionControl = fechaIngresoEstmulacionControl;
    }

    public Date getFechaEgresoEstmulacionControl() {
        return fechaEgresoEstmulacionControl;
    }

    public void setFechaEgresoEstmulacionControl(Date fechaEgresoEstmulacionControl) {
        this.fechaEgresoEstmulacionControl = fechaEgresoEstmulacionControl;
    }

    public Boolean getFiguraPaternaControl() {
        return figuraPaternaControl;
    }

    public void setFiguraPaternaControl(Boolean figuraPaternaControl) {
        this.figuraPaternaControl = figuraPaternaControl;
    }

    public String getExaminadorControl() {
        return examinadorControl;
    }

    public void setExaminadorControl(String examinadorControl) {
        this.examinadorControl = examinadorControl;
    }

    public Date getFechaProximaCitacionControl() {
        return fechaProximaCitacionControl;
    }

    public void setFechaProximaCitacionControl(Date fechaProximaCitacionControl) {
        this.fechaProximaCitacionControl = fechaProximaCitacionControl;
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
        if (!(object instanceof ControlNino)) {
            return false;
        }
        ControlNino other = (ControlNino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.pediatria.ControlNino[ id=" + id + " ]";
    }
    
}
