/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.descargas;

/**
 *
 * @author daniel
 */
import java.io.InputStream;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
 
@SessionScoped
public class anexoA1 implements Serializable{
   
    private StreamedContent file;
     
    public anexoA1() {        
        InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/demo/images/anexo_01_psam_EFAM.pdf");
        file = new DefaultStreamedContent(stream, "file/pdf", "anexo_01_psam_EFAM.pdf");
    }
 
    public StreamedContent getFile() {
        return file;
    }
}