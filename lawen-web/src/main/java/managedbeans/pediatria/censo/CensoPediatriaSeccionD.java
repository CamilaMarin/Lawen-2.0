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
@Named(value = "censoPediatriaSeccionD")
@ViewScoped
public class CensoPediatriaSeccionD {

    private String columnName1;
    private int scoreRiesgoLeve; 
    private int scoreRiesgoModerado;
    private int scoreRiesgoGrave;
    private int scoreTotal;

    public String getColumnName1() {
        return columnName1;
    }

    public void setColumnName1(String columnName1) {
        this.columnName1 = columnName1;
    }

    public int getScoreRiesgoLeve() {
        return scoreRiesgoLeve;
    }

    public void setScoreRiesgoLeve(int scoreRiesgoLeve) {
        this.scoreRiesgoLeve = scoreRiesgoLeve;
    }

    public int getScoreRiesgoModerado() {
        return scoreRiesgoModerado;
    }

    public void setScoreRiesgoModerado(int scoreRiesgoModerado) {
        this.scoreRiesgoModerado = scoreRiesgoModerado;
    }

    public int getScoreRiesgoGrave() {
        return scoreRiesgoGrave;
    }

    public void setScoreRiesgoGrave(int scoreRiesgoGrave) {
        this.scoreRiesgoGrave = scoreRiesgoGrave;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;    }   
    
    
    public CensoPediatriaSeccionD() {
        this.scoreRiesgoGrave = 0;
        this.scoreRiesgoLeve = 0;
        this.scoreRiesgoModerado = 0;
        this.scoreTotal = 0;
    }
    
}
