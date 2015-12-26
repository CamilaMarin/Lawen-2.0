/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author daniel
 */
@Named(value = "dominiosController" )
@ApplicationScoped
public class dominiosController {
    private List<String> genero;
    private List<String> sector;
    private List<String> prevision;
    private List<String> estadosExamen;
    private List<String> ejecucionExamen;
    private List<String> riesgoCCV;
    private Integer edad;
    private float imc;
    private String diagnosticoNutricional;
    //se añade el estado del paciente
    private List <String> estado_paciente;
    private List <String> diagnosticoLista;
    private List <String> higiene;
    
    private List <String> estadoNutricional;
    private List <String> antiguedad;
    private List <String> riesgo;
    private List <String> clasificacionefam;
    private List <String> clasificacionbarthel;
    private List <String> clasificacionyesavage;
    private List <String> clasificacionpfeffer;
    private List <String> clasificacionfolstein;
    private List <String> profesionales;
    // (NORMAL) (DETERIORO COGNITIVO) (SOSPECHA DE DEMENCIA)
    /// Carecteristicas de la vivienda
    // Solida - Ligera
    private List <String> caracteristicas_vivienda;
     // Adecuado - Contaminado
    private List <String> caracteristicas_ambiente;
    // (SE SOLICITA) (PENDIENTE) (NEGATIVO) (POSITIVO)
    private List <String> empaDom;
    private List <String> tipoNutriAtencion;
    private List <String> booleano;
    private List <String> enfermedadRenalCronica;
    private List <String> riesgoUlceras;
    private List <String> curacionPieDM;
    private List <String> ingresoReingreso;
    private List <String> pertenece_al_programa_mas;
    private List <String> prox_profesional;
    
    private List <String> alimentacionRecibe;
    private List <String> examinadorNino;
    
    private List <String> tipoControlNino;
    private List <String> presionArterialNino;
    private List <String> scoreIRANino;
    private List <String> visitaDomiciliariaNino;
    private List <String> nadieEsPerfectoNino;
    private List <String> materialesEstimulacionNino;
    

    /*
    Init para intanciar valores de las listas
    */
    @PostConstruct
    public void init() {
        
        tipoControlNino= new ArrayList<>(2);
        tipoControlNino.add(0,"Control");
        tipoControlNino.add(1,"Reevaluación");
        
        presionArterialNino= new ArrayList<>(4);
        presionArterialNino.add(0,"Normal");
        presionArterialNino.add(1,"Pre-Hipertensión");
        presionArterialNino.add(2,"Etapa 1");
        presionArterialNino.add(3,"Etapa 2");
        
        scoreIRANino= new ArrayList<>(3);
        scoreIRANino.add(0,"Leve");
        scoreIRANino.add(1,"Moderado");
        scoreIRANino.add(2,"Grave");
        
        visitaDomiciliariaNino= new ArrayList<>(2);
        visitaDomiciliariaNino.add(0,"Si");
        visitaDomiciliariaNino.add(1,"No");
        
        nadieEsPerfectoNino= new ArrayList<>(2);
        nadieEsPerfectoNino.add(0,"Si");
        nadieEsPerfectoNino.add(1,"No");
        
        materialesEstimulacionNino= new ArrayList<>(2);
        materialesEstimulacionNino.add(0,"Si");
        materialesEstimulacionNino.add(1,"No");
        
        alimentacionRecibe= new ArrayList<>(6);
        alimentacionRecibe.add(0,"L.M.E");
        alimentacionRecibe.add(1,"L.M.Otro");
        alimentacionRecibe.add(2,"L.M. L.A.");
        alimentacionRecibe.add(3,"L.M. L.A. Otros.");
        alimentacionRecibe.add(4,"L.A.");
        alimentacionRecibe.add(5,"L.A. Otros");
        
        examinadorNino= new ArrayList<>(6);
        examinadorNino.add(0,"Matrona");
        examinadorNino.add(1,"Nutricionista");
        examinadorNino.add(2,"Medico");
        examinadorNino.add(3,"Enfermera");
        examinadorNino.add(4,"Educadora de Parvulo");
        examinadorNino.add(5,"Tens");        
              
        genero = new ArrayList<>(2);
        genero.add(0,"Masculino");
        genero.add(1,"Femenino");
        
        sector = new ArrayList<>(4);
        sector.add(0, "Naranjo");
        sector.add(1, "Rojo");
        sector.add(2, "Azul");
        sector.add(3, "Verde");
        
        prox_profesional= new ArrayList<>(3);
        prox_profesional.add(0,"Medico");
        prox_profesional.add(1,"Enfermera");
        prox_profesional.add(2,"Nutricionista");
        
        prevision = new ArrayList<>(5);
        prevision.add(0, "Fonasa A");
        prevision.add(1, "Fonasa B");
        prevision.add(2, "Fonasa C");
        prevision.add(3, "Fonasa D");
        prevision.add(4, "Otros");
        
        estadosExamen = new ArrayList<>(4);
        estadosExamen.add(0, "VACIO");
        estadosExamen.add(1, "SE SOLICITA");
        estadosExamen.add(2, "PENDIENTE");
        estadosExamen.add(3, "RESULTADO");
        
        ejecucionExamen = new ArrayList<>(3);
        ejecucionExamen.add(0, "VACIO");
        ejecucionExamen.add(1, "NORMAL");
        ejecucionExamen.add(2, "ALTERADO");
       
        riesgoCCV = new ArrayList<>(3);
        riesgoCCV.add(0, "BAJO");
        riesgoCCV.add(1, "MODERADO");
        riesgoCCV.add(2, "ALTO");
        riesgoCCV.add(3,"NO SE SABE");
        diagnosticoLista = new ArrayList<>(7);
        diagnosticoLista.add(0, "E");
        diagnosticoLista.add(1, "BP");
        diagnosticoLista.add(2, "N");
        diagnosticoLista.add(3, "SP");
        diagnosticoLista.add(4, "OB");
        diagnosticoLista.add(5, "OBI");
        diagnosticoLista.add(6, "OBII");
        diagnosticoLista.add(7, "OBIII");
        
        higiene = new ArrayList<>(3);
        higiene.add(0, "Mala");
        higiene.add(1, "Regular");
        higiene.add(2, "Buena");
        
        estadoNutricional =  new ArrayList<>(5);
        estadoNutricional.add(0, "No se aplica");
        estadoNutricional.add(1, "Bajo Peso");
        estadoNutricional.add(2, "Normal");
        estadoNutricional.add(3, "Sobrepeso");
        estadoNutricional.add(4, "Obeso");
        
        antiguedad = new ArrayList<>(2);
        antiguedad.add(0,"Nuevo");
        antiguedad.add(1,"Antiguo");
        
        riesgo = new ArrayList<>(4);
        riesgo.add(0,"No se aplica");
        riesgo.add(1,"Normal");
        riesgo.add(2,"Riesgo leve");
        riesgo.add(3,"Alto riesgo");
        clasificacionefam = new ArrayList<>(4);
        clasificacionefam.add(0,"No se aplica");
        clasificacionefam.add(1,"Autovalente sin riesgo");
        clasificacionefam.add(2,"Autovalente con riesgo");
        clasificacionefam.add(3,"En riesgo de dependencia");
        
        clasificacionbarthel = new ArrayList<>(6);
        clasificacionbarthel.add(0,"No se aplica");
        clasificacionbarthel.add(1,"Total");
        clasificacionbarthel.add(2,"Grave");
        clasificacionbarthel.add(3,"Moderado");
        clasificacionbarthel.add(4,"Leve");
        clasificacionbarthel.add(5,"Independiente");
        
        clasificacionyesavage = new ArrayList<>(4);
        clasificacionyesavage.add(0,"No se aplica");
        clasificacionyesavage.add(1,"Normal");
        clasificacionyesavage.add(2,"Depresion leve");
        clasificacionyesavage.add(3,"Depresion establecida");
        
        clasificacionpfeffer = new ArrayList<>(3);
        clasificacionpfeffer.add(0,"No se aplica");
        clasificacionpfeffer.add(1,"Normal");
        clasificacionpfeffer.add(2,"Sospecha deterioro cognitivo");
        
        clasificacionfolstein = new ArrayList<>(4);
        clasificacionfolstein.add(0,"No se aplica");
        clasificacionfolstein.add(1,"Normal");
        clasificacionfolstein.add(2,"Deterioro cognitivo");
        clasificacionfolstein.add(3,"Sospecha de demencia");
        profesionales = new ArrayList<>(5);
        profesionales.add("ADMIN");
        profesionales.add("MÉDICO");
        profesionales.add("NUTRICIONISTA");
        profesionales.add("ENFERMERO(A)");
        profesionales.add("ADMINISTRATIVO");
        
        caracteristicas_vivienda = new ArrayList<>(2);
        caracteristicas_vivienda.add(0,"Solida");
        caracteristicas_vivienda.add(1,"Ligera");
        
        caracteristicas_ambiente = new ArrayList<>(2);
        caracteristicas_ambiente.add(0,"Adecuado");
        caracteristicas_ambiente.add(1,"Contaminado");
        
        empaDom = new ArrayList<>(4);
        empaDom.add(0, "SE SOLICITA");
        empaDom.add(1, "PENDIENTE");
        empaDom.add(2, "NEGATIVO");
        empaDom.add(3, "POSITIVO");
        
        tipoNutriAtencion = new ArrayList<>(2);
        tipoNutriAtencion.add(0,"Ingreso");
        tipoNutriAtencion.add(1,"Control");
        
        estado_paciente= new ArrayList<>(4);
        estado_paciente.add(0,"Activo");
        estado_paciente.add(1,"Pasivo por cambio de prevision ");
        estado_paciente.add(2,"Pasivo por traslado");
        estado_paciente.add(3,"Pasivo por fallecimiento");
        booleano= new ArrayList<>(2);
        booleano.add(0,"Si");
        booleano.add(1,"No");
        enfermedadRenalCronica= new ArrayList<>(7);
        enfermedadRenalCronica.add(0,"NO SE EVALUA");
        enfermedadRenalCronica.add(1,"SIN ENFERMEDAD RENAL");
        enfermedadRenalCronica.add(2,"ETAPA G1");
        enfermedadRenalCronica.add(3,"ETAPA G2");
        enfermedadRenalCronica.add(4,"ETAPA G3a");
        enfermedadRenalCronica.add(4,"ETAPA G3b");
        enfermedadRenalCronica.add(5,"ETAPA G4");
        enfermedadRenalCronica.add(6,"ETAPA G5");
        riesgoUlceras= new ArrayList<>(5);
        riesgoUlceras.add(0,"No se evalúa");
        riesgoUlceras.add(1,"Riesgo bajo");
        riesgoUlceras.add(2,"Riesgo moderado");
        riesgoUlceras.add(3,"Riesgo alto");
        riesgoUlceras.add(4,"Riesgo maximo");
        curacionPieDM= new ArrayList<>(3);
        curacionPieDM.add(0,"No se evalúa");
        curacionPieDM.add(1,"Curacion Convencional");
        curacionPieDM.add(2,"Curacion Avanzada");
        
        ingresoReingreso= new ArrayList<>(2);
        ingresoReingreso.add(0,"Ingreso");
        ingresoReingreso.add(1,"Reingreso");
        
        pertenece_al_programa_mas= new ArrayList<>(3);
        pertenece_al_programa_mas.add(0,"No se evalúa");
        pertenece_al_programa_mas.add(1,"No");
        pertenece_al_programa_mas.add(2,"Si");
        


        
    }

    public List<String> getIngresoReingreso() {
        return ingresoReingreso;
    }

    public void setIngresoReingreso(List<String> ingresoReingreso) {
        this.ingresoReingreso = ingresoReingreso;
    }

    
    public List<String> getCuracionPieDM() {
        return curacionPieDM;
    }

    public void setCuracionPieDM(List<String> curacionPieDM) {
        this.curacionPieDM = curacionPieDM;
    }

    public List<String> getAlimentacionRecibe() {
        return alimentacionRecibe;
    }

    public void setAlimentacionRecibe(List<String> alimentacionRecibe) {
        this.alimentacionRecibe = alimentacionRecibe;
    }

    public List<String> getExaminadorNino() {
        return examinadorNino;
    }

    public void setExaminadorNino(List<String> examinadorNino) {
        this.examinadorNino = examinadorNino;
    }

    
    
    
    public List<String> getProx_profesional() {
        return prox_profesional;
    }

    public void setProx_profesional(List<String> prox_profesional) {
        this.prox_profesional = prox_profesional;
    }
    
    public List<String> getRiesgoUlceras() {
        return riesgoUlceras;
    }

    public void setRiesgoUlceras(List<String> riesgoUlceras) {
        this.riesgoUlceras = riesgoUlceras;
    }

    
    
    public List<String> getBooleano() {
        return booleano;
    }

    public void setBooleano(List<String> booleano) {
        this.booleano = booleano;
    }

    public List<String> getEnfermedadRenalCronica() {
        return enfermedadRenalCronica;
    }

    public void setEnfermedadRenalCronica(List<String> enfermedadRenalCronica) {
        this.enfermedadRenalCronica = enfermedadRenalCronica;
    }
    
    
    
    
    public List<String> getEstado_paciente() {
        return estado_paciente;
    }

    public void setEstado_paciente(List<String> estado_paciente) {
        this.estado_paciente = estado_paciente;
    }
    
    

    public List<String> getProfesionales() {
        return profesionales;
    }

    public void setProfesionales(List<String> profesionales) {
        this.profesionales = profesionales;
    }

    public List<String> getTipoNutriAtencion() {
        return tipoNutriAtencion;
    }

    public void setTipoNutriAtencion(List<String> tipoNutriAtencion) {
        this.tipoNutriAtencion = tipoNutriAtencion;
    }

    
    
    public List<String> getHigiene() {
        return higiene;
    }

    public void setHigiene(List<String> higiene) {
        this.higiene = higiene;
    }

    
    public Integer getEdad() {
        return edad;
    }

    public List<String> getDiagnosticoLista() {
        return diagnosticoLista;
    }

    public void setDiagnosticoLista(List<String> diagnosticoLista) {
        this.diagnosticoLista = diagnosticoLista;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public String getDiagnosticoNutricional() {
        return diagnosticoNutricional;
    }

    public void setDiagnosticoNutricional(String diagnosticoNutricional) {
        this.diagnosticoNutricional = diagnosticoNutricional;
    }
    
    /*
    Funcion para el IMC
    */
    public void calculaIMC(){
        if(edad < 65 ){
            if(imc < 18.5){
                diagnosticoNutricional = "BP";
            }
            else if( 18.5 <= imc || imc < 25){
                diagnosticoNutricional = "N";
            }
            else if( 25 <= imc  || imc < 30){
                diagnosticoNutricional = "SP";
            }
            else if( 30 <= imc  || imc < 35){
                diagnosticoNutricional = "OBI";
            }
            else if( 35 <= imc  || imc < 40){
                diagnosticoNutricional = "OBII";
            }
            else if( 40 <= imc){
                diagnosticoNutricional = "OBIII";
            }
        }
        else if(edad >= 65){
            if(imc <= 23){
                diagnosticoNutricional = "E";
            }
            else if( 23 < imc || imc < 28){
                diagnosticoNutricional = "N";
            }
            else if( 28 <= imc  || imc < 32){
                diagnosticoNutricional = "SP";
            }
            else if( 32 <= imc){
                diagnosticoNutricional = "OB";
            }
            
        } 
    }

    public List<String> getTipoControlNino() {
        return tipoControlNino;
    }

    public void setTipoControlNino(List<String> tipoControlNino) {
        this.tipoControlNino = tipoControlNino;
    }

    public List<String> getPresionArterialNino() {
        return presionArterialNino;
    }

    public void setPresionArterialNino(List<String> presionArterialNino) {
        this.presionArterialNino = presionArterialNino;
    }

    public List<String> getScoreIRANino() {
        return scoreIRANino;
    }

    public void setScoreIRANino(List<String> scoreIRANino) {
        this.scoreIRANino = scoreIRANino;
    }

    public List<String> getVisitaDomiciliariaNino() {
        return visitaDomiciliariaNino;
    }

    public void setVisitaDomiciliariaNino(List<String> visitaDomiciliariaNino) {
        this.visitaDomiciliariaNino = visitaDomiciliariaNino;
    }

    public List<String> getNadieEsPerfectoNino() {
        return nadieEsPerfectoNino;
    }

    public void setNadieEsPerfectoNino(List<String> nadieEsPerfectoNino) {
        this.nadieEsPerfectoNino = nadieEsPerfectoNino;
    }

    public List<String> getMaterialesEstimulacionNino() {
        return materialesEstimulacionNino;
    }

    public void setMaterialesEstimulacionNino(List<String> materialesEstimulacionNino) {
        this.materialesEstimulacionNino = materialesEstimulacionNino;
    }
    
    

    public List<String> getPertenece_al_programa_mas() {
        return pertenece_al_programa_mas;
    }

    public void setPertenece_al_programa_mas(List<String> pertenece_al_programa_mas) {
        this.pertenece_al_programa_mas = pertenece_al_programa_mas;
    }
    
    
    public List<String> getGenero() {
        return genero;
    }
    public List<String> getSector() {
        return sector;
    } 
    public List<String> getPrevision() {
        return prevision;
    }

    public List<String> getEstadosExamen() {
        return estadosExamen;
    }

    public List<String> getEjecucionExamen() {
        return ejecucionExamen;
    }

    public List<String> getRiesgoCCV() {
        return riesgoCCV;
    }

    public List<String> getEstadoNutricional() {
        return estadoNutricional;
    }

    public void setEstadoNutricional(List<String> estadoNutricional) {
        this.estadoNutricional = estadoNutricional;
    }

    public List<String> getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(List<String> antiguedad) {
        this.antiguedad = antiguedad;
    }

    public List<String> getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(List<String> riesgo) {
        this.riesgo = riesgo;
    }

    public List<String> getClasificacionefam() {
        return clasificacionefam;
    }

    public void setClasificacionefam(List<String> clasificacionefam) {
        this.clasificacionefam = clasificacionefam;
    }

    public List<String> getClasificacionbarthel() {
        return clasificacionbarthel;
    }

    public void setClasificacionbarthel(List<String> clasificacionbarthel) {
        this.clasificacionbarthel = clasificacionbarthel;
    }

    public List<String> getClasificacionyesavage() {
        return clasificacionyesavage;
    }

    public void setClasificacionyesavage(List<String> clasificacionyesavage) {
        this.clasificacionyesavage = clasificacionyesavage;
    }

    public List<String> getClasificacionpfeffer() {
        return clasificacionpfeffer;
    }

    public void setClasificacionpfeffer(List<String> clasificacionpfeffer) {
        this.clasificacionpfeffer = clasificacionpfeffer;
    }

    public List<String> getClasificacionfolstein() {
        return clasificacionfolstein;
    }

    public void setClasificacionfolstein(List<String> clasificacionfolstein) {
        this.clasificacionfolstein = clasificacionfolstein;
    }

    public List<String> getCaracteristicas_vivienda() {
        return caracteristicas_vivienda;
    }

    public void setCaracteristicas_vivienda(List<String> caracteristicas_vivienda) {
        this.caracteristicas_vivienda = caracteristicas_vivienda;
    }

    public List<String> getCaracteristicas_ambiente() {
        return caracteristicas_ambiente;
    }

    public void setCaracteristicas_ambiente(List<String> caracteristicas_ambiente) {
        this.caracteristicas_ambiente = caracteristicas_ambiente;
    }

    public List<String> getEmpaDom() {
        return empaDom;
    }

    public void setEmpaDom(List<String> empaDom) {
        this.empaDom = empaDom;
    }
    
    
    
    
}
