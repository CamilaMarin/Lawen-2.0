package managedbeans.cardiovascular.censonorem;

import entities.Paciente;
import entities.cardiovascular.CartolaSeguimientoCCV;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
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
@Named(value = "consultasCensoCCVnoREM")
@SessionScoped
public class ConsultasCensoCCVnoREM implements Serializable {

    /**
     * Creates a new instance of ConsultasCensoCCVnoREM
     */
    public ConsultasCensoCCVnoREM() {

    }

    public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Carga completada", "Carga completada"));
    }

    public void onCancel() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Progress Cancelled", "Progress Cancelled"));
    }

    private List<CensoCCVnoREM> Pacientes15a19 = new ArrayList<>();
    private List<CensoCCVnoREM> Pacientes20a64 = new ArrayList<>();
    private List<CensoCCVnoREM> Pacientes65ymas = new ArrayList<>();
    private List<CensoCCVnoREMExcluidos> Pacientes_excluidos;
    @EJB
    private PacienteFacadeLocal ejbPaciente;
    @EJB
    private CartolaSeguimientoCCVFacadeLocal ejbCartola;

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

    public List<CensoCCVnoREM> getPacientes15a19() {
        return Pacientes15a19;
    }

    public void setPacientes15a19(List<CensoCCVnoREM> Pacientes15a19) {
        this.Pacientes15a19 = Pacientes15a19;
    }

    public List<CensoCCVnoREM> getPacientes20a64() {
        return Pacientes20a64;
    }

    public void setPacientes20a64(List<CensoCCVnoREM> Pacientes20a64) {
        this.Pacientes20a64 = Pacientes20a64;
    }

    public List<CensoCCVnoREM> getPacientes65ymas() {
        return Pacientes65ymas;
    }

    public void setPacientes65ymas(List<CensoCCVnoREM> Pacientes65ymas) {
        this.Pacientes65ymas = Pacientes65ymas;
    }

    public List<CensoCCVnoREMExcluidos> getPacientes_excluidos() {
        return Pacientes_excluidos;
    }

    public void setPacientes_excluidos(List<CensoCCVnoREMExcluidos> Pacientes_excluidos) {
        this.Pacientes_excluidos = Pacientes_excluidos;
    }
    /**
     * Metodo init , se carga antes de cargar la vista
     */
    public void init() {
        Pacientes_excluidos = new ArrayList<>();
        List<Paciente> pasivos_prevision = ejbPaciente.findbyPacientePasivoPrevision();
        List<Paciente> pasivos_trasalado = ejbPaciente.findbyPacientePasivoTraslado();
        CalculoCensoNoREM();
        for (Paciente prevision : pasivos_prevision) {
            CensoCCVnoREMExcluidos nocensado = new CensoCCVnoREMExcluidos();
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
            CensoCCVnoREMExcluidos nocensado = new CensoCCVnoREMExcluidos();
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
     * Calculo del censo no REM
     */
    public void CalculoCensoNoREM() {
        //Pacientes_excluidos.clear();
        CensoCCVnoREM diabeticos15a19 = new CensoCCVnoREM();
        CensoCCVnoREM hombresdiabeticos15a19 = new CensoCCVnoREM();
        CensoCCVnoREM mujeresdiabeticos15a19 = new CensoCCVnoREM();
        CensoCCVnoREM diabeticos20a64 = new CensoCCVnoREM();
        CensoCCVnoREM hombresdiabeticos20a64 = new CensoCCVnoREM();
        CensoCCVnoREM mujeresdiabeticos20a64 = new CensoCCVnoREM();
        CensoCCVnoREM diabeticos65ymas = new CensoCCVnoREM();
        CensoCCVnoREM hombresdiabeticos65ymas = new CensoCCVnoREM();
        CensoCCVnoREM mujeresdiabeticos65ymas = new CensoCCVnoREM();
        CensoCCVnoREM hipertensos15a19 = new CensoCCVnoREM();
        CensoCCVnoREM hombreshipertensos15a19 = new CensoCCVnoREM();
        CensoCCVnoREM mujereshipertensos15a19 = new CensoCCVnoREM();
        CensoCCVnoREM hipertensos20a64 = new CensoCCVnoREM();
        CensoCCVnoREM hombreshipertensos20a64 = new CensoCCVnoREM();
        CensoCCVnoREM mujereshipertensos20a64 = new CensoCCVnoREM();
        CensoCCVnoREM hipertensos65ymas = new CensoCCVnoREM();
        CensoCCVnoREM hombreshipertensos65ymas = new CensoCCVnoREM();
        CensoCCVnoREM mujereshipertensos65ymas = new CensoCCVnoREM();
        CensoCCVnoREM dislipidemicos15a19 = new CensoCCVnoREM();
        CensoCCVnoREM hombresdislipidemicos15a19 = new CensoCCVnoREM();
        CensoCCVnoREM mujeresdislipidemicos15a19 = new CensoCCVnoREM();
        CensoCCVnoREM dislipidemicos20a64 = new CensoCCVnoREM();
        CensoCCVnoREM hombresdislipidemicos20a64 = new CensoCCVnoREM();
        CensoCCVnoREM mujeresdislipidemicos20a64 = new CensoCCVnoREM();
        CensoCCVnoREM dislipidemicos65ymas = new CensoCCVnoREM();
        CensoCCVnoREM hombresdislipidemicos65ymas = new CensoCCVnoREM();
        CensoCCVnoREM mujeresdislipidemicos65ymas = new CensoCCVnoREM();
        List<Paciente> pacientes_habilitados = ejbPaciente.findbyPacienteActivo();
        List<Paciente> pacientes_fallecimiento = ejbPaciente.findbyPacientePasivoFallecimiento();
        List<CartolaSeguimientoCCV> ccv;
        List<CartolaSeguimientoCCV> ccv_filtro;
        List<CartolaSeguimientoCCV> ccv_ordenado;
        List<CartolaSeguimientoCCV> ccvf;
        List<CartolaSeguimientoCCV> ccv_filtrof;
        List<CartolaSeguimientoCCV> ccv_ordenadof;
        boolean resultados[];

        for (Paciente pacientes : pacientes_habilitados) {

            boolean fue_censado = false;
            int edad;
            boolean registra_unaatencion = false;
            resultados = new boolean[24];
            for (int i = 0; i < 24; i++) {
                resultados[i] = false;
            }
            ccv = ejbCartola.findByPaciente(pacientes);//obtengo todas las cartolas por  pacientes
            if (ccv.size() > 0) {
                registra_unaatencion = true;
            }
            ccv_ordenado = filtro(ccv);
            ccv_filtro = filtro_censables(ccv_ordenado);//se ordenan las cartolas, y se filtran solo als que entran al censo
            //en este punto por paciente tenemos las cartola que entran en el censo 
            //filtramos por paciente si su ultima cartola , la fecha mas alta que tiene es censable
            if (ccv_filtro.size() > 0) {//si tiene un elemento censable

                resultados = ResultadosNoRem(resultados, ccv_filtro);
                edad = ccv_filtro.get(ccv_filtro.size() - 1).getEdad_paciente();
                if (resultados[0]) {
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setPerfilLipidico(diabeticos15a19.getPerfilLipidico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setPerfilLipidico(hombresdiabeticos15a19.getPerfilLipidico() + 1);
                            } else {
                                mujeresdiabeticos15a19.setPerfilLipidico(mujeresdiabeticos15a19.getPerfilLipidico() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setPerfilLipidico(diabeticos20a64.getPerfilLipidico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setPerfilLipidico(hombresdiabeticos20a64.getPerfilLipidico() + 1);
                            } else {
                                mujeresdiabeticos20a64.setPerfilLipidico(mujeresdiabeticos20a64.getPerfilLipidico() + 1);
                            }

                        } else if (edad >= 65) {
                            diabeticos65ymas.setPerfilLipidico(diabeticos65ymas.getPerfilLipidico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setPerfilLipidico(hombresdiabeticos65ymas.getPerfilLipidico() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setPerfilLipidico(mujeresdiabeticos65ymas.getPerfilLipidico() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setPerfilLipidico(hipertensos15a19.getPerfilLipidico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setPerfilLipidico(hombreshipertensos15a19.getPerfilLipidico() + 1);
                            } else {
                                mujereshipertensos15a19.setPerfilLipidico(mujereshipertensos15a19.getPerfilLipidico() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setPerfilLipidico(hipertensos20a64.getPerfilLipidico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setPerfilLipidico(hombreshipertensos20a64.getPerfilLipidico() + 1);
                            } else {
                                mujereshipertensos20a64.setPerfilLipidico(mujereshipertensos20a64.getPerfilLipidico() + 1);
                            }

                        } else if (edad >= 65) {
                            hipertensos65ymas.setPerfilLipidico(hipertensos65ymas.getPerfilLipidico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setPerfilLipidico(hombreshipertensos65ymas.getPerfilLipidico() + 1);
                            } else {
                                mujereshipertensos65ymas.setPerfilLipidico(mujereshipertensos65ymas.getPerfilLipidico() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setPerfilLipidico(dislipidemicos15a19.getPerfilLipidico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setPerfilLipidico(hombresdislipidemicos15a19.getPerfilLipidico() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setPerfilLipidico(mujeresdislipidemicos15a19.getPerfilLipidico() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setPerfilLipidico(dislipidemicos20a64.getPerfilLipidico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setPerfilLipidico(hombresdislipidemicos20a64.getPerfilLipidico() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setPerfilLipidico(mujeresdislipidemicos20a64.getPerfilLipidico() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setPerfilLipidico(dislipidemicos65ymas.getPerfilLipidico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setPerfilLipidico(hombresdislipidemicos65ymas.getPerfilLipidico() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setPerfilLipidico(mujeresdislipidemicos65ymas.getPerfilLipidico() + 1);
                            }

                        }

                    }
                }//FIN Perfil Lipidico

                if (resultados[1]) {
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setFondoOjo(diabeticos15a19.getFondoOjo() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setFondoOjo(hombresdiabeticos15a19.getFondoOjo() + 1);
                            } else {
                                mujeresdiabeticos15a19.setFondoOjo(mujeresdiabeticos15a19.getFondoOjo() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setFondoOjo(diabeticos20a64.getFondoOjo() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setFondoOjo(hombresdiabeticos20a64.getFondoOjo() + 1);
                            } else {
                                mujeresdiabeticos20a64.setFondoOjo(mujeresdiabeticos20a64.getFondoOjo() + 1);
                            }

                        } else if (edad >= 65) {
                            diabeticos65ymas.setFondoOjo(diabeticos65ymas.getFondoOjo() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setFondoOjo(hombresdiabeticos65ymas.getFondoOjo() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setFondoOjo(mujeresdiabeticos65ymas.getFondoOjo() + 1);
                            }
                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setFondoOjo(hipertensos15a19.getFondoOjo() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setFondoOjo(hombreshipertensos15a19.getFondoOjo() + 1);
                            } else {
                                mujereshipertensos15a19.setFondoOjo(mujereshipertensos15a19.getFondoOjo() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setFondoOjo(hipertensos20a64.getFondoOjo() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setFondoOjo(hombreshipertensos20a64.getFondoOjo() + 1);
                            } else {
                                mujereshipertensos20a64.setFondoOjo(mujereshipertensos20a64.getFondoOjo() + 1);
                            }

                        } else if (edad >= 65) {
                            hipertensos65ymas.setFondoOjo(hipertensos65ymas.getFondoOjo() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setFondoOjo(hombreshipertensos65ymas.getFondoOjo() + 1);
                            } else {
                                mujereshipertensos65ymas.setFondoOjo(mujereshipertensos65ymas.getFondoOjo() + 1);
                            }

                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setFondoOjo(dislipidemicos15a19.getFondoOjo() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setFondoOjo(hombresdislipidemicos15a19.getFondoOjo() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setFondoOjo(mujeresdislipidemicos15a19.getFondoOjo() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setFondoOjo(dislipidemicos20a64.getFondoOjo() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setFondoOjo(hombresdislipidemicos20a64.getFondoOjo() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setFondoOjo(mujeresdislipidemicos20a64.getFondoOjo() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setFondoOjo(dislipidemicos65ymas.getFondoOjo() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setFondoOjo(hombresdislipidemicos65ymas.getFondoOjo() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setFondoOjo(mujeresdislipidemicos65ymas.getFondoOjo() + 1);
                            }

                        }

                    }
                }//FIN Fondo de ojo

                if (resultados[2]) {//Atencion podologica
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setAtencionPodologica(diabeticos15a19.getAtencionPodologica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setAtencionPodologica(hombresdiabeticos15a19.getAtencionPodologica() + 1);
                            } else {
                                mujeresdiabeticos15a19.setAtencionPodologica(mujeresdiabeticos15a19.getAtencionPodologica() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setAtencionPodologica(diabeticos20a64.getAtencionPodologica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setAtencionPodologica(hombresdiabeticos20a64.getAtencionPodologica() + 1);
                            } else {
                                mujeresdiabeticos20a64.setAtencionPodologica(mujeresdiabeticos20a64.getAtencionPodologica() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setAtencionPodologica(diabeticos65ymas.getAtencionPodologica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setAtencionPodologica(hombresdiabeticos65ymas.getAtencionPodologica() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setAtencionPodologica(mujeresdiabeticos65ymas.getAtencionPodologica() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setAtencionPodologica(hipertensos15a19.getAtencionPodologica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setAtencionPodologica(hombreshipertensos15a19.getAtencionPodologica() + 1);
                            } else {
                                mujereshipertensos15a19.setAtencionPodologica(mujereshipertensos15a19.getAtencionPodologica() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setAtencionPodologica(hipertensos20a64.getAtencionPodologica() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setAtencionPodologica(hombreshipertensos20a64.getAtencionPodologica() + 1);
                            } else {
                                mujereshipertensos20a64.setAtencionPodologica(mujereshipertensos20a64.getAtencionPodologica() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setAtencionPodologica(hipertensos65ymas.getAtencionPodologica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setAtencionPodologica(hombreshipertensos65ymas.getAtencionPodologica() + 1);
                            } else {
                                mujereshipertensos65ymas.setAtencionPodologica(mujereshipertensos65ymas.getAtencionPodologica() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setAtencionPodologica(dislipidemicos15a19.getAtencionPodologica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setAtencionPodologica(hombresdislipidemicos15a19.getAtencionPodologica() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setAtencionPodologica(mujeresdislipidemicos15a19.getAtencionPodologica() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setAtencionPodologica(dislipidemicos20a64.getAtencionPodologica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setAtencionPodologica(hombresdislipidemicos20a64.getAtencionPodologica() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setAtencionPodologica(mujeresdislipidemicos20a64.getAtencionPodologica() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setAtencionPodologica(dislipidemicos65ymas.getAtencionPodologica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setAtencionPodologica(hombresdislipidemicos65ymas.getAtencionPodologica() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setAtencionPodologica(mujeresdislipidemicos65ymas.getAtencionPodologica() + 1);
                            }

                        }

                    }

                }//FIN Atencion Podologica

                if (resultados[3]) {//HBA1C 4 en año
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setHba1c4(diabeticos15a19.getHba1c4() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setHba1c4(hombresdiabeticos15a19.getHba1c4() + 1);
                            } else {
                                mujeresdiabeticos15a19.setHba1c4(mujeresdiabeticos15a19.getHba1c4() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setHba1c4(diabeticos20a64.getHba1c4() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setHba1c4(hombresdiabeticos20a64.getHba1c4() + 1);
                            } else {
                                mujeresdiabeticos20a64.setHba1c4(mujeresdiabeticos20a64.getHba1c4() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setHba1c4(diabeticos65ymas.getHba1c4() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setHba1c4(hombresdiabeticos65ymas.getHba1c4() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setHba1c4(mujeresdiabeticos65ymas.getHba1c4() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setHba1c4(hipertensos15a19.getHba1c4() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setHba1c4(hombreshipertensos15a19.getHba1c4() + 1);
                            } else {
                                mujereshipertensos15a19.setHba1c4(mujereshipertensos15a19.getHba1c4() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setHba1c4(hipertensos20a64.getHba1c4() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setHba1c4(hombreshipertensos20a64.getHba1c4() + 1);
                            } else {
                                mujereshipertensos20a64.setHba1c4(mujereshipertensos20a64.getHba1c4() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setHba1c4(hipertensos65ymas.getHba1c4() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setHba1c4(hombreshipertensos65ymas.getHba1c4() + 1);
                            } else {
                                mujereshipertensos65ymas.setHba1c4(mujereshipertensos65ymas.getHba1c4() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setHba1c4(dislipidemicos15a19.getHba1c4() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setHba1c4(hombresdislipidemicos15a19.getHba1c4() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setHba1c4(mujeresdislipidemicos15a19.getHba1c4() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setHba1c4(dislipidemicos20a64.getHba1c4() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setHba1c4(hombresdislipidemicos20a64.getHba1c4() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setHba1c4(mujeresdislipidemicos20a64.getHba1c4() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setHba1c4(dislipidemicos65ymas.getHba1c4() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setHba1c4(hombresdislipidemicos65ymas.getHba1c4() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setHba1c4(mujeresdislipidemicos65ymas.getHba1c4() + 1);
                            }

                        }

                    }
                }//FIN HBA1C 4

                if (resultados[4]) {//hba1c 3 
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setHba1c3(diabeticos15a19.getHba1c3() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setHba1c3(hombresdiabeticos15a19.getHba1c3() + 1);
                            } else {
                                mujeresdiabeticos15a19.setHba1c3(mujeresdiabeticos15a19.getHba1c3() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setHba1c3(diabeticos20a64.getHba1c3() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setHba1c3(hombresdiabeticos20a64.getHba1c3() + 1);
                            } else {
                                mujeresdiabeticos20a64.setHba1c3(mujeresdiabeticos20a64.getHba1c3() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setHba1c3(diabeticos65ymas.getHba1c3() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setHba1c3(hombresdiabeticos65ymas.getHba1c3() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setHba1c3(mujeresdiabeticos65ymas.getHba1c3() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setHba1c3(hipertensos15a19.getHba1c3() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setHba1c3(hombreshipertensos15a19.getHba1c3() + 1);
                            } else {
                                mujereshipertensos15a19.setHba1c3(mujereshipertensos15a19.getHba1c3() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setHba1c3(hipertensos20a64.getHba1c3() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setHba1c3(hombreshipertensos20a64.getHba1c3() + 1);
                            } else {
                                mujereshipertensos20a64.setHba1c3(mujereshipertensos20a64.getHba1c3() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setHba1c3(hipertensos65ymas.getHba1c4() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setHba1c3(hombreshipertensos65ymas.getHba1c3() + 1);
                            } else {
                                mujereshipertensos65ymas.setHba1c3(mujereshipertensos65ymas.getHba1c3() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setHba1c3(dislipidemicos15a19.getHba1c3() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setHba1c3(hombresdislipidemicos15a19.getHba1c3() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setHba1c3(mujeresdislipidemicos15a19.getHba1c3() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setHba1c3(dislipidemicos20a64.getHba1c3() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setHba1c3(hombresdislipidemicos20a64.getHba1c3() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setHba1c3(mujeresdislipidemicos20a64.getHba1c3() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setHba1c3(dislipidemicos65ymas.getHba1c3() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setHba1c3(hombresdislipidemicos65ymas.getHba1c3() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setHba1c3(mujeresdislipidemicos65ymas.getHba1c3() + 1);
                            }

                        }

                    }

                }//FIN hba1c 3 en el año

                if (resultados[5]) {//hba1c 2 en el año

                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setHba1c2(diabeticos15a19.getHba1c2() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setHba1c2(hombresdiabeticos15a19.getHba1c2() + 1);
                            } else {
                                mujeresdiabeticos15a19.setHba1c2(mujeresdiabeticos15a19.getHba1c2() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setHba1c2(diabeticos20a64.getHba1c2() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setHba1c2(hombresdiabeticos20a64.getHba1c2() + 1);
                            } else {
                                mujeresdiabeticos20a64.setHba1c2(mujeresdiabeticos20a64.getHba1c2() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setHba1c2(diabeticos65ymas.getHba1c2() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setHba1c2(hombresdiabeticos65ymas.getHba1c2() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setHba1c2(mujeresdiabeticos65ymas.getHba1c2() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setHba1c2(hipertensos15a19.getHba1c2() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setHba1c2(hombreshipertensos15a19.getHba1c2() + 1);
                            } else {
                                mujereshipertensos15a19.setHba1c2(mujereshipertensos15a19.getHba1c2() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setHba1c2(hipertensos20a64.getHba1c2() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setHba1c2(hombreshipertensos20a64.getHba1c2() + 1);
                            } else {
                                mujereshipertensos20a64.setHba1c2(mujereshipertensos20a64.getHba1c2() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setHba1c2(hipertensos65ymas.getHba1c2() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setHba1c2(hombreshipertensos65ymas.getHba1c2() + 1);
                            } else {
                                mujereshipertensos65ymas.setHba1c2(mujereshipertensos65ymas.getHba1c2() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setHba1c2(dislipidemicos15a19.getHba1c2() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setHba1c2(hombresdislipidemicos15a19.getHba1c2() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setHba1c2(mujeresdislipidemicos15a19.getHba1c2() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setHba1c2(dislipidemicos20a64.getHba1c2() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setHba1c2(hombresdislipidemicos20a64.getHba1c2() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setHba1c2(mujeresdislipidemicos20a64.getHba1c2() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setHba1c2(dislipidemicos65ymas.getHba1c2() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setHba1c2(hombresdislipidemicos65ymas.getHba1c2() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setHba1c2(mujeresdislipidemicos65ymas.getHba1c2() + 1);
                            }

                        }

                    }

                }//FIN hba1c 2 en el año

                if (resultados[6]) {//hba1c en 1 año
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setHba1c1(diabeticos15a19.getHba1c1() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setHba1c1(hombresdiabeticos15a19.getHba1c1() + 1);
                            } else {
                                mujeresdiabeticos15a19.setHba1c1(mujeresdiabeticos15a19.getHba1c1() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setHba1c1(diabeticos20a64.getHba1c1() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setHba1c1(hombresdiabeticos20a64.getHba1c1() + 1);
                            } else {
                                mujeresdiabeticos20a64.setHba1c1(mujeresdiabeticos20a64.getHba1c1() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setHba1c1(diabeticos65ymas.getHba1c1() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setHba1c1(hombresdiabeticos65ymas.getHba1c1() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setHba1c1(mujeresdiabeticos65ymas.getHba1c1() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setHba1c1(hipertensos15a19.getHba1c1() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setHba1c1(hombreshipertensos15a19.getHba1c1() + 1);
                            } else {
                                mujereshipertensos15a19.setHba1c1(mujereshipertensos15a19.getHba1c1() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setHba1c1(hipertensos20a64.getHba1c1() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setHba1c1(hombreshipertensos20a64.getHba1c1() + 1);
                            } else {
                                mujereshipertensos20a64.setHba1c1(mujereshipertensos20a64.getHba1c1() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setHba1c1(hipertensos65ymas.getHba1c1() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setHba1c1(hombreshipertensos65ymas.getHba1c1() + 1);
                            } else {
                                mujereshipertensos65ymas.setHba1c1(mujereshipertensos65ymas.getHba1c1() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setHba1c1(dislipidemicos15a19.getHba1c1() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setHba1c1(hombresdislipidemicos15a19.getHba1c1() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setHba1c1(mujeresdislipidemicos15a19.getHba1c1() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setHba1c1(dislipidemicos20a64.getHba1c1() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setHba1c1(hombresdislipidemicos20a64.getHba1c1() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setHba1c1(mujeresdislipidemicos20a64.getHba1c1() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setHba1c1(dislipidemicos65ymas.getHba1c1() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setHba1c1(hombresdislipidemicos65ymas.getHba1c1() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setHba1c1(mujeresdislipidemicos65ymas.getHba1c1() + 1);
                            }

                        }

                    }

                }//FIN hba1c en 1 año

                if (resultados[7]) {//Atencion Creatinina

                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setCreatinina(diabeticos15a19.getCreatinina() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setCreatinina(hombresdiabeticos15a19.getCreatinina() + 1);
                            } else {
                                mujeresdiabeticos15a19.setCreatinina(mujeresdiabeticos15a19.getCreatinina() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setCreatinina(diabeticos20a64.getCreatinina() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setCreatinina(hombresdiabeticos20a64.getCreatinina() + 1);
                            } else {
                                mujeresdiabeticos20a64.setCreatinina(mujeresdiabeticos20a64.getCreatinina() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setCreatinina(diabeticos65ymas.getCreatinina() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setCreatinina(hombresdiabeticos65ymas.getCreatinina() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setCreatinina(mujeresdiabeticos65ymas.getCreatinina() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setCreatinina(hipertensos15a19.getCreatinina() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setCreatinina(hombreshipertensos15a19.getCreatinina() + 1);
                            } else {
                                mujereshipertensos15a19.setCreatinina(mujereshipertensos15a19.getCreatinina() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setCreatinina(hipertensos20a64.getCreatinina() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setCreatinina(hombreshipertensos20a64.getCreatinina() + 1);
                            } else {
                                mujereshipertensos20a64.setCreatinina(mujereshipertensos20a64.getCreatinina() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setCreatinina(hipertensos65ymas.getCreatinina() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setCreatinina(hombreshipertensos65ymas.getCreatinina() + 1);
                            } else {
                                mujereshipertensos65ymas.setCreatinina(mujereshipertensos65ymas.getCreatinina() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setCreatinina(dislipidemicos15a19.getCreatinina() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setCreatinina(hombresdislipidemicos15a19.getCreatinina() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setCreatinina(mujeresdislipidemicos15a19.getCreatinina() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setCreatinina(dislipidemicos20a64.getCreatinina() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setCreatinina(hombresdislipidemicos20a64.getCreatinina() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setCreatinina(mujeresdislipidemicos20a64.getCreatinina() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setCreatinina(dislipidemicos65ymas.getCreatinina() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setCreatinina(hombresdislipidemicos65ymas.getCreatinina() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setCreatinina(mujeresdislipidemicos65ymas.getCreatinina() + 1);
                            }

                        }

                    }

                }//FIN Creatinina

                if (resultados[8]) {//Atencion Microalbuminuria

                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setMicroalbuminuria(diabeticos15a19.getMicroalbuminuria() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setMicroalbuminuria(hombresdiabeticos15a19.getMicroalbuminuria() + 1);
                            } else {
                                mujeresdiabeticos15a19.setMicroalbuminuria(mujeresdiabeticos15a19.getMicroalbuminuria() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setMicroalbuminuria(diabeticos20a64.getMicroalbuminuria() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setMicroalbuminuria(hombresdiabeticos20a64.getMicroalbuminuria() + 1);
                            } else {
                                mujeresdiabeticos20a64.setMicroalbuminuria(mujeresdiabeticos20a64.getMicroalbuminuria() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setMicroalbuminuria(diabeticos65ymas.getMicroalbuminuria() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setMicroalbuminuria(hombresdiabeticos65ymas.getMicroalbuminuria() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setMicroalbuminuria(mujeresdiabeticos65ymas.getMicroalbuminuria() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setMicroalbuminuria(hipertensos15a19.getMicroalbuminuria() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setMicroalbuminuria(hombreshipertensos15a19.getMicroalbuminuria() + 1);
                            } else {
                                mujereshipertensos15a19.setMicroalbuminuria(mujereshipertensos15a19.getMicroalbuminuria() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setMicroalbuminuria(hipertensos20a64.getMicroalbuminuria() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setMicroalbuminuria(hombreshipertensos20a64.getMicroalbuminuria() + 1);
                            } else {
                                mujereshipertensos20a64.setMicroalbuminuria(mujereshipertensos20a64.getMicroalbuminuria() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setMicroalbuminuria(hipertensos65ymas.getMicroalbuminuria() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setMicroalbuminuria(hombreshipertensos65ymas.getMicroalbuminuria() + 1);
                            } else {
                                mujereshipertensos65ymas.setMicroalbuminuria(mujereshipertensos65ymas.getMicroalbuminuria() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setMicroalbuminuria(dislipidemicos15a19.getMicroalbuminuria() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setMicroalbuminuria(hombresdislipidemicos15a19.getMicroalbuminuria() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setMicroalbuminuria(mujeresdislipidemicos15a19.getMicroalbuminuria() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setMicroalbuminuria(dislipidemicos20a64.getMicroalbuminuria() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setMicroalbuminuria(hombresdislipidemicos20a64.getMicroalbuminuria() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setMicroalbuminuria(mujeresdislipidemicos20a64.getMicroalbuminuria() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setMicroalbuminuria(dislipidemicos65ymas.getMicroalbuminuria() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setMicroalbuminuria(hombresdislipidemicos65ymas.getMicroalbuminuria() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setMicroalbuminuria(mujeresdislipidemicos65ymas.getMicroalbuminuria() + 1);
                            }

                        }

                    }

                }//FIN Microalbuminuria

                if (resultados[9]) {//Atencion Potasio

                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setPotasioPlasmatico(diabeticos15a19.getPotasioPlasmatico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setPotasioPlasmatico(hombresdiabeticos15a19.getPotasioPlasmatico() + 1);
                            } else {
                                mujeresdiabeticos15a19.setPotasioPlasmatico(mujeresdiabeticos15a19.getPotasioPlasmatico() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setPotasioPlasmatico(diabeticos20a64.getPotasioPlasmatico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setPotasioPlasmatico(hombresdiabeticos20a64.getPotasioPlasmatico() + 1);
                            } else {
                                mujeresdiabeticos20a64.setPotasioPlasmatico(mujeresdiabeticos20a64.getPotasioPlasmatico() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setPotasioPlasmatico(diabeticos65ymas.getPotasioPlasmatico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setPotasioPlasmatico(hombresdiabeticos65ymas.getPotasioPlasmatico() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setPotasioPlasmatico(mujeresdiabeticos65ymas.getPotasioPlasmatico() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setPotasioPlasmatico(hipertensos15a19.getPotasioPlasmatico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setPotasioPlasmatico(hombreshipertensos15a19.getPotasioPlasmatico() + 1);
                            } else {
                                mujereshipertensos15a19.setPotasioPlasmatico(mujereshipertensos15a19.getPotasioPlasmatico() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setPotasioPlasmatico(hipertensos20a64.getPotasioPlasmatico() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setPotasioPlasmatico(hombreshipertensos20a64.getPotasioPlasmatico() + 1);
                            } else {
                                mujereshipertensos20a64.setPotasioPlasmatico(mujereshipertensos20a64.getPotasioPlasmatico() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setPotasioPlasmatico(hipertensos65ymas.getPotasioPlasmatico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setPotasioPlasmatico(hombreshipertensos65ymas.getPotasioPlasmatico() + 1);
                            } else {
                                mujereshipertensos65ymas.setPotasioPlasmatico(mujereshipertensos65ymas.getPotasioPlasmatico() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setPotasioPlasmatico(dislipidemicos15a19.getPotasioPlasmatico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setPotasioPlasmatico(hombresdislipidemicos15a19.getPotasioPlasmatico() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setPotasioPlasmatico(mujeresdislipidemicos15a19.getPotasioPlasmatico() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setPotasioPlasmatico(dislipidemicos20a64.getPotasioPlasmatico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setPotasioPlasmatico(hombresdislipidemicos20a64.getPotasioPlasmatico() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setPotasioPlasmatico(mujeresdislipidemicos20a64.getPotasioPlasmatico() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setPotasioPlasmatico(dislipidemicos65ymas.getPotasioPlasmatico() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setPotasioPlasmatico(hombresdislipidemicos65ymas.getPotasioPlasmatico() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setPotasioPlasmatico(mujeresdislipidemicos65ymas.getPotasioPlasmatico() + 1);
                            }

                        }

                    }

                }//FIN Potasio

                if (resultados[10]) {//Atencion ECG

                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setEcg(diabeticos15a19.getEcg() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setEcg(hombresdiabeticos15a19.getEcg() + 1);
                            } else {
                                mujeresdiabeticos15a19.setEcg(mujeresdiabeticos15a19.getEcg() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setEcg(diabeticos20a64.getEcg() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setEcg(hombresdiabeticos20a64.getEcg() + 1);
                            } else {
                                mujeresdiabeticos20a64.setEcg(mujeresdiabeticos20a64.getEcg() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setEcg(diabeticos65ymas.getEcg() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setEcg(hombresdiabeticos65ymas.getEcg() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setEcg(mujeresdiabeticos65ymas.getEcg() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setEcg(hipertensos15a19.getEcg() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setEcg(hombreshipertensos15a19.getEcg() + 1);
                            } else {
                                mujereshipertensos15a19.setEcg(mujereshipertensos15a19.getEcg() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setEcg(hipertensos20a64.getEcg() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setEcg(hombreshipertensos20a64.getEcg() + 1);
                            } else {
                                mujereshipertensos20a64.setEcg(mujereshipertensos20a64.getEcg() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setEcg(hipertensos65ymas.getEcg() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setEcg(hombreshipertensos65ymas.getEcg() + 1);
                            } else {
                                mujereshipertensos65ymas.setEcg(mujereshipertensos65ymas.getEcg() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setEcg(dislipidemicos15a19.getEcg() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setEcg(hombresdislipidemicos15a19.getEcg() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setEcg(mujeresdislipidemicos15a19.getEcg() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setEcg(dislipidemicos20a64.getEcg() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setEcg(hombresdislipidemicos20a64.getEcg() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setEcg(mujeresdislipidemicos20a64.getEcg() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setEcg(dislipidemicos65ymas.getEcg() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setEcg(hombresdislipidemicos65ymas.getEcg() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setEcg(mujeresdislipidemicos65ymas.getEcg() + 1);
                            }

                        }

                    }

                }//FIN ECG

                if (resultados[11]) {
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setComplicacion(diabeticos15a19.getComplicacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setComplicacion(hombresdiabeticos15a19.getComplicacion() + 1);
                            } else {
                                mujeresdiabeticos15a19.setComplicacion(mujeresdiabeticos15a19.getComplicacion() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setComplicacion(diabeticos20a64.getComplicacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setComplicacion(hombresdiabeticos20a64.getComplicacion() + 1);
                            } else {
                                mujeresdiabeticos20a64.setComplicacion(mujeresdiabeticos20a64.getComplicacion() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setComplicacion(diabeticos65ymas.getComplicacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setComplicacion(hombresdiabeticos65ymas.getComplicacion() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setComplicacion(mujeresdiabeticos65ymas.getComplicacion() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setComplicacion(hipertensos15a19.getComplicacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setComplicacion(hombreshipertensos15a19.getComplicacion() + 1);
                            } else {
                                mujereshipertensos15a19.setComplicacion(mujereshipertensos15a19.getComplicacion() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setComplicacion(hipertensos20a64.getComplicacion() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setComplicacion(hombreshipertensos20a64.getComplicacion() + 1);
                            } else {
                                mujereshipertensos20a64.setComplicacion(mujereshipertensos20a64.getComplicacion() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setComplicacion(hipertensos65ymas.getComplicacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setComplicacion(hombreshipertensos65ymas.getComplicacion() + 1);
                            } else {
                                mujereshipertensos65ymas.setComplicacion(mujereshipertensos65ymas.getComplicacion() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setComplicacion(dislipidemicos15a19.getComplicacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setComplicacion(hombresdislipidemicos15a19.getComplicacion() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setComplicacion(mujeresdislipidemicos15a19.getComplicacion() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setComplicacion(dislipidemicos20a64.getComplicacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setComplicacion(hombresdislipidemicos20a64.getComplicacion() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setComplicacion(mujeresdislipidemicos20a64.getComplicacion() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setComplicacion(dislipidemicos65ymas.getComplicacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setComplicacion(hombresdislipidemicos65ymas.getComplicacion() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setComplicacion(mujeresdislipidemicos65ymas.getComplicacion() + 1);
                            }

                        }

                    }

                } //Complicacion

                if (resultados[12]) {//Atencion Retinopatia
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setRetinopatiaDiabetica(diabeticos15a19.getRetinopatiaDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setRetinopatiaDiabetica(hombresdiabeticos15a19.getRetinopatiaDiabetica() + 1);
                            } else {
                                mujeresdiabeticos15a19.setRetinopatiaDiabetica(mujeresdiabeticos15a19.getRetinopatiaDiabetica() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setRetinopatiaDiabetica(diabeticos20a64.getRetinopatiaDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setRetinopatiaDiabetica(hombresdiabeticos20a64.getRetinopatiaDiabetica() + 1);
                            } else {
                                mujeresdiabeticos20a64.setRetinopatiaDiabetica(mujeresdiabeticos20a64.getRetinopatiaDiabetica() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setRetinopatiaDiabetica(diabeticos65ymas.getRetinopatiaDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setRetinopatiaDiabetica(hombresdiabeticos65ymas.getRetinopatiaDiabetica() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setRetinopatiaDiabetica(mujeresdiabeticos65ymas.getRetinopatiaDiabetica() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setRetinopatiaDiabetica(hipertensos15a19.getRetinopatiaDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setRetinopatiaDiabetica(hombreshipertensos15a19.getRetinopatiaDiabetica() + 1);
                            } else {
                                mujereshipertensos15a19.setRetinopatiaDiabetica(mujereshipertensos15a19.getRetinopatiaDiabetica() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setRetinopatiaDiabetica(hipertensos20a64.getRetinopatiaDiabetica() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setRetinopatiaDiabetica(hombreshipertensos20a64.getRetinopatiaDiabetica() + 1);
                            } else {
                                mujereshipertensos20a64.setRetinopatiaDiabetica(mujereshipertensos20a64.getRetinopatiaDiabetica() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setRetinopatiaDiabetica(hipertensos65ymas.getRetinopatiaDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setRetinopatiaDiabetica(hombreshipertensos65ymas.getRetinopatiaDiabetica() + 1);
                            } else {
                                mujereshipertensos65ymas.setRetinopatiaDiabetica(mujereshipertensos65ymas.getRetinopatiaDiabetica() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setRetinopatiaDiabetica(dislipidemicos15a19.getRetinopatiaDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setRetinopatiaDiabetica(hombresdislipidemicos15a19.getRetinopatiaDiabetica() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setRetinopatiaDiabetica(mujeresdislipidemicos15a19.getRetinopatiaDiabetica() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setRetinopatiaDiabetica(dislipidemicos20a64.getRetinopatiaDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setRetinopatiaDiabetica(hombresdislipidemicos20a64.getRetinopatiaDiabetica() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setRetinopatiaDiabetica(mujeresdislipidemicos20a64.getRetinopatiaDiabetica() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setRetinopatiaDiabetica(dislipidemicos65ymas.getRetinopatiaDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setRetinopatiaDiabetica(hombresdislipidemicos65ymas.getRetinopatiaDiabetica() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setRetinopatiaDiabetica(mujeresdislipidemicos65ymas.getRetinopatiaDiabetica() + 1);
                            }

                        }

                    }

                }//FIN Retinopatia

                if (resultados[13]) {//Iam

                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setInfarto(diabeticos15a19.getInfarto() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setInfarto(hombresdiabeticos15a19.getInfarto() + 1);
                            } else {
                                mujeresdiabeticos15a19.setInfarto(mujeresdiabeticos15a19.getInfarto() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setInfarto(diabeticos20a64.getInfarto() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setInfarto(hombresdiabeticos20a64.getInfarto() + 1);
                            } else {
                                mujeresdiabeticos20a64.setInfarto(mujeresdiabeticos20a64.getInfarto() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setInfarto(diabeticos65ymas.getInfarto() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setInfarto(hombresdiabeticos65ymas.getInfarto() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setInfarto(mujeresdiabeticos65ymas.getInfarto() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setInfarto(hipertensos15a19.getInfarto() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setInfarto(hombreshipertensos15a19.getInfarto() + 1);
                            } else {
                                mujereshipertensos15a19.setInfarto(mujereshipertensos15a19.getInfarto() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setInfarto(hipertensos20a64.getInfarto() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setInfarto(hombreshipertensos20a64.getInfarto() + 1);
                            } else {
                                mujereshipertensos20a64.setInfarto(mujereshipertensos20a64.getInfarto() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setInfarto(hipertensos65ymas.getInfarto() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setInfarto(hombreshipertensos65ymas.getInfarto() + 1);
                            } else {
                                mujereshipertensos65ymas.setInfarto(mujereshipertensos65ymas.getInfarto() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setInfarto(dislipidemicos15a19.getInfarto() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setInfarto(hombresdislipidemicos15a19.getInfarto() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setInfarto(mujeresdislipidemicos15a19.getInfarto() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setInfarto(dislipidemicos20a64.getInfarto() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setInfarto(hombresdislipidemicos20a64.getInfarto() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setInfarto(mujeresdislipidemicos20a64.getInfarto() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setInfarto(dislipidemicos65ymas.getInfarto() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setInfarto(hombresdislipidemicos65ymas.getInfarto() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setInfarto(mujeresdislipidemicos65ymas.getInfarto() + 1);
                            }

                        }

                    }

                }//FIN iam

                if (resultados[14]) {//ave
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setAccidenteVascular(diabeticos15a19.getAccidenteVascular() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setAccidenteVascular(hombresdiabeticos15a19.getAccidenteVascular() + 1);
                            } else {
                                mujeresdiabeticos15a19.setAccidenteVascular(mujeresdiabeticos15a19.getAccidenteVascular() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setAccidenteVascular(diabeticos20a64.getAccidenteVascular() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setAccidenteVascular(hombresdiabeticos20a64.getAccidenteVascular() + 1);
                            } else {
                                mujeresdiabeticos20a64.setAccidenteVascular(mujeresdiabeticos20a64.getAccidenteVascular() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setAccidenteVascular(diabeticos65ymas.getAccidenteVascular() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setAccidenteVascular(hombresdiabeticos65ymas.getAccidenteVascular() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setAccidenteVascular(mujeresdiabeticos65ymas.getAccidenteVascular() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setAccidenteVascular(hipertensos15a19.getAccidenteVascular() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setAccidenteVascular(hombreshipertensos15a19.getAccidenteVascular() + 1);
                            } else {
                                mujereshipertensos15a19.setAccidenteVascular(mujereshipertensos15a19.getAccidenteVascular() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setAccidenteVascular(hipertensos20a64.getAccidenteVascular() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setAccidenteVascular(hombreshipertensos20a64.getAccidenteVascular() + 1);
                            } else {
                                mujereshipertensos20a64.setAccidenteVascular(mujereshipertensos20a64.getAccidenteVascular() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setAccidenteVascular(hipertensos65ymas.getAccidenteVascular() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setAccidenteVascular(hombreshipertensos65ymas.getAccidenteVascular() + 1);
                            } else {
                                mujereshipertensos65ymas.setAccidenteVascular(mujereshipertensos65ymas.getAccidenteVascular() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setAccidenteVascular(dislipidemicos15a19.getAccidenteVascular() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setAccidenteVascular(hombresdislipidemicos15a19.getAccidenteVascular() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setAccidenteVascular(mujeresdislipidemicos15a19.getAccidenteVascular() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setAccidenteVascular(dislipidemicos20a64.getAccidenteVascular() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setAccidenteVascular(hombresdislipidemicos20a64.getAccidenteVascular() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setAccidenteVascular(mujeresdislipidemicos20a64.getAccidenteVascular() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setAccidenteVascular(dislipidemicos65ymas.getAccidenteVascular() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setAccidenteVascular(hombresdislipidemicos65ymas.getAccidenteVascular() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setAccidenteVascular(mujeresdislipidemicos65ymas.getAccidenteVascular() + 1);
                            }

                        }

                    }

                }//fin ave

                if (resultados[15]) {//Ceguera Post  

                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setCegueraPost(diabeticos15a19.getCegueraPost() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setCegueraPost(hombresdiabeticos15a19.getCegueraPost() + 1);
                            } else {
                                mujeresdiabeticos15a19.setCegueraPost(mujeresdiabeticos15a19.getCegueraPost() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setCegueraPost(diabeticos20a64.getCegueraPost() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setCegueraPost(hombresdiabeticos20a64.getCegueraPost() + 1);
                            } else {
                                mujeresdiabeticos20a64.setCegueraPost(mujeresdiabeticos20a64.getCegueraPost() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setCegueraPost(diabeticos65ymas.getCegueraPost() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setCegueraPost(hombresdiabeticos65ymas.getCegueraPost() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setCegueraPost(mujeresdiabeticos65ymas.getCegueraPost() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setCegueraPost(hipertensos15a19.getCegueraPost() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setCegueraPost(hombreshipertensos15a19.getCegueraPost() + 1);
                            } else {
                                mujereshipertensos15a19.setCegueraPost(mujereshipertensos15a19.getCegueraPost() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setCegueraPost(hipertensos20a64.getCegueraPost() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setCegueraPost(hombreshipertensos20a64.getCegueraPost() + 1);
                            } else {
                                mujereshipertensos20a64.setCegueraPost(mujereshipertensos20a64.getCegueraPost() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setCegueraPost(hipertensos65ymas.getCegueraPost() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setCegueraPost(hombreshipertensos65ymas.getCegueraPost() + 1);
                            } else {
                                mujereshipertensos65ymas.setCegueraPost(mujereshipertensos65ymas.getCegueraPost() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setCegueraPost(dislipidemicos15a19.getCegueraPost() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setCegueraPost(hombresdislipidemicos15a19.getCegueraPost() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setCegueraPost(mujeresdislipidemicos15a19.getCegueraPost() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setCegueraPost(dislipidemicos20a64.getCegueraPost() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setCegueraPost(hombresdislipidemicos20a64.getCegueraPost() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setCegueraPost(mujeresdislipidemicos20a64.getCegueraPost() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setCegueraPost(dislipidemicos65ymas.getCegueraPost() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setCegueraPost(hombresdislipidemicos65ymas.getCegueraPost() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setCegueraPost(mujeresdislipidemicos65ymas.getCegueraPost() + 1);
                            }

                        }

                    }

                }//FIN Ceguera Post          

                if (resultados[16]) {//Ceguera Hipertrofia  

                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setHipertrofia(diabeticos15a19.getHipertrofia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setHipertrofia(hombresdiabeticos15a19.getHipertrofia() + 1);
                            } else {
                                mujeresdiabeticos15a19.setHipertrofia(mujeresdiabeticos15a19.getHipertrofia() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setHipertrofia(diabeticos20a64.getHipertrofia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setHipertrofia(hombresdiabeticos20a64.getHipertrofia() + 1);
                            } else {
                                mujeresdiabeticos20a64.setHipertrofia(mujeresdiabeticos20a64.getHipertrofia() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setHipertrofia(diabeticos65ymas.getHipertrofia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setHipertrofia(hombresdiabeticos65ymas.getHipertrofia() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setHipertrofia(mujeresdiabeticos65ymas.getHipertrofia() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setHipertrofia(hipertensos15a19.getHipertrofia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setHipertrofia(hombreshipertensos15a19.getHipertrofia() + 1);
                            } else {
                                mujereshipertensos15a19.setHipertrofia(mujereshipertensos15a19.getHipertrofia() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setHipertrofia(hipertensos20a64.getHipertrofia() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setHipertrofia(hombreshipertensos20a64.getHipertrofia() + 1);
                            } else {
                                mujereshipertensos20a64.setHipertrofia(mujereshipertensos20a64.getHipertrofia() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setHipertrofia(hipertensos65ymas.getHipertrofia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setHipertrofia(hombreshipertensos65ymas.getHipertrofia() + 1);
                            } else {
                                mujereshipertensos65ymas.setHipertrofia(mujereshipertensos65ymas.getHipertrofia() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setHipertrofia(dislipidemicos15a19.getHipertrofia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setHipertrofia(hombresdislipidemicos15a19.getHipertrofia() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setHipertrofia(mujeresdislipidemicos15a19.getHipertrofia() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setHipertrofia(dislipidemicos20a64.getHipertrofia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setHipertrofia(hombresdislipidemicos20a64.getHipertrofia() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setHipertrofia(mujeresdislipidemicos20a64.getHipertrofia() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setHipertrofia(dislipidemicos65ymas.getHipertrofia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setHipertrofia(hombresdislipidemicos65ymas.getHipertrofia() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setHipertrofia(mujeresdislipidemicos65ymas.getHipertrofia() + 1);
                            }

                        }

                    }

                }//FIN Hipertrofia          

                if (resultados[17]) {//Ceguera Nefropatia  
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setNefropatia(diabeticos15a19.getNefropatia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setNefropatia(hombresdiabeticos15a19.getNefropatia() + 1);
                            } else {
                                mujeresdiabeticos15a19.setNefropatia(mujeresdiabeticos15a19.getNefropatia() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setNefropatia(diabeticos20a64.getNefropatia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setNefropatia(hombresdiabeticos20a64.getNefropatia() + 1);
                            } else {
                                mujeresdiabeticos20a64.setNefropatia(mujeresdiabeticos20a64.getNefropatia() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setNefropatia(diabeticos65ymas.getNefropatia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setNefropatia(hombresdiabeticos65ymas.getNefropatia() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setNefropatia(mujeresdiabeticos65ymas.getNefropatia() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setNefropatia(hipertensos15a19.getNefropatia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setNefropatia(hombreshipertensos15a19.getNefropatia() + 1);
                            } else {
                                mujereshipertensos15a19.setNefropatia(mujereshipertensos15a19.getNefropatia() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setNefropatia(hipertensos20a64.getNefropatia() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setNefropatia(hombreshipertensos20a64.getNefropatia() + 1);
                            } else {
                                mujereshipertensos20a64.setNefropatia(mujereshipertensos20a64.getNefropatia() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setNefropatia(hipertensos65ymas.getNefropatia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setNefropatia(hombreshipertensos65ymas.getNefropatia() + 1);
                            } else {
                                mujereshipertensos65ymas.setNefropatia(mujereshipertensos65ymas.getNefropatia() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setNefropatia(dislipidemicos15a19.getNefropatia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setNefropatia(hombresdislipidemicos15a19.getNefropatia() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setNefropatia(mujeresdislipidemicos15a19.getNefropatia() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setNefropatia(dislipidemicos20a64.getNefropatia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setNefropatia(hombresdislipidemicos20a64.getNefropatia() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setNefropatia(mujeresdislipidemicos20a64.getNefropatia() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setNefropatia(dislipidemicos65ymas.getNefropatia() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setNefropatia(hombresdislipidemicos65ymas.getNefropatia() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setNefropatia(mujeresdislipidemicos65ymas.getNefropatia() + 1);
                            }

                        }

                    }

                }//FIN Nefropatia      

                if (resultados[18]) {//Insuficiencia renal cronica   
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setInsuficienciaRenal(diabeticos15a19.getInsuficienciaRenal() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setInsuficienciaRenal(hombresdiabeticos15a19.getInsuficienciaRenal() + 1);
                            } else {
                                mujeresdiabeticos15a19.setInsuficienciaRenal(mujeresdiabeticos15a19.getInsuficienciaRenal() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setInsuficienciaRenal(diabeticos20a64.getInsuficienciaRenal() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setInsuficienciaRenal(hombresdiabeticos20a64.getInsuficienciaRenal() + 1);
                            } else {
                                mujeresdiabeticos20a64.setInsuficienciaRenal(mujeresdiabeticos20a64.getInsuficienciaRenal() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setInsuficienciaRenal(diabeticos65ymas.getInsuficienciaRenal() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setInsuficienciaRenal(hombresdiabeticos65ymas.getInsuficienciaRenal() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setInsuficienciaRenal(mujeresdiabeticos65ymas.getInsuficienciaRenal() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setInsuficienciaRenal(hipertensos15a19.getInsuficienciaRenal() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setInsuficienciaRenal(hombreshipertensos15a19.getInsuficienciaRenal() + 1);
                            } else {
                                mujereshipertensos15a19.setInsuficienciaRenal(mujereshipertensos15a19.getInsuficienciaRenal() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setInsuficienciaRenal(hipertensos20a64.getInsuficienciaRenal() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setInsuficienciaRenal(hombreshipertensos20a64.getInsuficienciaRenal() + 1);
                            } else {
                                mujereshipertensos20a64.setInsuficienciaRenal(mujereshipertensos20a64.getInsuficienciaRenal() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setInsuficienciaRenal(hipertensos65ymas.getInsuficienciaRenal() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setInsuficienciaRenal(hombreshipertensos65ymas.getInsuficienciaRenal() + 1);
                            } else {
                                mujereshipertensos65ymas.setInsuficienciaRenal(mujereshipertensos65ymas.getInsuficienciaRenal() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setInsuficienciaRenal(dislipidemicos15a19.getInsuficienciaRenal() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setInsuficienciaRenal(hombresdislipidemicos15a19.getInsuficienciaRenal() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setInsuficienciaRenal(mujeresdislipidemicos15a19.getInsuficienciaRenal() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setInsuficienciaRenal(dislipidemicos20a64.getInsuficienciaRenal() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setInsuficienciaRenal(hombresdislipidemicos20a64.getInsuficienciaRenal() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setInsuficienciaRenal(mujeresdislipidemicos20a64.getInsuficienciaRenal() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setInsuficienciaRenal(dislipidemicos65ymas.getInsuficienciaRenal() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setInsuficienciaRenal(hombresdislipidemicos65ymas.getInsuficienciaRenal() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setInsuficienciaRenal(mujeresdislipidemicos65ymas.getInsuficienciaRenal() + 1);
                            }

                        }

                    }

                }//FIN Insuficiencia renal cronica  

                if (resultados[19]) {//PIE con evaluacion 
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setPieDiabeticoEvaluacion(diabeticos15a19.getPieDiabeticoEvaluacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setPieDiabeticoEvaluacion(hombresdiabeticos15a19.getPieDiabeticoEvaluacion() + 1);
                            } else {
                                mujeresdiabeticos15a19.setPieDiabeticoEvaluacion(mujeresdiabeticos15a19.getPieDiabeticoEvaluacion() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setPieDiabeticoEvaluacion(diabeticos20a64.getPieDiabeticoEvaluacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setPieDiabeticoEvaluacion(hombresdiabeticos20a64.getPieDiabeticoEvaluacion() + 1);
                            } else {
                                mujeresdiabeticos20a64.setPieDiabeticoEvaluacion(mujeresdiabeticos20a64.getPieDiabeticoEvaluacion() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setPieDiabeticoEvaluacion(diabeticos65ymas.getPieDiabeticoEvaluacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setPieDiabeticoEvaluacion(hombresdiabeticos65ymas.getPieDiabeticoEvaluacion() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setPieDiabeticoEvaluacion(mujeresdiabeticos65ymas.getPieDiabeticoEvaluacion() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setPieDiabeticoEvaluacion(hipertensos15a19.getPieDiabeticoEvaluacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setPieDiabeticoEvaluacion(hombreshipertensos15a19.getPieDiabeticoEvaluacion() + 1);
                            } else {
                                mujereshipertensos15a19.setPieDiabeticoEvaluacion(mujereshipertensos15a19.getPieDiabeticoEvaluacion() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setPieDiabeticoEvaluacion(hipertensos20a64.getPieDiabeticoEvaluacion() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setPieDiabeticoEvaluacion(hombreshipertensos20a64.getPieDiabeticoEvaluacion() + 1);
                            } else {
                                mujereshipertensos20a64.setPieDiabeticoEvaluacion(mujereshipertensos20a64.getPieDiabeticoEvaluacion() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setPieDiabeticoEvaluacion(hipertensos65ymas.getPieDiabeticoEvaluacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setPieDiabeticoEvaluacion(hombreshipertensos65ymas.getPieDiabeticoEvaluacion() + 1);
                            } else {
                                mujereshipertensos65ymas.setPieDiabeticoEvaluacion(mujereshipertensos65ymas.getPieDiabeticoEvaluacion() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setPieDiabeticoEvaluacion(dislipidemicos15a19.getPieDiabeticoEvaluacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setPieDiabeticoEvaluacion(hombresdislipidemicos15a19.getPieDiabeticoEvaluacion() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setPieDiabeticoEvaluacion(mujeresdislipidemicos15a19.getPieDiabeticoEvaluacion() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setPieDiabeticoEvaluacion(dislipidemicos20a64.getPieDiabeticoEvaluacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setPieDiabeticoEvaluacion(hombresdislipidemicos20a64.getPieDiabeticoEvaluacion() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setPieDiabeticoEvaluacion(mujeresdislipidemicos20a64.getPieDiabeticoEvaluacion() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setPieDiabeticoEvaluacion(dislipidemicos65ymas.getPieDiabeticoEvaluacion() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setPieDiabeticoEvaluacion(hombresdislipidemicos65ymas.getPieDiabeticoEvaluacion() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setPieDiabeticoEvaluacion(mujeresdislipidemicos65ymas.getPieDiabeticoEvaluacion() + 1);
                            }

                        }

                    }

                }//FIN  PIE con evaluacion 

                if (resultados[20]) {// PIE con Ulcera 
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setPieDiabeticoUlcera(diabeticos15a19.getPieDiabeticoUlcera() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setPieDiabeticoUlcera(hombresdiabeticos15a19.getPieDiabeticoUlcera() + 1);
                            } else {
                                mujeresdiabeticos15a19.setPieDiabeticoUlcera(mujeresdiabeticos15a19.getPieDiabeticoUlcera() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setPieDiabeticoUlcera(diabeticos20a64.getPieDiabeticoUlcera() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setPieDiabeticoUlcera(hombresdiabeticos20a64.getPieDiabeticoUlcera() + 1);
                            } else {
                                mujeresdiabeticos20a64.setPieDiabeticoUlcera(mujeresdiabeticos20a64.getPieDiabeticoUlcera() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setPieDiabeticoUlcera(diabeticos65ymas.getPieDiabeticoUlcera() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setPieDiabeticoUlcera(hombresdiabeticos65ymas.getPieDiabeticoUlcera() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setPieDiabeticoUlcera(mujeresdiabeticos65ymas.getPieDiabeticoUlcera() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setPieDiabeticoUlcera(hipertensos15a19.getPieDiabeticoUlcera() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setPieDiabeticoUlcera(hombreshipertensos15a19.getPieDiabeticoUlcera() + 1);
                            } else {
                                mujereshipertensos15a19.setPieDiabeticoUlcera(mujereshipertensos15a19.getPieDiabeticoUlcera() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setPieDiabeticoUlcera(hipertensos20a64.getPieDiabeticoUlcera() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setPieDiabeticoUlcera(hombreshipertensos20a64.getPieDiabeticoUlcera() + 1);
                            } else {
                                mujereshipertensos20a64.setPieDiabeticoUlcera(mujereshipertensos20a64.getPieDiabeticoUlcera() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setPieDiabeticoUlcera(hipertensos65ymas.getPieDiabeticoUlcera() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setPieDiabeticoUlcera(hombreshipertensos65ymas.getPieDiabeticoUlcera() + 1);
                            } else {
                                mujereshipertensos65ymas.setPieDiabeticoUlcera(mujereshipertensos65ymas.getPieDiabeticoUlcera() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setPieDiabeticoUlcera(dislipidemicos15a19.getPieDiabeticoUlcera() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setPieDiabeticoUlcera(hombresdislipidemicos15a19.getPieDiabeticoUlcera() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setPieDiabeticoUlcera(mujeresdislipidemicos15a19.getPieDiabeticoUlcera() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setPieDiabeticoUlcera(dislipidemicos20a64.getPieDiabeticoUlcera() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setPieDiabeticoUlcera(hombresdislipidemicos20a64.getPieDiabeticoUlcera() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setPieDiabeticoUlcera(mujeresdislipidemicos20a64.getPieDiabeticoUlcera() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setPieDiabeticoUlcera(dislipidemicos65ymas.getPieDiabeticoUlcera() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setPieDiabeticoUlcera(hombresdislipidemicos65ymas.getPieDiabeticoUlcera() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setPieDiabeticoUlcera(mujeresdislipidemicos65ymas.getPieDiabeticoUlcera() + 1);
                            }

                        }

                    }

                }//FIN  PIE con Ulcera 

                if (resultados[21]) {

                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setPieDiabeticoHerida(diabeticos15a19.getPieDiabeticoHerida() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setPieDiabeticoHerida(hombresdiabeticos15a19.getPieDiabeticoHerida() + 1);
                            } else {
                                mujeresdiabeticos15a19.setPieDiabeticoHerida(mujeresdiabeticos15a19.getPieDiabeticoHerida() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setPieDiabeticoHerida(diabeticos20a64.getPieDiabeticoHerida() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setPieDiabeticoHerida(hombresdiabeticos20a64.getPieDiabeticoHerida() + 1);
                            } else {
                                mujeresdiabeticos20a64.setPieDiabeticoHerida(mujeresdiabeticos20a64.getPieDiabeticoHerida() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setPieDiabeticoHerida(diabeticos65ymas.getPieDiabeticoHerida() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setPieDiabeticoHerida(hombresdiabeticos65ymas.getPieDiabeticoHerida() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setPieDiabeticoHerida(mujeresdiabeticos65ymas.getPieDiabeticoHerida() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setPieDiabeticoHerida(hipertensos15a19.getPieDiabeticoHerida() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setPieDiabeticoHerida(hombreshipertensos15a19.getPieDiabeticoHerida() + 1);
                            } else {
                                mujereshipertensos15a19.setPieDiabeticoHerida(mujereshipertensos15a19.getPieDiabeticoHerida() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setPieDiabeticoHerida(hipertensos20a64.getPieDiabeticoHerida() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setPieDiabeticoHerida(hombreshipertensos20a64.getPieDiabeticoHerida() + 1);
                            } else {
                                mujereshipertensos20a64.setPieDiabeticoHerida(mujereshipertensos20a64.getPieDiabeticoHerida() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setPieDiabeticoHerida(hipertensos65ymas.getPieDiabeticoHerida() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setPieDiabeticoHerida(hombreshipertensos65ymas.getPieDiabeticoHerida() + 1);
                            } else {
                                mujereshipertensos65ymas.setPieDiabeticoHerida(mujereshipertensos65ymas.getPieDiabeticoHerida() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setPieDiabeticoHerida(dislipidemicos15a19.getPieDiabeticoHerida() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setPieDiabeticoHerida(hombresdislipidemicos15a19.getPieDiabeticoHerida() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setPieDiabeticoHerida(mujeresdislipidemicos15a19.getPieDiabeticoHerida() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setPieDiabeticoHerida(dislipidemicos20a64.getPieDiabeticoHerida() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setPieDiabeticoHerida(hombresdislipidemicos20a64.getPieDiabeticoHerida() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setPieDiabeticoHerida(mujeresdislipidemicos20a64.getPieDiabeticoHerida() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setPieDiabeticoHerida(dislipidemicos65ymas.getPieDiabeticoHerida() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setPieDiabeticoHerida(hombresdislipidemicos65ymas.getPieDiabeticoHerida() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setPieDiabeticoHerida(mujeresdislipidemicos65ymas.getPieDiabeticoHerida() + 1);
                            }

                        }

                    }

                }//pie con herida

                if (resultados[22]) {//  PIE con Amputacion
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setAmputacionDiabetica(diabeticos15a19.getAmputacionDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setAmputacionDiabetica(hombresdiabeticos15a19.getAmputacionDiabetica() + 1);
                            } else {
                                mujeresdiabeticos15a19.setAmputacionDiabetica(mujeresdiabeticos15a19.getAmputacionDiabetica() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setAmputacionDiabetica(diabeticos20a64.getAmputacionDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setAmputacionDiabetica(hombresdiabeticos20a64.getAmputacionDiabetica() + 1);
                            } else {
                                mujeresdiabeticos20a64.setAmputacionDiabetica(mujeresdiabeticos20a64.getAmputacionDiabetica() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setAmputacionDiabetica(diabeticos65ymas.getAmputacionDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setAmputacionDiabetica(hombresdiabeticos65ymas.getAmputacionDiabetica() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setAmputacionDiabetica(mujeresdiabeticos65ymas.getAmputacionDiabetica() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setAmputacionDiabetica(hipertensos15a19.getAmputacionDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setAmputacionDiabetica(hombreshipertensos15a19.getAmputacionDiabetica() + 1);
                            } else {
                                mujereshipertensos15a19.setAmputacionDiabetica(mujereshipertensos15a19.getAmputacionDiabetica() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setAmputacionDiabetica(hipertensos20a64.getAmputacionDiabetica() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setAmputacionDiabetica(hombreshipertensos20a64.getAmputacionDiabetica() + 1);
                            } else {
                                mujereshipertensos20a64.setAmputacionDiabetica(mujereshipertensos20a64.getAmputacionDiabetica() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setAmputacionDiabetica(hipertensos65ymas.getAmputacionDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setAmputacionDiabetica(hombreshipertensos65ymas.getAmputacionDiabetica() + 1);
                            } else {
                                mujereshipertensos65ymas.setAmputacionDiabetica(mujereshipertensos65ymas.getAmputacionDiabetica() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setAmputacionDiabetica(dislipidemicos15a19.getAmputacionDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setAmputacionDiabetica(hombresdislipidemicos15a19.getAmputacionDiabetica() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setAmputacionDiabetica(mujeresdislipidemicos15a19.getAmputacionDiabetica() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setAmputacionDiabetica(dislipidemicos20a64.getAmputacionDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setAmputacionDiabetica(hombresdislipidemicos20a64.getAmputacionDiabetica() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setAmputacionDiabetica(mujeresdislipidemicos20a64.getAmputacionDiabetica() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setAmputacionDiabetica(dislipidemicos65ymas.getAmputacionDiabetica() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setAmputacionDiabetica(hombresdislipidemicos65ymas.getAmputacionDiabetica() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setAmputacionDiabetica(mujeresdislipidemicos65ymas.getAmputacionDiabetica() + 1);
                            }

                        }

                    }

                }//FIN  Amputacion

                if (resultados[23]) {//  PIE con prediabetico
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setPreDiabeticos(diabeticos15a19.getPreDiabeticos() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setPreDiabeticos(hombresdiabeticos15a19.getPreDiabeticos() + 1);
                            } else {
                                mujeresdiabeticos15a19.setPreDiabeticos(mujeresdiabeticos15a19.getPreDiabeticos() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setPreDiabeticos(diabeticos20a64.getPreDiabeticos() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setPreDiabeticos(hombresdiabeticos20a64.getPreDiabeticos() + 1);
                            } else {
                                mujeresdiabeticos20a64.setPreDiabeticos(mujeresdiabeticos20a64.getPreDiabeticos() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setPreDiabeticos(diabeticos65ymas.getPreDiabeticos() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setPreDiabeticos(hombresdiabeticos65ymas.getPreDiabeticos() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setPreDiabeticos(mujeresdiabeticos65ymas.getPreDiabeticos() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setPreDiabeticos(hipertensos15a19.getPreDiabeticos() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setPreDiabeticos(hombreshipertensos15a19.getPreDiabeticos() + 1);
                            } else {
                                mujereshipertensos15a19.setPreDiabeticos(mujereshipertensos15a19.getPreDiabeticos() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setPreDiabeticos(hipertensos20a64.getPreDiabeticos() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setPreDiabeticos(hombreshipertensos20a64.getPreDiabeticos() + 1);
                            } else {
                                mujereshipertensos20a64.setPreDiabeticos(mujereshipertensos20a64.getPreDiabeticos() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setPreDiabeticos(hipertensos65ymas.getPreDiabeticos() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setPreDiabeticos(hombreshipertensos65ymas.getPreDiabeticos() + 1);
                            } else {
                                mujereshipertensos65ymas.setPreDiabeticos(mujereshipertensos65ymas.getPreDiabeticos() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setPreDiabeticos(dislipidemicos15a19.getPreDiabeticos() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setPreDiabeticos(hombresdislipidemicos15a19.getPreDiabeticos() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setPreDiabeticos(mujeresdislipidemicos15a19.getPreDiabeticos() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setPreDiabeticos(dislipidemicos20a64.getPreDiabeticos() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setPreDiabeticos(hombresdislipidemicos20a64.getPreDiabeticos() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setPreDiabeticos(mujeresdislipidemicos20a64.getPreDiabeticos() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setPreDiabeticos(dislipidemicos65ymas.getPreDiabeticos() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setPreDiabeticos(hombresdislipidemicos65ymas.getPreDiabeticos() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setPreDiabeticos(mujeresdislipidemicos65ymas.getPreDiabeticos() + 1);
                            }

                        }

                    }

                }//FIN  prediabetico

                if (fue_censado) {//  Si fue censado se cuenta al total
                    if (pacientes.isDiabetico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            diabeticos15a19.setPbc(diabeticos15a19.getPbc() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos15a19.setPbc(hombresdiabeticos15a19.getPbc() + 1);
                            } else {
                                mujeresdiabeticos15a19.setPbc(mujeresdiabeticos15a19.getPbc() + 1);
                            }
                        } else if (edad >= 20 && edad <= 64) {
                            diabeticos20a64.setPbc(diabeticos20a64.getPbc() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos20a64.setPbc(hombresdiabeticos20a64.getPbc() + 1);
                            } else {
                                mujeresdiabeticos20a64.setPbc(mujeresdiabeticos20a64.getPbc() + 1);
                            }
                        } else if (edad >= 65) {
                            diabeticos65ymas.setPbc(diabeticos65ymas.getPbc() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdiabeticos65ymas.setPbc(hombresdiabeticos65ymas.getPbc() + 1);
                            } else {
                                mujeresdiabeticos65ymas.setPbc(mujeresdiabeticos65ymas.getPbc() + 1);
                            }

                        }
                    }

                    if (pacientes.isHipertencion()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            hipertensos15a19.setPbc(hipertensos15a19.getPbc() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos15a19.setPbc(hombreshipertensos15a19.getPbc() + 1);
                            } else {
                                mujereshipertensos15a19.setPbc(mujereshipertensos15a19.getPbc() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            hipertensos20a64.setPbc(hipertensos20a64.getPbc() + 1);

                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos20a64.setPbc(hombreshipertensos20a64.getPbc() + 1);
                            } else {
                                mujereshipertensos20a64.setPbc(mujereshipertensos20a64.getPbc() + 1);
                            }
                        } else if (edad >= 65) {
                            hipertensos65ymas.setPbc(hipertensos65ymas.getPbc() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombreshipertensos65ymas.setPbc(hombreshipertensos65ymas.getPbc() + 1);
                            } else {
                                mujereshipertensos65ymas.setPbc(mujereshipertensos65ymas.getPbc() + 1);
                            }
                        }

                    }
                    if (pacientes.isDislipidemico()) {
                        fue_censado = true;
                        if (edad >= 15 && edad <= 19) {
                            dislipidemicos15a19.setPbc(dislipidemicos15a19.getPbc() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos15a19.setPbc(hombresdislipidemicos15a19.getPbc() + 1);
                            } else {
                                mujeresdislipidemicos15a19.setPbc(mujeresdislipidemicos15a19.getPbc() + 1);
                            }

                        } else if (edad >= 20 && edad <= 64) {
                            dislipidemicos20a64.setPbc(dislipidemicos20a64.getPbc() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos20a64.setPbc(hombresdislipidemicos20a64.getPbc() + 1);
                            } else {
                                mujeresdislipidemicos20a64.setPbc(mujeresdislipidemicos20a64.getPbc() + 1);
                            }

                        } else if (edad >= 65) {
                            dislipidemicos65ymas.setPbc(dislipidemicos65ymas.getPbc() + 1);
                            if (pacientes.getGenero_paciente().equals("Masculino")) {
                                hombresdislipidemicos65ymas.setPbc(hombresdislipidemicos65ymas.getPbc() + 1);
                            } else {
                                mujeresdislipidemicos65ymas.setPbc(mujeresdislipidemicos65ymas.getPbc() + 1);
                            }

                        }

                    }

                }//FIN  PBC

            } else {

                CensoCCVnoREMExcluidos nocensado = new CensoCCVnoREMExcluidos();
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

        //PAcientes fallecidos
        for (Paciente pacientes : pacientes_fallecimiento) {

            ccvf = ejbCartola.findByPaciente(pacientes);
            ccv_ordenadof = filtro(ccvf);
            ccv_filtrof = filtro_censables(ccv_ordenadof);
            if (ccv_filtrof.size() > 0) {
                int edad = ccv_filtrof.get(ccv_filtrof.size() - 1).getEdad_paciente();
                //posee un elemento censable o posee una atencion en 1 año pero esta fallecido
                if (pacientes.isDiabetico()) {//si es diabetico el paciente

                    if (edad >= 15 && edad <= 19) {
                        diabeticos15a19.setFallecidos(diabeticos15a19.getFallecidos() + 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            hombresdiabeticos15a19.setFallecidos(hombresdiabeticos15a19.getFallecidos() + 1);
                        } else {
                            mujeresdiabeticos15a19.setFallecidos(mujeresdiabeticos15a19.getFallecidos() + 1);
                        }
                    } else if (edad >= 20 && edad <= 64) {
                        diabeticos20a64.setFallecidos(diabeticos20a64.getFallecidos() + 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            hombresdiabeticos20a64.setFallecidos(hombresdiabeticos20a64.getFallecidos() + 1);
                        } else {
                            mujeresdiabeticos20a64.setFallecidos(mujeresdiabeticos20a64.getFallecidos() + 1);
                        }
                    } else if (edad >= 65) {
                        diabeticos65ymas.setFallecidos(diabeticos65ymas.getFallecidos() + 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            hombresdiabeticos65ymas.setFallecidos(hombresdiabeticos65ymas.getFallecidos() + 1);
                        } else {
                            mujeresdiabeticos65ymas.setFallecidos(mujeresdiabeticos65ymas.getFallecidos() + 1);
                        }

                    }
                }

                if (pacientes.isHipertencion()) {//si el paciente tiene hipertención

                    if (edad >= 15 && edad <= 19) {
                        hipertensos15a19.setFallecidos(hipertensos15a19.getFallecidos() + 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            hombreshipertensos15a19.setFallecidos(hombreshipertensos15a19.getFallecidos() + 1);
                        } else {
                            mujereshipertensos15a19.setFallecidos(mujereshipertensos15a19.getFallecidos() + 1);
                        }

                    } else if (edad >= 20 && edad <= 64) {
                        hipertensos20a64.setFallecidos(hipertensos20a64.getFallecidos() + 1);

                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            hombreshipertensos20a64.setFallecidos(hombreshipertensos20a64.getFallecidos() + 1);
                        } else {
                            mujereshipertensos20a64.setFallecidos(mujereshipertensos20a64.getFallecidos() + 1);
                        }
                    } else if (edad >= 65) {
                        hipertensos65ymas.setFallecidos(hipertensos65ymas.getFallecidos() + 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            hombreshipertensos65ymas.setFallecidos(hombreshipertensos65ymas.getFallecidos() + 1);
                        } else {
                            mujereshipertensos65ymas.setFallecidos(mujereshipertensos65ymas.getFallecidos() + 1);
                        }
                    }

                }
                if (pacientes.isDislipidemico()) {//si es dislipidemico

                    if (edad >= 15 && edad <= 19) {
                        dislipidemicos15a19.setFallecidos(dislipidemicos15a19.getFallecidos() + 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            hombresdislipidemicos15a19.setFallecidos(hombresdislipidemicos15a19.getFallecidos() + 1);
                        } else {
                            mujeresdislipidemicos15a19.setFallecidos(mujeresdislipidemicos15a19.getFallecidos() + 1);
                        }

                    } else if (edad >= 20 && edad <= 64) {
                        dislipidemicos20a64.setFallecidos(dislipidemicos20a64.getFallecidos() + 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            hombresdislipidemicos20a64.setFallecidos(hombresdislipidemicos20a64.getFallecidos() + 1);
                        } else {
                            mujeresdislipidemicos20a64.setFallecidos(mujeresdislipidemicos20a64.getFallecidos() + 1);
                        }

                    } else if (edad >= 65) {
                        dislipidemicos65ymas.setFallecidos(dislipidemicos65ymas.getFallecidos() + 1);
                        if (pacientes.getGenero_paciente().equals("Masculino")) {
                            hombresdislipidemicos65ymas.setFallecidos(hombresdislipidemicos65ymas.getFallecidos() + 1);
                        } else {
                            mujeresdislipidemicos65ymas.setFallecidos(mujeresdislipidemicos65ymas.getFallecidos() + 1);
                        }

                    }

                }

                CensoCCVnoREMExcluidos nocensado = new CensoCCVnoREMExcluidos();
                nocensado.setNombre(pacientes.getNombres_paciente());
                nocensado.setApellidop(pacientes.getApellidoPaterno_paciente());
                nocensado.setApellidom(pacientes.getApellidoMaterno_paciente());
                PacienteController p = new PacienteController();
                nocensado.setEdad(p.Age(pacientes.getFechaNacimiento_paciente()));
                nocensado.setRut(pacientes.getRut_paciente());
                nocensado.setRazon_exclusion("Considerado solo en Fallecidos PCCV");
                Pacientes_excluidos.add(nocensado);

            } else {//no se considero
                CensoCCVnoREMExcluidos nocensado = new CensoCCVnoREMExcluidos();
                nocensado.setNombre(pacientes.getNombres_paciente());
                nocensado.setApellidop(pacientes.getApellidoPaterno_paciente());
                nocensado.setApellidom(pacientes.getApellidoMaterno_paciente());
                PacienteController p = new PacienteController();
                nocensado.setEdad(p.Age(pacientes.getFechaNacimiento_paciente()));
                nocensado.setRut(pacientes.getRut_paciente());
                nocensado.setRazon_exclusion("Pasivo por Fallecimiento sin atención PCCV");
                Pacientes_excluidos.add(nocensado);
            }
        }//FIN FOR fallecidos
        /**
         * Se añaden los nombres a las columnas
         */
        diabeticos15a19.setNombreColumna("Total ambos sexos");
        hombresdiabeticos15a19.setNombreColumna("Hombres");
        mujeresdiabeticos15a19.setNombreColumna("Mujeres");
        diabeticos20a64.setNombreColumna("Total ambos sexos");
        hombresdiabeticos20a64.setNombreColumna("Hombres");
        mujeresdiabeticos20a64.setNombreColumna("Mujeres");
        diabeticos65ymas.setNombreColumna("Total ambos sexos");
        hombresdiabeticos65ymas.setNombreColumna("Hombres");
        mujeresdiabeticos65ymas.setNombreColumna("Mujeres");

        hipertensos15a19.setNombreColumna("Total ambos sexos");
        hombreshipertensos15a19.setNombreColumna("Hombres");
        mujereshipertensos15a19.setNombreColumna("Mujeres");
        hipertensos20a64.setNombreColumna("Total ambos sexos");
        hombreshipertensos20a64.setNombreColumna("Hombres");
        mujereshipertensos20a64.setNombreColumna("Mujeres");
        hipertensos65ymas.setNombreColumna("Total ambos sexos");
        hombreshipertensos65ymas.setNombreColumna("Hombres");
        mujereshipertensos65ymas.setNombreColumna("Mujeres");

        dislipidemicos15a19.setNombreColumna("Total ambos sexos");
        hombresdislipidemicos15a19.setNombreColumna("Hombres");
        mujeresdislipidemicos15a19.setNombreColumna("Mujeres");
        dislipidemicos20a64.setNombreColumna("Total ambos sexos");
        hombresdislipidemicos20a64.setNombreColumna("Hombres");
        mujeresdislipidemicos20a64.setNombreColumna("Mujeres");
        dislipidemicos65ymas.setNombreColumna("Total ambos sexos");
        hombresdislipidemicos65ymas.setNombreColumna("Hombres");
        mujeresdislipidemicos65ymas.setNombreColumna("Mujeres");

        diabeticos15a19.setNombreColumna2("DIABETICOS");
        hombresdiabeticos15a19.setNombreColumna2("");
        mujeresdiabeticos15a19.setNombreColumna2("");
        diabeticos20a64.setNombreColumna2("DIABETICOS");
        hombresdiabeticos20a64.setNombreColumna2("");
        mujeresdiabeticos20a64.setNombreColumna2("");
        diabeticos65ymas.setNombreColumna2("DIABETICOS");
        hombresdiabeticos65ymas.setNombreColumna2("");
        mujeresdiabeticos65ymas.setNombreColumna2("");

        hipertensos15a19.setNombreColumna2("HIPERTENSOS");
        hombreshipertensos15a19.setNombreColumna2("");
        mujereshipertensos15a19.setNombreColumna2("");
        hipertensos20a64.setNombreColumna2("HIPERTENSOS");
        hombreshipertensos20a64.setNombreColumna2("");
        mujereshipertensos20a64.setNombreColumna2("");
        hipertensos65ymas.setNombreColumna2("HIPERTENSOS");
        hombreshipertensos65ymas.setNombreColumna2("");
        mujereshipertensos65ymas.setNombreColumna2("");

        dislipidemicos15a19.setNombreColumna2("DISLIPIDEMICOS");
        hombresdislipidemicos15a19.setNombreColumna2("");
        mujeresdislipidemicos15a19.setNombreColumna2("");
        dislipidemicos20a64.setNombreColumna2("DISLIPIDEMICOS");
        hombresdislipidemicos20a64.setNombreColumna2("");
        mujeresdislipidemicos20a64.setNombreColumna2("");
        dislipidemicos65ymas.setNombreColumna2("DISLIPIDEMICOS");
        hombresdislipidemicos65ymas.setNombreColumna2("");
        mujeresdislipidemicos65ymas.setNombreColumna2("");
        /**
         * Se llenan las listas
         */
        Pacientes15a19.clear();
        Pacientes20a64.clear();
        Pacientes65ymas.clear();
        Pacientes15a19.add(diabeticos15a19);
        Pacientes15a19.add(hombresdiabeticos15a19);
        Pacientes15a19.add(mujeresdiabeticos15a19);
        Pacientes15a19.add(hipertensos15a19);
        Pacientes15a19.add(hombreshipertensos15a19);
        Pacientes15a19.add(mujereshipertensos15a19);
        Pacientes15a19.add(dislipidemicos15a19);
        Pacientes15a19.add(hombresdislipidemicos15a19);
        Pacientes15a19.add(mujeresdislipidemicos15a19);

        Pacientes20a64.add(diabeticos20a64);
        Pacientes20a64.add(hombresdiabeticos20a64);
        Pacientes20a64.add(mujeresdiabeticos20a64);
        Pacientes20a64.add(hipertensos20a64);
        Pacientes20a64.add(hombreshipertensos20a64);
        Pacientes20a64.add(mujereshipertensos20a64);
        Pacientes20a64.add(dislipidemicos20a64);
        Pacientes20a64.add(hombresdislipidemicos20a64);
        Pacientes20a64.add(mujeresdislipidemicos20a64);

        Pacientes65ymas.add(diabeticos65ymas);
        Pacientes65ymas.add(hombresdiabeticos65ymas);
        Pacientes65ymas.add(mujeresdiabeticos65ymas);
        Pacientes65ymas.add(hipertensos65ymas);
        Pacientes65ymas.add(hombreshipertensos65ymas);
        Pacientes65ymas.add(mujereshipertensos65ymas);
        Pacientes65ymas.add(dislipidemicos65ymas);
        Pacientes65ymas.add(hombresdislipidemicos65ymas);
        Pacientes65ymas.add(mujeresdislipidemicos65ymas);

    }
    /**
     * Calcula los resultados en regresion de las variables a considerar en el censo
     * @param resultados
     * @param ccv
     * @return 
     */
    public boolean[] ResultadosNoRem(boolean[] resultados, List<CartolaSeguimientoCCV> ccv) {
        int banderaLipico1 = 0;
        int banderaLipico2 = 0;
        int banderaLipico3 = 0;
        int banderaLipico4 = 0;
        int bandera0 = 0;
        int contadorHba = 0;
        int banderaHba1 = 0;
        int banderaHba2 = 0;
        int banderaHba3 = 0;
        int banderaHba4 = 0;
        int banderacreatinina = 0;
        int banderamicro = 0;
        int banderafondo = 0;
        int banderaatencion = 0;
        int banderak = 0;
        int banderaecg = 0;
        int banderacomp = 0;
        int banderaiam = 0;
        int banderaacv = 0;
        int banderaerc = 0;
        int banderaretinopatia = 0;
        int banderaceguera = 0;
        int banderahvi = 0;
        int banderaulcera = 0;
        int banderaamputacion = 0;
        int banderacuracionpie = 0;
        int banderanefro = 0;
        int banderaevaluacionpie = 0;
        int banderaprediabetes = 0;
        for (int i = ccv.size() - 1; i >= 0; i--) {
            if (ccv.get(i).getColesterolTotal_estado().equals("RESULTADO") && banderaLipico1 == 0) {
                banderaLipico1 = 1;
            }
            if (ccv.get(i).getHba1C_estado().equals("RESULTADO") && banderaLipico2 == 0) {
                banderaLipico2 = 1;
            }
            if (ccv.get(i).getColesterolLDL_estado().equals("RESULTADO") && banderaLipico3 == 0) {
                banderaLipico3 = 1;
            }
            if (ccv.get(i).getTrigliceridos_estado().equals("RESULTADO") && banderaLipico4 == 0) {
                banderaLipico4 = 1;
            }
            if (bandera0 == 0 && banderaLipico1 == 1 && banderaLipico2 == 1 && banderaLipico3 == 1 && banderaLipico4 == 1) {
                resultados[0] = true;
                bandera0 = 1;
            }

            if (banderafondo == 0 && ccv.get(i).getFondoOJO_estado().equals("RESULTADO")) {
                banderafondo = 1;
                resultados[1] = true;
            }

            if (banderaatencion == 0 && ccv.get(i).isAtencionPodologica()) {
                resultados[2] = true;
                banderaatencion = 1;
            }
            if (ccv.get(i).getHba1C_estado().equals("RESULTADO") && contadorHba <= 4) {
                contadorHba++;
                if (contadorHba == 1 && banderaHba1 == 0) {
                    resultados[6] = true;
                    banderaHba1 = 1;
                }
                if (contadorHba == 2 && banderaHba2 == 0) {
                    resultados[5] = true;
                    resultados[6] = false;
                    banderaHba2 = 1;
                }
                if (contadorHba == 3 && banderaHba3 == 0) {
                    resultados[4] = true;
                    resultados[6] = false;
                    resultados[5] = false;
                    banderaHba3 = 1;
                }
                if (contadorHba == 4 && banderaHba4 == 0) {
                    resultados[3] = true;
                    resultados[4] = false;
                    resultados[6] = false;
                    resultados[5] = false;
                    banderaHba4 = 1;
                }

            }//fin if hba1c

            if (ccv.get(i).getCreatinina_estado().equals("RESULTADO") && banderacreatinina == 0) {
                banderacreatinina = 1;
                resultados[7] = true;
            }//creatinina

            if (ccv.get(i).getMicroALB24H_estado().equals("RESULTADO") && banderamicro == 0) {
                banderamicro = 1;
                resultados[8] = true;
            }

            if (ccv.get(i).getKPositivo_estado().equals("RESULTADO") && banderak == 0) {
                banderak = 1;
                resultados[9] = true;
            }

            if (ccv.get(i).getECG_estado().equals("RESULTADO") && banderaecg == 0) {
                banderaecg = 1;
                resultados[10] = true;
            }

            if (ccv.get(i).isComplicacionPrevalencia() && banderacomp == 0) {
                resultados[11] = true;
                banderacomp = 1;
            }

            if (ccv.get(i).isRetinopatia() && banderaretinopatia == 0) {
                banderaretinopatia = 1;
                resultados[12] = true;
            }

            if (ccv.get(i).isIAM() && banderaiam == 0) {
                resultados[13] = true;
                banderaiam = 1;
            }

            if (ccv.get(i).isACV() && banderaacv == 0) {
                banderaacv = 1;
                resultados[14] = true;
            }

            if (ccv.get(i).isCegueraPostRetinopatia() && banderaceguera == 0) {
                banderaceguera = 1;
                resultados[15] = true;
            }

            if (ccv.get(i).isHVI() && banderahvi == 0) {
                resultados[16] = true;
                banderahvi = 1;

            }

            if (ccv.get(i).isNefropatiaInciente() && banderanefro == 0) {
                banderanefro = 1;
                resultados[17] = true;
            }

            if (ccv.get(i).getDet_Prev_ERC() != null && banderaerc == 0) {
                if (ccv.get(i).getDet_Prev_ERC().equals("NO SE EVALUA") == false) {
                    banderaerc = 1;
                    if (ccv.get(i).getDet_Prev_ERC().equals("ETAPA G5")) {
                        resultados[18] = true;
                    } else {
                        resultados[18] = false;
                    }
                }

            }

            if (ccv.get(i).getEstimacionRiesgoUlceracionPie() != null && banderaevaluacionpie == 0) {

                if (ccv.get(i).getEstimacionRiesgoUlceracionPie().equals("No se evalúa") == false) {
                    banderaevaluacionpie = 1;
                    resultados[19] = true;
                }
            }

            if (ccv.get(i).isUlcera_activaPieDM() && banderaulcera == 0) {
                banderaulcera = 1;
                resultados[20] = true;
            }

            if (ccv.get(i).getCuracionPie_DM() != null && banderacuracionpie == 0) {
                if (ccv.get(i).getCuracionPie_DM().equals("Curacion Convencional") && banderacuracionpie == 0) {
                    resultados[21] = false;
                    banderacuracionpie = 1;
                } else if (ccv.get(i).getCuracionPie_DM().equals("Curacion Avanzada") && banderacuracionpie == 0) {
                    resultados[21] = true;
                    banderacuracionpie = 1;
                }

            }

            if (ccv.get(i).isAmputacionDiabetica() && banderaamputacion == 0) {
                resultados[22] = true;
                banderaamputacion = 1;
            }

            if (ccv.get(i).getPaciente().isPrediabetes() && banderaprediabetes == 0) {
                banderaprediabetes = 1;
                resultados[23] = true;
            }

        }

        return resultados;
    }
    /**
     * Ve si una fecha entra en el rango de 1 año
     * @param fecha
     * @return 
     */
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
    /**
     * Solo filtra las cartolas que entran en el rango de fecha del censo, deben estar ordenadas por fecha
     * @param entrada
     * @return 
     */
    public List<CartolaSeguimientoCCV> filtro_censables(List<CartolaSeguimientoCCV> entrada) {
        List<CartolaSeguimientoCCV> lista = new ArrayList<>();

        for (int i = 0; i < entrada.size(); i++) {
            if (isCensable(entrada.get(i).getFecha_control()) && entrada.get(i).getEdad_paciente() >= 15) {
                lista.add(entrada.get(i));
            }
        }
        return lista;

    }
    /**
     * Hace un quicksort segun fechas a las cartolas
     * @param entrada
     * @return 
     */
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
    /**
     * Concatena dos listas ordenadas
     * @param less
     * @param pivot
     * @param mayores
     * @return 
     */
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
