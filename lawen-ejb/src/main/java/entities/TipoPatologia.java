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
 * @author daniel
 */
@Entity
public class TipoPatologia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_tipoPatologia")
    private Long id;
    private String nombre_patologia;
    
    @OneToMany(cascade = ALL,mappedBy ="patologia")
    private List<Patologia> patologias;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_patologia() {
        return nombre_patologia;
    }

    public void setNombre_patologia(String nombre_patologia) {
        this.nombre_patologia = nombre_patologia;
    }

    public List<Patologia> getPatologias() {
        return patologias;
    }

    public void setPatologias(List<Patologia> patologias) {
        this.patologias = patologias;
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
        if (!(object instanceof TipoPatologia)) {
            return false;
        }
        TipoPatologia other = (TipoPatologia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre_patologia;
    }
    
}
