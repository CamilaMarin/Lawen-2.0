/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.adultoMayor.censo;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author daniel
 */
@Named(value = "censoSeccionA")
@ViewScoped
public class CensoSeccionA {

    /**
     * Creates a new instance of CensoSeccionA
     */
     //efam
    private String columnName1;
    private String columnName2;
    private int contadorAutovalenteSinRiesgo;
    private int contadorAutovalenteConRiesgo;
    private int contadorRiesgoDependencia;
    private int subTotalEfam;
    //barthel
    private int dependentienteLeve;
    private int dependientemoderado;
    private int dependientegrave;
    private int dependienteTotal;
    private int subTotalBarthel;
    //total
    private int totalAdutosMayoresControl;

    public int getContadorAutovalenteSinRiesgo() {
        return contadorAutovalenteSinRiesgo;
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

  
    

    public void setContadorAutovalenteSinRiesgo(int contadorAutovalenteSinRiesgo) {
        this.contadorAutovalenteSinRiesgo = contadorAutovalenteSinRiesgo;
    }

    public int getContadorAutovalenteConRiesgo() {
        return contadorAutovalenteConRiesgo;
    }

    public void setContadorAutovalenteConRiesgo(int contadorAutovalenteConRiesgo) {
        this.contadorAutovalenteConRiesgo = contadorAutovalenteConRiesgo;
    }

    public int getContadorRiesgoDependencia() {
        return contadorRiesgoDependencia;
    }

    public void setContadorRiesgoDependencia(int contadorRiesgoDependencia) {
        this.contadorRiesgoDependencia = contadorRiesgoDependencia;
    }

    public int getSubTotalEfam() {
        return subTotalEfam;
    }

    public void setSubTotalEfam(int subTotalEfam) {
        this.subTotalEfam = subTotalEfam;
    }

    public int getDependentienteLeve() {
        return dependentienteLeve;
    }

    public void setDependentienteLeve(int dependentienteLeve) {
        this.dependentienteLeve = dependentienteLeve;
    }

    public int getDependientemoderado() {
        return dependientemoderado;
    }

    public void setDependientemoderado(int dependientemoderado) {
        this.dependientemoderado = dependientemoderado;
    }

    public int getDependientegrave() {
        return dependientegrave;
    }

    public void setDependientegrave(int dependientegrave) {
        this.dependientegrave = dependientegrave;
    }

    public int getDependienteTotal() {
        return dependienteTotal;
    }

    public void setDependienteTotal(int dependienteTotal) {
        this.dependienteTotal = dependienteTotal;
    }

    public int getSubTotalBarthel() {
        return subTotalBarthel;
    }

    public void setSubTotalBarthel(int subTotalBarthel) {
        this.subTotalBarthel = subTotalBarthel;
    }

    public int getTotalAdutosMayoresControl() {
        return totalAdutosMayoresControl;
    }

    public void setTotalAdutosMayoresControl(int totalAdutosMayoresControl) {
        this.totalAdutosMayoresControl = totalAdutosMayoresControl;
    }

    public CensoSeccionA() {
        this.contadorAutovalenteSinRiesgo = 0;
        this.contadorAutovalenteConRiesgo = 0;
        this.contadorRiesgoDependencia = 0;
        this.subTotalEfam = 0;
        this.dependentienteLeve = 0;
        this.dependientemoderado = 0;
        this.dependientegrave = 0;
        this.dependienteTotal = 0;
        this.subTotalBarthel = 0;
        this.totalAdutosMayoresControl = 0;
    }
    


    
}
