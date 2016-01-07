package managedbeans.pediatria.censonorem;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import sessionbeans.pediatria.CartolaControlesNinoFacadeLocal;
import sessionbeans.pediatria.ControlNinoFacadeLocal;
import sessionbeans.pediatria.PacienteNinoFacadeLocal;
import entities.pediatria.PacienteNino;
import entities.pediatria.CartolaControlesNino;
import entities.pediatria.ControlNino;

@Named(value = "consultasCensoPediatriaNoREM")
@SessionScoped
public class ConsultasCensoPediatriaNoREM implements Serializable {
    
        private List<CensoPediatriaNoREM> ElementosPediatriaNoREM = new ArrayList<>();

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
            ElementosPediatriaNoREM = censoPediatriaNoREM();
        }

        public ControlNinoFacadeLocal getEjbControlNino() {
            return ejbControlNino;
        }

        public void setEjbControlNino(ControlNinoFacadeLocal ejbControlNino) {
            this.ejbControlNino = ejbControlNino;
        }

        public List<CensoPediatriaNoREM> getElementosPediatriaNoREM() {
            return ElementosPediatriaNoREM;
        }

        public void setElementosPediatriaNoREM(List<CensoPediatriaNoREM> ElementosPediatriaNoREM) {
            this.ElementosPediatriaNoREM = ElementosPediatriaNoREM;
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
        
         public List<CensoPediatriaNoREM> censoPediatriaNoREM() {
             
            CensoPediatriaNoREM totalAmbosSexos = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_menor1 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_menor1 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_1 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_1 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_2 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_2 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_3 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_3 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_4 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_4 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_5 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_5 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_6 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_6 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_7a11 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_7a11 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_12a17 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_12a17 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_18a23 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_18a23 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_24a35 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_24a35 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_36a41 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_36a41 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_42a47 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_42a47 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_48a59 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_48a59 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_60a71 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_60a71 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_6a9 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_6a9 = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_pueblos = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_pueblos = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalhombres_inmigrantes = new CensoPediatriaNoREM();
            CensoPediatriaNoREM totalmujeres_inmigrantes = new CensoPediatriaNoREM();
            
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
                    controlUltimo = ejbControlNino.findLastControl(cped.get(0).getId());
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
                        
                        if (controlUltimo.get(0).getAlimentacionRecibeControl().equals("L.M.E")) {//L.M.E
                            //siempre actualizar variable fue censado:                    
                            fue_censado = true;
                            totalAmbosSexos.setLactanciaLME(totalAmbosSexos.getLactanciaLME()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setLactanciaLME(totalhombres.getLactanciaLME()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setLactanciaLME(totalhombres_pueblos.getLactanciaLME()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setLactanciaLME(totalhombres_inmigrantes.getLactanciaLME()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setLactanciaLME(totalhombres_menor1.getLactanciaLME()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setLactanciaLME(totalhombres_1.getLactanciaLME()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setLactanciaLME(totalhombres_2.getLactanciaLME()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setLactanciaLME(totalhombres_3.getLactanciaLME()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setLactanciaLME(totalhombres_4.getLactanciaLME()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setLactanciaLME(totalhombres_5.getLactanciaLME()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setLactanciaLME(totalhombres_6.getLactanciaLME()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setLactanciaLME(totalhombres_7a11.getLactanciaLME()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setLactanciaLME(totalhombres_12a17.getLactanciaLME()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setLactanciaLME(totalhombres_18a23.getLactanciaLME()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setLactanciaLME(totalhombres_24a35.getLactanciaLME()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setLactanciaLME(totalhombres_36a41.getLactanciaLME()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setLactanciaLME(totalhombres_42a47.getLactanciaLME()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setLactanciaLME(totalhombres_48a59.getLactanciaLME()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setLactanciaLME(totalmujeres_60a71.getLactanciaLME()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setLactanciaLME(totalhombres_6a9.getLactanciaLME()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setLactanciaLME(totalmujeres.getLactanciaLME()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setLactanciaLME(totalmujeres_pueblos.getLactanciaLME()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setLactanciaLME(totalmujeres_inmigrantes.getLactanciaLME()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setLactanciaLME(totalmujeres_menor1.getLactanciaLME()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setLactanciaLME(totalmujeres_1.getLactanciaLME()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setLactanciaLME(totalmujeres_2.getLactanciaLME()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setLactanciaLME(totalmujeres_3.getLactanciaLME()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setLactanciaLME(totalmujeres_4.getLactanciaLME()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setLactanciaLME(totalmujeres_5.getLactanciaLME()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setLactanciaLME(totalmujeres_6.getLactanciaLME()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setLactanciaLME(totalmujeres_7a11.getLactanciaLME()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setLactanciaLME(totalmujeres_12a17.getLactanciaLME()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setLactanciaLME(totalmujeres_18a23.getLactanciaLME()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setLactanciaLME(totalmujeres_24a35.getLactanciaLME()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setLactanciaLME(totalmujeres_36a41.getLactanciaLME()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setLactanciaLME(totalmujeres_42a47.getLactanciaLME()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setLactanciaLME(totalmujeres_48a59.getLactanciaLME()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setLactanciaLME(totalmujeres_60a71.getLactanciaLME()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setLactanciaLME(totalmujeres_6a9.getLactanciaLME()+1);
                                }
                            }
                        }// FIN L.M.E
                        
                        
                        if (controlUltimo.get(0).getAlimentacionRecibeControl().equals("L.M.Otro")) {//L.M.Otro
                            //siempre actualizar variable fue censado:                    
                            fue_censado = true;
                            totalAmbosSexos.setLactanciaLMOtro(totalAmbosSexos.getLactanciaLMOtro()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setLactanciaLMOtro(totalhombres.getLactanciaLMOtro()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setLactanciaLMOtro(totalhombres_pueblos.getLactanciaLMOtro()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setLactanciaLMOtro(totalhombres_inmigrantes.getLactanciaLMOtro()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setLactanciaLMOtro(totalhombres_menor1.getLactanciaLMOtro()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setLactanciaLMOtro(totalhombres_1.getLactanciaLMOtro()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setLactanciaLMOtro(totalhombres_2.getLactanciaLMOtro()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setLactanciaLMOtro(totalhombres_3.getLactanciaLMOtro()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setLactanciaLMOtro(totalhombres_4.getLactanciaLMOtro()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setLactanciaLMOtro(totalhombres_5.getLactanciaLMOtro()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setLactanciaLMOtro(totalhombres_6.getLactanciaLMOtro()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setLactanciaLMOtro(totalhombres_7a11.getLactanciaLMOtro()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setLactanciaLMOtro(totalhombres_12a17.getLactanciaLMOtro()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setLactanciaLMOtro(totalhombres_18a23.getLactanciaLMOtro()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setLactanciaLMOtro(totalhombres_24a35.getLactanciaLMOtro()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setLactanciaLMOtro(totalhombres_36a41.getLactanciaLMOtro()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setLactanciaLMOtro(totalhombres_42a47.getLactanciaLMOtro()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setLactanciaLMOtro(totalhombres_48a59.getLactanciaLMOtro()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setLactanciaLMOtro(totalmujeres_60a71.getLactanciaLMOtro()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setLactanciaLMOtro(totalhombres_6a9.getLactanciaLMOtro()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setLactanciaLMOtro(totalmujeres.getLactanciaLMOtro()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setLactanciaLMOtro(totalmujeres_pueblos.getLactanciaLMOtro()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setLactanciaLMOtro(totalmujeres_inmigrantes.getLactanciaLMOtro()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setLactanciaLMOtro(totalmujeres_menor1.getLactanciaLMOtro()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setLactanciaLMOtro(totalmujeres_1.getLactanciaLMOtro()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setLactanciaLMOtro(totalmujeres_2.getLactanciaLMOtro()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setLactanciaLMOtro(totalmujeres_3.getLactanciaLMOtro()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setLactanciaLMOtro(totalmujeres_4.getLactanciaLMOtro()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setLactanciaLMOtro(totalmujeres_5.getLactanciaLMOtro()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setLactanciaLMOtro(totalmujeres_6.getLactanciaLMOtro()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setLactanciaLMOtro(totalmujeres_7a11.getLactanciaLMOtro()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setLactanciaLMOtro(totalmujeres_12a17.getLactanciaLMOtro()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setLactanciaLMOtro(totalmujeres_18a23.getLactanciaLMOtro()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setLactanciaLMOtro(totalmujeres_24a35.getLactanciaLMOtro()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setLactanciaLMOtro(totalmujeres_36a41.getLactanciaLMOtro()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setLactanciaLMOtro(totalmujeres_42a47.getLactanciaLMOtro()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setLactanciaLMOtro(totalmujeres_48a59.getLactanciaLMOtro()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setLactanciaLMOtro(totalmujeres_60a71.getLactanciaLMOtro()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setLactanciaLMOtro(totalmujeres_6a9.getLactanciaLMOtro()+1);
                                }
                            }
                        }// FIN L.M.Otro
                        
                        if (controlUltimo.get(0).getAlimentacionRecibeControl().equals("L.M. L.A")) {//L.M.LA
                            //siempre actualizar variable fue censado:                    
                            fue_censado = true;
                            totalAmbosSexos.setLactanciaLMLA(totalAmbosSexos.getLactanciaLMLA()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setLactanciaLMLA(totalhombres.getLactanciaLMLA()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setLactanciaLMLA(totalhombres_pueblos.getLactanciaLMLA()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setLactanciaLMLA(totalhombres_inmigrantes.getLactanciaLMLA()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setLactanciaLMLA(totalhombres_menor1.getLactanciaLMLA()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setLactanciaLMLA(totalhombres_1.getLactanciaLMLA()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setLactanciaLMLA(totalhombres_2.getLactanciaLMLA()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setLactanciaLMLA(totalhombres_3.getLactanciaLMLA()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setLactanciaLMLA(totalhombres_4.getLactanciaLMLA()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setLactanciaLMLA(totalhombres_5.getLactanciaLMLA()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setLactanciaLMLA(totalhombres_6.getLactanciaLMLA()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setLactanciaLMLA(totalhombres_7a11.getLactanciaLMLA()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setLactanciaLMLA(totalhombres_12a17.getLactanciaLMLA()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setLactanciaLMLA(totalhombres_18a23.getLactanciaLMLA()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setLactanciaLMLA(totalhombres_24a35.getLactanciaLMLA()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setLactanciaLMLA(totalhombres_36a41.getLactanciaLMLA()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setLactanciaLMLA(totalhombres_42a47.getLactanciaLMLA()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setLactanciaLMLA(totalhombres_48a59.getLactanciaLMLA()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setLactanciaLMLA(totalmujeres_60a71.getLactanciaLMLA()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setLactanciaLMLA(totalhombres_6a9.getLactanciaLMLA()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setLactanciaLMLA(totalmujeres.getLactanciaLMLA()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setLactanciaLMLA(totalmujeres_pueblos.getLactanciaLMLA()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setLactanciaLMLA(totalmujeres_inmigrantes.getLactanciaLMLA()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setLactanciaLMLA(totalmujeres_menor1.getLactanciaLMLA()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setLactanciaLMLA(totalmujeres_1.getLactanciaLMLA()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setLactanciaLMLA(totalmujeres_2.getLactanciaLMLA()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setLactanciaLMLA(totalmujeres_3.getLactanciaLMLA()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setLactanciaLMLA(totalmujeres_4.getLactanciaLMLA()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setLactanciaLMLA(totalmujeres_5.getLactanciaLMLA()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setLactanciaLMLA(totalmujeres_6.getLactanciaLMLA()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setLactanciaLMLA(totalmujeres_7a11.getLactanciaLMLA()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setLactanciaLMLA(totalmujeres_12a17.getLactanciaLMLA()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setLactanciaLMLA(totalmujeres_18a23.getLactanciaLMLA()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setLactanciaLMLA(totalmujeres_24a35.getLactanciaLMLA()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setLactanciaLMLA(totalmujeres_36a41.getLactanciaLMLA()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setLactanciaLMLA(totalmujeres_42a47.getLactanciaLMLA()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setLactanciaLMLA(totalmujeres_48a59.getLactanciaLMLA()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setLactanciaLMLA(totalmujeres_60a71.getLactanciaLMLA()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setLactanciaLMLA(totalmujeres_6a9.getLactanciaLMLA()+1);
                                }
                            }
                        }// FIN L.M.LA
                        
                        if (controlUltimo.get(0).getAlimentacionRecibeControl().equals("L.M. L.A Otros")) {//L.M. L.A. Otros.
                            //siempre actualizar variable fue censado:                    
                            fue_censado = true;
                            totalAmbosSexos.setLactanciaLMLAOtros(totalAmbosSexos.getLactanciaLMLAOtros()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setLactanciaLMLAOtros(totalhombres.getLactanciaLMLAOtros()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setLactanciaLMLAOtros(totalhombres_pueblos.getLactanciaLMLAOtros()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setLactanciaLMLAOtros(totalhombres_inmigrantes.getLactanciaLMLAOtros()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setLactanciaLMLAOtros(totalhombres_menor1.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setLactanciaLMLAOtros(totalhombres_1.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setLactanciaLMLAOtros(totalhombres_2.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setLactanciaLMLAOtros(totalhombres_3.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setLactanciaLMLAOtros(totalhombres_4.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setLactanciaLMLAOtros(totalhombres_5.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setLactanciaLMLAOtros(totalhombres_6.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setLactanciaLMLAOtros(totalhombres_7a11.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setLactanciaLMLAOtros(totalhombres_12a17.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setLactanciaLMLAOtros(totalhombres_18a23.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setLactanciaLMLAOtros(totalhombres_24a35.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setLactanciaLMLAOtros(totalhombres_36a41.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setLactanciaLMLAOtros(totalhombres_42a47.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setLactanciaLMLAOtros(totalhombres_48a59.getLactanciaLMLAOtros()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setLactanciaLMLAOtros(totalmujeres_60a71.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setLactanciaLMLAOtros(totalhombres_6a9.getLactanciaLMLAOtros()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setLactanciaLMLAOtros(totalmujeres.getLactanciaLMLAOtros()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setLactanciaLMLAOtros(totalmujeres_pueblos.getLactanciaLMLAOtros()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setLactanciaLMLAOtros(totalmujeres_inmigrantes.getLactanciaLMLAOtros()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setLactanciaLMLAOtros(totalmujeres_menor1.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setLactanciaLMLAOtros(totalmujeres_1.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setLactanciaLMLAOtros(totalmujeres_2.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setLactanciaLMLAOtros(totalmujeres_3.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setLactanciaLMLAOtros(totalmujeres_4.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setLactanciaLMLAOtros(totalmujeres_5.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setLactanciaLMLAOtros(totalmujeres_6.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setLactanciaLMLAOtros(totalmujeres_7a11.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setLactanciaLMLAOtros(totalmujeres_12a17.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setLactanciaLMLAOtros(totalmujeres_18a23.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setLactanciaLMLAOtros(totalmujeres_24a35.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setLactanciaLMLAOtros(totalmujeres_36a41.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setLactanciaLMLAOtros(totalmujeres_42a47.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setLactanciaLMLAOtros(totalmujeres_48a59.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setLactanciaLMLAOtros(totalmujeres_60a71.getLactanciaLMLAOtros()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setLactanciaLMLAOtros(totalmujeres_6a9.getLactanciaLMLAOtros()+1);
                                }
                            }
                        }// FIN L.M. L.A. Otros.
                        
                        if (controlUltimo.get(0).getAlimentacionRecibeControl().equals("L.A.")) {//L.A.
                            //siempre actualizar variable fue censado:                    
                            fue_censado = true;
                            totalAmbosSexos.setLactanciaLA(totalAmbosSexos.getLactanciaLA()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setLactanciaLA(totalhombres.getLactanciaLA()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setLactanciaLA(totalhombres_pueblos.getLactanciaLA()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setLactanciaLA(totalhombres_inmigrantes.getLactanciaLA()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setLactanciaLA(totalhombres_menor1.getLactanciaLA()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setLactanciaLA(totalhombres_1.getLactanciaLA()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setLactanciaLA(totalhombres_2.getLactanciaLA()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setLactanciaLA(totalhombres_3.getLactanciaLA()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setLactanciaLA(totalhombres_4.getLactanciaLA()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setLactanciaLA(totalhombres_5.getLactanciaLA()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setLactanciaLA(totalhombres_6.getLactanciaLA()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setLactanciaLA(totalhombres_7a11.getLactanciaLA()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setLactanciaLA(totalhombres_12a17.getLactanciaLA()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setLactanciaLA(totalhombres_18a23.getLactanciaLA()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setLactanciaLA(totalhombres_24a35.getLactanciaLA()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setLactanciaLA(totalhombres_36a41.getLactanciaLA()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setLactanciaLA(totalhombres_42a47.getLactanciaLA()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setLactanciaLA(totalhombres_48a59.getLactanciaLA()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setLactanciaLA(totalmujeres_60a71.getLactanciaLA()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setLactanciaLA(totalhombres_6a9.getLactanciaLA()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setLactanciaLA(totalmujeres.getLactanciaLA()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setLactanciaLA(totalmujeres_pueblos.getLactanciaLA()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setLactanciaLA(totalmujeres_inmigrantes.getLactanciaLA()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setLactanciaLA(totalmujeres_menor1.getLactanciaLA()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setLactanciaLA(totalmujeres_1.getLactanciaLA()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setLactanciaLA(totalmujeres_2.getLactanciaLA()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setLactanciaLA(totalmujeres_3.getLactanciaLA()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setLactanciaLA(totalmujeres_4.getLactanciaLA()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setLactanciaLA(totalmujeres_5.getLactanciaLA()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setLactanciaLA(totalmujeres_6.getLactanciaLA()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setLactanciaLA(totalmujeres_7a11.getLactanciaLA()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setLactanciaLA(totalmujeres_12a17.getLactanciaLA()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setLactanciaLA(totalmujeres_18a23.getLactanciaLA()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setLactanciaLA(totalmujeres_24a35.getLactanciaLA()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setLactanciaLA(totalmujeres_36a41.getLactanciaLA()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setLactanciaLA(totalmujeres_42a47.getLactanciaLA()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setLactanciaLA(totalmujeres_48a59.getLactanciaLA()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setLactanciaLA(totalmujeres_60a71.getLactanciaLA()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setLactanciaLA(totalmujeres_6a9.getLactanciaLA()+1);
                                }
                            }
                        }// FIN L.A.
                        
                        if (controlUltimo.get(0).getAlimentacionRecibeControl().equals("L.A. Otros")) {//L.A.Otros
                            //siempre actualizar variable fue censado:                    
                            fue_censado = true;
                            totalAmbosSexos.setLactanciaLAOtros(totalAmbosSexos.getLactanciaLAOtros()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setLactanciaLAOtros(totalhombres.getLactanciaLAOtros()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setLactanciaLAOtros(totalhombres_pueblos.getLactanciaLAOtros()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setLactanciaLAOtros(totalhombres_inmigrantes.getLactanciaLAOtros()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setLactanciaLAOtros(totalhombres_menor1.getLactanciaLAOtros()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setLactanciaLAOtros(totalhombres_1.getLactanciaLAOtros()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setLactanciaLAOtros(totalhombres_2.getLactanciaLAOtros()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setLactanciaLAOtros(totalhombres_3.getLactanciaLAOtros()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setLactanciaLAOtros(totalhombres_4.getLactanciaLAOtros()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setLactanciaLAOtros(totalhombres_5.getLactanciaLAOtros()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setLactanciaLAOtros(totalhombres_6.getLactanciaLAOtros()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setLactanciaLAOtros(totalhombres_7a11.getLactanciaLAOtros()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setLactanciaLAOtros(totalhombres_12a17.getLactanciaLAOtros()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setLactanciaLAOtros(totalhombres_18a23.getLactanciaLAOtros()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setLactanciaLAOtros(totalhombres_24a35.getLactanciaLAOtros()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setLactanciaLAOtros(totalhombres_36a41.getLactanciaLAOtros()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setLactanciaLAOtros(totalhombres_42a47.getLactanciaLAOtros()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setLactanciaLAOtros(totalhombres_48a59.getLactanciaLAOtros()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setLactanciaLAOtros(totalmujeres_60a71.getLactanciaLAOtros()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setLactanciaLAOtros(totalhombres_6a9.getLactanciaLAOtros()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setLactanciaLAOtros(totalmujeres.getLactanciaLAOtros()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setLactanciaLAOtros(totalmujeres_pueblos.getLactanciaLAOtros()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setLactanciaLAOtros(totalmujeres_inmigrantes.getLactanciaLAOtros()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setLactanciaLAOtros(totalmujeres_menor1.getLactanciaLAOtros()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setLactanciaLAOtros(totalmujeres_1.getLactanciaLAOtros()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setLactanciaLAOtros(totalmujeres_2.getLactanciaLAOtros()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setLactanciaLAOtros(totalmujeres_3.getLactanciaLAOtros()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setLactanciaLAOtros(totalmujeres_4.getLactanciaLAOtros()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setLactanciaLAOtros(totalmujeres_5.getLactanciaLAOtros()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setLactanciaLAOtros(totalmujeres_6.getLactanciaLAOtros()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setLactanciaLAOtros(totalmujeres_7a11.getLactanciaLAOtros()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setLactanciaLAOtros(totalmujeres_12a17.getLactanciaLAOtros()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setLactanciaLAOtros(totalmujeres_18a23.getLactanciaLAOtros()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setLactanciaLAOtros(totalmujeres_24a35.getLactanciaLAOtros()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setLactanciaLAOtros(totalmujeres_36a41.getLactanciaLAOtros()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setLactanciaLAOtros(totalmujeres_42a47.getLactanciaLAOtros()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setLactanciaLAOtros(totalmujeres_48a59.getLactanciaLAOtros()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setLactanciaLAOtros(totalmujeres_60a71.getLactanciaLAOtros()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setLactanciaLAOtros(totalmujeres_6a9.getLactanciaLAOtros()+1);
                                }
                            }
                        }// FIN L.A.Otros
                        
                        if (controlUltimo.get(0).getMadreObesa().equals("Si")) {//M.obesa
                            //siempre actualizar variable fue censado:                    
                            fue_censado = true;
                            totalAmbosSexos.setMadreObesa(totalAmbosSexos.getMadreObesa()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setMadreObesa(totalhombres.getMadreObesa()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setMadreObesa(totalhombres_pueblos.getMadreObesa()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setMadreObesa(totalhombres_inmigrantes.getMadreObesa()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setMadreObesa(totalhombres_menor1.getMadreObesa()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setMadreObesa(totalhombres_1.getMadreObesa()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setMadreObesa(totalhombres_2.getMadreObesa()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setMadreObesa(totalhombres_3.getMadreObesa()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setMadreObesa(totalhombres_4.getMadreObesa()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setMadreObesa(totalhombres_5.getMadreObesa()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setMadreObesa(totalhombres_6.getMadreObesa()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setMadreObesa(totalhombres_7a11.getMadreObesa()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setMadreObesa(totalhombres_12a17.getMadreObesa()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setMadreObesa(totalhombres_18a23.getMadreObesa()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setMadreObesa(totalhombres_24a35.getMadreObesa()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setMadreObesa(totalhombres_36a41.getMadreObesa()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setMadreObesa(totalhombres_42a47.getMadreObesa()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setMadreObesa(totalhombres_48a59.getMadreObesa()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setMadreObesa(totalmujeres_60a71.getMadreObesa()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setMadreObesa(totalhombres_6a9.getMadreObesa()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setMadreObesa(totalmujeres.getMadreObesa()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setMadreObesa(totalmujeres_pueblos.getMadreObesa()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setMadreObesa(totalmujeres_inmigrantes.getMadreObesa()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setMadreObesa(totalmujeres_menor1.getMadreObesa()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setMadreObesa(totalmujeres_1.getMadreObesa()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setMadreObesa(totalmujeres_2.getMadreObesa()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setMadreObesa(totalmujeres_3.getMadreObesa()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setMadreObesa(totalmujeres_4.getMadreObesa()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setMadreObesa(totalmujeres_5.getMadreObesa()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setMadreObesa(totalmujeres_6.getMadreObesa()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setMadreObesa(totalmujeres_7a11.getMadreObesa()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setMadreObesa(totalmujeres_12a17.getMadreObesa()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setMadreObesa(totalmujeres_18a23.getMadreObesa()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setMadreObesa(totalmujeres_24a35.getMadreObesa()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setMadreObesa(totalmujeres_36a41.getMadreObesa()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setMadreObesa(totalmujeres_42a47.getMadreObesa()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setMadreObesa(totalmujeres_48a59.getMadreObesa()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setMadreObesa(totalmujeres_60a71.getMadreObesa()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setMadreObesa(totalmujeres_6a9.getMadreObesa()+1);
                                }
                            }
                        }// FIN M.obesa
                        
                        if (controlUltimo.get(0).getMadreFumadora().equals("Si")) {//M.fum
                            //siempre actualizar variable fue censado:                    
                            fue_censado = true;
                            totalAmbosSexos.setMadreFumadora(totalAmbosSexos.getMadreFumadora()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setMadreFumadora(totalhombres.getMadreFumadora()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setMadreFumadora(totalhombres_pueblos.getMadreFumadora()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setMadreFumadora(totalhombres_inmigrantes.getMadreFumadora()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setMadreFumadora(totalhombres_menor1.getMadreFumadora()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setMadreFumadora(totalhombres_1.getMadreFumadora()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setMadreFumadora(totalhombres_2.getMadreFumadora()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setMadreFumadora(totalhombres_3.getMadreFumadora()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setMadreFumadora(totalhombres_4.getMadreFumadora()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setMadreFumadora(totalhombres_5.getMadreFumadora()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setMadreFumadora(totalhombres_6.getMadreFumadora()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setMadreFumadora(totalhombres_7a11.getMadreFumadora()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setMadreFumadora(totalhombres_12a17.getMadreFumadora()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setMadreFumadora(totalhombres_18a23.getMadreFumadora()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setMadreFumadora(totalhombres_24a35.getMadreFumadora()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setMadreFumadora(totalhombres_36a41.getMadreFumadora()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setMadreFumadora(totalhombres_42a47.getMadreFumadora()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setMadreFumadora(totalhombres_48a59.getMadreFumadora()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setMadreFumadora(totalmujeres_60a71.getMadreFumadora()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setMadreFumadora(totalhombres_6a9.getMadreFumadora()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setMadreFumadora(totalmujeres.getMadreFumadora()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setMadreFumadora(totalmujeres_pueblos.getMadreFumadora()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setMadreFumadora(totalmujeres_inmigrantes.getMadreFumadora()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setMadreFumadora(totalmujeres_menor1.getMadreFumadora()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setMadreFumadora(totalmujeres_1.getMadreFumadora()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setMadreFumadora(totalmujeres_2.getMadreFumadora()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setMadreFumadora(totalmujeres_3.getMadreFumadora()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setMadreFumadora(totalmujeres_4.getMadreFumadora()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setMadreFumadora(totalmujeres_5.getMadreFumadora()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setMadreFumadora(totalmujeres_6.getMadreFumadora()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setMadreFumadora(totalmujeres_7a11.getMadreFumadora()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setMadreFumadora(totalmujeres_12a17.getMadreFumadora()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setMadreFumadora(totalmujeres_18a23.getMadreFumadora()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setMadreFumadora(totalmujeres_24a35.getMadreFumadora()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setMadreFumadora(totalmujeres_36a41.getMadreFumadora()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setMadreFumadora(totalmujeres_42a47.getMadreFumadora()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setMadreFumadora(totalmujeres_48a59.getMadreFumadora()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setMadreFumadora(totalmujeres_60a71.getMadreFumadora()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setMadreFumadora(totalmujeres_6a9.getMadreFumadora()+1);
                                }
                            }
                        }// FIN M.fum
                        
                        if (controlUltimo.get(0).getMadreAlcohol().equals("Si")) {//M.alcohol
                            //siempre actualizar variable fue censado:                    
                            fue_censado = true;
                            totalAmbosSexos.setMadreAlcholica(totalAmbosSexos.getMadreAlcholica()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setMadreAlcholica(totalhombres.getMadreAlcholica()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setMadreAlcholica(totalhombres_pueblos.getMadreAlcholica()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setMadreAlcholica(totalhombres_inmigrantes.getMadreAlcholica()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setMadreAlcholica(totalhombres_menor1.getMadreAlcholica()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setMadreAlcholica(totalhombres_1.getMadreAlcholica()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setMadreAlcholica(totalhombres_2.getMadreAlcholica()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setMadreAlcholica(totalhombres_3.getMadreAlcholica()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setMadreAlcholica(totalhombres_4.getMadreAlcholica()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setMadreAlcholica(totalhombres_5.getMadreAlcholica()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setMadreAlcholica(totalhombres_6.getMadreAlcholica()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setMadreAlcholica(totalhombres_7a11.getMadreAlcholica()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setMadreAlcholica(totalhombres_12a17.getMadreAlcholica()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setMadreAlcholica(totalhombres_18a23.getMadreAlcholica()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setMadreAlcholica(totalhombres_24a35.getMadreAlcholica()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setMadreAlcholica(totalhombres_36a41.getMadreAlcholica()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setMadreAlcholica(totalhombres_42a47.getMadreAlcholica()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setMadreAlcholica(totalhombres_48a59.getMadreAlcholica()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setMadreAlcholica(totalmujeres_60a71.getMadreAlcholica()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setMadreAlcholica(totalhombres_6a9.getMadreAlcholica()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setMadreAlcholica(totalmujeres.getMadreAlcholica()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setMadreAlcholica(totalmujeres_pueblos.getMadreAlcholica()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setMadreAlcholica(totalmujeres_inmigrantes.getMadreAlcholica()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setMadreAlcholica(totalmujeres_menor1.getMadreAlcholica()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setMadreAlcholica(totalmujeres_1.getMadreAlcholica()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setMadreAlcholica(totalmujeres_2.getMadreAlcholica()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setMadreAlcholica(totalmujeres_3.getMadreAlcholica()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setMadreAlcholica(totalmujeres_4.getMadreAlcholica()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setMadreAlcholica(totalmujeres_5.getMadreAlcholica()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setMadreAlcholica(totalmujeres_6.getMadreAlcholica()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setMadreAlcholica(totalmujeres_7a11.getMadreAlcholica()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setMadreAlcholica(totalmujeres_12a17.getMadreAlcholica()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setMadreAlcholica(totalmujeres_18a23.getMadreAlcholica()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setMadreAlcholica(totalmujeres_24a35.getMadreAlcholica()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setMadreAlcholica(totalmujeres_36a41.getMadreAlcholica()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setMadreAlcholica(totalmujeres_42a47.getMadreAlcholica()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setMadreAlcholica(totalmujeres_48a59.getMadreAlcholica()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setMadreAlcholica(totalmujeres_60a71.getMadreAlcholica()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setMadreAlcholica(totalmujeres_6a9.getMadreAlcholica()+1);
                                }
                            }
                        }// FIN M.alcohol
                        
                        if (controlUltimo.get(0).getPadreObeso().equals("Si")) {//p.obeso                   
                            fue_censado = true;
                            totalAmbosSexos.setPadreObeso(totalAmbosSexos.getPadreObeso()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setPadreObeso(totalhombres.getPadreObeso()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setPadreObeso(totalhombres_pueblos.getPadreObeso()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setPadreObeso(totalhombres_inmigrantes.getPadreObeso()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setPadreObeso(totalhombres_menor1.getPadreObeso()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setPadreObeso(totalhombres_1.getPadreObeso()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setPadreObeso(totalhombres_2.getPadreObeso()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setPadreObeso(totalhombres_3.getPadreObeso()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setPadreObeso(totalhombres_4.getPadreObeso()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setPadreObeso(totalhombres_5.getPadreObeso()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setPadreObeso(totalhombres_6.getPadreObeso()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setPadreObeso(totalhombres_7a11.getPadreObeso()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setPadreObeso(totalhombres_12a17.getPadreObeso()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setPadreObeso(totalhombres_18a23.getPadreObeso()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setPadreObeso(totalhombres_24a35.getPadreObeso()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setPadreObeso(totalhombres_36a41.getPadreObeso()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setPadreObeso(totalhombres_42a47.getPadreObeso()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setPadreObeso(totalhombres_48a59.getPadreObeso()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setPadreObeso(totalmujeres_60a71.getPadreObeso()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setPadreObeso(totalhombres_6a9.getPadreObeso()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setPadreObeso(totalmujeres.getPadreObeso()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setPadreObeso(totalmujeres_pueblos.getPadreObeso()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setPadreObeso(totalmujeres_inmigrantes.getPadreObeso()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setPadreObeso(totalmujeres_menor1.getPadreObeso()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setPadreObeso(totalmujeres_1.getPadreObeso()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setPadreObeso(totalmujeres_2.getPadreObeso()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setPadreObeso(totalmujeres_3.getPadreObeso()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setPadreObeso(totalmujeres_4.getPadreObeso()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setPadreObeso(totalmujeres_5.getPadreObeso()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setPadreObeso(totalmujeres_6.getPadreObeso()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setPadreObeso(totalmujeres_7a11.getPadreObeso()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setPadreObeso(totalmujeres_12a17.getPadreObeso()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setPadreObeso(totalmujeres_18a23.getPadreObeso()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setPadreObeso(totalmujeres_24a35.getPadreObeso()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setPadreObeso(totalmujeres_36a41.getPadreObeso()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setPadreObeso(totalmujeres_42a47.getPadreObeso()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setPadreObeso(totalmujeres_48a59.getPadreObeso()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setPadreObeso(totalmujeres_60a71.getPadreObeso()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setPadreObeso(totalmujeres_6a9.getPadreObeso()+1);
                                }
                            }
                        }// FIN p.obeso
                        
                                               
                        if (controlUltimo.get(0).getPadreFumador().equals("Si")) {//p.fumador                   
                            fue_censado = true;
                            totalAmbosSexos.setPadreFumador(totalAmbosSexos.getPadreFumador()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setPadreFumador(totalhombres.getPadreFumador()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setPadreFumador(totalhombres_pueblos.getPadreFumador()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setPadreFumador(totalhombres_inmigrantes.getPadreFumador()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setPadreFumador(totalhombres_menor1.getPadreFumador()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setPadreFumador(totalhombres_1.getPadreFumador()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setPadreFumador(totalhombres_2.getPadreFumador()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setPadreFumador(totalhombres_3.getPadreFumador()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setPadreFumador(totalhombres_4.getPadreFumador()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setPadreFumador(totalhombres_5.getPadreFumador()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setPadreFumador(totalhombres_6.getPadreFumador()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setPadreFumador(totalhombres_7a11.getPadreFumador()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setPadreFumador(totalhombres_12a17.getPadreFumador()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setPadreFumador(totalhombres_18a23.getPadreFumador()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setPadreFumador(totalhombres_24a35.getPadreFumador()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setPadreFumador(totalhombres_36a41.getPadreFumador()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setPadreFumador(totalhombres_42a47.getPadreFumador()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setPadreFumador(totalhombres_48a59.getPadreFumador()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setPadreFumador(totalmujeres_60a71.getPadreFumador()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setPadreFumador(totalhombres_6a9.getPadreFumador()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setPadreFumador(totalmujeres.getPadreFumador()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setPadreFumador(totalmujeres_pueblos.getPadreFumador()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setPadreFumador(totalmujeres_inmigrantes.getPadreFumador()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setPadreFumador(totalmujeres_menor1.getPadreFumador()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setPadreFumador(totalmujeres_1.getPadreFumador()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setPadreFumador(totalmujeres_2.getPadreFumador()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setPadreFumador(totalmujeres_3.getPadreFumador()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setPadreFumador(totalmujeres_4.getPadreFumador()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setPadreFumador(totalmujeres_5.getPadreFumador()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setPadreFumador(totalmujeres_6.getPadreFumador()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setPadreFumador(totalmujeres_7a11.getPadreFumador()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setPadreFumador(totalmujeres_12a17.getPadreFumador()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setPadreFumador(totalmujeres_18a23.getPadreFumador()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setPadreFumador(totalmujeres_24a35.getPadreFumador()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setPadreFumador(totalmujeres_36a41.getPadreFumador()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setPadreFumador(totalmujeres_42a47.getPadreFumador()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setPadreFumador(totalmujeres_48a59.getPadreFumador()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setPadreFumador(totalmujeres_60a71.getPadreFumador()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setPadreFumador(totalmujeres_6a9.getPadreFumador()+1);
                                }
                            }
                        }// FIN p.fumador
                        
                        if (controlUltimo.get(0).getPadreAlcohol().equals("Si")) {//p.alcoholico                 
                            fue_censado = true;
                            totalAmbosSexos.setPadreAlcholico(totalAmbosSexos.getPadreAlcholico()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setPadreAlcholico(totalhombres.getPadreAlcholico()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setPadreAlcholico(totalhombres_pueblos.getPadreAlcholico()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setPadreAlcholico(totalhombres_inmigrantes.getPadreAlcholico()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setPadreAlcholico(totalhombres_menor1.getPadreAlcholico()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setPadreAlcholico(totalhombres_1.getPadreAlcholico()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setPadreAlcholico(totalhombres_2.getPadreAlcholico()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setPadreAlcholico(totalhombres_3.getPadreAlcholico()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setPadreAlcholico(totalhombres_4.getPadreAlcholico()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setPadreAlcholico(totalhombres_5.getPadreAlcholico()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setPadreAlcholico(totalhombres_6.getPadreAlcholico()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setPadreAlcholico(totalhombres_7a11.getPadreAlcholico()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setPadreAlcholico(totalhombres_12a17.getPadreAlcholico()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setPadreAlcholico(totalhombres_18a23.getPadreAlcholico()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setPadreAlcholico(totalhombres_24a35.getPadreAlcholico()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setPadreAlcholico(totalhombres_36a41.getPadreAlcholico()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setPadreAlcholico(totalhombres_42a47.getPadreAlcholico()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setPadreAlcholico(totalhombres_48a59.getPadreAlcholico()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setPadreAlcholico(totalmujeres_60a71.getPadreAlcholico()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setPadreAlcholico(totalhombres_6a9.getPadreAlcholico()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setPadreAlcholico(totalmujeres.getPadreAlcholico()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setPadreAlcholico(totalmujeres_pueblos.getPadreAlcholico()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setPadreAlcholico(totalmujeres_inmigrantes.getPadreAlcholico()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setPadreAlcholico(totalmujeres_menor1.getPadreAlcholico()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setPadreAlcholico(totalmujeres_1.getPadreAlcholico()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setPadreAlcholico(totalmujeres_2.getPadreAlcholico()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setPadreAlcholico(totalmujeres_3.getPadreAlcholico()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setPadreAlcholico(totalmujeres_4.getPadreAlcholico()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setPadreAlcholico(totalmujeres_5.getPadreAlcholico()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setPadreAlcholico(totalmujeres_6.getPadreAlcholico()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setPadreAlcholico(totalmujeres_7a11.getPadreAlcholico()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setPadreAlcholico(totalmujeres_12a17.getPadreAlcholico()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setPadreAlcholico(totalmujeres_18a23.getPadreAlcholico()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setPadreAlcholico(totalmujeres_24a35.getPadreAlcholico()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setPadreAlcholico(totalmujeres_36a41.getPadreAlcholico()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setPadreAlcholico(totalmujeres_42a47.getPadreAlcholico()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setPadreAlcholico(totalmujeres_48a59.getPadreAlcholico()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setPadreAlcholico(totalmujeres_60a71.getPadreAlcholico()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setPadreAlcholico(totalmujeres_6a9.getPadreAlcholico()+1);
                                }
                            }
                        }// FIN p.alcoholico        
                        
                        if (controlUltimo.get(0).getTallerNadiePerfecto().equals("Si")) {//AsitN.Perf
                            //siempre actualizar variable fue censado:                    
                            fue_censado = true;
                            totalAmbosSexos.setAsistNadiePerfecto(totalAmbosSexos.getAsistNadiePerfecto()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setAsistNadiePerfecto(totalhombres.getAsistNadiePerfecto()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setAsistNadiePerfecto(totalhombres_pueblos.getAsistNadiePerfecto()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setAsistNadiePerfecto(totalhombres_inmigrantes.getAsistNadiePerfecto()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setAsistNadiePerfecto(totalhombres_menor1.getAsistNadiePerfecto()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setAsistNadiePerfecto(totalhombres_1.getAsistNadiePerfecto()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setAsistNadiePerfecto(totalhombres_2.getAsistNadiePerfecto()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setAsistNadiePerfecto(totalhombres_3.getAsistNadiePerfecto()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setAsistNadiePerfecto(totalhombres_4.getAsistNadiePerfecto()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setAsistNadiePerfecto(totalhombres_5.getAsistNadiePerfecto()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setAsistNadiePerfecto(totalhombres_6.getAsistNadiePerfecto()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setAsistNadiePerfecto(totalhombres_7a11.getAsistNadiePerfecto()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setAsistNadiePerfecto(totalhombres_12a17.getAsistNadiePerfecto()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setAsistNadiePerfecto(totalhombres_18a23.getAsistNadiePerfecto()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setAsistNadiePerfecto(totalhombres_24a35.getAsistNadiePerfecto()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setAsistNadiePerfecto(totalhombres_36a41.getAsistNadiePerfecto()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setAsistNadiePerfecto(totalhombres_42a47.getAsistNadiePerfecto()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setAsistNadiePerfecto(totalhombres_48a59.getAsistNadiePerfecto()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setAsistNadiePerfecto(totalmujeres_60a71.getAsistNadiePerfecto()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setAsistNadiePerfecto(totalhombres_6a9.getAsistNadiePerfecto()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setAsistNadiePerfecto(totalmujeres.getAsistNadiePerfecto()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setAsistNadiePerfecto(totalmujeres_pueblos.getAsistNadiePerfecto()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setAsistNadiePerfecto(totalmujeres_inmigrantes.getAsistNadiePerfecto()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setAsistNadiePerfecto(totalmujeres_menor1.getAsistNadiePerfecto()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setAsistNadiePerfecto(totalmujeres_1.getAsistNadiePerfecto()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setAsistNadiePerfecto(totalmujeres_2.getAsistNadiePerfecto()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setAsistNadiePerfecto(totalmujeres_3.getAsistNadiePerfecto()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setAsistNadiePerfecto(totalmujeres_4.getAsistNadiePerfecto()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setAsistNadiePerfecto(totalmujeres_5.getAsistNadiePerfecto()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setAsistNadiePerfecto(totalmujeres_6.getAsistNadiePerfecto()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setAsistNadiePerfecto(totalmujeres_7a11.getAsistNadiePerfecto()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setAsistNadiePerfecto(totalmujeres_12a17.getAsistNadiePerfecto()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setAsistNadiePerfecto(totalmujeres_18a23.getAsistNadiePerfecto()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setAsistNadiePerfecto(totalmujeres_24a35.getAsistNadiePerfecto()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setAsistNadiePerfecto(totalmujeres_36a41.getAsistNadiePerfecto()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setAsistNadiePerfecto(totalmujeres_42a47.getAsistNadiePerfecto()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setAsistNadiePerfecto(totalmujeres_48a59.getAsistNadiePerfecto()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setAsistNadiePerfecto(totalmujeres_60a71.getAsistNadiePerfecto()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setAsistNadiePerfecto(totalmujeres_6a9.getAsistNadiePerfecto()+1);
                                }
                            }
                        }// FIN AsitN.Perf
                        
                        if (controlUltimo.get(0).getEntregaMaterialesEstimulacionControl().equals("Si")) {//matEstim
                            //siempre actualizar variable fue censado:                    
                            fue_censado = true;
                            totalAmbosSexos.setConMaterialesEstimulacion(totalAmbosSexos.getConMaterialesEstimulacion()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setConMaterialesEstimulacion(totalhombres.getConMaterialesEstimulacion()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setConMaterialesEstimulacion(totalhombres_pueblos.getConMaterialesEstimulacion()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setConMaterialesEstimulacion(totalhombres_inmigrantes.getConMaterialesEstimulacion()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setConMaterialesEstimulacion(totalhombres_menor1.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setConMaterialesEstimulacion(totalhombres_1.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setConMaterialesEstimulacion(totalhombres_2.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setConMaterialesEstimulacion(totalhombres_3.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setConMaterialesEstimulacion(totalhombres_4.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setConMaterialesEstimulacion(totalhombres_5.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setConMaterialesEstimulacion(totalhombres_6.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setConMaterialesEstimulacion(totalhombres_7a11.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setConMaterialesEstimulacion(totalhombres_12a17.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setConMaterialesEstimulacion(totalhombres_18a23.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setConMaterialesEstimulacion(totalhombres_24a35.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setConMaterialesEstimulacion(totalhombres_36a41.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setConMaterialesEstimulacion(totalhombres_42a47.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setConMaterialesEstimulacion(totalhombres_48a59.getConMaterialesEstimulacion()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setConMaterialesEstimulacion(totalmujeres_60a71.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setConMaterialesEstimulacion(totalhombres_6a9.getConMaterialesEstimulacion()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setConMaterialesEstimulacion(totalmujeres.getConMaterialesEstimulacion()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setConMaterialesEstimulacion(totalmujeres_pueblos.getConMaterialesEstimulacion()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setConMaterialesEstimulacion(totalmujeres_inmigrantes.getConMaterialesEstimulacion()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setConMaterialesEstimulacion(totalmujeres_menor1.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setConMaterialesEstimulacion(totalmujeres_1.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setConMaterialesEstimulacion(totalmujeres_2.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setConMaterialesEstimulacion(totalmujeres_3.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setConMaterialesEstimulacion(totalmujeres_4.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setConMaterialesEstimulacion(totalmujeres_5.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setConMaterialesEstimulacion(totalmujeres_6.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setConMaterialesEstimulacion(totalmujeres_7a11.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setConMaterialesEstimulacion(totalmujeres_12a17.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setConMaterialesEstimulacion(totalmujeres_18a23.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setConMaterialesEstimulacion(totalmujeres_24a35.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setConMaterialesEstimulacion(totalmujeres_36a41.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setConMaterialesEstimulacion(totalmujeres_42a47.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setConMaterialesEstimulacion(totalmujeres_48a59.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setConMaterialesEstimulacion(totalmujeres_60a71.getConMaterialesEstimulacion()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setConMaterialesEstimulacion(totalmujeres_6a9.getConMaterialesEstimulacion()+1);
                                }
                            }
                        }// FIN matEstim
                        
                        if (controlUltimo.get(0).getFiguraPaternaControl()) {//padrePresente
                            //siempre actualizar variable fue censado:                    
                            fue_censado = true;
                            totalAmbosSexos.setPadrePresente(totalAmbosSexos.getPadrePresente()+1);                   
                            if (pacientes.getGenero_nino().equals("Masculino")) {
                                totalhombres.setPadrePresente(totalhombres.getPadrePresente()+1);
                                if(pacientes.getEtnia()){
                                    totalhombres_pueblos.setPadrePresente(totalhombres_pueblos.getPadrePresente()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalhombres_inmigrantes.setPadrePresente(totalhombres_inmigrantes.getPadrePresente()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalhombres_menor1.setPadrePresente(totalhombres_menor1.getPadrePresente()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalhombres_1.setPadrePresente(totalhombres_1.getPadrePresente()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalhombres_2.setPadrePresente(totalhombres_2.getPadrePresente()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalhombres_3.setPadrePresente(totalhombres_3.getPadrePresente()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalhombres_4.setPadrePresente(totalhombres_4.getPadrePresente()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalhombres_5.setPadrePresente(totalhombres_5.getPadrePresente()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalhombres_6.setPadrePresente(totalhombres_6.getPadrePresente()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalhombres_7a11.setPadrePresente(totalhombres_7a11.getPadrePresente()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalhombres_12a17.setPadrePresente(totalhombres_12a17.getPadrePresente()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalhombres_18a23.setPadrePresente(totalhombres_18a23.getPadrePresente()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalhombres_24a35.setPadrePresente(totalhombres_24a35.getPadrePresente()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalhombres_36a41.setPadrePresente(totalhombres_36a41.getPadrePresente()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalhombres_42a47.setPadrePresente(totalhombres_42a47.getPadrePresente()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalhombres_48a59.setPadrePresente(totalhombres_48a59.getPadrePresente()+1); 
                                } else if (edad >= 60 && edad < 72) {
                                    totalhombres_60a71.setPadrePresente(totalmujeres_60a71.getPadrePresente()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalhombres_6a9.setPadrePresente(totalhombres_6a9.getPadrePresente()+1);
                                }
                            } else {//Genero Femenino
                                totalmujeres.setPadrePresente(totalmujeres.getPadrePresente()+1);
                                if(pacientes.getEtnia()){
                                    totalmujeres_pueblos.setPadrePresente(totalmujeres_pueblos.getPadrePresente()+1);
                                }
                                if(pacientes.getExtranjero()){
                                    totalmujeres_inmigrantes.setPadrePresente(totalmujeres_inmigrantes.getPadrePresente()+1);
                                }
                                //Dependiendo de la edad las condiciones son:
                                if (edad <1) {
                                    totalmujeres_menor1.setPadrePresente(totalmujeres_menor1.getPadrePresente()+1);
                                } else if (edad >= 1 && edad < 2) {
                                    totalmujeres_1.setPadrePresente(totalmujeres_1.getPadrePresente()+1);
                                } else if (edad >= 2 && edad < 3) {
                                    totalmujeres_2.setPadrePresente(totalmujeres_2.getPadrePresente()+1);
                                } else if (edad >= 3 && edad < 4) {
                                    totalmujeres_3.setPadrePresente(totalmujeres_3.getPadrePresente()+1);
                                } else if (edad >= 4 && edad < 5) {
                                    totalmujeres_4.setPadrePresente(totalmujeres_4.getPadrePresente()+1);
                                } else if (edad >= 5 && edad < 6) {
                                    totalmujeres_5.setPadrePresente(totalmujeres_5.getPadrePresente()+1);
                                } else if (edad >= 6 && edad < 7) {
                                    totalmujeres_6.setPadrePresente(totalmujeres_6.getPadrePresente()+1);
                                } else if (edad >= 7 && edad < 12) {
                                    totalmujeres_7a11.setPadrePresente(totalmujeres_7a11.getPadrePresente()+1);
                                } else if (edad >= 12 && edad < 18) {
                                    totalmujeres_12a17.setPadrePresente(totalmujeres_12a17.getPadrePresente()+1);
                                } else if (edad >= 18 && edad < 24) {
                                    totalmujeres_18a23.setPadrePresente(totalmujeres_18a23.getPadrePresente()+1);
                                } else if (edad >= 24 && edad < 36) {
                                    totalmujeres_24a35.setPadrePresente(totalmujeres_24a35.getPadrePresente()+1);
                                } else if (edad >= 36 && edad < 42) {
                                    totalmujeres_36a41.setPadrePresente(totalmujeres_36a41.getPadrePresente()+1);
                                } else if (edad >= 42 && edad < 48) {
                                    totalmujeres_42a47.setPadrePresente(totalmujeres_42a47.getPadrePresente()+1);
                                } else if (edad >= 48 && edad < 60) {
                                    totalmujeres_48a59.setPadrePresente(totalmujeres_48a59.getPadrePresente()+1);
                                } else if (edad >= 60 && edad < 72) {
                                    totalmujeres_60a71.setPadrePresente(totalmujeres_60a71.getPadrePresente()+1);
                                } else if (edad >= 72 && edad <= 108) {
                                    totalmujeres_6a9.setPadrePresente(totalmujeres_6a9.getPadrePresente()+1);
                                }
                            }
                        }// FIN PadrePresente   
                    }
                }            
            }
            
            totalAmbosSexos.setColumnName1("Total Ambos Sexos");
            totalhombres.setColumnName1("Total Hombres");
            totalmujeres.setColumnName1("Total Mujeres");
            totalhombres_menor1.setColumnName1("Hombres menor de 1 mes");
            totalmujeres_menor1.setColumnName1("Mujeres menor de 1 mes");
            totalhombres_1.setColumnName1("Hombres 1 mes");
            totalmujeres_1.setColumnName1("Mujeres 1 mes");
            totalhombres_2.setColumnName1("Hombres 2 meses");
            totalmujeres_2.setColumnName1("Mujeres 2 meses");
            totalhombres_3.setColumnName1("Hombres 3 meses");
            totalmujeres_3.setColumnName1("Mujeres 3 meses");
            totalhombres_4.setColumnName1("Hombres 4 meses");
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

            ElementosPediatriaNoREM.clear();
            ElementosPediatriaNoREM.add(totalAmbosSexos);
            ElementosPediatriaNoREM.add(totalhombres);
            ElementosPediatriaNoREM.add(totalmujeres);
            ElementosPediatriaNoREM.add(totalhombres_menor1);
            ElementosPediatriaNoREM.add(totalmujeres_menor1);

            ElementosPediatriaNoREM.add(totalhombres_1);
            ElementosPediatriaNoREM.add(totalmujeres_1);

            ElementosPediatriaNoREM.add(totalhombres_2);
            ElementosPediatriaNoREM.add(totalmujeres_2);

            ElementosPediatriaNoREM.add(totalhombres_3);
            ElementosPediatriaNoREM.add(totalmujeres_3);

            ElementosPediatriaNoREM.add(totalhombres_4);
            ElementosPediatriaNoREM.add(totalmujeres_4);

            ElementosPediatriaNoREM.add(totalhombres_5);
            ElementosPediatriaNoREM.add(totalmujeres_5);

            ElementosPediatriaNoREM.add(totalhombres_6);
            ElementosPediatriaNoREM.add(totalmujeres_6);

            ElementosPediatriaNoREM.add(totalhombres_7a11);
            ElementosPediatriaNoREM.add(totalmujeres_7a11);

            ElementosPediatriaNoREM.add(totalhombres_12a17);
            ElementosPediatriaNoREM.add(totalmujeres_12a17);

            ElementosPediatriaNoREM.add(totalhombres_18a23);
            ElementosPediatriaNoREM.add(totalmujeres_18a23);

            ElementosPediatriaNoREM.add(totalhombres_24a35);
            ElementosPediatriaNoREM.add(totalmujeres_24a35);

            ElementosPediatriaNoREM.add(totalhombres_36a41);
            ElementosPediatriaNoREM.add(totalmujeres_36a41);

            ElementosPediatriaNoREM.add(totalhombres_42a47);
            ElementosPediatriaNoREM.add(totalmujeres_42a47);

            ElementosPediatriaNoREM.add(totalhombres_48a59);
            ElementosPediatriaNoREM.add(totalmujeres_48a59);

            ElementosPediatriaNoREM.add(totalhombres_60a71);
            ElementosPediatriaNoREM.add(totalmujeres_60a71);

            ElementosPediatriaNoREM.add(totalhombres_6a9);
            ElementosPediatriaNoREM.add(totalmujeres_6a9);

            ElementosPediatriaNoREM.add(totalhombres_pueblos);
            ElementosPediatriaNoREM.add(totalmujeres_pueblos);

            ElementosPediatriaNoREM.add(totalhombres_inmigrantes);
            ElementosPediatriaNoREM.add(totalmujeres_inmigrantes);

            return ElementosPediatriaNoREM;
         }

    public ConsultasCensoPediatriaNoREM() {        
        
    
    }
    
}
