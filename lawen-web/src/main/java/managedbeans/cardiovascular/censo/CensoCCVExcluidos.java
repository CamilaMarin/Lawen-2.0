package managedbeans.cardiovascular.censo;

import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author matias
 */
@Named(value = "censoCCVSeccionA")
@ViewScoped
public class CensoCCVExcluidos {

    private String nombre;
    private String apellidop;
    private String apellidom;
    private String rut;
    private int edad;
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
     * Creates a new instance of CensoCCVExcluidos
     */
    public CensoCCVExcluidos() {
        this.nombre = "";
        this.apellidom = "";
        this.apellidop = "";
        this.rut = "";
        this.edad = 0;
        this.razon_exclusion = "";
    }

}
