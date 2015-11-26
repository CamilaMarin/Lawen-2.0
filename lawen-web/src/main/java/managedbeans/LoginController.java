/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author matias
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {
    private String username;
    private String password;
    @Inject
    private UsuarioController rut;
    /*
    get  usuario
    */
    public String getUsername() {
        return username;
    }
    /**
     * set usuario
     * @param username 
     */
    public void setUsername(String username) {
        if(username.length()>=2){
            username =  username.toUpperCase();
            username = username.replace(".", "");
            username = username.replace("-", "");
            username = username.substring(0, username.length()-1) + "-" + username.substring(username.length()-1, username.length());

        }
        
        this.username = username;
    }
    /*
    get password del usuario
    */
    public String getPassword() {
        return password;
    }
    /*
    set password del usario
    */
    public void setPassword(String password) {
        this.password = password;
    }
    /***
     * http://docs.oracle.com/javaee/6/tutorial/doc/gkbaa.html
     * Login
     * @return 
     */
    public String login () {
        try{
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) 
        context.getExternalContext().getRequest();
        
        Usuario usuario;
        usuario = rut.FindUsuariobyRut(this.username);
        if(usuario == null){
            context.addMessage(null, new FacesMessage("El usuario no existe"));
                   
            
            return "faces/loginerror.xhtml";
        
        }
        else if(usuario.isHabilitado()==false){
            context.addMessage(null, new FacesMessage("Usted se encuentra deshabilitado, contáctese con el administrador"));           
            
            return "faces/loginerror.xhtml";
            
            
        }
        else{
        
            if(request.getRemoteUser() == null){//si el usuario remoto no esta logueado
                try {//prueba que se loguee con sus credenciales
                    request.login(this.username, this.password); //comprueba en el servidor si la pass y el usuario corresponden
                    //la comprobación se hace por parte de Wildfly(se configuraron Roles y rol)
                } 
                catch (ServletException e) {//si request.login fallo y la password o el usuario no corresponden
                        context.addMessage(null, new FacesMessage("Fallo en la autenticacion"));
                        return "faces/loginerror.xhtml";
                }
            }
            else{
                //usuario ya logueado
                context.addMessage(null, new FacesMessage("Usuario ya logueado"));    
                return "faces/index.xhtml";
            }
          return "faces/index.xhtml?faces-redirect=true";
        }
            
        
        }
        catch(Exception e){
           return "faces/loginerror.xhtml";
            
        }
        
        

   
  }

    /***
     * Logout para usuario logueado
     * @return 
     */
    public String logout() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();//obtiene el contexto
        externalContext.invalidateSession();//lo desloguea
        return "/faces/index.xhtml?faces-redirect=true";//redirige al index
    }
    
    /***
     * Función que verifica si un usuario está registrado
     * @return 
     * true: usaurio no logueado
     * false:usuario logueado
     */
    public boolean verifyLogin(){
        boolean verify= false;
        try {//prueba
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) 
            context.getExternalContext().getRequest();//obtengo el contexto en el servidor
            
             if(request.getRemoteUser() == null){//si el usuario no esta logueado
                 verify=false;//retorna falso
             }
             else{//sino esta logueado y retorna verdadero
                 verify=true;
             }
             
        } catch (Exception e) {//si hay algun error
            verify = false;//retorna falso
        }
        return verify;
    }

  
  
}

