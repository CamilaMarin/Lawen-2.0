package managedbeans.cardiovascular.censonorem;

import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author matias
 */
@Named(value = "censoCCVnoREM")
@ViewScoped
public class CensoCCVnoREM {
    private int fallecidos;
    private int pbc;
    private int perfilLipidico;
    private int fondoOjo;
    private int atencionPodologica;
    private int hba1c4;
    private int hba1c3;
    private int hba1c2;
    private int hba1c1;
    private int creatinina;
    private int microalbuminuria;
    private int potasioPlasmatico;
    private int ecg;
    private int complicacion;
    private int retinopatiaDiabetica;
    private int infarto;
    private int accidenteVascular;
    private int cegueraPost;
    private int hipertrofia;
    private int nefropatia;
    private int insuficienciaRenal;
    private int pieDiabeticoEvaluacion;
    private int pieDiabeticoUlcera;
    private int pieDiabeticoHerida;
    private int amputacionDiabetica;
    private int preDiabeticos;
    private String nombreColumna;
    private String nombreColumna2;

    public String getNombreColumna2() {
        return nombreColumna2;
    }

    public void setNombreColumna2(String nombreColumna2) {
        this.nombreColumna2 = nombreColumna2;
    }
    
    public String getNombreColumna() {
        return nombreColumna;
    }

    public void setNombreColumna(String nombreColumna) {
        this.nombreColumna = nombreColumna;
    }
    
    public int getPreDiabeticos() {
        return preDiabeticos;
    }

    public void setPreDiabeticos(int preDiabeticos) {
        this.preDiabeticos = preDiabeticos;
    }

    public int getFallecidos() {
        return fallecidos;
    }

    public void setFallecidos(int fallecidos) {
        this.fallecidos = fallecidos;
    }

    public int getPbc() {
        return pbc;
    }

    public void setPbc(int pbc) {
        this.pbc = pbc;
    }

    

    public int getPerfilLipidico() {
        return perfilLipidico;
    }

    public void setPerfilLipidico(int perfilLipidico) {
        this.perfilLipidico = perfilLipidico;
    }

    public int getFondoOjo() {
        return fondoOjo;
    }

    public void setFondoOjo(int fondoOjo) {
        this.fondoOjo = fondoOjo;
    }

    public int getAtencionPodologica() {
        return atencionPodologica;
    }

    public void setAtencionPodologica(int atencionPodologica) {
        this.atencionPodologica = atencionPodologica;
    }

    public int getHba1c4() {
        return hba1c4;
    }

    public void setHba1c4(int hba1c4) {
        this.hba1c4 = hba1c4;
    }

    public int getHba1c3() {
        return hba1c3;
    }

    public void setHba1c3(int hba1c3) {
        this.hba1c3 = hba1c3;
    }

    public int getHba1c2() {
        return hba1c2;
    }

    public void setHba1c2(int hba1c2) {
        this.hba1c2 = hba1c2;
    }

    public int getHba1c1() {
        return hba1c1;
    }

    public void setHba1c1(int hba1c1) {
        this.hba1c1 = hba1c1;
    }

    public int getCreatinina() {
        return creatinina;
    }

    public void setCreatinina(int creatinina) {
        this.creatinina = creatinina;
    }

    public int getMicroalbuminuria() {
        return microalbuminuria;
    }

    public void setMicroalbuminuria(int microalbuminuria) {
        this.microalbuminuria = microalbuminuria;
    }

    public int getPotasioPlasmatico() {
        return potasioPlasmatico;
    }

    public void setPotasioPlasmatico(int potasioPlasmatico) {
        this.potasioPlasmatico = potasioPlasmatico;
    }

    public int getEcg() {
        return ecg;
    }

    public void setEcg(int ecg) {
        this.ecg = ecg;
    }

    public int getComplicacion() {
        return complicacion;
    }

    public void setComplicacion(int complicacion) {
        this.complicacion = complicacion;
    }

    public int getRetinopatiaDiabetica() {
        return retinopatiaDiabetica;
    }

    public void setRetinopatiaDiabetica(int retinopatiaDiabetica) {
        this.retinopatiaDiabetica = retinopatiaDiabetica;
    }

    public int getInfarto() {
        return infarto;
    }

    public void setInfarto(int infarto) {
        this.infarto = infarto;
    }

    public int getAccidenteVascular() {
        return accidenteVascular;
    }

    public void setAccidenteVascular(int accidenteVascular) {
        this.accidenteVascular = accidenteVascular;
    }

    public int getCegueraPost() {
        return cegueraPost;
    }

    public void setCegueraPost(int cegueraPost) {
        this.cegueraPost = cegueraPost;
    }

    public int getHipertrofia() {
        return hipertrofia;
    }

    public void setHipertrofia(int hipertrofia) {
        this.hipertrofia = hipertrofia;
    }

    public int getNefropatia() {
        return nefropatia;
    }

    public void setNefropatia(int nefropatia) {
        this.nefropatia = nefropatia;
    }

    public int getInsuficienciaRenal() {
        return insuficienciaRenal;
    }

    public void setInsuficienciaRenal(int insuficienciaRenal) {
        this.insuficienciaRenal = insuficienciaRenal;
    }

    public int getPieDiabeticoEvaluacion() {
        return pieDiabeticoEvaluacion;
    }

    public void setPieDiabeticoEvaluacion(int pieDiabeticoEvaluacion) {
        this.pieDiabeticoEvaluacion = pieDiabeticoEvaluacion;
    }

    public int getPieDiabeticoUlcera() {
        return pieDiabeticoUlcera;
    }

    public void setPieDiabeticoUlcera(int pieDiabeticoUlcera) {
        this.pieDiabeticoUlcera = pieDiabeticoUlcera;
    }

    public int getPieDiabeticoHerida() {
        return pieDiabeticoHerida;
    }

    public void setPieDiabeticoHerida(int pieDiabeticoHerida) {
        this.pieDiabeticoHerida = pieDiabeticoHerida;
    }

    public int getAmputacionDiabetica() {
        return amputacionDiabetica;
    }

    public void setAmputacionDiabetica(int amputacionDiabetica) {
        this.amputacionDiabetica = amputacionDiabetica;
    }

    
    
    /**
     * Creates a new instance of CensoCCVnoREM
     */
    public CensoCCVnoREM() {
    this.fallecidos=0;
    this.pbc=0;
    this.perfilLipidico=0;
    this.fondoOjo=0;
    this.atencionPodologica=0;
    this.hba1c4=0;
    this.hba1c3=0;
    this.hba1c2=0;
    this.hba1c1=0;
    this.creatinina=0;
    this.microalbuminuria=0;
    this.potasioPlasmatico=0;
    this.ecg=0;
    this.complicacion=0;
    this.retinopatiaDiabetica=0;
    this.infarto=0;
    this.accidenteVascular=0;
    this.cegueraPost=0;
    this.hipertrofia=0;
    this.nefropatia=0;
    this.insuficienciaRenal=0;
    this.pieDiabeticoEvaluacion=0;
    this.pieDiabeticoUlcera=0;
    this.pieDiabeticoHerida=0;
    this.amputacionDiabetica=0;
    this.preDiabeticos=0;
        
    }
    
    
}
