/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.IOException;
import java.io.Serializable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import static javax.persistence.CascadeType.ALL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.jboss.security.Base64Encoder;

/**
 *
 * @author matias
 */
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"rut"} )})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_usuario")
    private Long id;
    @NotNull(message = "Debe ingresar un Usuario")
    private String rut;
    @NotNull(message = "Debe ingresar una contraseña")
    private String password;
    @NotNull(message = "Debe ingresar un nombre usuario")
    private String nombres_usuario;
    @NotNull(message = "Debe ingresar un apellido paterno")
    private String apellidoPaterno_usuario;
    private String apellidoMaterno_usuario;
    private String telefono1;
    private String telefono2;
    private String correo;
    private boolean habilitado;
    @NotNull(message = "Debe ingresar un Tipo de Usuario")
    @JoinColumn(nullable = false)
    @ManyToOne
    private TipoUsuario tipousuario;

    public TipoUsuario getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(TipoUsuario tipousuario) {
        this.tipousuario = tipousuario;
    }


    
 

  
    
    public String getNombres_usuario() {
        return nombres_usuario;
    }

    public void setNombres_usuario(String nombres_usuario) {
        this.nombres_usuario = nombres_usuario;
    }

    public String getApellidoPaterno_usuario() {
        return apellidoPaterno_usuario;
    }

    public void setApellidoPaterno_usuario(String apellidoPaterno_usuario) {
        this.apellidoPaterno_usuario = apellidoPaterno_usuario;
    }

    public String getApellidoMaterno_usuario() {
        return apellidoMaterno_usuario;
    }

    public void setApellidoMaterno_usuario(String apellidoMaterno_usuario) {
        this.apellidoMaterno_usuario = apellidoMaterno_usuario;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

   

   

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = this.encrypt(password);
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
 /***
  * 
  * @param clean_password
  * @return 
  */
   private String encrypt(String clean_password) {
    String algoritmo = "SHA-256"; 
    String hashedPassword = null; 

    try { 
       byte[] hash = MessageDigest.getInstance(algoritmo).digest(clean_password.getBytes()); 
       hashedPassword = Base64Encoder.encode(hash); 
       //System.out.println("Clear Text Password : " + clean_password); 
       //System.out.println("Encrypted Password : " + hashedPassword); 
    } catch (NoSuchAlgorithmException | IOException e) { 
    }
    return hashedPassword;
    } 
/**
 * 
 * @return 
 */
    @Override
    public String toString() {
      
        return tipousuario.getRol() +": "+ nombres_usuario +" " + apellidoPaterno_usuario + " " + apellidoMaterno_usuario;
    
    }
    
}
