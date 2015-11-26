/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.adultoMayor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

/**
 *
 * @author daniel
 */
@Entity
public class EsferaFuncionalPSAM implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_esferaFuncional")
    private Long id;
    
    // ESFERA FUNCIONAL
    
    private boolean uso_protesis_dentaria;
    private String uso_protesis_dentaria_obs;
    private boolean uso_lentes_opticos;
    private String uso_lentes_opticos_obs;
    private boolean uso_medios_apoyo;
    private String uso__medios_apoyo_obs;
    private boolean uso_audifonos;
    private String uso_audifonos_obs;
    
    // Riesgo Caidas
    
    private boolean caidas_este_ano;
    // INFORMACIÓN: >= 5 seg. Normal - <= 4 seg. Alterado
    private Integer estacion_unipodal_derecha;
    private Integer estacion_unipodal_izquierda;
    
    private Integer timed_up_and_go;
    
    /// EFAM
    
    // PARTE A:
    
    private Integer PA_pregunta01;
    private Integer PA_pregunta02;
    private Integer PA_pregunta03;
    private Integer PA_pregunta04;
    private Integer PA_pregunta05;
    private Integer PA_pregunta06;
    private Integer PA_pregunta07;
    private Integer PA_pregunta08;
    private Integer PA_pregunta09;
    
    // Parte B
    
    private Integer PB_pregunta01;
    private Integer PB_pregunta02;
    private Integer PB_pregunta03;
    private Integer PB_pregunta04;
    private Integer PB_pregunta05;
    private Integer PB_pregunta06;
    
    // PARTE MMSE
    
    private Integer MMSE_pregunta01;
    private Integer MMSE_pregunta02;
    private Integer MMSE_pregunta03;
    private Integer MMSE_pregunta04;
    private Integer MMSE_pregunta05;
    private Integer MMSE_pregunta06;
    
    private Integer total_efam;
    
    ///////////////////////////////// FIN EFAM 
    
    
    /// BARTHEL
    
    private Integer comer;
    private Integer laverse;
    private Integer vestirse;
    private Integer arreglarse;
    private Integer deposiciones_semanaPrevia;
    private Integer miccion_semanaPrevia;
    private Integer usar_el_retrete;
    private Integer trasladarse;
    private Integer deambular;
    private Integer escalones;
    
    private Integer total_barthel;
    /////////////////////////////// FIN BARTHEL
    /*SÍNDROMES GERIÁTRICOS DETECTADOS:				
	BOOLEAN	RIESGO DE CAIDAS		
	BOOLEAN	INMOVILIDAD		
    */
    private boolean riesgo_de_caidas;
    private boolean inmovilidad;

    public boolean isRiesgo_de_caidas() {
        return riesgo_de_caidas;
    }

    public void setRiesgo_de_caidas(boolean riesgo_de_caidas) {
        this.riesgo_de_caidas = riesgo_de_caidas;
    }

    public boolean isInmovilidad() {
        return inmovilidad;
    }

    public void setInmovilidad(boolean inmovilidad) {
        this.inmovilidad = inmovilidad;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isUso_protesis_dentaria() {
        return uso_protesis_dentaria;
    }

    public void setUso_protesis_dentaria(boolean uso_protesis_dentaria) {
        this.uso_protesis_dentaria = uso_protesis_dentaria;
    }

    public String getUso_protesis_dentaria_obs() {
        return uso_protesis_dentaria_obs;
    }

    public void setUso_protesis_dentaria_obs(String uso_protesis_dentaria_obs) {
        this.uso_protesis_dentaria_obs = uso_protesis_dentaria_obs;
    }

    public boolean isUso_lentes_opticos() {
        return uso_lentes_opticos;
    }

    public void setUso_lentes_opticos(boolean uso_lentes_opticos) {
        this.uso_lentes_opticos = uso_lentes_opticos;
    }

    public String getUso_lentes_opticos_obs() {
        return uso_lentes_opticos_obs;
    }

    public void setUso_lentes_opticos_obs(String uso_lentes_opticos_obs) {
        this.uso_lentes_opticos_obs = uso_lentes_opticos_obs;
    }

    public boolean isUso_medios_apoyo() {
        return uso_medios_apoyo;
    }

    public void setUso_medios_apoyo(boolean uso_medios_apoyo) {
        this.uso_medios_apoyo = uso_medios_apoyo;
    }

    public String getUso__medios_apoyo_obs() {
        return uso__medios_apoyo_obs;
    }

    public void setUso__medios_apoyo_obs(String uso__medios_apoyo_obs) {
        this.uso__medios_apoyo_obs = uso__medios_apoyo_obs;
    }

    public boolean isUso_audifonos() {
        return uso_audifonos;
    }

    public void setUso_audifonos(boolean uso_audifonos) {
        this.uso_audifonos = uso_audifonos;
    }

    public String getUso_audifonos_obs() {
        return uso_audifonos_obs;
    }

    public void setUso_audifonos_obs(String uso_audifonos_obs) {
        this.uso_audifonos_obs = uso_audifonos_obs;
    }

    public boolean isCaidas_este_ano() {
        return caidas_este_ano;
    }

    public void setCaidas_este_ano(boolean caidas_este_ano) {
        this.caidas_este_ano = caidas_este_ano;
    }

    public Integer getEstacion_unipodal_derecha() {
        return estacion_unipodal_derecha;
    }

    public void setEstacion_unipodal_derecha(Integer estacion_unipodal_derecha) {
        this.estacion_unipodal_derecha = estacion_unipodal_derecha;
    }

    public Integer getEstacion_unipodal_izquierda() {
        return estacion_unipodal_izquierda;
    }

    public void setEstacion_unipodal_izquierda(Integer estacion_unipodal_izquierda) {
        this.estacion_unipodal_izquierda = estacion_unipodal_izquierda;
    }

    public Integer getTimed_up_and_go() {
        return timed_up_and_go;
    }

    public void setTimed_up_and_go(Integer timed_up_and_go) {
        this.timed_up_and_go = timed_up_and_go;
    }

    public Integer getPA_pregunta01() {
        return PA_pregunta01;
    }

    public void setPA_pregunta01(Integer PA_pregunta01) {
        this.PA_pregunta01 = PA_pregunta01;
    }

    public Integer getPA_pregunta02() {
        return PA_pregunta02;
    }

    public void setPA_pregunta02(Integer PA_pregunta02) {
        this.PA_pregunta02 = PA_pregunta02;
    }

    public Integer getPA_pregunta03() {
        return PA_pregunta03;
    }

    public void setPA_pregunta03(Integer PA_pregunta03) {
        this.PA_pregunta03 = PA_pregunta03;
    }

    public Integer getPA_pregunta04() {
        return PA_pregunta04;
    }

    public void setPA_pregunta04(Integer PA_pregunta04) {
        this.PA_pregunta04 = PA_pregunta04;
    }

    public Integer getPA_pregunta05() {
        return PA_pregunta05;
    }

    public void setPA_pregunta05(Integer PA_pregunta05) {
        this.PA_pregunta05 = PA_pregunta05;
    }

    public Integer getPA_pregunta06() {
        return PA_pregunta06;
    }

    public void setPA_pregunta06(Integer PA_pregunta06) {
        this.PA_pregunta06 = PA_pregunta06;
    }

    public Integer getPA_pregunta07() {
        return PA_pregunta07;
    }

    public void setPA_pregunta07(Integer PA_pregunta07) {
        this.PA_pregunta07 = PA_pregunta07;
    }

    public Integer getPA_pregunta08() {
        return PA_pregunta08;
    }

    public void setPA_pregunta08(Integer PA_pregunta08) {
        this.PA_pregunta08 = PA_pregunta08;
    }

    public Integer getPA_pregunta09() {
        return PA_pregunta09;
    }

    public void setPA_pregunta09(Integer PA_pregunta09) {
        this.PA_pregunta09 = PA_pregunta09;
    }

    public Integer getPB_pregunta01() {
        return PB_pregunta01;
    }

    public void setPB_pregunta01(Integer PB_pregunta01) {
        this.PB_pregunta01 = PB_pregunta01;
    }

    public Integer getPB_pregunta02() {
        return PB_pregunta02;
    }

    public void setPB_pregunta02(Integer PB_pregunta02) {
        this.PB_pregunta02 = PB_pregunta02;
    }

    public Integer getPB_pregunta03() {
        return PB_pregunta03;
    }

    public void setPB_pregunta03(Integer PB_pregunta03) {
        this.PB_pregunta03 = PB_pregunta03;
    }

    public Integer getPB_pregunta04() {
        return PB_pregunta04;
    }

    public void setPB_pregunta04(Integer PB_pregunta04) {
        this.PB_pregunta04 = PB_pregunta04;
    }

    public Integer getPB_pregunta05() {
        return PB_pregunta05;
    }

    public void setPB_pregunta05(Integer PB_pregunta05) {
        this.PB_pregunta05 = PB_pregunta05;
    }

    public Integer getPB_pregunta06() {
        return PB_pregunta06;
    }

    public void setPB_pregunta06(Integer PB_pregunta06) {
        this.PB_pregunta06 = PB_pregunta06;
    }

    public Integer getMMSE_pregunta01() {
        return MMSE_pregunta01;
    }

    public void setMMSE_pregunta01(Integer MMSE_pregunta01) {
        this.MMSE_pregunta01 = MMSE_pregunta01;
    }

    public Integer getMMSE_pregunta02() {
        return MMSE_pregunta02;
    }

    public void setMMSE_pregunta02(Integer MMSE_pregunta02) {
        this.MMSE_pregunta02 = MMSE_pregunta02;
    }

    public Integer getMMSE_pregunta03() {
        return MMSE_pregunta03;
    }

    public void setMMSE_pregunta03(Integer MMSE_pregunta03) {
        this.MMSE_pregunta03 = MMSE_pregunta03;
    }

    public Integer getMMSE_pregunta04() {
        return MMSE_pregunta04;
    }

    public void setMMSE_pregunta04(Integer MMSE_pregunta04) {
        this.MMSE_pregunta04 = MMSE_pregunta04;
    }

    public Integer getMMSE_pregunta05() {
        return MMSE_pregunta05;
    }

    public void setMMSE_pregunta05(Integer MMSE_pregunta05) {
        this.MMSE_pregunta05 = MMSE_pregunta05;
    }

    public Integer getMMSE_pregunta06() {
        return MMSE_pregunta06;
    }

    public void setMMSE_pregunta06(Integer MMSE_pregunta06) {
        this.MMSE_pregunta06 = MMSE_pregunta06;
    }

    public Integer getTotal_efam() {
        return total_efam;
    }

    public void setTotal_efam(Integer total_efam) {
        this.total_efam = total_efam;
    }

    public Integer getComer() {
        return comer;
    }

    public void setComer(Integer comer) {
        this.comer = comer;
    }

    public Integer getLaverse() {
        return laverse;
    }

    public void setLaverse(Integer laverse) {
        this.laverse = laverse;
    }

    public Integer getVestirse() {
        return vestirse;
    }

    public void setVestirse(Integer vestirse) {
        this.vestirse = vestirse;
    }

    public Integer getArreglarse() {
        return arreglarse;
    }

    public void setArreglarse(Integer arreglarse) {
        this.arreglarse = arreglarse;
    }

    public Integer getDeposiciones_semanaPrevia() {
        return deposiciones_semanaPrevia;
    }

    public void setDeposiciones_semanaPrevia(Integer deposiciones_semanaPrevia) {
        this.deposiciones_semanaPrevia = deposiciones_semanaPrevia;
    }

    public Integer getMiccion_semanaPrevia() {
        return miccion_semanaPrevia;
    }

    public void setMiccion_semanaPrevia(Integer miccion_semanaPrevia) {
        this.miccion_semanaPrevia = miccion_semanaPrevia;
    }

    public Integer getUsar_el_retrete() {
        return usar_el_retrete;
    }

    public void setUsar_el_retrete(Integer usar_el_retrete) {
        this.usar_el_retrete = usar_el_retrete;
    }

    public Integer getTrasladarse() {
        return trasladarse;
    }

    public void setTrasladarse(Integer trasladarse) {
        this.trasladarse = trasladarse;
    }

    public Integer getDeambular() {
        return deambular;
    }

    public void setDeambular(Integer deambular) {
        this.deambular = deambular;
    }

    public Integer getEscalones() {
        return escalones;
    }

    public void setEscalones(Integer escalones) {
        this.escalones = escalones;
    }

    public Integer getTotal_barthel() {
        return total_barthel;
    }

    public void setTotal_barthel(Integer total_barthel) {
        this.total_barthel = total_barthel;
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
        if (!(object instanceof EsferaFuncionalPSAM)) {
            return false;
        }
        EsferaFuncionalPSAM other = (EsferaFuncionalPSAM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.adultoMayor.EsferaFuncionalPSAM[ id=" + id + " ]";
    }
    
}
