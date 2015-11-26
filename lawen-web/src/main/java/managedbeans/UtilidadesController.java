/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.cardiovascular.CartolaSeguimientoCCV;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author daniel
 */
@Named("utilidadesController")
@ApplicationScoped
public class UtilidadesController{


    public UtilidadesController() {
    }
    public String booleanos(boolean valor){
        if(valor)
            return "Si";
        return "No";
    
    }
    
    public String getFechaSistema(){
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha_sistema = new Date();
            
            return dateFormat.format(fecha_sistema);
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
