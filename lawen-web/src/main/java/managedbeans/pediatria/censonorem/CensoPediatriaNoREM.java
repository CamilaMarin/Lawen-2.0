/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.pediatria.censonorem;

import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author PC
 */
@Named(value = "censoPediatriaNoREM")
@ViewScoped
public class CensoPediatriaNoREM {
    
    private String columnName1; 
    private int numerodeNinosPediatria; 
    private int lactanciaLME; 
    private int lactanciaLMOtro;
    private int lactanciaLMLA; 
    private int lactanciaLMLAOtros; 
    private int lactanciaLA;
    private int lactanciaLAOtros;
    private int madreObesa;
    private int madreFumadora;
    private int madreAlcholica;
    private int padreObeso;
    private int padreFumador;
    private int padreAlcholico;
    private int asistNadiePerfecto; 
    private int conMaterialesEstimulacion; 
    private int padrePresente;

    public String getColumnName1() {
        return columnName1;
    }

    public int getMadreObesa() {
        return madreObesa;
    }

    public void setMadreObesa(int madreObesa) {
        this.madreObesa = madreObesa;
    }

    public int getMadreFumadora() {
        return madreFumadora;
    }

    public void setMadreFumadora(int madreFumadora) {
        this.madreFumadora = madreFumadora;
    }

    public int getMadreAlcholica() {
        return madreAlcholica;
    }

    public void setMadreAlcholica(int madreAlcholica) {
        this.madreAlcholica = madreAlcholica;
    }

    public int getPadreObeso() {
        return padreObeso;
    }

    public void setPadreObeso(int padreObeso) {
        this.padreObeso = padreObeso;
    }

    public int getPadreFumador() {
        return padreFumador;
    }

    public void setPadreFumador(int padreFumador) {
        this.padreFumador = padreFumador;
    }

    public int getPadreAlcholico() {
        return padreAlcholico;
    }

    public void setPadreAlcholico(int padreAlcholico) {
        this.padreAlcholico = padreAlcholico;
    }

    public void setColumnName1(String columnName1) {
        this.columnName1 = columnName1;
    }

    public int getNumerodeNinosPediatria() {
        return numerodeNinosPediatria;
    }

    public void setNumerodeNinosPediatria(int numerodeNinosPediatria) {
        this.numerodeNinosPediatria = numerodeNinosPediatria;
    }

    public int getLactanciaLME() {
        return lactanciaLME;
    }

    public void setLactanciaLME(int lactanciaLME) {
        this.lactanciaLME = lactanciaLME;
    }

    public int getLactanciaLMOtro() {
        return lactanciaLMOtro;
    }

    public void setLactanciaLMOtro(int lactanciaLMOtro) {
        this.lactanciaLMOtro = lactanciaLMOtro;
    }

    public int getLactanciaLMLA() {
        return lactanciaLMLA;
    }

    public void setLactanciaLMLA(int lactanciaLMLA) {
        this.lactanciaLMLA = lactanciaLMLA;
    }

    public int getLactanciaLMLAOtros() {
        return lactanciaLMLAOtros;
    }

    public void setLactanciaLMLAOtros(int lactanciaLMLAOtros) {
        this.lactanciaLMLAOtros = lactanciaLMLAOtros;
    }

    public int getLactanciaLA() {
        return lactanciaLA;
    }

    public void setLactanciaLA(int lactanciaLA) {
        this.lactanciaLA = lactanciaLA;
    }

    public int getLactanciaLAOtros() {
        return lactanciaLAOtros;
    }

    public void setLactanciaLAOtros(int lactanciaLAOtros) {
        this.lactanciaLAOtros = lactanciaLAOtros;
    }

    public int getAsistNadiePerfecto() {
        return asistNadiePerfecto;
    }

    public void setAsistNadiePerfecto(int asistNadiePerfecto) {
        this.asistNadiePerfecto = asistNadiePerfecto;
    }

    public int getConMaterialesEstimulacion() {
        return conMaterialesEstimulacion;
    }

    public void setConMaterialesEstimulacion(int conMaterialesEstimulacion) {
        this.conMaterialesEstimulacion = conMaterialesEstimulacion;
    }

    public int getPadrePresente() {
        return padrePresente;
    }

    public void setPadrePresente(int padrePresente) {
        this.padrePresente = padrePresente;
    }
    
    public CensoPediatriaNoREM() {
        this.numerodeNinosPediatria=0; 
        this.lactanciaLME=0; 
        this.lactanciaLMOtro=0;
        this.lactanciaLMLA=0; 
        this.lactanciaLMLAOtros=0; 
        this.lactanciaLA=0;
        this.lactanciaLAOtros=0;
        this.madreObesa=0;
        this.madreFumadora=0;
        this.madreAlcholica=0;
        this.padreObeso=0;
        this.padreFumador=0;
        this.padreAlcholico=0;
        this.asistNadiePerfecto=0; 
        this.conMaterialesEstimulacion=0; 
        this.padrePresente=0;
    }
    
}
