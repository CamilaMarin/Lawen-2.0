package entities.cardiovascular;

import entities.Paciente;
import entities.TipoPrograma;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PreingresoD1.class)
public abstract class PreingresoD1_ {

	public static volatile SingularAttribute<PreingresoD1, Boolean> citarmed;
	public static volatile SingularAttribute<PreingresoD1, Integer> padp1;
	public static volatile SingularAttribute<PreingresoD1, Integer> padp2;
	public static volatile SingularAttribute<PreingresoD1, Paciente> pacientes;
	public static volatile SingularAttribute<PreingresoD1, Integer> paref2sentado;
	public static volatile SingularAttribute<PreingresoD1, String> observaciones;
	public static volatile SingularAttribute<PreingresoD1, Long> id;
	public static volatile SingularAttribute<PreingresoD1, Integer> paref2parado;
	public static volatile SingularAttribute<PreingresoD1, TipoPrograma> tipoprograma;
	public static volatile SingularAttribute<PreingresoD1, String> trataactual;
	public static volatile SingularAttribute<PreingresoD1, String> antecedentespersocvc;
	public static volatile SingularAttribute<PreingresoD1, Date> dated1;
	public static volatile SingularAttribute<PreingresoD1, Boolean> alta;
	public static volatile SingularAttribute<PreingresoD1, Boolean> citard2;
	public static volatile SingularAttribute<PreingresoD1, Integer> pads1;
	public static volatile SingularAttribute<PreingresoD1, Integer> pads2;
	public static volatile SingularAttribute<PreingresoD1, Integer> pass2;
	public static volatile SingularAttribute<PreingresoD1, Float> talla;
	public static volatile SingularAttribute<PreingresoD1, Integer> pass1;
	public static volatile SingularAttribute<PreingresoD1, Usuario> profesional;
	public static volatile SingularAttribute<PreingresoD1, Integer> pasp2;
	public static volatile SingularAttribute<PreingresoD1, Float> peso;
	public static volatile SingularAttribute<PreingresoD1, Integer> pulso;
	public static volatile SingularAttribute<PreingresoD1, Integer> paref1sentado;
	public static volatile SingularAttribute<PreingresoD1, String> referido;
	public static volatile SingularAttribute<PreingresoD1, Integer> pasp1;
	public static volatile SingularAttribute<PreingresoD1, Integer> paref1parado;
	public static volatile SingularAttribute<PreingresoD1, String> antecedentesfamicvc;
	public static volatile SingularAttribute<PreingresoD1, Boolean> derivacionicv;
	public static volatile SingularAttribute<PreingresoD1, Boolean> citar6;

}

