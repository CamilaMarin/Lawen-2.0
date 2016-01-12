package entities.subprogramas;

import entities.Paciente;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Francisco Avello
 */
@Entity
@Table(name="tarjetaidentificacionira")
public class TarjetaIdentificacionIRA implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_tarjetaidenficacionira")
    private Long id;
    
    @JoinColumn(nullable = false)
    @ManyToOne
    private Paciente paciente;
    
    //Historia Personal
    
    private Integer numEpisodiosUltAno;
    private String rotacionEstacionalPrimavera;
    private String rotacionEstacionalVerano;
    private Integer numHospitalizacionesAbeviadas;
    private Integer numHospitalizacionesPrevias;
    private String sintomasPeriodosIntercrisisTosConEjercicios;
    private String sintomasPeriodosIntercrisisTosNocturna;
    private Integer numCurasEsteroidalesUltAno;    
    private Integer edadInicioCorticoidesInhalados;
    private Integer numBNMPrevias;
    private Integer numHospitPreviasBNM;
    private String scoreRiesgo;
    private String atopiaRinitis;
    private String atopiaDermatitis;
    private String atopiaAlimentos;
    
    // antecedentes familiares
    
    private String papaAsmaSBO;
    private String papaRinitis;
    private String papaDermatitis;
    private String papaOtros;
    private String mamaAsmaSBO;
    private String mamaRinitis;
    private String mamaDermatitis;
    private String mamaOtros;
    private String hnosAsmaSBO;
    private String hnosRinitis;
    private String hnosDermatitis;
    private String hnosOtros;
    private Integer hnosFallecidosBNM;
    
    // Condiciones vivienda
    
    private String materialCasaSolido;
    private String materialCasaMediaAgua;
    private String materialCasaMixto;
    private String calefaccionBrasero;    
    private String calefaccionParafina;
    private String calefaccionGas;
    private String calefaccionElectrica;
    private Integer hacinamientoNumPersonas;
    private Integer hacinamientoNumHabitaciones;
    private Integer hacinamientoNumCamas;
    
    // Contaminación intradomiciliaria
    
    private String tabaquismoPadre;
    private String tabaquismoMadre;
    private String tabaquismoOtros;
    private Integer numPerros;
    private Integer numGatos;
    private Integer numAves;
    
    // Contaminación extradomiciliaria
    
    private String tallerIndustriaCercana;
    private String callesSinPavimentar;
    
    private String educacionIRA;
    
    private String impresionMadre;
    
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

    public Integer getNumEpisodiosUltAno() {
        return numEpisodiosUltAno;
    }

    public void setNumEpisodiosUltAno(Integer numEpisodiosUltAno) {
        this.numEpisodiosUltAno = numEpisodiosUltAno;
    }

    public String getRotacionEstacionalPrimavera() {
        return rotacionEstacionalPrimavera;
    }

    public void setRotacionEstacionalPrimavera(String rotacionEstacionalPrimavera) {
        this.rotacionEstacionalPrimavera = rotacionEstacionalPrimavera;
    }

    public String getRotacionEstacionalVerano() {
        return rotacionEstacionalVerano;
    }

    public void setRotacionEstacionalVerano(String rotacionEstacionalVerano) {
        this.rotacionEstacionalVerano = rotacionEstacionalVerano;
    }
    
    public Integer getNumHospitalizacionesAbeviadas() {
        return numHospitalizacionesAbeviadas;
    }

    public void setNumHospitalizacionesAbeviadas(Integer numHospitalizacionesAbeviadas) {
        this.numHospitalizacionesAbeviadas = numHospitalizacionesAbeviadas;
    }

    public Integer getNumHospitalizacionesPrevias() {
        return numHospitalizacionesPrevias;
    }

    public void setNumHospitalizacionesPrevias(Integer numHospitalizacionesPrevias) {
        this.numHospitalizacionesPrevias = numHospitalizacionesPrevias;
    }

    public String getSintomasPeriodosIntercrisisTosConEjercicios() {
        return sintomasPeriodosIntercrisisTosConEjercicios;
    }

    public void setSintomasPeriodosIntercrisisTosConEjercicios(String sintomasPeriodosIntercrisisTosConEjercicios) {
        this.sintomasPeriodosIntercrisisTosConEjercicios = sintomasPeriodosIntercrisisTosConEjercicios;
    }

    public String getSintomasPeriodosIntercrisisTosNocturna() {
        return sintomasPeriodosIntercrisisTosNocturna;
    }

    public void setSintomasPeriodosIntercrisisTosNocturna(String sintomasPeriodosIntercrisisTosNocturna) {
        this.sintomasPeriodosIntercrisisTosNocturna = sintomasPeriodosIntercrisisTosNocturna;
    }

    public Integer getNumCurasEsteroidalesUltAno() {
        return numCurasEsteroidalesUltAno;
    }

    public void setNumCurasEsteroidalesUltAno(Integer numCurasEsteroidalesUltAno) {
        this.numCurasEsteroidalesUltAno = numCurasEsteroidalesUltAno;
    }

    public Integer getEdadInicioCorticoidesInhalados() {
        return edadInicioCorticoidesInhalados;
    }

    public void setEdadInicioCorticoidesInhalados(Integer edadInicioCorticoidesInhalados) {
        this.edadInicioCorticoidesInhalados = edadInicioCorticoidesInhalados;
    }

    public Integer getNumBNMPrevias() {
        return numBNMPrevias;
    }

    public void setNumBNMPrevias(Integer numBNMPrevias) {
        this.numBNMPrevias = numBNMPrevias;
    }

    public Integer getNumHospitPreviasBNM() {
        return numHospitPreviasBNM;
    }

    public void setNumHospitPreviasBNM(Integer numHospitPreviasBNM) {
        this.numHospitPreviasBNM = numHospitPreviasBNM;
    }

    public String getScoreRiesgo() {
        return scoreRiesgo;
    }

    public void setScoreRiesgo(String scoreRiesgo) {
        this.scoreRiesgo = scoreRiesgo;
    }

    public String getAtopiaRinitis() {
        return atopiaRinitis;
    }

    public void setAtopiaRinitis(String atopiaRinitis) {
        this.atopiaRinitis = atopiaRinitis;
    }

    public String getAtopiaDermatitis() {
        return atopiaDermatitis;
    }

    public void setAtopiaDermatitis(String atopiaDermatitis) {
        this.atopiaDermatitis = atopiaDermatitis;
    }

    public String getAtopiaAlimentos() {
        return atopiaAlimentos;
    }

    public void setAtopiaAlimentos(String atopiaAlimentos) {
        this.atopiaAlimentos = atopiaAlimentos;
    }

    public String getPapaAsmaSBO() {
        return papaAsmaSBO;
    }

    public void setPapaAsmaSBO(String papaAsmaSBO) {
        this.papaAsmaSBO = papaAsmaSBO;
    }

    public String getPapaRinitis() {
        return papaRinitis;
    }

    public void setPapaRinitis(String papaRinitis) {
        this.papaRinitis = papaRinitis;
    }

    public String getPapaDermatitis() {
        return papaDermatitis;
    }

    public void setPapaDermatitis(String papaDermatitis) {
        this.papaDermatitis = papaDermatitis;
    }

    public String getPapaOtros() {
        return papaOtros;
    }

    public void setPapaOtros(String papaOtros) {
        this.papaOtros = papaOtros;
    }

    public String getMamaAsmaSBO() {
        return mamaAsmaSBO;
    }

    public void setMamaAsmaSBO(String mamaAsmaSBO) {
        this.mamaAsmaSBO = mamaAsmaSBO;
    }

    public String getMamaRinitis() {
        return mamaRinitis;
    }

    public void setMamaRinitis(String mamaRinitis) {
        this.mamaRinitis = mamaRinitis;
    }

    public String getMamaDermatitis() {
        return mamaDermatitis;
    }

    public void setMamaDermatitis(String mamaDermatitis) {
        this.mamaDermatitis = mamaDermatitis;
    }

    public String getMamaOtros() {
        return mamaOtros;
    }

    public void setMamaOtros(String mamaOtros) {
        this.mamaOtros = mamaOtros;
    }

    public String getHnosAsmaSBO() {
        return hnosAsmaSBO;
    }

    public void setHnosAsmaSBO(String hnosAsmaSBO) {
        this.hnosAsmaSBO = hnosAsmaSBO;
    }

    public String getHnosRinitis() {
        return hnosRinitis;
    }

    public void setHnosRinitis(String hnosRinitis) {
        this.hnosRinitis = hnosRinitis;
    }

    public String getHnosDermatitis() {
        return hnosDermatitis;
    }

    public void setHnosDermatitis(String hnosDermatitis) {
        this.hnosDermatitis = hnosDermatitis;
    }

    public String getHnosOtros() {
        return hnosOtros;
    }

    public void setHnosOtros(String hnosOtros) {
        this.hnosOtros = hnosOtros;
    }

    public Integer getHnosFallecidosBNM() {
        return hnosFallecidosBNM;
    }

    public void setHnosFallecidosBNM(Integer hnosFallecidosBNM) {
        this.hnosFallecidosBNM = hnosFallecidosBNM;
    }

    public String getMaterialCasaSolido() {
        return materialCasaSolido;
    }

    public void setMaterialCasaSolido(String materialCasaSolido) {
        this.materialCasaSolido = materialCasaSolido;
    }

    public String getMaterialCasaMediaAgua() {
        return materialCasaMediaAgua;
    }

    public void setMaterialCasaMediaAgua(String materialCasaMediaAgua) {
        this.materialCasaMediaAgua = materialCasaMediaAgua;
    }

    public String getMaterialCasaMixto() {
        return materialCasaMixto;
    }

    public void setMaterialCasaMixto(String materialCasaMixto) {
        this.materialCasaMixto = materialCasaMixto;
    }

    public String getCalefaccionBrasero() {
        return calefaccionBrasero;
    }

    public void setCalefaccionBrasero(String calefaccionBrasero) {
        this.calefaccionBrasero = calefaccionBrasero;
    }

    public String getCalefaccionParafina() {
        return calefaccionParafina;
    }

    public void setCalefaccionParafina(String calefaccionParafina) {
        this.calefaccionParafina = calefaccionParafina;
    }

    public String getCalefaccionGas() {
        return calefaccionGas;
    }

    public void setCalefaccionGas(String calefaccionGas) {
        this.calefaccionGas = calefaccionGas;
    }

    public String getCalefaccionElectrica() {
        return calefaccionElectrica;
    }

    public void setCalefaccionElectrica(String calefaccionElectrica) {
        this.calefaccionElectrica = calefaccionElectrica;
    }

    public Integer getHacinamientoNumPersonas() {
        return hacinamientoNumPersonas;
    }

    public void setHacinamientoNumPersonas(Integer hacinamientoNumPersonas) {
        this.hacinamientoNumPersonas = hacinamientoNumPersonas;
    }

    public Integer getHacinamientoNumHabitaciones() {
        return hacinamientoNumHabitaciones;
    }

    public void setHacinamientoNumHabitaciones(Integer hacinamientoNumHabitaciones) {
        this.hacinamientoNumHabitaciones = hacinamientoNumHabitaciones;
    }

    public Integer getHacinamientoNumCamas() {
        return hacinamientoNumCamas;
    }

    public void setHacinamientoNumCamas(Integer hacinamientoNumCamas) {
        this.hacinamientoNumCamas = hacinamientoNumCamas;
    }

    public String getTabaquismoPadre() {
        return tabaquismoPadre;
    }

    public void setTabaquismoPadre(String tabaquismoPadre) {
        this.tabaquismoPadre = tabaquismoPadre;
    }

    public String getTabaquismoMadre() {
        return tabaquismoMadre;
    }

    public void setTabaquismoMadre(String tabaquismoMadre) {
        this.tabaquismoMadre = tabaquismoMadre;
    }

    public String getTabaquismoOtros() {
        return tabaquismoOtros;
    }

    public void setTabaquismoOtros(String tabaquismoOtros) {
        this.tabaquismoOtros = tabaquismoOtros;
    }

    public Integer getNumPerros() {
        return numPerros;
    }

    public void setNumPerros(Integer numPerros) {
        this.numPerros = numPerros;
    }

    public Integer getNumGatos() {
        return numGatos;
    }

    public void setNumGatos(Integer numGatos) {
        this.numGatos = numGatos;
    }

    public Integer getNumAves() {
        return numAves;
    }

    public void setNumAves(Integer numAves) {
        this.numAves = numAves;
    }

    public String getTallerIndustriaCercana() {
        return tallerIndustriaCercana;
    }

    public void setTallerIndustriaCercana(String tallerIndustriaCercana) {
        this.tallerIndustriaCercana = tallerIndustriaCercana;
    }

    public String getCallesSinPavimentar() {
        return callesSinPavimentar;
    }

    public void setCallesSinPavimentar(String callesSinPavimentar) {
        this.callesSinPavimentar = callesSinPavimentar;
    }

    public String getEducacionIRA() {
        return educacionIRA;
    }

    public void setEducacionIRA(String educacionIRA) {
        this.educacionIRA = educacionIRA;
    }

    public String getImpresionMadre() {
        return impresionMadre;
    }

    public void setImpresionMadre(String impresionMadre) {
        this.impresionMadre = impresionMadre;
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
        if (!(object instanceof TarjetaIdentificacionIRA)) {
            return false;
        }
        TarjetaIdentificacionIRA other = (TarjetaIdentificacionIRA) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.subprogramas.TarjetaIdentificacionIRA[ id=" + id + " ]";
    }
    
}
