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
@Named(value = "censoPediatriaSeccionA")
@ViewScoped
public class CensoPediatriaSeccionA {

    private String columnName1;
    private String columnName2;    
    private int numerodeNinosPediatria; 
    private int pesoEdadMenosUno; 
    private int pesoEdadMenosDos;
    private int pesoEdadMenosTotal; 
    private int pesoTallaMasDos; 
    private int pesoTallaMasUno;
    private int pesoTallaMasTotal; 
    private int pesoTallaMenosUno; 
    private int pesoTallaMenosDos;
    private int pesoTallaMenosTotal; 
    private int tallaEdadMenosUno; 
    private int tallaEdadMenosDos;
    private int tallaEdadMenosTotal;
    
    private int diagnosticoNutricionalIntegradoRiesgoBajoPeso;
    private int diagnosticoNutricionalIntegradoDesnutrido;
    private int diagnosticoNutricionalIntegradoSobrePesoObesidad;
    private int diagnosticoNutricionalIntegradoObeso;
    private int diagnosticoNutricionalIntegradoNormal;
    private int diagnosticoNutricionalIntegradoSubtotal;
    private int diagnosticoNutricionalIntegradoDesnutricionSecundaria;
    private int diagnosticoNutricionalIntegradoTotal;

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

    public int getNumerodeNinosPediatria() {
        return numerodeNinosPediatria;
    }

    public void setNumerodeNinosPediatria(int numerodeNinosPediatria) {
        this.numerodeNinosPediatria = numerodeNinosPediatria;
    }

    public int getPesoEdadMenosUno() {
        return pesoEdadMenosUno;
    }

    public void setPesoEdadMenosUno(int pesoEdadMenosUno) {
        this.pesoEdadMenosUno = pesoEdadMenosUno;
    }

    public int getPesoEdadMenosDos() {
        return pesoEdadMenosDos;
    }

    public void setPesoEdadMenosDos(int pesoEdadMenosDos) {
        this.pesoEdadMenosDos = pesoEdadMenosDos;
    }

    public int getPesoEdadMenosTotal() {
        return pesoEdadMenosTotal;
    }

    public void setPesoEdadMenosTotal(int pesoEdadMenosTotal) {
        this.pesoEdadMenosTotal = pesoEdadMenosTotal;
    }

    public int getPesoTallaMasDos() {
        return pesoTallaMasDos;
    }

    public void setPesoTallaMasDos(int pesoTallaMasDos) {
        this.pesoTallaMasDos = pesoTallaMasDos;
    }

    public int getPesoTallaMasUno() {
        return pesoTallaMasUno;
    }

    public void setPesoTallaMasUno(int pesoTallaMasUno) {
        this.pesoTallaMasUno = pesoTallaMasUno;
    }

    public int getPesoTallaMasTotal() {
        return pesoTallaMasTotal;
    }

    public void setPesoTallaMasTotal(int pesoTallaMasTotal) {
        this.pesoTallaMasTotal = pesoTallaMasTotal;
    }

    public int getPesoTallaMenosUno() {
        return pesoTallaMenosUno;
    }

    public void setPesoTallaMenosUno(int pesoTallaMenosUno) {
        this.pesoTallaMenosUno = pesoTallaMenosUno;
    }

    public int getPesoTallaMenosDos() {
        return pesoTallaMenosDos;
    }

    public void setPesoTallaMenosDos(int pesoTallaMenosDos) {
        this.pesoTallaMenosDos = pesoTallaMenosDos;
    }

    public int getPesoTallaMenosTotal() {
        return pesoTallaMenosTotal;
    }

    public void setPesoTallaMenosTotal(int pesoTallaMenosTotal) {
        this.pesoTallaMenosTotal = pesoTallaMenosTotal;
    }

    public int getTallaEdadMenosUno() {
        return tallaEdadMenosUno;
    }

    public void setTallaEdadMenosUno(int tallaEdadMenosUno) {
        this.tallaEdadMenosUno = tallaEdadMenosUno;
    }

    public int getTallaEdadMenosDos() {
        return tallaEdadMenosDos;
    }

    public void setTallaEdadMenosDos(int tallaEdadMenosDos) {
        this.tallaEdadMenosDos = tallaEdadMenosDos;
    }

    public int getTallaEdadMenosTotal() {
        return tallaEdadMenosTotal;
    }

    public void setTallaEdadMenosTotal(int tallaEdadMenosTotal) {
        this.tallaEdadMenosTotal = tallaEdadMenosTotal;
    }

    public int getDiagnosticoNutricionalIntegradoRiesgoBajoPeso() {
        return diagnosticoNutricionalIntegradoRiesgoBajoPeso;
    }

    public void setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(int diagnosticoNutricionalIntegradoRiesgoBajoPeso) {
        this.diagnosticoNutricionalIntegradoRiesgoBajoPeso = diagnosticoNutricionalIntegradoRiesgoBajoPeso;
    }

    public int getDiagnosticoNutricionalIntegradoDesnutrido() {
        return diagnosticoNutricionalIntegradoDesnutrido;
    }

    public void setDiagnosticoNutricionalIntegradoDesnutrido(int diagnosticoNutricionalIntegradoDesnutrido) {
        this.diagnosticoNutricionalIntegradoDesnutrido = diagnosticoNutricionalIntegradoDesnutrido;
    }

    public int getDiagnosticoNutricionalIntegradoSobrePesoObesidad() {
        return diagnosticoNutricionalIntegradoSobrePesoObesidad;
    }

    public void setDiagnosticoNutricionalIntegradoSobrePesoObesidad(int diagnosticoNutricionalIntegradoSobrePesoObesidad) {
        this.diagnosticoNutricionalIntegradoSobrePesoObesidad = diagnosticoNutricionalIntegradoSobrePesoObesidad;
    }

    public int getDiagnosticoNutricionalIntegradoObeso() {
        return diagnosticoNutricionalIntegradoObeso;
    }

    public void setDiagnosticoNutricionalIntegradoObeso(int diagnosticoNutricionalIntegradoObeso) {
        this.diagnosticoNutricionalIntegradoObeso = diagnosticoNutricionalIntegradoObeso;
    }

    public int getDiagnosticoNutricionalIntegradoNormal() {
        return diagnosticoNutricionalIntegradoNormal;
    }

    public void setDiagnosticoNutricionalIntegradoNormal(int diagnosticoNutricionalIntegradoNormal) {
        this.diagnosticoNutricionalIntegradoNormal = diagnosticoNutricionalIntegradoNormal;
    }

    public int getDiagnosticoNutricionalIntegradoSubtotal() {
        return diagnosticoNutricionalIntegradoSubtotal;
    }

    public void setDiagnosticoNutricionalIntegradoSubtotal(int diagnosticoNutricionalIntegradoSubtotal) {
        this.diagnosticoNutricionalIntegradoSubtotal = diagnosticoNutricionalIntegradoSubtotal;
    }

    public int getDiagnosticoNutricionalIntegradoDesnutricionSecundaria() {
        return diagnosticoNutricionalIntegradoDesnutricionSecundaria;
    }

    public void setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(int diagnosticoNutricionalIntegradoDesnutricionSecundaria) {
        this.diagnosticoNutricionalIntegradoDesnutricionSecundaria = diagnosticoNutricionalIntegradoDesnutricionSecundaria;
    }

    public int getDiagnosticoNutricionalIntegradoTotal() {
        return diagnosticoNutricionalIntegradoTotal;
    }

    public void setDiagnosticoNutricionalIntegradoTotal(int diagnosticoNutricionalIntegradoTotal) {
        this.diagnosticoNutricionalIntegradoTotal = diagnosticoNutricionalIntegradoTotal;
    }

    
    public CensoPediatriaSeccionA() {
        this.diagnosticoNutricionalIntegradoDesnutricionSecundaria = 0;
        this.diagnosticoNutricionalIntegradoDesnutrido = 0;
        this.diagnosticoNutricionalIntegradoNormal = 0;
        this.diagnosticoNutricionalIntegradoObeso = 0;
        this.diagnosticoNutricionalIntegradoRiesgoBajoPeso = 0;
        this.diagnosticoNutricionalIntegradoSobrePesoObesidad = 0;
        this.diagnosticoNutricionalIntegradoSubtotal = 0;
        this.diagnosticoNutricionalIntegradoTotal = 0;
        this.numerodeNinosPediatria = 0;
  
        this.pesoEdadMenosDos = 0;
        this.pesoEdadMenosTotal = 0;
        this.pesoEdadMenosUno = 0;
        this.pesoTallaMasDos = 0;
        this.pesoTallaMasTotal = 0;
        this.pesoTallaMasUno = 0;
        this.pesoTallaMenosDos = 0;
        this.pesoTallaMenosTotal = 0;
        this.pesoTallaMenosUno = 0;
        this.tallaEdadMenosDos=0;
        this.tallaEdadMenosTotal=0;                
        this.tallaEdadMenosUno=0;
    }
    
}
