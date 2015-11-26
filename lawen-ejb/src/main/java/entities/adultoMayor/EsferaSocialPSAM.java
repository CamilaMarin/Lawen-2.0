/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.adultoMayor;

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
public class EsferaSocialPSAM implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_esferaSocial")
    private Long id;

    
     
    ////// ESFERA SOCIAL
    
    @Size(max=100)
    private String ingreso_socioeconomico;
    @Size(max=300)
    private String descripcion_hogar;
    @Size(max=300)
    private String tipo_familia;
    ///
    private Integer puntaje_apgar;
    ////////////////////
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngreso_socioeconomico() {
        return ingreso_socioeconomico;
    }

    public void setIngreso_socioeconomico(String ingreso_socioeconomico) {
        this.ingreso_socioeconomico = ingreso_socioeconomico;
    }

    public String getDescripcion_hogar() {
        return descripcion_hogar;
    }

    public void setDescripcion_hogar(String descripcion_hogar) {
        this.descripcion_hogar = descripcion_hogar;
    }

    public String getTipo_familia() {
        return tipo_familia;
    }

    public void setTipo_familia(String tipo_familia) {
        this.tipo_familia = tipo_familia;
    }

    public Integer getPuntaje_apgar() {
        return puntaje_apgar;
    }

    public void setPuntaje_apgar(Integer puntaje_apgar) {
        this.puntaje_apgar = puntaje_apgar;
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
        if (!(object instanceof EsferaSocialPSAM)) {
            return false;
        }
        EsferaSocialPSAM other = (EsferaSocialPSAM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.adultoMayor.EsferaSocialPSAM[ id=" + id + " ]";
    }
    
}
