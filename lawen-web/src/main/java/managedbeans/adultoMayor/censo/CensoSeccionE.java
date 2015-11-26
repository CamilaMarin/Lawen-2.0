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
public class CensoSeccionE implements Serializable{
        private String columnName1;
        private String columnName2;
        private int Total_institu;
        private int Total_severo;
    /**
     * Creates a new instance of CensoSeccionE
     */
    public CensoSeccionE() {
        this.columnName1="";
        this.columnName2="";
        this.Total_institu=0;
        this.Total_severo=0;
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


    public int getTotal_institu() {
        return Total_institu;
    }

    public void setTotal_institu(int Total_institu) {
        this.Total_institu = Total_institu;
    }

    public int getTotal_severo() {
        return Total_severo;
    }

    public void setTotal_severo(int Total_severo) {
        this.Total_severo = Total_severo;
    }
    
    
    
}
