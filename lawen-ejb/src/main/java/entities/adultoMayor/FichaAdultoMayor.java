package entities.adultoMayor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class FichaAdultoMayor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_fichaAM")
    private Long id;
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private EsferaClinicaPSAM esferaCli;
 
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private EsferaFuncionalPSAM esferaFu;
    
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private EsferaMentalPSAM esferaMen;
    
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private EsferaSocialPSAM esferaSo;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    

    public EsferaClinicaPSAM getEsferaCli() {
        return esferaCli;
    }

    public void setEsferaCli(EsferaClinicaPSAM esferaCli) {
        this.esferaCli = esferaCli;
    }

    public EsferaFuncionalPSAM getEsferaFu() {
        return esferaFu;
    }

    public void setEsferaFu(EsferaFuncionalPSAM esferaFu) {
        this.esferaFu = esferaFu;
    }

    public EsferaMentalPSAM getEsferaMen() {
        return esferaMen;
    }

    public void setEsferaMen(EsferaMentalPSAM esferaMen) {
        this.esferaMen = esferaMen;
    }

    public EsferaSocialPSAM getEsferaSo() {
        return esferaSo;
    }

    public void setEsferaSo(EsferaSocialPSAM esferaSo) {
        this.esferaSo = esferaSo;
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
        if (!(object instanceof FichaAdultoMayor)) {
            return false;
        }
        FichaAdultoMayor other = (FichaAdultoMayor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.adultoMayor.FichaAdultoMayor[ id=" + id + " ]";
    }
    
}
