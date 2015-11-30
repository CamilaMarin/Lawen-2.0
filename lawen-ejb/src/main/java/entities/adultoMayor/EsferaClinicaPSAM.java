/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.adultoMayor;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author daniel
 */
@Entity
public class EsferaClinicaPSAM implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_esferaClinica")
    private Long id;
    
    /// ESFERA CLINICA
    
    // Vacunas
    private boolean influenza;
   
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date influenza_ultimaAdmin;
    private boolean neumococica;
   
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date neumonia_ultimaAdmin;
    
    // Habitos alimenticios
    @Size(max=500)
    private String descripcion_habitosAlimenticios;
    //Diuresis -Deposiciones
    @Size(max=500)
    private String descripcion_patronEliminacion;
    
    private boolean sexualidad_activa;
    
    // Patolgias agudas
    private boolean neumonia;
    private String neumonia_obervaciones;
    private boolean fractura_muneca;
    private String fractura_muneca_observaciones;
    private boolean fractura_cadera;
    private String fractura_cadera_observaciones;
    private boolean fractura_columna;
    private String fractura_columna_observaciones;
    private boolean IAM;
    private String IAM_observaciones;
    private boolean ataque_cerebro_vascular;
    private String ataque_cerebro_vascular_observaciones;
    
    // Terapia famacologica
    
    private boolean atenolol;
    private String atenolol_observaciones;
    private boolean anticoagulante;
    private String anticoagulante_observaciones;
    private boolean alprazalam;
    private String alprazalam_observaciones;
    private boolean amitriptilina;
    private String amitriptilina_observaciones;
    private boolean aspirina;
    private String aspirina_observaciones;
    private boolean celecoxib;
    private String celecoxib_observaciones;
    private boolean clorfenamina;
    private String clorfenamina_observaciones;
    private boolean clordiazepoxido;
    private String clordiazepoxido_observaciones;
    private boolean diazepam;
    private String diazepam_observaciones;
    private boolean diclofenaco;
    private String diclofenaco_observaciones;
    private boolean enalapril;
    private String enalapril_observaciones;
    private boolean furocemida;
    private String furocemida_observaciones;
    private boolean fluoxetina;
    private String fluoxetina_observaciones;
    private boolean genfibrozilo;
    private String genfibrozilo_observaciones;
    private boolean glibenclamida;
    private String glibenclamida_observaciones;
    private boolean hidroclorotiazida;
    private String hidroclorotiazida_observaciones;
    private boolean insulina;
    private String insulina_observaciones;
    private boolean imipramina;
    private String imipramina_observaciones;
    private boolean salbutamol;
    private String salbutamol_observaciones;
    private boolean bromuro_ipratropio;
    private String bromuro_ipratropio_observaciones;
    private boolean ibuprofeno;
    private String ibuprofeno_observaciones;
    private boolean corticoides_inhalados;
    private String corticoides_inhalados_observaciones;
    private boolean losartan_potasico;
    private String losartan_potasico_observaciones;
    private boolean levopoda;
    private String levopoda_observaciones;
    private boolean metformina;
    private String metformina_observaciones;
    private boolean nifedipino;
    private String nifedipino_observaciones;
    private boolean omeprazol;
    private String omeprazol_observaciones;
    private boolean paracetamol;
    private String paracetamol_observaciones;
    private boolean sertralina;
    private String sertralina_observaciones;
    private boolean tolbutamida;
    private String tolbutamida_observaciones;
    private boolean otros_farmacos;
    private String otros_farmacos_observaciones;
   
    // Examenes laboratorio
    
    // Solicitud ("VACIO" - "SE SOLICITA" - "PENDIENTE" - “RESULTADO”) con "VACIO" como predefinido)
    // Estado ("VACIO" - "NORMAL" - "ALTERADO") con "VACIO" preselecionado
    
    private String glicemia_sol;
    private Float glicemia_valor;
    private String colesterolTotal_sol;
    private Float colesterolTotal_valor;
    private String baciloscopia_sol;
    private String baciloscopia_estado;
    private String VDRL_sol;
    private String VDRL_estado;
    private String presbicia_sol;
    private String presbicia_estado;
    
    // Mediciones
    
    private Integer presion_arterial_sentado1;
    private Integer presion_arterial_sentado2;
    private Integer presion_arterial_dePie1;
    private Integer presion_arterial_dePie2;
    private Integer pulso;
    private Float peso;
    private Float talla;
    private Float imc;
    // estado nutricional
    private Float cc;
    private boolean baja_de_peso_involuntaria_ult6meses;
    @Size(max=1000)
    private String observaciones;
    
    
    // Examenes ingreso
    @Size(max=300)
    private String examen_fisico;
    @Size(max=300)
    private String evaluacion_del_pie;
    
    // Otras observaciones (tabla)
    // trabla izquierda
    // Usted observa
    private boolean mareos;
    private boolean temblor;
    private boolean alteracion_equilibrio;
    private boolean dolor_cadera;
    private boolean dolor_rodilla;
    // tabla derecha
    // Usted observa
    
    private boolean dolor_hombro;
    private boolean dolor_espalda;
    private boolean alteracion_visual;
    private boolean alteracion_auditiva;
    private boolean otros;

    
    /*
    SÍNDROMES GERIÁTRICOS DETECTADOS:				
	BOOLEAN	POLIFARMACIA		
	BOOLEAN	IATROGENIA		
	BOOLEAN	INCONTINENCIA URINARIA		
	BOOLEAN	INCONTINENCIA FECAL		
	BOOLEAN	UPP		
	BOOLEAN	TRASTORNO DE LA SEXUALIDAD		
	BOOLEAN	SARCOPENIA		
    */
    private boolean polifarmacia;
    private boolean iatrogenia;
    private boolean incontinencia_urinaria;
    private boolean incontinencia_fecal;
    private boolean upp;
    private boolean transtorno_sexualidad;
    private boolean sarcopenia;

    public boolean isPolifarmacia() {
        return polifarmacia;
    }

    public void setPolifarmacia(boolean polifarmacia) {
        this.polifarmacia = polifarmacia;
    }

    
    public boolean isIatrogenia() {
        return iatrogenia;
    }

    public void setIatrogenia(boolean iatrogenia) {
        this.iatrogenia = iatrogenia;
    }

    public boolean isIncontinencia_urinaria() {
        return incontinencia_urinaria;
    }

    public void setIncontinencia_urinaria(boolean incontinencia_urinaria) {
        this.incontinencia_urinaria = incontinencia_urinaria;
    }

    public boolean isIncontinencia_fecal() {
        return incontinencia_fecal;
    }

    public void setIncontinencia_fecal(boolean incontinencia_fecal) {
        this.incontinencia_fecal = incontinencia_fecal;
    }

    public boolean isUpp() {
        return upp;
    }

    public void setUpp(boolean upp) {
        this.upp = upp;
    }

    public boolean isTranstorno_sexualidad() {
        return transtorno_sexualidad;
    }

    public void setTranstorno_sexualidad(boolean transtorno_sexualidad) {
        this.transtorno_sexualidad = transtorno_sexualidad;
    }

    public boolean isSarcopenia() {
        return sarcopenia;
    }

    public void setSarcopenia(boolean sarcopenia) {
        this.sarcopenia = sarcopenia;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isInfluenza() {
        return influenza;
    }

    public void setInfluenza(boolean influenza) {
        this.influenza = influenza;
    }

    public Date getInfluenza_ultimaAdmin() {
        return influenza_ultimaAdmin;
    }

    public void setInfluenza_ultimaAdmin(Date influenza_ultimaAdmin) {
        this.influenza_ultimaAdmin = influenza_ultimaAdmin;
    }

    public boolean isNeumococica() {
        return neumococica;
    }

    public void setNeumococica(boolean neumococica) {
        this.neumococica = neumococica;
    }

    public Date getNeumonia_ultimaAdmin() {
        return neumonia_ultimaAdmin;
    }

    public void setNeumonia_ultimaAdmin(Date neumonia_ultimaAdmin) {
        this.neumonia_ultimaAdmin = neumonia_ultimaAdmin;
    }

    public String getDescripcion_habitosAlimenticios() {
        return descripcion_habitosAlimenticios;
    }

    public void setDescripcion_habitosAlimenticios(String descripcion_habitosAlimenticios) {
        this.descripcion_habitosAlimenticios = descripcion_habitosAlimenticios;
    }

    public String getDescripcion_patronEliminacion() {
        return descripcion_patronEliminacion;
    }

    public void setDescripcion_patronEliminacion(String descripcion_patronEliminacion) {
        this.descripcion_patronEliminacion = descripcion_patronEliminacion;
    }

    public boolean isSexualidad_activa() {
        return sexualidad_activa;
    }

    public void setSexualidad_activa(boolean sexualidad_activa) {
        this.sexualidad_activa = sexualidad_activa;
    }

    public boolean isNeumonia() {
        return neumonia;
    }

    public void setNeumonia(boolean neumonia) {
        this.neumonia = neumonia;
    }

    public String getNeumonia_obervaciones() {
        return neumonia_obervaciones;
    }

    public void setNeumonia_obervaciones(String neumonia_obervaciones) {
        this.neumonia_obervaciones = neumonia_obervaciones;
    }

    public boolean isFractura_muneca() {
        return fractura_muneca;
    }

    public void setFractura_muneca(boolean fractura_muneca) {
        this.fractura_muneca = fractura_muneca;
    }

    public String getFractura_muneca_observaciones() {
        return fractura_muneca_observaciones;
    }

    public void setFractura_muneca_observaciones(String fractura_muneca_observaciones) {
        this.fractura_muneca_observaciones = fractura_muneca_observaciones;
    }

    public boolean isFractura_cadera() {
        return fractura_cadera;
    }

    public void setFractura_cadera(boolean fractura_cadera) {
        this.fractura_cadera = fractura_cadera;
    }

    public String getFractura_cadera_observaciones() {
        return fractura_cadera_observaciones;
    }

    public void setFractura_cadera_observaciones(String fractura_cadera_observaciones) {
        this.fractura_cadera_observaciones = fractura_cadera_observaciones;
    }

    public boolean isFractura_columna() {
        return fractura_columna;
    }

    public void setFractura_columna(boolean fractura_columna) {
        this.fractura_columna = fractura_columna;
    }

    public String getFractura_columna_observaciones() {
        return fractura_columna_observaciones;
    }

    public void setFractura_columna_observaciones(String fractura_columna_observaciones) {
        this.fractura_columna_observaciones = fractura_columna_observaciones;
    }

    public boolean isIAM() {
        return IAM;
    }

    public void setIAM(boolean IAM) {
        this.IAM = IAM;
    }

    public String getIAM_observaciones() {
        return IAM_observaciones;
    }

    public void setIAM_observaciones(String IAM_observaciones) {
        this.IAM_observaciones = IAM_observaciones;
    }

    public boolean isAtaque_cerebro_vascular() {
        return ataque_cerebro_vascular;
    }

    public void setAtaque_cerebro_vascular(boolean ataque_cerebro_vascular) {
        this.ataque_cerebro_vascular = ataque_cerebro_vascular;
    }

    public String getAtaque_cerebro_vascular_observaciones() {
        return ataque_cerebro_vascular_observaciones;
    }

    public void setAtaque_cerebro_vascular_observaciones(String ataque_cerebro_vascular_observaciones) {
        this.ataque_cerebro_vascular_observaciones = ataque_cerebro_vascular_observaciones;
    }

    public boolean isAtenolol() {
        return atenolol;
    }

    public void setAtenolol(boolean atenolol) {
        this.atenolol = atenolol;
    }

    public String getAtenolol_observaciones() {
        return atenolol_observaciones;
    }

    public void setAtenolol_observaciones(String atenolol_observaciones) {
        this.atenolol_observaciones = atenolol_observaciones;
    }

    public boolean isAnticoagulante() {
        return anticoagulante;
    }

    public void setAnticoagulante(boolean anticoagulante) {
        this.anticoagulante = anticoagulante;
    }

    public String getAnticoagulante_observaciones() {
        return anticoagulante_observaciones;
    }

    public void setAnticoagulante_observaciones(String anticoagulante_observaciones) {
        this.anticoagulante_observaciones = anticoagulante_observaciones;
    }

    public boolean isAlprazalam() {
        return alprazalam;
    }

    public void setAlprazalam(boolean alprazalam) {
        this.alprazalam = alprazalam;
    }

    public String getAlprazalam_observaciones() {
        return alprazalam_observaciones;
    }

    public void setAlprazalam_observaciones(String alprazalam_observaciones) {
        this.alprazalam_observaciones = alprazalam_observaciones;
    }

    public boolean isAmitriptilina() {
        return amitriptilina;
    }

    public void setAmitriptilina(boolean amitriptilina) {
        this.amitriptilina = amitriptilina;
    }

    public String getAmitriptilina_observaciones() {
        return amitriptilina_observaciones;
    }

    public void setAmitriptilina_observaciones(String amitriptilina_observaciones) {
        this.amitriptilina_observaciones = amitriptilina_observaciones;
    }

    public boolean isAspirina() {
        return aspirina;
    }

    public void setAspirina(boolean aspirina) {
        this.aspirina = aspirina;
    }

    public String getAspirina_observaciones() {
        return aspirina_observaciones;
    }

    public void setAspirina_observaciones(String aspirina_observaciones) {
        this.aspirina_observaciones = aspirina_observaciones;
    }

    public boolean isCelecoxib() {
        return celecoxib;
    }

    public void setCelecoxib(boolean celecoxib) {
        this.celecoxib = celecoxib;
    }

    public String getCelecoxib_observaciones() {
        return celecoxib_observaciones;
    }

    public void setCelecoxib_observaciones(String celecoxib_observaciones) {
        this.celecoxib_observaciones = celecoxib_observaciones;
    }

    public boolean isClorfenamina() {
        return clorfenamina;
    }

    public void setClorfenamina(boolean clorfenamina) {
        this.clorfenamina = clorfenamina;
    }

    public String getClorfenamina_observaciones() {
        return clorfenamina_observaciones;
    }

    public void setClorfenamina_observaciones(String clorfenamina_observaciones) {
        this.clorfenamina_observaciones = clorfenamina_observaciones;
    }

    public boolean isClordiazepoxido() {
        return clordiazepoxido;
    }

    public void setClordiazepoxido(boolean clordiazepoxido) {
        this.clordiazepoxido = clordiazepoxido;
    }

    public String getClordiazepoxido_observaciones() {
        return clordiazepoxido_observaciones;
    }

    public void setClordiazepoxido_observaciones(String clordiazepoxido_observaciones) {
        this.clordiazepoxido_observaciones = clordiazepoxido_observaciones;
    }

    public boolean isDiazepam() {
        return diazepam;
    }

    public void setDiazepam(boolean diazepam) {
        this.diazepam = diazepam;
    }

    public String getDiazepam_observaciones() {
        return diazepam_observaciones;
    }

    public void setDiazepam_observaciones(String diazepam_observaciones) {
        this.diazepam_observaciones = diazepam_observaciones;
    }

    public boolean isDiclofenaco() {
        return diclofenaco;
    }

    public void setDiclofenaco(boolean diclofenaco) {
        this.diclofenaco = diclofenaco;
    }

    public String getDiclofenaco_observaciones() {
        return diclofenaco_observaciones;
    }

    public void setDiclofenaco_observaciones(String diclofenaco_observaciones) {
        this.diclofenaco_observaciones = diclofenaco_observaciones;
    }

    public boolean isEnalapril() {
        return enalapril;
    }

    public void setEnalapril(boolean enalapril) {
        this.enalapril = enalapril;
    }

    public String getEnalapril_observaciones() {
        return enalapril_observaciones;
    }

    public void setEnalapril_observaciones(String enalapril_observaciones) {
        this.enalapril_observaciones = enalapril_observaciones;
    }

    public boolean isFurocemida() {
        return furocemida;
    }

    public void setFurocemida(boolean furocemida) {
        this.furocemida = furocemida;
    }

    public String getFurocemida_observaciones() {
        return furocemida_observaciones;
    }

    public void setFurocemida_observaciones(String furocemida_observaciones) {
        this.furocemida_observaciones = furocemida_observaciones;
    }

    public boolean isFluoxetina() {
        return fluoxetina;
    }

    public void setFluoxetina(boolean fluoxetina) {
        this.fluoxetina = fluoxetina;
    }

    public String getFluoxetina_observaciones() {
        return fluoxetina_observaciones;
    }

    public void setFluoxetina_observaciones(String fluoxetina_observaciones) {
        this.fluoxetina_observaciones = fluoxetina_observaciones;
    }

    public boolean isGenfibrozilo() {
        return genfibrozilo;
    }

    public void setGenfibrozilo(boolean genfibrozilo) {
        this.genfibrozilo = genfibrozilo;
    }

    public String getGenfibrozilo_observaciones() {
        return genfibrozilo_observaciones;
    }

    public void setGenfibrozilo_observaciones(String genfibrozilo_observaciones) {
        this.genfibrozilo_observaciones = genfibrozilo_observaciones;
    }

    public boolean isGlibenclamida() {
        return glibenclamida;
    }

    public void setGlibenclamida(boolean glibenclamida) {
        this.glibenclamida = glibenclamida;
    }

    public String getGlibenclamida_observaciones() {
        return glibenclamida_observaciones;
    }

    public void setGlibenclamida_observaciones(String glibenclamida_observaciones) {
        this.glibenclamida_observaciones = glibenclamida_observaciones;
    }

    public boolean isHidroclorotiazida() {
        return hidroclorotiazida;
    }

    public void setHidroclorotiazida(boolean hidroclorotiazida) {
        this.hidroclorotiazida = hidroclorotiazida;
    }

    public String getHidroclorotiazida_observaciones() {
        return hidroclorotiazida_observaciones;
    }

    public void setHidroclorotiazida_observaciones(String hidroclorotiazida_observaciones) {
        this.hidroclorotiazida_observaciones = hidroclorotiazida_observaciones;
    }

    public boolean isInsulina() {
        return insulina;
    }

    public void setInsulina(boolean insulina) {
        this.insulina = insulina;
    }

    public String getInsulina_observaciones() {
        return insulina_observaciones;
    }

    public void setInsulina_observaciones(String insulina_observaciones) {
        this.insulina_observaciones = insulina_observaciones;
    }

    public boolean isImipramina() {
        return imipramina;
    }

    public void setImipramina(boolean imipramina) {
        this.imipramina = imipramina;
    }

    public String getImipramina_observaciones() {
        return imipramina_observaciones;
    }

    public void setImipramina_observaciones(String imipramina_observaciones) {
        this.imipramina_observaciones = imipramina_observaciones;
    }

    public boolean isSalbutamol() {
        return salbutamol;
    }

    public void setSalbutamol(boolean salbutamol) {
        this.salbutamol = salbutamol;
    }

    public String getSalbutamol_observaciones() {
        return salbutamol_observaciones;
    }

    public void setSalbutamol_observaciones(String salbutamol_observaciones) {
        this.salbutamol_observaciones = salbutamol_observaciones;
    }

    public boolean isBromuro_ipratropio() {
        return bromuro_ipratropio;
    }

    public void setBromuro_ipratropio(boolean bromuro_ipratropio) {
        this.bromuro_ipratropio = bromuro_ipratropio;
    }

    public String getBromuro_ipratropio_observaciones() {
        return bromuro_ipratropio_observaciones;
    }

    public void setBromuro_ipratropio_observaciones(String bromuro_ipratropio_observaciones) {
        this.bromuro_ipratropio_observaciones = bromuro_ipratropio_observaciones;
    }

    public boolean isIbuprofeno() {
        return ibuprofeno;
    }

    public void setIbuprofeno(boolean ibuprofeno) {
        this.ibuprofeno = ibuprofeno;
    }

    public String getIbuprofeno_observaciones() {
        return ibuprofeno_observaciones;
    }

    public void setIbuprofeno_observaciones(String ibuprofeno_observaciones) {
        this.ibuprofeno_observaciones = ibuprofeno_observaciones;
    }

    public boolean isCorticoides_inhalados() {
        return corticoides_inhalados;
    }

    public void setCorticoides_inhalados(boolean corticoides_inhalados) {
        this.corticoides_inhalados = corticoides_inhalados;
    }

    public String getCorticoides_inhalados_observaciones() {
        return corticoides_inhalados_observaciones;
    }

    public void setCorticoides_inhalados_observaciones(String corticoides_inhalados_observaciones) {
        this.corticoides_inhalados_observaciones = corticoides_inhalados_observaciones;
    }

    public boolean isLosartan_potasico() {
        return losartan_potasico;
    }

    public void setLosartan_potasico(boolean losartan_potasico) {
        this.losartan_potasico = losartan_potasico;
    }

    public String getLosartan_potasico_observaciones() {
        return losartan_potasico_observaciones;
    }

    public void setLosartan_potasico_observaciones(String losartan_potasico_observaciones) {
        this.losartan_potasico_observaciones = losartan_potasico_observaciones;
    }

    public boolean isLevopoda() {
        return levopoda;
    }

    public void setLevopoda(boolean levopoda) {
        this.levopoda = levopoda;
    }

    public String getLevopoda_observaciones() {
        return levopoda_observaciones;
    }

    public void setLevopoda_observaciones(String levopoda_observaciones) {
        this.levopoda_observaciones = levopoda_observaciones;
    }

    public boolean isMetformina() {
        return metformina;
    }

    public void setMetformina(boolean metformina) {
        this.metformina = metformina;
    }

    public String getMetformina_observaciones() {
        return metformina_observaciones;
    }

    public void setMetformina_observaciones(String metformina_observaciones) {
        this.metformina_observaciones = metformina_observaciones;
    }

    public boolean isNifedipino() {
        return nifedipino;
    }

    public void setNifedipino(boolean nifedipino) {
        this.nifedipino = nifedipino;
    }

    public String getNifedipino_observaciones() {
        return nifedipino_observaciones;
    }

    public void setNifedipino_observaciones(String nifedipino_observaciones) {
        this.nifedipino_observaciones = nifedipino_observaciones;
    }

    public boolean isOmeprazol() {
        return omeprazol;
    }

    public void setOmeprazol(boolean omeprazol) {
        this.omeprazol = omeprazol;
    }

    public String getOmeprazol_observaciones() {
        return omeprazol_observaciones;
    }

    public void setOmeprazol_observaciones(String omeprazol_observaciones) {
        this.omeprazol_observaciones = omeprazol_observaciones;
    }

    public boolean isParacetamol() {
        return paracetamol;
    }

    public void setParacetamol(boolean paracetamol) {
        this.paracetamol = paracetamol;
    }

    public String getParacetamol_observaciones() {
        return paracetamol_observaciones;
    }

    public void setParacetamol_observaciones(String paracetamol_observaciones) {
        this.paracetamol_observaciones = paracetamol_observaciones;
    }

    public boolean isSertralina() {
        return sertralina;
    }

    public void setSertralina(boolean sertralina) {
        this.sertralina = sertralina;
    }

    public String getSertralina_observaciones() {
        return sertralina_observaciones;
    }

    public void setSertralina_observaciones(String sertralina_observaciones) {
        this.sertralina_observaciones = sertralina_observaciones;
    }

    public boolean isTolbutamida() {
        return tolbutamida;
    }

    public void setTolbutamida(boolean tolbutamida) {
        this.tolbutamida = tolbutamida;
    }

    public String getTolbutamida_observaciones() {
        return tolbutamida_observaciones;
    }

    public void setTolbutamida_observaciones(String tolbutamida_observaciones) {
        this.tolbutamida_observaciones = tolbutamida_observaciones;
    }

    public boolean isOtros_farmacos() {
        return otros_farmacos;
    }

    public void setOtros_farmacos(boolean otros_farmacos) {
        this.otros_farmacos = otros_farmacos;
    }

    public String getOtros_farmacos_observaciones() {
        return otros_farmacos_observaciones;
    }

    public void setOtros_farmacos_observaciones(String otros_farmacos_observaciones) {
        this.otros_farmacos_observaciones = otros_farmacos_observaciones;
    }

    public String getGlicemia_sol() {
        return glicemia_sol;
    }

    public void setGlicemia_sol(String glicemia_sol) {
        this.glicemia_sol = glicemia_sol;
    }

    public Float getGlicemia_valor() {
        return glicemia_valor;
    }

    public void setGlicemia_valor(Float glicemia_valor) {
        this.glicemia_valor = glicemia_valor;
    }

    public String getColesterolTotal_sol() {
        return colesterolTotal_sol;
    }

    public void setColesterolTotal_sol(String colesterolTotal_sol) {
        this.colesterolTotal_sol = colesterolTotal_sol;
    }

    public Float getColesterolTotal_valor() {
        return colesterolTotal_valor;
    }

    public void setColesterolTotal_valor(Float colesterolTotal_valor) {
        this.colesterolTotal_valor = colesterolTotal_valor;
    }

    public String getBaciloscopia_sol() {
        return baciloscopia_sol;
    }

    public void setBaciloscopia_sol(String baciloscopia_sol) {
        this.baciloscopia_sol = baciloscopia_sol;
    }

    public String getBaciloscopia_estado() {
        return baciloscopia_estado;
    }

    public void setBaciloscopia_estado(String baciloscopia_estado) {
        this.baciloscopia_estado = baciloscopia_estado;
    }

    public String getVDRL_sol() {
        return VDRL_sol;
    }

    public void setVDRL_sol(String VDRL_sol) {
        this.VDRL_sol = VDRL_sol;
    }

    public String getVDRL_estado() {
        return VDRL_estado;
    }

    public void setVDRL_estado(String VDRL_estado) {
        this.VDRL_estado = VDRL_estado;
    }

    public String getPresbicia_sol() {
        return presbicia_sol;
    }

    public void setPresbicia_sol(String presbicia_sol) {
        this.presbicia_sol = presbicia_sol;
    }

    public String getPresbicia_estado() {
        return presbicia_estado;
    }

    public void setPresbicia_estado(String presbicia_estado) {
        this.presbicia_estado = presbicia_estado;
    }

    public Integer getPresion_arterial_sentado1() {
        return presion_arterial_sentado1;
    }

    public void setPresion_arterial_sentado1(Integer presion_arterial_sentado1) {
        this.presion_arterial_sentado1 = presion_arterial_sentado1;
    }

    public Integer getPresion_arterial_sentado2() {
        return presion_arterial_sentado2;
    }

    public void setPresion_arterial_sentado2(Integer presion_arterial_sentado2) {
        this.presion_arterial_sentado2 = presion_arterial_sentado2;
    }

    public Integer getPresion_arterial_dePie1() {
        return presion_arterial_dePie1;
    }

    public void setPresion_arterial_dePie1(Integer presion_arterial_dePie1) {
        this.presion_arterial_dePie1 = presion_arterial_dePie1;
    }

    public Integer getPresion_arterial_dePie2() {
        return presion_arterial_dePie2;
    }

    public void setPresion_arterial_dePie2(Integer presion_arterial_dePie2) {
        this.presion_arterial_dePie2 = presion_arterial_dePie2;
    }

    public Integer getPulso() {
        return pulso;
    }

    public void setPulso(Integer pulso) {
        this.pulso = pulso;
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

    public Float getCc() {
        return cc;
    }

    public void setCc(Float cc) {
        this.cc = cc;
    }

    public boolean isBaja_de_peso_involuntaria_ult6meses() {
        return baja_de_peso_involuntaria_ult6meses;
    }

    public void setBaja_de_peso_involuntaria_ult6meses(boolean baja_de_peso_involuntaria_ult6meses) {
        this.baja_de_peso_involuntaria_ult6meses = baja_de_peso_involuntaria_ult6meses;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getExamen_fisico() {
        return examen_fisico;
    }

    public void setExamen_fisico(String examen_fisico) {
        this.examen_fisico = examen_fisico;
    }

    public String getEvaluacion_del_pie() {
        return evaluacion_del_pie;
    }

    public void setEvaluacion_del_pie(String evaluacion_del_pie) {
        this.evaluacion_del_pie = evaluacion_del_pie;
    }

    public boolean isMareos() {
        return mareos;
    }

    public void setMareos(boolean mareos) {
        this.mareos = mareos;
    }

    public boolean isTemblor() {
        return temblor;
    }

    public void setTemblor(boolean temblor) {
        this.temblor = temblor;
    }

    public boolean isAlteracion_equilibrio() {
        return alteracion_equilibrio;
    }

    public void setAlteracion_equilibrio(boolean alteracion_equilibrio) {
        this.alteracion_equilibrio = alteracion_equilibrio;
    }

    public boolean isDolor_cadera() {
        return dolor_cadera;
    }

    public void setDolor_cadera(boolean dolor_cadera) {
        this.dolor_cadera = dolor_cadera;
    }

    public boolean isDolor_rodilla() {
        return dolor_rodilla;
    }

    public void setDolor_rodilla(boolean dolor_rodilla) {
        this.dolor_rodilla = dolor_rodilla;
    }

    public boolean isDolor_hombro() {
        return dolor_hombro;
    }

    public void setDolor_hombro(boolean dolor_hombro) {
        this.dolor_hombro = dolor_hombro;
    }

    public boolean isDolor_espalda() {
        return dolor_espalda;
    }

    public void setDolor_espalda(boolean dolor_espalda) {
        this.dolor_espalda = dolor_espalda;
    }

    public boolean isAlteracion_visual() {
        return alteracion_visual;
    }

    public void setAlteracion_visual(boolean alteracion_visual) {
        this.alteracion_visual = alteracion_visual;
    }

    public boolean isAlteracion_auditiva() {
        return alteracion_auditiva;
    }

    public void setAlteracion_auditiva(boolean alteracion_auditiva) {
        this.alteracion_auditiva = alteracion_auditiva;
    }

    public boolean isOtros() {
        return otros;
    }

    public void setOtros(boolean otros) {
        this.otros = otros;
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
        if (!(object instanceof EsferaClinicaPSAM)) {
            return false;
        }
        EsferaClinicaPSAM other = (EsferaClinicaPSAM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.adultoMayor.EsferaClinicaPSAM[ id=" + id + " ]";
    }
    
}
