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
public class PreingresoD2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_preind2")
    private Long id;
    @NotNull(message = "Debe ingresar un Paciente")
    @JoinColumn(nullable = false)
    @ManyToOne(cascade = ALL, fetch = FetchType.LAZY)
    private Paciente pacientes;
    @NotNull(message = "Debe ingresar un Programa")
    @JoinColumn(nullable = false)
    @ManyToOne(cascade = ALL, fetch = FetchType.LAZY)
    private TipoPrograma tipoprograma;
    
    //private String referido;//profesional referido
    private int pass1 ;// pa sistolica sentado 
    private int pass2;// pa sistolica sentado 
    private int pads1;// pa diastolica sentado
    private int pads2;// pa diastolica sentado
    private int pasp1;// pa sistolica pie
    private int pasp2;// pa sistolica pie 
    private int padp1;// pa diastolica pie 
    private int padp2;// pa diastolica pie
    private double peso;
    //private double talla;
    //private String trataactual;//tratamiento farmacologico
    private boolean citarmed; //se cita al medico para el siguiente
    private boolean citar4;//se cita a 4 meses al paciente
    private boolean citard3;//cita a d3
    private int pulso;
    private String observaciones;
    private boolean alta;//dado de alta
    private boolean derivacionicv;//deriva a icv
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date dated2;//fecha que se realizo
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario profesional;

    public Usuario getProfesional() {
        return profesional;
    }

    public void setProfesional(Usuario profesional) {
        this.profesional = profesional;
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

    public int getPass1() {
        return pass1;
    }

    public void setPass1(int pass1) {
        this.pass1 = pass1;
    }

    public int getPass2() {
        return pass2;
    }

    public void setPass2(int pass2) {
        this.pass2 = pass2;
    }

    public int getPads1() {
        return pads1;
    }

    public void setPads1(int pads1) {
        this.pads1 = pads1;
    }

    public int getPads2() {
        return pads2;
    }

    public void setPads2(int pads2) {
        this.pads2 = pads2;
    }

    public int getPasp1() {
        return pasp1;
    }

    public void setPasp1(int pasp1) {
        this.pasp1 = pasp1;
    }

    public int getPasp2() {
        return pasp2;
    }

    public void setPasp2(int pasp2) {
        this.pasp2 = pasp2;
    }

    public int getPadp1() {
        return padp1;
    }

    public void setPadp1(int padp1) {
        this.padp1 = padp1;
    }

    public int getPadp2() {
        return padp2;
    }

    public void setPadp2(int padp2) {
        this.padp2 = padp2;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isCitarmed() {
        return citarmed;
    }

    public void setCitarmed(boolean citarmed) {
        this.citarmed = citarmed;
    }

    public boolean isCitar4() {
        return citar4;
    }

    public void setCitar4(boolean citar4) {
        this.citar4 = citar4;
    }

    public boolean isCitard3() {
        return citard3;
    }

    public void setCitard3(boolean citard3) {
        this.citard3 = citard3;
    }

    public int getPulso() {
        return pulso;
    }

    public void setPulso(int pulso) {
        this.pulso = pulso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public Date getDated2() {
        return dated2;
    }

    public void setDated2(Date dated2) {
        this.dated2 = dated2;
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
        if (!(object instanceof PreingresoD2)) {
            return false;
        }
        PreingresoD2 other = (PreingresoD2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.cardiovascular.PreingresoD2[ id=" + id + " ]";
    }
    
}
