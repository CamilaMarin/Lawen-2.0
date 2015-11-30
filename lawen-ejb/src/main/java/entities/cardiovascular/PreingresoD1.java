/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.cardiovascular;

import entities.Paciente;
import entities.TipoPrograma;
import entities.Usuario;
import java.io.Serializable;
import java.util.Date;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author matias
 */
@Entity
public class PreingresoD1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_preind1")
    private Long id;
    @NotNull(message = "Debe ingresar un Paciente")
    @JoinColumn(nullable = false)
    @ManyToOne(cascade = ALL, fetch = FetchType.LAZY )
    private Paciente pacientes;
    @NotNull(message = "Debe ingresar un Programa")
    @JoinColumn(nullable = false)
    @ManyToOne(cascade = ALL, fetch = FetchType.LAZY)
    private TipoPrograma tipoprograma;
    private String referido;//profesional referido
    private Integer pass1 ;// pa sistolica sentado 
    private Integer pass2;// pa sistolica sentado 
    private Integer pads1;// pa diastolica sentado
    private Integer pads2;// pa diastolica sentado
    private Integer pasp1;// pa sistolica pie
    private Integer pasp2;// pa sistolica pie 
    private Integer padp1;// pa diastolica pie 
    private Integer padp2;// pa diastolica pie
    private String antecedentespersocvc;
    private String antecedentesfamicvc;
    private Float peso;
    private Float talla;
    private String trataactual;//tratamiento farmacologico
    private boolean citarmed; //se cita al medico para el siguiente
    private boolean citar6;//se cita a 6 meses al paciente
    private boolean citard2;//cita a d2
    private Integer pulso;
    private String observaciones;
    private Integer paref1parado;//presion arterial referencia parado
    private Integer paref2parado;
    private Integer paref1sentado;//presion arterial referencia sentado
    private Integer paref2sentado;
    private boolean alta;//dado de alta
    private boolean derivacionicv;//deriva a icv
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date dated1;//fecha que se realizo
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario profesional;

    public String getAntecedentespersocvc() {
        return antecedentespersocvc;
    }

    public void setAntecedentespersocvc(String antecedentespersocvc) {
        this.antecedentespersocvc = antecedentespersocvc;
    }

    public String getAntecedentesfamicvc() {
        return antecedentesfamicvc;
    }

    public void setAntecedentesfamicvc(String antecedentesfamicvc) {
        this.antecedentesfamicvc = antecedentesfamicvc;
    }
    
    public Paciente getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente pacientes) {
        this.pacientes = pacientes;
    }

    public TipoPrograma getTipoprograma() {
        return tipoprograma;
    }

    public void setTipoprograma(TipoPrograma tipoprograma) {
        this.tipoprograma = tipoprograma;
    }

    public String getReferido() {
        return referido;
    }

    public void setReferido(String referido) {
        this.referido = referido;
    }

    public Integer getPass1() {
        return pass1;
    }

    public void setPass1(Integer pass1) {
        this.pass1 = pass1;
    }

    public Integer getPass2() {
        return pass2;
    }

    public void setPass2(Integer pass2) {
        this.pass2 = pass2;
    }

    public Integer getPads1() {
        return pads1;
    }

    public void setPads1(Integer pads1) {
        this.pads1 = pads1;
    }

    public Integer getPads2() {
        return pads2;
    }

    public void setPads2(Integer pads2) {
        this.pads2 = pads2;
    }

    public Integer getPasp1() {
        return pasp1;
    }

    public void setPasp1(Integer pasp1) {
        this.pasp1 = pasp1;
    }

    public Integer getPasp2() {
        return pasp2;
    }

    public void setPasp2(Integer pasp2) {
        this.pasp2 = pasp2;
    }

    public Integer getPadp1() {
        return padp1;
    }

    public void setPadp1(Integer padp1) {
        this.padp1 = padp1;
    }

    public Integer getPadp2() {
        return padp2;
    }

    public void setPadp2(Integer padp2) {
        this.padp2 = padp2;
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

    public String getTrataactual() {
        return trataactual;
    }

    public void setTrataactual(String trataactual) {
        this.trataactual = trataactual;
    }

    public boolean isCitarmed() {
        return citarmed;
    }

    public void setCitarmed(boolean citarmed) {
        this.citarmed = citarmed;
    }

    public boolean isCitar6() {
        return citar6;
    }

    public void setCitar6(boolean citar6) {
        this.citar6 = citar6;
    }

    public boolean isCitard2() {
        return citard2;
    }

    public void setCitard2(boolean citard2) {
        this.citard2 = citard2;
    }

    public Integer getPulso() {
        return pulso;
    }

    public void setPulso(Integer pulso) {
        this.pulso = pulso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getParef1parado() {
        return paref1parado;
    }

    public void setParef1parado(Integer paref1parado) {
        this.paref1parado = paref1parado;
    }

    public Integer getParef2parado() {
        return paref2parado;
    }

    public void setParef2parado(Integer paref2parado) {
        this.paref2parado = paref2parado;
    }

    public Integer getParef1sentado() {
        return paref1sentado;
    }

    public void setParef1sentado(Integer paref1sentado) {
        this.paref1sentado = paref1sentado;
    }

    public Integer getParef2sentado() {
        return paref2sentado;
    }

    public void setParef2sentado(Integer paref2sentado) {
        this.paref2sentado = paref2sentado;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public boolean isDerivacionicv() {
        return derivacionicv;
    }

    public void setDerivacionicv(boolean derivacionicv) {
        this.derivacionicv = derivacionicv;
    }

    public Date getDated1() {
        return dated1;
    }

    public void setDated1(Date dated1) {
        this.dated1 = dated1;
    }

    public Usuario getProfesional() {
        return profesional;
    }

    public void setProfesional(Usuario profesional) {
        this.profesional = profesional;
    }


    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof PreingresoD1)) {
            return false;
        }
        PreingresoD1 other = (PreingresoD1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.cardiovascular.PreingresoD1[ id=" + id+ " ]";
    }
    
}
