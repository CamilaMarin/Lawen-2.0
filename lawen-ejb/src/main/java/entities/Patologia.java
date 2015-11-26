/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author daniel
 */
@Entity
/*@Table(name="Patologia")
@NamedQueries({
    @NamedQuery(name = "Patologia.findAll", query = "SELECT s FROM Patologia s")
})*/
public class Patologia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_patologia")
    private Long id;
    
    @NotNull(message = "Debe ingresar un Tipo de patologia")
    @JoinColumn(nullable = false)
    @ManyToOne
    private TipoPatologia patologia;
 
    @JoinColumn(nullable = false)
    @ManyToOne
    private Paciente paciente;
   
    
    public Long getId() {
        return id;
    }

    public TipoPatologia getPatologia() {
        return patologia;
    }

    public void setPatologia(TipoPatologia patologia) {
        this.patologia = patologia;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
        if (!(object instanceof Patologia)) {
            return false;
        }
        Patologia other = (Patologia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Patologia[ id=" + id + " ]";
    }
    
}
