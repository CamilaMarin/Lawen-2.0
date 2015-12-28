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
@Named(value = "censoPediatriaSeccionH")
@ViewScoped
public class CensoPediatriaSeccionH {

    private String columnName1;
    private int sinRiesgo; 
    private int conRiesgo; 
    private int totalEutrofica;

    public String getColumnName1() {
        return columnName1;
    }

    public void setColumnName1(String columnName1) {
        this.columnName1 = columnName1;
    }

    public int getSinRiesgo() {
        return sinRiesgo;
    }

    public void setSinRiesgo(int sinRiesgo) {
        this.sinRiesgo = sinRiesgo;
    }

    public int getConRiesgo() {
        return conRiesgo;
    }

    public void setConRiesgo(int conRiesgo) {
        this.conRiesgo = conRiesgo;
    }

    public int getTotalEutrofica() {
        return totalEutrofica;
    }

    public void setTotalEutrofica(int totalEutrofica) {
        this.totalEutrofica = totalEutrofica;
    }   
    
    
    public CensoPediatriaSeccionH() {
        this.conRiesgo = 0;
        this.sinRiesgo = 0;
        this.totalEutrofica = 0;
    }
    
}
