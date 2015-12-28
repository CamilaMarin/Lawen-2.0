/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.pediatria.censo;

import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Francisco Avello
 */
@Named(value = "censoPediatriaSeccionG")
@ViewScoped
public class CensoPediatriaSeccionG {

    private String columnName1;
    private int clasificacionNormal; 
    private int clasificacionPreHiper; 
    private int clasificacionEtapaUno; 
    private int clasificacionEtapaDos;
    private int totalClasificacion;

    public String getColumnName1() {
        return columnName1;
    }

    public void setColumnName1(String columnName1) {
        this.columnName1 = columnName1;
    }

    public int getClasificacionNormal() {
        return clasificacionNormal;
    }

    public void setClasificacionNormal(int clasificacionNormal) {
        this.clasificacionNormal = clasificacionNormal;
    }

    public int getClasificacionPreHiper() {
        return clasificacionPreHiper;
    }

    public void setClasificacionPreHiper(int clasificacionPreHiper) {
        this.clasificacionPreHiper = clasificacionPreHiper;
    }

    public int getClasificacionEtapaUno() {
        return clasificacionEtapaUno;
    }

    public void setClasificacionEtapaUno(int clasificacionEtapaUno) {
        this.clasificacionEtapaUno = clasificacionEtapaUno;
    }

    public int getClasificacionEtapaDos() {
        return clasificacionEtapaDos;
    }

    public void setClasificacionEtapaDos(int clasificacionEtapaDos) {
        this.clasificacionEtapaDos = clasificacionEtapaDos;
    }

    public int getTotalClasificacion() {
        return totalClasificacion;
    }

    public void setTotalClasificacion(int totalClasificacion) {
        this.totalClasificacion = totalClasificacion;
    }    
      
    public CensoPediatriaSeccionG() {
        this.clasificacionEtapaDos = 0;
        this.clasificacionEtapaUno = 0;
        this.clasificacionNormal = 0;
        this.clasificacionPreHiper = 0;
        this.totalClasificacion = 0;
    }
    
}
