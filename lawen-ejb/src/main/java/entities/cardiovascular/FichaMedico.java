/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.cardiovascular;

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
public class FichaMedico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_fichamedico")
    private Long id;

    @Size(max=2000)
    private String anamnesis_medico;
  
    
    // Sintomatologia
    private boolean polifagia_medico;
    private boolean polidipsia_medico;
    private boolean poliuria_medico;
    private boolean perdidaDePeso_medico;
    private boolean cefalea_medico;
    private boolean mareos_medico;
    private boolean tinitus_medico;
    private boolean fotopsia_medico;
    private boolean sincope_medico;
    private boolean angor_medico;
    private boolean dpn_medico;
    private boolean ortopnea_medico;
    private boolean disnea_medico;
    private String otros_sintomatologia_medico;
    /////////

    /// EXAMEN FISICO
    
    private String examenFisico_cabeza;
    private String examenFisico_cuello;
    private String examenFisico_cardiaco;
    private String examenFisico_pulmonar;
    private String examenFisico_abdomen;
    private String examenFisico_eess;
    private String examenFisico_eeii;
    
    /////
    @Size(max=1000)
    private String diagnosticos_medico;
    @Size(max=1500)
    private String otrasIndicaciones_medico;
    @Size(max=1500)
    private String referencias_medico;
    
    
    //especificos ingreso
    private boolean icv_hta_cedazo;
    private boolean icv_hta_reingreso;
    private boolean icv_hta_traslado;
    private String icv_hta_extrasis;
    private String icv_hta_otros;
    private String icv_antecedentes_personales;
    private String icv_antecedentes_familiares;
    private boolean icv_dm_glicemiaalt;
    private boolean icv_dm_ptgo;
    private boolean icv_dm_glicemiamayor;
    private String icv_dm_otros;
    private String icv_otros_diagnosticos;
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnamnesis_medico() {
        return anamnesis_medico;
    }

    public void setAnamnesis_medico(String anamnesis_medico) {
        this.anamnesis_medico = anamnesis_medico;
    }

    public boolean isPolifagia_medico() {
        return polifagia_medico;
    }

    public void setPolifagia_medico(boolean polifagia_medico) {
        this.polifagia_medico = polifagia_medico;
    }

    public boolean isPolidipsia_medico() {
        return polidipsia_medico;
    }

    public void setPolidipsia_medico(boolean polidipsia_medico) {
        this.polidipsia_medico = polidipsia_medico;
    }

    public boolean isPoliuria_medico() {
        return poliuria_medico;
    }

    public void setPoliuria_medico(boolean poliuria_medico) {
        this.poliuria_medico = poliuria_medico;
    }

    public boolean isPerdidaDePeso_medico() {
        return perdidaDePeso_medico;
    }

    public void setPerdidaDePeso_medico(boolean perdidaDePeso_medico) {
        this.perdidaDePeso_medico = perdidaDePeso_medico;
    }

    public boolean isCefalea_medico() {
        return cefalea_medico;
    }

    public void setCefalea_medico(boolean cefalea_medico) {
        this.cefalea_medico = cefalea_medico;
    }

    public boolean isMareos_medico() {
        return mareos_medico;
    }

    public void setMareos_medico(boolean mareos_medico) {
        this.mareos_medico = mareos_medico;
    }

    public boolean isTinitus_medico() {
        return tinitus_medico;
    }

    public void setTinitus_medico(boolean tinitus_medico) {
        this.tinitus_medico = tinitus_medico;
    }

    public boolean isFotopsia_medico() {
        return fotopsia_medico;
    }

    public void setFotopsia_medico(boolean fotopsia_medico) {
        this.fotopsia_medico = fotopsia_medico;
    }

    public boolean isSincope_medico() {
        return sincope_medico;
    }

    public void setSincope_medico(boolean sincope_medico) {
        this.sincope_medico = sincope_medico;
    }

    public boolean isAngor_medico() {
        return angor_medico;
    }

    public void setAngor_medico(boolean angor_medico) {
        this.angor_medico = angor_medico;
    }

    public boolean isDpn_medico() {
        return dpn_medico;
    }

    public void setDpn_medico(boolean dpn_medico) {
        this.dpn_medico = dpn_medico;
    }

    public boolean isOrtopnea_medico() {
        return ortopnea_medico;
    }

    public void setOrtopnea_medico(boolean ortopnea_medico) {
        this.ortopnea_medico = ortopnea_medico;
    }

    public boolean isDisnea_medico() {
        return disnea_medico;
    }

    public void setDisnea_medico(boolean disnea_medico) {
        this.disnea_medico = disnea_medico;
    }

    public String getOtros_sintomatologia_medico() {
        return otros_sintomatologia_medico;
    }

    public void setOtros_sintomatologia_medico(String otros_sintomatologia_medico) {
        this.otros_sintomatologia_medico = otros_sintomatologia_medico;
    }

    public String getExamenFisico_cabeza() {
        return examenFisico_cabeza;
    }

    public void setExamenFisico_cabeza(String examenFisico_cabeza) {
        this.examenFisico_cabeza = examenFisico_cabeza;
    }

    public String getExamenFisico_cuello() {
        return examenFisico_cuello;
    }

    public void setExamenFisico_cuello(String examenFisico_cuello) {
        this.examenFisico_cuello = examenFisico_cuello;
    }

    public String getExamenFisico_cardiaco() {
        return examenFisico_cardiaco;
    }

    public void setExamenFisico_cardiaco(String examenFisico_cardiaco) {
        this.examenFisico_cardiaco = examenFisico_cardiaco;
    }

    public String getExamenFisico_pulmonar() {
        return examenFisico_pulmonar;
    }

    public void setExamenFisico_pulmonar(String examenFisico_pulmonar) {
        this.examenFisico_pulmonar = examenFisico_pulmonar;
    }

    public String getExamenFisico_abdomen() {
        return examenFisico_abdomen;
    }

    public void setExamenFisico_abdomen(String examenFisico_abdomen) {
        this.examenFisico_abdomen = examenFisico_abdomen;
    }

    public String getExamenFisico_eess() {
        return examenFisico_eess;
    }

    public void setExamenFisico_eess(String examenFisico_eess) {
        this.examenFisico_eess = examenFisico_eess;
    }

    public String getExamenFisico_eeii() {
        return examenFisico_eeii;
    }

    public void setExamenFisico_eeii(String examenFisico_eeii) {
        this.examenFisico_eeii = examenFisico_eeii;
    }

    public String getDiagnosticos_medico() {
        return diagnosticos_medico;
    }

    public void setDiagnosticos_medico(String diagnosticos_medico) {
        this.diagnosticos_medico = diagnosticos_medico;
    }

    public String getOtrasIndicaciones_medico() {
        return otrasIndicaciones_medico;
    }

    public void setOtrasIndicaciones_medico(String otrasIndicaciones_medico) {
        this.otrasIndicaciones_medico = otrasIndicaciones_medico;
    }

    public String getReferencias_medico() {
        return referencias_medico;
    }

    public void setReferencias_medico(String referencias_medico) {
        this.referencias_medico = referencias_medico;
    }

    public boolean isIcv_hta_cedazo() {
        return icv_hta_cedazo;
    }

    public void setIcv_hta_cedazo(boolean icv_hta_cedazo) {
        this.icv_hta_cedazo = icv_hta_cedazo;
    }

    public boolean isIcv_hta_reingreso() {
        return icv_hta_reingreso;
    }

    public void setIcv_hta_reingreso(boolean icv_hta_reingreso) {
        this.icv_hta_reingreso = icv_hta_reingreso;
    }

    public boolean isIcv_hta_traslado() {
        return icv_hta_traslado;
    }

    public void setIcv_hta_traslado(boolean icv_hta_traslado) {
        this.icv_hta_traslado = icv_hta_traslado;
    }

    public String getIcv_hta_extrasis() {
        return icv_hta_extrasis;
    }

    public void setIcv_hta_extrasis(String icv_hta_extrasis) {
        this.icv_hta_extrasis = icv_hta_extrasis;
    }

    public String getIcv_hta_otros() {
        return icv_hta_otros;
    }

    public void setIcv_hta_otros(String icv_hta_otros) {
        this.icv_hta_otros = icv_hta_otros;
    }

    public String getIcv_antecedentes_personales() {
        return icv_antecedentes_personales;
    }

    public void setIcv_antecedentes_personales(String icv_antecedentes_personales) {
        this.icv_antecedentes_personales = icv_antecedentes_personales;
    }

    public String getIcv_antecedentes_familiares() {
        return icv_antecedentes_familiares;
    }

    public void setIcv_antecedentes_familiares(String icv_antecedentes_familiares) {
        this.icv_antecedentes_familiares = icv_antecedentes_familiares;
    }

    public boolean isIcv_dm_glicemiaalt() {
        return icv_dm_glicemiaalt;
    }

    public void setIcv_dm_glicemiaalt(boolean icv_dm_glicemiaalt) {
        this.icv_dm_glicemiaalt = icv_dm_glicemiaalt;
    }

    public boolean isIcv_dm_ptgo() {
        return icv_dm_ptgo;
    }

    public void setIcv_dm_ptgo(boolean icv_dm_ptgo) {
        this.icv_dm_ptgo = icv_dm_ptgo;
    }

    public boolean isIcv_dm_glicemiamayor() {
        return icv_dm_glicemiamayor;
    }

    public void setIcv_dm_glicemiamayor(boolean icv_dm_glicemiamayor) {
        this.icv_dm_glicemiamayor = icv_dm_glicemiamayor;
    }

    public String getIcv_dm_otros() {
        return icv_dm_otros;
    }

    public void setIcv_dm_otros(String icv_dm_otros) {
        this.icv_dm_otros = icv_dm_otros;
    }

    public String getIcv_otros_diagnosticos() {
        return icv_otros_diagnosticos;
    }

    public void setIcv_otros_diagnosticos(String icv_otros_diagnosticos) {
        this.icv_otros_diagnosticos = icv_otros_diagnosticos;
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
        if (!(object instanceof FichaMedico)) {
            return false;
        }
        FichaMedico other = (FichaMedico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.cardiovascular.FichaMedico[ id=" + id + " ]";
    }
    
}
