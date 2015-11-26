/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.cardiovascular.censo;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author daniel
 */
@Named(value = "censoCCVSeccionA")
@ViewScoped
public class CensoCCVSeccionA {

    /**
     * Creates a new instance of CensoCCVSeccionA
     */
    private String columnName1;
    private String columnName2;
    private int numerodePersonasCCV; 
    // Clasificación riesgo cardiovascular
    private int clasificacionRiesgoCCVBajo;
    private int clasificacionRiesgoCCVModerado;
    private int clasificacionRiesgoCCVAlto;
    private int clasificacionRiesgoCCVMaximo;
    // Personas bajo control según patología y factores de riesgo
    private int PBCsegunPyFRHipertensos;
    private int PBCsegunPyFRDiabeticos;
    private int PBCsegunPyFRDislipidemicos;
    private int PBCsegunPyFRTabaquismo;
    //private int PBCsegunPyFRObesidad;
    private int PBCsegunPyFRAntInfarto;
    private int PBCsegunPyFRAntEnfCerebroVascular;
    // Detección y prevención de la progresión de la enfermedad renal crónica.
    //SIN ENFERMEDAD RENAL (S/ERC)
    //ETAPA 1 Y ETAPA 2 (VFG ≥ 60 ml/min)
    //ETAPA 3 (VFG ≥30 a 59 ml/min)
    //ETAPA 4 (VFG ≥15 a 29 ml/min)
    //ETAPA 5 (VFG <15 ml/min)
    //TOTAL
    private int sinERC;
    private int Etapa1_2;
    private int Etapa3a;
    private int Etapa3b;
    private int Etapa4;
    private int Etapa5;
    private int total;
    private int pacientestotal;

    public int getPacientestotal() {
        return pacientestotal;
    }

    public void setPacientestotal(int pacientestotal) {
        this.pacientestotal = pacientestotal;
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

    public int getNumerodePersonasCCV() {
        return numerodePersonasCCV;
    }

    public void setNumerodePersonasCCV(int numerodePersonasCCV) {
        this.numerodePersonasCCV = numerodePersonasCCV;
    }

    public int getClasificacionRiesgoCCVBajo() {
        return clasificacionRiesgoCCVBajo;
    }

    public void setClasificacionRiesgoCCVBajo(int clasificacionRiesgoCCVBajo) {
        this.clasificacionRiesgoCCVBajo = clasificacionRiesgoCCVBajo;
    }

    public int getClasificacionRiesgoCCVModerado() {
        return clasificacionRiesgoCCVModerado;
    }

    public void setClasificacionRiesgoCCVModerado(int clasificacionRiesgoCCVModerado) {
        this.clasificacionRiesgoCCVModerado = clasificacionRiesgoCCVModerado;
    }

    public int getClasificacionRiesgoCCVAlto() {
        return clasificacionRiesgoCCVAlto;
    }

    public void setClasificacionRiesgoCCVAlto(int clasificacionRiesgoCCVAlto) {
        this.clasificacionRiesgoCCVAlto = clasificacionRiesgoCCVAlto;
    }

    public int getClasificacionRiesgoCCVMaximo() {
        return clasificacionRiesgoCCVMaximo;
    }

    public void setClasificacionRiesgoCCVMaximo(int clasificacionRiesgoCCVMaximo) {
        this.clasificacionRiesgoCCVMaximo = clasificacionRiesgoCCVMaximo;
    }

    public int getPBCsegunPyFRHipertensos() {
        return PBCsegunPyFRHipertensos;
    }

    public void setPBCsegunPyFRHipertensos(int PBCsegunPyFRHipertensos) {
        this.PBCsegunPyFRHipertensos = PBCsegunPyFRHipertensos;
    }

    public int getPBCsegunPyFRDiabeticos() {
        return PBCsegunPyFRDiabeticos;
    }

    public void setPBCsegunPyFRDiabeticos(int PBCsegunPyFRDiabeticos) {
        this.PBCsegunPyFRDiabeticos = PBCsegunPyFRDiabeticos;
    }

    public int getPBCsegunPyFRDislipidemicos() {
        return PBCsegunPyFRDislipidemicos;
    }

    public void setPBCsegunPyFRDislipidemicos(int PBCsegunPyFRDislipidemicos) {
        this.PBCsegunPyFRDislipidemicos = PBCsegunPyFRDislipidemicos;
    }

    public int getPBCsegunPyFRTabaquismo() {
        return PBCsegunPyFRTabaquismo;
    }

    public void setPBCsegunPyFRTabaquismo(int PBCsegunPyFRTabaquismo) {
        this.PBCsegunPyFRTabaquismo = PBCsegunPyFRTabaquismo;
    }



    public int getPBCsegunPyFRAntInfarto() {
        return PBCsegunPyFRAntInfarto;
    }

    public void setPBCsegunPyFRAntInfarto(int PBCsegunPyFRAntInfarto) {
        this.PBCsegunPyFRAntInfarto = PBCsegunPyFRAntInfarto;
    }

    public int getPBCsegunPyFRAntEnfCerebroVascular() {
        return PBCsegunPyFRAntEnfCerebroVascular;
    }

    public void setPBCsegunPyFRAntEnfCerebroVascular(int PBCsegunPyFRAntEnfCerebroVascular) {
        this.PBCsegunPyFRAntEnfCerebroVascular = PBCsegunPyFRAntEnfCerebroVascular;
    }

    public int getSinERC() {
        return sinERC;
    }

    public void setSinERC(int sinERC) {
        this.sinERC = sinERC;
    }



    public int getEtapa1_2() {
        return Etapa1_2;
    }

    public void setEtapa1_2(int Etapa1_2) {
        this.Etapa1_2 = Etapa1_2;
    }

   


    public int getEtapa4() {
        return Etapa4;
    }

    public void setEtapa4(int Etapa4) {
        this.Etapa4 = Etapa4;
    }

    public int getEtapa5() {
        return Etapa5;
    }

    public void setEtapa5(int Etapa5) {
        this.Etapa5 = Etapa5;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getEtapa3a() {
        return Etapa3a;
    }

    public void setEtapa3a(int Etapa3a) {
        this.Etapa3a = Etapa3a;
    }

    public int getEtapa3b() {
        return Etapa3b;
    }

    public void setEtapa3b(int Etapa3b) {
        this.Etapa3b = Etapa3b;
    }
    
    
    
    
    public CensoCCVSeccionA() {
        
        this.numerodePersonasCCV = 0;
        this.clasificacionRiesgoCCVBajo = 0;
        this.clasificacionRiesgoCCVModerado = 0;
        this.clasificacionRiesgoCCVAlto = 0;
        this.clasificacionRiesgoCCVMaximo = 0;
        this.PBCsegunPyFRHipertensos = 0;
        this.PBCsegunPyFRDiabeticos = 0;
        this.PBCsegunPyFRDislipidemicos = 0;
        this.PBCsegunPyFRTabaquismo = 0;
  
        this.PBCsegunPyFRAntInfarto = 0;
        this.PBCsegunPyFRAntEnfCerebroVascular = 0;
        this.sinERC = 0;
        this.Etapa1_2 = 0;
        this.Etapa3a = 0;
        this.Etapa3b = 0;
        this.Etapa4 = 0;
        this.Etapa5 = 0;
        this.total = 0;
        this.pacientestotal=0;
    }
    
}
