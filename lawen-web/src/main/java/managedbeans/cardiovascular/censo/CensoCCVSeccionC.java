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
@Named(value = "censoCCVSeccionC")
@ViewScoped
public class CensoCCVSeccionC {

    /**
     * Creates a new instance of CensoCCVSeccionC
     */
    private String columnName1;
    private String columnName2;
    //PERSONAS DIABETICAS EN PSCV	
    //PACIENTES CON DIABETES INGRESADOS LOS ÚLTIMOS 12 MESES	CON RAZON ALBÚMINA CREATININA (RAC).
    //PACIENTES CON DIABETES INGRESADOS LOS ÚLTIMOS 12 MESES	CON VELOCIDAD DE FILTRACIÓN GLOMERULAR (VFG).
    //PACIENTES CON DIABETES INGRESADOS LOS ÚLTIMOS 12 MESES    CON FONDO DE OJO.
    private Integer PDI12MESES_RAC;
    private Integer PDI12MESES_VFG;
    private Integer PDI12MESES_FondoDeOjo;
    
    //EN TRATAMIENTO CON INSULINA	
    private Integer TratamientoInsulina;
    //CON HbA1C>= 9 %	
    private Integer HbA1C9;
    //EN TRATAMIENTO CON IECA O ARA II.	
    private Integer TratamientoConIECAoARRAII;
    //CON UN EXÁMEN DE COLESTEROL LDL VIGENTE.	
    private Integer ExamenColesterolLDLVigente;
    
    //CON "EVALUACIÓN VIGENTE DEL PIE SEGÚN PAUTA DE ESTIMACION DEL RIESGO DE ULCERACION EN PERSONAS CON DIABETES     Riesgo bajo
    private Integer Ulceracion_RiesgoBajo;
    //CON "EVALUACIÓN VIGENTE DEL PIE SEGÚN PAUTA DE ESTIMACION DEL RIESGO DE ULCERACION EN PERSONAS CON DIABETES     Riesgo moderado 
    private Integer Ulceracion_RiesgoModerado;
    //CON "EVALUACIÓN VIGENTE DEL PIE SEGÚN PAUTA DE ESTIMACION DEL RIESGO DE ULCERACION EN PERSONAS CON DIABETES     Riesgo alto
    private Integer Ulceracion_RiesgoAlto;
    //CON "EVALUACIÓN VIGENTE DEL PIE SEGÚN PAUTA DE ESTIMACION DEL RIESGO DE ULCERACION EN PERSONAS CON DIABETES     Riesgo máximo 
    private Integer Ulceracion_RiesgoMaximo;
    
    //CON ÚLCERAS ACTIVAS DE PIE TRATADAS CON CURACIÓN      Curación Convencional
    private Integer UlcerasActivas_CuracionCo;
    //CON ÚLCERAS ACTIVAS DE PIE TRATADAS CON CURACIÓN      Curación Avanzada
    private Integer UlcerasActivas_CuracionAvan;
    //PACIENTES DIABETICOS CON EVALUACIÓN, EN LOS ULTIMOS 12 MESES, DE CALIDAD REGISTRADA EN QUALIDIAB U OTRO SISTEMA INFORMÁTICO	
    private Integer PDE12Meses_Qualdiab_Otros;
    private Integer RAC;

    public Integer getRAC() {
        return RAC;
    }

    public void setRAC(Integer RAC) {
        this.RAC = RAC;
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

    public Integer getPDI12MESES_RAC() {
        return PDI12MESES_RAC;
    }

    public void setPDI12MESES_RAC(Integer PDI12MESES_RAC) {
        this.PDI12MESES_RAC = PDI12MESES_RAC;
    }

    public Integer getPDI12MESES_VFG() {
        return PDI12MESES_VFG;
    }

    public void setPDI12MESES_VFG(Integer PDI12MESES_VFG) {
        this.PDI12MESES_VFG = PDI12MESES_VFG;
    }

    public Integer getPDI12MESES_FondoDeOjo() {
        return PDI12MESES_FondoDeOjo;
    }

    public void setPDI12MESES_FondoDeOjo(Integer PDI12MESES_FondoDeOjo) {
        this.PDI12MESES_FondoDeOjo = PDI12MESES_FondoDeOjo;
    }

    public Integer getTratamientoInsulina() {
        return TratamientoInsulina;
    }

    public void setTratamientoInsulina(Integer TratamientoInsulina) {
        this.TratamientoInsulina = TratamientoInsulina;
    }

    public Integer getHbA1C9() {
        return HbA1C9;
    }

    public void setHbA1C9(Integer HbA1C9) {
        this.HbA1C9 = HbA1C9;
    }

    public Integer getTratamientoConIECAoARRAII() {
        return TratamientoConIECAoARRAII;
    }

    public void setTratamientoConIECAoARRAII(Integer TratamientoConIECAoARRAII) {
        this.TratamientoConIECAoARRAII = TratamientoConIECAoARRAII;
    }

    public Integer getExamenColesterolLDLVigente() {
        return ExamenColesterolLDLVigente;
    }

    public void setExamenColesterolLDLVigente(Integer ExamenColesterolLDLVigente) {
        this.ExamenColesterolLDLVigente = ExamenColesterolLDLVigente;
    }

    public Integer getUlceracion_RiesgoBajo() {
        return Ulceracion_RiesgoBajo;
    }

    public void setUlceracion_RiesgoBajo(Integer Ulceracion_RiesgoBajo) {
        this.Ulceracion_RiesgoBajo = Ulceracion_RiesgoBajo;
    }

    public Integer getUlceracion_RiesgoModerado() {
        return Ulceracion_RiesgoModerado;
    }

    public void setUlceracion_RiesgoModerado(Integer Ulceracion_RiesgoModerado) {
        this.Ulceracion_RiesgoModerado = Ulceracion_RiesgoModerado;
    }

    public Integer getUlceracion_RiesgoAlto() {
        return Ulceracion_RiesgoAlto;
    }

    public void setUlceracion_RiesgoAlto(Integer Ulceracion_RiesgoAlto) {
        this.Ulceracion_RiesgoAlto = Ulceracion_RiesgoAlto;
    }

    public Integer getUlceracion_RiesgoMaximo() {
        return Ulceracion_RiesgoMaximo;
    }

    public void setUlceracion_RiesgoMaximo(Integer Ulceracion_RiesgoMaximo) {
        this.Ulceracion_RiesgoMaximo = Ulceracion_RiesgoMaximo;
    }

    public Integer getUlcerasActivas_CuracionCo() {
        return UlcerasActivas_CuracionCo;
    }

    public void setUlcerasActivas_CuracionCo(Integer UlcerasActivas_CuracionCo) {
        this.UlcerasActivas_CuracionCo = UlcerasActivas_CuracionCo;
    }

    public Integer getUlcerasActivas_CuracionAvan() {
        return UlcerasActivas_CuracionAvan;
    }

    public void setUlcerasActivas_CuracionAvan(Integer UlcerasActivas_CuracionAvan) {
        this.UlcerasActivas_CuracionAvan = UlcerasActivas_CuracionAvan;
    }

    public Integer getPDE12Meses_Qualdiab_Otros() {
        return PDE12Meses_Qualdiab_Otros;
    }

    public void setPDE12Meses_Qualdiab_Otros(Integer PDE12Meses_Qualdiab_Otros) {
        this.PDE12Meses_Qualdiab_Otros = PDE12Meses_Qualdiab_Otros;
    }
    
    
    
    
    
    public CensoCCVSeccionC() {
        this.PDI12MESES_RAC =0;
        this.PDI12MESES_VFG =0;
        this.PDI12MESES_FondoDeOjo =0;
        this.TratamientoInsulina =0;
        this.HbA1C9 =0;
        this.TratamientoConIECAoARRAII =0;
        this.ExamenColesterolLDLVigente =0;
        this.Ulceracion_RiesgoBajo =0;
        this.Ulceracion_RiesgoModerado =0;
        this.Ulceracion_RiesgoAlto =0;
        this.Ulceracion_RiesgoMaximo =0;
        this.UlcerasActivas_CuracionCo =0;
        this.UlcerasActivas_CuracionAvan =0;
        this.PDE12Meses_Qualdiab_Otros =0;
        this.RAC=0;
    }
    
}
