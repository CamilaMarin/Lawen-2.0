/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.atenciones;

import entities.Paciente;
import entities.Usuario;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author daniel
 */
@Entity
public class AtencionNutriDietoterapia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_DietoTerapia")
    private Long id;
    
    @Size(max=50)
    private String tipoDietoterapia;
    
    @JoinColumn(nullable = false)
    @ManyToOne
    private Paciente paciente;
    
   
    @NotNull(message = "Debe ingresar una Fecha de control")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fecha_control;
    private Integer edad_paciente;
    
    @JoinColumn(nullable = false)
    @ManyToOne
    private Usuario profesional;
    
    @Size(max=2000)
    private String anamnesis_nutri;
    
    private Float peso;
    private Float talla;
    private Float imc;
    private String diagnostico_nutricional;
    private Float perimetro_cintura;
    
    private Float perimetroCaderas_nutri;
    private Integer indiceCC_nutri1;
    private Integer indiceCC_nutri2;
    private Integer pa_de_pie1;
    private Integer pa_de_pie2;
    private Integer pa_sentado1;
    private Integer pa_sentado2;
    private Integer puslo;
    
    
    // FARMACOS
    private boolean sulfonilureas_bool;
    private String sulfonilureas_texto;
    private boolean biguanidas_bool;
    private String biguanidas_texto;
    private boolean insulina_bool;
    private String insulina_texto;
    private boolean diuereticosTiazidicos_bool;
    private String diuereticosTiazidicos_texto;
    private boolean diureticosDelAsa_bool;
    private String diureticosDelAsa_texto;
    private boolean deiureticosAntiAldosterona_bool;
    private String deiureticosAntiAldosterona_texto;
    private boolean betaBloqueadores_bool;
    private String betaBloqueadores_texto;
    private boolean IECA_bool;
    private String IECA_texto;
    private boolean ARAII_bool;
    private String ARAII_texto;
    private boolean calcioAntagonistas_bool;
    private String calcioAntagonistas_texto;
    private boolean esteatinas_bool;
    private String esteatinas_texto;
    private boolean fibratos_bool;
    private String fibratos_texto;
    
    /*
    (Para fármaco deben existir dos atributos por cada fármaco, un boolean (si/no) (PREDEFINIDO EN NO es muy importante) y un campo de texto de char[30])
Fármacos:
	SULFONILUREAS
	BIGUANIDAS
	INSULINA
	DIUERETICOS TIAZIDICOS
	DIURETICOS DEL ASA
	DEIURETICOS ANTI-ALDOSTERONA
	BETA BLOQUEADORES
	IECA
	ARAII
	CALCIO ANTAGONISTAS
	ESTEATINAS
	FIBRATOS
 
    */
   
    ////////
    
    // Examenes
    
    private String glicemia_estado;
    private Float glicemica_valor;
    private String hba1C_estado;
    private Float hba1C_valor;
    private String colesterolTotal_estado;
    private Float colesterolTotal_valor;
    private String colesterolLDL_estado;
    private Float colesterolLDL_valor;
    private String colesterolHDL_estado;
    private Float colesterolHDL_valor;
    private String trigliceridos_estado;
    private Float trigliceridos_valor;
    private String bilirrubinaTotal_estado;
    private Float bilirrubinaTotal_valor;
    private String bilirrubinaDirecta_estado;
    private Float bilirrubinaDirecta_valor;
    private String bilirrubinaIndirecta_estado;
    private Float bilirrubinaIndirecta_valor;
    private String creatinina_estado;
    private Float creatinina_valor;
    private String BUN_estado;
    private Float BUN_valor;
    private String MDRD_estado;
    private Float MDRD_valor;
    private String microALB24H_estado;
    private Float microALB24H_valor;
    private String clearenceCrea_estado;
    private Float clearenceCrea_valor;
    private String NaPositivo_estado;
    private Float NaPositivo_valor;
    private String KPositivo_estado;
    private Float KPositivo_valor;
    private String CLNegativo_estado;
    private Float CLNegativo_valor;
    private String GPT_estado;
    private Float GPT_valor;
    private String GOT_estado;
    private Float GOT_valor;  
    /*
(para examenes se requieren dos atributos por examen, el primer atributo un char seleccionable entre las siguientes opciones: ("VACIO" - "SE SOLICITA" - "PENDIENTE")  con "VACIO" como predefinido)
Exámenes:
-------------------------------------------------------
Para los siguientes examenes el segundo atributo debe ser un Float.
	GLICEMIA
	HBA 1C
	COLESTEROL TOTAL
	COLESTEROL LDL
	COLESTEROL HDL
	TRIGLICERIDOS
	BILIRRUBINA TOTAL
	BILIRRUBINA DIRECTA
	BILIRRUBINA INDIRECTA
	CREATININA
	BUN
	MDRD
	MICROALB 24H
	CLEARENCE CREA
	Na+
	K+
	Cl-
	GPT
	GOT
---------------------------------------------------------
*/
 
    
    private String orocultivo_estado;
    private String orocultivo_ejecucion;
    private String ECG_estado;
    private String ECG_ejecucion;
    private String fondoOJO_estado;
    private String fondoOJO_ejecucion;
    private String orinaCompleta_estado;
    private String orinaCompleta_ejecucion;
    
    /*    
-------------------------------------------------------
Para los siguientes examenes el segundo atributo debe tener un char selecionable entre las siguientes opciones: ("VACIO" - "NORMAL" - "ALTERADO") con "VACIO" preselecionado
	UROCULTIVO
	ECG
	FONDO OJO
	ORINA COMPLETA
-------------------------------------------------------
	OTROS EXAMENES (solo UN atributo que sea char[150])
   
    
    
    */
    
    private String otros_examenes;
    
    
     //// HISTORIA DIETÉTICA
    // Encuesta recordatoria 24 horas
    // Minuta desayuno
  
    @Temporal(javax.persistence.TemporalType.TIME)
    private java.util.Date desayuno_horario;
    private String desayuno_descripcion;
    @Temporal(javax.persistence.TemporalType.TIME)
    private java.util.Date colacion_horario;
    private String colacion_descripcion;
    @Temporal(javax.persistence.TemporalType.TIME)
    private java.util.Date  almuerzo_horario;
    private String almuerzo_descripcion;
    @Temporal(javax.persistence.TemporalType.TIME)
    private java.util.Date  colaciontarde_horario;
    private String colaciontarde_descripcion;
    @Temporal(javax.persistence.TemporalType.TIME)
    private java.util.Date cena_horario;
    private String cena_descripcion;
    //////
    //////
  
    @Size(max=2000)
    private String frecuencia_consumo;
    
    @Size(max=500)
    private String intolerancia_alimentaria;
    @Size(max=500)
    private String nutrientes_criticos;
    
    @Size(max=1500) 
    private String indicaciones;
    
   
  
    /// Regimen
    private boolean hiposodico;
    private boolean diabetico;
    private boolean hipocalorico;
    private Float calorias;
   
    
    @Size(max=1500) 
    private String referencias_nutri;
    private Integer punteaje_pie_dm;
    
/// ANTECEDENTES
    
    private String tabaco;
    private boolean IAM;
    private boolean ACV;
    private boolean HVI;
    private boolean IRC;
    private boolean amputacion_no_traumatica;
    private boolean ceguera;
    private boolean retinopatia;
    private boolean QUALDIAB;

    
    
    ///////////////////////
    
    private String riesgo_cardiovascular;
    private String observaciones;

    private String proximo_control;
    private String profesional_control;

    public String getTipoDietoterapia() {
        return tipoDietoterapia;
    }

    public void setTipoDietoterapia(String tipoDietoterapia) {
        this.tipoDietoterapia = tipoDietoterapia;
    }
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFecha_control() {
        return fecha_control;
    }

    public void setFecha_control(Date fecha_control) {
        this.fecha_control = fecha_control;
    }

    public Integer getEdad_paciente() {
        return edad_paciente;
    }

    public void setEdad_paciente(Integer edad_paciente) {
        this.edad_paciente = edad_paciente;
    }

    public Usuario getProfesional() {
        return profesional;
    }

    public void setProfesional(Usuario profesional) {
        this.profesional = profesional;
    }

    public String getAnamnesis_nutri() {
        return anamnesis_nutri;
    }

    public void setAnamnesis_nutri(String anamnesis_nutri) {
        this.anamnesis_nutri = anamnesis_nutri;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getTalla() {
        return talla;
    }

    public void setTalla(Float talla) {
        this.talla = talla;
    }

    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    public String getDiagnostico_nutricional() {
        return diagnostico_nutricional;
    }

    public void setDiagnostico_nutricional(String diagnostico_nutricional) {
        this.diagnostico_nutricional = diagnostico_nutricional;
    }

    public Float getPerimetro_cintura() {
        return perimetro_cintura;
    }

    public void setPerimetro_cintura(Float perimetro_cintura) {
        this.perimetro_cintura = perimetro_cintura;
    }

    public Float getPerimetroCaderas_nutri() {
        return perimetroCaderas_nutri;
    }

    public void setPerimetroCaderas_nutri(Float perimetroCaderas_nutri) {
        this.perimetroCaderas_nutri = perimetroCaderas_nutri;
    }

    public Integer getIndiceCC_nutri1() {
        return indiceCC_nutri1;
    }

    public void setIndiceCC_nutri1(Integer indiceCC_nutri1) {
        this.indiceCC_nutri1 = indiceCC_nutri1;
    }

    public Integer getIndiceCC_nutri2() {
        return indiceCC_nutri2;
    }

    public void setIndiceCC_nutri2(Integer indiceCC_nutri2) {
        this.indiceCC_nutri2 = indiceCC_nutri2;
    }

    public Integer getPa_de_pie1() {
        return pa_de_pie1;
    }

    public void setPa_de_pie1(Integer pa_de_pie1) {
        this.pa_de_pie1 = pa_de_pie1;
    }

    public Integer getPa_de_pie2() {
        return pa_de_pie2;
    }

    public void setPa_de_pie2(Integer pa_de_pie2) {
        this.pa_de_pie2 = pa_de_pie2;
    }

    public Integer getPa_sentado1() {
        return pa_sentado1;
    }

    public void setPa_sentado1(Integer pa_sentado1) {
        this.pa_sentado1 = pa_sentado1;
    }

    public Integer getPa_sentado2() {
        return pa_sentado2;
    }

    public void setPa_sentado2(Integer pa_sentado2) {
        this.pa_sentado2 = pa_sentado2;
    }

    public Integer getPuslo() {
        return puslo;
    }

    public void setPuslo(Integer puslo) {
        this.puslo = puslo;
    }

    public boolean isSulfonilureas_bool() {
        return sulfonilureas_bool;
    }

    public void setSulfonilureas_bool(boolean sulfonilureas_bool) {
        this.sulfonilureas_bool = sulfonilureas_bool;
    }

    public String getSulfonilureas_texto() {
        return sulfonilureas_texto;
    }

    public void setSulfonilureas_texto(String sulfonilureas_texto) {
        this.sulfonilureas_texto = sulfonilureas_texto;
    }

    public boolean isBiguanidas_bool() {
        return biguanidas_bool;
    }

    public void setBiguanidas_bool(boolean biguanidas_bool) {
        this.biguanidas_bool = biguanidas_bool;
    }

    public String getBiguanidas_texto() {
        return biguanidas_texto;
    }

    public void setBiguanidas_texto(String biguanidas_texto) {
        this.biguanidas_texto = biguanidas_texto;
    }

    public boolean isInsulina_bool() {
        return insulina_bool;
    }

    public void setInsulina_bool(boolean insulina_bool) {
        this.insulina_bool = insulina_bool;
    }

    public String getInsulina_texto() {
        return insulina_texto;
    }

    public void setInsulina_texto(String insulina_texto) {
        this.insulina_texto = insulina_texto;
    }

    public boolean isDiuereticosTiazidicos_bool() {
        return diuereticosTiazidicos_bool;
    }

    public void setDiuereticosTiazidicos_bool(boolean diuereticosTiazidicos_bool) {
        this.diuereticosTiazidicos_bool = diuereticosTiazidicos_bool;
    }

    public String getDiuereticosTiazidicos_texto() {
        return diuereticosTiazidicos_texto;
    }

    public void setDiuereticosTiazidicos_texto(String diuereticosTiazidicos_texto) {
        this.diuereticosTiazidicos_texto = diuereticosTiazidicos_texto;
    }

    public boolean isDiureticosDelAsa_bool() {
        return diureticosDelAsa_bool;
    }

    public void setDiureticosDelAsa_bool(boolean diureticosDelAsa_bool) {
        this.diureticosDelAsa_bool = diureticosDelAsa_bool;
    }

    public String getDiureticosDelAsa_texto() {
        return diureticosDelAsa_texto;
    }

    public void setDiureticosDelAsa_texto(String diureticosDelAsa_texto) {
        this.diureticosDelAsa_texto = diureticosDelAsa_texto;
    }

    public boolean isDeiureticosAntiAldosterona_bool() {
        return deiureticosAntiAldosterona_bool;
    }

    public void setDeiureticosAntiAldosterona_bool(boolean deiureticosAntiAldosterona_bool) {
        this.deiureticosAntiAldosterona_bool = deiureticosAntiAldosterona_bool;
    }

    public String getDeiureticosAntiAldosterona_texto() {
        return deiureticosAntiAldosterona_texto;
    }

    public void setDeiureticosAntiAldosterona_texto(String deiureticosAntiAldosterona_texto) {
        this.deiureticosAntiAldosterona_texto = deiureticosAntiAldosterona_texto;
    }

    public boolean isBetaBloqueadores_bool() {
        return betaBloqueadores_bool;
    }

    public void setBetaBloqueadores_bool(boolean betaBloqueadores_bool) {
        this.betaBloqueadores_bool = betaBloqueadores_bool;
    }

    public String getBetaBloqueadores_texto() {
        return betaBloqueadores_texto;
    }

    public void setBetaBloqueadores_texto(String betaBloqueadores_texto) {
        this.betaBloqueadores_texto = betaBloqueadores_texto;
    }

    public boolean isIECA_bool() {
        return IECA_bool;
    }

    public void setIECA_bool(boolean IECA_bool) {
        this.IECA_bool = IECA_bool;
    }

    public String getIECA_texto() {
        return IECA_texto;
    }

    public void setIECA_texto(String IECA_texto) {
        this.IECA_texto = IECA_texto;
    }

    public boolean isARAII_bool() {
        return ARAII_bool;
    }

    public void setARAII_bool(boolean ARAII_bool) {
        this.ARAII_bool = ARAII_bool;
    }

    public String getARAII_texto() {
        return ARAII_texto;
    }

    public void setARAII_texto(String ARAII_texto) {
        this.ARAII_texto = ARAII_texto;
    }

    public boolean isCalcioAntagonistas_bool() {
        return calcioAntagonistas_bool;
    }

    public void setCalcioAntagonistas_bool(boolean calcioAntagonistas_bool) {
        this.calcioAntagonistas_bool = calcioAntagonistas_bool;
    }

    public String getCalcioAntagonistas_texto() {
        return calcioAntagonistas_texto;
    }

    public void setCalcioAntagonistas_texto(String calcioAntagonistas_texto) {
        this.calcioAntagonistas_texto = calcioAntagonistas_texto;
    }

    public boolean isEsteatinas_bool() {
        return esteatinas_bool;
    }

    public void setEsteatinas_bool(boolean esteatinas_bool) {
        this.esteatinas_bool = esteatinas_bool;
    }

    public String getEsteatinas_texto() {
        return esteatinas_texto;
    }

    public void setEsteatinas_texto(String esteatinas_texto) {
        this.esteatinas_texto = esteatinas_texto;
    }

    public boolean isFibratos_bool() {
        return fibratos_bool;
    }

    public void setFibratos_bool(boolean fibratos_bool) {
        this.fibratos_bool = fibratos_bool;
    }

    public String getFibratos_texto() {
        return fibratos_texto;
    }

    public void setFibratos_texto(String fibratos_texto) {
        this.fibratos_texto = fibratos_texto;
    }

    public String getGlicemia_estado() {
        return glicemia_estado;
    }

    public void setGlicemia_estado(String glicemia_estado) {
        this.glicemia_estado = glicemia_estado;
    }

    public Float getGlicemica_valor() {
        return glicemica_valor;
    }

    public void setGlicemica_valor(Float glicemica_valor) {
        this.glicemica_valor = glicemica_valor;
    }

    public String getHba1C_estado() {
        return hba1C_estado;
    }

    public void setHba1C_estado(String hba1C_estado) {
        this.hba1C_estado = hba1C_estado;
    }

    public Float getHba1C_valor() {
        return hba1C_valor;
    }

    public void setHba1C_valor(Float hba1C_valor) {
        this.hba1C_valor = hba1C_valor;
    }

    public String getColesterolTotal_estado() {
        return colesterolTotal_estado;
    }

    public void setColesterolTotal_estado(String colesterolTotal_estado) {
        this.colesterolTotal_estado = colesterolTotal_estado;
    }

    public Float getColesterolTotal_valor() {
        return colesterolTotal_valor;
    }

    public void setColesterolTotal_valor(Float colesterolTotal_valor) {
        this.colesterolTotal_valor = colesterolTotal_valor;
    }

    public String getColesterolLDL_estado() {
        return colesterolLDL_estado;
    }

    public void setColesterolLDL_estado(String colesterolLDL_estado) {
        this.colesterolLDL_estado = colesterolLDL_estado;
    }

    public Float getColesterolLDL_valor() {
        return colesterolLDL_valor;
    }

    public void setColesterolLDL_valor(Float colesterolLDL_valor) {
        this.colesterolLDL_valor = colesterolLDL_valor;
    }

    public String getColesterolHDL_estado() {
        return colesterolHDL_estado;
    }

    public void setColesterolHDL_estado(String colesterolHDL_estado) {
        this.colesterolHDL_estado = colesterolHDL_estado;
    }

    public Float getColesterolHDL_valor() {
        return colesterolHDL_valor;
    }

    public void setColesterolHDL_valor(Float colesterolHDL_valor) {
        this.colesterolHDL_valor = colesterolHDL_valor;
    }

    public String getTrigliceridos_estado() {
        return trigliceridos_estado;
    }

    public void setTrigliceridos_estado(String trigliceridos_estado) {
        this.trigliceridos_estado = trigliceridos_estado;
    }

    public Float getTrigliceridos_valor() {
        return trigliceridos_valor;
    }

    public void setTrigliceridos_valor(Float trigliceridos_valor) {
        this.trigliceridos_valor = trigliceridos_valor;
    }

    public String getBilirrubinaTotal_estado() {
        return bilirrubinaTotal_estado;
    }

    public void setBilirrubinaTotal_estado(String bilirrubinaTotal_estado) {
        this.bilirrubinaTotal_estado = bilirrubinaTotal_estado;
    }

    public Float getBilirrubinaTotal_valor() {
        return bilirrubinaTotal_valor;
    }

    public void setBilirrubinaTotal_valor(Float bilirrubinaTotal_valor) {
        this.bilirrubinaTotal_valor = bilirrubinaTotal_valor;
    }

    public String getBilirrubinaDirecta_estado() {
        return bilirrubinaDirecta_estado;
    }

    public void setBilirrubinaDirecta_estado(String bilirrubinaDirecta_estado) {
        this.bilirrubinaDirecta_estado = bilirrubinaDirecta_estado;
    }

    public Float getBilirrubinaDirecta_valor() {
        return bilirrubinaDirecta_valor;
    }

    public void setBilirrubinaDirecta_valor(Float bilirrubinaDirecta_valor) {
        this.bilirrubinaDirecta_valor = bilirrubinaDirecta_valor;
    }

    public String getBilirrubinaIndirecta_estado() {
        return bilirrubinaIndirecta_estado;
    }

    public void setBilirrubinaIndirecta_estado(String bilirrubinaIndirecta_estado) {
        this.bilirrubinaIndirecta_estado = bilirrubinaIndirecta_estado;
    }

    public Float getBilirrubinaIndirecta_valor() {
        return bilirrubinaIndirecta_valor;
    }

    public void setBilirrubinaIndirecta_valor(Float bilirrubinaIndirecta_valor) {
        this.bilirrubinaIndirecta_valor = bilirrubinaIndirecta_valor;
    }

    public String getCreatinina_estado() {
        return creatinina_estado;
    }

    public void setCreatinina_estado(String creatinina_estado) {
        this.creatinina_estado = creatinina_estado;
    }

    public Float getCreatinina_valor() {
        return creatinina_valor;
    }

    public void setCreatinina_valor(Float creatinina_valor) {
        this.creatinina_valor = creatinina_valor;
    }

    public String getBUN_estado() {
        return BUN_estado;
    }

    public void setBUN_estado(String BUN_estado) {
        this.BUN_estado = BUN_estado;
    }

    public Float getBUN_valor() {
        return BUN_valor;
    }

    public void setBUN_valor(Float BUN_valor) {
        this.BUN_valor = BUN_valor;
    }

    public String getMDRD_estado() {
        return MDRD_estado;
    }

    public void setMDRD_estado(String MDRD_estado) {
        this.MDRD_estado = MDRD_estado;
    }

    public Float getMDRD_valor() {
        return MDRD_valor;
    }

    public void setMDRD_valor(Float MDRD_valor) {
        this.MDRD_valor = MDRD_valor;
    }

    public String getMicroALB24H_estado() {
        return microALB24H_estado;
    }

    public void setMicroALB24H_estado(String microALB24H_estado) {
        this.microALB24H_estado = microALB24H_estado;
    }

    public Float getMicroALB24H_valor() {
        return microALB24H_valor;
    }

    public void setMicroALB24H_valor(Float microALB24H_valor) {
        this.microALB24H_valor = microALB24H_valor;
    }

    public String getClearenceCrea_estado() {
        return clearenceCrea_estado;
    }

    public void setClearenceCrea_estado(String clearenceCrea_estado) {
        this.clearenceCrea_estado = clearenceCrea_estado;
    }

    public Float getClearenceCrea_valor() {
        return clearenceCrea_valor;
    }

    public void setClearenceCrea_valor(Float clearenceCrea_valor) {
        this.clearenceCrea_valor = clearenceCrea_valor;
    }

    public String getNaPositivo_estado() {
        return NaPositivo_estado;
    }

    public void setNaPositivo_estado(String NaPositivo_estado) {
        this.NaPositivo_estado = NaPositivo_estado;
    }

    public Float getNaPositivo_valor() {
        return NaPositivo_valor;
    }

    public void setNaPositivo_valor(Float NaPositivo_valor) {
        this.NaPositivo_valor = NaPositivo_valor;
    }

    public String getKPositivo_estado() {
        return KPositivo_estado;
    }

    public void setKPositivo_estado(String KPositivo_estado) {
        this.KPositivo_estado = KPositivo_estado;
    }

    public Float getKPositivo_valor() {
        return KPositivo_valor;
    }

    public void setKPositivo_valor(Float KPositivo_valor) {
        this.KPositivo_valor = KPositivo_valor;
    }

    public String getCLNegativo_estado() {
        return CLNegativo_estado;
    }

    public void setCLNegativo_estado(String CLNegativo_estado) {
        this.CLNegativo_estado = CLNegativo_estado;
    }

    public Float getCLNegativo_valor() {
        return CLNegativo_valor;
    }

    public void setCLNegativo_valor(Float CLNegativo_valor) {
        this.CLNegativo_valor = CLNegativo_valor;
    }

    public String getGPT_estado() {
        return GPT_estado;
    }

    public void setGPT_estado(String GPT_estado) {
        this.GPT_estado = GPT_estado;
    }

    public Float getGPT_valor() {
        return GPT_valor;
    }

    public void setGPT_valor(Float GPT_valor) {
        this.GPT_valor = GPT_valor;
    }

    public String getGOT_estado() {
        return GOT_estado;
    }

    public void setGOT_estado(String GOT_estado) {
        this.GOT_estado = GOT_estado;
    }

    public Float getGOT_valor() {
        return GOT_valor;
    }

    public void setGOT_valor(Float GOT_valor) {
        this.GOT_valor = GOT_valor;
    }

    public String getOrocultivo_estado() {
        return orocultivo_estado;
    }

    public void setOrocultivo_estado(String orocultivo_estado) {
        this.orocultivo_estado = orocultivo_estado;
    }

    public String getOrocultivo_ejecucion() {
        return orocultivo_ejecucion;
    }

    public void setOrocultivo_ejecucion(String orocultivo_ejecucion) {
        this.orocultivo_ejecucion = orocultivo_ejecucion;
    }

    public String getECG_estado() {
        return ECG_estado;
    }

    public void setECG_estado(String ECG_estado) {
        this.ECG_estado = ECG_estado;
    }

    public String getECG_ejecucion() {
        return ECG_ejecucion;
    }

    public void setECG_ejecucion(String ECG_ejecucion) {
        this.ECG_ejecucion = ECG_ejecucion;
    }

    public String getFondoOJO_estado() {
        return fondoOJO_estado;
    }

    public void setFondoOJO_estado(String fondoOJO_estado) {
        this.fondoOJO_estado = fondoOJO_estado;
    }

    public String getFondoOJO_ejecucion() {
        return fondoOJO_ejecucion;
    }

    public void setFondoOJO_ejecucion(String fondoOJO_ejecucion) {
        this.fondoOJO_ejecucion = fondoOJO_ejecucion;
    }

    public String getOrinaCompleta_estado() {
        return orinaCompleta_estado;
    }

    public void setOrinaCompleta_estado(String orinaCompleta_estado) {
        this.orinaCompleta_estado = orinaCompleta_estado;
    }

    public String getOrinaCompleta_ejecucion() {
        return orinaCompleta_ejecucion;
    }

    public void setOrinaCompleta_ejecucion(String orinaCompleta_ejecucion) {
        this.orinaCompleta_ejecucion = orinaCompleta_ejecucion;
    }

    public String getOtros_examenes() {
        return otros_examenes;
    }

    public void setOtros_examenes(String otros_examenes) {
        this.otros_examenes = otros_examenes;
    }

    public Date getDesayuno_horario() {
        return desayuno_horario;
    }

    public void setDesayuno_horario(Date desayuno_horario) {
        this.desayuno_horario = desayuno_horario;
    }

    public String getDesayuno_descripcion() {
        return desayuno_descripcion;
    }

    public void setDesayuno_descripcion(String desayuno_descripcion) {
        this.desayuno_descripcion = desayuno_descripcion;
    }

    public Date getColacion_horario() {
        return colacion_horario;
    }

    public void setColacion_horario(Date colacion_horario) {
        this.colacion_horario = colacion_horario;
    }

    public String getColacion_descripcion() {
        return colacion_descripcion;
    }

    public void setColacion_descripcion(String colacion_descripcion) {
        this.colacion_descripcion = colacion_descripcion;
    }

    public Date getAlmuerzo_horario() {
        return almuerzo_horario;
    }

    public void setAlmuerzo_horario(Date almuerzo_horario) {
        this.almuerzo_horario = almuerzo_horario;
    }

    public String getAlmuerzo_descripcion() {
        return almuerzo_descripcion;
    }

    public void setAlmuerzo_descripcion(String almuerzo_descripcion) {
        this.almuerzo_descripcion = almuerzo_descripcion;
    }

    public Date getColaciontarde_horario() {
        return colaciontarde_horario;
    }

    public void setColaciontarde_horario(Date colaciontarde_horario) {
        this.colaciontarde_horario = colaciontarde_horario;
    }

    public String getColaciontarde_descripcion() {
        return colaciontarde_descripcion;
    }

    public void setColaciontarde_descripcion(String colaciontarde_descripcion) {
        this.colaciontarde_descripcion = colaciontarde_descripcion;
    }

    public Date getCena_horario() {
        return cena_horario;
    }

    public void setCena_horario(Date cena_horario) {
        this.cena_horario = cena_horario;
    }

    public String getCena_descripcion() {
        return cena_descripcion;
    }

    public void setCena_descripcion(String cena_descripcion) {
        this.cena_descripcion = cena_descripcion;
    }

    
    public String getFrecuencia_consumo() {
        return frecuencia_consumo;
    }

    public void setFrecuencia_consumo(String frecuencia_consumo) {
        this.frecuencia_consumo = frecuencia_consumo;
    }

    public String getIntolerancia_alimentaria() {
        return intolerancia_alimentaria;
    }

    public void setIntolerancia_alimentaria(String intolerancia_alimentaria) {
        this.intolerancia_alimentaria = intolerancia_alimentaria;
    }

    public String getNutrientes_criticos() {
        return nutrientes_criticos;
    }

    public void setNutrientes_criticos(String nutrientes_criticos) {
        this.nutrientes_criticos = nutrientes_criticos;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public boolean isHiposodico() {
        return hiposodico;
    }

    public void setHiposodico(boolean hiposodico) {
        this.hiposodico = hiposodico;
    }

    public boolean isDiabetico() {
        return diabetico;
    }

    public void setDiabetico(boolean diabetico) {
        this.diabetico = diabetico;
    }

    public boolean isHipocalorico() {
        return hipocalorico;
    }

    public void setHipocalorico(boolean hipocalorico) {
        this.hipocalorico = hipocalorico;
    }

    public Float getCalorias() {
        return calorias;
    }

    public void setCalorias(Float calorias) {
        this.calorias = calorias;
    }

    public String getReferencias_nutri() {
        return referencias_nutri;
    }

    public void setReferencias_nutri(String referencias_nutri) {
        this.referencias_nutri = referencias_nutri;
    }

    public Integer getPunteaje_pie_dm() {
        return punteaje_pie_dm;
    }

    public void setPunteaje_pie_dm(Integer punteaje_pie_dm) {
        this.punteaje_pie_dm = punteaje_pie_dm;
    }

    public String getTabaco() {
        return tabaco;
    }

    public void setTabaco(String tabaco) {
        this.tabaco = tabaco;
    }

    public boolean isIAM() {
        return IAM;
    }

    public void setIAM(boolean IAM) {
        this.IAM = IAM;
    }

    public boolean isACV() {
        return ACV;
    }

    public void setACV(boolean ACV) {
        this.ACV = ACV;
    }

    public boolean isHVI() {
        return HVI;
    }

    public void setHVI(boolean HVI) {
        this.HVI = HVI;
    }

    public boolean isIRC() {
        return IRC;
    }

    public void setIRC(boolean IRC) {
        this.IRC = IRC;
    }

    public boolean isAmputacion_no_traumatica() {
        return amputacion_no_traumatica;
    }

    public void setAmputacion_no_traumatica(boolean amputacion_no_traumatica) {
        this.amputacion_no_traumatica = amputacion_no_traumatica;
    }

    public boolean isCeguera() {
        return ceguera;
    }

    public void setCeguera(boolean ceguera) {
        this.ceguera = ceguera;
    }

    public boolean isRetinopatia() {
        return retinopatia;
    }

    public void setRetinopatia(boolean retinopatia) {
        this.retinopatia = retinopatia;
    }

    public boolean isQUALDIAB() {
        return QUALDIAB;
    }

    public void setQUALDIAB(boolean QUALDIAB) {
        this.QUALDIAB = QUALDIAB;
    }

    public String getRiesgo_cardiovascular() {
        return riesgo_cardiovascular;
    }

    public void setRiesgo_cardiovascular(String riesgo_cardiovascular) {
        this.riesgo_cardiovascular = riesgo_cardiovascular;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getProximo_control() {
        return proximo_control;
    }

    public void setProximo_control(String proximo_control) {
        this.proximo_control = proximo_control;
    }

    public String getProfesional_control() {
        return profesional_control;
    }

    public void setProfesional_control(String profesional_control) {
        this.profesional_control = profesional_control;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtencionNutriDietoterapia)) {
            return false;
        }
        AtencionNutriDietoterapia other = (AtencionNutriDietoterapia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.atenciones.AtencionNutriDietoterapiaControl[ id=" + id + " ]";
    }
    
}