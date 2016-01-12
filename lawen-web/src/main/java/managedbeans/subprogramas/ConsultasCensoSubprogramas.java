/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.subprogramas;

import entities.Paciente;
import entities.Subprograma;
import entities.subprogramas.TarjetaIdentificacionIRA;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import managedbeans.PacienteController;
import sessionbeans.PacienteFacadeLocal;
import sessionbeans.SubprogramaFacadeLocal;
import sessionbeans.subprogramas.TarjetaIdentificacionIRAFacadeLocal;

/**
 *
 * @author Francisco Avello
 */
@Named(value = "consultasCensoSubprogramas")
@SessionScoped
public class ConsultasCensoSubprogramas implements Serializable {

    private List<CensoSubprogramas> censoSubprogramas = new ArrayList<>();
    
    @EJB
    private PacienteFacadeLocal ejbPaciente;
    @EJB
    private SubprogramaFacadeLocal ejbSubprograma;
    @EJB
    private TarjetaIdentificacionIRAFacadeLocal ejbIRA;
    @Inject
    private PacienteController pacienteProg;
    
    public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Carga completada", "Carga completada"));
    }

    public void onCancel() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Progress Cancelled", "Progress Cancelled"));
    }
    
    public void init() {
        censoSubprogramas = censoSubprogramas();
    }

    public List<CensoSubprogramas> getCensoSubprogramas() {
        return censoSubprogramas;
    }

    public void setCensoSubprogramas(List<CensoSubprogramas> censoSubprogramas) {
        this.censoSubprogramas = censoSubprogramas;
    }

    public PacienteFacadeLocal getEjbPaciente() {
        return ejbPaciente;
    }

    public void setEjbPaciente(PacienteFacadeLocal ejbPaciente) {
        this.ejbPaciente = ejbPaciente;
    }

    public SubprogramaFacadeLocal getEjbSubprograma() {
        return ejbSubprograma;
    }

    public void setEjbSubprograma(SubprogramaFacadeLocal ejbSubprograma) {
        this.ejbSubprograma = ejbSubprograma;
    }

    public TarjetaIdentificacionIRAFacadeLocal getEjbIRA() {
        return ejbIRA;
    }

    public void setEjbIRA(TarjetaIdentificacionIRAFacadeLocal ejbIRA) {
        this.ejbIRA = ejbIRA;
    }

    public PacienteController getPacienteProg() {
        return pacienteProg;
    }

    public void setPacienteProg(PacienteController pacienteProg) {
        this.pacienteProg = pacienteProg;
    }
    
    public List<CensoSubprogramas> censoSubprogramas() {
        
        CensoSubprogramas totalAmbosSexos = new CensoSubprogramas();
        CensoSubprogramas totalhombres = new CensoSubprogramas();
        CensoSubprogramas totalmujeres = new CensoSubprogramas();
        CensoSubprogramas totalhombres_15a19 = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_15a19 = new CensoSubprogramas();
        CensoSubprogramas totalhombres_20a24 = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_20a24 = new CensoSubprogramas();
        CensoSubprogramas totalhombres_25a29 = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_25a29 = new CensoSubprogramas();
        CensoSubprogramas totalhombres_30a34 = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_30a34 = new CensoSubprogramas();
        CensoSubprogramas totalhombres_35a39 = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_35a39 = new CensoSubprogramas();
        CensoSubprogramas totalhombres_40a44 = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_40a44 = new CensoSubprogramas();
        CensoSubprogramas totalhombres_45a49 = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_45a49 = new CensoSubprogramas();
        CensoSubprogramas totalhombres_50a54 = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_50a54 = new CensoSubprogramas();
        CensoSubprogramas totalhombres_55a59 = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_55a59 = new CensoSubprogramas();
        CensoSubprogramas totalhombres_60a64 = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_60a64 = new CensoSubprogramas();
        CensoSubprogramas totalhombres_65a69 = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_65a69 = new CensoSubprogramas();
        CensoSubprogramas totalhombres_70a74 = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_70a74 = new CensoSubprogramas();
        CensoSubprogramas totalhombres_75a79 = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_75a79 = new CensoSubprogramas();
        CensoSubprogramas totalhombres_80amas = new CensoSubprogramas();
        CensoSubprogramas totalmujeres_80amas = new CensoSubprogramas();
        
        List<Paciente> pacientes_habilitados = ejbPaciente.findbyPacienteActivo();
        List<Subprograma> subProg;
        List<TarjetaIdentificacionIRA> subIRA;
        for (Paciente pacientes : pacientes_habilitados) {
            boolean fue_censado = false;
            boolean yaSumado =  false;
            int edad;
            subProg = ejbSubprograma.findbyPaciente(pacientes);
            if (subProg.size() > 0) {
                edad = pacienteProg.Age(pacientes.getFechaNacimiento_paciente());
                yaSumado=true;
                totalAmbosSexos.setTotalPacientesSubprogramas(totalAmbosSexos.getTotalPacientesSubprogramas()+1);                
                if (pacientes.getGenero_paciente().equals("Masculino")) {                    
                        totalhombres.setTotalPacientesSubprogramas(totalhombres.getTotalPacientesSubprogramas()+1);
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setTotalPacientesSubprogramas(totalhombres_15a19.getTotalPacientesSubprogramas()+1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setTotalPacientesSubprogramas(totalhombres_20a24.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setTotalPacientesSubprogramas(totalhombres_25a29.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setTotalPacientesSubprogramas(totalhombres_30a34.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setTotalPacientesSubprogramas(totalhombres_35a39.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setTotalPacientesSubprogramas(totalhombres_40a44.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setTotalPacientesSubprogramas(totalhombres_45a49.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setTotalPacientesSubprogramas(totalhombres_50a54.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setTotalPacientesSubprogramas(totalhombres_55a59.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setTotalPacientesSubprogramas(totalhombres_60a64.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setTotalPacientesSubprogramas(totalhombres_65a69.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setTotalPacientesSubprogramas(totalhombres_70a74.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setTotalPacientesSubprogramas(totalhombres_75a79.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80amas.setTotalPacientesSubprogramas(totalhombres_80amas.getTotalPacientesSubprogramas()+ 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setTotalPacientesSubprogramas(totalmujeres.getTotalPacientesSubprogramas()+ 1);
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setTotalPacientesSubprogramas(totalmujeres_15a19.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setTotalPacientesSubprogramas(totalmujeres_20a24.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setTotalPacientesSubprogramas(totalmujeres_25a29.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setTotalPacientesSubprogramas(totalmujeres_30a34.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setTotalPacientesSubprogramas(totalmujeres_35a39.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setTotalPacientesSubprogramas(totalmujeres_40a44.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setTotalPacientesSubprogramas(totalmujeres_45a49.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setTotalPacientesSubprogramas(totalmujeres_50a54.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setTotalPacientesSubprogramas(totalmujeres_55a59.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setTotalPacientesSubprogramas(totalmujeres_60a64.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setTotalPacientesSubprogramas(totalmujeres_65a69.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setTotalPacientesSubprogramas(totalmujeres_70a74.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setTotalPacientesSubprogramas(totalmujeres_75a79.getTotalPacientesSubprogramas() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80amas.setTotalPacientesSubprogramas(totalmujeres_80amas.getTotalPacientesSubprogramas() + 1);
                        }
                    }
                
                for(Subprograma subprograma : subProg){
                    if (subprograma.getSubprograma().getNombre_subprograma().equals("Artrosis")) {//Artrosis
                        //siempre actualizar variable fue censado:
                        fue_censado = true;
                        totalAmbosSexos.setSubprogramaArtrosis(totalAmbosSexos.getSubprogramaArtrosis()+ 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setSubprogramaArtrosis(totalhombres.getSubprogramaArtrosis()+ 1);
                            //Dependiendo de la edad las condiciones son:
                            if (edad >= 15 && edad <= 19) {
                                totalhombres_15a19.setSubprogramaArtrosis(totalhombres_15a19.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 20 && edad <= 24) {
                                totalhombres_20a24.setSubprogramaArtrosis(totalhombres_20a24.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 25 && edad <= 29) {
                                totalhombres_25a29.setSubprogramaArtrosis(totalhombres_25a29.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 30 && edad <= 34) {
                                totalhombres_30a34.setSubprogramaArtrosis(totalhombres_30a34.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 35 && edad <= 39) {
                                totalhombres_35a39.setSubprogramaArtrosis(totalhombres_35a39.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 40 && edad <= 44) {
                                totalhombres_40a44.setSubprogramaArtrosis(totalhombres_40a44.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 45 && edad <= 49) {
                                totalhombres_45a49.setSubprogramaArtrosis(totalhombres_45a49.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 50 && edad <= 54) {
                                totalhombres_50a54.setSubprogramaArtrosis(totalhombres_50a54.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 55 && edad <= 59) {
                                totalhombres_55a59.setSubprogramaArtrosis(totalhombres_55a59.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 60 && edad <= 64) {
                                totalhombres_60a64.setSubprogramaArtrosis(totalhombres_60a64.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 65 && edad <= 69) {
                                totalhombres_65a69.setSubprogramaArtrosis(totalhombres_65a69.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                totalhombres_70a74.setSubprogramaArtrosis(totalhombres_70a74.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                totalhombres_75a79.setSubprogramaArtrosis(totalhombres_75a79.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 80) {
                                totalhombres_80amas.setSubprogramaArtrosis(totalhombres_80amas.getSubprogramaArtrosis() + 1);
                            }
                        } else {//Genero Femenino
                            totalmujeres.setSubprogramaArtrosis(totalmujeres.getSubprogramaArtrosis()+ 1);
                            //Dependiendo de la edad las condiciones son:
                            if (edad >= 15 && edad <= 19) {
                                totalmujeres_15a19.setSubprogramaArtrosis(totalmujeres_15a19.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 20 && edad <= 24) {
                                totalmujeres_20a24.setSubprogramaArtrosis(totalmujeres_20a24.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 25 && edad <= 29) {
                                totalmujeres_25a29.setSubprogramaArtrosis(totalmujeres_25a29.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 30 && edad <= 34) {
                                totalmujeres_30a34.setSubprogramaArtrosis(totalmujeres_30a34.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 35 && edad <= 39) {
                                totalmujeres_35a39.setSubprogramaArtrosis(totalmujeres_35a39.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 40 && edad <= 44) {
                                totalmujeres_40a44.setSubprogramaArtrosis(totalmujeres_40a44.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 45 && edad <= 49) {
                                totalmujeres_45a49.setSubprogramaArtrosis(totalmujeres_45a49.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 50 && edad <= 54) {
                                totalmujeres_50a54.setSubprogramaArtrosis(totalmujeres_50a54.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 55 && edad <= 59) {
                                totalmujeres_55a59.setSubprogramaArtrosis(totalmujeres_55a59.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 60 && edad <= 64) {
                                totalmujeres_60a64.setSubprogramaArtrosis(totalmujeres_60a64.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 65 && edad <= 69) {
                                totalmujeres_65a69.setSubprogramaArtrosis(totalmujeres_65a69.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                totalmujeres_70a74.setSubprogramaArtrosis(totalmujeres_70a74.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                totalmujeres_75a79.setSubprogramaArtrosis(totalmujeres_75a79.getSubprogramaArtrosis() + 1);
                            } else if (edad >= 80) {
                                totalmujeres_80amas.setSubprogramaArtrosis(totalmujeres_80amas.getSubprogramaArtrosis() + 1);
                            }
                        }
                    }
                    
                    if (subprograma.getSubprograma().getNombre_subprograma().equals("Epilepsia")) {//Epilepsia
                        //siempre actualizar variable fue censado:
                        fue_censado = true;
                        totalAmbosSexos.setSubprogramaEpilepsia(totalAmbosSexos.getSubprogramaEpilepsia()+ 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setSubprogramaEpilepsia(totalhombres.getSubprogramaEpilepsia()+ 1);
                            //Dependiendo de la edad las condiciones son:
                            if (edad >= 15 && edad <= 19) {
                                totalhombres_15a19.setSubprogramaEpilepsia(totalhombres_15a19.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 20 && edad <= 24) {
                                totalhombres_20a24.setSubprogramaEpilepsia(totalhombres_20a24.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 25 && edad <= 29) {
                                totalhombres_25a29.setSubprogramaEpilepsia(totalhombres_25a29.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 30 && edad <= 34) {
                                totalhombres_30a34.setSubprogramaEpilepsia(totalhombres_30a34.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 35 && edad <= 39) {
                                totalhombres_35a39.setSubprogramaEpilepsia(totalhombres_35a39.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 40 && edad <= 44) {
                                totalhombres_40a44.setSubprogramaEpilepsia(totalhombres_40a44.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 45 && edad <= 49) {
                                totalhombres_45a49.setSubprogramaEpilepsia(totalhombres_45a49.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 50 && edad <= 54) {
                                totalhombres_50a54.setSubprogramaEpilepsia(totalhombres_50a54.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 55 && edad <= 59) {
                                totalhombres_55a59.setSubprogramaEpilepsia(totalhombres_55a59.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 60 && edad <= 64) {
                                totalhombres_60a64.setSubprogramaEpilepsia(totalhombres_60a64.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 65 && edad <= 69) {
                                totalhombres_65a69.setSubprogramaEpilepsia(totalhombres_65a69.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                totalhombres_70a74.setSubprogramaEpilepsia(totalhombres_70a74.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                totalhombres_75a79.setSubprogramaEpilepsia(totalhombres_75a79.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 80) {
                                totalhombres_80amas.setSubprogramaEpilepsia(totalhombres_80amas.getSubprogramaEpilepsia() + 1);
                            }
                        } else {//Genero Femenino
                            totalmujeres.setSubprogramaEpilepsia(totalmujeres.getSubprogramaEpilepsia()+ 1);
                            //Dependiendo de la edad las condiciones son:
                            if (edad >= 15 && edad <= 19) {
                                totalmujeres_15a19.setSubprogramaEpilepsia(totalmujeres_15a19.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 20 && edad <= 24) {
                                totalmujeres_20a24.setSubprogramaEpilepsia(totalmujeres_20a24.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 25 && edad <= 29) {
                                totalmujeres_25a29.setSubprogramaEpilepsia(totalmujeres_25a29.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 30 && edad <= 34) {
                                totalmujeres_30a34.setSubprogramaEpilepsia(totalmujeres_30a34.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 35 && edad <= 39) {
                                totalmujeres_35a39.setSubprogramaEpilepsia(totalmujeres_35a39.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 40 && edad <= 44) {
                                totalmujeres_40a44.setSubprogramaEpilepsia(totalmujeres_40a44.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 45 && edad <= 49) {
                                totalmujeres_45a49.setSubprogramaEpilepsia(totalmujeres_45a49.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 50 && edad <= 54) {
                                totalmujeres_50a54.setSubprogramaEpilepsia(totalmujeres_50a54.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 55 && edad <= 59) {
                                totalmujeres_55a59.setSubprogramaEpilepsia(totalmujeres_55a59.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 60 && edad <= 64) {
                                totalmujeres_60a64.setSubprogramaEpilepsia(totalmujeres_60a64.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 65 && edad <= 69) {
                                totalmujeres_65a69.setSubprogramaEpilepsia(totalmujeres_65a69.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                totalmujeres_70a74.setSubprogramaEpilepsia(totalmujeres_70a74.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                totalmujeres_75a79.setSubprogramaEpilepsia(totalmujeres_75a79.getSubprogramaEpilepsia() + 1);
                            } else if (edad >= 80) {
                                totalmujeres_80amas.setSubprogramaEpilepsia(totalmujeres_80amas.getSubprogramaEpilepsia() + 1);
                            }
                        }
                    }
                    
                    if (subprograma.getSubprograma().getNombre_subprograma().equals("Hipotiroidismo")) {//Hipotiroidismo
                        //siempre actualizar variable fue censado:
                        fue_censado = true;
                        totalAmbosSexos.setSubprogramaHipotiroidismo(totalAmbosSexos.getSubprogramaHipotiroidismo()+ 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setSubprogramaHipotiroidismo(totalhombres.getSubprogramaHipotiroidismo()+ 1);
                            //Dependiendo de la edad las condiciones son:
                            if (edad >= 15 && edad <= 19) {
                                totalhombres_15a19.setSubprogramaHipotiroidismo(totalhombres_15a19.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 20 && edad <= 24) {
                                totalhombres_20a24.setSubprogramaHipotiroidismo(totalhombres_20a24.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 25 && edad <= 29) {
                                totalhombres_25a29.setSubprogramaHipotiroidismo(totalhombres_25a29.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 30 && edad <= 34) {
                                totalhombres_30a34.setSubprogramaHipotiroidismo(totalhombres_30a34.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 35 && edad <= 39) {
                                totalhombres_35a39.setSubprogramaHipotiroidismo(totalhombres_35a39.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 40 && edad <= 44) {
                                totalhombres_40a44.setSubprogramaHipotiroidismo(totalhombres_40a44.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 45 && edad <= 49) {
                                totalhombres_45a49.setSubprogramaHipotiroidismo(totalhombres_45a49.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 50 && edad <= 54) {
                                totalhombres_50a54.setSubprogramaHipotiroidismo(totalhombres_50a54.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 55 && edad <= 59) {
                                totalhombres_55a59.setSubprogramaHipotiroidismo(totalhombres_55a59.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 60 && edad <= 64) {
                                totalhombres_60a64.setSubprogramaHipotiroidismo(totalhombres_60a64.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 65 && edad <= 69) {
                                totalhombres_65a69.setSubprogramaHipotiroidismo(totalhombres_65a69.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                totalhombres_70a74.setSubprogramaHipotiroidismo(totalhombres_70a74.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                totalhombres_75a79.setSubprogramaHipotiroidismo(totalhombres_75a79.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 80) {
                                totalhombres_80amas.setSubprogramaHipotiroidismo(totalhombres_80amas.getSubprogramaHipotiroidismo() + 1);
                            }
                        } else {//Genero Femenino
                            totalmujeres.setSubprogramaHipotiroidismo(totalmujeres.getSubprogramaHipotiroidismo()+ 1);
                            //Dependiendo de la edad las condiciones son:
                            if (edad >= 15 && edad <= 19) {
                                totalmujeres_15a19.setSubprogramaHipotiroidismo(totalmujeres_15a19.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 20 && edad <= 24) {
                                totalmujeres_20a24.setSubprogramaHipotiroidismo(totalmujeres_20a24.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 25 && edad <= 29) {
                                totalmujeres_25a29.setSubprogramaHipotiroidismo(totalmujeres_25a29.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 30 && edad <= 34) {
                                totalmujeres_30a34.setSubprogramaHipotiroidismo(totalmujeres_30a34.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 35 && edad <= 39) {
                                totalmujeres_35a39.setSubprogramaHipotiroidismo(totalmujeres_35a39.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 40 && edad <= 44) {
                                totalmujeres_40a44.setSubprogramaHipotiroidismo(totalmujeres_40a44.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 45 && edad <= 49) {
                                totalmujeres_45a49.setSubprogramaHipotiroidismo(totalmujeres_45a49.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 50 && edad <= 54) {
                                totalmujeres_50a54.setSubprogramaHipotiroidismo(totalmujeres_50a54.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 55 && edad <= 59) {
                                totalmujeres_55a59.setSubprogramaHipotiroidismo(totalmujeres_55a59.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 60 && edad <= 64) {
                                totalmujeres_60a64.setSubprogramaHipotiroidismo(totalmujeres_60a64.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 65 && edad <= 69) {
                                totalmujeres_65a69.setSubprogramaHipotiroidismo(totalmujeres_65a69.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                totalmujeres_70a74.setSubprogramaHipotiroidismo(totalmujeres_70a74.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                totalmujeres_75a79.setSubprogramaHipotiroidismo(totalmujeres_75a79.getSubprogramaHipotiroidismo() + 1);
                            } else if (edad >= 80) {
                                totalmujeres_80amas.setSubprogramaHipotiroidismo(totalmujeres_80amas.getSubprogramaHipotiroidismo() + 1);
                            }
                        }
                    }
                    
                    if (subprograma.getSubprograma().getNombre_subprograma().equals("Parkinson")) {//Artrosis
                        //siempre actualizar variable fue censado:
                        fue_censado = true;
                        totalAmbosSexos.setSubprogramaParkinson(totalAmbosSexos.getSubprogramaParkinson()+ 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setSubprogramaParkinson(totalhombres.getSubprogramaParkinson()+ 1);
                            //Dependiendo de la edad las condiciones son:
                            if (edad >= 15 && edad <= 19) {
                                totalhombres_15a19.setSubprogramaParkinson(totalhombres_15a19.getSubprogramaParkinson() + 1);
                            } else if (edad >= 20 && edad <= 24) {
                                totalhombres_20a24.setSubprogramaParkinson(totalhombres_20a24.getSubprogramaParkinson() + 1);
                            } else if (edad >= 25 && edad <= 29) {
                                totalhombres_25a29.setSubprogramaParkinson(totalhombres_25a29.getSubprogramaParkinson() + 1);
                            } else if (edad >= 30 && edad <= 34) {
                                totalhombres_30a34.setSubprogramaParkinson(totalhombres_30a34.getSubprogramaParkinson() + 1);
                            } else if (edad >= 35 && edad <= 39) {
                                totalhombres_35a39.setSubprogramaParkinson(totalhombres_35a39.getSubprogramaParkinson() + 1);
                            } else if (edad >= 40 && edad <= 44) {
                                totalhombres_40a44.setSubprogramaParkinson(totalhombres_40a44.getSubprogramaParkinson() + 1);
                            } else if (edad >= 45 && edad <= 49) {
                                totalhombres_45a49.setSubprogramaParkinson(totalhombres_45a49.getSubprogramaParkinson() + 1);
                            } else if (edad >= 50 && edad <= 54) {
                                totalhombres_50a54.setSubprogramaParkinson(totalhombres_50a54.getSubprogramaParkinson() + 1);
                            } else if (edad >= 55 && edad <= 59) {
                                totalhombres_55a59.setSubprogramaParkinson(totalhombres_55a59.getSubprogramaParkinson() + 1);
                            } else if (edad >= 60 && edad <= 64) {
                                totalhombres_60a64.setSubprogramaParkinson(totalhombres_60a64.getSubprogramaParkinson() + 1);
                            } else if (edad >= 65 && edad <= 69) {
                                totalhombres_65a69.setSubprogramaParkinson(totalhombres_65a69.getSubprogramaParkinson() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                totalhombres_70a74.setSubprogramaParkinson(totalhombres_70a74.getSubprogramaParkinson() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                totalhombres_75a79.setSubprogramaParkinson(totalhombres_75a79.getSubprogramaParkinson() + 1);
                            } else if (edad >= 80) {
                                totalhombres_80amas.setSubprogramaParkinson(totalhombres_80amas.getSubprogramaParkinson() + 1);
                            }
                        } else {//Genero Femenino
                            totalmujeres.setSubprogramaParkinson(totalmujeres.getSubprogramaParkinson()+ 1);
                            //Dependiendo de la edad las condiciones son:
                            if (edad >= 15 && edad <= 19) {
                                totalmujeres_15a19.setSubprogramaParkinson(totalmujeres_15a19.getSubprogramaParkinson() + 1);
                            } else if (edad >= 20 && edad <= 24) {
                                totalmujeres_20a24.setSubprogramaParkinson(totalmujeres_20a24.getSubprogramaParkinson() + 1);
                            } else if (edad >= 25 && edad <= 29) {
                                totalmujeres_25a29.setSubprogramaParkinson(totalmujeres_25a29.getSubprogramaParkinson() + 1);
                            } else if (edad >= 30 && edad <= 34) {
                                totalmujeres_30a34.setSubprogramaParkinson(totalmujeres_30a34.getSubprogramaParkinson() + 1);
                            } else if (edad >= 35 && edad <= 39) {
                                totalmujeres_35a39.setSubprogramaParkinson(totalmujeres_35a39.getSubprogramaParkinson() + 1);
                            } else if (edad >= 40 && edad <= 44) {
                                totalmujeres_40a44.setSubprogramaParkinson(totalmujeres_40a44.getSubprogramaParkinson() + 1);
                            } else if (edad >= 45 && edad <= 49) {
                                totalmujeres_45a49.setSubprogramaParkinson(totalmujeres_45a49.getSubprogramaParkinson() + 1);
                            } else if (edad >= 50 && edad <= 54) {
                                totalmujeres_50a54.setSubprogramaParkinson(totalmujeres_50a54.getSubprogramaParkinson() + 1);
                            } else if (edad >= 55 && edad <= 59) {
                                totalmujeres_55a59.setSubprogramaParkinson(totalmujeres_55a59.getSubprogramaParkinson() + 1);
                            } else if (edad >= 60 && edad <= 64) {
                                totalmujeres_60a64.setSubprogramaParkinson(totalmujeres_60a64.getSubprogramaParkinson() + 1);
                            } else if (edad >= 65 && edad <= 69) {
                                totalmujeres_65a69.setSubprogramaParkinson(totalmujeres_65a69.getSubprogramaParkinson() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                totalmujeres_70a74.setSubprogramaParkinson(totalmujeres_70a74.getSubprogramaParkinson() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                totalmujeres_75a79.setSubprogramaParkinson(totalmujeres_75a79.getSubprogramaParkinson() + 1);
                            } else if (edad >= 80) {
                                totalmujeres_80amas.setSubprogramaParkinson(totalmujeres_80amas.getSubprogramaParkinson() + 1);
                            }
                        }
                    }
                    
                    if (subprograma.getSubprograma().getNombre_subprograma().equals("ERA")) {//Era
                        //siempre actualizar variable fue censado:
                        fue_censado = true;
                        totalAmbosSexos.setSubprogramaERA(totalAmbosSexos.getSubprogramaERA()+ 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setSubprogramaERA(totalhombres.getSubprogramaERA()+ 1);
                            //Dependiendo de la edad las condiciones son:
                            if (edad >= 15 && edad <= 19) {
                                totalhombres_15a19.setSubprogramaERA(totalhombres_15a19.getSubprogramaERA() + 1);
                            } else if (edad >= 20 && edad <= 24) {
                                totalhombres_20a24.setSubprogramaERA(totalhombres_20a24.getSubprogramaERA() + 1);
                            } else if (edad >= 25 && edad <= 29) {
                                totalhombres_25a29.setSubprogramaERA(totalhombres_25a29.getSubprogramaERA() + 1);
                            } else if (edad >= 30 && edad <= 34) {
                                totalhombres_30a34.setSubprogramaERA(totalhombres_30a34.getSubprogramaERA() + 1);
                            } else if (edad >= 35 && edad <= 39) {
                                totalhombres_35a39.setSubprogramaERA(totalhombres_35a39.getSubprogramaERA() + 1);
                            } else if (edad >= 40 && edad <= 44) {
                                totalhombres_40a44.setSubprogramaERA(totalhombres_40a44.getSubprogramaERA() + 1);
                            } else if (edad >= 45 && edad <= 49) {
                                totalhombres_45a49.setSubprogramaERA(totalhombres_45a49.getSubprogramaERA() + 1);
                            } else if (edad >= 50 && edad <= 54) {
                                totalhombres_50a54.setSubprogramaERA(totalhombres_50a54.getSubprogramaERA() + 1);
                            } else if (edad >= 55 && edad <= 59) {
                                totalhombres_55a59.setSubprogramaERA(totalhombres_55a59.getSubprogramaERA() + 1);
                            } else if (edad >= 60 && edad <= 64) {
                                totalhombres_60a64.setSubprogramaERA(totalhombres_60a64.getSubprogramaERA() + 1);
                            } else if (edad >= 65 && edad <= 69) {
                                totalhombres_65a69.setSubprogramaERA(totalhombres_65a69.getSubprogramaERA() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                totalhombres_70a74.setSubprogramaERA(totalhombres_70a74.getSubprogramaERA() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                totalhombres_75a79.setSubprogramaERA(totalhombres_75a79.getSubprogramaERA() + 1);
                            } else if (edad >= 80) {
                                totalhombres_80amas.setSubprogramaERA(totalhombres_80amas.getSubprogramaERA() + 1);
                            }
                        } else {//Genero Femenino
                            totalmujeres.setSubprogramaERA(totalmujeres.getSubprogramaERA()+ 1);
                            //Dependiendo de la edad las condiciones son:
                            if (edad >= 15 && edad <= 19) {
                                totalmujeres_15a19.setSubprogramaERA(totalmujeres_15a19.getSubprogramaERA() + 1);
                            } else if (edad >= 20 && edad <= 24) {
                                totalmujeres_20a24.setSubprogramaERA(totalmujeres_20a24.getSubprogramaERA() + 1);
                            } else if (edad >= 25 && edad <= 29) {
                                totalmujeres_25a29.setSubprogramaERA(totalmujeres_25a29.getSubprogramaERA() + 1);
                            } else if (edad >= 30 && edad <= 34) {
                                totalmujeres_30a34.setSubprogramaERA(totalmujeres_30a34.getSubprogramaERA() + 1);
                            } else if (edad >= 35 && edad <= 39) {
                                totalmujeres_35a39.setSubprogramaERA(totalmujeres_35a39.getSubprogramaERA() + 1);
                            } else if (edad >= 40 && edad <= 44) {
                                totalmujeres_40a44.setSubprogramaERA(totalmujeres_40a44.getSubprogramaERA() + 1);
                            } else if (edad >= 45 && edad <= 49) {
                                totalmujeres_45a49.setSubprogramaERA(totalmujeres_45a49.getSubprogramaERA() + 1);
                            } else if (edad >= 50 && edad <= 54) {
                                totalmujeres_50a54.setSubprogramaERA(totalmujeres_50a54.getSubprogramaERA() + 1);
                            } else if (edad >= 55 && edad <= 59) {
                                totalmujeres_55a59.setSubprogramaERA(totalmujeres_55a59.getSubprogramaERA() + 1);
                            } else if (edad >= 60 && edad <= 64) {
                                totalmujeres_60a64.setSubprogramaERA(totalmujeres_60a64.getSubprogramaERA() + 1);
                            } else if (edad >= 65 && edad <= 69) {
                                totalmujeres_65a69.setSubprogramaERA(totalmujeres_65a69.getSubprogramaERA() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                totalmujeres_70a74.setSubprogramaERA(totalmujeres_70a74.getSubprogramaERA() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                totalmujeres_75a79.setSubprogramaERA(totalmujeres_75a79.getSubprogramaERA() + 1);
                            } else if (edad >= 80) {
                                totalmujeres_80amas.setSubprogramaERA(totalmujeres_80amas.getSubprogramaERA() + 1);
                            }
                        }
                    }
                }
            }
            subIRA = ejbIRA.findbyPaciente(pacientes);
            if(subIRA.size()>0){
                    edad = pacienteProg.Age(pacientes.getFechaNacimiento_paciente());
                    if(!yaSumado){
                        totalAmbosSexos.setTotalPacientesSubprogramas(totalAmbosSexos.getTotalPacientesSubprogramas()+1);                
                        if (pacientes.getGenero_paciente().equals("Masculino")) {                    
                                totalhombres.setTotalPacientesSubprogramas(totalhombres.getTotalPacientesSubprogramas()+1);
                                if (edad >= 15 && edad <= 19) {
                                    totalhombres_15a19.setTotalPacientesSubprogramas(totalhombres_15a19.getTotalPacientesSubprogramas()+1);
                                } else if (edad >= 20 && edad <= 24) {
                                    totalhombres_20a24.setTotalPacientesSubprogramas(totalhombres_20a24.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 25 && edad <= 29) {
                                    totalhombres_25a29.setTotalPacientesSubprogramas(totalhombres_25a29.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 30 && edad <= 34) {
                                    totalhombres_30a34.setTotalPacientesSubprogramas(totalhombres_30a34.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 35 && edad <= 39) {
                                    totalhombres_35a39.setTotalPacientesSubprogramas(totalhombres_35a39.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 40 && edad <= 44) {
                                    totalhombres_40a44.setTotalPacientesSubprogramas(totalhombres_40a44.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 45 && edad <= 49) {
                                    totalhombres_45a49.setTotalPacientesSubprogramas(totalhombres_45a49.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 50 && edad <= 54) {
                                    totalhombres_50a54.setTotalPacientesSubprogramas(totalhombres_50a54.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 55 && edad <= 59) {
                                    totalhombres_55a59.setTotalPacientesSubprogramas(totalhombres_55a59.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 60 && edad <= 64) {
                                    totalhombres_60a64.setTotalPacientesSubprogramas(totalhombres_60a64.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 65 && edad <= 69) {
                                    totalhombres_65a69.setTotalPacientesSubprogramas(totalhombres_65a69.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 70 && edad <= 74) {
                                    totalhombres_70a74.setTotalPacientesSubprogramas(totalhombres_70a74.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 75 && edad <= 79) {
                                    totalhombres_75a79.setTotalPacientesSubprogramas(totalhombres_75a79.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 80) {
                                    totalhombres_80amas.setTotalPacientesSubprogramas(totalhombres_80amas.getTotalPacientesSubprogramas()+ 1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setTotalPacientesSubprogramas(totalmujeres.getTotalPacientesSubprogramas()+ 1);
                                //Dependiendo de la edad las condiciones son:
                                if (edad >= 15 && edad <= 19) {
                                    totalmujeres_15a19.setTotalPacientesSubprogramas(totalmujeres_15a19.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 20 && edad <= 24) {
                                    totalmujeres_20a24.setTotalPacientesSubprogramas(totalmujeres_20a24.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 25 && edad <= 29) {
                                    totalmujeres_25a29.setTotalPacientesSubprogramas(totalmujeres_25a29.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 30 && edad <= 34) {
                                    totalmujeres_30a34.setTotalPacientesSubprogramas(totalmujeres_30a34.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 35 && edad <= 39) {
                                    totalmujeres_35a39.setTotalPacientesSubprogramas(totalmujeres_35a39.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 40 && edad <= 44) {
                                    totalmujeres_40a44.setTotalPacientesSubprogramas(totalmujeres_40a44.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 45 && edad <= 49) {
                                    totalmujeres_45a49.setTotalPacientesSubprogramas(totalmujeres_45a49.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 50 && edad <= 54) {
                                    totalmujeres_50a54.setTotalPacientesSubprogramas(totalmujeres_50a54.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 55 && edad <= 59) {
                                    totalmujeres_55a59.setTotalPacientesSubprogramas(totalmujeres_55a59.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 60 && edad <= 64) {
                                    totalmujeres_60a64.setTotalPacientesSubprogramas(totalmujeres_60a64.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 65 && edad <= 69) {
                                    totalmujeres_65a69.setTotalPacientesSubprogramas(totalmujeres_65a69.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 70 && edad <= 74) {
                                    totalmujeres_70a74.setTotalPacientesSubprogramas(totalmujeres_70a74.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 75 && edad <= 79) {
                                    totalmujeres_75a79.setTotalPacientesSubprogramas(totalmujeres_75a79.getTotalPacientesSubprogramas() + 1);
                                } else if (edad >= 80) {
                                    totalmujeres_80amas.setTotalPacientesSubprogramas(totalmujeres_80amas.getTotalPacientesSubprogramas() + 1);
                                }
                            }
                        }

                            fue_censado = true;
                            totalAmbosSexos.setSubprogramaIRA(totalAmbosSexos.getSubprogramaIRA()+ 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                totalhombres.setSubprogramaIRA(totalhombres.getSubprogramaIRA()+ 1);
                                //Dependiendo de la edad las condiciones son:
                                if (edad >= 15 && edad <= 19) {
                                    totalhombres_15a19.setSubprogramaIRA(totalhombres_15a19.getSubprogramaIRA() + 1);
                                } else if (edad >= 20 && edad <= 24) {
                                    totalhombres_20a24.setSubprogramaIRA(totalhombres_20a24.getSubprogramaIRA() + 1);
                                } else if (edad >= 25 && edad <= 29) {
                                    totalhombres_25a29.setSubprogramaIRA(totalhombres_25a29.getSubprogramaIRA() + 1);
                                } else if (edad >= 30 && edad <= 34) {
                                    totalhombres_30a34.setSubprogramaIRA(totalhombres_30a34.getSubprogramaIRA() + 1);
                                } else if (edad >= 35 && edad <= 39) {
                                    totalhombres_35a39.setSubprogramaIRA(totalhombres_35a39.getSubprogramaIRA() + 1);
                                } else if (edad >= 40 && edad <= 44) {
                                    totalhombres_40a44.setSubprogramaIRA(totalhombres_40a44.getSubprogramaIRA() + 1);
                                } else if (edad >= 45 && edad <= 49) {
                                    totalhombres_45a49.setSubprogramaIRA(totalhombres_45a49.getSubprogramaIRA() + 1);
                                } else if (edad >= 50 && edad <= 54) {
                                    totalhombres_50a54.setSubprogramaIRA(totalhombres_50a54.getSubprogramaIRA() + 1);
                                } else if (edad >= 55 && edad <= 59) {
                                    totalhombres_55a59.setSubprogramaIRA(totalhombres_55a59.getSubprogramaIRA() + 1);
                                } else if (edad >= 60 && edad <= 64) {
                                    totalhombres_60a64.setSubprogramaIRA(totalhombres_60a64.getSubprogramaIRA() + 1);
                                } else if (edad >= 65 && edad <= 69) {
                                    totalhombres_65a69.setSubprogramaIRA(totalhombres_65a69.getSubprogramaIRA() + 1);
                                } else if (edad >= 70 && edad <= 74) {
                                    totalhombres_70a74.setSubprogramaIRA(totalhombres_70a74.getSubprogramaIRA() + 1);
                                } else if (edad >= 75 && edad <= 79) {
                                    totalhombres_75a79.setSubprogramaIRA(totalhombres_75a79.getSubprogramaIRA() + 1);
                                } else if (edad >= 80) {
                                    totalhombres_80amas.setSubprogramaIRA(totalhombres_80amas.getSubprogramaIRA() + 1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setSubprogramaIRA(totalmujeres.getSubprogramaIRA()+ 1);
                                //Dependiendo de la edad las condiciones son:
                                if (edad >= 15 && edad <= 19) {
                                    totalmujeres_15a19.setSubprogramaIRA(totalmujeres_15a19.getSubprogramaIRA() + 1);
                                } else if (edad >= 20 && edad <= 24) {
                                    totalmujeres_20a24.setSubprogramaIRA(totalmujeres_20a24.getSubprogramaIRA() + 1);
                                } else if (edad >= 25 && edad <= 29) {
                                    totalmujeres_25a29.setSubprogramaIRA(totalmujeres_25a29.getSubprogramaIRA() + 1);
                                } else if (edad >= 30 && edad <= 34) {
                                    totalmujeres_30a34.setSubprogramaIRA(totalmujeres_30a34.getSubprogramaIRA() + 1);
                                } else if (edad >= 35 && edad <= 39) {
                                    totalmujeres_35a39.setSubprogramaIRA(totalmujeres_35a39.getSubprogramaIRA() + 1);
                                } else if (edad >= 40 && edad <= 44) {
                                    totalmujeres_40a44.setSubprogramaIRA(totalmujeres_40a44.getSubprogramaIRA() + 1);
                                } else if (edad >= 45 && edad <= 49) {
                                    totalmujeres_45a49.setSubprogramaIRA(totalmujeres_45a49.getSubprogramaIRA() + 1);
                                } else if (edad >= 50 && edad <= 54) {
                                    totalmujeres_50a54.setSubprogramaIRA(totalmujeres_50a54.getSubprogramaIRA() + 1);
                                } else if (edad >= 55 && edad <= 59) {
                                    totalmujeres_55a59.setSubprogramaIRA(totalmujeres_55a59.getSubprogramaIRA() + 1);
                                } else if (edad >= 60 && edad <= 64) {
                                    totalmujeres_60a64.setSubprogramaIRA(totalmujeres_60a64.getSubprogramaIRA() + 1);
                                } else if (edad >= 65 && edad <= 69) {
                                    totalmujeres_65a69.setSubprogramaIRA(totalmujeres_65a69.getSubprogramaIRA() + 1);
                                } else if (edad >= 70 && edad <= 74) {
                                    totalmujeres_70a74.setSubprogramaIRA(totalmujeres_70a74.getSubprogramaIRA() + 1);
                                } else if (edad >= 75 && edad <= 79) {
                                    totalmujeres_75a79.setSubprogramaIRA(totalmujeres_75a79.getSubprogramaIRA() + 1);
                                } else if (edad >= 80) {
                                    totalmujeres_80amas.setSubprogramaIRA(totalmujeres_80amas.getSubprogramaIRA() + 1);
                                }
                            }
            
                }
            
        }
        
        totalAmbosSexos.setColumnName1("Total Ambos Sexos");
        totalhombres.setColumnName1("Total Hombres");
        totalmujeres.setColumnName1("Total Mujeres");
        totalhombres_15a19.setColumnName1("Hombres de 15 a 19 años");
        totalmujeres_15a19.setColumnName1("Mujeres 15 a 19 años");
        totalhombres_20a24.setColumnName1("Hombres de 20 a 24 años");
        totalmujeres_20a24.setColumnName1("Mujeres 20 a 24 años");
        totalhombres_25a29.setColumnName1("Hombres de 25 a 29 años");
        totalmujeres_25a29.setColumnName1("Mujeres 25 a 29 años");
        totalhombres_30a34.setColumnName1("Hombres de 30 a 34 años");
        totalmujeres_30a34.setColumnName1("Mujeres 30 a 34 años");
        totalhombres_35a39.setColumnName1("Hombres de 35 a 39 años");
        totalmujeres_35a39.setColumnName1("Mujeres 35 a 39 años");
        totalhombres_40a44.setColumnName1("Hombres de 40 a 44 años");
        totalmujeres_40a44.setColumnName1("Mujeres 40 a 44 años");
        totalhombres_45a49.setColumnName1("Hombres de 45 a 49 años");
        totalmujeres_45a49.setColumnName1("Mujeres 45 a 49 años");
        totalhombres_50a54.setColumnName1("Hombres de 50 a 54 años");
        totalmujeres_50a54.setColumnName1("Mujeres 50 a 54 años");
        totalhombres_55a59.setColumnName1("Hombres de 55 a 59 años");
        totalmujeres_55a59.setColumnName1("Mujeres 55 a 59 años");
        totalhombres_60a64.setColumnName1("Hombres de 60 a 64 años");
        totalmujeres_60a64.setColumnName1("Mujeres 60 a 64 años");
        totalhombres_65a69.setColumnName1("Hombres de 65 a 69 años");
        totalmujeres_65a69.setColumnName1("Mujeres 65 a 69 años");
        totalhombres_70a74.setColumnName1("Hombres de 70 a 74 años");
        totalmujeres_70a74.setColumnName1("Mujeres 70 a 74 años");
        totalhombres_75a79.setColumnName1("Hombres de 75 a 79 años");
        totalmujeres_75a79.setColumnName1("Mujeres 75 a 79 años");
        totalhombres_80amas.setColumnName1("Hombres de 80 más años");
        totalmujeres_80amas.setColumnName1("Mujeres de 80 o más años");

        censoSubprogramas.clear();
        censoSubprogramas.add(totalAmbosSexos);
        censoSubprogramas.add(totalhombres);
        censoSubprogramas.add(totalmujeres);
        censoSubprogramas.add(totalhombres_15a19);
        censoSubprogramas.add(totalmujeres_15a19);

        censoSubprogramas.add(totalhombres_20a24);
        censoSubprogramas.add(totalmujeres_20a24);

        censoSubprogramas.add(totalhombres_25a29);
        censoSubprogramas.add(totalmujeres_25a29);

        censoSubprogramas.add(totalhombres_30a34);
        censoSubprogramas.add(totalmujeres_30a34);

        censoSubprogramas.add(totalhombres_35a39);
        censoSubprogramas.add(totalmujeres_35a39);

        censoSubprogramas.add(totalhombres_40a44);
        censoSubprogramas.add(totalmujeres_40a44);

        censoSubprogramas.add(totalhombres_45a49);
        censoSubprogramas.add(totalmujeres_45a49);

        censoSubprogramas.add(totalhombres_50a54);
        censoSubprogramas.add(totalmujeres_50a54);

        censoSubprogramas.add(totalhombres_55a59);
        censoSubprogramas.add(totalmujeres_55a59);

        censoSubprogramas.add(totalhombres_60a64);
        censoSubprogramas.add(totalmujeres_60a64);

        censoSubprogramas.add(totalhombres_65a69);
        censoSubprogramas.add(totalmujeres_65a69);

        censoSubprogramas.add(totalhombres_70a74);
        censoSubprogramas.add(totalmujeres_70a74);

        censoSubprogramas.add(totalhombres_75a79);
        censoSubprogramas.add(totalmujeres_75a79);

        censoSubprogramas.add(totalhombres_80amas);
        censoSubprogramas.add(totalmujeres_80amas);
        
        return censoSubprogramas;
    }
    
    public ConsultasCensoSubprogramas() {
    }
    
}
