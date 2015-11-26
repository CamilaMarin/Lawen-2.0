/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.adultoMayor.censo;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author matias
 */
@Named(value = "censoSeccionD")
@ViewScoped
public class CensoSeccionF {
    private String columnName1;
    private String columnName2;
    private int Riesgo_normal;
    private int Riesgo_leve;
    private int Riesgo_alto;
    /**
     * Creates a new instance of CensoSeccionF
     */
    public CensoSeccionF() {
        this.columnName1="";
        this.columnName2="";
        this.Riesgo_alto=0;
        this.Riesgo_leve=0;
        this.Riesgo_normal=0;
    }

    public String getColumnName1() {
        return columnName1;
    }

    public void setColumnName1(String columnName1) {
        this.columnName1 = columnName1;
    }

    public String getColumnName2() {
        return columnName2;
    }

    public void setColumnName2(String columnName2) {
        this.columnName2 = columnName2;
    }



    public int getRiesgo_normal() {
        return Riesgo_normal;
    }

    public void setRiesgo_normal(int Riesgo_normal) {
        this.Riesgo_normal = Riesgo_normal;
    }

    public int getRiesgo_leve() {
        return Riesgo_leve;
    }

    public void setRiesgo_leve(int Riesgo_leve) {
        this.Riesgo_leve = Riesgo_leve;
    }

    public int getRiesgo_alto() {
        return Riesgo_alto;
    }

    public void setRiesgo_alto(int Riesgo_alto) {
        this.Riesgo_alto = Riesgo_alto;
    }
    
    
}
