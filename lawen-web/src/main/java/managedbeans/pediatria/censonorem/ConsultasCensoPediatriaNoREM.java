package managedbeans.pediatria.censonorem;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "consultasCensoPediatriaNoREM")
@SessionScoped
public class ConsultasCensoPediatriaNoREM implements Serializable {

    public ConsultasCensoPediatriaNoREM() {
    }
    
}
