/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.subprogramas;

import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Francisco Avello
 */
@Named(value = "censoSubprogramas")
@ViewScoped
public class CensoSubprogramas {
    
    private String columnName1;
    private String columnName2;    
    private int totalPacientesSubprogramas; 
    private int subprogramaArtrosis; 
    private int subprogramaEpilepsia    ; 
    private int subprogramaHipotiroidismo;
    private int subprogramaParkinson; 
    private int subprogramaERA;
    private int subprogramaIRA;

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

    public int getSubprogramaArtrosis() {
        return subprogramaArtrosis;
    }

    public void setSubprogramaArtrosis(int subprogramaArtrosis) {
        this.subprogramaArtrosis = subprogramaArtrosis;
    }

    public int getSubprogramaEpilepsia() {
        return subprogramaEpilepsia;
    }

    public void setSubprogramaEpilepsia(int subprogramaEpilepsia) {
        this.subprogramaEpilepsia = subprogramaEpilepsia;
    }

    public int getSubprogramaHipotiroidismo() {
        return subprogramaHipotiroidismo;
    }

    public void setSubprogramaHipotiroidismo(int subprogramaHipotiroidismo) {
        this.subprogramaHipotiroidismo = subprogramaHipotiroidismo;
    }

    public int getSubprogramaParkinson() {
        return subprogramaParkinson;
    }

    public void setSubprogramaParkinson(int subprogramaParkinson) {
        this.subprogramaParkinson = subprogramaParkinson;
    }

    public int getTotalPacientesSubprogramas() {
        return totalPacientesSubprogramas;
    }

    public void setTotalPacientesSubprogramas(int totalPacientesSubprogramas) {
        this.totalPacientesSubprogramas = totalPacientesSubprogramas;
    }

    public int getSubprogramaERA() {
        return subprogramaERA;
    }

    public void setSubprogramaERA(int subprogramaERA) {
        this.subprogramaERA = subprogramaERA;
    }

    public int getSubprogramaIRA() {
        return subprogramaIRA;
    }

    public void setSubprogramaIRA(int subprogramaIRA) {
        this.subprogramaIRA = subprogramaIRA;
    }
    
    public CensoSubprogramas() {
        this.subprogramaArtrosis=0; 
        this.subprogramaEpilepsia=0; 
        this.subprogramaHipotiroidismo=0;
        this.subprogramaParkinson=0; 
        this.subprogramaERA=0;
        this.subprogramaIRA=0;
        this.totalPacientesSubprogramas=0;        
    }
    
}
