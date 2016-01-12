/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Medicamentos;
import entities.cardiovascular.CartolaSeguimientoCCV;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Beban
 */
@Entity
@Table(name = "medicamentos_cartola")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicamentosCartola.findAll", query = "SELECT m FROM MedicamentosCartola m"),
    @NamedQuery(name = "MedicamentosCartola.findByIdMedicamentosCartola", query = "SELECT m FROM MedicamentosCartola m WHERE m.idMedicamentosCartola = :idMedicamentosCartola"),
    @NamedQuery(name = "MedicamentosCartola.findByIdMedicamento", query = "SELECT m FROM MedicamentosCartola m WHERE m.idMedicamento = :idMedicamento"),
    @NamedQuery(name = "MedicamentosCartola.findByIdCartolaseguimiento", query = "SELECT m FROM MedicamentosCartola m WHERE m.idCartolaseguimiento = :idCartolaseguimiento")})
public class MedicamentosCartola implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_medicamentos_cartola")
    private Long idMedicamentosCartola;
   
    @JoinColumn(nullable = false)
    @ManyToOne
    private Medicamentos idMedicamento;
    
    @JoinColumn(nullable = false)
    @ManyToOne
    private CartolaSeguimientoCCV idCartolaseguimiento;

    public MedicamentosCartola() {
    }

    public MedicamentosCartola(Long idMedicamentosCartola) {
        this.idMedicamentosCartola = idMedicamentosCartola;
    }

    public Long getIdMedicamentosCartola() {
        return idMedicamentosCartola;
    }

    public void setIdMedicamentosCartola(Long idMedicamentosCartola) {
        this.idMedicamentosCartola = idMedicamentosCartola;
    }

    public Medicamentos getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Medicamentos idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public CartolaSeguimientoCCV getIdCartolaseguimiento() {
        return idCartolaseguimiento;
    }

    public void setIdCartolaseguimiento(CartolaSeguimientoCCV idCartolaseguimiento) {
        this.idCartolaseguimiento = idCartolaseguimiento;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicamentosCartola != null ? idMedicamentosCartola.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicamentosCartola)) {
            return false;
        }
        MedicamentosCartola other = (MedicamentosCartola) object;
        if ((this.idMedicamentosCartola == null && other.idMedicamentosCartola != null) || (this.idMedicamentosCartola != null && !this.idMedicamentosCartola.equals(other.idMedicamentosCartola))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MedicamentosCartola[ idMedicamentosCartola=" + idMedicamentosCartola + " ]";
    }

    public void setIdMedicamentosCartola(Medicamentos medicamentoscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
