package managedbeans.adultoMayor.censo;

import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author matias
 */
@Named(value = "censoPSAMExcluidos")
@ViewScoped
public class CensoPSAMExcluidos {
    //nombre del paciente
    private String nombre;
    //apellido del paciente
    private String apellidop;
    //apellido materno del paciente
    private String apellidom;
    //rut del paciente
    private String rut;
    //edad del paciente
    private int edad;
    //razo de exclusion del censo
    private String razon_exclusion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRazon_exclusion() {
        return razon_exclusion;
    }

    public void setRazon_exclusion(String razon_exclusion) {
        this.razon_exclusion = razon_exclusion;
    }

    /**
     * Creates a new instance of CensoPSAMExcluidos
     */
    public CensoPSAMExcluidos() {
        this.nombre = "";
        this.apellidom = "";
        this.apellidop = "";
        this.rut = "";
        this.edad = 0;
        this.razon_exclusion = "";
    }

}
