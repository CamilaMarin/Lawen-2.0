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
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class anexoA3 {
     
    private StreamedContent fileA3;
     
    public anexoA3() {        
        InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/documents/anexos/anexo_03_psam_YESAVAGE.pdf");
        fileA3 = new DefaultStreamedContent(stream, "file/pdf", "anexo_03_psam_YESAVAGE.pdf");
    }
 
    public StreamedContent getFile() {
        return fileA3;
    }
}