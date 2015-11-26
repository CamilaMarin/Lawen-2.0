package managedbeans.adultoMayor.censo;

import entities.Paciente;
import entities.adultoMayor.CartolaSeguimientoPSAM;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import managedbeans.PacienteController;
import sessionbeans.adultoMayor.CartolaSeguimientoPSAMFacadeLocal;
import org.joda.time.DateTime;
import org.joda.time.Days;
import sessionbeans.PacienteFacadeLocal;

/**
 *
 * @author matias
 */
@Named(value = "consultasCenso")
@SessionScoped
public class ConsultasCenso implements Serializable {
    /*Para consultas de cartola*/

    @EJB
    private CartolaSeguimientoPSAMFacadeLocal ejbCartolaFacade;
    /*Para incluir consultas a ingreso*/

    @EJB
    private PacienteFacadeLocal ejbPaciente;

    /*Listas de resultados para cada seccion del Censo*/
    private List<CensoSeccionA> elementos = new ArrayList<>();
    private List<CensoSeccionA> A1elementos = new ArrayList<>();
    private List<CensoSeccionB> B_elementos = new ArrayList<>();
    private List<CensoSeccionC> C_elementos = new ArrayList<>();
    private List<CensoSeccionD> D_elementos = new ArrayList<>();
    private List<CensoSeccionE> E_elementos = new ArrayList<>();
    private List<CensoSeccionF> F_elementos = new ArrayList<>();
    private List<CensoPSAMExcluidos> Pacientes_excluidos;
    private int pacientesCensados = 0;
    /*Constructores*/

    public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Carga Completada", "Carga Completada"));
    }

    public void onCancel() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Progress Cancelled", "Progress Cancelled"));
    }

    public CartolaSeguimientoPSAMFacadeLocal getEjbCartolaFacade() {
        return ejbCartolaFacade;
    }

    public void setEjbCartolaFacade(CartolaSeguimientoPSAMFacadeLocal ejbCartolaFacade) {
        this.ejbCartolaFacade = ejbCartolaFacade;
    }

    public ConsultasCenso() {
    }

    public List<CensoSeccionA> getElementos() {
        return elementos;
    }

    public void setElementos(List<CensoSeccionA> elementos) {
        this.elementos = elementos;
    }

    public List<CensoSeccionB> getB_elementos() {
        return B_elementos;

    }

    public void setB_elementos(List<CensoSeccionB> B_elementos) {
        this.B_elementos = B_elementos;
    }

    public List<CensoSeccionC> getC_elementos() {
        return C_elementos;
    }

    public void setC_elementos(List<CensoSeccionC> C_elementos) {
        this.C_elementos = C_elementos;
    }

    public List<CensoSeccionD> getD_elementos() {
        return D_elementos;
    }

    public void setD_elementos(List<CensoSeccionD> D_elementos) {
        this.D_elementos = D_elementos;
    }

    public List<CensoSeccionE> getE_elementos() {
        return E_elementos;
    }

    public void setE_elementos(List<CensoSeccionE> E_elementos) {
        this.E_elementos = E_elementos;
    }

    public List<CensoSeccionF> getF_elementos() {
        return F_elementos;
    }

    public void setF_elementos(List<CensoSeccionF> F_elementos) {
        this.F_elementos = F_elementos;
    }

    public List<CensoPSAMExcluidos> getPacientes_excluidos() {
        return Pacientes_excluidos;
    }

    public void setPacientes_excluidos(List<CensoPSAMExcluidos> Pacientes_excluidos) {
        this.Pacientes_excluidos = Pacientes_excluidos;
    }

    private CartolaSeguimientoPSAMFacadeLocal getFacade() {
        return ejbCartolaFacade;
    }

    public int getPacientesCensados() {
        return pacientesCensados;
    }

    public void setPacientesCensados(int pacientesCensados) {
        this.pacientesCensados = pacientesCensados;
    }

    public List<CensoSeccionA> getA1elementos() {
        return A1elementos;
    }

    public void setA1elementos(List<CensoSeccionA> A1elementos) {
        this.A1elementos = A1elementos;
    }

    public void init() {
        pacientesCensados = 0;
        Pacientes_excluidos = new ArrayList<>();
        elementos = censoPSAMSeccionA();
        B_elementos = censoPSAMSeccionB();
        C_elementos = censoPSAMSeccionC();
        D_elementos = censoPSAMSeccionD();
        E_elementos = censoPSAMSeccionE();
        F_elementos = censoPSAMSeccionF();
        List<Paciente> pasivos_fallecimiento = ejbPaciente.findbyPacientePasivoFallecimiento();
        List<Paciente> pasivos_prevision = ejbPaciente.findbyPacientePasivoPrevision();
        List<Paciente> pasivos_trasalado = ejbPaciente.findbyPacientePasivoTraslado();

        for (Paciente fallecidos : pasivos_fallecimiento) {
            CensoPSAMExcluidos nocensado = new CensoPSAMExcluidos();
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
            CensoPSAMExcluidos nocensado = new CensoPSAMExcluidos();
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
            CensoPSAMExcluidos nocensado = new CensoPSAMExcluidos();
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

    /**
     * Calcula el censo para la seccion A
     *
     * @return
     */
    public List<CensoSeccionA> censoPSAMSeccionA() {

        CensoSeccionA totalAmbosSexos = new CensoSeccionA();
        CensoSeccionA totalhombres = new CensoSeccionA();
        CensoSeccionA totalmujeres = new CensoSeccionA();
        CensoSeccionA totalhombres_65a69 = new CensoSeccionA();
        CensoSeccionA totalmujeres_65a69 = new CensoSeccionA();
        CensoSeccionA totalhombres_70a74 = new CensoSeccionA();
        CensoSeccionA totalmujeres_70a74 = new CensoSeccionA();
        CensoSeccionA totalhombres_75a79 = new CensoSeccionA();
        CensoSeccionA totalmujeres_75a79 = new CensoSeccionA();
        CensoSeccionA totalhombres_80omas = new CensoSeccionA();
        CensoSeccionA totalmujeres_80omas = new CensoSeccionA();
        CensoSeccionA totalhombres_pueblos = new CensoSeccionA();
        CensoSeccionA totalmujeres_pueblos = new CensoSeccionA();

        //SECCION A1
        CensoSeccionA A1totalAmbosSexos = new CensoSeccionA();
        CensoSeccionA A1totalhombres = new CensoSeccionA();
        CensoSeccionA A1totalmujeres = new CensoSeccionA();
        CensoSeccionA A1totalhombres_65a69 = new CensoSeccionA();
        CensoSeccionA A1totalmujeres_65a69 = new CensoSeccionA();
        CensoSeccionA A1totalhombres_70a74 = new CensoSeccionA();
        CensoSeccionA A1totalmujeres_70a74 = new CensoSeccionA();
        CensoSeccionA A1totalhombres_75a79 = new CensoSeccionA();
        CensoSeccionA A1totalmujeres_75a79 = new CensoSeccionA();
        CensoSeccionA A1totalhombres_80omas = new CensoSeccionA();
        CensoSeccionA A1totalmujeres_80omas = new CensoSeccionA();
        CensoSeccionA A1totalhombres_pueblos = new CensoSeccionA();
        CensoSeccionA A1totalmujeres_pueblos = new CensoSeccionA();

        List<Paciente> pacientes_habilitados = ejbPaciente.findbyPacienteActivo();
        List<CartolaSeguimientoPSAM> ccv;
        List<CartolaSeguimientoPSAM> ccv_filtro;
        List<CartolaSeguimientoPSAM> ccv_ordenado;
        for (Paciente pacientes : pacientes_habilitados) {
            boolean fue_censado = false;
            int edad;
            boolean registra_unaatencion = false;
            ccv = ejbCartolaFacade.findByPaciente(pacientes);//obtengo todas las cartolas por  pacientes
            if (ccv.size() > 0) {
                registra_unaatencion = true;
            }
            ccv_ordenado = filtro(ccv);
            ccv_filtro = filtro_censables(ccv_ordenado);//se ordenan las cartolas, y se filtran solo als que entran al censo
            if (ccv_filtro.size() > 0) {
                edad = ccv_filtro.get(ccv_filtro.size() - 1).getEdad();
                boolean programamas = Resultadoprograma(ccv_filtro);
                //ACA FALTA EL IF SI ES EFAM O SI ES BARTHEL AGREGAR ACA
                if (ccv_filtro.get(ccv_filtro.size() - 1).getClasificacion_efam().equals("Autovalente sin riesgo")) {//consultas Autovalente sin riesgo
                    fue_censado = true;
                    totalAmbosSexos.setContadorAutovalenteSinRiesgo(totalAmbosSexos.getContadorAutovalenteSinRiesgo() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setContadorAutovalenteSinRiesgo(totalhombres.getContadorAutovalenteSinRiesgo() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setContadorAutovalenteSinRiesgo(totalhombres_pueblos.getContadorAutovalenteSinRiesgo() + 1);
                        }
                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setContadorAutovalenteSinRiesgo(totalhombres_65a69.getContadorAutovalenteSinRiesgo() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setContadorAutovalenteSinRiesgo(totalhombres_70a74.getContadorAutovalenteSinRiesgo() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setContadorAutovalenteSinRiesgo(totalhombres_75a79.getContadorAutovalenteSinRiesgo() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setContadorAutovalenteSinRiesgo(totalhombres_80omas.getContadorAutovalenteSinRiesgo() + 1);
                        }
                    } else {//consultas mujeres 
                        totalmujeres.setContadorAutovalenteSinRiesgo(totalmujeres.getContadorAutovalenteSinRiesgo() + 1);
                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setContadorAutovalenteSinRiesgo(totalmujeres_pueblos.getContadorAutovalenteSinRiesgo() + 1);
                        }
                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setContadorAutovalenteSinRiesgo(totalmujeres_65a69.getContadorAutovalenteSinRiesgo() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setContadorAutovalenteSinRiesgo(totalmujeres_70a74.getContadorAutovalenteSinRiesgo() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setContadorAutovalenteSinRiesgo(totalmujeres_75a79.getContadorAutovalenteSinRiesgo() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setContadorAutovalenteSinRiesgo(totalmujeres_80omas.getContadorAutovalenteSinRiesgo() + 1);
                        }
                    }

                    //SECCION A1
                    if (programamas) {

                        A1totalAmbosSexos.setContadorAutovalenteSinRiesgo(A1totalAmbosSexos.getContadorAutovalenteSinRiesgo() + 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            A1totalhombres.setContadorAutovalenteSinRiesgo(A1totalhombres.getContadorAutovalenteSinRiesgo() + 1);
                            if (pacientes.isEtnia()) {
                                A1totalhombres_pueblos.setContadorAutovalenteSinRiesgo(A1totalhombres_pueblos.getContadorAutovalenteSinRiesgo() + 1);
                            }
                            if (edad >= 65 && edad <= 69) {
                                A1totalhombres_65a69.setContadorAutovalenteSinRiesgo(A1totalhombres_65a69.getContadorAutovalenteSinRiesgo() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                A1totalhombres_70a74.setContadorAutovalenteSinRiesgo(A1totalhombres_70a74.getContadorAutovalenteSinRiesgo() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                A1totalhombres_75a79.setContadorAutovalenteSinRiesgo(A1totalhombres_75a79.getContadorAutovalenteSinRiesgo() + 1);
                            } else if (edad >= 80) {
                                A1totalhombres_80omas.setContadorAutovalenteSinRiesgo(A1totalhombres_80omas.getContadorAutovalenteSinRiesgo() + 1);
                            }
                        } else {//consultas mujeres 
                            A1totalmujeres.setContadorAutovalenteSinRiesgo(A1totalmujeres.getContadorAutovalenteSinRiesgo() + 1);
                            if (pacientes.isEtnia()) {
                                A1totalmujeres_pueblos.setContadorAutovalenteSinRiesgo(A1totalmujeres_pueblos.getContadorAutovalenteSinRiesgo() + 1);
                            }
                            if (edad >= 65 && edad <= 69) {
                                A1totalmujeres_65a69.setContadorAutovalenteSinRiesgo(A1totalmujeres_65a69.getContadorAutovalenteSinRiesgo() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                A1totalmujeres_70a74.setContadorAutovalenteSinRiesgo(A1totalmujeres_70a74.getContadorAutovalenteSinRiesgo() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                A1totalmujeres_75a79.setContadorAutovalenteSinRiesgo(A1totalmujeres_75a79.getContadorAutovalenteSinRiesgo() + 1);
                            } else if (edad >= 80) {
                                A1totalmujeres_80omas.setContadorAutovalenteSinRiesgo(A1totalmujeres_80omas.getContadorAutovalenteSinRiesgo() + 1);
                            }
                        }

                    }

                }
                if (ccv_filtro.get(ccv_filtro.size() - 1).getClasificacion_efam().equals("Autovalente con riesgo")) {//consultas Autovalente con riesgo
                    fue_censado = true;
                    totalAmbosSexos.setContadorAutovalenteConRiesgo(totalAmbosSexos.getContadorAutovalenteConRiesgo() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setContadorAutovalenteConRiesgo(totalhombres.getContadorAutovalenteConRiesgo() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setContadorAutovalenteConRiesgo(totalhombres_pueblos.getContadorAutovalenteConRiesgo() + 1);
                        }
                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setContadorAutovalenteConRiesgo(totalhombres_65a69.getContadorAutovalenteConRiesgo() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setContadorAutovalenteConRiesgo(totalhombres_70a74.getContadorAutovalenteConRiesgo() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setContadorAutovalenteConRiesgo(totalhombres_75a79.getContadorAutovalenteConRiesgo() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setContadorAutovalenteConRiesgo(totalhombres_80omas.getContadorAutovalenteConRiesgo() + 1);
                        }
                    } else {//consultas mujeres
                        totalmujeres.setContadorAutovalenteConRiesgo(totalmujeres.getContadorAutovalenteConRiesgo() + 1);
                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setContadorAutovalenteConRiesgo(totalmujeres_pueblos.getContadorAutovalenteConRiesgo() + 1);
                        }
                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setContadorAutovalenteConRiesgo(totalmujeres_65a69.getContadorAutovalenteConRiesgo() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setContadorAutovalenteConRiesgo(totalmujeres_70a74.getContadorAutovalenteConRiesgo() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setContadorAutovalenteConRiesgo(totalmujeres_75a79.getContadorAutovalenteConRiesgo() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setContadorAutovalenteConRiesgo(totalmujeres_80omas.getContadorAutovalenteConRiesgo() + 1);
                        }
                    }

                    if (programamas) {
                        A1totalAmbosSexos.setContadorAutovalenteConRiesgo(A1totalAmbosSexos.getContadorAutovalenteConRiesgo() + 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            A1totalhombres.setContadorAutovalenteConRiesgo(A1totalhombres.getContadorAutovalenteConRiesgo() + 1);
                            if (pacientes.isEtnia()) {
                                A1totalhombres_pueblos.setContadorAutovalenteConRiesgo(A1totalhombres_pueblos.getContadorAutovalenteConRiesgo() + 1);
                            }
                            if (edad >= 65 && edad <= 69) {
                                A1totalhombres_65a69.setContadorAutovalenteConRiesgo(A1totalhombres_65a69.getContadorAutovalenteConRiesgo() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                A1totalhombres_70a74.setContadorAutovalenteConRiesgo(A1totalhombres_70a74.getContadorAutovalenteConRiesgo() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                A1totalhombres_75a79.setContadorAutovalenteConRiesgo(A1totalhombres_75a79.getContadorAutovalenteConRiesgo() + 1);
                            } else if (edad >= 80) {
                                A1totalhombres_80omas.setContadorAutovalenteConRiesgo(A1totalhombres_80omas.getContadorAutovalenteConRiesgo() + 1);
                            }
                        } else {//consultas mujeres
                            A1totalmujeres.setContadorAutovalenteConRiesgo(A1totalmujeres.getContadorAutovalenteConRiesgo() + 1);
                            if (pacientes.isEtnia()) {
                                A1totalmujeres_pueblos.setContadorAutovalenteConRiesgo(A1totalmujeres_pueblos.getContadorAutovalenteConRiesgo() + 1);
                            }
                            if (edad >= 65 && edad <= 69) {
                                A1totalmujeres_65a69.setContadorAutovalenteConRiesgo(A1totalmujeres_65a69.getContadorAutovalenteConRiesgo() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                A1totalmujeres_70a74.setContadorAutovalenteConRiesgo(A1totalmujeres_70a74.getContadorAutovalenteConRiesgo() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                A1totalmujeres_75a79.setContadorAutovalenteConRiesgo(A1totalmujeres_75a79.getContadorAutovalenteConRiesgo() + 1);
                            } else if (edad >= 80) {
                                A1totalmujeres_80omas.setContadorAutovalenteConRiesgo(A1totalmujeres_80omas.getContadorAutovalenteConRiesgo() + 1);
                            }
                        }

                    }
                }

                if (ccv_filtro.get(ccv_filtro.size() - 1).getClasificacion_efam().equals("En riesgo de dependencia")) {//consultas En riesgo de dependencia
                    fue_censado = true;
                    totalAmbosSexos.setContadorRiesgoDependencia(totalAmbosSexos.getContadorRiesgoDependencia() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setContadorRiesgoDependencia(totalhombres.getContadorRiesgoDependencia() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setContadorRiesgoDependencia(totalhombres_pueblos.getContadorRiesgoDependencia() + 1);
                        }
                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setContadorRiesgoDependencia(totalhombres_65a69.getContadorRiesgoDependencia() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setContadorRiesgoDependencia(totalhombres_70a74.getContadorRiesgoDependencia() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setContadorRiesgoDependencia(totalhombres_75a79.getContadorRiesgoDependencia() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setContadorRiesgoDependencia(totalhombres_80omas.getContadorRiesgoDependencia() + 1);
                        }
                    } else {//consultas mujeres
                        totalmujeres.setContadorRiesgoDependencia(totalmujeres.getContadorRiesgoDependencia() + 1);
                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setContadorRiesgoDependencia(totalmujeres_pueblos.getContadorRiesgoDependencia() + 1);
                        }
                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setContadorRiesgoDependencia(totalmujeres_65a69.getContadorRiesgoDependencia() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setContadorRiesgoDependencia(totalmujeres_70a74.getContadorRiesgoDependencia() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setContadorRiesgoDependencia(totalmujeres_75a79.getContadorRiesgoDependencia() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setContadorRiesgoDependencia(totalmujeres_80omas.getContadorRiesgoDependencia() + 1);
                        }
                    }

                    if (programamas) {
                        A1totalAmbosSexos.setContadorRiesgoDependencia(A1totalAmbosSexos.getContadorRiesgoDependencia() + 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            A1totalhombres.setContadorRiesgoDependencia(A1totalhombres.getContadorRiesgoDependencia() + 1);
                            if (pacientes.isEtnia()) {
                                A1totalhombres_pueblos.setContadorRiesgoDependencia(A1totalhombres_pueblos.getContadorRiesgoDependencia() + 1);
                            }
                            if (edad >= 65 && edad <= 69) {
                                A1totalhombres_65a69.setContadorRiesgoDependencia(A1totalhombres_65a69.getContadorRiesgoDependencia() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                A1totalhombres_70a74.setContadorRiesgoDependencia(A1totalhombres_70a74.getContadorRiesgoDependencia() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                A1totalhombres_75a79.setContadorRiesgoDependencia(A1totalhombres_75a79.getContadorRiesgoDependencia() + 1);
                            } else if (edad >= 80) {
                                A1totalhombres_80omas.setContadorRiesgoDependencia(A1totalhombres_80omas.getContadorRiesgoDependencia() + 1);
                            }
                        } else {//consultas mujeres
                            A1totalmujeres.setContadorRiesgoDependencia(A1totalmujeres.getContadorRiesgoDependencia() + 1);
                            if (pacientes.isEtnia()) {
                                A1totalmujeres_pueblos.setContadorRiesgoDependencia(A1totalmujeres_pueblos.getContadorRiesgoDependencia() + 1);
                            }
                            if (edad >= 65 && edad <= 69) {
                                A1totalmujeres_65a69.setContadorRiesgoDependencia(A1totalmujeres_65a69.getContadorRiesgoDependencia() + 1);
                            } else if (edad >= 70 && edad <= 74) {
                                A1totalmujeres_70a74.setContadorRiesgoDependencia(A1totalmujeres_70a74.getContadorRiesgoDependencia() + 1);
                            } else if (edad >= 75 && edad <= 79) {
                                A1totalmujeres_75a79.setContadorRiesgoDependencia(A1totalmujeres_75a79.getContadorRiesgoDependencia() + 1);
                            } else if (edad >= 80) {
                                A1totalmujeres_80omas.setContadorRiesgoDependencia(A1totalmujeres_80omas.getContadorRiesgoDependencia() + 1);
                            }
                        }

                    }

                }

                //ACA VA EL ELSE PARA BARTHEL
                if (ccv_filtro.get(ccv_filtro.size() - 1).getClasificacion_barthel().equals("Leve")) {//consultas barthel leve
                    fue_censado = true;
                    totalAmbosSexos.setDependentienteLeve(totalAmbosSexos.getDependentienteLeve() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setDependentienteLeve(totalhombres.getDependentienteLeve() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setDependentienteLeve(totalhombres_pueblos.getDependentienteLeve() + 1);
                        }
                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setDependentienteLeve(totalhombres_65a69.getDependentienteLeve() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setDependentienteLeve(totalhombres_70a74.getDependentienteLeve() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setDependentienteLeve(totalhombres_75a79.getDependentienteLeve() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setDependentienteLeve(totalhombres_80omas.getDependentienteLeve() + 1);
                        }
                    } else {//mujeres
                        totalmujeres.setDependentienteLeve(totalmujeres.getDependentienteLeve() + 1);
                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setDependentienteLeve(totalmujeres_pueblos.getDependentienteLeve() + 1);
                        }
                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setDependentienteLeve(totalmujeres_65a69.getDependentienteLeve() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setDependentienteLeve(totalmujeres_70a74.getDependentienteLeve() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setDependentienteLeve(totalmujeres_75a79.getDependentienteLeve() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setDependentienteLeve(totalmujeres_80omas.getDependentienteLeve() + 1);
                        }
                    }
                }

                if (ccv_filtro.get(ccv_filtro.size() - 1).getClasificacion_barthel().equals("Moderado")) {//consultas barthel moderado
                    fue_censado = true;
                    totalAmbosSexos.setDependientemoderado(totalAmbosSexos.getDependientemoderado() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setDependientemoderado(totalhombres.getDependientemoderado() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setDependientemoderado(totalhombres_pueblos.getDependientemoderado() + 1);
                        }

                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setDependientemoderado(totalhombres_65a69.getDependientemoderado() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setDependientemoderado(totalhombres_70a74.getDependientemoderado() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setDependientemoderado(totalhombres_75a79.getDependientemoderado() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setDependientemoderado(totalhombres_80omas.getDependientemoderado() + 1);
                        }

                    } else {
                        totalmujeres.setDependientemoderado(totalmujeres.getDependientemoderado() + 1);
                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setDependientemoderado(totalmujeres_pueblos.getDependientemoderado() + 1);
                        }

                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setDependientemoderado(totalmujeres_65a69.getDependientemoderado() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setDependientemoderado(totalmujeres_70a74.getDependientemoderado() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setDependientemoderado(totalmujeres_75a79.getDependientemoderado() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setDependientemoderado(totalmujeres_80omas.getDependientemoderado() + 1);
                        }

                    }
                }

                if (ccv_filtro.get(ccv_filtro.size() - 1).getClasificacion_barthel().equals("Grave")) {//consultas barthel Grave
                    fue_censado = true;
                    totalAmbosSexos.setDependientegrave(totalAmbosSexos.getDependientegrave() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setDependientegrave(totalhombres.getDependientegrave() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setDependientegrave(totalhombres_pueblos.getDependientegrave() + 1);
                        }

                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setDependientegrave(totalhombres_65a69.getDependientegrave() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setDependientegrave(totalhombres_70a74.getDependientegrave() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setDependientegrave(totalhombres_75a79.getDependientegrave() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setDependientegrave(totalhombres_80omas.getDependientegrave() + 1);
                        }

                    } else {//mujeres  barthel
                        totalmujeres.setDependientegrave(totalmujeres.getDependientegrave() + 1);
                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setDependientegrave(totalmujeres_pueblos.getDependientegrave() + 1);
                        }

                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setDependientegrave(totalmujeres_65a69.getDependientegrave() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setDependientegrave(totalmujeres_70a74.getDependientegrave() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setDependientegrave(totalmujeres_75a79.getDependientegrave() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setDependientegrave(totalmujeres_80omas.getDependientegrave() + 1);
                        }

                    }
                }

                if (ccv_filtro.get(ccv_filtro.size() - 1).getClasificacion_barthel().equals("Total")) {//consultas barthel total
                    fue_censado = true;
                    totalAmbosSexos.setDependienteTotal(totalAmbosSexos.getDependienteTotal() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setDependienteTotal(totalhombres.getDependienteTotal() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setDependienteTotal(totalhombres_pueblos.getDependienteTotal() + 1);
                        }

                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setDependienteTotal(totalhombres_65a69.getDependienteTotal() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setDependienteTotal(totalhombres_70a74.getDependienteTotal() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setDependienteTotal(totalhombres_75a79.getDependienteTotal() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setDependienteTotal(totalhombres_80omas.getDependienteTotal() + 1);
                        }

                    } else {//consultas barthel mujeres
                        totalmujeres.setDependienteTotal(totalmujeres.getDependienteTotal() + 1);
                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setDependienteTotal(totalmujeres_pueblos.getDependienteTotal() + 1);
                        }

                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setDependienteTotal(totalmujeres_65a69.getDependienteTotal() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setDependienteTotal(totalmujeres_70a74.getDependienteTotal() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setDependienteTotal(totalmujeres_75a79.getDependienteTotal() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setDependienteTotal(totalmujeres_80omas.getDependienteTotal() + 1);
                        }

                    }
                }

                if (fue_censado) {
                    pacientesCensados++;
                }

            } else {

                CensoPSAMExcluidos nocensado = new CensoPSAMExcluidos();
                nocensado.setNombre(pacientes.getNombres_paciente());
                nocensado.setApellidop(pacientes.getApellidoPaterno_paciente());
                nocensado.setApellidom(pacientes.getApellidoMaterno_paciente());
                nocensado.setRut(pacientes.getRut_paciente());
                if (registra_unaatencion) {
                    nocensado.setRazon_exclusion("Pasivo en el programa");
                } else {
                    nocensado.setRazon_exclusion("No posee atenciones en el PSAM");
                }
                PacienteController p = new PacienteController();
                nocensado.setEdad(p.Age(pacientes.getFechaNacimiento_paciente()));
                Pacientes_excluidos.add(nocensado);
            }

        }

        totalAmbosSexos.setColumnName1("Total");
        totalAmbosSexos.setColumnName2("Ambos Sexos");
        totalAmbosSexos.setSubTotalEfam(totalAmbosSexos.getContadorAutovalenteConRiesgo() + totalAmbosSexos.getContadorAutovalenteSinRiesgo() + totalAmbosSexos.getContadorRiesgoDependencia());
        totalAmbosSexos.setSubTotalBarthel(totalAmbosSexos.getDependentienteLeve() + totalAmbosSexos.getDependienteTotal() + totalAmbosSexos.getDependientegrave() + totalAmbosSexos.getDependientemoderado());
        totalAmbosSexos.setTotalAdutosMayoresControl(totalAmbosSexos.getSubTotalBarthel() + totalAmbosSexos.getSubTotalEfam());

        totalhombres.setColumnName1("Total");
        totalhombres.setColumnName2("Hombres");
        totalhombres.setSubTotalEfam(totalhombres.getContadorAutovalenteConRiesgo() + totalhombres.getContadorAutovalenteSinRiesgo() + totalhombres.getContadorRiesgoDependencia());
        totalhombres.setSubTotalBarthel(totalhombres.getDependentienteLeve() + totalhombres.getDependienteTotal() + totalhombres.getDependientegrave() + totalhombres.getDependientemoderado());
        totalhombres.setTotalAdutosMayoresControl(totalhombres.getSubTotalBarthel() + totalhombres.getSubTotalEfam());
        totalmujeres.setColumnName1("Total");
        totalmujeres.setColumnName2("Mujeres");
        totalmujeres.setSubTotalEfam(totalmujeres.getContadorAutovalenteConRiesgo() + totalmujeres.getContadorAutovalenteSinRiesgo() + totalmujeres.getContadorRiesgoDependencia());
        totalmujeres.setSubTotalBarthel(totalmujeres.getDependentienteLeve() + totalmujeres.getDependienteTotal() + totalmujeres.getDependientegrave() + totalmujeres.getDependientemoderado());
        totalmujeres.setTotalAdutosMayoresControl(totalmujeres.getSubTotalBarthel() + totalmujeres.getSubTotalEfam());

        //total 65 a 69
        totalhombres_65a69.setColumnName1("65 a 69");
        totalhombres_65a69.setColumnName2("Hombres");
        totalhombres_65a69.setSubTotalEfam(totalhombres_65a69.getContadorAutovalenteConRiesgo() + totalhombres_65a69.getContadorAutovalenteSinRiesgo() + totalhombres_65a69.getContadorRiesgoDependencia());
        totalhombres_65a69.setSubTotalBarthel(totalhombres_65a69.getDependentienteLeve() + totalhombres_65a69.getDependienteTotal() + totalhombres_65a69.getDependientegrave() + totalhombres_65a69.getDependientemoderado());
        totalhombres_65a69.setTotalAdutosMayoresControl(totalhombres_65a69.getSubTotalBarthel() + totalhombres_65a69.getSubTotalEfam());
        totalmujeres_65a69.setColumnName1("65 a 69 ");
        totalmujeres_65a69.setColumnName2("Mujeres");
        totalmujeres_65a69.setSubTotalEfam(totalmujeres_65a69.getContadorAutovalenteConRiesgo() + totalmujeres_65a69.getContadorAutovalenteSinRiesgo() + totalmujeres_65a69.getContadorRiesgoDependencia());
        totalmujeres_65a69.setSubTotalBarthel(totalmujeres_65a69.getDependentienteLeve() + totalmujeres_65a69.getDependienteTotal() + totalmujeres_65a69.getDependientegrave() + totalmujeres_65a69.getDependientemoderado());
        totalmujeres_65a69.setTotalAdutosMayoresControl(totalmujeres_65a69.getSubTotalBarthel() + totalmujeres_65a69.getSubTotalEfam());

        //total 70 a 74
        totalhombres_70a74.setColumnName1("70 a 74");
        totalhombres_70a74.setColumnName2("Hombres");
        totalhombres_70a74.setSubTotalEfam(totalhombres_70a74.getContadorAutovalenteConRiesgo() + totalhombres_70a74.getContadorAutovalenteSinRiesgo() + totalhombres_70a74.getContadorRiesgoDependencia());
        totalhombres_70a74.setSubTotalBarthel(totalhombres_70a74.getDependentienteLeve() + totalhombres_70a74.getDependienteTotal() + totalhombres_70a74.getDependientegrave() + totalhombres_70a74.getDependientemoderado());
        totalhombres_70a74.setTotalAdutosMayoresControl(totalhombres_70a74.getSubTotalBarthel() + totalhombres_70a74.getSubTotalEfam());
        totalmujeres_70a74.setColumnName1("70 a 74");
        totalmujeres_70a74.setColumnName2("Mujeres");
        totalmujeres_70a74.setSubTotalEfam(totalmujeres_70a74.getContadorAutovalenteConRiesgo() + totalmujeres_70a74.getContadorAutovalenteSinRiesgo() + totalmujeres_70a74.getContadorRiesgoDependencia());
        totalmujeres_70a74.setSubTotalBarthel(totalmujeres_70a74.getDependentienteLeve() + totalmujeres_70a74.getDependienteTotal() + totalmujeres_70a74.getDependientegrave() + totalmujeres_70a74.getDependientemoderado());
        totalmujeres_70a74.setTotalAdutosMayoresControl(totalmujeres_70a74.getSubTotalBarthel() + totalmujeres_70a74.getSubTotalEfam());

        //75 a 79
        totalhombres_75a79.setColumnName1("75 a 79");
        totalhombres_75a79.setColumnName2("Hombres");
        totalhombres_75a79.setSubTotalEfam(totalhombres_75a79.getContadorAutovalenteConRiesgo() + totalhombres_75a79.getContadorAutovalenteSinRiesgo() + totalhombres_75a79.getContadorRiesgoDependencia());
        totalhombres_75a79.setSubTotalBarthel(totalhombres_75a79.getDependentienteLeve() + totalhombres_75a79.getDependienteTotal() + totalhombres_75a79.getDependientegrave() + totalhombres_75a79.getDependientemoderado());
        totalhombres_75a79.setTotalAdutosMayoresControl(totalhombres_75a79.getSubTotalBarthel() + totalhombres_75a79.getSubTotalEfam());
        totalmujeres_75a79.setColumnName1("75 a 79");
        totalmujeres_75a79.setColumnName2("Mujeres");
        totalmujeres_75a79.setSubTotalEfam(totalmujeres_75a79.getContadorAutovalenteConRiesgo() + totalmujeres_75a79.getContadorAutovalenteSinRiesgo() + totalmujeres_75a79.getContadorRiesgoDependencia());
        totalmujeres_75a79.setSubTotalBarthel(totalmujeres_75a79.getDependentienteLeve() + totalmujeres_75a79.getDependienteTotal() + totalmujeres_75a79.getDependientegrave() + totalmujeres_75a79.getDependientemoderado());
        totalmujeres_75a79.setTotalAdutosMayoresControl(totalmujeres_75a79.getSubTotalBarthel() + totalmujeres_75a79.getSubTotalEfam());

        //80 o mas
        totalhombres_80omas.setColumnName1("80 y más");
        totalhombres_80omas.setColumnName2("Hombres");
        totalhombres_80omas.setSubTotalEfam(totalhombres_80omas.getContadorAutovalenteConRiesgo() + totalhombres_80omas.getContadorAutovalenteSinRiesgo() + totalhombres_80omas.getContadorRiesgoDependencia());
        totalhombres_80omas.setSubTotalBarthel(totalhombres_80omas.getDependentienteLeve() + totalhombres_80omas.getDependienteTotal() + totalhombres_80omas.getDependientegrave() + totalhombres_80omas.getDependientemoderado());
        totalhombres_80omas.setTotalAdutosMayoresControl(totalhombres_80omas.getSubTotalBarthel() + totalhombres_80omas.getSubTotalEfam());
        totalmujeres_80omas.setColumnName1("80 y más");
        totalmujeres_80omas.setColumnName2("Mujeres");
        totalmujeres_80omas.setSubTotalEfam(totalmujeres_80omas.getContadorAutovalenteConRiesgo() + totalmujeres_80omas.getContadorAutovalenteSinRiesgo() + totalmujeres_80omas.getContadorRiesgoDependencia());
        totalmujeres_80omas.setSubTotalBarthel(totalmujeres_80omas.getDependentienteLeve() + totalmujeres_80omas.getDependienteTotal() + totalmujeres_80omas.getDependientegrave() + totalmujeres_80omas.getDependientemoderado());
        totalmujeres_80omas.setTotalAdutosMayoresControl(totalmujeres_80omas.getSubTotalBarthel() + totalmujeres_80omas.getSubTotalEfam());
        //total pueblos
        totalhombres_pueblos.setColumnName1("Pueblos");
        totalhombres_pueblos.setColumnName2("Hombres");
        totalhombres_pueblos.setSubTotalEfam(totalhombres_pueblos.getContadorAutovalenteConRiesgo() + totalhombres_pueblos.getContadorAutovalenteSinRiesgo() + totalhombres_pueblos.getContadorRiesgoDependencia());
        totalhombres_pueblos.setSubTotalBarthel(totalhombres_pueblos.getDependentienteLeve() + totalhombres_pueblos.getDependienteTotal() + totalhombres_pueblos.getDependientegrave() + totalhombres_pueblos.getDependientemoderado());
        totalhombres_pueblos.setTotalAdutosMayoresControl(totalhombres_pueblos.getSubTotalBarthel() + totalhombres_pueblos.getSubTotalEfam());
        totalmujeres_pueblos.setColumnName1("originarios");
        totalmujeres_pueblos.setColumnName2("Mujeres");
        totalmujeres_pueblos.setSubTotalEfam(totalmujeres_pueblos.getContadorAutovalenteConRiesgo() + totalmujeres_pueblos.getContadorAutovalenteSinRiesgo() + totalmujeres_pueblos.getContadorRiesgoDependencia());
        totalmujeres_pueblos.setSubTotalBarthel(totalmujeres_pueblos.getDependentienteLeve() + totalmujeres_pueblos.getDependienteTotal() + totalmujeres_pueblos.getDependientegrave() + totalmujeres_pueblos.getDependientemoderado());
        totalmujeres_pueblos.setTotalAdutosMayoresControl(totalmujeres_pueblos.getSubTotalBarthel() + totalmujeres_pueblos.getSubTotalEfam());

        //Seccion A1
        A1totalAmbosSexos.setColumnName1("Total");
        A1totalAmbosSexos.setColumnName2("Ambos Sexos");
        A1totalAmbosSexos.setSubTotalEfam(A1totalAmbosSexos.getContadorAutovalenteConRiesgo() + A1totalAmbosSexos.getContadorAutovalenteSinRiesgo() + A1totalAmbosSexos.getContadorRiesgoDependencia());

        A1totalhombres.setColumnName1("Total");
        A1totalhombres.setColumnName2("Hombres");
        A1totalhombres.setSubTotalEfam(A1totalhombres.getContadorAutovalenteConRiesgo() + A1totalhombres.getContadorAutovalenteSinRiesgo() + A1totalhombres.getContadorRiesgoDependencia());

        A1totalmujeres.setColumnName1("Total");
        A1totalmujeres.setColumnName2("Mujeres");
        A1totalmujeres.setSubTotalEfam(A1totalmujeres.getContadorAutovalenteConRiesgo() + A1totalmujeres.getContadorAutovalenteSinRiesgo() + A1totalmujeres.getContadorRiesgoDependencia());

        //total 65 a 69
        A1totalhombres_65a69.setColumnName1("65 a 69");
        A1totalhombres_65a69.setColumnName2("Hombres");
        A1totalhombres_65a69.setSubTotalEfam(A1totalhombres_65a69.getContadorAutovalenteConRiesgo() + A1totalhombres_65a69.getContadorAutovalenteSinRiesgo() + A1totalhombres_65a69.getContadorRiesgoDependencia());

        A1totalmujeres_65a69.setColumnName1("65 a 69 ");
        A1totalmujeres_65a69.setColumnName2("Mujeres");
        A1totalmujeres_65a69.setSubTotalEfam(A1totalmujeres_65a69.getContadorAutovalenteConRiesgo() + A1totalmujeres_65a69.getContadorAutovalenteSinRiesgo() + A1totalmujeres_65a69.getContadorRiesgoDependencia());

        //total 70 a 74
        A1totalhombres_70a74.setColumnName1("70 a 74");
        A1totalhombres_70a74.setColumnName2("Hombres");
        A1totalhombres_70a74.setSubTotalEfam(A1totalhombres_70a74.getContadorAutovalenteConRiesgo() + A1totalhombres_70a74.getContadorAutovalenteSinRiesgo() + A1totalhombres_70a74.getContadorRiesgoDependencia());

        A1totalmujeres_70a74.setColumnName1("70 a 74");
        A1totalmujeres_70a74.setColumnName2("Mujeres");
        A1totalmujeres_70a74.setSubTotalEfam(A1totalmujeres_70a74.getContadorAutovalenteConRiesgo() + A1totalmujeres_70a74.getContadorAutovalenteSinRiesgo() + A1totalmujeres_70a74.getContadorRiesgoDependencia());

        //75 a 79
        A1totalhombres_75a79.setColumnName1("75 a 79");
        A1totalhombres_75a79.setColumnName2("Hombres");
        A1totalhombres_75a79.setSubTotalEfam(A1totalhombres_75a79.getContadorAutovalenteConRiesgo() + A1totalhombres_75a79.getContadorAutovalenteSinRiesgo() + A1totalhombres_75a79.getContadorRiesgoDependencia());

        A1totalmujeres_75a79.setColumnName1("75 a 79");
        A1totalmujeres_75a79.setColumnName2("Mujeres");
        A1totalmujeres_75a79.setSubTotalEfam(A1totalmujeres_75a79.getContadorAutovalenteConRiesgo() + A1totalmujeres_75a79.getContadorAutovalenteSinRiesgo() + A1totalmujeres_75a79.getContadorRiesgoDependencia());

        //80 o mas
        A1totalhombres_80omas.setColumnName1("80 y más");
        A1totalhombres_80omas.setColumnName2("Hombres");
        A1totalhombres_80omas.setSubTotalEfam(A1totalhombres_80omas.getContadorAutovalenteConRiesgo() + A1totalhombres_80omas.getContadorAutovalenteSinRiesgo() + A1totalhombres_80omas.getContadorRiesgoDependencia());

        A1totalmujeres_80omas.setColumnName1("80 y más");
        A1totalmujeres_80omas.setColumnName2("Mujeres");
        A1totalmujeres_80omas.setSubTotalEfam(A1totalmujeres_80omas.getContadorAutovalenteConRiesgo() + A1totalmujeres_80omas.getContadorAutovalenteSinRiesgo() + A1totalmujeres_80omas.getContadorRiesgoDependencia());

        //total pueblos
        A1totalhombres_pueblos.setColumnName1("Pueblos");
        A1totalhombres_pueblos.setColumnName2("Hombres");
        A1totalhombres_pueblos.setSubTotalEfam(A1totalhombres_pueblos.getContadorAutovalenteConRiesgo() + A1totalhombres_pueblos.getContadorAutovalenteSinRiesgo() + A1totalhombres_pueblos.getContadorRiesgoDependencia());

        A1totalmujeres_pueblos.setColumnName1("originarios");
        A1totalmujeres_pueblos.setColumnName2("Mujeres");
        A1totalmujeres_pueblos.setSubTotalEfam(A1totalmujeres_pueblos.getContadorAutovalenteConRiesgo() + A1totalmujeres_pueblos.getContadorAutovalenteSinRiesgo() + A1totalmujeres_pueblos.getContadorRiesgoDependencia());

        elementos.clear();
        A1elementos.clear();

        elementos.add(totalAmbosSexos);
        elementos.add(totalhombres);
        elementos.add(totalmujeres);
        elementos.add(totalhombres_65a69);
        elementos.add(totalmujeres_65a69);
        elementos.add(totalhombres_70a74);
        elementos.add(totalmujeres_70a74);
        elementos.add(totalhombres_75a79);
        elementos.add(totalmujeres_75a79);
        elementos.add(totalhombres_80omas);
        elementos.add(totalmujeres_80omas);
        elementos.add(totalhombres_pueblos);
        elementos.add(totalmujeres_pueblos);
        A1elementos.add(A1totalAmbosSexos);
        A1elementos.add(A1totalhombres);
        A1elementos.add(A1totalmujeres);
        A1elementos.add(A1totalhombres_65a69);
        A1elementos.add(A1totalmujeres_65a69);
        A1elementos.add(A1totalhombres_70a74);
        A1elementos.add(A1totalmujeres_70a74);
        A1elementos.add(A1totalhombres_75a79);
        A1elementos.add(A1totalmujeres_75a79);
        A1elementos.add(A1totalhombres_80omas);
        A1elementos.add(A1totalmujeres_80omas);
        A1elementos.add(A1totalhombres_pueblos);
        A1elementos.add(A1totalmujeres_pueblos);
        return elementos;

    }

    /**
     * *
     * Censo para la seccion B
     *
     * @return
     */
    public List<CensoSeccionB> censoPSAMSeccionB() {
        CensoSeccionB totalAmbosSexos = new CensoSeccionB();
        CensoSeccionB totalhombres = new CensoSeccionB();
        CensoSeccionB totalmujeres = new CensoSeccionB();
        CensoSeccionB totalhombres_65a69 = new CensoSeccionB();
        CensoSeccionB totalmujeres_65a69 = new CensoSeccionB();
        CensoSeccionB totalhombres_70a74 = new CensoSeccionB();
        CensoSeccionB totalmujeres_70a74 = new CensoSeccionB();
        CensoSeccionB totalhombres_75a79 = new CensoSeccionB();
        CensoSeccionB totalmujeres_75a79 = new CensoSeccionB();
        CensoSeccionB totalhombres_80omas = new CensoSeccionB();
        CensoSeccionB totalmujeres_80omas = new CensoSeccionB();
        CensoSeccionB totalhombres_pueblos = new CensoSeccionB();
        CensoSeccionB totalmujeres_pueblos = new CensoSeccionB();

        List<Paciente> pacientes_habilitados = ejbPaciente.findbyPacienteActivo();
        List<CartolaSeguimientoPSAM> ccv;
        List<CartolaSeguimientoPSAM> ccv_filtro;
        List<CartolaSeguimientoPSAM> ccv_ordenado;
        for (Paciente pacientes : pacientes_habilitados) {
            boolean fue_censado = false;
            int edad;
            boolean registra_unaatencion = false;
            ccv = ejbCartolaFacade.findByPaciente(pacientes);//obtengo todas las cartolas por  pacientes
            if (ccv.size() > 0) {
                registra_unaatencion = true;
            }
            ccv_ordenado = filtro(ccv);
            ccv_filtro = filtro_censables(ccv_ordenado);//se ordenan las cartolas, y se filtran solo als que entran al censo
            if (ccv_filtro.size() > 0) {
                edad = ccv_filtro.get(ccv_filtro.size() - 1).getEdad();

                if (ccv_filtro.get(ccv_filtro.size() - 1).getEstado_nutricional().equals("BP")
                        || ccv_filtro.get(ccv_filtro.size() - 1).getEstado_nutricional().equals("E")) {//consultas bajo peso
                    totalAmbosSexos.setContadorBajoPeso(totalAmbosSexos.getContadorBajoPeso() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setContadorBajoPeso(totalhombres.getContadorBajoPeso() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setContadorBajoPeso(totalhombres_pueblos.getContadorBajoPeso() + 1);
                        }

                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setContadorBajoPeso(totalhombres_65a69.getContadorBajoPeso() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setContadorBajoPeso(totalhombres_70a74.getContadorBajoPeso() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setContadorBajoPeso(totalhombres_75a79.getContadorBajoPeso() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setContadorBajoPeso(totalhombres_80omas.getContadorBajoPeso() + 1);
                        }

                    } else {//Genero Femenino

                        totalmujeres.setContadorBajoPeso(totalmujeres.getContadorBajoPeso() + 1);
                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setContadorBajoPeso(totalmujeres_pueblos.getContadorBajoPeso() + 1);
                        }

                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setContadorBajoPeso(totalmujeres_65a69.getContadorBajoPeso() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setContadorBajoPeso(totalmujeres_70a74.getContadorBajoPeso() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setContadorBajoPeso(totalmujeres_75a79.getContadorBajoPeso() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setContadorBajoPeso(totalmujeres_80omas.getContadorBajoPeso() + 1);
                        }

                    }

                }

                if (ccv_filtro.get(ccv_filtro.size() - 1).getEstado_nutricional().equals("N")) {//Consultas peso normal
                    totalAmbosSexos.setContadorNormal(totalAmbosSexos.getContadorNormal() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setContadorNormal(totalhombres.getContadorNormal() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setContadorNormal(totalhombres_pueblos.getContadorNormal() + 1);
                        }

                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setContadorNormal(totalhombres_65a69.getContadorNormal() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setContadorNormal(totalhombres_70a74.getContadorNormal() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setContadorNormal(totalhombres_75a79.getContadorNormal() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setContadorNormal(totalhombres_80omas.getContadorNormal() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setContadorNormal(totalmujeres.getContadorNormal() + 1);
                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setContadorNormal(totalmujeres_pueblos.getContadorNormal() + 1);
                        }

                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setContadorNormal(totalmujeres_65a69.getContadorNormal() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setContadorNormal(totalmujeres_70a74.getContadorNormal() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setContadorNormal(totalmujeres_75a79.getContadorNormal() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setContadorNormal(totalmujeres_80omas.getContadorNormal() + 1);
                        }

                    }

                }

                if (ccv_filtro.get(ccv_filtro.size() - 1).getEstado_nutricional().equals("SP")) {//consultas sobrepeso
                    totalAmbosSexos.setContadorSobrepeso(totalAmbosSexos.getContadorSobrepeso() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setContadorSobrepeso(totalhombres.getContadorSobrepeso() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setContadorSobrepeso(totalhombres_pueblos.getContadorSobrepeso() + 1);
                        }

                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setContadorSobrepeso(totalhombres_65a69.getContadorSobrepeso() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setContadorSobrepeso(totalhombres_70a74.getContadorSobrepeso() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setContadorSobrepeso(totalhombres_75a79.getContadorSobrepeso() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setContadorSobrepeso(totalhombres_80omas.getContadorSobrepeso() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setContadorSobrepeso(totalmujeres.getContadorSobrepeso() + 1);
                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setContadorSobrepeso(totalmujeres_pueblos.getContadorSobrepeso() + 1);
                        }

                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setContadorSobrepeso(totalmujeres_65a69.getContadorSobrepeso() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setContadorSobrepeso(totalmujeres_70a74.getContadorSobrepeso() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setContadorSobrepeso(totalmujeres_75a79.getContadorSobrepeso() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setContadorSobrepeso(totalmujeres_80omas.getContadorSobrepeso() + 1);
                        }
                    }

                }

                if (ccv_filtro.get(ccv_filtro.size() - 1).getEstado_nutricional().equals("OB")
                        || ccv_filtro.get(ccv_filtro.size() - 1).getEstado_nutricional().equals("OBI")
                        || ccv_filtro.get(ccv_filtro.size() - 1).getEstado_nutricional().equals("OBII")
                        || ccv_filtro.get(ccv_filtro.size() - 1).getEstado_nutricional().equals("OBIII")) {//consultas obeso
                    totalAmbosSexos.setContadorObeso(totalAmbosSexos.getContadorObeso() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setContadorObeso(totalhombres.getContadorObeso() + 1);
                        if (pacientes.isEtnia()) {
                            totalhombres_pueblos.setContadorObeso(totalhombres_pueblos.getContadorObeso() + 1);
                        }

                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setContadorObeso(totalhombres_65a69.getContadorObeso() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setContadorObeso(totalhombres_70a74.getContadorObeso() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setContadorObeso(totalhombres_75a79.getContadorObeso() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setContadorObeso(totalhombres_80omas.getContadorObeso() + 1);
                        }

                    } else {//Genero Femenino
                        //Mismo para hombre pero cambiando lista para mujer

                        totalmujeres.setContadorObeso(totalmujeres.getContadorObeso() + 1);
                        if (pacientes.isEtnia()) {
                            totalmujeres_pueblos.setContadorObeso(totalmujeres_pueblos.getContadorObeso() + 1);
                        }

                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setContadorObeso(totalmujeres_65a69.getContadorObeso() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setContadorObeso(totalmujeres_70a74.getContadorObeso() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setContadorObeso(totalmujeres_75a79.getContadorObeso() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setContadorObeso(totalmujeres_80omas.getContadorObeso() + 1);
                        }
                    }

                }

            } else {

            }

        }
        totalAmbosSexos.setColumnName1("Total");
        totalAmbosSexos.setColumnName2("Ambos Sexos");
        totalAmbosSexos.setTotalSeccionB(totalAmbosSexos.getContadorBajoPeso() + totalAmbosSexos.getContadorNormal() + totalAmbosSexos.getContadorSobrepeso() + totalAmbosSexos.getContadorObeso());
        totalhombres.setColumnName1("Total");
        totalhombres.setColumnName2("Hombres");
        totalhombres.setTotalSeccionB(totalhombres.getContadorBajoPeso() + totalhombres.getContadorNormal() + totalhombres.getContadorSobrepeso() + totalhombres.getContadorObeso());
        totalmujeres.setColumnName1("Total");
        totalmujeres.setColumnName2("Mujeres");
        totalmujeres.setTotalSeccionB(totalmujeres.getContadorBajoPeso() + totalmujeres.getContadorNormal() + totalmujeres.getContadorSobrepeso() + totalmujeres.getContadorObeso());

        totalhombres_65a69.setColumnName1("65 a 69");
        totalhombres_65a69.setColumnName2("Hombres");
        totalhombres_65a69.setTotalSeccionB(totalhombres_65a69.getContadorBajoPeso() + totalhombres_65a69.getContadorNormal() + totalhombres_65a69.getContadorSobrepeso() + totalhombres_65a69.getContadorObeso());
        totalmujeres_65a69.setColumnName1("65 a 69");
        totalmujeres_65a69.setColumnName2("Mujeres");
        totalmujeres_65a69.setTotalSeccionB(totalmujeres_65a69.getContadorBajoPeso() + totalmujeres_65a69.getContadorNormal() + totalmujeres_65a69.getContadorSobrepeso() + totalmujeres_65a69.getContadorObeso());

        totalhombres_70a74.setColumnName1("70 a 74");
        totalhombres_70a74.setColumnName2("Hombres");
        totalhombres_70a74.setTotalSeccionB(totalhombres_70a74.getContadorBajoPeso() + totalhombres_70a74.getContadorNormal() + totalhombres_70a74.getContadorSobrepeso() + totalhombres_70a74.getContadorObeso());
        totalmujeres_70a74.setColumnName1("70 a 74");
        totalmujeres_70a74.setColumnName2("Mujeres");
        totalmujeres_70a74.setTotalSeccionB(totalmujeres_70a74.getContadorBajoPeso() + totalmujeres_70a74.getContadorNormal() + totalmujeres_70a74.getContadorSobrepeso() + totalmujeres_70a74.getContadorObeso());

        totalhombres_75a79.setColumnName1("75 a 79");
        totalhombres_75a79.setColumnName2("Hombres");
        totalhombres_75a79.setTotalSeccionB(totalhombres_75a79.getContadorBajoPeso() + totalhombres_75a79.getContadorNormal() + totalhombres_75a79.getContadorSobrepeso() + totalhombres_75a79.getContadorObeso());
        totalmujeres_75a79.setColumnName1("75 a 79");
        totalmujeres_75a79.setColumnName2("Mujeres");
        totalmujeres_75a79.setTotalSeccionB(totalmujeres_75a79.getContadorBajoPeso() + totalmujeres_75a79.getContadorNormal() + totalmujeres_75a79.getContadorSobrepeso() + totalmujeres_75a79.getContadorObeso());

        totalhombres_80omas.setColumnName1("80 y más");
        totalhombres_80omas.setColumnName2("Hombres");
        totalhombres_80omas.setTotalSeccionB(totalhombres_80omas.getContadorBajoPeso() + totalhombres_80omas.getContadorNormal() + totalhombres_80omas.getContadorSobrepeso() + totalhombres_80omas.getContadorObeso());
        totalmujeres_80omas.setColumnName1("80 y más");
        totalmujeres_80omas.setColumnName2("Mujeres");
        totalmujeres_80omas.setTotalSeccionB(totalmujeres_80omas.getContadorBajoPeso() + totalmujeres_80omas.getContadorNormal() + totalmujeres_80omas.getContadorSobrepeso() + totalmujeres_80omas.getContadorObeso());

        totalhombres_pueblos.setColumnName1("Pueblos");
        totalhombres_pueblos.setColumnName2("Hombres");
        totalhombres_pueblos.setTotalSeccionB(totalhombres_pueblos.getContadorBajoPeso() + totalhombres_pueblos.getContadorNormal() + totalhombres_pueblos.getContadorSobrepeso() + totalhombres_pueblos.getContadorObeso());
        totalmujeres_pueblos.setColumnName1("originarios");
        totalmujeres_pueblos.setColumnName2("Mujeres");
        totalmujeres_pueblos.setTotalSeccionB(totalmujeres_pueblos.getContadorBajoPeso() + totalmujeres_pueblos.getContadorNormal() + totalmujeres_pueblos.getContadorSobrepeso() + totalmujeres_pueblos.getContadorObeso());

        //añadir lista
        B_elementos.clear();

        B_elementos.add(totalAmbosSexos);
        B_elementos.add(totalhombres);
        B_elementos.add(totalmujeres);

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

    /**
     * *
     * Censo para la seccion C
     *
     * @return
     */
    public List<CensoSeccionC> censoPSAMSeccionC() {
        CensoSeccionC totalAmbosSexos = new CensoSeccionC();
        CensoSeccionC totalhombres = new CensoSeccionC();
        CensoSeccionC totalmujeres = new CensoSeccionC();
        CensoSeccionC totalhombres_65a69 = new CensoSeccionC();
        CensoSeccionC totalmujeres_65a69 = new CensoSeccionC();
        CensoSeccionC totalhombres_70a74 = new CensoSeccionC();
        CensoSeccionC totalmujeres_70a74 = new CensoSeccionC();
        CensoSeccionC totalhombres_75a79 = new CensoSeccionC();
        CensoSeccionC totalmujeres_75a79 = new CensoSeccionC();
        CensoSeccionC totalhombres_80omas = new CensoSeccionC();
        CensoSeccionC totalmujeres_80omas = new CensoSeccionC();

        List<Paciente> pacientes_habilitados = ejbPaciente.findbyPacienteActivo();
        List<CartolaSeguimientoPSAM> ccv;
        List<CartolaSeguimientoPSAM> ccv_filtro;
        List<CartolaSeguimientoPSAM> ccv_ordenado;
        for (Paciente pacientes : pacientes_habilitados) {
            boolean fue_censado = false;
            int edad;
            boolean registra_unaatencion = false;
            ccv = ejbCartolaFacade.findByPaciente(pacientes);//obtengo todas las cartolas por  pacientes
            ccv_ordenado = filtro(ccv);
            ccv_filtro = filtro_censables(ccv_ordenado);//se ordenan las cartolas, y se filtran solo als que entran al censo
            if (ccv_filtro.size() > 0) {
                edad = ccv_filtro.get(ccv_filtro.size() - 1).getEdad();
                if (ResultadoSospechaMaltrato(ccv_filtro)) {//Consultas sospecha de maltrato
                    totalAmbosSexos.setTotalSeccionC(totalAmbosSexos.getTotalSeccionC() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setTotalSeccionC(totalhombres.getTotalSeccionC() + 1);
                        //Dependiendo de la edad las condiciones son:
                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setTotalSeccionC(totalhombres_65a69.getTotalSeccionC() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setTotalSeccionC(totalhombres_70a74.getTotalSeccionC() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setTotalSeccionC(totalhombres_75a79.getTotalSeccionC() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setTotalSeccionC(totalhombres_80omas.getTotalSeccionC() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setTotalSeccionC(totalmujeres.getTotalSeccionC() + 1);
                        //Dependiendo de la edad las condiciones son:

                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setTotalSeccionC(totalmujeres_65a69.getTotalSeccionC() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setTotalSeccionC(totalmujeres_70a74.getTotalSeccionC() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setTotalSeccionC(totalmujeres_75a79.getTotalSeccionC() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setTotalSeccionC(totalmujeres_80omas.getTotalSeccionC() + 1);
                        }

                    }

                }

            } else {

            }
        }

        totalAmbosSexos.setColumnName1("Total");
        totalAmbosSexos.setColumnName2("Ambos Sexos");
        totalhombres.setColumnName1("Total");
        totalhombres.setColumnName2("Hombres");
        totalmujeres.setColumnName1("Total");
        totalmujeres.setColumnName2("Mujeres");
        totalhombres_65a69.setColumnName1("65 a 69");
        totalhombres_65a69.setColumnName2("Hombres");
        totalmujeres_65a69.setColumnName1("65 a 69");
        totalmujeres_65a69.setColumnName2("Mujeres");

        totalhombres_70a74.setColumnName1("70 a 74");
        totalmujeres_70a74.setColumnName1("70 a 74");
        totalhombres_70a74.setColumnName2("Hombres");
        totalmujeres_70a74.setColumnName2("Mujeres");

        totalhombres_75a79.setColumnName1("75 a 79");
        totalmujeres_75a79.setColumnName1("75 a 79");
        totalhombres_75a79.setColumnName2("Hombres");
        totalmujeres_75a79.setColumnName2("Mujeres");

        totalhombres_80omas.setColumnName1("80 y más");
        totalmujeres_80omas.setColumnName1("80 y más");
        totalhombres_80omas.setColumnName2("Hombres");
        totalmujeres_80omas.setColumnName2("Mujeres");

        C_elementos.clear();

        C_elementos.add(totalAmbosSexos);
        C_elementos.add(totalhombres);
        C_elementos.add(totalmujeres);
        C_elementos.add(totalhombres_65a69);
        C_elementos.add(totalmujeres_65a69);
        C_elementos.add(totalhombres_70a74);
        C_elementos.add(totalmujeres_70a74);
        C_elementos.add(totalhombres_75a79);
        C_elementos.add(totalmujeres_75a79);
        C_elementos.add(totalhombres_80omas);
        C_elementos.add(totalmujeres_80omas);

        return C_elementos;

    }

    /**
     * Censo seccion D
     *
     * @return
     */
    public List<CensoSeccionD> censoPSAMSeccionD() {
        CensoSeccionD totalAmbosSexos = new CensoSeccionD();
        CensoSeccionD totalhombres = new CensoSeccionD();
        CensoSeccionD totalmujeres = new CensoSeccionD();
        CensoSeccionD totalhombres_65a69 = new CensoSeccionD();
        CensoSeccionD totalmujeres_65a69 = new CensoSeccionD();
        CensoSeccionD totalhombres_70a74 = new CensoSeccionD();
        CensoSeccionD totalmujeres_70a74 = new CensoSeccionD();
        CensoSeccionD totalhombres_75a79 = new CensoSeccionD();
        CensoSeccionD totalmujeres_75a79 = new CensoSeccionD();
        CensoSeccionD totalhombres_80omas = new CensoSeccionD();
        CensoSeccionD totalmujeres_80omas = new CensoSeccionD();
        List<Paciente> pacientes_habilitados = ejbPaciente.findbyPacienteActivo();
        List<CartolaSeguimientoPSAM> ccv;
        List<CartolaSeguimientoPSAM> ccv_filtro;
        List<CartolaSeguimientoPSAM> ccv_ordenado;
        for (Paciente pacientes : pacientes_habilitados) {
            boolean fue_censado = false;
            int edad;
            boolean registra_unaatencion = false;
            ccv = ejbCartolaFacade.findByPaciente(pacientes);//obtengo todas las cartolas por  pacientes
            ccv_ordenado = filtro(ccv);
            ccv_filtro = filtro_censables(ccv_ordenado);//se ordenan las cartolas, y se filtran solo als que entran al censo
            if (ccv_filtro.size() > 0) {
                edad = ccv_filtro.get(ccv_filtro.size() - 1).getEdad();
                if (ResultadoActividadFisica(ccv_filtro)) {
                    totalAmbosSexos.setTotalSeccionD(totalAmbosSexos.getTotalSeccionD() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setTotalSeccionD(totalhombres.getTotalSeccionD() + 1);
                        //Dependiendo de la edad las condiciones son:

                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setTotalSeccionD(totalhombres_65a69.getTotalSeccionD() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setTotalSeccionD(totalhombres_70a74.getTotalSeccionD() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setTotalSeccionD(totalhombres_75a79.getTotalSeccionD() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setTotalSeccionD(totalhombres_80omas.getTotalSeccionD() + 1);
                        }

                    } else {//Genero Femenino
                        totalmujeres.setTotalSeccionD(totalmujeres.getTotalSeccionD() + 1);
                        //Dependiendo de la edad las condiciones son:

                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setTotalSeccionD(totalmujeres_65a69.getTotalSeccionD() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setTotalSeccionD(totalmujeres_70a74.getTotalSeccionD() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setTotalSeccionD(totalmujeres_75a79.getTotalSeccionD() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setTotalSeccionD(totalmujeres_80omas.getTotalSeccionD() + 1);
                        }
                    }

                }

            } else {
            }
        }

        totalAmbosSexos.setColumnName1("Total");
        totalAmbosSexos.setColumnName2("Ambos Sexos");
        totalhombres.setColumnName1("Total");
        totalhombres.setColumnName2("Hombres");
        totalmujeres.setColumnName1("Total");
        totalmujeres.setColumnName2("Mujeres");
        totalhombres_65a69.setColumnName1("65 a 69");
        totalhombres_65a69.setColumnName2("Hombres");
        totalmujeres_65a69.setColumnName1("65 a 69");
        totalmujeres_65a69.setColumnName2("Mujeres");

        totalhombres_70a74.setColumnName1("70 a 74");
        totalmujeres_70a74.setColumnName1("70 a 74");
        totalhombres_70a74.setColumnName2("Hombres");
        totalmujeres_70a74.setColumnName2("Mujeres");

        totalhombres_75a79.setColumnName1("75 a 79");
        totalmujeres_75a79.setColumnName1("75 a 79");
        totalhombres_75a79.setColumnName2("Hombres");
        totalmujeres_75a79.setColumnName2("Mujeres");

        totalhombres_80omas.setColumnName1("80 y más");
        totalmujeres_80omas.setColumnName1("80 y más");
        totalhombres_80omas.setColumnName2("Hombres");
        totalmujeres_80omas.setColumnName2("Mujeres");

        D_elementos.clear();

        D_elementos.add(totalAmbosSexos);
        D_elementos.add(totalhombres);
        D_elementos.add(totalmujeres);
        D_elementos.add(totalhombres_65a69);
        D_elementos.add(totalmujeres_65a69);
        D_elementos.add(totalhombres_70a74);
        D_elementos.add(totalmujeres_70a74);
        D_elementos.add(totalhombres_75a79);
        D_elementos.add(totalmujeres_75a79);
        D_elementos.add(totalhombres_80omas);
        D_elementos.add(totalmujeres_80omas);
        return D_elementos;

    }

    /**
     * Censo Seccion E
     *
     * @return
     */
    public List<CensoSeccionE> censoPSAMSeccionE() {
        CensoSeccionE totalAmbosSexos = new CensoSeccionE();
        CensoSeccionE totalhombres = new CensoSeccionE();
        CensoSeccionE totalmujeres = new CensoSeccionE();
        List<Paciente> pacientes_habilitados = ejbPaciente.findbyPacienteActivo();
        List<CartolaSeguimientoPSAM> ccv = new ArrayList<>();
        List<CartolaSeguimientoPSAM> ccv_filtro = new ArrayList<>();
        List<CartolaSeguimientoPSAM> ccv_ordenado = new ArrayList<>();
        for (Paciente pacientes : pacientes_habilitados) {
            boolean fue_censado = false;
            int edad;
            boolean registra_unaatencion = false;
            ccv = ejbCartolaFacade.findByPaciente(pacientes);//obtengo todas las cartolas por  pacientes
            ccv_ordenado = filtro(ccv);
            ccv_filtro = filtro_censables(ccv_ordenado);//se ordenan las cartolas, y se filtran solo als que entran al censo
            boolean ResultadosE[] = new boolean[2];
            ResultadosE[0] = false;
            ResultadosE[1] = false;
            if (ccv_filtro.size() > 0) {
                ResultadosE = ResultadoSeccionE(ResultadosE, ccv_ordenado, ccv_filtro);
                edad = ccv_filtro.get(ccv_filtro.size() - 1).getEdad();
                if (ResultadosE[1] == true) {
                    totalAmbosSexos.setTotal_institu(totalAmbosSexos.getTotal_institu() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setTotal_institu(totalhombres.getTotal_institu() + 1);
                    } else {//Genero Femenino
                        totalmujeres.setTotal_institu(totalmujeres.getTotal_institu() + 1);
                    }

                }
                if (ResultadosE[0] == true) {

                    totalAmbosSexos.setTotal_severo(totalAmbosSexos.getTotal_severo() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setTotal_severo(totalhombres.getTotal_severo() + 1);
                    } else {//Genero Femenino
                        totalmujeres.setTotal_severo(totalmujeres.getTotal_severo() + 1);
                    }
                }

            } else {

            }
        }
        totalAmbosSexos.setColumnName1("Total");
        totalAmbosSexos.setColumnName2("Ambos Sexos");
        totalhombres.setColumnName1("Total");
        totalhombres.setColumnName2("Hombres");
        totalmujeres.setColumnName1("Total");
        totalmujeres.setColumnName2("Mujeres");

        E_elementos.clear();
        E_elementos.add(totalAmbosSexos);
        E_elementos.add(totalhombres);
        E_elementos.add(totalmujeres);
        return E_elementos;
    }

    /**
     * Censo Seccion F
     *
     * @return
     */
    public List<CensoSeccionF> censoPSAMSeccionF() {
        CensoSeccionF totalAmbosSexos = new CensoSeccionF();
        CensoSeccionF totalhombres = new CensoSeccionF();
        CensoSeccionF totalmujeres = new CensoSeccionF();
        CensoSeccionF totalhombres_65a69 = new CensoSeccionF();
        CensoSeccionF totalmujeres_65a69 = new CensoSeccionF();
        CensoSeccionF totalhombres_70a74 = new CensoSeccionF();
        CensoSeccionF totalmujeres_70a74 = new CensoSeccionF();
        CensoSeccionF totalhombres_75a79 = new CensoSeccionF();
        CensoSeccionF totalmujeres_75a79 = new CensoSeccionF();
        CensoSeccionF totalhombres_80omas = new CensoSeccionF();
        CensoSeccionF totalmujeres_80omas = new CensoSeccionF();
        List<Paciente> pacientes_habilitados = ejbPaciente.findbyPacienteActivo();
        List<CartolaSeguimientoPSAM> ccv;
        List<CartolaSeguimientoPSAM> ccv_filtro;
        List<CartolaSeguimientoPSAM> ccv_ordenado;
        for (Paciente pacientes : pacientes_habilitados) {
            boolean fue_censado = false;
            int edad;
            boolean registra_unaatencion = false;
            ccv = ejbCartolaFacade.findByPaciente(pacientes);//obtengo todas las cartolas por  pacientes
            ccv_ordenado = filtro(ccv);
            ccv_filtro = filtro_censables(ccv_ordenado);//se ordenan las cartolas, y se filtran solo als que entran al censo
            boolean ResultadosF[] = new boolean[3];

            if (ccv_filtro.size() > 0) {
                edad = ccv_filtro.get(ccv_filtro.size() - 1).getEdad();
                ResultadosF = ResultadoSeccionF(ccv_filtro, ResultadosF);
                if (ResultadosF[0]) {
                    totalAmbosSexos.setRiesgo_normal(totalAmbosSexos.getRiesgo_normal() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setRiesgo_normal(totalhombres.getRiesgo_normal() + 1);
                        //Dependiendo de la edad las condiciones son:

                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setRiesgo_normal(totalhombres_65a69.getRiesgo_normal() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setRiesgo_normal(totalhombres_70a74.getRiesgo_normal() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setRiesgo_normal(totalhombres_75a79.getRiesgo_normal() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setRiesgo_normal(totalhombres_80omas.getRiesgo_normal() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setRiesgo_normal(totalmujeres.getRiesgo_normal() + 1);
                        //Dependiendo de la edad las condiciones son:

                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setRiesgo_normal(totalmujeres_65a69.getRiesgo_normal() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setRiesgo_normal(totalmujeres_70a74.getRiesgo_normal() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setRiesgo_normal(totalmujeres_75a79.getRiesgo_normal() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setRiesgo_normal(totalmujeres_80omas.getRiesgo_normal() + 1);
                        }

                    }

                }

                if (ResultadosF[1]) {
                    totalAmbosSexos.setRiesgo_leve(totalAmbosSexos.getRiesgo_leve() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setRiesgo_leve(totalhombres.getRiesgo_leve() + 1);
                        //Dependiendo de la edad las condiciones son:

                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setRiesgo_leve(totalhombres_65a69.getRiesgo_leve() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setRiesgo_leve(totalhombres_70a74.getRiesgo_leve() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setRiesgo_leve(totalhombres_75a79.getRiesgo_leve() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setRiesgo_leve(totalhombres_80omas.getRiesgo_leve() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setRiesgo_leve(totalmujeres.getRiesgo_leve() + 1);
                        //Dependiendo de la edad las condiciones son:

                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setRiesgo_leve(totalmujeres_65a69.getRiesgo_leve() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setRiesgo_leve(totalmujeres_70a74.getRiesgo_leve() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setRiesgo_leve(totalmujeres_75a79.getRiesgo_leve() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setRiesgo_leve(totalmujeres_80omas.getRiesgo_leve() + 1);
                        }

                    }

                }

                if (ResultadosF[2]) {
                    totalAmbosSexos.setRiesgo_alto(totalAmbosSexos.getRiesgo_alto() + 1);
                    if (pacientes.getGenero_paciente().equals("Masculino")) {
                        totalhombres.setRiesgo_alto(totalhombres.getRiesgo_alto() + 1);
                        //Dependiendo de la edad las condiciones son:

                        if (edad >= 65 && edad <= 69) {
                            totalhombres_65a69.setRiesgo_alto(totalhombres_65a69.getRiesgo_alto() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalhombres_70a74.setRiesgo_alto(totalhombres_70a74.getRiesgo_alto() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalhombres_75a79.setRiesgo_alto(totalhombres_75a79.getRiesgo_alto() + 1);
                        } else if (edad >= 80) {
                            totalhombres_80omas.setRiesgo_alto(totalhombres_80omas.getRiesgo_alto() + 1);
                        }
                    } else {//Genero Femenino
                        totalmujeres.setRiesgo_alto(totalmujeres.getRiesgo_alto() + 1);
                        //Dependiendo de la edad las condiciones son:

                        if (edad >= 65 && edad <= 69) {
                            totalmujeres_65a69.setRiesgo_alto(totalmujeres_65a69.getRiesgo_alto() + 1);
                        } else if (edad >= 70 && edad <= 74) {
                            totalmujeres_70a74.setRiesgo_alto(totalmujeres_70a74.getRiesgo_alto() + 1);
                        } else if (edad >= 75 && edad <= 79) {
                            totalmujeres_75a79.setRiesgo_alto(totalmujeres_75a79.getRiesgo_alto() + 1);
                        } else if (edad >= 80) {
                            totalmujeres_80omas.setRiesgo_alto(totalmujeres_80omas.getRiesgo_alto() + 1);
                        }

                    }

                }

            } else {

            }

        }

        totalAmbosSexos.setColumnName1("Total");
        totalAmbosSexos.setColumnName2("Ambos Sexos");
        totalhombres.setColumnName1("Total");
        totalhombres.setColumnName2("Hombres");
        totalmujeres.setColumnName1("Total");
        totalmujeres.setColumnName2("Mujeres");
        totalhombres_65a69.setColumnName1("65 a 69");
        totalhombres_65a69.setColumnName2("Hombres");
        totalmujeres_65a69.setColumnName1("65 a 69");
        totalmujeres_65a69.setColumnName2("Mujeres");

        totalhombres_70a74.setColumnName1("70 a 74");
        totalmujeres_70a74.setColumnName1("70 a 74");
        totalhombres_70a74.setColumnName2("Hombres");
        totalmujeres_70a74.setColumnName2("Mujeres");

        totalhombres_75a79.setColumnName1("75 a 79");
        totalmujeres_75a79.setColumnName1("75 a 79");
        totalhombres_75a79.setColumnName2("Hombres");
        totalmujeres_75a79.setColumnName2("Mujeres");

        totalhombres_80omas.setColumnName1("80 y más");
        totalmujeres_80omas.setColumnName1("80 y más");
        totalhombres_80omas.setColumnName2("Hombres");
        totalmujeres_80omas.setColumnName2("Mujeres");

        F_elementos.clear();
        F_elementos.add(totalAmbosSexos);
        F_elementos.add(totalhombres);
        F_elementos.add(totalmujeres);
        F_elementos.add(totalhombres_65a69);
        F_elementos.add(totalmujeres_65a69);
        F_elementos.add(totalhombres_70a74);
        F_elementos.add(totalmujeres_70a74);
        F_elementos.add(totalhombres_75a79);
        F_elementos.add(totalmujeres_75a79);
        F_elementos.add(totalhombres_80omas);
        F_elementos.add(totalmujeres_80omas);
        return F_elementos;

    }

    /**
     *
     * Retorna si el paciente posee el atributo sospecha del maltrato en alguna
     * cartola en regresion
     *
     * @param cartolas
     * @return
     *
     */
    public boolean ResultadoSospechaMaltrato(List<CartolaSeguimientoPSAM> cartolas) {
        for (int i = cartolas.size() - 1; i >= 0; i--) {
            if (cartolas.get(i).isSospecha_maltrato()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna true si el paciente posee el atributo programa mas
     *
     * @return
     */
    public boolean Resultadoprograma(List<CartolaSeguimientoPSAM> cartolas) {
        for (int i = cartolas.size() - 1; i >= 0; i--) {
            if (cartolas.get(i).getPertenece_al_programa_mas() != null) {
                if (cartolas.get(i).getPertenece_al_programa_mas().equals("No se evalúa") == false) {
                    if (cartolas.get(i).getPertenece_al_programa_mas().equals("Si")) {
                        return true;
                    } else {
                        return false;
                    }
                }

            }
        }
        return false;
    }

    /**
     * Retorna si el paciente posee el atributo actividad fisica en alguna
     * cartola en regresion
     *
     * @param cartolas
     * @return
     */
    public boolean ResultadoActividadFisica(List<CartolaSeguimientoPSAM> cartolas) {
        for (int i = cartolas.size() - 1; i >= 0; i--) {
            if (cartolas.get(i).isRealiza_actividadFisica()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna resultados en arreglo acerca de atributos en regresion e
     * historico
     *
     * @param ResultadosE
     * @param ccvHistorico
     * @param cartolas
     * @return
     */
    public boolean[] ResultadoSeccionE(boolean ResultadosE[], List<CartolaSeguimientoPSAM> ccvHistorico, List<CartolaSeguimientoPSAM> cartolas) {
        //Barthel Severo es DOPA
        ResultadosE[1] = false;
        ResultadosE[0] = false;
        if (cartolas.get(cartolas.size() - 1).getClasificacion_barthel().equals("Grave") || cartolas.get(cartolas.size() - 1).getClasificacion_barthel().equals("Total")) {

            ResultadosE[0] = true;
        }

        for (CartolaSeguimientoPSAM historico : ccvHistorico) {
            if (historico.isPaciente_institucionalizado()) {
                ResultadosE[1] = true;
                break;
            }
        }

        return ResultadosE;
    }

    /**
     * Retorna si el paciente posee el atributo riesgo de caidas (Normal,Leve o
     * Alto) en alguna cartola en regresion
     *
     * @param cartolas
     * @param ResultadoF
     * @return
     */
    public boolean[] ResultadoSeccionF(List<CartolaSeguimientoPSAM> cartolas, boolean ResultadoF[]) {
        int bandera = 0;
        ResultadoF[0] = false;
        ResultadoF[1] = false;
        ResultadoF[2] = false;
        for (int i = cartolas.size() - 1; i >= 0; i--) {
            if (cartolas.get(i).getValoracion_riesgo() != null && bandera == 0) {
                if (cartolas.get(i).getValoracion_riesgo().equals("Normal")) {
                    ResultadoF[0] = true;
                    break;
                } else if (cartolas.get(i).getValoracion_riesgo().equals("Riesgo leve")) {
                    ResultadoF[1] = true;
                    break;
                } else if (cartolas.get(i).getValoracion_riesgo().equals("Alto riesgo")) {
                    ResultadoF[2] = true;
                    break;
                }
            }
        }

        return ResultadoF;
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

    public List<CartolaSeguimientoPSAM> filtro_censables(List<CartolaSeguimientoPSAM> entrada) {
        List<CartolaSeguimientoPSAM> lista = new ArrayList<>();

        for (int i = 0; i < entrada.size(); i++) {
            if (isCensable(entrada.get(i).getFechaAtencion()) && entrada.get(i).getEdad() >= 65) {
                lista.add(entrada.get(i));
            }
        }
        return lista;

    }

    public List<CartolaSeguimientoPSAM> filtro(List<CartolaSeguimientoPSAM> entrada) {

        if (entrada.size() <= 1) {
            return entrada;
        }

        int posicion_media = (int) Math.ceil((double) entrada.size() / 2);
        CartolaSeguimientoPSAM ccv_pivot;
        ccv_pivot = entrada.get(posicion_media);

        List<CartolaSeguimientoPSAM> menores = new ArrayList<CartolaSeguimientoPSAM>();
        List<CartolaSeguimientoPSAM> mayores = new ArrayList<CartolaSeguimientoPSAM>();

        for (int i = 0; i < entrada.size(); i++) {
            if (entrada.get(i).getFechaAtencion().compareTo(ccv_pivot.getFechaAtencion()) <= 0) {
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

    public List<CartolaSeguimientoPSAM> concatenear(List<CartolaSeguimientoPSAM> less, CartolaSeguimientoPSAM pivot, List<CartolaSeguimientoPSAM> mayores) {

        List<CartolaSeguimientoPSAM> lista = new ArrayList<CartolaSeguimientoPSAM>();

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
