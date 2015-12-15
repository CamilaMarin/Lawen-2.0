/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.pediatria;

import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Francisco Avello
 */
@Entity
public class CartolaControlesNino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(cascade = ALL, mappedBy ="cartolaControlesNino", fetch = FetchType.LAZY)
    private List<ControlNino> controles;
    
    @JoinColumn(nullable = false)
    @ManyToOne
    private PacienteNino pacienteNino;

    public PacienteNino getPacienteNino() {
        return pacienteNino;
    }

    public void setPacienteNino(PacienteNino pacienteNino) {
        this.pacienteNino = pacienteNino;
    }   
    
    public List<ControlNino> getControles() {
        return controles;
    }

    public void setControles(List<ControlNino> controles) {
        this.controles = controles;
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
        if (!(object instanceof CartolaControlesNino)) {
            return false;
        }
        CartolaControlesNino other = (CartolaControlesNino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.pediatria.CartolaControlesNino[ id=" + id + " ]";
    }
    
}
