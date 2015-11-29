package managedbeans.cardiovascular.censo;

import entities.Paciente;
import entities.cardiovascular.CartolaSeguimientoCCV;
import javax.inject.Named;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import managedbeans.PacienteController;
import org.joda.time.DateTime;
import org.joda.time.Days;
import sessionbeans.PacienteFacadeLocal;
import sessionbeans.cardiovascular.CartolaSeguimientoCCVFacadeLocal;

/**
 *
 * @author matias
 */
@Named(value = "consultasCensoCCV")
@SessionScoped
public class ConsultasCensoCCV implements Serializable {

    private List<CensoCCVSeccionA> A_elementos = new ArrayList<>();
    private List<CensoCCVSeccionB> B_elementos = new ArrayList<>();
    private List<CensoCCVSeccionC> C_elementos = new ArrayList<>();
    private List<CensoCCVExcluidos> Pacientes_excluidos;
    @EJB
    private PacienteFacadeLocal ejbPaciente;
    @EJB
    private CartolaSeguimientoCCVFacadeLocal ejbCartola;

    public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Carga completada", "Carga completada"));
    }

    public void onCancel() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Progress Cancelled", "Progress Cancelled"));
    }

    public void init() {
        Pacientes_excluidos = new ArrayList<>();
        A_elementos = censoCCVSeccionA();
        B_elementos = censoCCVSeccionB();
        C_elementos = censoCCVSeccionC();

        //agregamos pacientes excluidos inhabilitados
        List<Paciente> pasivos_fallecimiento = ejbPaciente.findbyPacientePasivoFallecimiento();
        List<Paciente> pasivos_prevision = ejbPaciente.findbyPacientePasivoPrevision();
        List<Paciente> pasivos_trasalado = ejbPaciente.findbyPacientePasivoTraslado();

        for (Paciente fallecidos : pasivos_fallecimiento) {
            CensoCCVExcluidos nocensado = new CensoCCVExcluidos();
            nocensado.setNombre(fallecidos.getNombres_paciente());
            nocensado.setApellidop(fallecidos.getApellidoPaterno_paciente());
            nocensado.setApellidom(fallecidos.getApellidoMaterno_paciente());
            PacienteController p = new PacienteController();
            nocensado.setEdad(p.Age(fallecidos.getFechaNacimiento_paciente()));
            nocensado.setRut(fallecidos.getRut_paciente());
            nocensado.setRazon_exclusion("Pasivo por Fallecimiento");
            Pacientes_excluidos.add(nocensado);
        }

        for (Paciente prevision : pasivos_prevision) {
            CensoCCVExcluidos nocensado = new CensoCCVExcluidos();
            nocensado.setNombre(prevision.getNombres_paciente());
            nocensado.setApellidop(prevision.getApellidoPaterno_paciente());
            nocensado.setApellidom(prevision.getApellidoMaterno_paciente());
            PacienteController p = new PacienteController();
            nocensado.setEdad(p.Age(prevision.getFechaNacimiento_paciente()));
            nocensado.setRut(prevision.getRut_paciente());
            nocensado.setRazon_exclusion("Pasivo por Prevision");
            Pacientes_excluidos.add(nocensado);
        }

        for (Paciente traslado : pasivos_trasalado) {
            CensoCCVExcluidos nocensado = new CensoCCVExcluidos();
            nocensado.setNombre(traslado.getNombres_paciente());
            nocensado.setApellidop(traslado.getApellidoPaterno_paciente());
            nocensado.setApellidom(traslado.getApellidoMaterno_paciente());
            PacienteController p = new PacienteController();
            nocensado.setEdad(p.Age(traslado.getFechaNacimiento_paciente()));
            nocensado.setRut(traslado.getRut_paciente());
            nocensado.setRazon_exclusion("Pasivo por Traslado");
            Pacientes_excluidos.add(nocensado);
        }
    }

    public List<CensoCCVExcluidos> getPacientes_excluidos() {
        return Pacientes_excluidos;
    }

    public void setPacientes_excluidos(List<CensoCCVExcluidos> Pacientes_excluidos) {
        this.Pacientes_excluidos = Pacientes_excluidos;
    }

    public List<CensoCCVSeccionA> getA_elementos() {
        return A_elementos;
    }

    public void setA_elementos(List<CensoCCVSeccionA> A_elementos) {
        this.A_elementos = A_elementos;
    }

    public List<CensoCCVSeccionB> getB_elementos() {
        return B_elementos;
    }

    public void setB_elementos(List<CensoCCVSeccionB> B_elementos) {
        this.B_elementos = B_elementos;
    }

    public List<CensoCCVSeccionC> getC_elementos() {
        return C_elementos;
    }

    public void setC_elementos(List<CensoCCVSeccionC> C_elementos) {
        this.C_elementos = C_elementos;
    }
    //Facades

    public PacienteFacadeLocal getEjbPaciente() {
        return ejbPaciente;
    }

    public void setEjbPaciente(PacienteFacadeLocal ejbPaciente) {
        this.ejbPaciente = ejbPaciente;
    }

    public CartolaSeguimientoCCVFacadeLocal getEjbCartola() {
        return ejbCartola;
    }

    public void setEjbCartola(CartolaSeguimientoCCVFacadeLocal ejbCartola) {
        this.ejbCartola = ejbCartola;
    }

    public List<CensoCCVSeccionA> censoCCVSeccionA() {

        Pacientes_excluidos.clear();
        CensoCCVSeccionA totalAmbosSexos = new CensoCCVSeccionA();
        CensoCCVSeccionA totalhombres = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres = new CensoCCVSeccionA();
        CensoCCVSeccionA totalhombres_15a19 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_15a19 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalhombres_20a24 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_20a24 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalhombres_25a29 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_25a29 = new CensoCCVSeccionA();

        CensoCCVSeccionA totalhombres_30a34 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_30a34 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalhombres_35a39 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_35a39 = new CensoCCVSeccionA();

        CensoCCVSeccionA totalhombres_40a44 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_40a44 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalhombres_45a49 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_45a49 = new CensoCCVSeccionA();

        CensoCCVSeccionA totalhombres_50a54 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_50a54 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalhombres_55a59 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_55a59 = new CensoCCVSeccionA();

        CensoCCVSeccionA totalhombres_60a64 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_60a64 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalhombres_65a69 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_65a69 = new CensoCCVSeccionA();

        CensoCCVSeccionA totalhombres_70a74 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_70a74 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalhombres_75a79 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_75a79 = new CensoCCVSeccionA();
        CensoCCVSeccionA totalhombres_80omas = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_80omas = new CensoCCVSeccionA();
        CensoCCVSeccionA totalhombres_pueblos = new CensoCCVSeccionA();
        CensoCCVSeccionA totalmujeres_pueblos = new CensoCCVSeccionA();
        CensoCCVSeccionA total_diabeticos = new CensoCCVSeccionA();
        List<Paciente> pacientes_habilitados = ejbPaciente.findbyPacienteActivo();
        List<CartolaSeguimientoCCV> ccv;
        List<CartolaSeguimientoCCV> ccv_filtro;
        List<CartolaSeguimientoCCV> ccv_ordenado;
        boolean resultados[];
        for (Paciente pacientes : pacientes_habilitados) {
            boolean fue_censado = false;
            int edad;
            boolean registra_unaatencion = false;

            ccv = ejbCartola.findByPaciente(pacientes);//obtengo todas las cartolas por  pacientes
            if (ccv.size() > 0) {
                registra_unaatencion = true;
            }
            ccv_ordenado = filtro(ccv);
            ccv_filtro = filtro_censables(ccv_ordenado);//se ordenan las cartolas, y se filtran solo als que entran al censo

            //en este punto por paciente tenemos las cartola que entran en el censo 
            //filtramos por paciente si su ultima cartola , la fecha mas alta que tiene es censable
            if (ccv_filtro.size() > 0) {//si tiene un elemento censable

                edad = ccv_filtro.get(ccv_filtro.size() - 1).getEdad_paciente();
                if (ccv_filtro.get(ccv_filtro.size() - 1).getRiesgo_cardiovascular().equals("BAJO")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setClasificacionRiesgoCCVBajo(totalAmbosSexos.getClasificacionRiesgoCCVBajo() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setClasificacionRiesgoCCVBajo(total_diabeticos.getClasificacionRiesgoCCVBajo() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setClasificacionRiesgoCCVBajo(totalhombres.getClasificacionRiesgoCCVBajo() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setClasificacionRiesgoCCVBajo(totalhombres_pueblos.getClasificacionRiesgoCCVBajo() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setClasificacionRiesgoCCVBajo(totalhombres_15a19.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setClasificacionRiesgoCCVBajo(totalhombres_20a24.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setClasificacionRiesgoCCVBajo(totalhombres_25a29.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setClasificacionRiesgoCCVBajo(totalhombres_30a34.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setClasificacionRiesgoCCVBajo(totalhombres_35a39.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setClasificacionRiesgoCCVBajo(totalhombres_40a44.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setClasificacionRiesgoCCVBajo(totalhombres_45a49.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setClasificacionRiesgoCCVBajo(totalhombres_50a54.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setClasificacionRiesgoCCVBajo(totalhombres_55a59.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setClasificacionRiesgoCCVBajo(totalhombres_60a64.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setClasificacionRiesgoCCVBajo(totalhombres_65a69.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setClasificacionRiesgoCCVBajo(totalhombres_70a74.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setClasificacionRiesgoCCVBajo(totalhombres_75a79.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setClasificacionRiesgoCCVBajo(totalhombres_80omas.getClasificacionRiesgoCCVBajo() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setClasificacionRiesgoCCVBajo(totalmujeres.getClasificacionRiesgoCCVBajo() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setClasificacionRiesgoCCVBajo(totalmujeres_pueblos.getClasificacionRiesgoCCVBajo() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setClasificacionRiesgoCCVBajo(totalmujeres_15a19.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setClasificacionRiesgoCCVBajo(totalmujeres_20a24.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setClasificacionRiesgoCCVBajo(totalmujeres_25a29.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setClasificacionRiesgoCCVBajo(totalmujeres_30a34.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setClasificacionRiesgoCCVBajo(totalmujeres_35a39.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setClasificacionRiesgoCCVBajo(totalmujeres_40a44.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setClasificacionRiesgoCCVBajo(totalmujeres_45a49.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setClasificacionRiesgoCCVBajo(totalmujeres_50a54.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setClasificacionRiesgoCCVBajo(totalmujeres_55a59.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setClasificacionRiesgoCCVBajo(totalmujeres_60a64.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setClasificacionRiesgoCCVBajo(totalmujeres_65a69.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setClasificacionRiesgoCCVBajo(totalmujeres_70a74.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setClasificacionRiesgoCCVBajo(totalmujeres_75a79.getClasificacionRiesgoCCVBajo() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setClasificacionRiesgoCCVBajo(totalmujeres_80omas.getClasificacionRiesgoCCVBajo() + 1);
                        }

                    }
                }//FIN riesgo bajo

                if (ccv_filtro.get(ccv_filtro.size() - 1).getRiesgo_cardiovascular().equals("MODERADO")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setClasificacionRiesgoCCVModerado(totalAmbosSexos.getClasificacionRiesgoCCVModerado() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setClasificacionRiesgoCCVModerado(total_diabeticos.getClasificacionRiesgoCCVModerado() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setClasificacionRiesgoCCVModerado(totalhombres.getClasificacionRiesgoCCVModerado() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setClasificacionRiesgoCCVModerado(totalhombres_pueblos.getClasificacionRiesgoCCVModerado() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setClasificacionRiesgoCCVModerado(totalhombres_15a19.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setClasificacionRiesgoCCVModerado(totalhombres_20a24.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setClasificacionRiesgoCCVModerado(totalhombres_25a29.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setClasificacionRiesgoCCVModerado(totalhombres_30a34.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setClasificacionRiesgoCCVModerado(totalhombres_35a39.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setClasificacionRiesgoCCVModerado(totalhombres_40a44.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setClasificacionRiesgoCCVModerado(totalhombres_45a49.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setClasificacionRiesgoCCVModerado(totalhombres_50a54.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setClasificacionRiesgoCCVModerado(totalhombres_55a59.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setClasificacionRiesgoCCVModerado(totalhombres_60a64.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setClasificacionRiesgoCCVModerado(totalhombres_65a69.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setClasificacionRiesgoCCVModerado(totalhombres_70a74.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setClasificacionRiesgoCCVModerado(totalhombres_75a79.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setClasificacionRiesgoCCVModerado(totalhombres_80omas.getClasificacionRiesgoCCVModerado() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setClasificacionRiesgoCCVModerado(totalmujeres.getClasificacionRiesgoCCVModerado() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setClasificacionRiesgoCCVModerado(totalmujeres_pueblos.getClasificacionRiesgoCCVModerado() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setClasificacionRiesgoCCVModerado(totalmujeres_15a19.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setClasificacionRiesgoCCVModerado(totalmujeres_20a24.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setClasificacionRiesgoCCVModerado(totalmujeres_25a29.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setClasificacionRiesgoCCVModerado(totalmujeres_30a34.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setClasificacionRiesgoCCVModerado(totalmujeres_35a39.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setClasificacionRiesgoCCVModerado(totalmujeres_40a44.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setClasificacionRiesgoCCVModerado(totalmujeres_45a49.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setClasificacionRiesgoCCVModerado(totalmujeres_50a54.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setClasificacionRiesgoCCVModerado(totalmujeres_55a59.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setClasificacionRiesgoCCVModerado(totalmujeres_60a64.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setClasificacionRiesgoCCVModerado(totalmujeres_65a69.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setClasificacionRiesgoCCVModerado(totalmujeres_70a74.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setClasificacionRiesgoCCVModerado(totalmujeres_75a79.getClasificacionRiesgoCCVModerado() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setClasificacionRiesgoCCVModerado(totalmujeres_80omas.getClasificacionRiesgoCCVModerado() + 1);
                        }

                    }
                }//FIN riesgo moderado

                if (ccv_filtro.get(ccv_filtro.size() - 1).getRiesgo_cardiovascular().equals("ALTO")) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setClasificacionRiesgoCCVAlto(totalAmbosSexos.getClasificacionRiesgoCCVAlto() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setClasificacionRiesgoCCVAlto(total_diabeticos.getClasificacionRiesgoCCVAlto() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setClasificacionRiesgoCCVAlto(totalhombres.getClasificacionRiesgoCCVAlto() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setClasificacionRiesgoCCVAlto(totalhombres_pueblos.getClasificacionRiesgoCCVAlto() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setClasificacionRiesgoCCVAlto(totalhombres_15a19.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setClasificacionRiesgoCCVAlto(totalhombres_20a24.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setClasificacionRiesgoCCVAlto(totalhombres_25a29.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setClasificacionRiesgoCCVAlto(totalhombres_30a34.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setClasificacionRiesgoCCVAlto(totalhombres_35a39.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setClasificacionRiesgoCCVAlto(totalhombres_40a44.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setClasificacionRiesgoCCVAlto(totalhombres_45a49.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setClasificacionRiesgoCCVAlto(totalhombres_50a54.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setClasificacionRiesgoCCVAlto(totalhombres_55a59.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setClasificacionRiesgoCCVAlto(totalhombres_60a64.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setClasificacionRiesgoCCVAlto(totalhombres_65a69.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setClasificacionRiesgoCCVAlto(totalhombres_70a74.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setClasificacionRiesgoCCVAlto(totalhombres_75a79.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setClasificacionRiesgoCCVAlto(totalhombres_80omas.getClasificacionRiesgoCCVAlto() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setClasificacionRiesgoCCVAlto(totalmujeres.getClasificacionRiesgoCCVAlto() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setClasificacionRiesgoCCVAlto(totalmujeres_pueblos.getClasificacionRiesgoCCVAlto() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setClasificacionRiesgoCCVAlto(totalmujeres_15a19.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setClasificacionRiesgoCCVAlto(totalmujeres_20a24.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setClasificacionRiesgoCCVAlto(totalmujeres_25a29.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setClasificacionRiesgoCCVAlto(totalmujeres_30a34.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setClasificacionRiesgoCCVAlto(totalmujeres_35a39.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setClasificacionRiesgoCCVAlto(totalmujeres_40a44.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setClasificacionRiesgoCCVAlto(totalmujeres_45a49.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setClasificacionRiesgoCCVAlto(totalmujeres_50a54.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setClasificacionRiesgoCCVAlto(totalmujeres_55a59.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setClasificacionRiesgoCCVAlto(totalmujeres_60a64.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setClasificacionRiesgoCCVAlto(totalmujeres_65a69.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setClasificacionRiesgoCCVAlto(totalmujeres_70a74.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setClasificacionRiesgoCCVAlto(totalmujeres_75a79.getClasificacionRiesgoCCVAlto() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setClasificacionRiesgoCCVAlto(totalmujeres_80omas.getClasificacionRiesgoCCVAlto() + 1);
                        }

                    }
                }//FIN riesgo alto

                if (pacientes.isHipertencion()) {
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPBCsegunPyFRHipertensos(totalAmbosSexos.getPBCsegunPyFRHipertensos() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setPBCsegunPyFRHipertensos(total_diabeticos.getPBCsegunPyFRHipertensos() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setPBCsegunPyFRHipertensos(totalhombres.getPBCsegunPyFRHipertensos() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setPBCsegunPyFRHipertensos(totalhombres_pueblos.getPBCsegunPyFRHipertensos() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setPBCsegunPyFRHipertensos(totalhombres_15a19.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setPBCsegunPyFRHipertensos(totalhombres_20a24.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setPBCsegunPyFRHipertensos(totalhombres_25a29.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setPBCsegunPyFRHipertensos(totalhombres_30a34.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setPBCsegunPyFRHipertensos(totalhombres_35a39.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setPBCsegunPyFRHipertensos(totalhombres_40a44.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setPBCsegunPyFRHipertensos(totalhombres_45a49.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setPBCsegunPyFRHipertensos(totalhombres_50a54.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setPBCsegunPyFRHipertensos(totalhombres_55a59.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setPBCsegunPyFRHipertensos(totalhombres_60a64.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setPBCsegunPyFRHipertensos(totalhombres_65a69.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setPBCsegunPyFRHipertensos(totalhombres_70a74.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setPBCsegunPyFRHipertensos(totalhombres_75a79.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setPBCsegunPyFRHipertensos(totalhombres_80omas.getPBCsegunPyFRHipertensos() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPBCsegunPyFRHipertensos(totalmujeres.getPBCsegunPyFRHipertensos() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setPBCsegunPyFRHipertensos(totalmujeres_pueblos.getPBCsegunPyFRHipertensos() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setPBCsegunPyFRHipertensos(totalmujeres_15a19.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setPBCsegunPyFRHipertensos(totalmujeres_20a24.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setPBCsegunPyFRHipertensos(totalmujeres_25a29.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setPBCsegunPyFRHipertensos(totalmujeres_30a34.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setPBCsegunPyFRHipertensos(totalmujeres_35a39.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setPBCsegunPyFRHipertensos(totalmujeres_40a44.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setPBCsegunPyFRHipertensos(totalmujeres_45a49.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setPBCsegunPyFRHipertensos(totalmujeres_50a54.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setPBCsegunPyFRHipertensos(totalmujeres_55a59.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setPBCsegunPyFRHipertensos(totalmujeres_60a64.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setPBCsegunPyFRHipertensos(totalmujeres_65a69.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setPBCsegunPyFRHipertensos(totalmujeres_70a74.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setPBCsegunPyFRHipertensos(totalmujeres_75a79.getPBCsegunPyFRHipertensos() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setPBCsegunPyFRHipertensos(totalmujeres_80omas.getPBCsegunPyFRHipertensos() + 1);
                        }

                    }
                }//FIN hipertension

                if (pacientes.isDiabetico()) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPBCsegunPyFRDiabeticos(totalAmbosSexos.getPBCsegunPyFRDiabeticos() + 1);
                    total_diabeticos.setPBCsegunPyFRDiabeticos(total_diabeticos.getPBCsegunPyFRDiabeticos() + 1);

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setPBCsegunPyFRDiabeticos(totalhombres.getPBCsegunPyFRDiabeticos() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setPBCsegunPyFRDiabeticos(totalhombres_pueblos.getPBCsegunPyFRDiabeticos() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setPBCsegunPyFRDiabeticos(totalhombres_15a19.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setPBCsegunPyFRDiabeticos(totalhombres_20a24.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setPBCsegunPyFRDiabeticos(totalhombres_25a29.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setPBCsegunPyFRDiabeticos(totalhombres_30a34.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setPBCsegunPyFRDiabeticos(totalhombres_35a39.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setPBCsegunPyFRDiabeticos(totalhombres_40a44.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setPBCsegunPyFRDiabeticos(totalhombres_45a49.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setPBCsegunPyFRDiabeticos(totalhombres_50a54.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setPBCsegunPyFRDiabeticos(totalhombres_55a59.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setPBCsegunPyFRDiabeticos(totalhombres_60a64.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setPBCsegunPyFRDiabeticos(totalhombres_65a69.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setPBCsegunPyFRDiabeticos(totalhombres_70a74.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setPBCsegunPyFRDiabeticos(totalhombres_75a79.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setPBCsegunPyFRDiabeticos(totalhombres_80omas.getPBCsegunPyFRDiabeticos() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPBCsegunPyFRDiabeticos(totalmujeres.getPBCsegunPyFRDiabeticos() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setPBCsegunPyFRDiabeticos(totalmujeres_pueblos.getPBCsegunPyFRDiabeticos() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setPBCsegunPyFRDiabeticos(totalmujeres_15a19.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setPBCsegunPyFRDiabeticos(totalmujeres_20a24.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setPBCsegunPyFRDiabeticos(totalmujeres_25a29.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setPBCsegunPyFRDiabeticos(totalmujeres_30a34.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setPBCsegunPyFRDiabeticos(totalmujeres_35a39.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setPBCsegunPyFRDiabeticos(totalmujeres_40a44.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setPBCsegunPyFRDiabeticos(totalmujeres_45a49.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setPBCsegunPyFRDiabeticos(totalmujeres_50a54.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setPBCsegunPyFRDiabeticos(totalmujeres_55a59.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setPBCsegunPyFRDiabeticos(totalmujeres_60a64.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setPBCsegunPyFRDiabeticos(totalmujeres_65a69.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setPBCsegunPyFRDiabeticos(totalmujeres_70a74.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setPBCsegunPyFRDiabeticos(totalmujeres_75a79.getPBCsegunPyFRDiabeticos() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setPBCsegunPyFRDiabeticos(totalmujeres_80omas.getPBCsegunPyFRDiabeticos() + 1);
                        }

                    }
                }//FIN diabeticos

                if (pacientes.isDislipidemico()) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPBCsegunPyFRDislipidemicos(totalAmbosSexos.getPBCsegunPyFRDislipidemicos() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setPBCsegunPyFRDislipidemicos(total_diabeticos.getPBCsegunPyFRDislipidemicos() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setPBCsegunPyFRDislipidemicos(totalhombres.getPBCsegunPyFRDislipidemicos() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setPBCsegunPyFRDislipidemicos(totalhombres_pueblos.getPBCsegunPyFRDislipidemicos() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setPBCsegunPyFRDislipidemicos(totalhombres_15a19.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setPBCsegunPyFRDislipidemicos(totalhombres_20a24.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setPBCsegunPyFRDislipidemicos(totalhombres_25a29.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setPBCsegunPyFRDislipidemicos(totalhombres_30a34.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setPBCsegunPyFRDislipidemicos(totalhombres_35a39.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setPBCsegunPyFRDislipidemicos(totalhombres_40a44.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setPBCsegunPyFRDislipidemicos(totalhombres_45a49.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setPBCsegunPyFRDislipidemicos(totalhombres_50a54.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setPBCsegunPyFRDislipidemicos(totalhombres_55a59.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setPBCsegunPyFRDislipidemicos(totalhombres_60a64.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setPBCsegunPyFRDislipidemicos(totalhombres_65a69.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setPBCsegunPyFRDislipidemicos(totalhombres_70a74.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setPBCsegunPyFRDislipidemicos(totalhombres_75a79.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setPBCsegunPyFRDislipidemicos(totalhombres_80omas.getPBCsegunPyFRDislipidemicos() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPBCsegunPyFRDislipidemicos(totalmujeres.getPBCsegunPyFRDislipidemicos() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setPBCsegunPyFRDislipidemicos(totalmujeres_pueblos.getPBCsegunPyFRDislipidemicos() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setPBCsegunPyFRDislipidemicos(totalmujeres_15a19.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setPBCsegunPyFRDislipidemicos(totalmujeres_20a24.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setPBCsegunPyFRDislipidemicos(totalmujeres_25a29.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setPBCsegunPyFRDislipidemicos(totalmujeres_30a34.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setPBCsegunPyFRDislipidemicos(totalmujeres_35a39.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setPBCsegunPyFRDislipidemicos(totalmujeres_40a44.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setPBCsegunPyFRDislipidemicos(totalmujeres_45a49.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setPBCsegunPyFRDislipidemicos(totalmujeres_50a54.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setPBCsegunPyFRDislipidemicos(totalmujeres_55a59.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setPBCsegunPyFRDislipidemicos(totalmujeres_60a64.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setPBCsegunPyFRDislipidemicos(totalmujeres_65a69.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setPBCsegunPyFRDislipidemicos(totalmujeres_70a74.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setPBCsegunPyFRDislipidemicos(totalmujeres_75a79.getPBCsegunPyFRDislipidemicos() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setPBCsegunPyFRDislipidemicos(totalmujeres_80omas.getPBCsegunPyFRDislipidemicos() + 1);
                        }

                    }
                }//FIN dislipidemicos

                if (ccv_filtro.get(ccv_filtro.size() - 1).getTabaco().equals("Si") && edad >= 55) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPBCsegunPyFRTabaquismo(totalAmbosSexos.getPBCsegunPyFRTabaquismo() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setPBCsegunPyFRTabaquismo(total_diabeticos.getPBCsegunPyFRTabaquismo() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setPBCsegunPyFRTabaquismo(totalhombres.getPBCsegunPyFRTabaquismo() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setPBCsegunPyFRTabaquismo(totalhombres_pueblos.getPBCsegunPyFRTabaquismo() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:      
                        if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setPBCsegunPyFRTabaquismo(totalhombres_55a59.getPBCsegunPyFRTabaquismo() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setPBCsegunPyFRTabaquismo(totalhombres_60a64.getPBCsegunPyFRTabaquismo() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setPBCsegunPyFRTabaquismo(totalhombres_65a69.getPBCsegunPyFRTabaquismo() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setPBCsegunPyFRTabaquismo(totalhombres_70a74.getPBCsegunPyFRTabaquismo() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setPBCsegunPyFRTabaquismo(totalhombres_75a79.getPBCsegunPyFRTabaquismo() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setPBCsegunPyFRTabaquismo(totalhombres_80omas.getPBCsegunPyFRTabaquismo() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPBCsegunPyFRTabaquismo(totalmujeres.getPBCsegunPyFRTabaquismo() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setPBCsegunPyFRTabaquismo(totalmujeres_pueblos.getPBCsegunPyFRTabaquismo() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:    
                        if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setPBCsegunPyFRTabaquismo(totalmujeres_55a59.getPBCsegunPyFRTabaquismo() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setPBCsegunPyFRTabaquismo(totalmujeres_60a64.getPBCsegunPyFRTabaquismo() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setPBCsegunPyFRTabaquismo(totalmujeres_65a69.getPBCsegunPyFRTabaquismo() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setPBCsegunPyFRTabaquismo(totalmujeres_70a74.getPBCsegunPyFRTabaquismo() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setPBCsegunPyFRTabaquismo(totalmujeres_75a79.getPBCsegunPyFRTabaquismo() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setPBCsegunPyFRTabaquismo(totalmujeres_80omas.getPBCsegunPyFRTabaquismo() + 1);
                        }

                    }
                }//FIN tabaquismo             

                if (pacientes.isIAM()) {
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPBCsegunPyFRAntInfarto(totalAmbosSexos.getPBCsegunPyFRAntInfarto() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setPBCsegunPyFRAntInfarto(total_diabeticos.getPBCsegunPyFRAntInfarto() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setPBCsegunPyFRAntInfarto(totalhombres.getPBCsegunPyFRAntInfarto() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setPBCsegunPyFRAntInfarto(totalhombres_pueblos.getPBCsegunPyFRAntInfarto() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setPBCsegunPyFRAntInfarto(totalhombres_15a19.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setPBCsegunPyFRAntInfarto(totalhombres_20a24.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setPBCsegunPyFRAntInfarto(totalhombres_25a29.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setPBCsegunPyFRAntInfarto(totalhombres_30a34.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setPBCsegunPyFRAntInfarto(totalhombres_35a39.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setPBCsegunPyFRAntInfarto(totalhombres_40a44.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setPBCsegunPyFRAntInfarto(totalhombres_45a49.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setPBCsegunPyFRAntInfarto(totalhombres_50a54.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setPBCsegunPyFRAntInfarto(totalhombres_55a59.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setPBCsegunPyFRAntInfarto(totalhombres_60a64.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setPBCsegunPyFRAntInfarto(totalhombres_65a69.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setPBCsegunPyFRAntInfarto(totalhombres_70a74.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setPBCsegunPyFRAntInfarto(totalhombres_75a79.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setPBCsegunPyFRAntInfarto(totalhombres_80omas.getPBCsegunPyFRAntInfarto() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPBCsegunPyFRAntInfarto(totalmujeres.getPBCsegunPyFRAntInfarto() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setPBCsegunPyFRAntInfarto(totalmujeres_pueblos.getPBCsegunPyFRAntInfarto() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setPBCsegunPyFRAntInfarto(totalmujeres_15a19.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setPBCsegunPyFRAntInfarto(totalmujeres_20a24.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setPBCsegunPyFRAntInfarto(totalmujeres_25a29.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setPBCsegunPyFRAntInfarto(totalmujeres_30a34.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setPBCsegunPyFRAntInfarto(totalmujeres_35a39.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setPBCsegunPyFRAntInfarto(totalmujeres_40a44.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setPBCsegunPyFRAntInfarto(totalmujeres_45a49.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setPBCsegunPyFRAntInfarto(totalmujeres_50a54.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setPBCsegunPyFRAntInfarto(totalmujeres_55a59.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setPBCsegunPyFRAntInfarto(totalmujeres_60a64.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setPBCsegunPyFRAntInfarto(totalmujeres_65a69.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setPBCsegunPyFRAntInfarto(totalmujeres_70a74.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setPBCsegunPyFRAntInfarto(totalmujeres_75a79.getPBCsegunPyFRAntInfarto() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setPBCsegunPyFRAntInfarto(totalmujeres_80omas.getPBCsegunPyFRAntInfarto() + 1);
                        }

                    }
                }//FIN IAM

                if (pacientes.isACV()) {//DOPA
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPBCsegunPyFRAntEnfCerebroVascular(totalAmbosSexos.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setPBCsegunPyFRAntEnfCerebroVascular(total_diabeticos.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_pueblos.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_15a19.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_20a24.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_25a29.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_30a34.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_35a39.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_40a44.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_45a49.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_50a54.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_55a59.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_60a64.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_65a69.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_70a74.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_75a79.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setPBCsegunPyFRAntEnfCerebroVascular(totalhombres_80omas.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres.getPBCsegunPyFRAntEnfCerebroVascular() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_pueblos.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_15a19.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_20a24.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_25a29.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_30a34.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_35a39.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_40a44.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_45a49.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_50a54.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_55a59.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_60a64.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_65a69.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_70a74.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_75a79.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setPBCsegunPyFRAntEnfCerebroVascular(totalmujeres_80omas.getPBCsegunPyFRAntEnfCerebroVascular() + 1);
                        }

                    }
                }//FIN CEREBRO CAR

                //CLASIFICACION ERC!!!!
                String ERC = ClasificacionERC(ccv_filtro);

                if (ERC.equals("SIN ENFERMEDAD RENAL")) {
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setSinERC(totalAmbosSexos.getSinERC() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setSinERC(total_diabeticos.getSinERC() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setSinERC(totalhombres.getSinERC() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setSinERC(totalhombres_pueblos.getSinERC() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setSinERC(totalhombres_15a19.getSinERC() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setSinERC(totalhombres_20a24.getSinERC() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setSinERC(totalhombres_25a29.getSinERC() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setSinERC(totalhombres_30a34.getSinERC() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setSinERC(totalhombres_35a39.getSinERC() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setSinERC(totalhombres_40a44.getSinERC() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setSinERC(totalhombres_45a49.getSinERC() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setSinERC(totalhombres_50a54.getSinERC() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setSinERC(totalhombres_55a59.getSinERC() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setSinERC(totalhombres_60a64.getSinERC() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setSinERC(totalhombres_65a69.getSinERC() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setSinERC(totalhombres_70a74.getSinERC() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setSinERC(totalhombres_75a79.getSinERC() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setSinERC(totalhombres_80omas.getSinERC() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setSinERC(totalmujeres.getSinERC() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setSinERC(totalmujeres_pueblos.getSinERC() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setSinERC(totalmujeres_15a19.getSinERC() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setSinERC(totalmujeres_20a24.getSinERC() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setSinERC(totalmujeres_25a29.getSinERC() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setSinERC(totalmujeres_30a34.getSinERC() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setSinERC(totalmujeres_35a39.getSinERC() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setSinERC(totalmujeres_40a44.getSinERC() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setSinERC(totalmujeres_45a49.getSinERC() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setSinERC(totalmujeres_50a54.getSinERC() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setSinERC(totalmujeres_55a59.getSinERC() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setSinERC(totalmujeres_60a64.getSinERC() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setSinERC(totalmujeres_65a69.getSinERC() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setSinERC(totalmujeres_70a74.getSinERC() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setSinERC(totalmujeres_75a79.getSinERC() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setSinERC(totalmujeres_80omas.getSinERC() + 1);
                        }

                    }
                }//FIN SIN ERC
                else if (ERC.equals("ETAPA G1_2")) {
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setEtapa1_2(totalAmbosSexos.getEtapa1_2() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setEtapa1_2(total_diabeticos.getEtapa1_2() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setEtapa1_2(totalhombres.getEtapa1_2() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setEtapa1_2(totalhombres_pueblos.getEtapa1_2() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setEtapa1_2(totalhombres_15a19.getEtapa1_2() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setEtapa1_2(totalhombres_20a24.getEtapa1_2() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setEtapa1_2(totalhombres_25a29.getEtapa1_2() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setEtapa1_2(totalhombres_30a34.getEtapa1_2() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setEtapa1_2(totalhombres_35a39.getEtapa1_2() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setEtapa1_2(totalhombres_40a44.getEtapa1_2() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setEtapa1_2(totalhombres_45a49.getEtapa1_2() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setEtapa1_2(totalhombres_50a54.getEtapa1_2() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setEtapa1_2(totalhombres_55a59.getEtapa1_2() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setEtapa1_2(totalhombres_60a64.getEtapa1_2() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setEtapa1_2(totalhombres_65a69.getEtapa1_2() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setEtapa1_2(totalhombres_70a74.getEtapa1_2() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setEtapa1_2(totalhombres_75a79.getEtapa1_2() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setEtapa1_2(totalhombres_80omas.getEtapa1_2() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setEtapa1_2(totalmujeres.getEtapa1_2() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setEtapa1_2(totalmujeres_pueblos.getEtapa1_2() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setEtapa1_2(totalmujeres_15a19.getEtapa1_2() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setEtapa1_2(totalmujeres_20a24.getEtapa1_2() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setEtapa1_2(totalmujeres_25a29.getEtapa1_2() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setEtapa1_2(totalmujeres_30a34.getEtapa1_2() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setEtapa1_2(totalmujeres_35a39.getEtapa1_2() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setEtapa1_2(totalmujeres_40a44.getEtapa1_2() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setEtapa1_2(totalmujeres_45a49.getEtapa1_2() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setEtapa1_2(totalmujeres_50a54.getEtapa1_2() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setEtapa1_2(totalmujeres_55a59.getEtapa1_2() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setEtapa1_2(totalmujeres_60a64.getEtapa1_2() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setEtapa1_2(totalmujeres_65a69.getEtapa1_2() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setEtapa1_2(totalmujeres_70a74.getEtapa1_2() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setEtapa1_2(totalmujeres_75a79.getEtapa1_2() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setEtapa1_2(totalmujeres_80omas.getEtapa1_2() + 1);
                        }

                    }
                }//FIN ETAPA1-2
                else if (ERC.equals("ETAPA G3a")) {
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setEtapa3a(totalAmbosSexos.getEtapa3a() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setEtapa3a(total_diabeticos.getEtapa3a() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setEtapa3a(totalhombres.getEtapa3a() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setEtapa3a(totalhombres_pueblos.getEtapa3a() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setEtapa3a(totalhombres_15a19.getEtapa3a() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setEtapa3a(totalhombres_20a24.getEtapa3a() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setEtapa3a(totalhombres_25a29.getEtapa3a() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setEtapa3a(totalhombres_30a34.getEtapa3a() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setEtapa3a(totalhombres_35a39.getEtapa3a() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setEtapa3a(totalhombres_40a44.getEtapa3a() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setEtapa3a(totalhombres_45a49.getEtapa3a() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setEtapa3a(totalhombres_50a54.getEtapa3a() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setEtapa3a(totalhombres_55a59.getEtapa3a() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setEtapa3a(totalhombres_60a64.getEtapa3a() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setEtapa3a(totalhombres_65a69.getEtapa3a() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setEtapa3a(totalhombres_70a74.getEtapa3a() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setEtapa3a(totalhombres_75a79.getEtapa3a() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setEtapa3a(totalhombres_80omas.getEtapa3a() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setEtapa3a(totalmujeres.getEtapa3a() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setEtapa3a(totalmujeres_pueblos.getEtapa3a() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setEtapa3a(totalmujeres_15a19.getEtapa3a() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setEtapa3a(totalmujeres_20a24.getEtapa3a() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setEtapa3a(totalmujeres_25a29.getEtapa3a() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setEtapa3a(totalmujeres_30a34.getEtapa3a() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setEtapa3a(totalmujeres_35a39.getEtapa3a() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setEtapa3a(totalmujeres_40a44.getEtapa3a() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setEtapa3a(totalmujeres_45a49.getEtapa3a() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setEtapa3a(totalmujeres_50a54.getEtapa3a() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setEtapa3a(totalmujeres_55a59.getEtapa3a() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setEtapa3a(totalmujeres_60a64.getEtapa3a() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setEtapa3a(totalmujeres_65a69.getEtapa3a() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setEtapa3a(totalmujeres_70a74.getEtapa3a() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setEtapa3a(totalmujeres_75a79.getEtapa3a() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setEtapa3a(totalmujeres_80omas.getEtapa3a() + 1);
                        }

                    }
                }//FIN ETAPA3a
                else if (ERC.equals("ETAPA G3b")) {
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setEtapa3b(totalAmbosSexos.getEtapa3b() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setEtapa3b(total_diabeticos.getEtapa3b() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setEtapa3b(totalhombres.getEtapa3b() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setEtapa3b(totalhombres_pueblos.getEtapa3b() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setEtapa3b(totalhombres_15a19.getEtapa3b() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setEtapa3b(totalhombres_20a24.getEtapa3b() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setEtapa3b(totalhombres_25a29.getEtapa3b() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setEtapa3b(totalhombres_30a34.getEtapa3b() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setEtapa3b(totalhombres_35a39.getEtapa3b() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setEtapa3b(totalhombres_40a44.getEtapa3b() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setEtapa3b(totalhombres_45a49.getEtapa3b() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setEtapa3b(totalhombres_50a54.getEtapa3b() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setEtapa3b(totalhombres_55a59.getEtapa3b() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setEtapa3b(totalhombres_60a64.getEtapa3b() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setEtapa3b(totalhombres_65a69.getEtapa3b() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setEtapa3b(totalhombres_70a74.getEtapa3b() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setEtapa3b(totalhombres_75a79.getEtapa3b() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setEtapa3b(totalhombres_80omas.getEtapa3b() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setEtapa3b(totalmujeres.getEtapa3b() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setEtapa3b(totalmujeres_pueblos.getEtapa3b() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setEtapa3b(totalmujeres_15a19.getEtapa3b() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setEtapa3b(totalmujeres_20a24.getEtapa3b() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setEtapa3b(totalmujeres_25a29.getEtapa3b() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setEtapa3b(totalmujeres_30a34.getEtapa3b() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setEtapa3b(totalmujeres_35a39.getEtapa3b() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setEtapa3b(totalmujeres_40a44.getEtapa3b() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setEtapa3b(totalmujeres_45a49.getEtapa3b() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setEtapa3b(totalmujeres_50a54.getEtapa3b() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setEtapa3b(totalmujeres_55a59.getEtapa3b() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setEtapa3b(totalmujeres_60a64.getEtapa3b() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setEtapa3b(totalmujeres_65a69.getEtapa3b() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setEtapa3b(totalmujeres_70a74.getEtapa3b() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setEtapa3b(totalmujeres_75a79.getEtapa3b() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setEtapa3b(totalmujeres_80omas.getEtapa3b() + 1);
                        }

                    }
                }//FIN ETAPA3b
                else if (ERC.equals("ETAPA G4")) {
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setEtapa4(totalAmbosSexos.getEtapa4() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setEtapa4(total_diabeticos.getEtapa4() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setEtapa4(totalhombres.getEtapa4() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setEtapa4(totalhombres_pueblos.getEtapa4() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setEtapa4(totalhombres_15a19.getEtapa4() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setEtapa4(totalhombres_20a24.getEtapa4() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setEtapa4(totalhombres_25a29.getEtapa4() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setEtapa4(totalhombres_30a34.getEtapa4() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setEtapa4(totalhombres_35a39.getEtapa4() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setEtapa4(totalhombres_40a44.getEtapa4() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setEtapa4(totalhombres_45a49.getEtapa4() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setEtapa4(totalhombres_50a54.getEtapa4() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setEtapa4(totalhombres_55a59.getEtapa4() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setEtapa4(totalhombres_60a64.getEtapa4() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setEtapa4(totalhombres_65a69.getEtapa4() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setEtapa4(totalhombres_70a74.getEtapa4() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setEtapa4(totalhombres_75a79.getEtapa4() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setEtapa4(totalhombres_80omas.getEtapa4() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setEtapa4(totalmujeres.getEtapa4() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setEtapa4(totalmujeres_pueblos.getEtapa4() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setEtapa4(totalmujeres_15a19.getEtapa4() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setEtapa4(totalmujeres_20a24.getEtapa4() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setEtapa4(totalmujeres_25a29.getEtapa4() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setEtapa4(totalmujeres_30a34.getEtapa4() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setEtapa4(totalmujeres_35a39.getEtapa4() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setEtapa4(totalmujeres_40a44.getEtapa4() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setEtapa4(totalmujeres_45a49.getEtapa4() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setEtapa4(totalmujeres_50a54.getEtapa4() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setEtapa4(totalmujeres_55a59.getEtapa4() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setEtapa4(totalmujeres_60a64.getEtapa4() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setEtapa4(totalmujeres_65a69.getEtapa4() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setEtapa4(totalmujeres_70a74.getEtapa4() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setEtapa4(totalmujeres_75a79.getEtapa4() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setEtapa4(totalmujeres_80omas.getEtapa4() + 1);
                        }

                    }
                }//FIN ETAPA4
                else if (ERC.equals("ETAPA G5")) {
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setEtapa5(totalAmbosSexos.getEtapa5() + 1);
                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setEtapa5(total_diabeticos.getEtapa5() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setEtapa5(totalhombres.getEtapa5() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setEtapa5(totalhombres_pueblos.getEtapa5() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setEtapa5(totalhombres_15a19.getEtapa5() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setEtapa5(totalhombres_20a24.getEtapa5() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setEtapa5(totalhombres_25a29.getEtapa5() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setEtapa5(totalhombres_30a34.getEtapa5() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setEtapa5(totalhombres_35a39.getEtapa5() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setEtapa5(totalhombres_40a44.getEtapa5() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setEtapa5(totalhombres_45a49.getEtapa5() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setEtapa5(totalhombres_50a54.getEtapa5() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setEtapa5(totalhombres_55a59.getEtapa5() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setEtapa5(totalhombres_60a64.getEtapa5() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setEtapa5(totalhombres_65a69.getEtapa5() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setEtapa5(totalhombres_70a74.getEtapa5() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setEtapa5(totalhombres_75a79.getEtapa5() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setEtapa5(totalhombres_80omas.getEtapa5() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setEtapa5(totalmujeres.getEtapa5() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setEtapa5(totalmujeres_pueblos.getEtapa5() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setEtapa5(totalmujeres_15a19.getEtapa5() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setEtapa5(totalmujeres_20a24.getEtapa5() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setEtapa5(totalmujeres_25a29.getEtapa5() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setEtapa5(totalmujeres_30a34.getEtapa5() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setEtapa5(totalmujeres_35a39.getEtapa5() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setEtapa5(totalmujeres_40a44.getEtapa5() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setEtapa5(totalmujeres_45a49.getEtapa5() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setEtapa5(totalmujeres_50a54.getEtapa5() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setEtapa5(totalmujeres_55a59.getEtapa5() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setEtapa5(totalmujeres_60a64.getEtapa5() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setEtapa5(totalmujeres_65a69.getEtapa5() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setEtapa5(totalmujeres_70a74.getEtapa5() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setEtapa5(totalmujeres_75a79.getEtapa5() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setEtapa5(totalmujeres_80omas.getEtapa5() + 1);
                        }

                    }
                }//FIN ETAPA 5

                if (fue_censado) {

                    totalAmbosSexos.setPacientestotal(totalAmbosSexos.getPacientestotal() + 1);

                    if (pacientes.isDiabetico()) {
                        total_diabeticos.setPacientestotal(total_diabeticos.getPacientestotal() + 1);
                    }

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setPacientestotal(totalhombres.getPacientestotal() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setPacientestotal(totalhombres_pueblos.getPacientestotal() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setPacientestotal(totalhombres_15a19.getPacientestotal() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setPacientestotal(totalhombres_20a24.getPacientestotal() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setPacientestotal(totalhombres_25a29.getPacientestotal() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setPacientestotal(totalhombres_30a34.getPacientestotal() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setPacientestotal(totalhombres_35a39.getPacientestotal() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setPacientestotal(totalhombres_40a44.getPacientestotal() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setPacientestotal(totalhombres_45a49.getPacientestotal() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setPacientestotal(totalhombres_50a54.getPacientestotal() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setPacientestotal(totalhombres_55a59.getPacientestotal() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setPacientestotal(totalhombres_60a64.getPacientestotal() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setPacientestotal(totalhombres_65a69.getPacientestotal() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setPacientestotal(totalhombres_70a74.getPacientestotal() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setPacientestotal(totalhombres_75a79.getPacientestotal() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setPacientestotal(totalhombres_80omas.getPacientestotal() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPacientestotal(totalmujeres.getPacientestotal() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setPacientestotal(totalmujeres_pueblos.getPacientestotal() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setPacientestotal(totalmujeres_15a19.getPacientestotal() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setPacientestotal(totalmujeres_20a24.getPacientestotal() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setPacientestotal(totalmujeres_25a29.getPacientestotal() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setPacientestotal(totalmujeres_30a34.getPacientestotal() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setPacientestotal(totalmujeres_35a39.getPacientestotal() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setPacientestotal(totalmujeres_40a44.getPacientestotal() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setPacientestotal(totalmujeres_45a49.getPacientestotal() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setPacientestotal(totalmujeres_50a54.getPacientestotal() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setPacientestotal(totalmujeres_55a59.getPacientestotal() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setPacientestotal(totalmujeres_60a64.getPacientestotal() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setPacientestotal(totalmujeres_65a69.getPacientestotal() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setPacientestotal(totalmujeres_70a74.getPacientestotal() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setPacientestotal(totalmujeres_75a79.getPacientestotal() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setPacientestotal(totalmujeres_80omas.getPacientestotal() + 1);
                        }

                    }

                }

            } else {
                //aqui tomamos al paciente que no fue censado

                CensoCCVExcluidos nocensado = new CensoCCVExcluidos();
                nocensado.setNombre(pacientes.getNombres_paciente());
                nocensado.setApellidop(pacientes.getApellidoPaterno_paciente());
                nocensado.setApellidom(pacientes.getApellidoMaterno_paciente());
                nocensado.setRut(pacientes.getRut_paciente());
                if (registra_unaatencion) {
                    nocensado.setRazon_exclusion("Pasivo en el programa");
                } else {
                    nocensado.setRazon_exclusion("No posee atenciones en el CCV");
                }
                PacienteController p = new PacienteController();
                nocensado.setEdad(p.Age(pacientes.getFechaNacimiento_paciente()));
                Pacientes_excluidos.add(nocensado);
            }

        }//fin for

        totalAmbosSexos.setTotal(
                totalAmbosSexos.getSinERC()
                + totalAmbosSexos.getEtapa1_2()
                + totalAmbosSexos.getEtapa3a()
                + totalAmbosSexos.getEtapa3b()
                + totalAmbosSexos.getEtapa4()
                + totalAmbosSexos.getEtapa5()
        );
        totalhombres.setTotal(
                totalhombres.getSinERC()
                + totalhombres.getEtapa1_2()
                + totalhombres.getEtapa3a()
                + totalhombres.getEtapa3b()
                + totalhombres.getEtapa4()
                + totalhombres.getEtapa5()
        );
        totalmujeres.setTotal(
                totalmujeres.getSinERC()
                + totalmujeres.getEtapa1_2()
                + totalmujeres.getEtapa3a()
                + totalmujeres.getEtapa3b()
                + totalmujeres.getEtapa4()
                + totalmujeres.getEtapa5()
        );
        totalhombres_15a19.setTotal(
                totalhombres_15a19.getSinERC()
                + totalhombres_15a19.getEtapa1_2()
                + totalhombres_15a19.getEtapa3a()
                + totalhombres_15a19.getEtapa3b()
                + totalhombres_15a19.getEtapa4()
                + totalhombres_15a19.getEtapa5()
        );
        totalhombres_20a24.setTotal(
                totalhombres_20a24.getSinERC()
                + totalhombres_20a24.getEtapa1_2()
                + totalhombres_20a24.getEtapa3a()
                + totalhombres_20a24.getEtapa3b()
                + totalhombres_20a24.getEtapa4()
                + totalhombres_20a24.getEtapa5()
        );
        totalhombres_25a29.setTotal(
                totalhombres_25a29.getSinERC()
                + totalhombres_25a29.getEtapa1_2()
                + totalhombres_25a29.getEtapa3a()
                + totalhombres_25a29.getEtapa3b()
                + totalhombres_25a29.getEtapa4()
                + totalhombres_25a29.getEtapa5()
        );
        totalhombres_30a34.setTotal(
                totalhombres_30a34.getSinERC()
                + totalhombres_30a34.getEtapa1_2()
                + totalhombres_30a34.getEtapa3a()
                + totalhombres_30a34.getEtapa3b()
                + totalhombres_30a34.getEtapa4()
                + totalhombres_30a34.getEtapa5()
        );
        totalhombres_35a39.setTotal(
                totalhombres_35a39.getSinERC()
                + totalhombres_35a39.getEtapa1_2()
                + totalhombres_35a39.getEtapa3a()
                + totalhombres_35a39.getEtapa3b()
                + totalhombres_35a39.getEtapa4()
                + totalhombres_35a39.getEtapa5()
        );

        totalhombres_40a44.setTotal(
                totalhombres_40a44.getSinERC()
                + totalhombres_40a44.getEtapa1_2()
                + totalhombres_40a44.getEtapa3a()
                + totalhombres_40a44.getEtapa3b()
                + totalhombres_40a44.getEtapa4()
                + totalhombres_40a44.getEtapa5()
        );
        totalhombres_45a49.setTotal(
                totalhombres_45a49.getSinERC()
                + totalhombres_45a49.getEtapa1_2()
                + totalhombres_45a49.getEtapa3a()
                + totalhombres_45a49.getEtapa3b()
                + totalhombres_45a49.getEtapa4()
                + totalhombres_45a49.getEtapa5()
        );
        totalhombres_50a54.setTotal(
                totalhombres_50a54.getSinERC()
                + totalhombres_50a54.getEtapa1_2()
                + totalhombres_50a54.getEtapa3a()
                + totalhombres_50a54.getEtapa3b()
                + totalhombres_50a54.getEtapa4()
                + totalhombres_50a54.getEtapa5()
        );
        totalhombres_55a59.setTotal(
                totalhombres_55a59.getSinERC()
                + totalhombres_55a59.getEtapa1_2()
                + totalhombres_55a59.getEtapa3a()
                + totalhombres_55a59.getEtapa3b()
                + totalhombres_55a59.getEtapa4()
                + totalhombres_55a59.getEtapa5()
        );
        totalhombres_60a64.setTotal(
                totalhombres_60a64.getSinERC()
                + totalhombres_60a64.getEtapa1_2()
                + totalhombres_60a64.getEtapa3a()
                + totalhombres_60a64.getEtapa3b()
                + totalhombres_60a64.getEtapa4()
                + totalhombres_60a64.getEtapa5()
        );
        totalhombres_65a69.setTotal(
                totalhombres_65a69.getSinERC()
                + totalhombres_65a69.getEtapa1_2()
                + totalhombres_65a69.getEtapa3a()
                + totalhombres_65a69.getEtapa3b()
                + totalhombres_65a69.getEtapa4()
                + totalhombres_65a69.getEtapa5()
        );
        totalhombres_70a74.setTotal(
                totalhombres_70a74.getSinERC()
                + totalhombres_70a74.getEtapa1_2()
                + totalhombres_70a74.getEtapa3a()
                + totalhombres_70a74.getEtapa3b()
                + totalhombres_70a74.getEtapa4()
                + totalhombres_70a74.getEtapa5()
        );
        totalhombres_75a79.setTotal(
                totalhombres_75a79.getSinERC()
                + totalhombres_75a79.getEtapa1_2()
                + totalhombres_75a79.getEtapa3a()
                + totalhombres_75a79.getEtapa3b()
                + totalhombres_75a79.getEtapa4()
                + totalhombres_75a79.getEtapa5()
        );
        totalhombres_80omas.setTotal(
                totalhombres_80omas.getSinERC()
                + totalhombres_80omas.getEtapa1_2()
                + totalhombres_80omas.getEtapa3a()
                + totalhombres_80omas.getEtapa3b()
                + totalhombres_80omas.getEtapa4()
                + totalhombres_80omas.getEtapa5()
        );
        totalhombres_pueblos.setTotal(
                totalhombres_pueblos.getSinERC()
                + totalhombres_pueblos.getEtapa1_2()
                + totalhombres_pueblos.getEtapa3a()
                + totalhombres_pueblos.getEtapa3b()
                + totalhombres_pueblos.getEtapa4()
                + totalhombres_pueblos.getEtapa5()
        );

        totalmujeres_15a19.setTotal(
                totalmujeres_15a19.getSinERC()
                + totalmujeres_15a19.getEtapa1_2()
                + totalmujeres_15a19.getEtapa3a()
                + totalmujeres_15a19.getEtapa3b()
                + totalmujeres_15a19.getEtapa4()
                + totalmujeres_15a19.getEtapa5()
        );
        totalmujeres_20a24.setTotal(
                totalmujeres_20a24.getSinERC()
                + totalmujeres_20a24.getEtapa1_2()
                + totalmujeres_20a24.getEtapa3a()
                + totalmujeres_20a24.getEtapa3b()
                + totalmujeres_20a24.getEtapa4()
                + totalmujeres_20a24.getEtapa5()
        );
        totalmujeres_25a29.setTotal(
                totalmujeres_25a29.getSinERC()
                + totalmujeres_25a29.getEtapa1_2()
                + totalmujeres_25a29.getEtapa3a()
                + totalmujeres_25a29.getEtapa3b()
                + totalmujeres_25a29.getEtapa4()
                + totalmujeres_25a29.getEtapa5()
        );
        totalmujeres_30a34.setTotal(
                totalmujeres_30a34.getSinERC()
                + totalmujeres_30a34.getEtapa1_2()
                + totalmujeres_30a34.getEtapa3a()
                + totalmujeres_30a34.getEtapa3b()
                + totalmujeres_30a34.getEtapa4()
                + totalmujeres_30a34.getEtapa5()
        );
        totalmujeres_35a39.setTotal(
                totalmujeres_35a39.getSinERC()
                + totalmujeres_35a39.getEtapa1_2()
                + totalmujeres_35a39.getEtapa3a()
                + totalmujeres_35a39.getEtapa3b()
                + totalmujeres_35a39.getEtapa4()
                + totalmujeres_35a39.getEtapa5()
        );
        totalmujeres_40a44.setTotal(
                totalmujeres_40a44.getSinERC()
                + totalmujeres_40a44.getEtapa1_2()
                + totalmujeres_40a44.getEtapa3a()
                + totalmujeres_40a44.getEtapa3b()
                + totalmujeres_40a44.getEtapa4()
                + totalmujeres_40a44.getEtapa5()
        );
        totalmujeres_45a49.setTotal(
                totalmujeres_45a49.getSinERC()
                + totalmujeres_45a49.getEtapa1_2()
                + totalmujeres_45a49.getEtapa3a()
                + totalmujeres_45a49.getEtapa3b()
                + totalmujeres_45a49.getEtapa4()
                + totalmujeres_45a49.getEtapa5()
        );
        totalmujeres_50a54.setTotal(
                totalmujeres_50a54.getSinERC()
                + totalmujeres_50a54.getEtapa1_2()
                + totalmujeres_50a54.getEtapa3a()
                + totalmujeres_50a54.getEtapa3b()
                + totalmujeres_50a54.getEtapa4()
                + totalmujeres_50a54.getEtapa5()
        );
        totalmujeres_55a59.setTotal(
                totalmujeres_55a59.getSinERC()
                + totalmujeres_55a59.getEtapa1_2()
                + totalmujeres_55a59.getEtapa3a()
                + totalmujeres_55a59.getEtapa3b()
                + totalmujeres_55a59.getEtapa4()
                + totalmujeres_55a59.getEtapa5()
        );
        totalmujeres_60a64.setTotal(
                totalmujeres_60a64.getSinERC()
                + totalmujeres_60a64.getEtapa1_2()
                + totalmujeres_60a64.getEtapa3a()
                + totalmujeres_60a64.getEtapa3b()
                + totalmujeres_60a64.getEtapa4()
                + totalmujeres_60a64.getEtapa5()
        );
        totalmujeres_65a69.setTotal(
                totalmujeres_65a69.getSinERC()
                + totalmujeres_65a69.getEtapa1_2()
                + totalmujeres_65a69.getEtapa3a()
                + totalmujeres_65a69.getEtapa3b()
                + totalmujeres_65a69.getEtapa4()
                + totalmujeres_65a69.getEtapa5()
        );
        totalmujeres_70a74.setTotal(
                totalmujeres_70a74.getSinERC()
                + totalmujeres_70a74.getEtapa1_2()
                + totalmujeres_70a74.getEtapa3a()
                + totalmujeres_70a74.getEtapa3b()
                + totalmujeres_70a74.getEtapa4()
                + totalmujeres_70a74.getEtapa5()
        );
        totalmujeres_75a79.setTotal(
                totalmujeres_75a79.getSinERC()
                + totalmujeres_75a79.getEtapa1_2()
                + totalmujeres_75a79.getEtapa3a()
                + totalmujeres_75a79.getEtapa3b()
                + totalmujeres_75a79.getEtapa4()
                + totalmujeres_75a79.getEtapa5()
        );
        totalmujeres_80omas.setTotal(
                totalmujeres_80omas.getSinERC()
                + totalmujeres_80omas.getEtapa1_2()
                + totalmujeres_80omas.getEtapa3a()
                + totalmujeres_80omas.getEtapa3b()
                + totalmujeres_80omas.getEtapa4()
                + totalmujeres_80omas.getEtapa5()
        );
        totalmujeres_pueblos.setTotal(
                totalmujeres_pueblos.getSinERC()
                + totalmujeres_pueblos.getEtapa1_2()
                + totalmujeres_pueblos.getEtapa3a()
                + totalmujeres_pueblos.getEtapa3b()
                + totalmujeres_pueblos.getEtapa4()
                + totalmujeres_pueblos.getEtapa5()
        );
        total_diabeticos.setTotal(
                total_diabeticos.getSinERC()
                + total_diabeticos.getEtapa1_2()
                + total_diabeticos.getEtapa3a()
                + total_diabeticos.getEtapa3b()
                + total_diabeticos.getEtapa4()
                + total_diabeticos.getEtapa5()
        );

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
        totalhombres_80omas.setColumnName1("Hombres de 80 más años");
        totalmujeres_80omas.setColumnName1("Mujeres de 80 o más años");
        totalhombres_pueblos.setColumnName1("Hombres de pueblos originarios");
        totalmujeres_pueblos.setColumnName1("Mujeres de pueblos originarios");
        total_diabeticos.setColumnName1("Pacientes Diabeticos");
        A_elementos.clear();
        A_elementos.add(totalAmbosSexos);
        A_elementos.add(totalhombres);
        A_elementos.add(totalmujeres);
        A_elementos.add(totalhombres_15a19);
        A_elementos.add(totalmujeres_15a19);

        A_elementos.add(totalhombres_20a24);
        A_elementos.add(totalmujeres_20a24);

        A_elementos.add(totalhombres_25a29);
        A_elementos.add(totalmujeres_25a29);

        A_elementos.add(totalhombres_30a34);
        A_elementos.add(totalmujeres_30a34);

        A_elementos.add(totalhombres_35a39);
        A_elementos.add(totalmujeres_35a39);

        A_elementos.add(totalhombres_40a44);
        A_elementos.add(totalmujeres_40a44);

        A_elementos.add(totalhombres_45a49);
        A_elementos.add(totalmujeres_45a49);

        A_elementos.add(totalhombres_50a54);
        A_elementos.add(totalmujeres_50a54);

        A_elementos.add(totalhombres_55a59);
        A_elementos.add(totalmujeres_55a59);

        A_elementos.add(totalhombres_60a64);
        A_elementos.add(totalmujeres_60a64);

        A_elementos.add(totalhombres_65a69);
        A_elementos.add(totalmujeres_65a69);

        A_elementos.add(totalhombres_70a74);
        A_elementos.add(totalmujeres_70a74);

        A_elementos.add(totalhombres_75a79);
        A_elementos.add(totalmujeres_75a79);

        A_elementos.add(totalhombres_80omas);
        A_elementos.add(totalmujeres_80omas);

        A_elementos.add(totalhombres_pueblos);
        A_elementos.add(totalmujeres_pueblos);
        A_elementos.add(total_diabeticos);

        return A_elementos;

    }

    public List<CensoCCVSeccionB> censoCCVSeccionB() {
        CensoCCVSeccionB totalAmbosSexos = new CensoCCVSeccionB();
        CensoCCVSeccionB totalhombres = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres = new CensoCCVSeccionB();
        CensoCCVSeccionB totalhombres_15a19 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_15a19 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalhombres_20a24 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_20a24 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalhombres_25a29 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_25a29 = new CensoCCVSeccionB();

        CensoCCVSeccionB totalhombres_30a34 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_30a34 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalhombres_35a39 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_35a39 = new CensoCCVSeccionB();

        CensoCCVSeccionB totalhombres_40a44 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_40a44 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalhombres_45a49 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_45a49 = new CensoCCVSeccionB();

        CensoCCVSeccionB totalhombres_50a54 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_50a54 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalhombres_55a59 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_55a59 = new CensoCCVSeccionB();

        CensoCCVSeccionB totalhombres_60a64 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_60a64 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalhombres_65a69 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_65a69 = new CensoCCVSeccionB();

        CensoCCVSeccionB totalhombres_70a74 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_70a74 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalhombres_75a79 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_75a79 = new CensoCCVSeccionB();
        CensoCCVSeccionB totalhombres_80omas = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_80omas = new CensoCCVSeccionB();
        CensoCCVSeccionB totalhombres_pueblos = new CensoCCVSeccionB();
        CensoCCVSeccionB totalmujeres_pueblos = new CensoCCVSeccionB();

        List<Paciente> pacientes_habilitados = ejbPaciente.findbyPacienteActivo();
        List<CartolaSeguimientoCCV> ccv;
        List<CartolaSeguimientoCCV> ccv_filtro;
        List<CartolaSeguimientoCCV> ccv_ordenado;
        boolean resultados[];
        //obtengo todos los pacientes habilitados , primer filtro
        for (Paciente pacientes : pacientes_habilitados) {
            boolean fue_censado = false;
            int edad;

            ccv = new ArrayList<>();
            resultados = new boolean[7];
            ccv_filtro = new ArrayList<>();
            ccv_ordenado = new ArrayList<>();
            ccv = ejbCartola.findByPaciente(pacientes);//obtengo todas las cartolas por  pacientes

            ccv_ordenado = filtro(ccv);
            ccv_filtro = filtro_censables(ccv_ordenado);//se ordenan las cartolas, y se filtran solo als que entran al censo

            //en este punto por paciente tenemos las cartola que entran en el censo 
            //filtramos por paciente si su ultima cartola , la fecha mas alta que tiene es censable
            if (ccv_filtro.size() > 0) {//si tiene un elemento censable

                for (int i = 0; i < 7; i++) {
                    resultados[i] = false;//por defecto todos son falsos hasta que no se cambien
                }
                resultados = Resultados_B(ccv_filtro, resultados);

                edad = ccv_filtro.get(ccv_filtro.size() - 1).getEdad_paciente();
                //VERIFICACIONES:

                if (resultados[0] && pacientes.isHipertencion()) {
                    fue_censado = true;
                    totalAmbosSexos.setPBCHipertensionPAMen140_90(totalAmbosSexos.getPBCHipertensionPAMen140_90() + 1);

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setPBCHipertensionPAMen140_90(totalhombres.getPBCHipertensionPAMen140_90() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setPBCHipertensionPAMen140_90(totalhombres_pueblos.getPBCHipertensionPAMen140_90() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setPBCHipertensionPAMen140_90(totalhombres_15a19.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setPBCHipertensionPAMen140_90(totalhombres_20a24.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setPBCHipertensionPAMen140_90(totalhombres_25a29.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setPBCHipertensionPAMen140_90(totalhombres_30a34.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setPBCHipertensionPAMen140_90(totalhombres_35a39.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setPBCHipertensionPAMen140_90(totalhombres_40a44.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setPBCHipertensionPAMen140_90(totalhombres_45a49.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setPBCHipertensionPAMen140_90(totalhombres_50a54.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setPBCHipertensionPAMen140_90(totalhombres_55a59.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setPBCHipertensionPAMen140_90(totalhombres_60a64.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setPBCHipertensionPAMen140_90(totalhombres_65a69.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setPBCHipertensionPAMen140_90(totalhombres_70a74.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setPBCHipertensionPAMen140_90(totalhombres_75a79.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setPBCHipertensionPAMen140_90(totalhombres_80omas.getPBCHipertensionPAMen140_90() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPBCHipertensionPAMen140_90(totalmujeres.getPBCHipertensionPAMen140_90() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setPBCHipertensionPAMen140_90(totalmujeres_pueblos.getPBCHipertensionPAMen140_90() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setPBCHipertensionPAMen140_90(totalmujeres_15a19.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setPBCHipertensionPAMen140_90(totalmujeres_20a24.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setPBCHipertensionPAMen140_90(totalmujeres_25a29.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setPBCHipertensionPAMen140_90(totalmujeres_30a34.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setPBCHipertensionPAMen140_90(totalmujeres_35a39.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setPBCHipertensionPAMen140_90(totalmujeres_40a44.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setPBCHipertensionPAMen140_90(totalmujeres_45a49.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setPBCHipertensionPAMen140_90(totalmujeres_50a54.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setPBCHipertensionPAMen140_90(totalmujeres_55a59.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setPBCHipertensionPAMen140_90(totalmujeres_60a64.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setPBCHipertensionPAMen140_90(totalmujeres_65a69.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setPBCHipertensionPAMen140_90(totalmujeres_70a74.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setPBCHipertensionPAMen140_90(totalmujeres_75a79.getPBCHipertensionPAMen140_90() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setPBCHipertensionPAMen140_90(totalmujeres_80omas.getPBCHipertensionPAMen140_90() + 1);
                        }

                    }

                }//FIN PA <140/90

                if (resultados[2] && pacientes.isDiabetico()) {
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPBCDiabetesHbA1CMen7(totalAmbosSexos.getPBCDiabetesHbA1CMen7() + 1);

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setPBCDiabetesHbA1CMen7(totalhombres.getPBCDiabetesHbA1CMen7() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setPBCDiabetesHbA1CMen7(totalhombres_pueblos.getPBCDiabetesHbA1CMen7() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setPBCDiabetesHbA1CMen7(totalhombres_15a19.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setPBCDiabetesHbA1CMen7(totalhombres_20a24.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setPBCDiabetesHbA1CMen7(totalhombres_25a29.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setPBCDiabetesHbA1CMen7(totalhombres_30a34.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setPBCDiabetesHbA1CMen7(totalhombres_35a39.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setPBCDiabetesHbA1CMen7(totalhombres_40a44.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setPBCDiabetesHbA1CMen7(totalhombres_45a49.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setPBCDiabetesHbA1CMen7(totalhombres_50a54.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setPBCDiabetesHbA1CMen7(totalhombres_55a59.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setPBCDiabetesHbA1CMen7(totalhombres_60a64.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setPBCDiabetesHbA1CMen7(totalhombres_65a69.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setPBCDiabetesHbA1CMen7(totalhombres_70a74.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setPBCDiabetesHbA1CMen7(totalhombres_75a79.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setPBCDiabetesHbA1CMen7(totalhombres_80omas.getPBCDiabetesHbA1CMen7() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPBCDiabetesHbA1CMen7(totalmujeres.getPBCDiabetesHbA1CMen7() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setPBCDiabetesHbA1CMen7(totalmujeres_pueblos.getPBCDiabetesHbA1CMen7() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setPBCDiabetesHbA1CMen7(totalmujeres_15a19.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setPBCDiabetesHbA1CMen7(totalmujeres_20a24.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setPBCDiabetesHbA1CMen7(totalmujeres_25a29.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setPBCDiabetesHbA1CMen7(totalmujeres_30a34.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setPBCDiabetesHbA1CMen7(totalmujeres_35a39.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setPBCDiabetesHbA1CMen7(totalmujeres_40a44.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setPBCDiabetesHbA1CMen7(totalmujeres_45a49.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setPBCDiabetesHbA1CMen7(totalmujeres_50a54.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setPBCDiabetesHbA1CMen7(totalmujeres_55a59.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setPBCDiabetesHbA1CMen7(totalmujeres_60a64.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setPBCDiabetesHbA1CMen7(totalmujeres_65a69.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setPBCDiabetesHbA1CMen7(totalmujeres_70a74.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setPBCDiabetesHbA1CMen7(totalmujeres_75a79.getPBCDiabetesHbA1CMen7() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setPBCDiabetesHbA1CMen7(totalmujeres_80omas.getPBCDiabetesHbA1CMen7() + 1);
                        }

                    }
                }//FIN HBA1C<7%

                if (resultados[2] && resultados[0] && resultados[3] && pacientes.isDiabetico()) {
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalAmbosSexos.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_pueblos.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_15a19.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_20a24.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_25a29.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_30a34.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_35a39.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_40a44.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_45a49.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_50a54.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_55a59.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_60a64.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_65a69.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_70a74.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_75a79.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalhombres_80omas.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_pueblos.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_15a19.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_20a24.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_25a29.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_30a34.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_35a39.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_40a44.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_45a49.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_50a54.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_55a59.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_60a64.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_65a69.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_70a74.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_75a79.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100(totalmujeres_80omas.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100() + 1);
                        }

                    }
                }//FIN HBA 1C PA COLESTEROL LDL
                //NO DIABETICAS

                if (resultados[3]) {
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalAmbosSexos.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_pueblos.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_15a19.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_20a24.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_25a29.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_30a34.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_35a39.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_40a44.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_45a49.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_50a54.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_55a59.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_60a64.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_65a69.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_70a74.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_75a79.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalhombres_80omas.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_pueblos.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_15a19.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_20a24.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_25a29.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_30a34.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_35a39.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_40a44.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_45a49.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_50a54.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_55a59.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_60a64.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_65a69.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_70a74.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_75a79.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100(totalmujeres_80omas.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100() + 1);
                        }

                    }
                }//FIN Personas bajo control riesgo cv no diabeticas

                //PERSONAS BAJO CONTROL con antecedentes Enfermedad Cardiovascular (ECV)	
                //PARTE 1 : ACIDO ACETIL
                if (resultados[5] && (pacientes.isACV() || pacientes.isIAM())) {
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalAmbosSexos.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_pueblos.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_15a19.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_20a24.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_25a29.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_30a34.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_35a39.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_40a44.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_45a49.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_50a54.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_55a59.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_60a64.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_65a69.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_70a74.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_75a79.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalhombres_80omas.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_pueblos.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_15a19.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_20a24.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_25a29.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_30a34.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_35a39.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_40a44.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_45a49.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_50a54.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_55a59.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_60a64.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_65a69.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_70a74.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_75a79.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setPBCconAntecedentesCCV_TratramientoAcidoAcetil(totalmujeres_80omas.getPBCconAntecedentesCCV_TratramientoAcidoAcetil() + 1);
                        }

                    }
                }//FIN antecedentes ccv con acetil

                if (resultados[6] && (pacientes.isACV() || pacientes.isIAM())) {
                    //siempre actualizar variable fue censado:
                    fue_censado = true;
                    totalAmbosSexos.setPBCconAntecedentesCCV_TratramientoEstanina(totalAmbosSexos.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);

                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_pueblos.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalhombres_15a19.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_15a19.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalhombres_20a24.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_20a24.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalhombres_25a29.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_25a29.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalhombres_30a34.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_30a34.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalhombres_35a39.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_35a39.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalhombres_40a44.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_40a44.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalhombres_45a49.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_45a49.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalhombres_50a54.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_50a54.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalhombres_55a59.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_55a59.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalhombres_60a64.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_60a64.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_65a69.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_70a74.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_75a79.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setPBCconAntecedentesCCV_TratramientoEstanina(totalhombres_80omas.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);

                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_pueblos.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        }
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 15 && edad <= 19) {
                            totalmujeres_15a19.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_15a19.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 20 && edad <= 24) {
                            totalmujeres_20a24.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_20a24.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 25 && edad <= 29) {
                            totalmujeres_25a29.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_25a29.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 30 && edad <= 34) {
                            totalmujeres_30a34.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_30a34.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 35 && edad <= 39) {
                            totalmujeres_35a39.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_35a39.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 40 && edad <= 44) {
                            totalmujeres_40a44.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_40a44.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 45 && edad <= 49) {
                            totalmujeres_45a49.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_45a49.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 50 && edad <= 54) {
                            totalmujeres_50a54.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_50a54.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 55 && edad <= 59) {
                            totalmujeres_55a59.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_55a59.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 60 && edad <= 64) {
                            totalmujeres_60a64.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_60a64.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_65a69.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_70a74.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_75a79.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setPBCconAntecedentesCCV_TratramientoEstanina(totalmujeres_80omas.getPBCconAntecedentesCCV_TratramientoEstanina() + 1);
                        }

                    }
                }//FIN HBA1C<7%

            } else {
                //no se tomo al paciente habilitado:
                //no cumple el requisito de que a lo menos una atencion sea censable (este dentro del rango 1 año)

            }

            //revisamos si el paciente fue censado
            if (fue_censado) {
                //censadosB.add(pacientes);

            } else {
                //nocensadosB.add(pacientes);
            }

        }//FIN FOR

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
        totalhombres_80omas.setColumnName1("Hombres de 80 más años");
        totalmujeres_80omas.setColumnName1("Mujeres de 80 o más años");
        totalhombres_pueblos.setColumnName1("Hombres de pueblos originarios");
        totalmujeres_pueblos.setColumnName1("Mujeres de pueblos originarios");

        B_elementos.clear();
        B_elementos.add(totalAmbosSexos);
        B_elementos.add(totalhombres);
        B_elementos.add(totalmujeres);
        B_elementos.add(totalhombres_15a19);
        B_elementos.add(totalmujeres_15a19);

        B_elementos.add(totalhombres_20a24);
        B_elementos.add(totalmujeres_20a24);

        B_elementos.add(totalhombres_25a29);
        B_elementos.add(totalmujeres_25a29);

        B_elementos.add(totalhombres_30a34);
        B_elementos.add(totalmujeres_30a34);

        B_elementos.add(totalhombres_35a39);
        B_elementos.add(totalmujeres_35a39);

        B_elementos.add(totalhombres_40a44);
        B_elementos.add(totalmujeres_40a44);

        B_elementos.add(totalhombres_45a49);
        B_elementos.add(totalmujeres_45a49);

        B_elementos.add(totalhombres_50a54);
        B_elementos.add(totalmujeres_50a54);

        B_elementos.add(totalhombres_55a59);
        B_elementos.add(totalmujeres_55a59);

        B_elementos.add(totalhombres_60a64);
        B_elementos.add(totalmujeres_60a64);

        B_elementos.add(totalhombres_65a69);
        B_elementos.add(totalmujeres_65a69);

        B_elementos.add(totalhombres_70a74);
        B_elementos.add(totalmujeres_70a74);

        B_elementos.add(totalhombres_75a79);
        B_elementos.add(totalmujeres_75a79);

        B_elementos.add(totalhombres_80omas);
        B_elementos.add(totalmujeres_80omas);

        B_elementos.add(totalhombres_pueblos);
        B_elementos.add(totalmujeres_pueblos);

        return B_elementos;
    }

    public List<CensoCCVSeccionC> censoCCVSeccionC() {
        CensoCCVSeccionC totalAmbosSexos = new CensoCCVSeccionC();
        CensoCCVSeccionC totalhombres = new CensoCCVSeccionC();
        CensoCCVSeccionC totalmujeres = new CensoCCVSeccionC();
        CensoCCVSeccionC total_15a64 = new CensoCCVSeccionC();
        CensoCCVSeccionC total_65ymas = new CensoCCVSeccionC();

        List<Paciente> pacientes_habilitados = ejbPaciente.findbyPacienteActivo();
        List<CartolaSeguimientoCCV> ccv;
        List<CartolaSeguimientoCCV> ccv_filtro;
        List<CartolaSeguimientoCCV> ccv_ordenado;
        boolean resultados[];
        for (Paciente pacientes : pacientes_habilitados) {
            boolean fue_censado = false;
            int edad;
            resultados = new boolean[15];
            ccv = new ArrayList<>();
            ccv_filtro = new ArrayList<>();
            ccv_ordenado = new ArrayList<>();
            ccv = ejbCartola.findByPaciente(pacientes);//obtengo todas las cartolas por  pacientes
            ccv_ordenado = filtro(ccv);
            ccv_filtro = filtro_censables(ccv_ordenado);//se ordenan las cartolas, y se filtran solo als que entran al censo
            for (int i = 0; i < 15; i++) {
                resultados[i] = false;//por defecto todos son falsos hasta que no se cambien
            }

            //en este punto por paciente tenemos las cartola que entran en el censo 
            //filtramos por paciente si su ultima cartola , la fecha mas alta que tiene es censable
            if (ccv_filtro.size() > 0) {//si tiene un elemento censable y es diabetico

                resultados = Resultados_C(ccv_filtro, resultados);
                edad = ccv_filtro.get(ccv_filtro.size() - 1).getEdad_paciente();

                if (pacientes.isDiabetico()) {
                    if (resultados[0]) {//si tiene RAC

                        fue_censado = true;
                        totalAmbosSexos.setPDI12MESES_RAC(totalAmbosSexos.getPDI12MESES_RAC() + 1);
                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setPDI12MESES_RAC(total_15a64.getPDI12MESES_RAC() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setPDI12MESES_RAC(total_65ymas.getPDI12MESES_RAC() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setPDI12MESES_RAC(totalhombres.getPDI12MESES_RAC() + 1);
                            //Dependiendo de la edad las condiciones son:

                        } else {//Genero Femenino
                            totalmujeres.setPDI12MESES_RAC(totalmujeres.getPDI12MESES_RAC() + 1);

                        }
                    }//FIN RAC

                    if (resultados[1]) {//si tiene VFG

                        fue_censado = true;
                        totalAmbosSexos.setPDI12MESES_VFG(totalAmbosSexos.getPDI12MESES_VFG() + 1);
                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setPDI12MESES_VFG(total_15a64.getPDI12MESES_VFG() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setPDI12MESES_VFG(total_65ymas.getPDI12MESES_VFG() + 1);
                        }
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setPDI12MESES_VFG(totalhombres.getPDI12MESES_VFG() + 1);
                            //Dependiendo de la edad las condiciones son:

                        } else {//Genero Femenino
                            totalmujeres.setPDI12MESES_VFG(totalmujeres.getPDI12MESES_VFG() + 1);

                        }
                    }//FIN VFG

                    if (resultados[2]) {//si tiene FONDO OJO

                        fue_censado = true;
                        totalAmbosSexos.setPDI12MESES_FondoDeOjo(totalAmbosSexos.getPDI12MESES_FondoDeOjo() + 1);

                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setPDI12MESES_FondoDeOjo(total_15a64.getPDI12MESES_FondoDeOjo() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setPDI12MESES_FondoDeOjo(total_65ymas.getPDI12MESES_FondoDeOjo() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setPDI12MESES_FondoDeOjo(totalhombres.getPDI12MESES_FondoDeOjo() + 1);
                            //Dependiendo de la edad las condiciones son:
                        } else {//Genero Femenino
                            totalmujeres.setPDI12MESES_FondoDeOjo(totalmujeres.getPDI12MESES_FondoDeOjo() + 1);
                        }

                    }//FIN FONDO OJO

                    if (resultados[3]) {//si tiene INSULINA

                        fue_censado = true;
                        totalAmbosSexos.setTratamientoInsulina(totalAmbosSexos.getTratamientoInsulina() + 1);
                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setTratamientoInsulina(total_15a64.getTratamientoInsulina() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setTratamientoInsulina(total_65ymas.getTratamientoInsulina() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setTratamientoInsulina(totalhombres.getTratamientoInsulina() + 1);
                            //Dependiendo de la edad las condiciones son:
                        } else {//Genero Femenino
                            totalmujeres.setTratamientoInsulina(totalmujeres.getTratamientoInsulina() + 1);
                        }
                    }//FIN insulina

                    if (resultados[4]) {//si tiene HBA1C MAYOR 9

                        fue_censado = true;
                        totalAmbosSexos.setHbA1C9(totalAmbosSexos.getHbA1C9() + 1);
                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setHbA1C9(total_15a64.getHbA1C9() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setHbA1C9(total_65ymas.getHbA1C9() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setHbA1C9(totalhombres.getHbA1C9() + 1);
                            //Dependiendo de la edad las condiciones son:

                        } else {//Genero Femenino
                            totalmujeres.setHbA1C9(totalmujeres.getHbA1C9() + 1);

                        }
                    }//FIN HBA1C9

                    if (resultados[5]) {//si tiene IECA O ARAII

                        fue_censado = true;
                        totalAmbosSexos.setTratamientoConIECAoARRAII(totalAmbosSexos.getTratamientoConIECAoARRAII() + 1);

                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setTratamientoConIECAoARRAII(total_15a64.getTratamientoConIECAoARRAII() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setTratamientoConIECAoARRAII(total_65ymas.getTratamientoConIECAoARRAII() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setTratamientoConIECAoARRAII(totalhombres.getTratamientoConIECAoARRAII() + 1);
                            //Dependiendo de la edad las condiciones son:
                        } else {//Genero Femenino
                            totalmujeres.setTratamientoConIECAoARRAII(totalmujeres.getTratamientoConIECAoARRAII() + 1);

                        }
                    }//FIN ARAII O IECA

                    if (resultados[6]) {//si tiene EXAMEN LDL

                        fue_censado = true;
                        totalAmbosSexos.setExamenColesterolLDLVigente(totalAmbosSexos.getExamenColesterolLDLVigente() + 1);
                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setExamenColesterolLDLVigente(total_15a64.getExamenColesterolLDLVigente() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setExamenColesterolLDLVigente(total_65ymas.getExamenColesterolLDLVigente() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setExamenColesterolLDLVigente(totalhombres.getExamenColesterolLDLVigente() + 1);
                            //Dependiendo de la edad las condiciones son:
                        } else {//Genero Femenino
                            totalmujeres.setExamenColesterolLDLVigente(totalmujeres.getExamenColesterolLDLVigente() + 1);
                        }
                    }//FIN LDL VIEGENTE

                    if (resultados[7]) {//si tiene RIESGO BAJO ULCERACION

                        fue_censado = true;
                        totalAmbosSexos.setUlceracion_RiesgoBajo(totalAmbosSexos.getUlceracion_RiesgoBajo() + 1);

                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setUlceracion_RiesgoBajo(total_15a64.getUlceracion_RiesgoBajo() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setUlceracion_RiesgoBajo(total_65ymas.getUlceracion_RiesgoBajo() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setUlceracion_RiesgoBajo(totalhombres.getUlceracion_RiesgoBajo() + 1);
                            //Dependiendo de la edad las condiciones son:
                        } else {//Genero Femenino
                            totalmujeres.setUlceracion_RiesgoBajo(totalmujeres.getUlceracion_RiesgoBajo() + 1);
                        }
                    }//FIN RIESGO BAJO ULCERACION

                    if (resultados[8]) {//si tiene RIESGO MODERADO ULCERACION

                        fue_censado = true;
                        totalAmbosSexos.setUlceracion_RiesgoModerado(totalAmbosSexos.getUlceracion_RiesgoModerado() + 1);
                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setUlceracion_RiesgoModerado(total_15a64.getUlceracion_RiesgoModerado() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setUlceracion_RiesgoModerado(total_65ymas.getUlceracion_RiesgoModerado() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setUlceracion_RiesgoModerado(totalhombres.getUlceracion_RiesgoModerado() + 1);
                            //Dependiendo de la edad las condiciones son:
                        } else {//Genero Femenino
                            totalmujeres.setUlceracion_RiesgoModerado(totalmujeres.getUlceracion_RiesgoModerado() + 1);
                        }
                    }//FIN RIESGO MODERADO ULCERACION

                    if (resultados[9]) {//si tiene RIESGO ALTO ULCERACION

                        fue_censado = true;
                        totalAmbosSexos.setUlceracion_RiesgoAlto(totalAmbosSexos.getUlceracion_RiesgoAlto() + 1);
                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setUlceracion_RiesgoAlto(total_15a64.getUlceracion_RiesgoAlto() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setUlceracion_RiesgoAlto(total_65ymas.getUlceracion_RiesgoAlto() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setUlceracion_RiesgoAlto(totalhombres.getUlceracion_RiesgoAlto() + 1);
                            //Dependiendo de la edad las condiciones son:
                        } else {//Genero Femenino
                            totalmujeres.setUlceracion_RiesgoAlto(totalmujeres.getUlceracion_RiesgoAlto() + 1);

                        }
                    }//FIN RIESGO ALTO ULCERACION

                    if (resultados[10]) {//si tiene RIESGO ALTO ULCERACION

                        fue_censado = true;
                        totalAmbosSexos.setUlceracion_RiesgoMaximo(totalAmbosSexos.getUlceracion_RiesgoMaximo() + 1);
                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setUlceracion_RiesgoMaximo(total_15a64.getUlceracion_RiesgoMaximo() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setUlceracion_RiesgoMaximo(total_65ymas.getUlceracion_RiesgoMaximo() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setUlceracion_RiesgoMaximo(totalhombres.getUlceracion_RiesgoMaximo() + 1);
                            //Dependiendo de la edad las condiciones son:
                        } else {//Genero Femenino
                            totalmujeres.setUlceracion_RiesgoMaximo(totalmujeres.getUlceracion_RiesgoMaximo() + 1);

                        }
                    }//FIN RIESGO maximo ULCERACION

                    if (resultados[11]) {//CURACION CONVENCIONAL

                        fue_censado = true;
                        totalAmbosSexos.setUlcerasActivas_CuracionCo(totalAmbosSexos.getUlcerasActivas_CuracionCo() + 1);

                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setUlcerasActivas_CuracionCo(total_15a64.getUlcerasActivas_CuracionCo() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setUlcerasActivas_CuracionCo(total_65ymas.getUlcerasActivas_CuracionCo() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setUlcerasActivas_CuracionCo(totalhombres.getUlcerasActivas_CuracionCo() + 1);
                            //Dependiendo de la edad las condiciones son:
                        } else {//Genero Femenino
                            totalmujeres.setUlcerasActivas_CuracionCo(totalmujeres.getUlcerasActivas_CuracionCo() + 1);

                        }
                    }//FIN CURACION CONVENCIONAL

                    if (resultados[12]) {//CURACION AVANZADA

                        fue_censado = true;
                        totalAmbosSexos.setUlcerasActivas_CuracionAvan(totalAmbosSexos.getUlcerasActivas_CuracionAvan() + 1);
                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setUlcerasActivas_CuracionAvan(total_15a64.getUlcerasActivas_CuracionAvan() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setUlcerasActivas_CuracionAvan(total_65ymas.getUlcerasActivas_CuracionAvan() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setUlcerasActivas_CuracionAvan(totalhombres.getUlcerasActivas_CuracionAvan() + 1);
                            //Dependiendo de la edad las condiciones son:
                        } else {//Genero Femenino
                            totalmujeres.setUlcerasActivas_CuracionAvan(totalmujeres.getUlcerasActivas_CuracionAvan() + 1);

                        }
                    }//FIN CURACION AVANZADA

                    if (resultados[13]) {//CURACION qualidiab

                        fue_censado = true;
                        totalAmbosSexos.setPDE12Meses_Qualdiab_Otros(totalAmbosSexos.getPDE12Meses_Qualdiab_Otros() + 1);

                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setPDE12Meses_Qualdiab_Otros(total_15a64.getPDE12Meses_Qualdiab_Otros() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setPDE12Meses_Qualdiab_Otros(total_65ymas.getPDE12Meses_Qualdiab_Otros() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setPDE12Meses_Qualdiab_Otros(totalhombres.getPDE12Meses_Qualdiab_Otros() + 1);
                            //Dependiendo de la edad las condiciones son:
                        } else {//Genero Femenino
                            totalmujeres.setPDE12Meses_Qualdiab_Otros(totalmujeres.getPDE12Meses_Qualdiab_Otros() + 1);
                        }
                    }//FIN CURACION qualidiab

                }

                if (pacientes.isHipertencion()) {
                    boolean rachiper = hipertensoRAC(ccv_filtro);
                    if (rachiper) {//RAC

                        fue_censado = true;
                        totalAmbosSexos.setRAC(totalAmbosSexos.getRAC() + 1);

                        if (edad >= 15 && edad <= 64) {
                            total_15a64.setRAC(total_15a64.getRAC() + 1);
                        } else if (edad >= 65) {
                            total_65ymas.setRAC(total_65ymas.getRAC() + 1);
                        }

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            totalhombres.setRAC(totalhombres.getRAC() + 1);
                            //Dependiendo de la edad las condiciones son:
                        } else {//Genero Femenino
                            totalmujeres.setRAC(totalmujeres.getRAC() + 1);
                        }
                    }//FIN RAC

                }

            } else {

            }
        }//FIN FOR
        totalAmbosSexos.setColumnName1("TOTAL");
        totalhombres.setColumnName1("Hombres");
        totalmujeres.setColumnName1("Mujeres");
        total_15a64.setColumnName1("EDAD: 15 a 64 años");
        total_65ymas.setColumnName1("EDAD: 65 y más");

        C_elementos.clear();
        C_elementos.add(totalAmbosSexos);
        C_elementos.add(total_15a64);
        C_elementos.add(total_65ymas);
        C_elementos.add(totalhombres);
        C_elementos.add(totalmujeres);
        return C_elementos;

    }

    public String ClasificacionERC(List<CartolaSeguimientoCCV> ccv) {
        try {

            for (int i = ccv.size() - 1; i >= 0; i--) {
                if (ccv.get(i).getDet_Prev_ERC() != null) {
                    if (ccv.get(i).getDet_Prev_ERC().equals("SIN ENFERMEDAD RENAL")) {
                        return "SIN ENFERMEDAD RENAL";
                    }
                    if (ccv.get(i).getDet_Prev_ERC().equals("ETAPA G1") || ccv.get(i).getDet_Prev_ERC().equals("ETAPA G2")) {
                        return "ETAPA G1_2";
                    }
                    if (ccv.get(i).getDet_Prev_ERC().equals("ETAPA G3a")) {
                        return "ETAPA G3a";
                    }
                    if (ccv.get(i).getDet_Prev_ERC().equals("ETAPA G3b")) {
                        return "ETAPA G3b";
                    }
                    if (ccv.get(i).getDet_Prev_ERC().equals("ETAPA G4")) {
                        return "ETAPA G4";
                    }
                    if (ccv.get(i).getDet_Prev_ERC().equals("ETAPA G5")) {
                        return "ETAPA G5";
                    }

                }

            }

            return "NULO";

        } catch (Exception e) {

            return "NULO";
        }

    }

    public boolean[] Resultados_B(List<CartolaSeguimientoCCV> ccv, boolean[] resultados) {
        try {
            int i = 0;
            int bandera1 = 0, bandera2 = 0, bandera3 = 0, bandera4 = 0, bandera5 = 0, bandera6 = 0;
            for (int j = ccv.size() - 1; j >= 0; j--) {

                if (ccv.get(j).getPa_de_pie1() < 140 && ccv.get(j).getPa_sentado1() < 140
                        && ccv.get(j).getPa_de_pie2() < 90 && ccv.get(j).getPa_sentado2() < 90
                        && j == ccv.size() - 1//y ademas es la ultima cartola DOPA
                        ) {//dopa

                    resultados[0] = true;
                }

                if (ccv.get(j).getPa_de_pie1() < 130 && ccv.get(j).getPa_sentado1() < 130
                        && ccv.get(j).getPa_de_pie2() < 80 && ccv.get(j).getPa_sentado2() < 80
                        && j == ccv.size() - 1) {//dopa
                    resultados[1] = true;
                }

                if (ccv.get(j).getHba1C_valor() > 0.0 && bandera2 == 0) {
                    if (ccv.get(j).getHba1C_valor() <= 7) {
                        resultados[2] = true;
                    } else {
                        resultados[2] = false;
                    }
                    bandera2 = 1;
                }
                if (ccv.get(j).getColesterolLDL_valor() > 0.0 && bandera3 == 0) {//regresion
                    //si el valor es distinto de cero , se lleno , entonces se ve su valor:
                    if (ccv.get(j).getColesterolLDL_valor() < 100) {
                        resultados[3] = true;
                    } else {
                        resultados[3] = false;
                    }

                    bandera3 = 1;
                }
                if (ccv.get(j).getRiesgo_cardiovascular().equals("ALTO") && j == ccv.size() - 1) {//dopa 
                    resultados[4] = true;
                }
                if (ccv.get(j).isAcido_acetilsalicilico()) {
                    resultados[5] = true;
                }
                if (ccv.get(j).isEsteatinas_bool()) {
                    resultados[6] = true;
                }

            }
            return resultados;

        } catch (Exception e) {

            return resultados;
        }

    }

    public boolean[] Resultados_C(List<CartolaSeguimientoCCV> ccv, boolean[] resultados) {
        int bandera1 = 0, bandera2 = 0, bandera3 = 0, bandera4 = 0, bandera5 = 0,
                bandera6 = 0, bandera7 = 0, bandera8 = 0, bandera9 = 0, bandera10 = 0, bandera11 = 0, bandera12 = 0, bandera13 = 0;
        int bandera14 = 0;
        try {
            for (int j = ccv.size() - 1; j >= 0; j--) {
                if (ccv.get(j).getMicroALB24H_estado().equals("RESULTADO") && bandera1 == 0) {
                    resultados[0] = true;
                    bandera1 = 1;
                }
                if (ccv.get(j).getMDRD_estado().equals("RESULTADO") && bandera2 == 0) {
                    resultados[1] = true;
                    bandera2 = 1;
                }
                if (ccv.get(j).getFondoOJO_estado().equals("RESULTADO") && bandera3 == 0) {
                    resultados[2] = true;
                    bandera3 = 1;
                }
                if (ccv.get(j).isInsulina_bool() && bandera4 == 0) {
                    resultados[3] = true;
                    bandera4 = 1;
                }
                if (ccv.get(j).getHba1C_valor() > 0 && bandera5 == 0) {
                    if (ccv.get(j).getHba1C_valor() >= 9) {
                        resultados[4] = true;
                    } else {
                        resultados[4] = false;
                    }
                    bandera5 = 1;
                }
                if ((ccv.get(j).isIECA_bool() || ccv.get(j).isARAII_bool()) && bandera6 == 0) {
                    resultados[5] = true;
                    bandera6 = 1;
                }
                if (ccv.get(j).getColesterolLDL_estado().equals("RESULTADO") && bandera7 == 0) {
                    resultados[6] = true;
                    bandera7 = 1;
                }
                if (ccv.get(j).getEstimacionRiesgoUlceracionPie() != null && bandera8 == 0) {
                    if (ccv.get(j).getEstimacionRiesgoUlceracionPie().equals("Riesgo bajo") && bandera8 == 0) {
                        resultados[7] = true;
                        bandera8 = 1;
                    } else if (ccv.get(j).getEstimacionRiesgoUlceracionPie().equals("Riesgo moderado") && bandera8 == 0) {
                        resultados[8] = true;
                        bandera8 = 1;
                    } else if (ccv.get(j).getEstimacionRiesgoUlceracionPie().equals("Riesgo alto") && bandera8 == 0) {
                        resultados[9] = true;
                        bandera8 = 1;
                    } else if (ccv.get(j).getEstimacionRiesgoUlceracionPie().equals("Riesgo maximo") && bandera8 == 0) {
                        resultados[10] = true;
                        bandera8 = 1;
                    }

                }
                if (ccv.get(j).getCuracionPie_DM() != null && bandera9 == 0) {

                    if (ccv.get(j).getCuracionPie_DM().equals("Curacion Convencional") && bandera9 == 0) {
                        resultados[11] = true;
                        bandera9 = 1;
                    } else if (ccv.get(j).getCuracionPie_DM().equals("Curacion Avanzada") && bandera9 == 0) {
                        resultados[12] = true;
                        bandera9 = 1;
                    }
                }

                if (ccv.get(j).isQUALDIAB() && bandera10 == 0) {
                    resultados[13] = true;
                    bandera10 = 1;
                }
            }
        } catch (Exception e) {

            return resultados;
        }
        return resultados;
    }

    public boolean hipertensoRAC(List<CartolaSeguimientoCCV> ccv) {
        int bandera1 = 0;
        boolean resultado = false;
        try {
            for (int j = ccv.size() - 1; j >= 0; j--) {
                if (bandera1 == 1) {
                    break;
                }
                if (ccv.get(j).getMicroALB24H_estado().equals("RESULTADO") && bandera1 == 0) {
                    resultado = true;
                    bandera1 = 1;
                }

            }
            return resultado;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean isCensable(Date fecha) {

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_sistema = new Date();
            dateFormat.format(fecha_sistema);
            int days = Days.daysBetween(new DateTime(fecha), new DateTime(fecha_sistema)).getDays();

            if (days <= 365 && days >= 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public List<CartolaSeguimientoCCV> filtro_censables(List<CartolaSeguimientoCCV> entrada) {
        List<CartolaSeguimientoCCV> lista = new ArrayList<>();

        for (int i = 0; i < entrada.size(); i++) {
            if (isCensable(entrada.get(i).getFecha_control()) && entrada.get(i).getEdad_paciente() >= 15) {
                lista.add(entrada.get(i));
            }
        }
        return lista;

    }

    public List<CartolaSeguimientoCCV> filtro(List<CartolaSeguimientoCCV> entrada) {

        if (entrada.size() <= 1) {
            return entrada;
        }

        int posicion_media = (int) Math.ceil((double) entrada.size() / 2);
        CartolaSeguimientoCCV ccv_pivot;
        ccv_pivot = entrada.get(posicion_media);

        List<CartolaSeguimientoCCV> menores = new ArrayList<CartolaSeguimientoCCV>();
        List<CartolaSeguimientoCCV> mayores = new ArrayList<CartolaSeguimientoCCV>();

        for (int i = 0; i < entrada.size(); i++) {
            if (entrada.get(i).getFecha_control().compareTo(ccv_pivot.getFecha_control()) <= 0) {
                if (i == posicion_media) {
                    continue;
                }
                menores.add(entrada.get(i));
            } else {
                mayores.add(entrada.get(i));
            }
        }//FIN FOR

        return concatenear(filtro(menores), ccv_pivot, filtro(mayores));
    }

    public List<CartolaSeguimientoCCV> concatenear(List<CartolaSeguimientoCCV> less, CartolaSeguimientoCCV pivot, List<CartolaSeguimientoCCV> mayores) {

        List<CartolaSeguimientoCCV> lista = new ArrayList<CartolaSeguimientoCCV>();

        for (int i = 0; i < less.size(); i++) {
            lista.add(less.get(i));
        }

        lista.add(pivot);

        for (int i = 0; i < mayores.size(); i++) {
            lista.add(mayores.get(i));
        }

        return lista;
    }

}
