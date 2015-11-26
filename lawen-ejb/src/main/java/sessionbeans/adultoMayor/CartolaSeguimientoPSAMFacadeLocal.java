package sessionbeans.adultoMayor;

import entities.Paciente;
import entities.adultoMayor.CartolaSeguimientoPSAM;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author matias
 */
@Local
public interface CartolaSeguimientoPSAMFacadeLocal {

    void create(CartolaSeguimientoPSAM cartolaSeguimientoPSAM);

    void edit(CartolaSeguimientoPSAM cartolaSeguimientoPSAM);

    void remove(CartolaSeguimientoPSAM cartolaSeguimientoPSAM);

    CartolaSeguimientoPSAM find(Object id);

    List<CartolaSeguimientoPSAM> findAll();

    List<CartolaSeguimientoPSAM> findRange(int[] range);

    int count();
    
    List<CartolaSeguimientoPSAM> findByPaciente(Paciente paciente);
    
}
