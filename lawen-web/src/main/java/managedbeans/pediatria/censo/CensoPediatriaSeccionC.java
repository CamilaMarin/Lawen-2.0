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
@Named(value = "censoPediatriaSeccionC")
@ViewScoped
public class CensoPediatriaSeccionC {

    private String columnName1;
    private int riesgoMenor12; 
    private int riesgo12a17; 
    private int riesgo18a23; 
    private int riesgo24a47;
    private int riesgo48a59;
    private int retrasoMenor12; 
    private int retraso12a17; 
    private int retraso18a23; 
    private int retraso24a47;
    private int retraso48a59;

    public String getColumnName1() {
        return columnName1;
    }

    public void setColumnName1(String columnName1) {
        this.columnName1 = columnName1;
    }

    public int getRiesgoMenor12() {
        return riesgoMenor12;
    }

    public void setRiesgoMenor12(int riesgoMenor12) {
        this.riesgoMenor12 = riesgoMenor12;
    }

    public int getRiesgo12a17() {
        return riesgo12a17;
    }

    public void setRiesgo12a17(int riesgo12a17) {
        this.riesgo12a17 = riesgo12a17;
    }

    public int getRiesgo18a23() {
        return riesgo18a23;
    }

    public void setRiesgo18a23(int riesgo18a23) {
        this.riesgo18a23 = riesgo18a23;
    }

    public int getRiesgo24a47() {
        return riesgo24a47;
    }

    public void setRiesgo24a47(int riesgo24a47) {
        this.riesgo24a47 = riesgo24a47;
    }

    public int getRiesgo48a59() {
        return riesgo48a59;
    }

    public void setRiesgo48a59(int riesgo48a59) {
        this.riesgo48a59 = riesgo48a59;
    }

    public int getRetrasoMenor12() {
        return retrasoMenor12;
    }

    public void setRetrasoMenor12(int retrasoMenor12) {
        this.retrasoMenor12 = retrasoMenor12;
    }

    public int getRetraso12a17() {
        return retraso12a17;
    }

    public void setRetraso12a17(int retraso12a17) {
        this.retraso12a17 = retraso12a17;
    }

    public int getRetraso18a23() {
        return retraso18a23;
    }

    public void setRetraso18a23(int retraso18a23) {
        this.retraso18a23 = retraso18a23;
    }

    public int getRetraso24a47() {
        return retraso24a47;
    }

    public void setRetraso24a47(int retraso24a47) {
        this.retraso24a47 = retraso24a47;
    }

    public int getRetraso48a59() {
        return retraso48a59;
    }

    public void setRetraso48a59(int retraso48a59) {
        this.retraso48a59 = retraso48a59;
    }
    
    public CensoPediatriaSeccionC() {
        this.retraso12a17 = 0;
        this.retraso18a23 = 0;
        this.retraso24a47 = 0;
        this.retraso48a59 = 0;
        this.retrasoMenor12 = 0;
        this.riesgo12a17 = 0;
        this.riesgo18a23 = 0;
        this.riesgo24a47 = 0;
        this.riesgo48a59 = 0;
        this.riesgoMenor12 = 0;
    }
    
}
