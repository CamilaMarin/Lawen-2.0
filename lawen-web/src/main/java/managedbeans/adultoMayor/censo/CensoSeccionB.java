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
@Named(value = "censoSeccionB")
@ViewScoped
public class CensoSeccionB implements Serializable {
    private String columnName1;
    private String columnName2;
    private int contadorBajoPeso;
    private int contadorNormal;
    private int contadorSobrepeso;
    private int contadorObeso;
    private int TotalSeccionB;
    /**
     * Creates a new instance of CensoSeccionB
     */
    public CensoSeccionB() {
        this.columnName1="";
        this.columnName2="";
        this.contadorBajoPeso=0;
        this.contadorNormal=0;
        this.contadorSobrepeso=0;
        this.contadorObeso=0;
        this.TotalSeccionB=0;
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

  

    public int getContadorBajoPeso() {
        return contadorBajoPeso;
    }

    public void setContadorBajoPeso(int contadorBajoPesp) {
        this.contadorBajoPeso = contadorBajoPesp;
    }

    public int getContadorNormal() {
        return contadorNormal;
    }

    public void setContadorNormal(int contadorNormal) {
        this.contadorNormal = contadorNormal;
    }

    public int getContadorSobrepeso() {
        return contadorSobrepeso;
    }

    public void setContadorSobrepeso(int contadorSobrepeso) {
        this.contadorSobrepeso = contadorSobrepeso;
    }

    public int getContadorObeso() {
        return contadorObeso;
    }

    public void setContadorObeso(int contadorObeso) {
        this.contadorObeso = contadorObeso;
    }

    public int getTotalSeccionB() {
        return TotalSeccionB;
    }

    public void setTotalSeccionB(int TotalSeccionB) {
        this.TotalSeccionB = TotalSeccionB;
    }
    
    
    
}
