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
public class CensoSeccionD implements Serializable {

    /**
     * Creates a new instance of CensoSeccionD
     */
    private String columnName1;
    private String columnName2;
    private int TotalSeccionD;
     
    public CensoSeccionD() {
        this.columnName1="";
        this.columnName2="";
        this.TotalSeccionD=0;
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
    
    public int getTotalSeccionD() {
        return TotalSeccionD;
    }

    public void setTotalSeccionD(int TotalSeccionD) {
        this.TotalSeccionD = TotalSeccionD;
    }
    
    
    
}
