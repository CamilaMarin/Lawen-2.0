/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 La idea es que los siguientes datos estén de forma 'estática' cuando se atiende un paciente, SIEMPRE tener acceso sin tener que volver a cargar la página (deben estar predefinidamente desplegdas pero con la posibilidad de minimizar) - Ubicación superior-centrada en la vista.
***: Antecedentes requeridos de forma obligatoria.

Antecedentes personales:
	Rut*** (char[15])
	Nombres*** (char[15])
	Apellido Paterno*** (char[15])
	Apellido materno (char[15])
	Fecha de nacimiento***  (date)
	Genero (char[15] del tipo: Masculino - Femenino)
	Email (char[15] del tipo )
	Domicilio (char[30])
	Telefono 1 (char[15])
	Telefono 2 (char[15])
	Escolaridad (char[30])

Antecedentes generales:
	Numero de ficha*** (char[15] del tipo: XXXXXX-X)
	Numero de registro (char[15])
	Sector (char[15] del tipo: Naranjo - Rojo - Azul - Verde)
	Previsión (char[15] del tipo: Fonasa A - Fonasa B - Fonasa C - Fonasa D - Otra)
	Fecha de inscripción (date ; permitir ingresar manualmente (para cuando ellos poblen) y automaticamente)

Antecedentes morbidos:
	*Listar programas de Salud a los que pertenece junto con la fecha de inscripción según corresponda.
	*Listar patologías, (se requiere crear previamente tabla db con lista de patologías, crud de patologias, 100 en total aprox; para asociar a paciente)
        HOSPITALIZACIONES ANTERIORES (char[1500])
	ALERGIAS (char[140])
	ANTECEDENTES QUIRÚRGICOS (char[300])
	ANTECEDENTES OBSTÉTRICOS (char[300])
	HÁBITOS:
		ALCOHOL (Boolean)
		TABACO (Boolean)
		DROGAS (Boolean)
		ACTIVIDAD FÍSICA (char[140])   
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Paciente.findByEstado", query = "SELECT p FROM Paciente p WHERE p.estado = :estado"),
    @NamedQuery(name = "Paciente.findByPacienteRut", query = "SELECT c FROM Paciente c WHERE c.rut_paciente = :rut_paciente"),
     @NamedQuery(name = "Paciente.findByPacienteId", query = "SELECT c FROM Paciente c WHERE c.id = :id"),
      @NamedQuery(name = "Paciente.findbyGenero", query = "SELECT c FROM Paciente c WHERE c.genero_paciente = :genero_paciente")
})
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"rut_paciente"} )})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_paciente")
    private Long id;
    // ANTECEDENTES PERSONALES
    @NotNull(message = "Debe ingresar un Rut")
    private String rut_paciente;
    @NotNull(message = "Debe ingresar un Nombre")
    private String nombres_paciente;
    @NotNull(message = "Debe ingresar un Apellido Paterno")
    private String apellidoPaterno_paciente;
    private String apellidoMaterno_paciente;
    @NotNull(message = "Debe ingresar una Fecha de nacimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaNacimiento_paciente;
    private String genero_paciente;
    private String email_paciente;
    private String direccion_paciente;
    private String nacionalidad_paciente;
    private String etnia_paciente;
    private String ocupacion_paciente;
    private String telefono1;
    private String telefono2;
    private String estadoCivil_paciente;
    private String escolaridad_paciente;
    private boolean etnia;
    private String estado;
    //ANTECEDENTES GENERALES
      
      // NUMERO DE FIHCA
      private String numeroFicha_paciente;
      // NUMERO DE REGISTRO
      private String numeroRegistro_paciente;
      private String sector_paciente;
      private String prevision_paciente;
    @Temporal(javax.persistence.TemporalType.DATE)
      private java.util.Date fechaInscripcion_paciente;
      
   // ANTECEDENTES MORBIDOS
       
      @OneToMany(cascade = ALL, mappedBy ="paciente", fetch = FetchType.LAZY)
      private List<Patologia> patologia;
      
      @OneToMany(cascade = ALL, mappedBy ="paciente", fetch = FetchType.LAZY)
      private List<Programa> programas;
      //Hospitalizaciones anteriores
      ///Alergias
      private String hospitalizaciones_paciente;
      private String alergias_paciente;
      private String anteQuirurjicos_paciente;
      private String anteObstetricos_paciente;
      // hábitos
      
      private boolean alcohol_paciente;
      private boolean tabaco_paciente;
      private boolean drogas_paciente;
      private String actividadFisica_paciente;
      
      
      // Patologías crónicas
      private boolean hipertencion;
      private boolean diabetico;
      private boolean dislipidemico;
      
      // Antecedentes CCV
      
      private boolean IAM;
      private boolean ACV;
      private boolean prediabetes;
      
      
      
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    
    
    public boolean isHipertencion() {
        return hipertencion;
    }

    public void setHipertencion(boolean hipertencion) {
        this.hipertencion = hipertencion;
    }

    public boolean isDiabetico() {
        return diabetico;
    }

    public void setDiabetico(boolean diabetico) {
        this.diabetico = diabetico;
    }

    public boolean isDislipidemico() {
        return dislipidemico;
    }

    public void setDislipidemico(boolean dislipidemico) {
        this.dislipidemico = dislipidemico;
    }

    
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    public boolean isEtnia() {
        return etnia;
    }

    public void setEtnia(boolean etnia) {
        this.etnia = etnia;
    }

    
    
    public String getRut_paciente() {
        return rut_paciente;
    }

    public void setRut_paciente(String rut_paciente) {
        this.rut_paciente = rut_paciente;
    }
    public String getNombres_paciente() {
        return nombres_paciente;
    }

    public void setNombres_paciente(String nombres_paciente) {
        this.nombres_paciente = nombres_paciente;
    }

    public String getApellidoPaterno_paciente() {
        return apellidoPaterno_paciente;
    }

    public void setApellidoPaterno_paciente(String apellidoPaterno_paciente) {
        this.apellidoPaterno_paciente = apellidoPaterno_paciente;
    }

    public String getApellidoMaterno_paciente() {
        return apellidoMaterno_paciente;
    }

    public void setApellidoMaterno_paciente(String apellidoMaterno_paciente) {
        this.apellidoMaterno_paciente = apellidoMaterno_paciente;
    }

    public String getGenero_paciente() {
        return genero_paciente;
    }

    public void setGenero_paciente(String genero_paciente) {
        this.genero_paciente = genero_paciente;
    }

    public String getEmail_paciente() {
        return email_paciente;
    }

    public void setEmail_paciente(String email_paciente) {
        this.email_paciente = email_paciente;
    }

    public String getDireccion_paciente() {
        return direccion_paciente;
    }

    public void setDireccion_paciente(String direccion_paciente) {
        this.direccion_paciente = direccion_paciente;
    }

    public String getNacionalidad_paciente() {
        return nacionalidad_paciente;
    }

    public void setNacionalidad_paciente(String nacionalidad_paciente) {
        this.nacionalidad_paciente = nacionalidad_paciente;
    }

    public String getEtnia_paciente() {
        return etnia_paciente;
    }

    public void setEtnia_paciente(String etnia_paciente) {
        this.etnia_paciente = etnia_paciente;
    }

    public String getOcupacion_paciente() {
        return ocupacion_paciente;
    }

    public void setOcupacion_paciente(String ocupacion_paciente) {
        this.ocupacion_paciente = ocupacion_paciente;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }
  
    public String getEstadoCivil_paciente() {
        return estadoCivil_paciente;
    }

    public void setEstadoCivil_paciente(String estadoCivil_paciente) {
        this.estadoCivil_paciente = estadoCivil_paciente;
    }

    public String getEscolaridad_paciente() {
        return escolaridad_paciente;
    }

    public void setEscolaridad_paciente(String escolaridad_paciente) {
        this.escolaridad_paciente = escolaridad_paciente;
    }

    public String getSector_paciente() {
        return sector_paciente;
    }

    public void setSector_paciente(String sector_paciente) {
        this.sector_paciente = sector_paciente;
    }

    public String getPrevision_paciente() {
        return prevision_paciente;
    }

    public void setPrevision_paciente(String prevision_paciente) {
        this.prevision_paciente = prevision_paciente;
    }

  

    public String getNumeroFicha_paciente() {
        return numeroFicha_paciente;
    }

    public void setNumeroFicha_paciente(String numeroFicha_paciente) {
        this.numeroFicha_paciente = numeroFicha_paciente;
    }

    public String getNumeroRegistro_paciente() {
        return numeroRegistro_paciente;
    }

    public void setNumeroRegistro_paciente(String numeroRegistro_paciente) {
        this.numeroRegistro_paciente = numeroRegistro_paciente;
    }

    public List<Patologia> getPatologia() {
        return patologia;
    }

    public void setPatologia(List<Patologia> patologia) {
        this.patologia = patologia;
    }

    

    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }

    public String getHospitalizaciones_paciente() {
        return hospitalizaciones_paciente;
    }

    public void setHospitalizaciones_paciente(String hospitalizaciones_paciente) {
        this.hospitalizaciones_paciente = hospitalizaciones_paciente;
    }

    public String getAlergias_paciente() {
        return alergias_paciente;
    }

    public void setAlergias_paciente(String alergias_paciente) {
        this.alergias_paciente = alergias_paciente;
    }

    public java.util.Date getFechaNacimiento_paciente() {
        return fechaNacimiento_paciente;
    }

    public void setFechaNacimiento_paciente(java.util.Date fechaNacimiento_paciente) {
        this.fechaNacimiento_paciente = fechaNacimiento_paciente;
    }

    public java.util.Date getFechaInscripcion_paciente() {
        return fechaInscripcion_paciente;
    }

    public void setFechaInscripcion_paciente(java.util.Date fechaInscripcion_paciente) {
        this.fechaInscripcion_paciente = fechaInscripcion_paciente;
    }

    public String getAnteQuirurjicos_paciente() {
        return anteQuirurjicos_paciente;
    }

    public void setAnteQuirurjicos_paciente(String anteQuirurjicos_paciente) {
        this.anteQuirurjicos_paciente = anteQuirurjicos_paciente;
    }

    public String getAnteObstetricos_paciente() {
        return anteObstetricos_paciente;
    }

    public void setAnteObstetricos_paciente(String anteObstetricos_paciente) {
        this.anteObstetricos_paciente = anteObstetricos_paciente;
    }

    public boolean isAlcohol_paciente() {
        return alcohol_paciente;
    }

    public void setAlcohol_paciente(boolean alcohol_paciente) {
        this.alcohol_paciente = alcohol_paciente;
    }

    public boolean isTabaco_paciente() {
        return tabaco_paciente;
    }

    public void setTabaco_paciente(boolean tabaco_paciente) {
        this.tabaco_paciente = tabaco_paciente;
    }

    public boolean isDrogas_paciente() {
        return drogas_paciente;
    }

    public void setDrogas_paciente(boolean drogas_paciente) {
        this.drogas_paciente = drogas_paciente;
    }
    public String getActividadFisica_paciente() {
        return actividadFisica_paciente;
    }

    public void setActividadFisica_paciente(String actividadFisica_paciente) {
        this.actividadFisica_paciente = actividadFisica_paciente;
    }

    public boolean isPrediabetes() {
        return prediabetes;
    }

    public void setPrediabetes(boolean prediabetes) {
        this.prediabetes = prediabetes;
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
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rut_paciente  + " - " + nombres_paciente +" " + apellidoPaterno_paciente;
    }
   
    
}
