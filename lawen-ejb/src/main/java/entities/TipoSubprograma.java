/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Francisco Avello
 */
@Entity
public class TipoSubprograma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_tipoSubprograma")
    private Long id;
    private String nombre_subprograma;
    
    @OneToMany(cascade = ALL,mappedBy ="subprograma")
    private List<Subprograma> subprogramas;
  
    public String getNombre_subprograma() {
        return nombre_subprograma;
    }

    public void setNombre_subprograma(String nombre_subprograma) {
        this.nombre_subprograma = nombre_subprograma;
    }

    public List<Subprograma> getSubprogramas() {
        return subprogramas;
    }

    public void setSubprogramas(List<Subprograma> subprogramas) {
        this.subprogramas = subprogramas;
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
        if (!(object instanceof TipoSubprograma)) {
            return false;
        }
        TipoSubprograma other = (TipoSubprograma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoSubprograma[ id=" + id + " ]";
    }
    
}
