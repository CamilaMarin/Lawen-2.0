/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.pediatria.censo;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import sessionbeans.pediatria.CartolaControlesNinoFacadeLocal;
import sessionbeans.pediatria.PacienteNinoFacadeLocal;
import entities.pediatria.PacienteNino;
import entities.pediatria.CartolaControlesNino;
import entities.pediatria.ControlNino;
import sessionbeans.pediatria.ControlNinoFacadeLocal;

/**
 *
 * @author Francisco Avello
 */
@Named(value = "consultasCensoPediatria")
@SessionScoped
public class ConsultasCensoPediatria implements Serializable {

    private List<CensoPediatriaSeccionA> A_elementosPediatria = new ArrayList<>();
    private List<CensoPediatriaSeccionE> E_elementosPediatria = new ArrayList<>();
    private List<CensoPediatriaSeccionD> D_elementosPediatria = new ArrayList<>();
    private List<CensoPediatriaSeccionG> G_elementosPediatria = new ArrayList<>();
     
    @EJB
    private PacienteNinoFacadeLocal ejbPacienteNino;
    @EJB
    private CartolaControlesNinoFacadeLocal ejbCartolaNino;
    @EJB
    private ControlNinoFacadeLocal ejbControlNino;
    
    public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Carga completada", "Carga completada"));
    }

    public void onCancel() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Progress Cancelled", "Progress Cancelled"));
    }
    
    public void init() {
        A_elementosPediatria = censoPediatriaSeccionA();
        E_elementosPediatria = censoPediatriaSeccionE();
        D_elementosPediatria = censoPediatriaSeccionD();
        G_elementosPediatria = censoPediatriaSeccionG();
    }

    public ControlNinoFacadeLocal getEjbControlNino() {
        return ejbControlNino;
    }

    public void setEjbControlNino(ControlNinoFacadeLocal ejbControlNino) {
        this.ejbControlNino = ejbControlNino;
    }

    public List<CensoPediatriaSeccionD> getD_elementosPediatria() {
        return D_elementosPediatria;
    }

    public void setD_elementosPediatria(List<CensoPediatriaSeccionD> D_elementosPediatria) {
        this.D_elementosPediatria = D_elementosPediatria;
    }    

    public List<CensoPediatriaSeccionG> getG_elementosPediatria() {
        return G_elementosPediatria;
    }

    public void setG_elementosPediatria(List<CensoPediatriaSeccionG> G_elementosPediatria) {
        this.G_elementosPediatria = G_elementosPediatria;
    }  
    
    public List<CensoPediatriaSeccionE> getE_elementosPediatria() {
        return E_elementosPediatria;
    }

    public void setE_elementosPediatria(List<CensoPediatriaSeccionE> E_elementosPediatria) {
        this.E_elementosPediatria = E_elementosPediatria;
    }    
        
    public List<CensoPediatriaSeccionA> getA_elementosPediatria() {
        return A_elementosPediatria;
    }

    public void setA_elementosPediatria(List<CensoPediatriaSeccionA> A_elementosPediatria) {
        this.A_elementosPediatria = A_elementosPediatria;
    }

    public PacienteNinoFacadeLocal getEjbPacienteNino() {
        return ejbPacienteNino;
    }

    public void setEjbPacienteNino(PacienteNinoFacadeLocal ejbPacienteNino) {
        this.ejbPacienteNino = ejbPacienteNino;
    }

    public CartolaControlesNinoFacadeLocal getEjbCartolaNino() {
        return ejbCartolaNino;
    }

    public void setEjbCartolaNino(CartolaControlesNinoFacadeLocal ejbCartolaNino) {
        this.ejbCartolaNino = ejbCartolaNino;
    }
    
    public List<CensoPediatriaSeccionA> censoPediatriaSeccionA() {

        CensoPediatriaSeccionA totalAmbosSexos = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_menor1 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_menor1 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_1 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_1 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_2 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_2 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_3 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_3 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_4 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_4 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_5 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_5 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_6 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_6 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_7a11 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_7a11 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_12a17 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_12a17 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_18a23 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_18a23 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_24a35 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_24a35 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_36a41 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_36a41 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_42a47 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_42a47 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_48a59 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_48a59 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_60a71 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_60a71 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_6a9 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_6a9 = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_pueblos = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_pueblos = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalhombres_inmigrantes = new CensoPediatriaSeccionA();
        CensoPediatriaSeccionA totalmujeres_inmigrantes = new CensoPediatriaSeccionA();

        List<PacienteNino> pacientes_habilitados = ejbPacienteNino.findbyPacienteNinoActivo();
        List<CartolaControlesNino> cped;
        List<ControlNino> controlesPaciente = null;
        List<ControlNino> controlUltimo;
        boolean resultados[];       
        for (PacienteNino pacientes : pacientes_habilitados) {            
            boolean fue_censado = false;
            int edad;
            boolean registra_unaatencion = false;

            cped = ejbCartolaNino.findByPacienteNino(pacientes);//obtengo todas las cartolas por  pacientes
            
            if (cped.size() > 0) {
                registra_unaatencion = true;
                controlesPaciente = ejbControlNino.findbyCartola(cped.get(0).getId());
            }
                      
            controlUltimo = ejbControlNino.findLastControl(controlesPaciente);            
                     
            if (controlUltimo.size() > 0) {//si tiene un elemento censable
                
                edad = controlUltimo.get(0).getEdadControl();
                
                totalAmbosSexos.setNumerodeNinosPediatria(totalAmbosSexos.getNumerodeNinosPediatria()+1);                
                if (pacientes.getGenero_nino().equals("Masculino")) {                    
                        totalhombres.setNumerodeNinosPediatria(totalhombres.getNumerodeNinosPediatria()+1);
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setNumerodeNinosPediatria(totalhombres_pueblos.getNumerodeNinosPediatria()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setNumerodeNinosPediatria(totalhombres_inmigrantes.getNumerodeNinosPediatria()+1);
                        }
                        if (edad <1) {
                            totalhombres_menor1.setNumerodeNinosPediatria(totalhombres_menor1.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setNumerodeNinosPediatria(totalhombres_1.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setNumerodeNinosPediatria(totalhombres_2.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setNumerodeNinosPediatria(totalhombres_3.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setNumerodeNinosPediatria(totalhombres_4.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setNumerodeNinosPediatria(totalhombres_5.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setNumerodeNinosPediatria(totalhombres_6.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setNumerodeNinosPediatria(totalhombres_7a11.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setNumerodeNinosPediatria(totalhombres_12a17.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setNumerodeNinosPediatria(totalhombres_18a23.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setNumerodeNinosPediatria(totalhombres_24a35.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setNumerodeNinosPediatria(totalhombres_36a41.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setNumerodeNinosPediatria(totalhombres_42a47.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setNumerodeNinosPediatria(totalhombres_48a59.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setNumerodeNinosPediatria(totalmujeres_60a71.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setNumerodeNinosPediatria(totalhombres_6a9.getNumerodeNinosPediatria()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setNumerodeNinosPediatria(totalmujeres.getNumerodeNinosPediatria()+1);
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setNumerodeNinosPediatria(totalmujeres_pueblos.getNumerodeNinosPediatria()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setNumerodeNinosPediatria(totalmujeres_inmigrantes.getNumerodeNinosPediatria()+1);
                        }
                        if (edad <1) {
                            totalmujeres_menor1.setNumerodeNinosPediatria(totalmujeres_menor1.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setNumerodeNinosPediatria(totalmujeres_1.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setNumerodeNinosPediatria(totalmujeres_2.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setNumerodeNinosPediatria(totalmujeres_3.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setNumerodeNinosPediatria(totalmujeres_4.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setNumerodeNinosPediatria(totalmujeres_5.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setNumerodeNinosPediatria(totalmujeres_6.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setNumerodeNinosPediatria(totalmujeres_7a11.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setNumerodeNinosPediatria(totalmujeres_12a17.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setNumerodeNinosPediatria(totalmujeres_18a23.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setNumerodeNinosPediatria(totalmujeres_24a35.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setNumerodeNinosPediatria(totalmujeres_36a41.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setNumerodeNinosPediatria(totalmujeres_42a47.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setNumerodeNinosPediatria(totalmujeres_48a59.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setNumerodeNinosPediatria(totalmujeres_60a71.getNumerodeNinosPediatria()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setNumerodeNinosPediatria(totalmujeres_6a9.getNumerodeNinosPediatria()+1);
                        }
                    }                              
                
                if (controlUltimo.get(0).getPesoEdadControl().equals("-1 DE")) {//DOPA
                    //siempre actualizar variable fue censado:                    
                    fue_censado = true;
                    totalAmbosSexos.setPesoEdadMenosUno(totalAmbosSexos.getPesoEdadMenosUno()+1);
                    totalAmbosSexos.setPesoEdadMenosTotal(totalAmbosSexos.getPesoEdadMenosTotal()+1);                    
                    if (pacientes.getGenero_nino().equals("Masculino")) {
                        totalhombres.setPesoEdadMenosUno(totalhombres.getPesoEdadMenosUno()+1);
                        totalhombres.setPesoEdadMenosTotal(totalhombres.getPesoEdadMenosTotal()+1);
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setPesoEdadMenosUno(totalhombres_pueblos.getPesoEdadMenosUno()+1);
                            totalhombres_pueblos.setPesoEdadMenosTotal(totalhombres_pueblos.getPesoEdadMenosTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setPesoEdadMenosUno(totalhombres_inmigrantes.getPesoEdadMenosUno()+1);
                            totalhombres_inmigrantes.setPesoEdadMenosTotal(totalhombres_inmigrantes.getPesoEdadMenosTotal()+1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalhombres_menor1.setPesoEdadMenosUno(totalhombres_menor1.getPesoEdadMenosUno()+1);
                            totalhombres_menor1.setPesoEdadMenosTotal(totalhombres_menor1.getPesoEdadMenosTotal()+1);                            
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setPesoEdadMenosUno(totalhombres_1.getPesoEdadMenosUno()+1);
                            totalhombres_1.setPesoEdadMenosTotal(totalhombres_1.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setPesoEdadMenosUno(totalhombres_2.getPesoEdadMenosUno()+1);
                            totalhombres_2.setPesoEdadMenosTotal(totalhombres_2.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setPesoEdadMenosUno(totalhombres_3.getPesoEdadMenosUno()+1);
                            totalhombres_3.setPesoEdadMenosTotal(totalhombres_3.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setPesoEdadMenosUno(totalhombres_4.getPesoEdadMenosUno()+1);
                            totalhombres_4.setPesoEdadMenosTotal(totalhombres_4.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setPesoEdadMenosUno(totalhombres_5.getPesoEdadMenosUno()+1);
                            totalhombres_5.setPesoEdadMenosTotal(totalhombres_5.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setPesoEdadMenosUno(totalhombres_6.getPesoEdadMenosUno()+1);
                            totalhombres_6.setPesoEdadMenosTotal(totalhombres_6.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setPesoEdadMenosUno(totalhombres_7a11.getPesoEdadMenosUno()+1);
                            totalhombres_7a11.setPesoEdadMenosTotal(totalhombres_7a11.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setPesoEdadMenosUno(totalhombres_12a17.getPesoEdadMenosUno()+1);
                            totalhombres_12a17.setPesoEdadMenosTotal(totalhombres_12a17.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setPesoEdadMenosUno(totalhombres_18a23.getPesoEdadMenosUno()+1);
                            totalhombres_18a23.setPesoEdadMenosTotal(totalhombres_18a23.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setPesoEdadMenosUno(totalhombres_24a35.getPesoEdadMenosUno()+1);
                            totalhombres_24a35.setPesoEdadMenosTotal(totalhombres_24a35.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setPesoEdadMenosUno(totalhombres_36a41.getPesoEdadMenosUno()+1);
                            totalhombres_36a41.setPesoEdadMenosTotal(totalhombres_36a41.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setPesoEdadMenosUno(totalhombres_42a47.getPesoEdadMenosUno()+1);
                            totalhombres_42a47.setPesoEdadMenosTotal(totalhombres_42a47.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setPesoEdadMenosUno(totalhombres_48a59.getPesoEdadMenosUno()+1); 
                            totalhombres_48a59.setPesoEdadMenosTotal(totalhombres_48a59.getPesoEdadMenosTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalhombres_60a71.setPesoEdadMenosUno(totalmujeres_60a71.getPesoEdadMenosUno()+1);
                            totalmujeres_60a71.setPesoEdadMenosTotal(totalmujeres_60a71.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setPesoEdadMenosUno(totalhombres_6a9.getPesoEdadMenosUno()+1);
                            totalhombres_6a9.setPesoEdadMenosTotal(totalhombres_6a9.getPesoEdadMenosTotal()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPesoEdadMenosUno(totalmujeres.getPesoEdadMenosUno()+1);
                        totalmujeres.setPesoEdadMenosTotal(totalmujeres.getPesoEdadMenosTotal()+1);
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setPesoEdadMenosUno(totalmujeres_pueblos.getPesoEdadMenosUno()+1);
                            totalmujeres_pueblos.setPesoEdadMenosTotal(totalmujeres_pueblos.getPesoEdadMenosTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setPesoEdadMenosUno(totalmujeres_inmigrantes.getPesoEdadMenosUno()+1);
                            totalmujeres_inmigrantes.setPesoEdadMenosTotal(totalmujeres_inmigrantes.getPesoEdadMenosTotal()+1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalmujeres_menor1.setPesoEdadMenosUno(totalmujeres_menor1.getPesoEdadMenosUno()+1);
                            totalmujeres_menor1.setPesoEdadMenosTotal(totalmujeres_menor1.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setPesoEdadMenosUno(totalmujeres_1.getPesoEdadMenosUno()+1);
                            totalmujeres_1.setPesoEdadMenosTotal(totalmujeres_1.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setPesoEdadMenosUno(totalmujeres_2.getPesoEdadMenosUno()+1);
                            totalmujeres_2.setPesoEdadMenosTotal(totalmujeres_2.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setPesoEdadMenosUno(totalmujeres_3.getPesoEdadMenosUno()+1);
                            totalmujeres_3.setPesoEdadMenosTotal(totalmujeres_3.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setPesoEdadMenosUno(totalmujeres_4.getPesoEdadMenosUno()+1);
                            totalmujeres_4.setPesoEdadMenosTotal(totalmujeres_4.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setPesoEdadMenosUno(totalmujeres_5.getPesoEdadMenosUno()+1);
                            totalmujeres_5.setPesoEdadMenosTotal(totalmujeres_5.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setPesoEdadMenosUno(totalmujeres_6.getPesoEdadMenosUno()+1);
                            totalmujeres_6.setPesoEdadMenosTotal(totalmujeres_6.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setPesoEdadMenosUno(totalmujeres_7a11.getPesoEdadMenosUno()+1);
                            totalmujeres_7a11.setPesoEdadMenosTotal(totalmujeres_7a11.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setPesoEdadMenosUno(totalmujeres_12a17.getPesoEdadMenosUno()+1);
                            totalmujeres_12a17.setPesoEdadMenosTotal(totalmujeres_12a17.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setPesoEdadMenosUno(totalmujeres_18a23.getPesoEdadMenosUno()+1);
                            totalmujeres_18a23.setPesoEdadMenosTotal(totalmujeres_18a23.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setPesoEdadMenosUno(totalmujeres_24a35.getPesoEdadMenosUno()+1);
                            totalmujeres_24a35.setPesoEdadMenosTotal(totalmujeres_24a35.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setPesoEdadMenosUno(totalmujeres_36a41.getPesoEdadMenosUno()+1);
                            totalmujeres_36a41.setPesoEdadMenosTotal(totalmujeres_36a41.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setPesoEdadMenosUno(totalmujeres_42a47.getPesoEdadMenosUno()+1);
                            totalmujeres_42a47.setPesoEdadMenosTotal(totalmujeres_42a47.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setPesoEdadMenosUno(totalmujeres_48a59.getPesoEdadMenosUno()+1);
                            totalmujeres_48a59.setPesoEdadMenosTotal(totalmujeres_48a59.getPesoEdadMenosTotal()+1);                        
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setPesoEdadMenosUno(totalmujeres_60a71.getPesoEdadMenosUno()+1);
                            totalmujeres_60a71.setPesoEdadMenosTotal(totalmujeres_60a71.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setPesoEdadMenosUno(totalmujeres_6a9.getPesoEdadMenosUno()+1);
                            totalmujeres_6a9.setPesoEdadMenosTotal(totalmujeres_6a9.getPesoEdadMenosTotal()+1);
                        }
                    }
                }// FIN -1 DS
                
                if (controlUltimo.get(0).getPesoEdadControl().equals("-2 DE")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPesoEdadMenosDos(totalAmbosSexos.getPesoEdadMenosDos()+1);
                    totalAmbosSexos.setPesoEdadMenosTotal(totalAmbosSexos.getPesoEdadMenosTotal()+1);                    
                    if (pacientes.getGenero_nino().equals("Masculino")) {
                        totalhombres.setPesoEdadMenosDos(totalhombres.getPesoEdadMenosDos()+1);
                        totalhombres.setPesoEdadMenosTotal(totalhombres.getPesoEdadMenosTotal()+1);
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setPesoEdadMenosDos(totalhombres_pueblos.getPesoEdadMenosDos()+1);
                            totalhombres_pueblos.setPesoEdadMenosTotal(totalhombres_pueblos.getPesoEdadMenosTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setPesoEdadMenosDos(totalhombres_inmigrantes.getPesoEdadMenosDos()+1);
                            totalhombres_inmigrantes.setPesoEdadMenosTotal(totalhombres_inmigrantes.getPesoEdadMenosTotal()+1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalhombres_menor1.setPesoEdadMenosDos(totalhombres_menor1.getPesoEdadMenosDos()+1);
                            totalhombres_menor1.setPesoEdadMenosTotal(totalhombres_menor1.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setPesoEdadMenosDos(totalhombres_1.getPesoEdadMenosDos()+1);
                            totalhombres_1.setPesoEdadMenosTotal(totalhombres_1.getPesoEdadMenosTotal()+1);                            
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setPesoEdadMenosDos(totalhombres_2.getPesoEdadMenosDos()+1);
                            totalhombres_2.setPesoEdadMenosTotal(totalhombres_2.getPesoEdadMenosTotal()+1);                            
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setPesoEdadMenosDos(totalhombres_3.getPesoEdadMenosDos()+1);
                            totalhombres_3.setPesoEdadMenosTotal(totalhombres_3.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setPesoEdadMenosDos(totalhombres_4.getPesoEdadMenosDos()+1);
                            totalhombres_4.setPesoEdadMenosTotal(totalhombres_4.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setPesoEdadMenosDos(totalhombres_5.getPesoEdadMenosDos()+1);
                            totalhombres_5.setPesoEdadMenosTotal(totalhombres_5.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setPesoEdadMenosDos(totalhombres_6.getPesoEdadMenosDos()+1);
                            totalhombres_6.setPesoEdadMenosTotal(totalhombres_6.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setPesoEdadMenosDos(totalhombres_7a11.getPesoEdadMenosDos()+1);
                            totalhombres_7a11.setPesoEdadMenosTotal(totalhombres_7a11.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setPesoEdadMenosDos(totalhombres_12a17.getPesoEdadMenosDos()+1);
                            totalhombres_12a17.setPesoEdadMenosTotal(totalhombres_12a17.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setPesoEdadMenosDos(totalhombres_18a23.getPesoEdadMenosDos()+1);
                            totalhombres_18a23.setPesoEdadMenosTotal(totalhombres_18a23.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setPesoEdadMenosDos(totalhombres_24a35.getPesoEdadMenosDos()+1);
                            totalhombres_24a35.setPesoEdadMenosTotal(totalhombres_24a35.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setPesoEdadMenosDos(totalhombres_36a41.getPesoEdadMenosDos()+1);
                            totalhombres_36a41.setPesoEdadMenosTotal(totalhombres_36a41.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setPesoEdadMenosDos(totalhombres_42a47.getPesoEdadMenosDos()+1);
                            totalhombres_42a47.setPesoEdadMenosTotal(totalhombres_42a47.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setPesoEdadMenosDos(totalhombres_48a59.getPesoEdadMenosDos()+1); 
                            totalhombres_48a59.setPesoEdadMenosTotal(totalhombres_48a59.getPesoEdadMenosTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalhombres_60a71.setPesoEdadMenosDos(totalmujeres_60a71.getPesoEdadMenosDos()+1);
                            totalmujeres_60a71.setPesoEdadMenosTotal(totalmujeres_60a71.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setPesoEdadMenosDos(totalhombres_6a9.getPesoEdadMenosDos()+1);
                            totalhombres_6a9.setPesoEdadMenosTotal(totalhombres_6a9.getPesoEdadMenosTotal()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPesoEdadMenosDos(totalmujeres.getPesoEdadMenosDos()+1);
                        totalmujeres.setPesoEdadMenosTotal(totalmujeres.getPesoEdadMenosTotal()+1);
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setPesoEdadMenosDos(totalmujeres_pueblos.getPesoEdadMenosDos()+1);
                            totalmujeres_pueblos.setPesoEdadMenosTotal(totalmujeres_pueblos.getPesoEdadMenosTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setPesoEdadMenosDos(totalmujeres_inmigrantes.getPesoEdadMenosDos()+1);
                            totalmujeres_inmigrantes.setPesoEdadMenosTotal(totalmujeres_inmigrantes.getPesoEdadMenosTotal()+1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalmujeres_menor1.setPesoEdadMenosDos(totalmujeres_menor1.getPesoEdadMenosDos()+1);
                            totalmujeres_menor1.setPesoEdadMenosTotal(totalmujeres_menor1.getPesoEdadMenosTotal()+1);                            
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setPesoEdadMenosDos(totalmujeres_1.getPesoEdadMenosDos()+1);
                            totalmujeres_1.setPesoEdadMenosTotal(totalmujeres_1.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setPesoEdadMenosDos(totalmujeres_2.getPesoEdadMenosDos()+1);
                            totalmujeres_2.setPesoEdadMenosTotal(totalmujeres_2.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setPesoEdadMenosDos(totalmujeres_3.getPesoEdadMenosDos()+1);
                            totalmujeres_3.setPesoEdadMenosTotal(totalmujeres_3.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setPesoEdadMenosDos(totalmujeres_4.getPesoEdadMenosDos()+1);
                            totalmujeres_4.setPesoEdadMenosTotal(totalmujeres_4.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setPesoEdadMenosDos(totalmujeres_5.getPesoEdadMenosDos()+1);
                            totalmujeres_5.setPesoEdadMenosTotal(totalmujeres_5.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setPesoEdadMenosDos(totalmujeres_6.getPesoEdadMenosDos()+1);
                            totalmujeres_6.setPesoEdadMenosTotal(totalmujeres_6.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setPesoEdadMenosDos(totalmujeres_7a11.getPesoEdadMenosDos()+1);
                            totalmujeres_7a11.setPesoEdadMenosTotal(totalmujeres_7a11.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setPesoEdadMenosDos(totalmujeres_12a17.getPesoEdadMenosDos()+1);
                            totalmujeres_12a17.setPesoEdadMenosTotal(totalmujeres_12a17.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setPesoEdadMenosDos(totalmujeres_18a23.getPesoEdadMenosDos()+1);
                            totalmujeres_18a23.setPesoEdadMenosTotal(totalmujeres_18a23.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setPesoEdadMenosDos(totalmujeres_24a35.getPesoEdadMenosDos()+1);
                            totalmujeres_24a35.setPesoEdadMenosTotal(totalmujeres_24a35.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setPesoEdadMenosDos(totalmujeres_36a41.getPesoEdadMenosDos()+1);
                            totalmujeres_36a41.setPesoEdadMenosTotal(totalmujeres_36a41.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setPesoEdadMenosDos(totalmujeres_42a47.getPesoEdadMenosDos()+1);
                            totalmujeres_42a47.setPesoEdadMenosTotal(totalmujeres_42a47.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setPesoEdadMenosDos(totalmujeres_48a59.getPesoEdadMenosDos()+1); 
                            totalmujeres_48a59.setPesoEdadMenosTotal(totalmujeres_48a59.getPesoEdadMenosTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setPesoEdadMenosDos(totalmujeres_60a71.getPesoEdadMenosDos()+1);
                            totalmujeres_60a71.setPesoEdadMenosTotal(totalmujeres_60a71.getPesoEdadMenosTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setPesoEdadMenosDos(totalmujeres_6a9.getPesoEdadMenosDos()+1);
                            totalmujeres_6a9.setPesoEdadMenosTotal(totalmujeres_6a9.getPesoEdadMenosTotal()+1);
                        }
                    }
                }// FIN -2 DS
                
                // Peso/Talla
                
                if (controlUltimo.get(0).getPesoTallaControl().equals("+2 DE")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPesoTallaMasDos(totalAmbosSexos.getPesoTallaMasDos()+1);
                    totalAmbosSexos.setPesoTallaMasTotal(totalAmbosSexos.getPesoTallaMasTotal()+1);                    
                    if (pacientes.getGenero_nino().equals("Masculino")) {
                        totalhombres.setPesoTallaMasDos(totalhombres.getPesoTallaMasDos()+1);
                        totalhombres.setPesoTallaMasTotal(totalhombres.getPesoTallaMasTotal()+1);
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setPesoTallaMasDos(totalhombres_pueblos.getPesoTallaMasDos()+1);
                            totalhombres_pueblos.setPesoTallaMasTotal(totalhombres_pueblos.getPesoTallaMasTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setPesoTallaMasDos(totalhombres_inmigrantes.getPesoTallaMasDos()+1);
                            totalhombres_inmigrantes.setPesoTallaMasTotal(totalhombres_inmigrantes.getPesoTallaMasTotal()+1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalhombres_menor1.setPesoTallaMasDos(totalhombres_menor1.getPesoTallaMasDos()+1);
                            totalhombres_menor1.setPesoTallaMasTotal(totalhombres_menor1.getPesoTallaMasTotal()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setPesoTallaMasDos(totalhombres_1.getPesoTallaMasDos()+1);
                            totalhombres_1.setPesoTallaMasTotal(totalhombres_1.getPesoTallaMasTotal()+1);                            
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setPesoTallaMasDos(totalhombres_2.getPesoTallaMasDos()+1);
                            totalhombres_2.setPesoTallaMasTotal(totalhombres_2.getPesoTallaMasTotal()+1);                            
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setPesoTallaMasDos(totalhombres_3.getPesoTallaMasDos()+1);
                            totalhombres_3.setPesoTallaMasTotal(totalhombres_3.getPesoTallaMasTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setPesoTallaMasDos(totalhombres_4.getPesoTallaMasDos()+1);
                            totalhombres_4.setPesoTallaMasTotal(totalhombres_4.getPesoTallaMasTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setPesoTallaMasDos(totalhombres_5.getPesoTallaMasDos()+1);
                            totalhombres_5.setPesoTallaMasTotal(totalhombres_5.getPesoTallaMasTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setPesoTallaMasDos(totalhombres_6.getPesoTallaMasDos()+1);
                            totalhombres_6.setPesoTallaMasTotal(totalhombres_6.getPesoTallaMasTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setPesoTallaMasDos(totalhombres_7a11.getPesoTallaMasDos()+1);
                            totalhombres_7a11.setPesoTallaMasTotal(totalhombres_7a11.getPesoTallaMasTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setPesoTallaMasDos(totalhombres_12a17.getPesoTallaMasDos()+1);
                            totalhombres_12a17.setPesoTallaMasTotal(totalhombres_12a17.getPesoTallaMasTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setPesoTallaMasDos(totalhombres_18a23.getPesoTallaMasDos()+1);
                            totalhombres_18a23.setPesoTallaMasTotal(totalhombres_18a23.getPesoTallaMasTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setPesoTallaMasDos(totalhombres_24a35.getPesoTallaMasDos()+1);
                            totalhombres_24a35.setPesoTallaMasTotal(totalhombres_24a35.getPesoTallaMasTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setPesoTallaMasDos(totalhombres_36a41.getPesoTallaMasDos()+1);
                            totalhombres_36a41.setPesoTallaMasTotal(totalhombres_36a41.getPesoTallaMasTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setPesoTallaMasDos(totalhombres_42a47.getPesoTallaMasDos()+1);
                            totalhombres_42a47.setPesoTallaMasTotal(totalhombres_42a47.getPesoTallaMasTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setPesoTallaMasDos(totalhombres_48a59.getPesoTallaMasDos()+1); 
                            totalhombres_48a59.setPesoTallaMasTotal(totalhombres_48a59.getPesoTallaMasTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalhombres_60a71.setPesoTallaMasDos(totalmujeres_60a71.getPesoTallaMasDos()+1);
                            totalmujeres_60a71.setPesoTallaMasTotal(totalmujeres_60a71.getPesoTallaMasTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setPesoTallaMasDos(totalhombres_6a9.getPesoTallaMasDos()+1);
                            totalhombres_6a9.setPesoTallaMasTotal(totalhombres_6a9.getPesoTallaMasTotal()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPesoTallaMasDos(totalmujeres.getPesoTallaMasDos()+1);
                        totalmujeres.setPesoTallaMasTotal(totalmujeres.getPesoTallaMasTotal()+1);
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setPesoTallaMasDos(totalmujeres_pueblos.getPesoTallaMasDos()+1);
                            totalmujeres_pueblos.setPesoTallaMasTotal(totalmujeres_pueblos.getPesoTallaMasTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setPesoTallaMasDos(totalmujeres_inmigrantes.getPesoTallaMasDos()+1);
                            totalmujeres_inmigrantes.setPesoTallaMasTotal(totalmujeres_inmigrantes.getPesoTallaMasTotal()+1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalmujeres_menor1.setPesoTallaMasDos(totalmujeres_menor1.getPesoTallaMasDos()+1);
                            totalmujeres_menor1.setPesoTallaMasTotal(totalmujeres_menor1.getPesoTallaMasTotal()+1);                            
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setPesoTallaMasDos(totalmujeres_1.getPesoTallaMasDos()+1);
                            totalmujeres_1.setPesoTallaMasTotal(totalmujeres_1.getPesoTallaMasTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setPesoTallaMasDos(totalmujeres_2.getPesoTallaMasDos()+1);
                            totalmujeres_2.setPesoTallaMasTotal(totalmujeres_2.getPesoTallaMasTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setPesoTallaMasDos(totalmujeres_3.getPesoTallaMasDos()+1);
                            totalmujeres_3.setPesoTallaMasTotal(totalmujeres_3.getPesoTallaMasTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setPesoTallaMasDos(totalmujeres_4.getPesoTallaMasDos()+1);
                            totalmujeres_4.setPesoTallaMasTotal(totalmujeres_4.getPesoTallaMasTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setPesoTallaMasDos(totalmujeres_5.getPesoTallaMasDos()+1);
                            totalmujeres_5.setPesoTallaMasTotal(totalmujeres_5.getPesoTallaMasTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setPesoTallaMasDos(totalmujeres_6.getPesoTallaMasDos()+1);
                            totalmujeres_6.setPesoTallaMasTotal(totalmujeres_6.getPesoTallaMasTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setPesoTallaMasDos(totalmujeres_7a11.getPesoTallaMasDos()+1);
                            totalmujeres_7a11.setPesoTallaMasTotal(totalmujeres_7a11.getPesoTallaMasTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setPesoTallaMasDos(totalmujeres_12a17.getPesoTallaMasDos()+1);
                            totalmujeres_12a17.setPesoTallaMasTotal(totalmujeres_12a17.getPesoTallaMasTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setPesoTallaMasDos(totalmujeres_18a23.getPesoTallaMasDos()+1);
                            totalmujeres_18a23.setPesoTallaMasTotal(totalmujeres_18a23.getPesoTallaMasTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setPesoTallaMasDos(totalmujeres_24a35.getPesoTallaMasDos()+1);
                            totalmujeres_24a35.setPesoTallaMasTotal(totalmujeres_24a35.getPesoTallaMasTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setPesoTallaMasDos(totalmujeres_36a41.getPesoTallaMasDos()+1);
                            totalmujeres_36a41.setPesoTallaMasTotal(totalmujeres_36a41.getPesoTallaMasTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setPesoTallaMasDos(totalmujeres_42a47.getPesoTallaMasDos()+1);
                            totalmujeres_42a47.setPesoTallaMasTotal(totalmujeres_42a47.getPesoTallaMasTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setPesoTallaMasDos(totalmujeres_48a59.getPesoTallaMasDos()+1); 
                            totalmujeres_48a59.setPesoTallaMasTotal(totalmujeres_48a59.getPesoTallaMasTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setPesoTallaMasDos(totalmujeres_60a71.getPesoTallaMasDos()+1);
                            totalmujeres_60a71.setPesoTallaMasTotal(totalmujeres_60a71.getPesoTallaMasTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setPesoTallaMasDos(totalmujeres_6a9.getPesoTallaMasDos()+1);
                            totalmujeres_6a9.setPesoTallaMasTotal(totalmujeres_6a9.getPesoTallaMasTotal()+1);
                        }
                    }
                }// FIN -2 DS

                if (controlUltimo.get(0).getPesoTallaControl().equals("+1 DE")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPesoTallaMasUno(totalAmbosSexos.getPesoTallaMasUno()+1);
                    totalAmbosSexos.setPesoTallaMasTotal(totalAmbosSexos.getPesoTallaMasTotal()+1);                    
                    if (pacientes.getGenero_nino().equals("Masculino")) {
                        totalhombres.setPesoTallaMasUno(totalhombres.getPesoTallaMasUno()+1);
                        totalhombres.setPesoTallaMasTotal(totalhombres.getPesoTallaMasTotal()+1);
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setPesoTallaMasUno(totalhombres_pueblos.getPesoTallaMasUno()+1);
                            totalhombres_pueblos.setPesoTallaMasTotal(totalhombres_pueblos.getPesoTallaMasTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setPesoTallaMasUno(totalhombres_inmigrantes.getPesoTallaMasUno()+1);
                            totalhombres_inmigrantes.setPesoTallaMasTotal(totalhombres_inmigrantes.getPesoTallaMasTotal()+1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalhombres_menor1.setPesoTallaMasUno(totalhombres_menor1.getPesoTallaMasUno()+1);
                            totalhombres_menor1.setPesoTallaMasTotal(totalhombres_menor1.getPesoTallaMasTotal()+1);                            
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setPesoTallaMasUno(totalhombres_1.getPesoTallaMasUno()+1);
                            totalhombres_1.setPesoTallaMasTotal(totalhombres_1.getPesoTallaMasTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setPesoTallaMasUno(totalhombres_2.getPesoTallaMasUno()+1);
                            totalhombres_2.setPesoTallaMasTotal(totalhombres_2.getPesoTallaMasTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setPesoTallaMasUno(totalhombres_3.getPesoTallaMasUno()+1);
                            totalhombres_3.setPesoTallaMasTotal(totalhombres_3.getPesoTallaMasTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setPesoTallaMasUno(totalhombres_4.getPesoTallaMasUno()+1);
                            totalhombres_4.setPesoTallaMasTotal(totalhombres_4.getPesoTallaMasTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setPesoTallaMasUno(totalhombres_5.getPesoTallaMasUno()+1);
                            totalhombres_5.setPesoTallaMasTotal(totalhombres_5.getPesoTallaMasTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setPesoTallaMasUno(totalhombres_6.getPesoTallaMasUno()+1);
                            totalhombres_6.setPesoTallaMasTotal(totalhombres_6.getPesoTallaMasTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setPesoTallaMasUno(totalhombres_7a11.getPesoTallaMasUno()+1);
                            totalhombres_7a11.setPesoTallaMasTotal(totalhombres_7a11.getPesoTallaMasTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setPesoTallaMasUno(totalhombres_12a17.getPesoTallaMasUno()+1);
                            totalhombres_12a17.setPesoTallaMasTotal(totalhombres_12a17.getPesoTallaMasTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setPesoTallaMasUno(totalhombres_18a23.getPesoTallaMasUno()+1);
                            totalhombres_18a23.setPesoTallaMasTotal(totalhombres_18a23.getPesoTallaMasTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setPesoTallaMasUno(totalhombres_24a35.getPesoTallaMasUno()+1);
                            totalhombres_24a35.setPesoTallaMasTotal(totalhombres_24a35.getPesoTallaMasTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setPesoTallaMasUno(totalhombres_36a41.getPesoTallaMasUno()+1);
                            totalhombres_36a41.setPesoTallaMasTotal(totalhombres_36a41.getPesoTallaMasTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setPesoTallaMasUno(totalhombres_42a47.getPesoTallaMasUno()+1);
                            totalhombres_42a47.setPesoTallaMasTotal(totalhombres_42a47.getPesoTallaMasTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setPesoTallaMasUno(totalhombres_48a59.getPesoTallaMasUno()+1); 
                            totalhombres_48a59.setPesoTallaMasTotal(totalhombres_48a59.getPesoTallaMasTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalhombres_60a71.setPesoTallaMasUno(totalmujeres_60a71.getPesoTallaMasUno()+1);
                            totalmujeres_60a71.setPesoTallaMasTotal(totalmujeres_60a71.getPesoTallaMasTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setPesoTallaMasUno(totalhombres_6a9.getPesoTallaMasUno()+1);
                            totalhombres_6a9.setPesoTallaMasTotal(totalhombres_6a9.getPesoTallaMasTotal()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPesoTallaMasUno(totalmujeres.getPesoTallaMasUno()+1);
                        totalmujeres.setPesoTallaMasTotal(totalmujeres.getPesoTallaMasTotal()+1);
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setPesoTallaMasUno(totalmujeres_pueblos.getPesoTallaMasUno()+1);
                            totalmujeres_pueblos.setPesoTallaMasTotal(totalmujeres_pueblos.getPesoTallaMasTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setPesoTallaMasUno(totalmujeres_inmigrantes.getPesoTallaMasUno()+1);
                            totalmujeres_inmigrantes.setPesoTallaMasTotal(totalmujeres_inmigrantes.getPesoTallaMasTotal()+1);
                        }    
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalmujeres_menor1.setPesoTallaMasUno(totalmujeres_menor1.getPesoTallaMasUno()+1);
                            totalmujeres_menor1.setPesoTallaMasTotal(totalmujeres_menor1.getPesoTallaMasTotal()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setPesoTallaMasUno(totalmujeres_1.getPesoTallaMasUno()+1);
                            totalmujeres_1.setPesoTallaMasTotal(totalmujeres_1.getPesoTallaMasTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setPesoTallaMasUno(totalmujeres_2.getPesoTallaMasUno()+1);
                            totalmujeres_2.setPesoTallaMasTotal(totalmujeres_2.getPesoTallaMasTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setPesoTallaMasUno(totalmujeres_3.getPesoTallaMasUno()+1);
                            totalmujeres_3.setPesoTallaMasTotal(totalmujeres_3.getPesoTallaMasTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setPesoTallaMasUno(totalmujeres_4.getPesoTallaMasUno()+1);
                            totalmujeres_4.setPesoTallaMasTotal(totalmujeres_4.getPesoTallaMasTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setPesoTallaMasUno(totalmujeres_5.getPesoTallaMasUno()+1);
                            totalmujeres_5.setPesoTallaMasTotal(totalmujeres_5.getPesoTallaMasTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setPesoTallaMasUno(totalmujeres_6.getPesoTallaMasUno()+1);
                            totalmujeres_6.setPesoTallaMasTotal(totalmujeres_6.getPesoTallaMasTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setPesoTallaMasUno(totalmujeres_7a11.getPesoTallaMasUno()+1);
                            totalmujeres_7a11.setPesoTallaMasTotal(totalmujeres_7a11.getPesoTallaMasTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setPesoTallaMasUno(totalmujeres_12a17.getPesoTallaMasUno()+1);
                            totalmujeres_12a17.setPesoTallaMasTotal(totalmujeres_12a17.getPesoTallaMasTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setPesoTallaMasUno(totalmujeres_18a23.getPesoTallaMasUno()+1);
                            totalmujeres_18a23.setPesoTallaMasTotal(totalmujeres_18a23.getPesoTallaMasTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setPesoTallaMasUno(totalmujeres_24a35.getPesoTallaMasUno()+1);
                            totalmujeres_24a35.setPesoTallaMasTotal(totalmujeres_24a35.getPesoTallaMasTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setPesoTallaMasUno(totalmujeres_36a41.getPesoTallaMasUno()+1);
                            totalmujeres_36a41.setPesoTallaMasTotal(totalmujeres_36a41.getPesoTallaMasTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setPesoTallaMasUno(totalmujeres_42a47.getPesoTallaMasUno()+1);
                            totalmujeres_42a47.setPesoTallaMasTotal(totalmujeres_42a47.getPesoTallaMasTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setPesoTallaMasUno(totalmujeres_48a59.getPesoTallaMasUno()+1);
                            totalmujeres_48a59.setPesoTallaMasTotal(totalmujeres_48a59.getPesoTallaMasTotal()+1);                        
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setPesoTallaMasUno(totalmujeres_60a71.getPesoTallaMasUno()+1);
                            totalmujeres_60a71.setPesoTallaMasTotal(totalmujeres_60a71.getPesoTallaMasTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setPesoTallaMasUno(totalmujeres_6a9.getPesoTallaMasUno()+1);
                            totalmujeres_6a9.setPesoTallaMasTotal(totalmujeres_6a9.getPesoTallaMasTotal()+1);
                        }
                    }
                }// FIN -1 DS
                
                if (controlUltimo.get(0).getPesoTallaControl().equals("-2 DE")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPesoTallaMenosDos(totalAmbosSexos.getPesoTallaMenosDos()+1);
                    totalAmbosSexos.setPesoTallaMenosTotal(totalAmbosSexos.getPesoTallaMenosTotal()+1);                    
                    if (pacientes.getGenero_nino().equals("Masculino")) {
                        totalhombres.setPesoTallaMenosDos(totalhombres.getPesoTallaMenosDos()+1);
                        totalhombres.setPesoTallaMenosTotal(totalhombres.getPesoTallaMenosTotal()+1);                        
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setPesoTallaMenosDos(totalhombres_pueblos.getPesoTallaMenosDos()+1);
                            totalhombres_pueblos.setPesoTallaMenosTotal(totalhombres_pueblos.getPesoTallaMenosTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setPesoTallaMenosDos(totalhombres_inmigrantes.getPesoTallaMenosDos()+1);
                            totalhombres_inmigrantes.setPesoTallaMenosTotal(totalhombres_inmigrantes.getPesoTallaMenosTotal()+1);
                        }   
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalhombres_menor1.setPesoTallaMenosDos(totalhombres_menor1.getPesoTallaMenosDos()+1);
                            totalhombres_menor1.setPesoTallaMenosTotal(totalhombres_menor1.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setPesoTallaMenosDos(totalhombres_1.getPesoTallaMenosDos()+1);
                            totalhombres_1.setPesoTallaMenosTotal(totalhombres_1.getPesoTallaMenosTotal()+1);                            
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setPesoTallaMenosDos(totalhombres_2.getPesoTallaMenosDos()+1);
                            totalhombres_2.setPesoTallaMenosTotal(totalhombres_2.getPesoTallaMenosTotal()+1);                            
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setPesoTallaMenosDos(totalhombres_3.getPesoTallaMenosDos()+1);
                            totalhombres_3.setPesoTallaMenosTotal(totalhombres_3.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setPesoTallaMenosDos(totalhombres_4.getPesoTallaMenosDos()+1);
                            totalhombres_4.setPesoTallaMenosTotal(totalhombres_4.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setPesoTallaMenosDos(totalhombres_5.getPesoTallaMenosDos()+1);
                            totalhombres_5.setPesoTallaMenosTotal(totalhombres_5.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setPesoTallaMenosDos(totalhombres_6.getPesoTallaMenosDos()+1);
                            totalhombres_6.setPesoTallaMenosTotal(totalhombres_6.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setPesoTallaMenosDos(totalhombres_7a11.getPesoTallaMenosDos()+1);
                            totalhombres_7a11.setPesoTallaMenosTotal(totalhombres_7a11.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setPesoTallaMenosDos(totalhombres_12a17.getPesoTallaMenosDos()+1);
                            totalhombres_12a17.setPesoTallaMenosTotal(totalhombres_12a17.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setPesoTallaMenosDos(totalhombres_18a23.getPesoTallaMenosDos()+1);
                            totalhombres_18a23.setPesoTallaMenosTotal(totalhombres_18a23.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setPesoTallaMenosDos(totalhombres_24a35.getPesoTallaMenosDos()+1);
                            totalhombres_24a35.setPesoTallaMenosTotal(totalhombres_24a35.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setPesoTallaMenosDos(totalhombres_36a41.getPesoTallaMenosDos()+1);
                            totalhombres_36a41.setPesoTallaMenosTotal(totalhombres_36a41.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setPesoTallaMenosDos(totalhombres_42a47.getPesoTallaMenosDos()+1);
                            totalhombres_42a47.setPesoTallaMenosTotal(totalhombres_42a47.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setPesoTallaMenosDos(totalhombres_48a59.getPesoTallaMenosDos()+1); 
                            totalhombres_48a59.setPesoTallaMenosTotal(totalhombres_48a59.getPesoTallaMenosTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalhombres_60a71.setPesoTallaMenosDos(totalmujeres_60a71.getPesoTallaMenosDos()+1);
                            totalmujeres_60a71.setPesoTallaMenosTotal(totalmujeres_60a71.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setPesoTallaMenosDos(totalhombres_6a9.getPesoTallaMenosDos()+1);
                            totalhombres_6a9.setPesoTallaMenosTotal(totalhombres_6a9.getPesoTallaMenosTotal()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPesoTallaMenosDos(totalmujeres.getPesoTallaMenosDos()+1);
                        totalmujeres.setPesoTallaMenosTotal(totalmujeres.getPesoTallaMenosTotal()+1);                        
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setPesoTallaMenosDos(totalmujeres_pueblos.getPesoTallaMenosDos()+1);
                            totalmujeres_pueblos.setPesoTallaMenosTotal(totalmujeres_pueblos.getPesoTallaMenosTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setPesoTallaMenosDos(totalmujeres_inmigrantes.getPesoTallaMenosDos()+1);
                            totalmujeres_inmigrantes.setPesoTallaMenosTotal(totalmujeres_inmigrantes.getPesoTallaMenosTotal()+1);
                        } 
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalmujeres_menor1.setPesoTallaMenosDos(totalmujeres_menor1.getPesoTallaMenosDos()+1);
                            totalmujeres_menor1.setPesoTallaMenosTotal(totalmujeres_menor1.getPesoTallaMenosTotal()+1);                            
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setPesoTallaMenosDos(totalmujeres_1.getPesoTallaMenosDos()+1);
                            totalmujeres_1.setPesoTallaMenosTotal(totalmujeres_1.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setPesoTallaMenosDos(totalmujeres_2.getPesoTallaMenosDos()+1);
                            totalmujeres_2.setPesoTallaMenosTotal(totalmujeres_2.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setPesoTallaMenosDos(totalmujeres_3.getPesoTallaMenosDos()+1);
                            totalmujeres_3.setPesoTallaMenosTotal(totalmujeres_3.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setPesoTallaMenosDos(totalmujeres_4.getPesoTallaMenosDos()+1);
                            totalmujeres_4.setPesoTallaMenosTotal(totalmujeres_4.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setPesoTallaMenosDos(totalmujeres_5.getPesoTallaMenosDos()+1);
                            totalmujeres_5.setPesoTallaMenosTotal(totalmujeres_5.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setPesoTallaMenosDos(totalmujeres_6.getPesoTallaMenosDos()+1);
                            totalmujeres_6.setPesoTallaMenosTotal(totalmujeres_6.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setPesoTallaMenosDos(totalmujeres_7a11.getPesoTallaMenosDos()+1);
                            totalmujeres_7a11.setPesoTallaMenosTotal(totalmujeres_7a11.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setPesoTallaMenosDos(totalmujeres_12a17.getPesoTallaMenosDos()+1);
                            totalmujeres_12a17.setPesoTallaMenosTotal(totalmujeres_12a17.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setPesoTallaMenosDos(totalmujeres_18a23.getPesoTallaMenosDos()+1);
                            totalmujeres_18a23.setPesoTallaMenosTotal(totalmujeres_18a23.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setPesoTallaMenosDos(totalmujeres_24a35.getPesoTallaMenosDos()+1);
                            totalmujeres_24a35.setPesoTallaMenosTotal(totalmujeres_24a35.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setPesoTallaMenosDos(totalmujeres_36a41.getPesoTallaMenosDos()+1);
                            totalmujeres_36a41.setPesoTallaMenosTotal(totalmujeres_36a41.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setPesoTallaMenosDos(totalmujeres_42a47.getPesoTallaMenosDos()+1);
                            totalmujeres_42a47.setPesoTallaMenosTotal(totalmujeres_42a47.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setPesoTallaMenosDos(totalmujeres_48a59.getPesoTallaMenosDos()+1); 
                            totalmujeres_48a59.setPesoTallaMenosTotal(totalmujeres_48a59.getPesoTallaMenosTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setPesoTallaMenosDos(totalmujeres_60a71.getPesoTallaMenosDos()+1);
                            totalmujeres_60a71.setPesoTallaMenosTotal(totalmujeres_60a71.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setPesoTallaMenosDos(totalmujeres_6a9.getPesoTallaMenosDos()+1);
                            totalmujeres_6a9.setPesoTallaMenosTotal(totalmujeres_6a9.getPesoTallaMenosTotal()+1);
                        }
                    }
                }// FIN -2 DS

                if (controlUltimo.get(0).getPesoTallaControl().equals("-1 DE")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPesoTallaMenosUno(totalAmbosSexos.getPesoTallaMenosUno()+1);
                    totalAmbosSexos.setPesoTallaMenosTotal(totalAmbosSexos.getPesoTallaMenosTotal()+1);                    
                    if (pacientes.getGenero_nino().equals("Masculino")) {
                        totalhombres.setPesoTallaMenosUno(totalhombres.getPesoTallaMenosUno()+1);
                        totalhombres.setPesoTallaMenosTotal(totalhombres.getPesoTallaMenosTotal()+1);                                                
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setPesoTallaMenosUno(totalhombres_pueblos.getPesoTallaMenosUno()+1);
                            totalhombres_pueblos.setPesoTallaMenosTotal(totalhombres_pueblos.getPesoTallaMenosTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setPesoTallaMenosUno(totalhombres_inmigrantes.getPesoTallaMenosUno()+1);
                            totalhombres_inmigrantes.setPesoTallaMenosTotal(totalhombres_inmigrantes.getPesoTallaMenosTotal()+1);
                        } 
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalhombres_menor1.setPesoTallaMenosUno(totalhombres_menor1.getPesoTallaMenosUno()+1);
                            totalhombres_menor1.setPesoTallaMenosTotal(totalhombres_menor1.getPesoTallaMenosTotal()+1);                            
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setPesoTallaMenosUno(totalhombres_1.getPesoTallaMenosUno()+1);
                            totalhombres_1.setPesoTallaMenosTotal(totalhombres_1.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setPesoTallaMenosUno(totalhombres_2.getPesoTallaMenosUno()+1);
                            totalhombres_2.setPesoTallaMenosTotal(totalhombres_2.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setPesoTallaMenosUno(totalhombres_3.getPesoTallaMenosUno()+1);
                            totalhombres_3.setPesoTallaMenosTotal(totalhombres_3.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setPesoTallaMenosUno(totalhombres_4.getPesoTallaMenosUno()+1);
                            totalhombres_4.setPesoTallaMenosTotal(totalhombres_4.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setPesoTallaMenosUno(totalhombres_5.getPesoTallaMenosUno()+1);
                            totalhombres_5.setPesoTallaMenosTotal(totalhombres_5.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setPesoTallaMenosUno(totalhombres_6.getPesoTallaMenosUno()+1);
                            totalhombres_6.setPesoTallaMenosTotal(totalhombres_6.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setPesoTallaMenosUno(totalhombres_7a11.getPesoTallaMenosUno()+1);
                            totalhombres_7a11.setPesoTallaMenosTotal(totalhombres_7a11.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setPesoTallaMenosUno(totalhombres_12a17.getPesoTallaMenosUno()+1);
                            totalhombres_12a17.setPesoTallaMenosTotal(totalhombres_12a17.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setPesoTallaMenosUno(totalhombres_18a23.getPesoTallaMenosUno()+1);
                            totalhombres_18a23.setPesoTallaMenosTotal(totalhombres_18a23.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setPesoTallaMenosUno(totalhombres_24a35.getPesoTallaMenosUno()+1);
                            totalhombres_24a35.setPesoTallaMenosTotal(totalhombres_24a35.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setPesoTallaMenosUno(totalhombres_36a41.getPesoTallaMenosUno()+1);
                            totalhombres_36a41.setPesoTallaMenosTotal(totalhombres_36a41.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setPesoTallaMenosUno(totalhombres_42a47.getPesoTallaMenosUno()+1);
                            totalhombres_42a47.setPesoTallaMenosTotal(totalhombres_42a47.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setPesoTallaMenosUno(totalhombres_48a59.getPesoTallaMenosUno()+1); 
                            totalhombres_48a59.setPesoTallaMenosTotal(totalhombres_48a59.getPesoTallaMenosTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalhombres_60a71.setPesoTallaMenosUno(totalmujeres_60a71.getPesoTallaMenosUno()+1);
                            totalmujeres_60a71.setPesoTallaMenosTotal(totalmujeres_60a71.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setPesoTallaMenosUno(totalhombres_6a9.getPesoTallaMenosUno()+1);
                            totalhombres_6a9.setPesoTallaMenosTotal(totalhombres_6a9.getPesoTallaMenosTotal()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPesoTallaMenosUno(totalmujeres.getPesoTallaMenosUno()+1);
                        totalmujeres.setPesoTallaMenosTotal(totalmujeres.getPesoTallaMenosTotal()+1);                                                
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setPesoTallaMenosUno(totalmujeres_pueblos.getPesoTallaMenosUno()+1);
                            totalmujeres_pueblos.setPesoTallaMenosTotal(totalmujeres_pueblos.getPesoTallaMenosTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setPesoTallaMenosUno(totalmujeres_inmigrantes.getPesoTallaMenosUno()+1);
                            totalmujeres_inmigrantes.setPesoTallaMenosTotal(totalmujeres_inmigrantes.getPesoTallaMenosTotal()+1);
                        }  
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalmujeres_menor1.setPesoTallaMenosUno(totalmujeres_menor1.getPesoTallaMenosUno()+1);
                            totalmujeres_menor1.setPesoTallaMenosTotal(totalmujeres_menor1.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setPesoTallaMenosUno(totalmujeres_1.getPesoTallaMenosUno()+1);
                            totalmujeres_1.setPesoTallaMenosTotal(totalmujeres_1.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setPesoTallaMenosUno(totalmujeres_2.getPesoTallaMenosUno()+1);
                            totalmujeres_2.setPesoTallaMenosTotal(totalmujeres_2.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setPesoTallaMenosUno(totalmujeres_3.getPesoTallaMenosUno()+1);
                            totalmujeres_3.setPesoTallaMenosTotal(totalmujeres_3.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setPesoTallaMenosUno(totalmujeres_4.getPesoTallaMenosUno()+1);
                            totalmujeres_4.setPesoTallaMenosTotal(totalmujeres_4.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setPesoTallaMenosUno(totalmujeres_5.getPesoTallaMenosUno()+1);
                            totalmujeres_5.setPesoTallaMenosTotal(totalmujeres_5.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setPesoTallaMenosUno(totalmujeres_6.getPesoTallaMenosUno()+1);
                            totalmujeres_6.setPesoTallaMenosTotal(totalmujeres_6.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setPesoTallaMenosUno(totalmujeres_7a11.getPesoTallaMenosUno()+1);
                            totalmujeres_7a11.setPesoTallaMenosTotal(totalmujeres_7a11.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setPesoTallaMenosUno(totalmujeres_12a17.getPesoTallaMenosUno()+1);
                            totalmujeres_12a17.setPesoTallaMenosTotal(totalmujeres_12a17.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setPesoTallaMenosUno(totalmujeres_18a23.getPesoTallaMenosUno()+1);
                            totalmujeres_18a23.setPesoTallaMenosTotal(totalmujeres_18a23.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setPesoTallaMenosUno(totalmujeres_24a35.getPesoTallaMenosUno()+1);
                            totalmujeres_24a35.setPesoTallaMenosTotal(totalmujeres_24a35.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setPesoTallaMenosUno(totalmujeres_36a41.getPesoTallaMenosUno()+1);
                            totalmujeres_36a41.setPesoTallaMenosTotal(totalmujeres_36a41.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setPesoTallaMenosUno(totalmujeres_42a47.getPesoTallaMenosUno()+1);
                            totalmujeres_42a47.setPesoTallaMenosTotal(totalmujeres_42a47.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setPesoTallaMenosUno(totalmujeres_48a59.getPesoTallaMenosUno()+1);
                            totalmujeres_48a59.setPesoTallaMenosTotal(totalmujeres_48a59.getPesoTallaMenosTotal()+1);                        
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setPesoTallaMenosUno(totalmujeres_60a71.getPesoTallaMenosUno()+1);
                            totalmujeres_60a71.setPesoTallaMenosTotal(totalmujeres_60a71.getPesoTallaMenosTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setPesoTallaMenosUno(totalmujeres_6a9.getPesoTallaMenosUno()+1);
                            totalmujeres_6a9.setPesoTallaMenosTotal(totalmujeres_6a9.getPesoTallaMenosTotal()+1);
                        }
                    }
                }// FIN -1 DS
                
                // Talla/Edad
                
                if (controlUltimo.get(0).getTallaEdadControl().equals("-2 DE")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setTallaEdadMenosDos(totalAmbosSexos.getTallaEdadMenosDos()+1);
                    totalAmbosSexos.setTallaEdadMenosTotal(totalAmbosSexos.getTallaEdadMenosTotal()+1);                    
                    if (pacientes.getGenero_nino().equals("Masculino")) {
                        totalhombres.setTallaEdadMenosDos(totalhombres.getTallaEdadMenosDos()+1);
                        totalhombres.setTallaEdadMenosTotal(totalhombres.getTallaEdadMenosTotal()+1);                                                
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setTallaEdadMenosDos(totalhombres_pueblos.getTallaEdadMenosDos()+1);
                            totalhombres_pueblos.setTallaEdadMenosTotal(totalhombres_pueblos.getTallaEdadMenosTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setTallaEdadMenosDos(totalhombres_inmigrantes.getTallaEdadMenosDos()+1);
                            totalhombres_inmigrantes.setTallaEdadMenosTotal(totalhombres_inmigrantes.getTallaEdadMenosTotal()+1);
                        }     
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalhombres_menor1.setTallaEdadMenosDos(totalhombres_menor1.getTallaEdadMenosDos()+1);
                            totalhombres_menor1.setTallaEdadMenosTotal(totalhombres_menor1.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setTallaEdadMenosDos(totalhombres_1.getTallaEdadMenosDos()+1);
                            totalhombres_1.setTallaEdadMenosTotal(totalhombres_1.getTallaEdadMenosTotal()+1);                            
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setTallaEdadMenosDos(totalhombres_2.getTallaEdadMenosDos()+1);
                            totalhombres_2.setTallaEdadMenosTotal(totalhombres_2.getTallaEdadMenosTotal()+1);                            
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setTallaEdadMenosDos(totalhombres_3.getTallaEdadMenosDos()+1);
                            totalhombres_3.setTallaEdadMenosTotal(totalhombres_3.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setTallaEdadMenosDos(totalhombres_4.getTallaEdadMenosDos()+1);
                            totalhombres_4.setTallaEdadMenosTotal(totalhombres_4.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setTallaEdadMenosDos(totalhombres_5.getTallaEdadMenosDos()+1);
                            totalhombres_5.setTallaEdadMenosTotal(totalhombres_5.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setTallaEdadMenosDos(totalhombres_6.getTallaEdadMenosDos()+1);
                            totalhombres_6.setTallaEdadMenosTotal(totalhombres_6.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setTallaEdadMenosDos(totalhombres_7a11.getTallaEdadMenosDos()+1);
                            totalhombres_7a11.setTallaEdadMenosTotal(totalhombres_7a11.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setTallaEdadMenosDos(totalhombres_12a17.getTallaEdadMenosDos()+1);
                            totalhombres_12a17.setTallaEdadMenosTotal(totalhombres_12a17.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setTallaEdadMenosDos(totalhombres_18a23.getTallaEdadMenosDos()+1);
                            totalhombres_18a23.setTallaEdadMenosTotal(totalhombres_18a23.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setTallaEdadMenosDos(totalhombres_24a35.getTallaEdadMenosDos()+1);
                            totalhombres_24a35.setTallaEdadMenosTotal(totalhombres_24a35.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setTallaEdadMenosDos(totalhombres_36a41.getTallaEdadMenosDos()+1);
                            totalhombres_36a41.setTallaEdadMenosTotal(totalhombres_36a41.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setTallaEdadMenosDos(totalhombres_42a47.getTallaEdadMenosDos()+1);
                            totalhombres_42a47.setTallaEdadMenosTotal(totalhombres_42a47.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setTallaEdadMenosDos(totalhombres_48a59.getTallaEdadMenosDos()+1); 
                            totalhombres_48a59.setTallaEdadMenosTotal(totalhombres_48a59.getTallaEdadMenosTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalhombres_60a71.setTallaEdadMenosDos(totalmujeres_60a71.getTallaEdadMenosDos()+1);
                            totalmujeres_60a71.setTallaEdadMenosTotal(totalmujeres_60a71.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setTallaEdadMenosDos(totalhombres_6a9.getTallaEdadMenosDos()+1);
                            totalhombres_6a9.setTallaEdadMenosTotal(totalhombres_6a9.getTallaEdadMenosTotal()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setTallaEdadMenosDos(totalmujeres.getTallaEdadMenosDos()+1);
                        totalmujeres.setTallaEdadMenosTotal(totalmujeres.getTallaEdadMenosTotal()+1);                                                
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setTallaEdadMenosDos(totalmujeres_pueblos.getTallaEdadMenosDos()+1);
                            totalmujeres_pueblos.setTallaEdadMenosTotal(totalmujeres_pueblos.getTallaEdadMenosTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setTallaEdadMenosDos(totalmujeres_inmigrantes.getTallaEdadMenosDos()+1);
                            totalmujeres_inmigrantes.setTallaEdadMenosTotal(totalmujeres_inmigrantes.getTallaEdadMenosTotal()+1);
                        }     
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalmujeres_menor1.setTallaEdadMenosDos(totalmujeres_menor1.getTallaEdadMenosDos()+1);
                            totalmujeres_menor1.setTallaEdadMenosTotal(totalmujeres_menor1.getTallaEdadMenosTotal()+1);                            
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setTallaEdadMenosDos(totalmujeres_1.getTallaEdadMenosDos()+1);
                            totalmujeres_1.setTallaEdadMenosTotal(totalmujeres_1.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setTallaEdadMenosDos(totalmujeres_2.getTallaEdadMenosDos()+1);
                            totalmujeres_2.setTallaEdadMenosTotal(totalmujeres_2.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setTallaEdadMenosDos(totalmujeres_3.getTallaEdadMenosDos()+1);
                            totalmujeres_3.setTallaEdadMenosTotal(totalmujeres_3.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setTallaEdadMenosDos(totalmujeres_4.getTallaEdadMenosDos()+1);
                            totalmujeres_4.setTallaEdadMenosTotal(totalmujeres_4.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setTallaEdadMenosDos(totalmujeres_5.getTallaEdadMenosDos()+1);
                            totalmujeres_5.setTallaEdadMenosTotal(totalmujeres_5.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setTallaEdadMenosDos(totalmujeres_6.getTallaEdadMenosDos()+1);
                            totalmujeres_6.setTallaEdadMenosTotal(totalmujeres_6.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setTallaEdadMenosDos(totalmujeres_7a11.getTallaEdadMenosDos()+1);
                            totalmujeres_7a11.setTallaEdadMenosTotal(totalmujeres_7a11.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setTallaEdadMenosDos(totalmujeres_12a17.getTallaEdadMenosDos()+1);
                            totalmujeres_12a17.setTallaEdadMenosTotal(totalmujeres_12a17.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setTallaEdadMenosDos(totalmujeres_18a23.getTallaEdadMenosDos()+1);
                            totalmujeres_18a23.setTallaEdadMenosTotal(totalmujeres_18a23.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setTallaEdadMenosDos(totalmujeres_24a35.getTallaEdadMenosDos()+1);
                            totalmujeres_24a35.setTallaEdadMenosTotal(totalmujeres_24a35.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setTallaEdadMenosDos(totalmujeres_36a41.getTallaEdadMenosDos()+1);
                            totalmujeres_36a41.setTallaEdadMenosTotal(totalmujeres_36a41.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setTallaEdadMenosDos(totalmujeres_42a47.getTallaEdadMenosDos()+1);
                            totalmujeres_42a47.setTallaEdadMenosTotal(totalmujeres_42a47.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setTallaEdadMenosDos(totalmujeres_48a59.getTallaEdadMenosDos()+1); 
                            totalmujeres_48a59.setTallaEdadMenosTotal(totalmujeres_48a59.getTallaEdadMenosTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setTallaEdadMenosDos(totalmujeres_60a71.getTallaEdadMenosDos()+1);
                            totalmujeres_60a71.setTallaEdadMenosTotal(totalmujeres_60a71.getTallaEdadMenosTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setTallaEdadMenosDos(totalmujeres_6a9.getTallaEdadMenosDos()+1);
                            totalmujeres_6a9.setTallaEdadMenosTotal(totalmujeres_6a9.getTallaEdadMenosTotal()+1);
                        }
                    }
                }// FIN -2 DS

                // RIESGO/BAJOPESO
                
                if (controlUltimo.get(0).getEstadoNutricionalControl().equals("Riesgo/Bajo Peso")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalAmbosSexos.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoSubtotal(totalAmbosSexos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoTotal(totalAmbosSexos.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                    if (pacientes.getGenero_nino().equals("Masculino")) {
                        totalhombres.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                        totalhombres.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                        totalhombres.setDiagnosticoNutricionalIntegradoTotal(totalhombres.getDiagnosticoNutricionalIntegradoTotal()+1);                                                
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoTotal(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoTotal(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }    
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_menor1.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_menor1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoTotal(totalhombres_menor1.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_1.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_1.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_1.setDiagnosticoNutricionalIntegradoTotal(totalhombres_1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_2.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_2.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_2.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_2.setDiagnosticoNutricionalIntegradoTotal(totalhombres_2.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_3.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_3.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_3.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_3.setDiagnosticoNutricionalIntegradoTotal(totalhombres_3.getDiagnosticoNutricionalIntegradoTotal()+1);;
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_4.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_4.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_4.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_4.setDiagnosticoNutricionalIntegradoTotal(totalhombres_4.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_5.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_5.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_5.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_5.setDiagnosticoNutricionalIntegradoTotal(totalhombres_5.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_6.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_6.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_6.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_6.setDiagnosticoNutricionalIntegradoTotal(totalhombres_6.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_7a11.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_7a11.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoTotal(totalhombres_7a11.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_12a17.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_12a17.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoTotal(totalhombres_12a17.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_18a23.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_18a23.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoTotal(totalhombres_18a23.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_24a35.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_24a35.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoTotal(totalhombres_24a35.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_36a41.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_36a41.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoTotal(totalhombres_36a41.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_42a47.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_42a47.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoTotal(totalhombres_42a47.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_48a59.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1); 
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_48a59.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoTotal(totalhombres_48a59.getDiagnosticoNutricionalIntegradoTotal()+1);                     
                        } else if (edad >= 60 && edad < 72) {
                            totalhombres_60a71.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalhombres_6a9.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_6a9.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoTotal(totalhombres_6a9.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                        totalmujeres.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                        totalmujeres.setDiagnosticoNutricionalIntegradoTotal(totalmujeres.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } 
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_1.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_2.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_2.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_2.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_3.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_3.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_3.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_4.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_4.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_4.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_5.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_5.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_5.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_6.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_6.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_6.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoSubtotal()+1); 
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoRiesgoBajoPeso(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoRiesgoBajoPeso()+1);
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                    }
                }// FIN RIESGO/BAJOPESO
                
                // DESNUTRIDO
                
                if (controlUltimo.get(0).getEstadoNutricionalControl().equals("Desnutrido")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoDesnutrido(totalAmbosSexos.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoSubtotal(totalAmbosSexos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoTotal(totalAmbosSexos.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                    if (pacientes.getGenero_nino().equals("Masculino")) {
                        totalhombres.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                        totalhombres.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                        totalhombres.setDiagnosticoNutricionalIntegradoTotal(totalhombres.getDiagnosticoNutricionalIntegradoTotal()+1);                                       
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoTotal(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoTotal(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_menor1.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_menor1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoTotal(totalhombres_menor1.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_1.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_1.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_1.setDiagnosticoNutricionalIntegradoTotal(totalhombres_1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_2.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_2.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_2.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_2.setDiagnosticoNutricionalIntegradoTotal(totalhombres_2.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_3.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_3.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_3.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_3.setDiagnosticoNutricionalIntegradoTotal(totalhombres_3.getDiagnosticoNutricionalIntegradoTotal()+1);;
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_4.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_4.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_4.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_4.setDiagnosticoNutricionalIntegradoTotal(totalhombres_4.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_5.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_5.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_5.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_5.setDiagnosticoNutricionalIntegradoTotal(totalhombres_5.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_6.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_6.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_6.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_6.setDiagnosticoNutricionalIntegradoTotal(totalhombres_6.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_7a11.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_7a11.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoTotal(totalhombres_7a11.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_12a17.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_12a17.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoTotal(totalhombres_12a17.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_18a23.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_18a23.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoTotal(totalhombres_18a23.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_24a35.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_24a35.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoTotal(totalhombres_24a35.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_36a41.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_36a41.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoTotal(totalhombres_36a41.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_42a47.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_42a47.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoTotal(totalhombres_42a47.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_48a59.getDiagnosticoNutricionalIntegradoDesnutrido()+1); 
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_48a59.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoTotal(totalhombres_48a59.getDiagnosticoNutricionalIntegradoTotal()+1);                     
                        } else if (edad >= 60 && edad < 72) {
                            totalhombres_60a71.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoDesnutrido(totalhombres_6a9.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_6a9.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoTotal(totalhombres_6a9.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                        totalmujeres.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                        totalmujeres.setDiagnosticoNutricionalIntegradoTotal(totalmujeres.getDiagnosticoNutricionalIntegradoTotal()+1);                                       
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }   
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_1.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_2.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_2.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_2.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_3.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_3.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_3.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_4.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_4.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_4.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_5.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_5.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_5.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_6.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_6.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_6.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoSubtotal()+1); 
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoDesnutrido(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoDesnutrido()+1);
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                    }
                }// FIN DESNUTRIDO
                
                // SOBREPESO/RIESGOOBESIDAD
                
                 if (controlUltimo.get(0).getEstadoNutricionalControl().equals("Sobrepeso/Riesgo Obesidad")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalAmbosSexos.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoSubtotal(totalAmbosSexos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoTotal(totalAmbosSexos.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                    if (pacientes.getGenero_nino().equals("Masculino")) {
                        totalhombres.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                        totalhombres.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                        totalhombres.setDiagnosticoNutricionalIntegradoTotal(totalhombres.getDiagnosticoNutricionalIntegradoTotal()+1);                                       
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoTotal(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoTotal(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }      
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_menor1.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_menor1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoTotal(totalhombres_menor1.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_1.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_1.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_1.setDiagnosticoNutricionalIntegradoTotal(totalhombres_1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_2.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_2.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_2.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_2.setDiagnosticoNutricionalIntegradoTotal(totalhombres_2.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_3.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_3.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_3.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_3.setDiagnosticoNutricionalIntegradoTotal(totalhombres_3.getDiagnosticoNutricionalIntegradoTotal()+1);;
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_4.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_4.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_4.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_4.setDiagnosticoNutricionalIntegradoTotal(totalhombres_4.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_5.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_5.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_5.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_5.setDiagnosticoNutricionalIntegradoTotal(totalhombres_5.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_6.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_6.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_6.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_6.setDiagnosticoNutricionalIntegradoTotal(totalhombres_6.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_7a11.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_7a11.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoTotal(totalhombres_7a11.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_12a17.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_12a17.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoTotal(totalhombres_12a17.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_18a23.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_18a23.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoTotal(totalhombres_18a23.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_24a35.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_24a35.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoTotal(totalhombres_24a35.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_36a41.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_36a41.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoTotal(totalhombres_36a41.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_42a47.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_42a47.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoTotal(totalhombres_42a47.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_48a59.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1); 
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_48a59.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoTotal(totalhombres_48a59.getDiagnosticoNutricionalIntegradoTotal()+1);                     
                        } else if (edad >= 60 && edad < 72) {
                            totalhombres_60a71.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalhombres_6a9.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_6a9.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoTotal(totalhombres_6a9.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                        totalmujeres.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                        totalmujeres.setDiagnosticoNutricionalIntegradoTotal(totalmujeres.getDiagnosticoNutricionalIntegradoTotal()+1);                                       
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } 
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_1.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_2.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_2.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_2.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_3.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_3.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_3.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_4.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_4.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_4.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_5.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_5.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_5.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_6.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_6.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_6.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoSubtotal()+1); 
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoSobrePesoObesidad(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoSobrePesoObesidad()+1);
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                    }
                }// FIN SOBREPESO/RIESGOOBESIDAD
                
                // OBESO
                
                 if (controlUltimo.get(0).getEstadoNutricionalControl().equals("Obeso")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoObeso(totalAmbosSexos.getDiagnosticoNutricionalIntegradoObeso()+1);
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoSubtotal(totalAmbosSexos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoTotal(totalAmbosSexos.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                    if (pacientes.getGenero_nino().equals("Masculino")) {
                        totalhombres.setDiagnosticoNutricionalIntegradoObeso(totalhombres.getDiagnosticoNutricionalIntegradoObeso()+1);
                        totalhombres.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                        totalhombres.setDiagnosticoNutricionalIntegradoTotal(totalhombres.getDiagnosticoNutricionalIntegradoTotal()+1);                                       
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoObeso(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoTotal(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoObeso(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoTotal(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }  
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoObeso(totalhombres_menor1.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_menor1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoTotal(totalhombres_menor1.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setDiagnosticoNutricionalIntegradoObeso(totalhombres_1.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_1.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_1.setDiagnosticoNutricionalIntegradoTotal(totalhombres_1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setDiagnosticoNutricionalIntegradoObeso(totalhombres_2.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_2.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_2.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_2.setDiagnosticoNutricionalIntegradoTotal(totalhombres_2.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setDiagnosticoNutricionalIntegradoObeso(totalhombres_3.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_3.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_3.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_3.setDiagnosticoNutricionalIntegradoTotal(totalhombres_3.getDiagnosticoNutricionalIntegradoTotal()+1);;
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setDiagnosticoNutricionalIntegradoObeso(totalhombres_4.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_4.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_4.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_4.setDiagnosticoNutricionalIntegradoTotal(totalhombres_4.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setDiagnosticoNutricionalIntegradoObeso(totalhombres_5.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_5.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_5.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_5.setDiagnosticoNutricionalIntegradoTotal(totalhombres_5.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setDiagnosticoNutricionalIntegradoObeso(totalhombres_6.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_6.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_6.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_6.setDiagnosticoNutricionalIntegradoTotal(totalhombres_6.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoObeso(totalhombres_7a11.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_7a11.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoTotal(totalhombres_7a11.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoObeso(totalhombres_12a17.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_12a17.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoTotal(totalhombres_12a17.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoObeso(totalhombres_18a23.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_18a23.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoTotal(totalhombres_18a23.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoObeso(totalhombres_24a35.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_24a35.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoTotal(totalhombres_24a35.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoObeso(totalhombres_36a41.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_36a41.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoTotal(totalhombres_36a41.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoObeso(totalhombres_42a47.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_42a47.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoTotal(totalhombres_42a47.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoObeso(totalhombres_48a59.getDiagnosticoNutricionalIntegradoObeso()+1); 
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_48a59.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoTotal(totalhombres_48a59.getDiagnosticoNutricionalIntegradoTotal()+1);                     
                        } else if (edad >= 60 && edad < 72) {
                            totalhombres_60a71.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoObeso(totalhombres_6a9.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_6a9.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoTotal(totalhombres_6a9.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setDiagnosticoNutricionalIntegradoObeso(totalmujeres.getDiagnosticoNutricionalIntegradoObeso()+1);
                        totalmujeres.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                        totalmujeres.setDiagnosticoNutricionalIntegradoTotal(totalmujeres.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }      
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_1.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_2.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_2.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_2.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_3.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_3.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_3.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_4.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_4.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_4.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_5.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_5.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_5.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_6.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_6.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_6.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoSubtotal()+1); 
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoObeso(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoObeso()+1);
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                    }
                }// FIN OBESO
                 
                //Normal
                
                 if (controlUltimo.get(0).getEstadoNutricionalControl().equals("Normal")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoNormal(totalAmbosSexos.getDiagnosticoNutricionalIntegradoNormal()+1);
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoSubtotal(totalAmbosSexos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoTotal(totalAmbosSexos.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                    if (pacientes.getGenero_nino().equals("Masculino")) {
                        totalhombres.setDiagnosticoNutricionalIntegradoNormal(totalhombres.getDiagnosticoNutricionalIntegradoNormal()+1);
                        totalhombres.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                        totalhombres.setDiagnosticoNutricionalIntegradoTotal(totalhombres.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoNormal(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoTotal(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoNormal(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoTotal(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }  
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoNormal(totalhombres_menor1.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_menor1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoTotal(totalhombres_menor1.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setDiagnosticoNutricionalIntegradoNormal(totalhombres_1.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_1.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_1.setDiagnosticoNutricionalIntegradoTotal(totalhombres_1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setDiagnosticoNutricionalIntegradoNormal(totalhombres_2.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_2.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_2.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_2.setDiagnosticoNutricionalIntegradoTotal(totalhombres_2.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setDiagnosticoNutricionalIntegradoNormal(totalhombres_3.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_3.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_3.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_3.setDiagnosticoNutricionalIntegradoTotal(totalhombres_3.getDiagnosticoNutricionalIntegradoTotal()+1);;
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setDiagnosticoNutricionalIntegradoNormal(totalhombres_4.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_4.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_4.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_4.setDiagnosticoNutricionalIntegradoTotal(totalhombres_4.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setDiagnosticoNutricionalIntegradoNormal(totalhombres_5.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_5.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_5.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_5.setDiagnosticoNutricionalIntegradoTotal(totalhombres_5.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setDiagnosticoNutricionalIntegradoNormal(totalhombres_6.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_6.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_6.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_6.setDiagnosticoNutricionalIntegradoTotal(totalhombres_6.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoNormal(totalhombres_7a11.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_7a11.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoTotal(totalhombres_7a11.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoNormal(totalhombres_12a17.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_12a17.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoTotal(totalhombres_12a17.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoNormal(totalhombres_18a23.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_18a23.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoTotal(totalhombres_18a23.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoNormal(totalhombres_24a35.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_24a35.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoTotal(totalhombres_24a35.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoNormal(totalhombres_36a41.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_36a41.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoTotal(totalhombres_36a41.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoNormal(totalhombres_42a47.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_42a47.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoTotal(totalhombres_42a47.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoNormal(totalhombres_48a59.getDiagnosticoNutricionalIntegradoNormal()+1); 
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_48a59.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoTotal(totalhombres_48a59.getDiagnosticoNutricionalIntegradoTotal()+1);                     
                        } else if (edad >= 60 && edad < 72) {
                            totalhombres_60a71.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoNormal(totalhombres_6a9.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoSubtotal(totalhombres_6a9.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoTotal(totalhombres_6a9.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setDiagnosticoNutricionalIntegradoNormal(totalmujeres.getDiagnosticoNutricionalIntegradoNormal()+1);
                        totalmujeres.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                        totalmujeres.setDiagnosticoNutricionalIntegradoTotal(totalmujeres.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }   
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }    
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_1.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_1.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_2.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_2.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_2.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_3.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_3.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_3.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_4.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_4.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_4.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_5.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_5.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_5.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_6.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_6.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_6.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoSubtotal()+1); 
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoNormal(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoNormal()+1);
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoSubtotal(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoSubtotal()+1);
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                    }
                }// FIN NORMAL
                 
                //DESNUTRICION SEC
                 
                  if (controlUltimo.get(0).getEstadoNutricionalControl().equals("Desnutricion Secundaria")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalAmbosSexos.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                    totalAmbosSexos.setDiagnosticoNutricionalIntegradoTotal(totalAmbosSexos.getDiagnosticoNutricionalIntegradoTotal()+1);                    
                    if (pacientes.getGenero_nino().equals("Masculino")) {
                        totalhombres.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                        totalhombres.setDiagnosticoNutricionalIntegradoTotal(totalhombres.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                        if(pacientes.getEtnia()){
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_pueblos.setDiagnosticoNutricionalIntegradoTotal(totalhombres_pueblos.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } 
                        if(pacientes.getExtranjero()){
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_inmigrantes.setDiagnosticoNutricionalIntegradoTotal(totalhombres_inmigrantes.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } 
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_menor1.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_menor1.setDiagnosticoNutricionalIntegradoTotal(totalhombres_menor1.getDiagnosticoNutricionalIntegradoTotal()+1);                            
                        } else if (edad >= 1 && edad < 2) {
                            totalhombres_1.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_1.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_1.setDiagnosticoNutricionalIntegradoTotal(totalhombres_1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalhombres_2.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_2.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_2.setDiagnosticoNutricionalIntegradoTotal(totalhombres_2.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalhombres_3.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_3.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_3.setDiagnosticoNutricionalIntegradoTotal(totalhombres_3.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalhombres_4.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_4.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_4.setDiagnosticoNutricionalIntegradoTotal(totalhombres_4.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalhombres_5.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_5.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_5.setDiagnosticoNutricionalIntegradoTotal(totalhombres_5.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalhombres_6.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_6.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_6.setDiagnosticoNutricionalIntegradoTotal(totalhombres_6.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_7a11.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_7a11.setDiagnosticoNutricionalIntegradoTotal(totalhombres_7a11.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_12a17.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_12a17.setDiagnosticoNutricionalIntegradoTotal(totalhombres_12a17.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_18a23.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_18a23.setDiagnosticoNutricionalIntegradoTotal(totalhombres_18a23.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_24a35.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_24a35.setDiagnosticoNutricionalIntegradoTotal(totalhombres_24a35.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_36a41.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_36a41.setDiagnosticoNutricionalIntegradoTotal(totalhombres_36a41.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_42a47.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_42a47.setDiagnosticoNutricionalIntegradoTotal(totalhombres_42a47.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_48a59.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1); 
                            totalhombres_48a59.setDiagnosticoNutricionalIntegradoTotal(totalhombres_48a59.getDiagnosticoNutricionalIntegradoTotal()+1);                       
                        } else if (edad >= 60 && edad < 72) {
                            totalhombres_60a71.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalhombres_6a9.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalhombres_6a9.setDiagnosticoNutricionalIntegradoTotal(totalhombres_6a9.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                        totalmujeres.setDiagnosticoNutricionalIntegradoTotal(totalmujeres.getDiagnosticoNutricionalIntegradoTotal()+1);                                        
                        if(pacientes.getEtnia()){
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_pueblos.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_pueblos.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }  
                        if(pacientes.getExtranjero()){
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_inmigrantes.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_inmigrantes.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }  
                        //Dependiendo de la edad las condiciones son:
                        if (edad <1) {
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_menor1.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_menor1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 1 && edad < 2) {
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_1.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_1.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_1.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 2 && edad < 3) {
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_2.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_2.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_2.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 3 && edad < 4) {
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_3.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_3.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_3.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 4 && edad < 5) {
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_4.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_4.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_4.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 5 && edad < 6) {
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_5.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_5.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_5.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 6 && edad < 7) {
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_6.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_6.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_6.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 7 && edad < 12) {
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_7a11.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_7a11.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 12 && edad < 18) {
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_12a17.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_12a17.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 18 && edad < 24) {
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_18a23.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_18a23.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 24 && edad < 36) {
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_24a35.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_24a35.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 36 && edad < 42) {
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_36a41.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_36a41.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 42 && edad < 48) {
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_42a47.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_42a47.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 48 && edad < 60) {
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_48a59.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_48a59.getDiagnosticoNutricionalIntegradoTotal()+1);                        
                        } else if (edad >= 60 && edad < 72) {
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_60a71.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_60a71.getDiagnosticoNutricionalIntegradoTotal()+1);
                        } else if (edad >= 72 && edad <= 108) {
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoDesnutricionSecundaria(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoDesnutricionSecundaria()+1);
                            totalmujeres_6a9.setDiagnosticoNutricionalIntegradoTotal(totalmujeres_6a9.getDiagnosticoNutricionalIntegradoTotal()+1);
                        }
                    }
                }// FIN DESNUTRICION SEC                
                
            }
        }//fin for
        totalAmbosSexos.setColumnName1("Total Ambos Sexos");
        totalhombres.setColumnName1("Total Hombres");
        totalmujeres.setColumnName1("Total Mujeres");
        totalhombres_menor1.setColumnName1("Hombres menor de 1 mes");
        totalmujeres_menor1.setColumnName1("Mujeres menor de 1 mes");
        totalhombres_1.setColumnName1("Hombres 1 mes");
        totalmujeres_1.setColumnName1("Mujeres 1 mes");
        totalhombres_2.setColumnName1("Hombres 2 meses");
        totalhombres_2.setColumnName1("Mujeres 2 meses");
        totalmujeres_3.setColumnName1("Hombres 3 meses");
        totalhombres_3.setColumnName1("Mujeres 3 meses");
        totalmujeres_4.setColumnName1("Hombres 4 meses");
        totalmujeres_4.setColumnName1("Mujeres 4 meses");
        totalhombres_5.setColumnName1("Hombres 5 meses");
        totalmujeres_5.setColumnName1("Mujeres 5 meses");
        totalhombres_6.setColumnName1("Hombres 6 meses");
        totalmujeres_6.setColumnName1("Mujeres 6 meses");
        totalhombres_7a11.setColumnName1("Hombres 7 a 11 meses");
        totalmujeres_7a11.setColumnName1("Mujeres 7 a 11 meses");
        totalhombres_12a17.setColumnName1("Hombres 12 a 17 meses");
        totalmujeres_12a17.setColumnName1("Mujeres 12 a 17 meses");
        totalhombres_18a23.setColumnName1("Hombres 18 a 23 meses");
        totalmujeres_18a23.setColumnName1("Mujeres 18 a 23 meses");
        totalhombres_24a35.setColumnName1("Hombres 24 a 35 meses");
        totalmujeres_24a35.setColumnName1("Mujeres 24 a 35 meses");
        totalhombres_36a41.setColumnName1("Hombres 36 a 41 meses");
        totalmujeres_36a41.setColumnName1("Mujeres 36 a 41 meses");
        totalhombres_42a47.setColumnName1("Hombres 42 a 47 meses");
        totalmujeres_42a47.setColumnName1("Mujeres 42 a 47 meses");
        totalhombres_48a59.setColumnName1("Hombres 48 a 59 meses");
        totalmujeres_48a59.setColumnName1("Mujeres 48 a 59 meses");
        totalhombres_60a71.setColumnName1("Hombres 60 a 71 meses");
        totalmujeres_60a71.setColumnName1("Mujeres 60 a 71 meses");
        totalhombres_6a9.setColumnName1("Hombres 6 a 9 años");
        totalmujeres_6a9.setColumnName1("Mujeres 6 a 9 años");
        totalhombres_pueblos.setColumnName1("Pueblos Originarios Hombres");
        totalmujeres_pueblos.setColumnName1("Pueblos Originarios Mujeres");
        totalhombres_inmigrantes.setColumnName1("Extranjeros Hombres");
        totalmujeres_inmigrantes.setColumnName1("Extranjeros Mujeres");

        A_elementosPediatria.clear();
        A_elementosPediatria.add(totalAmbosSexos);
        A_elementosPediatria.add(totalhombres);
        A_elementosPediatria.add(totalmujeres);
        A_elementosPediatria.add(totalhombres_menor1);
        A_elementosPediatria.add(totalmujeres_menor1);

        A_elementosPediatria.add(totalhombres_1);
        A_elementosPediatria.add(totalmujeres_1);
        
        A_elementosPediatria.add(totalhombres_2);
        A_elementosPediatria.add(totalmujeres_2);
        
        A_elementosPediatria.add(totalhombres_3);
        A_elementosPediatria.add(totalmujeres_3);
        
        A_elementosPediatria.add(totalhombres_4);
        A_elementosPediatria.add(totalmujeres_4);
        
        A_elementosPediatria.add(totalhombres_5);
        A_elementosPediatria.add(totalmujeres_5);
        
        A_elementosPediatria.add(totalhombres_6);
        A_elementosPediatria.add(totalmujeres_6);
        
        A_elementosPediatria.add(totalhombres_7a11);
        A_elementosPediatria.add(totalmujeres_7a11);
        
        A_elementosPediatria.add(totalhombres_12a17);
        A_elementosPediatria.add(totalmujeres_12a17);
        
        A_elementosPediatria.add(totalhombres_18a23);
        A_elementosPediatria.add(totalmujeres_18a23);
        
        A_elementosPediatria.add(totalhombres_24a35);
        A_elementosPediatria.add(totalmujeres_24a35);
        
        A_elementosPediatria.add(totalhombres_36a41);
        A_elementosPediatria.add(totalmujeres_36a41);
        
        A_elementosPediatria.add(totalhombres_42a47);
        A_elementosPediatria.add(totalmujeres_42a47);
        
        A_elementosPediatria.add(totalhombres_48a59);
        A_elementosPediatria.add(totalmujeres_48a59);
        
        A_elementosPediatria.add(totalhombres_60a71);
        A_elementosPediatria.add(totalmujeres_60a71);
        
        A_elementosPediatria.add(totalhombres_6a9);
        A_elementosPediatria.add(totalmujeres_6a9);
        
        A_elementosPediatria.add(totalhombres_pueblos);
        A_elementosPediatria.add(totalmujeres_pueblos);
        
        A_elementosPediatria.add(totalhombres_inmigrantes);
        A_elementosPediatria.add(totalmujeres_inmigrantes);
        
        return A_elementosPediatria;

        }   
   
    
    public List<CensoPediatriaSeccionE> censoPediatriaSeccionE(){
       CensoPediatriaSeccionE totalNinos = new CensoPediatriaSeccionE(); 
       List<PacienteNino> pacientes_habilitados = ejbPacienteNino.findbyPacienteNinoActivo();
       List<CartolaControlesNino> cped;
       List<ControlNino> controlesPaciente = null;
       
       for (PacienteNino pacientes : pacientes_habilitados) {  
            boolean fue_censado = false;
            int edad;
            boolean registra_unaatencion = false;

            cped = ejbCartolaNino.findByPacienteNino(pacientes);//obtengo todas las cartolas por  pacientes
            
            if (cped.size() > 0) {
                registra_unaatencion = true;
                controlesPaciente = ejbControlNino.findbyCartola(cped.get(0).getId());
            }
            
            if (controlesPaciente.size() > 0) {
                for (ControlNino controles : controlesPaciente){
                    if (controles.getIdentificadorControl().equals("5 meses") && controles.getExaminadorControl().equals("Nutricionista")){
                        totalNinos.setNumeroNutriQuintoMes(totalNinos.getNumeroNutriQuintoMes()+1);
                    }
                    if (controles.getIdentificadorControl().equals("3 años 6 meses") && controles.getExaminadorControl().equals("Nutricionista")){
                        totalNinos.setNumeroNutriTresAñosSeisMeses(totalNinos.getNumeroNutriTresAñosSeisMeses()+1);
                    }
                }
            }
       }       
       
       totalNinos.setColumnName1("Total");
       
       E_elementosPediatria.clear();
       E_elementosPediatria.add(totalNinos);
       
       return E_elementosPediatria;
    }
            
    
    public List<CensoPediatriaSeccionG> censoPediatriaSeccionG(){
        
        CensoPediatriaSeccionG totalClas = new CensoPediatriaSeccionG();
        CensoPediatriaSeccionG grupo36a47 = new CensoPediatriaSeccionG();
        CensoPediatriaSeccionG grupo48a71 = new CensoPediatriaSeccionG();
        CensoPediatriaSeccionG grupo6a9 = new CensoPediatriaSeccionG();        
        List<PacienteNino> pacientes_habilitados = ejbPacienteNino.findbyPacienteNinoActivo();
        List<CartolaControlesNino> cped;
        List<ControlNino> controlesPaciente = null;
        List<ControlNino> controlUltimo;
        boolean resultados[];       
        for (PacienteNino pacientes : pacientes_habilitados) {            
            boolean fue_censado = false;
            int edad;
            boolean registra_unaatencion = false;

            cped = ejbCartolaNino.findByPacienteNino(pacientes);//obtengo todas las cartolas por  pacientes
            
            if (cped.size() > 0) {
                registra_unaatencion = true;
                controlesPaciente = ejbControlNino.findbyCartola(cped.get(0).getId());
            }
                      
            controlUltimo = ejbControlNino.findLastControl(controlesPaciente);
            
            if (controlUltimo.size() > 0) {
                edad = controlUltimo.get(0).getEdadControl();                
                if (edad>=36 && edad < 48){
                    if(controlUltimo.get(0).getPresionArterialControl().equals("Normal")){
                        grupo36a47.setClasificacionNormal(grupo36a47.getClasificacionNormal()+1);
                        totalClas.setClasificacionNormal(totalClas.getClasificacionNormal()+1);
                        grupo36a47.setTotalClasificacion(grupo36a47.getTotalClasificacion()+1);
                        totalClas.setTotalClasificacion(totalClas.getTotalClasificacion()+1);
                    }
                    else if(controlUltimo.get(0).getPresionArterialControl().equals("Pre-Hipertensión")){
                        grupo36a47.setClasificacionPreHiper(grupo36a47.getClasificacionPreHiper()+1);
                        totalClas.setClasificacionPreHiper(totalClas.getClasificacionPreHiper()+1);
                        grupo36a47.setTotalClasificacion(grupo36a47.getTotalClasificacion()+1);
                        totalClas.setTotalClasificacion(totalClas.getTotalClasificacion()+1);
                    }
                    else if(controlUltimo.get(0).getPresionArterialControl().equals("Etapa 1")){
                        grupo36a47.setClasificacionEtapaUno(grupo36a47.getClasificacionEtapaUno()+1);
                        totalClas.setClasificacionEtapaUno(totalClas.getClasificacionEtapaUno()+1);
                        grupo36a47.setTotalClasificacion(grupo36a47.getTotalClasificacion()+1);
                        totalClas.setTotalClasificacion(totalClas.getTotalClasificacion()+1);
                    }
                    else if(controlUltimo.get(0).getPresionArterialControl().equals("Etapa 2")){
                        grupo36a47.setClasificacionEtapaDos(grupo36a47.getClasificacionEtapaDos()+1);
                        totalClas.setClasificacionEtapaDos(totalClas.getClasificacionEtapaDos()+1);
                        grupo36a47.setTotalClasificacion(grupo36a47.getTotalClasificacion()+1);
                        totalClas.setTotalClasificacion(totalClas.getTotalClasificacion()+1);
                    }
                }
                else if (edad>=48 && edad < 72){
                    if(controlUltimo.get(0).getPresionArterialControl().equals("Normal")){
                        grupo48a71.setClasificacionNormal(grupo48a71.getClasificacionNormal()+1);
                        totalClas.setClasificacionNormal(totalClas.getClasificacionNormal()+1);
                        grupo48a71.setTotalClasificacion(grupo48a71.getTotalClasificacion()+1);
                        totalClas.setTotalClasificacion(totalClas.getTotalClasificacion()+1);
                    }
                    else if(controlUltimo.get(0).getPresionArterialControl().equals("Pre-Hipertensión")){
                        grupo48a71.setClasificacionPreHiper(grupo48a71.getClasificacionPreHiper()+1);
                        totalClas.setClasificacionPreHiper(totalClas.getClasificacionPreHiper()+1);
                        grupo48a71.setTotalClasificacion(grupo48a71.getTotalClasificacion()+1);
                        totalClas.setTotalClasificacion(totalClas.getTotalClasificacion()+1);
                    }
                    else if(controlUltimo.get(0).getPresionArterialControl().equals("Etapa 1")){
                        grupo48a71.setClasificacionEtapaUno(grupo48a71.getClasificacionEtapaUno()+1);
                        totalClas.setClasificacionEtapaUno(totalClas.getClasificacionEtapaUno()+1);
                        grupo48a71.setTotalClasificacion(grupo48a71.getTotalClasificacion()+1);
                        totalClas.setTotalClasificacion(totalClas.getTotalClasificacion()+1);
                    }
                    else if(controlUltimo.get(0).getPresionArterialControl().equals("Etapa 2")){
                        grupo48a71.setClasificacionEtapaDos(grupo48a71.getClasificacionEtapaDos()+1);
                        totalClas.setClasificacionEtapaDos(totalClas.getClasificacionEtapaDos()+1);
                        grupo48a71.setTotalClasificacion(grupo48a71.getTotalClasificacion()+1);
                        totalClas.setTotalClasificacion(totalClas.getTotalClasificacion()+1);
                    }
                }
                else if (edad>=72 && edad <= 108){
                    if(controlUltimo.get(0).getPresionArterialControl().equals("Normal")){
                        grupo6a9.setClasificacionNormal(grupo6a9.getClasificacionNormal()+1);
                        totalClas.setClasificacionNormal(totalClas.getClasificacionNormal()+1);
                        grupo6a9.setTotalClasificacion(grupo6a9.getTotalClasificacion()+1);
                        totalClas.setTotalClasificacion(totalClas.getTotalClasificacion()+1);
                    }
                    else if(controlUltimo.get(0).getPresionArterialControl().equals("Pre-Hipertensión")){
                        grupo6a9.setClasificacionPreHiper(grupo6a9.getClasificacionPreHiper()+1);
                        totalClas.setClasificacionPreHiper(totalClas.getClasificacionPreHiper()+1);
                        grupo6a9.setTotalClasificacion(grupo6a9.getTotalClasificacion()+1);
                        totalClas.setTotalClasificacion(totalClas.getTotalClasificacion()+1);
                    }
                    else if(controlUltimo.get(0).getPresionArterialControl().equals("Etapa 1")){
                        grupo6a9.setClasificacionEtapaUno(grupo6a9.getClasificacionEtapaUno()+1);
                        totalClas.setClasificacionEtapaUno(totalClas.getClasificacionEtapaUno()+1);
                        grupo6a9.setTotalClasificacion(grupo6a9.getTotalClasificacion()+1);
                        totalClas.setTotalClasificacion(totalClas.getTotalClasificacion()+1);
                    }
                    else if(controlUltimo.get(0).getPresionArterialControl().equals("Etapa 2")){
                        grupo6a9.setClasificacionEtapaDos(grupo6a9.getClasificacionEtapaDos()+1);
                        totalClas.setClasificacionEtapaDos(totalClas.getClasificacionEtapaDos()+1);
                        grupo6a9.setTotalClasificacion(grupo6a9.getTotalClasificacion()+1);
                        totalClas.setTotalClasificacion(totalClas.getTotalClasificacion()+1);
                    }
                }
            }
        }
       
       totalClas.setColumnName1("Total");
       grupo36a47.setColumnName1("Grupo de edad 36 a 47 meses");
       grupo48a71.setColumnName1("Grupo de edad 48 a 71 meses");
       grupo6a9.setColumnName1("Grupo de edad 6 a 9 años");
       
       G_elementosPediatria.clear();
       
       G_elementosPediatria.add(totalClas);
       G_elementosPediatria.add(grupo36a47);
       G_elementosPediatria.add(grupo48a71);
       G_elementosPediatria.add(grupo6a9);
       
        return G_elementosPediatria;
    }
    
    public List<CensoPediatriaSeccionD> censoPediatriaSeccionD(){
        CensoPediatriaSeccionD totalScore = new CensoPediatriaSeccionD();
        CensoPediatriaSeccionD totalMenor1 = new CensoPediatriaSeccionD();
        CensoPediatriaSeccionD total1 = new CensoPediatriaSeccionD();
        CensoPediatriaSeccionD total2 = new CensoPediatriaSeccionD();      
        CensoPediatriaSeccionD total3 = new CensoPediatriaSeccionD();      
        CensoPediatriaSeccionD total4 = new CensoPediatriaSeccionD();      
        CensoPediatriaSeccionD total5 = new CensoPediatriaSeccionD();      
        CensoPediatriaSeccionD total6 = new CensoPediatriaSeccionD();      
        CensoPediatriaSeccionD totalVisitaDomiciliaria = new CensoPediatriaSeccionD();    
        
        List<PacienteNino> pacientes_habilitados = ejbPacienteNino.findbyPacienteNinoActivo();
        List<CartolaControlesNino> cped;
        List<ControlNino> controlesPaciente = null;
        List<ControlNino> controlUltimo;
        boolean resultados[];   
        for (PacienteNino pacientes : pacientes_habilitados) { 
            boolean fue_censado = false;
            int edad;
            boolean registra_unaatencion = false;

            cped = ejbCartolaNino.findByPacienteNino(pacientes);//obtengo todas las cartolas por  pacientes
            
            if (cped.size() > 0) {
                registra_unaatencion = true;
                controlesPaciente = ejbControlNino.findbyCartola(cped.get(0).getId());
            }
                      
            controlUltimo = ejbControlNino.findLastControl(controlesPaciente);
            
            if (controlUltimo.size() > 0) {
                edad = controlUltimo.get(0).getEdadControl();                
                if(edad<1){
                    if(controlUltimo.get(0).getControlIRAControl().equals("Leve")){
                        totalMenor1.setScoreRiesgoLeve(totalMenor1.getScoreRiesgoLeve()+1);
                        totalScore.setScoreRiesgoLeve(totalScore.getScoreRiesgoLeve()+1);
                        totalMenor1.setScoreTotal(totalMenor1.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoLeve(totalVisitaDomiciliaria.getScoreRiesgoLeve()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Moderado")){
                        totalMenor1.setScoreRiesgoModerado(totalMenor1.getScoreRiesgoModerado()+1);
                        totalScore.setScoreRiesgoModerado(totalScore.getScoreRiesgoModerado()+1);
                        totalMenor1.setScoreTotal(totalMenor1.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoModerado(totalVisitaDomiciliaria.getScoreRiesgoModerado()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Grave")){
                        totalMenor1.setScoreRiesgoGrave(totalMenor1.getScoreRiesgoGrave()+1);
                        totalScore.setScoreRiesgoGrave(totalScore.getScoreRiesgoGrave()+1);
                        totalMenor1.setScoreTotal(totalMenor1.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoGrave(totalVisitaDomiciliaria.getScoreRiesgoGrave()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                }
                else if (edad==1){
                    if(controlUltimo.get(0).getControlIRAControl().equals("Leve")){
                        total1.setScoreRiesgoLeve(total1.getScoreRiesgoLeve()+1);
                        totalScore.setScoreRiesgoLeve(totalScore.getScoreRiesgoLeve()+1);
                        total1.setScoreTotal(total1.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoLeve(totalVisitaDomiciliaria.getScoreRiesgoLeve()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Moderado")){
                        total1.setScoreRiesgoModerado(total1.getScoreRiesgoModerado()+1);
                        totalScore.setScoreRiesgoModerado(totalScore.getScoreRiesgoModerado()+1);
                        total1.setScoreTotal(total1.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoModerado(totalVisitaDomiciliaria.getScoreRiesgoModerado()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Grave")){
                        total1.setScoreRiesgoGrave(total1.getScoreRiesgoGrave()+1);
                        totalScore.setScoreRiesgoGrave(totalScore.getScoreRiesgoGrave()+1);
                        total1.setScoreTotal(total1.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoGrave(totalVisitaDomiciliaria.getScoreRiesgoGrave()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                }
                else if (edad==2){
                    if(controlUltimo.get(0).getControlIRAControl().equals("Leve")){
                        total2.setScoreRiesgoLeve(total2.getScoreRiesgoLeve()+1);
                        totalScore.setScoreRiesgoLeve(totalScore.getScoreRiesgoLeve()+1);
                        total2.setScoreTotal(total2.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoLeve(totalVisitaDomiciliaria.getScoreRiesgoLeve()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Moderado")){
                        total2.setScoreRiesgoModerado(total2.getScoreRiesgoModerado()+1);
                        totalScore.setScoreRiesgoModerado(totalScore.getScoreRiesgoModerado()+1);
                        total2.setScoreTotal(total2.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoModerado(totalVisitaDomiciliaria.getScoreRiesgoModerado()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Grave")){
                        total2.setScoreRiesgoGrave(total2.getScoreRiesgoGrave()+1);
                        totalScore.setScoreRiesgoGrave(totalScore.getScoreRiesgoGrave()+1);
                        total2.setScoreTotal(total2.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoGrave(totalVisitaDomiciliaria.getScoreRiesgoGrave()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                }
                else if (edad==3){
                    if(controlUltimo.get(0).getControlIRAControl().equals("Leve")){
                        total3.setScoreRiesgoLeve(total3.getScoreRiesgoLeve()+1);
                        totalScore.setScoreRiesgoLeve(totalScore.getScoreRiesgoLeve()+1);
                        total3.setScoreTotal(total3.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoLeve(totalVisitaDomiciliaria.getScoreRiesgoLeve()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Moderado")){
                        total3.setScoreRiesgoModerado(total3.getScoreRiesgoModerado()+1);
                        totalScore.setScoreRiesgoModerado(totalScore.getScoreRiesgoModerado()+1);
                        total3.setScoreTotal(total3.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoModerado(totalVisitaDomiciliaria.getScoreRiesgoModerado()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Grave")){
                        total3.setScoreRiesgoGrave(total3.getScoreRiesgoGrave()+1);
                        totalScore.setScoreRiesgoGrave(totalScore.getScoreRiesgoGrave()+1);
                        total3.setScoreTotal(total3.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoGrave(totalVisitaDomiciliaria.getScoreRiesgoGrave()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                }
                else if (edad==4){
                    if(controlUltimo.get(0).getControlIRAControl().equals("Leve")){
                        total4.setScoreRiesgoLeve(total4.getScoreRiesgoLeve()+1);
                        totalScore.setScoreRiesgoLeve(totalScore.getScoreRiesgoLeve()+1);
                        total4.setScoreTotal(total4.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoLeve(totalVisitaDomiciliaria.getScoreRiesgoLeve()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Moderado")){
                        total4.setScoreRiesgoModerado(total4.getScoreRiesgoModerado()+1);
                        totalScore.setScoreRiesgoModerado(totalScore.getScoreRiesgoModerado()+1);
                        total4.setScoreTotal(total4.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoModerado(totalVisitaDomiciliaria.getScoreRiesgoModerado()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Grave")){
                        total4.setScoreRiesgoGrave(total4.getScoreRiesgoGrave()+1);
                        totalScore.setScoreRiesgoGrave(totalScore.getScoreRiesgoGrave()+1);
                        total4.setScoreTotal(total4.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoGrave(totalVisitaDomiciliaria.getScoreRiesgoGrave()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                }
                else if (edad==5){
                    if(controlUltimo.get(0).getControlIRAControl().equals("Leve")){
                        total5.setScoreRiesgoLeve(total5.getScoreRiesgoLeve()+1);
                        totalScore.setScoreRiesgoLeve(totalScore.getScoreRiesgoLeve()+1);
                        total5.setScoreTotal(total5.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoLeve(totalVisitaDomiciliaria.getScoreRiesgoLeve()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Moderado")){
                        total5.setScoreRiesgoModerado(total5.getScoreRiesgoModerado()+1);
                        totalScore.setScoreRiesgoModerado(totalScore.getScoreRiesgoModerado()+1);
                        total5.setScoreTotal(total5.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoModerado(totalVisitaDomiciliaria.getScoreRiesgoModerado()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Grave")){
                        total5.setScoreRiesgoGrave(total5.getScoreRiesgoGrave()+1);
                        totalScore.setScoreRiesgoGrave(totalScore.getScoreRiesgoGrave()+1);
                        total5.setScoreTotal(total5.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoGrave(totalVisitaDomiciliaria.getScoreRiesgoGrave()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                }
                else if (edad==6){
                    if(controlUltimo.get(0).getControlIRAControl().equals("Leve")){
                        total6.setScoreRiesgoLeve(total6.getScoreRiesgoLeve()+1);
                        totalScore.setScoreRiesgoLeve(totalScore.getScoreRiesgoLeve()+1);
                        total6.setScoreTotal(total6.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoLeve(totalVisitaDomiciliaria.getScoreRiesgoLeve()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Moderado")){
                        total6.setScoreRiesgoModerado(total6.getScoreRiesgoModerado()+1);
                        totalScore.setScoreRiesgoModerado(totalScore.getScoreRiesgoModerado()+1);
                        total6.setScoreTotal(total6.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoModerado(totalVisitaDomiciliaria.getScoreRiesgoModerado()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                    else if(controlUltimo.get(0).getControlIRAControl().equals("Grave")){
                        total6.setScoreRiesgoGrave(total6.getScoreRiesgoGrave()+1);
                        totalScore.setScoreRiesgoGrave(totalScore.getScoreRiesgoGrave()+1);
                        total6.setScoreTotal(total6.getScoreTotal()+1);
                        totalScore.setScoreTotal(totalScore.getScoreTotal()+1);
                        if(controlUltimo.get(0).getVisitaDomiciliaria().equals("Si")){
                            totalVisitaDomiciliaria.setScoreRiesgoGrave(totalVisitaDomiciliaria.getScoreRiesgoGrave()+1);
                            totalVisitaDomiciliaria.setScoreTotal(totalVisitaDomiciliaria.getScoreTotal()+1);
                        }
                    }
                }
            }
        
        }
        
       totalScore.setColumnName1("Total");
       totalMenor1.setColumnName1("Diada, < 10 días");
       total1.setColumnName1("1 mes");
       total2.setColumnName1("2 meses");
       total3.setColumnName1("3 meses");
       total4.setColumnName1("4 meses");
       total5.setColumnName1("5 meses");
       total6.setColumnName1("6 meses");
       totalVisitaDomiciliaria.setColumnName1("Total de niños que han recibido VDI");
       
       D_elementosPediatria.clear();
       
       D_elementosPediatria.add(totalScore);
       D_elementosPediatria.add(totalMenor1);
       D_elementosPediatria.add(total1);
       D_elementosPediatria.add(total2);
       D_elementosPediatria.add(total3);
       D_elementosPediatria.add(total4);
       D_elementosPediatria.add(total5);
       D_elementosPediatria.add(total6);
       D_elementosPediatria.add(totalVisitaDomiciliaria);
       
        return D_elementosPediatria;
    }
    
    
    public ConsultasCensoPediatria() {        
    
    }
    
}
