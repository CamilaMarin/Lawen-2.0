package entities.cardiovascular;

import entities.Paciente;
import entities.TipoPrograma;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PreingresoD3.class)
public abstract class PreingresoD3_ {

	public static volatile SingularAttribute<PreingresoD3, Integer> padp2;
	public static volatile SingularAttribute<PreingresoD3, Integer> pulso;
	public static volatile SingularAttribute<PreingresoD3, Integer> padp1;
	public static volatile SingularAttribute<PreingresoD3, Integer> pads2;
	public static volatile SingularAttribute<PreingresoD3, Float> peso;
	public static volatile SingularAttribute<PreingresoD3, Integer> pads1;
	public static volatile SingularAttribute<PreingresoD3, Boolean> derivacionicv;
	public static volatile SingularAttribute<PreingresoD3, Boolean> citarmed;
	public static volatile SingularAttribute<PreingresoD3, Date> dated3;
	public static volatile SingularAttribute<PreingresoD3, Boolean> alta;
	public static volatile SingularAttribute<PreingresoD3, Integer> pass1;
	public static volatile SingularAttribute<PreingresoD3, Boolean> citar4;
	public static volatile SingularAttribute<PreingresoD3, String> observaciones;
	public static volatile SingularAttribute<PreingresoD3, Paciente> pacientes;
	public static volatile SingularAttribute<PreingresoD3, Usuario> profesional;
	public static volatile SingularAttribute<PreingresoD3, Integer> pass2;
	public static volatile SingularAttribute<PreingresoD3, Long> id;
	public static volatile SingularAttribute<PreingresoD3, Integer> pasp1;
	public static volatile SingularAttribute<PreingresoD3, Integer> pasp2;
	public static volatile SingularAttribute<PreingresoD3, TipoPrograma> tipoprograma;

}

