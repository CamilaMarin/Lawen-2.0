/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.cardiovascular.censo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author daniel
 */
@Named(value = "censoCCVSeccionB")
@ViewScoped
public class CensoCCVSeccionB {

    /**
     * Creates a new instance of CensoCCVSeccionB
     */
    private String columnName1;
    private String columnName2;
    //PERSONAS BAJO CONTROL POR HIPERTENSION            PA < 140/90 mmHg 
    //PERSONAS BAJO CONTROL POR DIABETES MELLITUS	HbA1C<7% 
    //PERSONAS BAJO CONTROL POR DIABETES MELLITUS       HbA1C<7% - PA < 130/80mmHg y Colesterol LDL < 100 mg/dl
    //PERSONAS BAJO CONTROL EN RIESGO CV. No diabéticas                         Alto y Muy Alto con Col. LDL < 100 mg/dL
    //PERSONAS BAJO CONTROL con antecedentes Enfermedad Cardiovascular (ECV)	En tratamiento con Acido Acetilsalicílico 
    //PERSONAS BAJO CONTROL con antecedentes Enfermedad Cardiovascular (ECV)    En tratamiento con Estatina
    private Integer PBCHipertensionPAMen140_90;
    private Integer PBCDiabetesHbA1CMen7;
    private Integer PBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100;
    private Integer PBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100;
    private Integer PBCconAntecedentesCCV_TratramientoAcidoAcetil;
    private Integer PBCconAntecedentesCCV_TratramientoEstanina;

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

    public Integer getPBCHipertensionPAMen140_90() {
        return PBCHipertensionPAMen140_90;
    }

    public void setPBCHipertensionPAMen140_90(Integer PBCHipertensionPAMen140_90) {
        this.PBCHipertensionPAMen140_90 = PBCHipertensionPAMen140_90;
    }

    public Integer getPBCDiabetesHbA1CMen7() {
        return PBCDiabetesHbA1CMen7;
    }

    public void setPBCDiabetesHbA1CMen7(Integer PBCDiabetesHbA1CMen7) {
        this.PBCDiabetesHbA1CMen7 = PBCDiabetesHbA1CMen7;
    }

    public Integer getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() {
        return PBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100;
    }

    public void setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(Integer PBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100) {
        this.PBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100 = PBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100;
    }

    public Integer getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() {
        return PBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100;
    }

    public void setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(Integer PBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100) {
        this.PBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100 = PBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100;
    }

    public Integer getPBCconAntecedentesCCV_TratramientoAcidoAcetil() {
        return PBCconAntecedentesCCV_TratramientoAcidoAcetil;
    }

    public void setPBCconAntecedentesCCV_TratramientoAcidoAcetil(Integer PBCconAntecedentesCCV_TratramientoAcidoAcetil) {
        this.PBCconAntecedentesCCV_TratramientoAcidoAcetil = PBCconAntecedentesCCV_TratramientoAcidoAcetil;
    }

    public Integer getPBCconAntecedentesCCV_TratramientoEstanina() {
        return PBCconAntecedentesCCV_TratramientoEstanina;
    }

    public void setPBCconAntecedentesCCV_TratramientoEstanina(Integer PBCconAntecedentesCCV_TratramientoEstanina) {
        this.PBCconAntecedentesCCV_TratramientoEstanina = PBCconAntecedentesCCV_TratramientoEstanina;
    }
    
    
    
    
    
    public CensoCCVSeccionB() {
            this.columnName1="";
            this.columnName2="";
            this.PBCHipertensionPAMen140_90 =0;
            this.PBCDiabetesHbA1CMen7 =0;
            this.PBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100 =0;
            this.PBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100 =0;
            this.PBCconAntecedentesCCV_TratramientoAcidoAcetil =0;
            this.PBCconAntecedentesCCV_TratramientoEstanina =0;
        
    }
    
}
