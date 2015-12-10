package entities.atenciones;

import entities.Paciente;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtencionENFVisitaDom.class)
public abstract class AtencionENFVisitaDom_ {

	public static volatile SingularAttribute<AtencionENFVisitaDom, String> situacion_socioeconomica;
	public static volatile SingularAttribute<AtencionENFVisitaDom, String> plan_de_accion;
	public static volatile SingularAttribute<AtencionENFVisitaDom, Usuario> profesional_visita;
	public static volatile SingularAttribute<AtencionENFVisitaDom, Date> fechaVista;
	public static volatile SingularAttribute<AtencionENFVisitaDom, String> factores_de_riesgo;
	public static volatile SingularAttribute<AtencionENFVisitaDom, String> factores_protectores;
	public static volatile SingularAttribute<AtencionENFVisitaDom, String> estructura_vivienda;
	public static volatile SingularAttribute<AtencionENFVisitaDom, String> observaciones_generales;
	public static volatile SingularAttribute<AtencionENFVisitaDom, String> obervaciones_vivienda;
	public static volatile SingularAttribute<AtencionENFVisitaDom, Boolean> hacinamiento;
	public static volatile SingularAttribute<AtencionENFVisitaDom, Boolean> riesgo_accidentes;
	public static volatile SingularAttribute<AtencionENFVisitaDom, Integer> edad_paciente;
	public static volatile SingularAttribute<AtencionENFVisitaDom, String> condiciones_medio_ambiente;
	public static volatile SingularAttribute<AtencionENFVisitaDom, String> integrantes_grupo_familiar;
	public static volatile SingularAttribute<AtencionENFVisitaDom, Boolean> animales_en_casa;
	public static volatile SingularAttribute<AtencionENFVisitaDom, Long> id;
	public static volatile SingularAttribute<AtencionENFVisitaDom, Paciente> paciente_visita;

}

