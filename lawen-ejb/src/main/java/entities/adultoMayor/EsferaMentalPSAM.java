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
import javax.validation.constraints.Size;

/**
 *
 * @author daniel
 */
@Entity
public class EsferaMentalPSAM implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_esferaMental")
    private Long id;
    
    
    /// ESFERA MENTAL
    
    /// YESAVAGE
    private Integer YEVG_pregunta01;
    private Integer YEVG_pregunta02;
    private Integer YEVG_pregunta03;
    private Integer YEVG_pregunta04;
    private Integer YEVG_pregunta05;
    private Integer YEVG_pregunta06;
    private Integer YEVG_pregunta07;
    private Integer YEVG_pregunta08;
    private Integer YEVG_pregunta09;
    private Integer YEVG_pregunta10;
    private Integer YEVG_pregunta11;
    private Integer YEVG_pregunta12;
    private Integer YEVG_pregunta13;
    private Integer YEVG_pregunta14;
    private Integer YEVG_pregunta15;
    
    private Integer total_yesavage;
    /////////////////////////////// FIN YESAVAGE
    
    /// PFEFFER
    private Integer PFFR_pregunta01;
    private Integer PFFR_pregunta02;
    private Integer PFFR_pregunta03;
    private Integer PFFR_pregunta04;
    private Integer PFFR_pregunta05;
    private Integer PFFR_pregunta06;
    private Integer PFFR_pregunta07;
    private Integer PFFR_pregunta08;
    private Integer PFFR_pregunta09;
    private Integer PFFR_pregunta10;
    
    private Integer total_pfeffer;
    
    /////////////////////////////// FIN PFEFFER
    
    /// MMSE EXTENDIDO O FOLSTEIN
    private Integer orientacion_temporal;
    private Integer orientacion_espacial;
    private Integer recuerdo_Inmediato;
    private Integer atencion_calculo;
    private Integer recuedo_diferido;
    private Integer lenguaje;
    
    private Integer total_folstein;
    
    /////////////////////////////// FIN MMSE EXTENDIDO O FOLSTEIN
    @Size(max=300)
    private String ocupacion;
    private boolean trabaja;
    @Size(max=300)
    private String trabaja_descripcion;
    private boolean apoyo;
    private String apoyo_descripcion;
    //////////////////////////////////
    
    private boolean antecedentes_psiquiatricos_personales_familiares;
    @Size(max=300)
    private String ant_psi_obs;
    ////////////////////////////////////////////
       /*
    SÍNDROMES GERIÁTRICOS DETECTADOS:				
	BOOLEAN	DEMENCIA		
	BOOLEAN	TRASTORNO DEL ÁNIMO		
    */
    private boolean demencia;
    private boolean transtorno_animo;

    public boolean isDemencia() {
        return demencia;
    }

    public void setDemencia(boolean demencia) {
        this.demencia = demencia;
    }

    public boolean isTranstorno_animo() {
        return transtorno_animo;
    }

    public void setTranstorno_animo(boolean transtorno_animo) {
        this.transtorno_animo = transtorno_animo;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYEVG_pregunta01() {
        return YEVG_pregunta01;
    }

    public void setYEVG_pregunta01(Integer YEVG_pregunta01) {
        this.YEVG_pregunta01 = YEVG_pregunta01;
    }

    public Integer getYEVG_pregunta02() {
        return YEVG_pregunta02;
    }

    public void setYEVG_pregunta02(Integer YEVG_pregunta02) {
        this.YEVG_pregunta02 = YEVG_pregunta02;
    }

    public Integer getYEVG_pregunta03() {
        return YEVG_pregunta03;
    }

    public void setYEVG_pregunta03(Integer YEVG_pregunta03) {
        this.YEVG_pregunta03 = YEVG_pregunta03;
    }

    public Integer getYEVG_pregunta04() {
        return YEVG_pregunta04;
    }

    public void setYEVG_pregunta04(Integer YEVG_pregunta04) {
        this.YEVG_pregunta04 = YEVG_pregunta04;
    }

    public Integer getYEVG_pregunta05() {
        return YEVG_pregunta05;
    }

    public void setYEVG_pregunta05(Integer YEVG_pregunta05) {
        this.YEVG_pregunta05 = YEVG_pregunta05;
    }

    public Integer getYEVG_pregunta06() {
        return YEVG_pregunta06;
    }

    public void setYEVG_pregunta06(Integer YEVG_pregunta06) {
        this.YEVG_pregunta06 = YEVG_pregunta06;
    }

    public Integer getYEVG_pregunta07() {
        return YEVG_pregunta07;
    }

    public void setYEVG_pregunta07(Integer YEVG_pregunta07) {
        this.YEVG_pregunta07 = YEVG_pregunta07;
    }

    public Integer getYEVG_pregunta08() {
        return YEVG_pregunta08;
    }

    public void setYEVG_pregunta08(Integer YEVG_pregunta08) {
        this.YEVG_pregunta08 = YEVG_pregunta08;
    }

    public Integer getYEVG_pregunta09() {
        return YEVG_pregunta09;
    }

    public void setYEVG_pregunta09(Integer YEVG_pregunta09) {
        this.YEVG_pregunta09 = YEVG_pregunta09;
    }

    public Integer getYEVG_pregunta10() {
        return YEVG_pregunta10;
    }

    public void setYEVG_pregunta10(Integer YEVG_pregunta10) {
        this.YEVG_pregunta10 = YEVG_pregunta10;
    }

    public Integer getYEVG_pregunta11() {
        return YEVG_pregunta11;
    }

    public void setYEVG_pregunta11(Integer YEVG_pregunta11) {
        this.YEVG_pregunta11 = YEVG_pregunta11;
    }

    public Integer getYEVG_pregunta12() {
        return YEVG_pregunta12;
    }

    public void setYEVG_pregunta12(Integer YEVG_pregunta12) {
        this.YEVG_pregunta12 = YEVG_pregunta12;
    }

    public Integer getYEVG_pregunta13() {
        return YEVG_pregunta13;
    }

    public void setYEVG_pregunta13(Integer YEVG_pregunta13) {
        this.YEVG_pregunta13 = YEVG_pregunta13;
    }

    public Integer getYEVG_pregunta14() {
        return YEVG_pregunta14;
    }

    public void setYEVG_pregunta14(Integer YEVG_pregunta14) {
        this.YEVG_pregunta14 = YEVG_pregunta14;
    }

    public Integer getYEVG_pregunta15() {
        return YEVG_pregunta15;
    }

    public void setYEVG_pregunta15(Integer YEVG_pregunta15) {
        this.YEVG_pregunta15 = YEVG_pregunta15;
    }

    public Integer getTotal_yesavage() {
        return total_yesavage;
    }

    public void setTotal_yesavage(Integer total_yesavage) {
        this.total_yesavage = total_yesavage;
    }

    public Integer getPFFR_pregunta01() {
        return PFFR_pregunta01;
    }

    public void setPFFR_pregunta01(Integer PFFR_pregunta01) {
        this.PFFR_pregunta01 = PFFR_pregunta01;
    }

    public Integer getPFFR_pregunta02() {
        return PFFR_pregunta02;
    }

    public void setPFFR_pregunta02(Integer PFFR_pregunta02) {
        this.PFFR_pregunta02 = PFFR_pregunta02;
    }

    public Integer getPFFR_pregunta03() {
        return PFFR_pregunta03;
    }

    public void setPFFR_pregunta03(Integer PFFR_pregunta03) {
        this.PFFR_pregunta03 = PFFR_pregunta03;
    }

    public Integer getPFFR_pregunta04() {
        return PFFR_pregunta04;
    }

    public void setPFFR_pregunta04(Integer PFFR_pregunta04) {
        this.PFFR_pregunta04 = PFFR_pregunta04;
    }

    public Integer getPFFR_pregunta05() {
        return PFFR_pregunta05;
    }

    public void setPFFR_pregunta05(Integer PFFR_pregunta05) {
        this.PFFR_pregunta05 = PFFR_pregunta05;
    }

    public Integer getPFFR_pregunta06() {
        return PFFR_pregunta06;
    }

    public void setPFFR_pregunta06(Integer PFFR_pregunta06) {
        this.PFFR_pregunta06 = PFFR_pregunta06;
    }

    public Integer getPFFR_pregunta07() {
        return PFFR_pregunta07;
    }

    public void setPFFR_pregunta07(Integer PFFR_pregunta07) {
        this.PFFR_pregunta07 = PFFR_pregunta07;
    }

    public Integer getPFFR_pregunta08() {
        return PFFR_pregunta08;
    }

    public void setPFFR_pregunta08(Integer PFFR_pregunta08) {
        this.PFFR_pregunta08 = PFFR_pregunta08;
    }

    public Integer getPFFR_pregunta09() {
        return PFFR_pregunta09;
    }

    public void setPFFR_pregunta09(Integer PFFR_pregunta09) {
        this.PFFR_pregunta09 = PFFR_pregunta09;
    }

    public Integer getPFFR_pregunta10() {
        return PFFR_pregunta10;
    }

    public void setPFFR_pregunta10(Integer PFFR_pregunta10) {
        this.PFFR_pregunta10 = PFFR_pregunta10;
    }

    public Integer getTotal_pfeffer() {
        return total_pfeffer;
    }

    public void setTotal_pfeffer(Integer total_pfeffer) {
        this.total_pfeffer = total_pfeffer;
    }

    public Integer getOrientacion_temporal() {
        return orientacion_temporal;
    }

    public void setOrientacion_temporal(Integer orientacion_temporal) {
        this.orientacion_temporal = orientacion_temporal;
    }

    public Integer getOrientacion_espacial() {
        return orientacion_espacial;
    }

    public void setOrientacion_espacial(Integer orientacion_espacial) {
        this.orientacion_espacial = orientacion_espacial;
    }

    public Integer getRecuerdo_Inmediato() {
        return recuerdo_Inmediato;
    }

    public void setRecuerdo_Inmediato(Integer recuerdo_Inmediato) {
        this.recuerdo_Inmediato = recuerdo_Inmediato;
    }

    public Integer getAtencion_calculo() {
        return atencion_calculo;
    }

    public void setAtencion_calculo(Integer atencion_calculo) {
        this.atencion_calculo = atencion_calculo;
    }

    public Integer getRecuedo_diferido() {
        return recuedo_diferido;
    }

    public void setRecuedo_diferido(Integer recuedo_diferido) {
        this.recuedo_diferido = recuedo_diferido;
    }

    public Integer getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(Integer lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Integer getTotal_folstein() {
        return total_folstein;
    }

    public void setTotal_folstein(Integer total_folstein) {
        this.total_folstein = total_folstein;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public boolean isTrabaja() {
        return trabaja;
    }

    public void setTrabaja(boolean trabaja) {
        this.trabaja = trabaja;
    }

    public String getTrabaja_descripcion() {
        return trabaja_descripcion;
    }

    public void setTrabaja_descripcion(String trabaja_descripcion) {
        this.trabaja_descripcion = trabaja_descripcion;
    }

    public boolean isApoyo() {
        return apoyo;
    }

    public void setApoyo(boolean apoyo) {
        this.apoyo = apoyo;
    }

    public String getApoyo_descripcion() {
        return apoyo_descripcion;
    }

    public void setApoyo_descripcion(String apoyo_descripcion) {
        this.apoyo_descripcion = apoyo_descripcion;
    }

    public boolean isAntecedentes_psiquiatricos_personales_familiares() {
        return antecedentes_psiquiatricos_personales_familiares;
    }

    public void setAntecedentes_psiquiatricos_personales_familiares(boolean antecedentes_psiquiatricos_personales_familiares) {
        this.antecedentes_psiquiatricos_personales_familiares = antecedentes_psiquiatricos_personales_familiares;
    }

    public String getAnt_psi_obs() {
        return ant_psi_obs;
    }

    public void setAnt_psi_obs(String ant_psi_obs) {
        this.ant_psi_obs = ant_psi_obs;
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
        if (!(object instanceof EsferaMentalPSAM)) {
            return false;
        }
        EsferaMentalPSAM other = (EsferaMentalPSAM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.adultoMayor.EsferaMentalPSAM[ id=" + id + " ]";
    }
    
}
