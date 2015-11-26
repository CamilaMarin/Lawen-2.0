/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.cardiovascular;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author daniel
 */
@Entity
public class CCVEnfermero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_ccvenfermero")
    private Long id;
   @NotNull(message = "Debe ingresar una Fecha de atención")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaAtencionEnf;
   
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private FichaEnfermero fichaEnf;
 
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CartolaSeguimientoCCV cartolaToEnf;

    public Date getFechaAtencionEnf() {
        return fechaAtencionEnf;
    }

    public void setFechaAtencionEnf(Date fechaAtencionEnf) {
        this.fechaAtencionEnf = fechaAtencionEnf;
    }

    
    
    public FichaEnfermero getFichaEnf() {
        return fichaEnf;
    }

    public void setFichaEnf(FichaEnfermero fichaEnf) {
        this.fichaEnf = fichaEnf;
    }

    public CartolaSeguimientoCCV getCartolaToEnf() {
        return cartolaToEnf;
    }

    public void setCartolaToEnf(CartolaSeguimientoCCV cartolaToEnf) {
        this.cartolaToEnf = cartolaToEnf;
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
        if (!(object instanceof CCVEnfermero)) {
            return false;
        }
        CCVEnfermero other = (CCVEnfermero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.cardiovascular.FichaEnfermero[ id=" + id + " ]";
    }
    
}
