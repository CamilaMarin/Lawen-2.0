/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.cardiovascular;


import entities.Paciente;
import entities.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartolaSeguimientoCCV.findAll", query = "SELECT c FROM CartolaSeguimientoCCV c"),
    @NamedQuery(name = "CartolaSeguimientoCCV.findbyPaciente", query = "SELECT c FROM CartolaSeguimientoCCV c WHERE c.paciente=:paciente")

})
public class CartolaSeguimientoCCV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_cartolaSeguimiento")
    private Long id;
    
    
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
    
    private float peso;
    private float talla;
    private float imc;
    private String diagnostico_nutricional;
    private float perimetro_cintura;
    
    ///////// REINGRESO!!!!
    private String ingreso_reingreso;
    
    /// Regimen
    private boolean hiposodico;
    private boolean diabetico;
    private boolean hipocalorico;
    private float calorias;
    
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
    private Integer pa_de_pie1;
    private Integer pa_de_pie2;
    private Integer pa_sentado1;
    private Integer pa_sentado2;
    private Integer puslo;
    private Integer punteaje_pie_dm;
    
    // Examenes
    
    private String glicemia_estado;
    private float glicemica_valor;
    private String hba1C_estado;
    private float hba1C_valor;
    private String colesterolTotal_estado;
    private float colesterolTotal_valor;
    private String colesterolLDL_estado;
    private float colesterolLDL_valor;
    private String colesterolHDL_estado;
    private float colesterolHDL_valor;
    private String trigliceridos_estado;
    private float trigliceridos_valor;
    private String bilirrubinaTotal_estado;
    private float bilirrubinaTotal_valor;
    private String bilirrubinaDirecta_estado;
    private float bilirrubinaDirecta_valor;
    private String bilirrubinaIndirecta_estado;
    private float bilirrubinaIndirecta_valor;
    private String creatinina_estado;
    private float creatinina_valor;
    private String BUN_estado;
    private float BUN_valor;
    private String MDRD_estado;
    private float MDRD_valor;
    private String microALB24H_estado;
    private float microALB24H_valor;
    private String clearenceCrea_estado;
    private float clearenceCrea_valor;
    private String NaPositivo_estado;
    private float NaPositivo_valor;
    private String KPositivo_estado;
    private float KPositivo_valor;
    private String CLNegativo_estado;
    private float CLNegativo_valor;
    private String GPT_estado;
    private float GPT_valor;
    private String GOT_estado;
    private float GOT_valor;  
    /*
(para examenes se requieren dos atributos por examen, el primer atributo un char seleccionable entre las siguientes opciones: ("VACIO" - "SE SOLICITA" - "PENDIENTE")  con "VACIO" como predefinido)
Exámenes:
-------------------------------------------------------
Para los siguientes examenes el segundo atributo debe ser un float.
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
    
  //////////////////////////////////////////////7  
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

    //reingreso
    private boolean reingreso;
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechareingreso;
    private String proximo_control;
  //Nuevos para censo CCV
    
    private String Det_Prev_ERC;
    //nuevo censo farmaco
    private boolean Acido_acetilsalicilico;
    private String Acido_acetilsalicilico_texto;

// NUEVOS PARA CENSO SECCION C EVALUACION VIGENTE DEL PIE
    @Size(max=200)
    private String estimacionRiesgoUlceracionPie;
// ULCERAS ACTIVAS
    private boolean ulcera_activaPieDM;
    @Size(max=200)
    private String ulcera_activaPieDM_Descripcion;
    @Size(max=200)
    private String curacionPie_DM;

    //Nuevos datos no rem
    private boolean atencionPodologica;
    private boolean complicacionPrevalencia;
    private boolean cegueraPostRetinopatia;
    private boolean nefropatiaInciente;
    private boolean amputacionDiabetica;

    public boolean isAtencionPodologica() {
        return atencionPodologica;
    }

    public void setAtencionPodologica(boolean atencionPodologica) {
        this.atencionPodologica = atencionPodologica;
    }

    public boolean isComplicacionPrevalencia() {
        return complicacionPrevalencia;
    }

    public void setComplicacionPrevalencia(boolean complicacionPrevalencia) {
        this.complicacionPrevalencia = complicacionPrevalencia;
    }

    public boolean isCegueraPostRetinopatia() {
        return cegueraPostRetinopatia;
    }

    public void setCegueraPostRetinopatia(boolean cegueraPostRetinopatia) {
        this.cegueraPostRetinopatia = cegueraPostRetinopatia;
    }

    public boolean isNefropatiaInciente() {
        return nefropatiaInciente;
    }

    public void setNefropatiaInciente(boolean nefropatiaInciente) {
        this.nefropatiaInciente = nefropatiaInciente;
    }

    public boolean isAmputacionDiabetica() {
        return amputacionDiabetica;
    }

    public void setAmputacionDiabetica(boolean amputacionDiabetica) {
        this.amputacionDiabetica = amputacionDiabetica;
    }
    
    
    
    
    
    public String getEstimacionRiesgoUlceracionPie() {
        return estimacionRiesgoUlceracionPie;
    }

    public void setEstimacionRiesgoUlceracionPie(String estimacionRiesgoUlceracionPie) {
        this.estimacionRiesgoUlceracionPie = estimacionRiesgoUlceracionPie;
    }

    public boolean isUlcera_activaPieDM() {
        return ulcera_activaPieDM;
    }

    public void setUlcera_activaPieDM(boolean ulcera_activaPieDM) {
        this.ulcera_activaPieDM = ulcera_activaPieDM;
    }

    public String getUlcera_activaPieDM_Descripcion() {
        return ulcera_activaPieDM_Descripcion;
    }

    public void setUlcera_activaPieDM_Descripcion(String ulcera_activaPieDM_Descripcion) {
        this.ulcera_activaPieDM_Descripcion = ulcera_activaPieDM_Descripcion;
    }

    public String getCuracionPie_DM() {
        return curacionPie_DM;
    }

    public void setCuracionPie_DM(String curacionPie_DM) {
        this.curacionPie_DM = curacionPie_DM;
    }
    
    
    
    
    
    
    public String getDet_Prev_ERC() {
        return Det_Prev_ERC;
    }

    public void setDet_Prev_ERC(String Det_Prev_ERC) {
        this.Det_Prev_ERC = Det_Prev_ERC;
    }

    public boolean isAcido_acetilsalicilico() {
        return Acido_acetilsalicilico;
    }

    public void setAcido_acetilsalicilico(boolean Acido_acetilsalicilico) {
        this.Acido_acetilsalicilico = Acido_acetilsalicilico;
    }

    public String getAcido_acetilsalicilico_texto() {
        return Acido_acetilsalicilico_texto;
    }

    public void setAcido_acetilsalicilico_texto(String Acido_acetilsalicilico_texto) {
        this.Acido_acetilsalicilico_texto = Acido_acetilsalicilico_texto;
    }

    public String getIngreso_reingreso() {
        return ingreso_reingreso;
    }

    public void setIngreso_reingreso(String ingreso_reingreso) {
        this.ingreso_reingreso = ingreso_reingreso;
    }
    
    
    
    
    
    
    
    
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
  
    
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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

  
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getTalla() {
        return talla;
    }

    public void setTalla(float talla) {
        this.talla = talla;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public String getDiagnostico_nutricional() {
        return diagnostico_nutricional;
    }

    public void setDiagnostico_nutricional(String diagnostico_nutricional) {
        this.diagnostico_nutricional = diagnostico_nutricional;
    }

    public float getPerimetro_cintura() {
        return perimetro_cintura;
    }

    public void setPerimetro_cintura(float perimetro_cintura) {
        this.perimetro_cintura = perimetro_cintura;
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

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
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

    public Integer getPunteaje_pie_dm() {
        return punteaje_pie_dm;
    }

    public void setPunteaje_pie_dm(Integer punteaje_pie_dm) {
        this.punteaje_pie_dm = punteaje_pie_dm;
    }

    public String getGlicemia_estado() {
        return glicemia_estado;
    }

    public void setGlicemia_estado(String glicemia_estado) {
        this.glicemia_estado = glicemia_estado;
    }

    public float getGlicemica_valor() {
        return glicemica_valor;
    }

    public void setGlicemica_valor(float glicemica_valor) {
        this.glicemica_valor = glicemica_valor;
    }

    public String getHba1C_estado() {
        return hba1C_estado;
    }

    public void setHba1C_estado(String hba1C_estado) {
        this.hba1C_estado = hba1C_estado;
    }

    public float getHba1C_valor() {
        return hba1C_valor;
    }

    public void setHba1C_valor(float hba1C_valor) {
        this.hba1C_valor = hba1C_valor;
    }

    public String getColesterolTotal_estado() {
        return colesterolTotal_estado;
    }

    public void setColesterolTotal_estado(String colesterolTotal_estado) {
        this.colesterolTotal_estado = colesterolTotal_estado;
    }

    public float getColesterolTotal_valor() {
        return colesterolTotal_valor;
    }

    public void setColesterolTotal_valor(float colesterolTotal_valor) {
        this.colesterolTotal_valor = colesterolTotal_valor;
    }

    public String getColesterolLDL_estado() {
        return colesterolLDL_estado;
    }

    public void setColesterolLDL_estado(String colesterolLDL_estado) {
        this.colesterolLDL_estado = colesterolLDL_estado;
    }

    public float getColesterolLDL_valor() {
        return colesterolLDL_valor;
    }

    public void setColesterolLDL_valor(float colesterolLDL_valor) {
        this.colesterolLDL_valor = colesterolLDL_valor;
    }

    public String getColesterolHDL_estado() {
        return colesterolHDL_estado;
    }

    public void setColesterolHDL_estado(String colesterolHDL_estado) {
        this.colesterolHDL_estado = colesterolHDL_estado;
    }

    public float getColesterolHDL_valor() {
        return colesterolHDL_valor;
    }

    public void setColesterolHDL_valor(float colesterolHDL_valor) {
        this.colesterolHDL_valor = colesterolHDL_valor;
    }

    public String getTrigliceridos_estado() {
        return trigliceridos_estado;
    }

    public void setTrigliceridos_estado(String trigliceridos_estado) {
        this.trigliceridos_estado = trigliceridos_estado;
    }

    public float getTrigliceridos_valor() {
        return trigliceridos_valor;
    }

    public void setTrigliceridos_valor(float trigliceridos_valor) {
        this.trigliceridos_valor = trigliceridos_valor;
    }

    public String getBilirrubinaTotal_estado() {
        return bilirrubinaTotal_estado;
    }

    public void setBilirrubinaTotal_estado(String bilirrubinaTotal_estado) {
        this.bilirrubinaTotal_estado = bilirrubinaTotal_estado;
    }

    public float getBilirrubinaTotal_valor() {
        return bilirrubinaTotal_valor;
    }

    public void setBilirrubinaTotal_valor(float bilirrubinaTotal_valor) {
        this.bilirrubinaTotal_valor = bilirrubinaTotal_valor;
    }

    public String getBilirrubinaDirecta_estado() {
        return bilirrubinaDirecta_estado;
    }

    public void setBilirrubinaDirecta_estado(String bilirrubinaDirecta_estado) {
        this.bilirrubinaDirecta_estado = bilirrubinaDirecta_estado;
    }

    public float getBilirrubinaDirecta_valor() {
        return bilirrubinaDirecta_valor;
    }

    public void setBilirrubinaDirecta_valor(float bilirrubinaDirecta_valor) {
        this.bilirrubinaDirecta_valor = bilirrubinaDirecta_valor;
    }

    public String getBilirrubinaIndirecta_estado() {
        return bilirrubinaIndirecta_estado;
    }

    public void setBilirrubinaIndirecta_estado(String bilirrubinaIndirecta_estado) {
        this.bilirrubinaIndirecta_estado = bilirrubinaIndirecta_estado;
    }

    public float getBilirrubinaIndirecta_valor() {
        return bilirrubinaIndirecta_valor;
    }

    public void setBilirrubinaIndirecta_valor(float bilirrubinaIndirecta_valor) {
        this.bilirrubinaIndirecta_valor = bilirrubinaIndirecta_valor;
    }

    public String getCreatinina_estado() {
        return creatinina_estado;
    }

    public void setCreatinina_estado(String creatinina_estado) {
        this.creatinina_estado = creatinina_estado;
    }

    public float getCreatinina_valor() {
        return creatinina_valor;
    }

    public void setCreatinina_valor(float creatinina_valor) {
        this.creatinina_valor = creatinina_valor;
    }

    public String getBUN_estado() {
        return BUN_estado;
    }

    public void setBUN_estado(String BUN_estado) {
        this.BUN_estado = BUN_estado;
    }

    public float getBUN_valor() {
        return BUN_valor;
    }

    public void setBUN_valor(float BUN_valor) {
        this.BUN_valor = BUN_valor;
    }

    public String getMDRD_estado() {
        return MDRD_estado;
    }

    public void setMDRD_estado(String MDRD_estado) {
        this.MDRD_estado = MDRD_estado;
    }

    public float getMDRD_valor() {
        return MDRD_valor;
    }

    public void setMDRD_valor(float MDRD_valor) {
        this.MDRD_valor = MDRD_valor;
    }

    public String getMicroALB24H_estado() {
        return microALB24H_estado;
    }

    public void setMicroALB24H_estado(String microALB24H_estado) {
        this.microALB24H_estado = microALB24H_estado;
    }

    public float getMicroALB24H_valor() {
        return microALB24H_valor;
    }

    public void setMicroALB24H_valor(float microALB24H_valor) {
        this.microALB24H_valor = microALB24H_valor;
    }

    public String getClearenceCrea_estado() {
        return clearenceCrea_estado;
    }

    public void setClearenceCrea_estado(String clearenceCrea_estado) {
        this.clearenceCrea_estado = clearenceCrea_estado;
    }

    public float getClearenceCrea_valor() {
        return clearenceCrea_valor;
    }

    public void setClearenceCrea_valor(float clearenceCrea_valor) {
        this.clearenceCrea_valor = clearenceCrea_valor;
    }

    public String getNaPositivo_estado() {
        return NaPositivo_estado;
    }

    public void setNaPositivo_estado(String NaPositivo_estado) {
        this.NaPositivo_estado = NaPositivo_estado;
    }

    public float getNaPositivo_valor() {
        return NaPositivo_valor;
    }

    public void setNaPositivo_valor(float NaPositivo_valor) {
        this.NaPositivo_valor = NaPositivo_valor;
    }

    public String getKPositivo_estado() {
        return KPositivo_estado;
    }

    public void setKPositivo_estado(String KPositivo_estado) {
        this.KPositivo_estado = KPositivo_estado;
    }

    public float getKPositivo_valor() {
        return KPositivo_valor;
    }

    public void setKPositivo_valor(float KPositivo_valor) {
        this.KPositivo_valor = KPositivo_valor;
    }

    public String getCLNegativo_estado() {
        return CLNegativo_estado;
    }

    public void setCLNegativo_estado(String CLNegativo_estado) {
        this.CLNegativo_estado = CLNegativo_estado;
    }

    public float getCLNegativo_valor() {
        return CLNegativo_valor;
    }

    public void setCLNegativo_valor(float CLNegativo_valor) {
        this.CLNegativo_valor = CLNegativo_valor;
    }

    public String getGPT_estado() {
        return GPT_estado;
    }

    public void setGPT_estado(String GPT_estado) {
        this.GPT_estado = GPT_estado;
    }

    public float getGPT_valor() {
        return GPT_valor;
    }

    public void setGPT_valor(float GPT_valor) {
        this.GPT_valor = GPT_valor;
    }

    public String getGOT_estado() {
        return GOT_estado;
    }

    public void setGOT_estado(String GOT_estado) {
        this.GOT_estado = GOT_estado;
    }

    public float getGOT_valor() {
        return GOT_valor;
    }

    public void setGOT_valor(float GOT_valor) {
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

    public boolean isReingreso() {
        return reingreso;
    }

    public void setReingreso(boolean reingreso) {
        this.reingreso = reingreso;
    }

    public Date getFechareingreso() {
        return fechareingreso;
    }

    public void setFechareingreso(Date fechareingreso) {
        this.fechareingreso = fechareingreso;
    }

    public String getProximo_control() {
        return proximo_control;
    }

    public void setProximo_control(String proximo_control) {
        this.proximo_control = proximo_control;
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
        if (!(object instanceof CartolaSeguimientoCCV)) {
            return false;
        }
        CartolaSeguimientoCCV other = (CartolaSeguimientoCCV) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.cardiovascular.CartolaSeguimientoCCV[ id=" + id + " ]";
    }
    
}
