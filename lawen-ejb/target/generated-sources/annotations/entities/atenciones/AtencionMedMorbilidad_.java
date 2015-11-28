package entities.atenciones;

import entities.Paciente;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtencionMedMorbilidad.class)
public abstract class AtencionMedMorbilidad_ {

	public static volatile SingularAttribute<AtencionMedMorbilidad, String> diagnostivo_mrb;
	public static volatile SingularAttribute<AtencionMedMorbilidad, String> hipotesis_diagnostiva;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Float> peso_morb;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Integer> frecuencia_respiratoria;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Date> fechaAtencion_morb;
	public static volatile SingularAttribute<AtencionMedMorbilidad, String> indicaciones;
	public static volatile SingularAttribute<AtencionMedMorbilidad, String> tratamiento_famacologico;
	public static volatile SingularAttribute<AtencionMedMorbilidad, String> anamnesis_morb;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Float> temperatura;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Float> talla_morb;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Integer> saturacion_oxigeno;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Integer> frecuencia_cardiaca;
	public static volatile SingularAttribute<AtencionMedMorbilidad, String> diagnostico_nutricional_mrb;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Integer> presion_arterial1;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Integer> dolor;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Float> imc_morb;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Integer> presion_arterial2;
	public static volatile SingularAttribute<AtencionMedMorbilidad, String> examen_fisico;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Long> id;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Integer> edadMorb;
	public static volatile SingularAttribute<AtencionMedMorbilidad, String> examenes;
	public static volatile SingularAttribute<AtencionMedMorbilidad, String> referencias_mrb;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Usuario> profesional_morb;
	public static volatile SingularAttribute<AtencionMedMorbilidad, Paciente> paciente_mrb;

}

