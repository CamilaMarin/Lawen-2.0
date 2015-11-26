/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.cardiovascular;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;


/**
 *
 * @author daniel
 */
@Entity
public class FichaNutricionista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_fichanutri")
    private Long id;
    
    @Size(max=2000)
    private String anamnesis_nutri;
    private float perimetroCaderas_nutri;
    private Integer indiceCC_nutri1;
    private Integer indiceCC_nutri2;
    //// HISTORIA DIETÉTICA
    // Encuesta recordatoria 24 horas
    // Minuta desayuno
  
    @Temporal(javax.persistence.TemporalType.TIME)
    private java.util.Date desayuno_horario;
    private String desayuno_descripcion;
    @Temporal(javax.persistence.TemporalType.TIME)
    private java.util.Date colacion_horario;
    private String colacion_descripcion;
    @Temporal(javax.persistence.TemporalType.TIME)
    private java.util.Date  almuerzo_horario;
    private String almuerzo_descripcion;
    @Temporal(javax.persistence.TemporalType.TIME)
    private java.util.Date  colaciontarde_horario;
    private String colaciontarde_descripcion;
    @Temporal(javax.persistence.TemporalType.TIME)
    private java.util.Date cena_horario;
    private String cena_descripcion;
    //////
    
    ///// FRECUANCIA DE CONSUMO
    
    private String consumo_lecheYogurt_frecuencia;
    private String consumo_lecheYogurt_cantidad;
    private String consumo_lecheYogurt_observaciones;
    private String consumo_quesoQuesillo_frecuencia;
    private String consumo_quesoQuesillo_cantidad;
    private String consumo_quesoQuesillo_observaciones;
    private String consumo_carnes_frecuencia;
    private String consumo_carnes_cantidad;
    private String consumo_carnes_observaciones;
    private String consumo_pescadosMariscos_frecuencia;
    private String consumo_pescadosMariscos_cantidad;
    private String consumo_pescadosMariscos_observaciones;
    private String consumo_huevos_frecuencia;
    private String consumo_huevos_cantidad;
    private String consumo_huevos_observaciones;
    private String consumo_verduras_frecuencia;
    private String consumo_verduras_cantidad;
    private String consumo_verduras_observaciones;
    private String consumo_papas_frecuencia;
    private String consumo_papas_cantidad;
    private String consumo_papas_observaciones;
    private String consumo_frutas_frecuencia;
    private String consumo_frutas_cantidad;
    private String consumo_frutas_observaciones;
    private String consumo_leguminosas_frecuencia;
    private String consumo_leguminosas_cantidad;
    private String consumo_leguminosas_observaciones;
    private String consumo_cerealesFarinaceos_frecuencia;
    private String consumo_cerealesFarinaceos_cantidad;
    private String consumo_cerealesFarinaceos_observaciones;
    private String consumo_sopas_frecuencia;
    private String consumo_sopas_cantidad;
    private String consumo_sopas_observaciones;
    private String consumo_guisos_frecuencia;
    private String consumo_guisos_cantidad;
    private String consumo_guisos_observaciones;
    private String consumo_pan_frecuencia;
    private String consumo_pan_cantidad;
    private String consumo_pan_observaciones;
    private String consumo_galletas_frecuencia;
    private String consumo_galletas_cantidad;
    private String consumo_galletas_observaciones;
    private String consumo_aceite_frecuencia;
    private String consumo_aceite_cantidad;
    private String consumo_aceite_observaciones;
    private String consumo_mantequillaMargarina_frecuencia;
    private String consumo_mantequillaMargarina_cantidad;
    private String consumo_mantequillaMargarina_observaciones;
    private String consumo_azucar_frecuencia;
    private String consumo_azucar_cantidad;
    private String consumo_azucar_observaciones;
    private String consumo_mielMermelada_frecuencia;
    private String consumo_mielMermelada_cantidad;
    private String consumo_mielMermelada_observaciones;
    private String consumo_bedidas_frecuencia;
    private String consumo_bebidas_cantidad;
    private String consumo_bebidas_observaciones;
    private String consumo_dulces_frecuencia;
    private String consumo_dulces_cantidad;
    private String consumo_dulces_observaciones;
    private String consumo_embutidos_frecuencia;
    private String consumo_embutidos_cantidad;
    private String consumo_embutidos_observaciones;
    private String consumo_agua_frecuencia;
    private String consumo_agua_cantidad;
    private String consumo_agua_observaciones;
    private String consumo_otrosAlimentos_frecuencia;
    private String consumo_otrosAlimentos_cantidad;
    private String consumo_otrosAlimentos_observaciones;
    //////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    
    @Size(max=500)
    private String intolerancia_alimentaria;
    @Size(max=500)
    private String nutrientes_criticos;
    @Size(max=1500) 
    private String referencias_nutri;
    
    //va solo en en la ficha para ingreso
    private String icv_preescripciones_esp;//preescripciones especificas
    private String icv_preescripciones_dieteticas;
    private String icv_referencias;
    private String icv_indicaciones_alimentarias;
    private String icv_ind_esp_hdec1;
    private int icv_ind_esp_hdec2;
    private String icv_ind_esp_proteinas1;
    private int icv_ind_esp_proteinas2;
    private String icv_ind_esp_lipidos1;
    private int icv_ind_esp_lipidos2;
    
    
    //indicacion 
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnamnesis_nutri() {
        return anamnesis_nutri;
    }

    public void setAnamnesis_nutri(String anamnesis_nutri) {
        this.anamnesis_nutri = anamnesis_nutri;
    }

    public float getPerimetroCaderas_nutri() {
        return perimetroCaderas_nutri;
    }

    public void setPerimetroCaderas_nutri(float perimetroCaderas_nutri) {
        this.perimetroCaderas_nutri = perimetroCaderas_nutri;
    }

    public Integer getIndiceCC_nutri1() {
        return indiceCC_nutri1;
    }

    public void setIndiceCC_nutri1(Integer indiceCC_nutri1) {
        this.indiceCC_nutri1 = indiceCC_nutri1;
    }

    public Integer getIndiceCC_nutri2() {
        return indiceCC_nutri2;
    }

    public void setIndiceCC_nutri2(Integer indiceCC_nutri2) {
        this.indiceCC_nutri2 = indiceCC_nutri2;
    }

    public Date getDesayuno_horario() {
        return desayuno_horario;
    }

    public void setDesayuno_horario(Date desayuno_horario) {
        this.desayuno_horario = desayuno_horario;
    }

    public String getDesayuno_descripcion() {
        return desayuno_descripcion;
    }

    public void setDesayuno_descripcion(String desayuno_descripcion) {
        this.desayuno_descripcion = desayuno_descripcion;
    }

    public Date getColacion_horario() {
        return colacion_horario;
    }

    public void setColacion_horario(Date colacion_horario) {
        this.colacion_horario = colacion_horario;
    }

    public String getColacion_descripcion() {
        return colacion_descripcion;
    }

    public void setColacion_descripcion(String colacion_descripcion) {
        this.colacion_descripcion = colacion_descripcion;
    }

    public Date getAlmuerzo_horario() {
        return almuerzo_horario;
    }

    public void setAlmuerzo_horario(Date almuerzo_horario) {
        this.almuerzo_horario = almuerzo_horario;
    }

    public String getAlmuerzo_descripcion() {
        return almuerzo_descripcion;
    }

    public void setAlmuerzo_descripcion(String almuerzo_descripcion) {
        this.almuerzo_descripcion = almuerzo_descripcion;
    }

    public Date getColaciontarde_horario() {
        return colaciontarde_horario;
    }

    public void setColaciontarde_horario(Date colaciontarde_horario) {
        this.colaciontarde_horario = colaciontarde_horario;
    }

    public String getColaciontarde_descripcion() {
        return colaciontarde_descripcion;
    }

    public void setColaciontarde_descripcion(String colaciontarde_descripcion) {
        this.colaciontarde_descripcion = colaciontarde_descripcion;
    }

    public Date getCena_horario() {
        return cena_horario;
    }

    public void setCena_horario(Date cena_horario) {
        this.cena_horario = cena_horario;
    }

    public String getCena_descripcion() {
        return cena_descripcion;
    }

    public void setCena_descripcion(String cena_descripcion) {
        this.cena_descripcion = cena_descripcion;
    }


    public String getConsumo_lecheYogurt_frecuencia() {
        return consumo_lecheYogurt_frecuencia;
    }

    public void setConsumo_lecheYogurt_frecuencia(String consumo_lecheYogurt_frecuencia) {
        this.consumo_lecheYogurt_frecuencia = consumo_lecheYogurt_frecuencia;
    }

    public String getConsumo_lecheYogurt_cantidad() {
        return consumo_lecheYogurt_cantidad;
    }

    public void setConsumo_lecheYogurt_cantidad(String consumo_lecheYogurt_cantidad) {
        this.consumo_lecheYogurt_cantidad = consumo_lecheYogurt_cantidad;
    }

    public String getConsumo_lecheYogurt_observaciones() {
        return consumo_lecheYogurt_observaciones;
    }

    public void setConsumo_lecheYogurt_observaciones(String consumo_lecheYogurt_observaciones) {
        this.consumo_lecheYogurt_observaciones = consumo_lecheYogurt_observaciones;
    }

    public String getConsumo_quesoQuesillo_frecuencia() {
        return consumo_quesoQuesillo_frecuencia;
    }

    public void setConsumo_quesoQuesillo_frecuencia(String consumo_quesoQuesillo_frecuencia) {
        this.consumo_quesoQuesillo_frecuencia = consumo_quesoQuesillo_frecuencia;
    }

    public String getConsumo_quesoQuesillo_cantidad() {
        return consumo_quesoQuesillo_cantidad;
    }

    public void setConsumo_quesoQuesillo_cantidad(String consumo_quesoQuesillo_cantidad) {
        this.consumo_quesoQuesillo_cantidad = consumo_quesoQuesillo_cantidad;
    }

    public String getConsumo_quesoQuesillo_observaciones() {
        return consumo_quesoQuesillo_observaciones;
    }

    public void setConsumo_quesoQuesillo_observaciones(String consumo_quesoQuesillo_observaciones) {
        this.consumo_quesoQuesillo_observaciones = consumo_quesoQuesillo_observaciones;
    }

    public String getConsumo_carnes_frecuencia() {
        return consumo_carnes_frecuencia;
    }

    public void setConsumo_carnes_frecuencia(String consumo_carnes_frecuencia) {
        this.consumo_carnes_frecuencia = consumo_carnes_frecuencia;
    }

    public String getConsumo_carnes_cantidad() {
        return consumo_carnes_cantidad;
    }

    public void setConsumo_carnes_cantidad(String consumo_carnes_cantidad) {
        this.consumo_carnes_cantidad = consumo_carnes_cantidad;
    }

    public String getConsumo_carnes_observaciones() {
        return consumo_carnes_observaciones;
    }

    public void setConsumo_carnes_observaciones(String consumo_carnes_observaciones) {
        this.consumo_carnes_observaciones = consumo_carnes_observaciones;
    }

    public String getConsumo_pescadosMariscos_frecuencia() {
        return consumo_pescadosMariscos_frecuencia;
    }

    public void setConsumo_pescadosMariscos_frecuencia(String consumo_pescadosMariscos_frecuencia) {
        this.consumo_pescadosMariscos_frecuencia = consumo_pescadosMariscos_frecuencia;
    }

    public String getConsumo_pescadosMariscos_cantidad() {
        return consumo_pescadosMariscos_cantidad;
    }

    public void setConsumo_pescadosMariscos_cantidad(String consumo_pescadosMariscos_cantidad) {
        this.consumo_pescadosMariscos_cantidad = consumo_pescadosMariscos_cantidad;
    }

    public String getConsumo_pescadosMariscos_observaciones() {
        return consumo_pescadosMariscos_observaciones;
    }

    public void setConsumo_pescadosMariscos_observaciones(String consumo_pescadosMariscos_observaciones) {
        this.consumo_pescadosMariscos_observaciones = consumo_pescadosMariscos_observaciones;
    }

    public String getConsumo_huevos_frecuencia() {
        return consumo_huevos_frecuencia;
    }

    public void setConsumo_huevos_frecuencia(String consumo_huevos_frecuencia) {
        this.consumo_huevos_frecuencia = consumo_huevos_frecuencia;
    }

    public String getConsumo_huevos_cantidad() {
        return consumo_huevos_cantidad;
    }

    public void setConsumo_huevos_cantidad(String consumo_huevos_cantidad) {
        this.consumo_huevos_cantidad = consumo_huevos_cantidad;
    }

    public String getConsumo_huevos_observaciones() {
        return consumo_huevos_observaciones;
    }

    public void setConsumo_huevos_observaciones(String consumo_huevos_observaciones) {
        this.consumo_huevos_observaciones = consumo_huevos_observaciones;
    }

    public String getConsumo_verduras_frecuencia() {
        return consumo_verduras_frecuencia;
    }

    public void setConsumo_verduras_frecuencia(String consumo_verduras_frecuencia) {
        this.consumo_verduras_frecuencia = consumo_verduras_frecuencia;
    }

    public String getConsumo_verduras_cantidad() {
        return consumo_verduras_cantidad;
    }

    public void setConsumo_verduras_cantidad(String consumo_verduras_cantidad) {
        this.consumo_verduras_cantidad = consumo_verduras_cantidad;
    }

    public String getConsumo_verduras_observaciones() {
        return consumo_verduras_observaciones;
    }

    public void setConsumo_verduras_observaciones(String consumo_verduras_observaciones) {
        this.consumo_verduras_observaciones = consumo_verduras_observaciones;
    }

    public String getConsumo_papas_frecuencia() {
        return consumo_papas_frecuencia;
    }

    public void setConsumo_papas_frecuencia(String consumo_papas_frecuencia) {
        this.consumo_papas_frecuencia = consumo_papas_frecuencia;
    }

    public String getConsumo_papas_cantidad() {
        return consumo_papas_cantidad;
    }

    public void setConsumo_papas_cantidad(String consumo_papas_cantidad) {
        this.consumo_papas_cantidad = consumo_papas_cantidad;
    }

    public String getConsumo_papas_observaciones() {
        return consumo_papas_observaciones;
    }

    public void setConsumo_papas_observaciones(String consumo_papas_observaciones) {
        this.consumo_papas_observaciones = consumo_papas_observaciones;
    }

    public String getConsumo_frutas_frecuencia() {
        return consumo_frutas_frecuencia;
    }

    public void setConsumo_frutas_frecuencia(String consumo_frutas_frecuencia) {
        this.consumo_frutas_frecuencia = consumo_frutas_frecuencia;
    }

    public String getConsumo_frutas_cantidad() {
        return consumo_frutas_cantidad;
    }

    public void setConsumo_frutas_cantidad(String consumo_frutas_cantidad) {
        this.consumo_frutas_cantidad = consumo_frutas_cantidad;
    }

    public String getConsumo_frutas_observaciones() {
        return consumo_frutas_observaciones;
    }

    public void setConsumo_frutas_observaciones(String consumo_frutas_observaciones) {
        this.consumo_frutas_observaciones = consumo_frutas_observaciones;
    }

    public String getConsumo_leguminosas_frecuencia() {
        return consumo_leguminosas_frecuencia;
    }

    public void setConsumo_leguminosas_frecuencia(String consumo_leguminosas_frecuencia) {
        this.consumo_leguminosas_frecuencia = consumo_leguminosas_frecuencia;
    }

    public String getConsumo_leguminosas_cantidad() {
        return consumo_leguminosas_cantidad;
    }

    public void setConsumo_leguminosas_cantidad(String consumo_leguminosas_cantidad) {
        this.consumo_leguminosas_cantidad = consumo_leguminosas_cantidad;
    }

    public String getConsumo_leguminosas_observaciones() {
        return consumo_leguminosas_observaciones;
    }

    public void setConsumo_leguminosas_observaciones(String consumo_leguminosas_observaciones) {
        this.consumo_leguminosas_observaciones = consumo_leguminosas_observaciones;
    }

    public String getConsumo_cerealesFarinaceos_frecuencia() {
        return consumo_cerealesFarinaceos_frecuencia;
    }

    public void setConsumo_cerealesFarinaceos_frecuencia(String consumo_cerealesFarinaceos_frecuencia) {
        this.consumo_cerealesFarinaceos_frecuencia = consumo_cerealesFarinaceos_frecuencia;
    }

    public String getConsumo_cerealesFarinaceos_cantidad() {
        return consumo_cerealesFarinaceos_cantidad;
    }

    public void setConsumo_cerealesFarinaceos_cantidad(String consumo_cerealesFarinaceos_cantidad) {
        this.consumo_cerealesFarinaceos_cantidad = consumo_cerealesFarinaceos_cantidad;
    }

    public String getConsumo_cerealesFarinaceos_observaciones() {
        return consumo_cerealesFarinaceos_observaciones;
    }

    public void setConsumo_cerealesFarinaceos_observaciones(String consumo_cerealesFarinaceos_observaciones) {
        this.consumo_cerealesFarinaceos_observaciones = consumo_cerealesFarinaceos_observaciones;
    }

    public String getConsumo_sopas_frecuencia() {
        return consumo_sopas_frecuencia;
    }

    public void setConsumo_sopas_frecuencia(String consumo_sopas_frecuencia) {
        this.consumo_sopas_frecuencia = consumo_sopas_frecuencia;
    }

    public String getConsumo_sopas_cantidad() {
        return consumo_sopas_cantidad;
    }

    public void setConsumo_sopas_cantidad(String consumo_sopas_cantidad) {
        this.consumo_sopas_cantidad = consumo_sopas_cantidad;
    }

    public String getConsumo_sopas_observaciones() {
        return consumo_sopas_observaciones;
    }

    public void setConsumo_sopas_observaciones(String consumo_sopas_observaciones) {
        this.consumo_sopas_observaciones = consumo_sopas_observaciones;
    }

    public String getConsumo_guisos_frecuencia() {
        return consumo_guisos_frecuencia;
    }

    public void setConsumo_guisos_frecuencia(String consumo_guisos_frecuencia) {
        this.consumo_guisos_frecuencia = consumo_guisos_frecuencia;
    }

    public String getConsumo_guisos_cantidad() {
        return consumo_guisos_cantidad;
    }

    public void setConsumo_guisos_cantidad(String consumo_guisos_cantidad) {
        this.consumo_guisos_cantidad = consumo_guisos_cantidad;
    }

    public String getConsumo_guisos_observaciones() {
        return consumo_guisos_observaciones;
    }

    public void setConsumo_guisos_observaciones(String consumo_guisos_observaciones) {
        this.consumo_guisos_observaciones = consumo_guisos_observaciones;
    }

    public String getConsumo_pan_frecuencia() {
        return consumo_pan_frecuencia;
    }

    public void setConsumo_pan_frecuencia(String consumo_pan_frecuencia) {
        this.consumo_pan_frecuencia = consumo_pan_frecuencia;
    }

    public String getConsumo_pan_cantidad() {
        return consumo_pan_cantidad;
    }

    public void setConsumo_pan_cantidad(String consumo_pan_cantidad) {
        this.consumo_pan_cantidad = consumo_pan_cantidad;
    }

    public String getConsumo_pan_observaciones() {
        return consumo_pan_observaciones;
    }

    public void setConsumo_pan_observaciones(String consumo_pan_observaciones) {
        this.consumo_pan_observaciones = consumo_pan_observaciones;
    }

    public String getConsumo_galletas_frecuencia() {
        return consumo_galletas_frecuencia;
    }

    public void setConsumo_galletas_frecuencia(String consumo_galletas_frecuencia) {
        this.consumo_galletas_frecuencia = consumo_galletas_frecuencia;
    }

    public String getConsumo_galletas_cantidad() {
        return consumo_galletas_cantidad;
    }

    public void setConsumo_galletas_cantidad(String consumo_galletas_cantidad) {
        this.consumo_galletas_cantidad = consumo_galletas_cantidad;
    }

    public String getConsumo_galletas_observaciones() {
        return consumo_galletas_observaciones;
    }

    public void setConsumo_galletas_observaciones(String consumo_galletas_observaciones) {
        this.consumo_galletas_observaciones = consumo_galletas_observaciones;
    }

    public String getConsumo_aceite_frecuencia() {
        return consumo_aceite_frecuencia;
    }

    public void setConsumo_aceite_frecuencia(String consumo_aceite_frecuencia) {
        this.consumo_aceite_frecuencia = consumo_aceite_frecuencia;
    }

    public String getConsumo_aceite_cantidad() {
        return consumo_aceite_cantidad;
    }

    public void setConsumo_aceite_cantidad(String consumo_aceite_cantidad) {
        this.consumo_aceite_cantidad = consumo_aceite_cantidad;
    }

    public String getConsumo_aceite_observaciones() {
        return consumo_aceite_observaciones;
    }

    public void setConsumo_aceite_observaciones(String consumo_aceite_observaciones) {
        this.consumo_aceite_observaciones = consumo_aceite_observaciones;
    }

    public String getConsumo_mantequillaMargarina_frecuencia() {
        return consumo_mantequillaMargarina_frecuencia;
    }

    public void setConsumo_mantequillaMargarina_frecuencia(String consumo_mantequillaMargarina_frecuencia) {
        this.consumo_mantequillaMargarina_frecuencia = consumo_mantequillaMargarina_frecuencia;
    }

    public String getConsumo_mantequillaMargarina_cantidad() {
        return consumo_mantequillaMargarina_cantidad;
    }

    public void setConsumo_mantequillaMargarina_cantidad(String consumo_mantequillaMargarina_cantidad) {
        this.consumo_mantequillaMargarina_cantidad = consumo_mantequillaMargarina_cantidad;
    }

    public String getConsumo_mantequillaMargarina_observaciones() {
        return consumo_mantequillaMargarina_observaciones;
    }

    public void setConsumo_mantequillaMargarina_observaciones(String consumo_mantequillaMargarina_observaciones) {
        this.consumo_mantequillaMargarina_observaciones = consumo_mantequillaMargarina_observaciones;
    }

    public String getConsumo_azucar_frecuencia() {
        return consumo_azucar_frecuencia;
    }

    public void setConsumo_azucar_frecuencia(String consumo_azucar_frecuencia) {
        this.consumo_azucar_frecuencia = consumo_azucar_frecuencia;
    }

    public String getConsumo_azucar_cantidad() {
        return consumo_azucar_cantidad;
    }

    public void setConsumo_azucar_cantidad(String consumo_azucar_cantidad) {
        this.consumo_azucar_cantidad = consumo_azucar_cantidad;
    }

    public String getConsumo_azucar_observaciones() {
        return consumo_azucar_observaciones;
    }

    public void setConsumo_azucar_observaciones(String consumo_azucar_observaciones) {
        this.consumo_azucar_observaciones = consumo_azucar_observaciones;
    }

    public String getConsumo_mielMermelada_frecuencia() {
        return consumo_mielMermelada_frecuencia;
    }

    public void setConsumo_mielMermelada_frecuencia(String consumo_mielMermelada_frecuencia) {
        this.consumo_mielMermelada_frecuencia = consumo_mielMermelada_frecuencia;
    }

    public String getConsumo_mielMermelada_cantidad() {
        return consumo_mielMermelada_cantidad;
    }

    public void setConsumo_mielMermelada_cantidad(String consumo_mielMermelada_cantidad) {
        this.consumo_mielMermelada_cantidad = consumo_mielMermelada_cantidad;
    }

    public String getConsumo_mielMermelada_observaciones() {
        return consumo_mielMermelada_observaciones;
    }

    public void setConsumo_mielMermelada_observaciones(String consumo_mielMermelada_observaciones) {
        this.consumo_mielMermelada_observaciones = consumo_mielMermelada_observaciones;
    }

    public String getConsumo_bedidas_frecuencia() {
        return consumo_bedidas_frecuencia;
    }

    public void setConsumo_bedidas_frecuencia(String consumo_bedidas_frecuencia) {
        this.consumo_bedidas_frecuencia = consumo_bedidas_frecuencia;
    }

    public String getConsumo_bebidas_cantidad() {
        return consumo_bebidas_cantidad;
    }

    public void setConsumo_bebidas_cantidad(String consumo_bebidas_cantidad) {
        this.consumo_bebidas_cantidad = consumo_bebidas_cantidad;
    }

    public String getConsumo_bebidas_observaciones() {
        return consumo_bebidas_observaciones;
    }

    public void setConsumo_bebidas_observaciones(String consumo_bebidas_observaciones) {
        this.consumo_bebidas_observaciones = consumo_bebidas_observaciones;
    }

    public String getConsumo_dulces_frecuencia() {
        return consumo_dulces_frecuencia;
    }

    public void setConsumo_dulces_frecuencia(String consumo_dulces_frecuencia) {
        this.consumo_dulces_frecuencia = consumo_dulces_frecuencia;
    }

    public String getConsumo_dulces_cantidad() {
        return consumo_dulces_cantidad;
    }

    public void setConsumo_dulces_cantidad(String consumo_dulces_cantidad) {
        this.consumo_dulces_cantidad = consumo_dulces_cantidad;
    }

    public String getConsumo_dulces_observaciones() {
        return consumo_dulces_observaciones;
    }

    public void setConsumo_dulces_observaciones(String consumo_dulces_observaciones) {
        this.consumo_dulces_observaciones = consumo_dulces_observaciones;
    }

    public String getConsumo_embutidos_frecuencia() {
        return consumo_embutidos_frecuencia;
    }

    public void setConsumo_embutidos_frecuencia(String consumo_embutidos_frecuencia) {
        this.consumo_embutidos_frecuencia = consumo_embutidos_frecuencia;
    }

    public String getConsumo_embutidos_cantidad() {
        return consumo_embutidos_cantidad;
    }

    public void setConsumo_embutidos_cantidad(String consumo_embutidos_cantidad) {
        this.consumo_embutidos_cantidad = consumo_embutidos_cantidad;
    }

    public String getConsumo_embutidos_observaciones() {
        return consumo_embutidos_observaciones;
    }

    public void setConsumo_embutidos_observaciones(String consumo_embutidos_observaciones) {
        this.consumo_embutidos_observaciones = consumo_embutidos_observaciones;
    }

    public String getConsumo_agua_frecuencia() {
        return consumo_agua_frecuencia;
    }

    public void setConsumo_agua_frecuencia(String consumo_agua_frecuencia) {
        this.consumo_agua_frecuencia = consumo_agua_frecuencia;
    }

    public String getConsumo_agua_cantidad() {
        return consumo_agua_cantidad;
    }

    public void setConsumo_agua_cantidad(String consumo_agua_cantidad) {
        this.consumo_agua_cantidad = consumo_agua_cantidad;
    }

    public String getConsumo_agua_observaciones() {
        return consumo_agua_observaciones;
    }

    public void setConsumo_agua_observaciones(String consumo_agua_observaciones) {
        this.consumo_agua_observaciones = consumo_agua_observaciones;
    }

    public String getConsumo_otrosAlimentos_frecuencia() {
        return consumo_otrosAlimentos_frecuencia;
    }

    public void setConsumo_otrosAlimentos_frecuencia(String consumo_otrosAlimentos_frecuencia) {
        this.consumo_otrosAlimentos_frecuencia = consumo_otrosAlimentos_frecuencia;
    }

    public String getConsumo_otrosAlimentos_cantidad() {
        return consumo_otrosAlimentos_cantidad;
    }

    public void setConsumo_otrosAlimentos_cantidad(String consumo_otrosAlimentos_cantidad) {
        this.consumo_otrosAlimentos_cantidad = consumo_otrosAlimentos_cantidad;
    }

    public String getConsumo_otrosAlimentos_observaciones() {
        return consumo_otrosAlimentos_observaciones;
    }

    public void setConsumo_otrosAlimentos_observaciones(String consumo_otrosAlimentos_observaciones) {
        this.consumo_otrosAlimentos_observaciones = consumo_otrosAlimentos_observaciones;
    }

    public String getIntolerancia_alimentaria() {
        return intolerancia_alimentaria;
    }

    public void setIntolerancia_alimentaria(String intolerancia_alimentaria) {
        this.intolerancia_alimentaria = intolerancia_alimentaria;
    }

    public String getNutrientes_criticos() {
        return nutrientes_criticos;
    }

    public void setNutrientes_criticos(String nutrientes_criticos) {
        this.nutrientes_criticos = nutrientes_criticos;
    }

    public String getReferencias_nutri() {
        return referencias_nutri;
    }

    public void setReferencias_nutri(String referencias_nutri) {
        this.referencias_nutri = referencias_nutri;
    }

    public String getIcv_preescripciones_esp() {
        return icv_preescripciones_esp;
    }

    public void setIcv_preescripciones_esp(String icv_preescripciones_esp) {
        this.icv_preescripciones_esp = icv_preescripciones_esp;
    }

    public String getIcv_preescripciones_dieteticas() {
        return icv_preescripciones_dieteticas;
    }

    public void setIcv_preescripciones_dieteticas(String icv_preescripciones_dieteticas) {
        this.icv_preescripciones_dieteticas = icv_preescripciones_dieteticas;
    }

    public String getIcv_referencias() {
        return icv_referencias;
    }

    public void setIcv_referencias(String icv_referencias) {
        this.icv_referencias = icv_referencias;
    }

    public String getIcv_indicaciones_alimentarias() {
        return icv_indicaciones_alimentarias;
    }

    public void setIcv_indicaciones_alimentarias(String icv_indicaciones_alimentarias) {
        this.icv_indicaciones_alimentarias = icv_indicaciones_alimentarias;
    }

    public String getIcv_ind_esp_hdec1() {
        return icv_ind_esp_hdec1;
    }

    public void setIcv_ind_esp_hdec1(String icv_ind_esp_hdec1) {
        this.icv_ind_esp_hdec1 = icv_ind_esp_hdec1;
    }

    public int getIcv_ind_esp_hdec2() {
        return icv_ind_esp_hdec2;
    }

    public void setIcv_ind_esp_hdec2(int icv_ind_esp_hdec2) {
        this.icv_ind_esp_hdec2 = icv_ind_esp_hdec2;
    }

    public String getIcv_ind_esp_proteinas1() {
        return icv_ind_esp_proteinas1;
    }

    public void setIcv_ind_esp_proteinas1(String icv_ind_esp_proteinas1) {
        this.icv_ind_esp_proteinas1 = icv_ind_esp_proteinas1;
    }

    public int getIcv_ind_esp_proteinas2() {
        return icv_ind_esp_proteinas2;
    }

    public void setIcv_ind_esp_proteinas2(int icv_ind_esp_proteinas2) {
        this.icv_ind_esp_proteinas2 = icv_ind_esp_proteinas2;
    }

    public String getIcv_ind_esp_lipidos1() {
        return icv_ind_esp_lipidos1;
    }

    public void setIcv_ind_esp_lipidos1(String icv_ind_esp_lipidos1) {
        this.icv_ind_esp_lipidos1 = icv_ind_esp_lipidos1;
    }

    public int getIcv_ind_esp_lipidos2() {
        return icv_ind_esp_lipidos2;
    }

    public void setIcv_ind_esp_lipidos2(int icv_ind_esp_lipidos2) {
        this.icv_ind_esp_lipidos2 = icv_ind_esp_lipidos2;
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
        if (!(object instanceof FichaNutricionista)) {
            return false;
        }
        FichaNutricionista other = (FichaNutricionista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.cardiovascular.fichaNutricionista[ id=" + id + " ]";
    }
    
}