package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Paciente.class)
public abstract class Paciente_ {

	public static volatile SingularAttribute<Paciente, String> genero_paciente;
	public static volatile SingularAttribute<Paciente, Boolean> ACV;
	public static volatile SingularAttribute<Paciente, String> telefono2;
	public static volatile SingularAttribute<Paciente, String> estadoCivil_paciente;
	public static volatile SingularAttribute<Paciente, Boolean> drogas_paciente;
	public static volatile SingularAttribute<Paciente, String> telefono1;
	public static volatile SingularAttribute<Paciente, String> antecedentes_familiares;
	public static volatile SingularAttribute<Paciente, String> direccion_paciente;
	public static volatile SingularAttribute<Paciente, String> tabaco_paciente;
	public static volatile SingularAttribute<Paciente, String> nacionalidad_paciente;
	public static volatile SingularAttribute<Paciente, String> rut_paciente;
	public static volatile SingularAttribute<Paciente, String> sector_paciente;
	public static volatile SingularAttribute<Paciente, Date> fechaNacimiento_paciente;
	public static volatile SingularAttribute<Paciente, Long> id;
	public static volatile SingularAttribute<Paciente, Boolean> alcohol_paciente;
	public static volatile SingularAttribute<Paciente, String> ocupacion_paciente;
	public static volatile SingularAttribute<Paciente, Boolean> hipertencion;
	public static volatile SingularAttribute<Paciente, String> email_paciente;
	public static volatile SingularAttribute<Paciente, String> numeroRegistro_paciente;
	public static volatile SingularAttribute<Paciente, Boolean> diabetico;
	public static volatile SingularAttribute<Paciente, String> anteObstetricos_paciente;
	public static volatile SingularAttribute<Paciente, Boolean> intolerancia_glucosa;
	public static volatile SingularAttribute<Paciente, String> numeroFicha_paciente;
	public static volatile SingularAttribute<Paciente, String> alergias_paciente;
	public static volatile SingularAttribute<Paciente, Date> fechaInscripcion_paciente;
	public static volatile SingularAttribute<Paciente, String> apellidoPaterno_paciente;
	public static volatile ListAttribute<Paciente, Patologia> patologia;
	public static volatile SingularAttribute<Paciente, String> nombres_paciente;
	public static volatile SingularAttribute<Paciente, String> anteQuirurjicos_paciente;
	public static volatile SingularAttribute<Paciente, Boolean> resistencia_insulina;
	public static volatile SingularAttribute<Paciente, String> prevision_paciente;
	public static volatile SingularAttribute<Paciente, Boolean> dislipidemico;
	public static volatile SingularAttribute<Paciente, Boolean> IAM;
	public static volatile SingularAttribute<Paciente, Boolean> etnia;
	public static volatile SingularAttribute<Paciente, String> estado;
	public static volatile ListAttribute<Paciente, Programa> programas;
	public static volatile SingularAttribute<Paciente, String> hospitalizaciones_paciente;
	public static volatile SingularAttribute<Paciente, String> escolaridad_paciente;
	public static volatile SingularAttribute<Paciente, String> apellidoMaterno_paciente;
	public static volatile SingularAttribute<Paciente, Boolean> prediabetes;
	public static volatile SingularAttribute<Paciente, String> etnia_paciente;
	public static volatile SingularAttribute<Paciente, String> actividadFisica_paciente;

}

