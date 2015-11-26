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
public class IngresoPSAM implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_ingresoPSAM")
    private Long id;
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private FichaAdultoMayor fichaAdultoMayor;
 
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CartolaSeguimientoPSAM cartolaPSAM;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public FichaAdultoMayor getFichaAdultoMayor() {
        return fichaAdultoMayor;
    }

    public void setFichaAdultoMayor(FichaAdultoMayor fichaAdultoMayor) {
        this.fichaAdultoMayor = fichaAdultoMayor;
    }

    public CartolaSeguimientoPSAM getCartolaPSAM() {
        return cartolaPSAM;
    }

    public void setCartolaPSAM(CartolaSeguimientoPSAM cartolaPSAM) {
        this.cartolaPSAM = cartolaPSAM;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof IngresoPSAM)) {
            return false;
        }
        IngresoPSAM other = (IngresoPSAM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.adultoMayor.IngresoPSAM[ id=" + id + " ]";
    }
    
}
