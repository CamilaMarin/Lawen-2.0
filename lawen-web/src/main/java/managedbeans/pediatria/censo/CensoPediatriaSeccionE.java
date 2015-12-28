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
@Named(value = "censoPediatriaSeccionE")
@ViewScoped
public class CensoPediatriaSeccionE {
    
    private String columnName1;
    private int numeroNutriQuintoMes; 
    private int numeroNutriTresAñosSeisMeses; 

    public String getColumnName1() {
        return columnName1;
    }

    public void setColumnName1(String columnName1) {
        this.columnName1 = columnName1;
    }

    public int getNumeroNutriQuintoMes() {
        return numeroNutriQuintoMes;
    }

    public void setNumeroNutriQuintoMes(int numeroNutriQuintoMes) {
        this.numeroNutriQuintoMes = numeroNutriQuintoMes;
    }

    public int getNumeroNutriTresAñosSeisMeses() {
        return numeroNutriTresAñosSeisMeses;
    }

    public void setNumeroNutriTresAñosSeisMeses(int numeroNutriTresAñosSeisMeses) {
        this.numeroNutriTresAñosSeisMeses = numeroNutriTresAñosSeisMeses;
    }
    
    
    
    public CensoPediatriaSeccionE() {
        this.numeroNutriQuintoMes = 0;
        this.numeroNutriTresAñosSeisMeses = 0;
    }
    
}
