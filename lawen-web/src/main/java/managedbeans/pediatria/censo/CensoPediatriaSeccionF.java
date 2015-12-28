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
@Named(value = "censoPediatriaSeccionF")
@ViewScoped
public class CensoPediatriaSeccionF {

    private String columnName1;
    private int inasistenteMenor6; 
    private int inasistente6a11;
    private int inasistente12a17;
    private int inasistente18a23;
    private int inasistente24a35;
    private int inasistente36a47;
    private int inasistente48a59;
    private int inasistente60a71;
    private int inasistente6a9;
    private int totalInasistente;

    public int getTotalInasistente() {
        return totalInasistente;
    }

    public void setTotalInasistente(int totalInasistente) {
        this.totalInasistente = totalInasistente;
    }    
    
    public String getColumnName1() {
        return columnName1;
    }

    public void setColumnName1(String columnName1) {
        this.columnName1 = columnName1;
    }

    public int getInasistenteMenor6() {
        return inasistenteMenor6;
    }

    public void setInasistenteMenor6(int inasistenteMenor6) {
        this.inasistenteMenor6 = inasistenteMenor6;
    }

    public int getInasistente6a11() {
        return inasistente6a11;
    }

    public void setInasistente6a11(int inasistente6a11) {
        this.inasistente6a11 = inasistente6a11;
    }

    public int getInasistente12a17() {
        return inasistente12a17;
    }

    public void setInasistente12a17(int inasistente12a17) {
        this.inasistente12a17 = inasistente12a17;
    }

    public int getInasistente18a23() {
        return inasistente18a23;
    }

    public void setInasistente18a23(int inasistente18a23) {
        this.inasistente18a23 = inasistente18a23;
    }

    public int getInasistente24a35() {
        return inasistente24a35;
    }

    public void setInasistente24a35(int inasistente24a35) {
        this.inasistente24a35 = inasistente24a35;
    }

    public int getInasistente36a47() {
        return inasistente36a47;
    }

    public void setInasistente36a47(int inasistente36a47) {
        this.inasistente36a47 = inasistente36a47;
    }

    public int getInasistente48a59() {
        return inasistente48a59;
    }

    public void setInasistente48a59(int inasistente48a59) {
        this.inasistente48a59 = inasistente48a59;
    }

    public int getInasistente60a71() {
        return inasistente60a71;
    }

    public void setInasistente60a71(int inasistente60a71) {
        this.inasistente60a71 = inasistente60a71;
    }

    public int getInasistente6a9() {
        return inasistente6a9;
    }

    public void setInasistente6a9(int inasistente6a9) {
        this.inasistente6a9 = inasistente6a9;
    }
       
    public CensoPediatriaSeccionF() {
        this.inasistente12a17 = 0;
        this.inasistente18a23 = 0;
        this.inasistente24a35 = 0;
        this.inasistente36a47 = 0;
        this.inasistente48a59 = 0;
        this.inasistente60a71 = 0;
        this.inasistente6a11 = 0;
        this.inasistente6a9 = 0;
        this.inasistenteMenor6 = 0;
        this.totalInasistente=0;
    }
    
}
