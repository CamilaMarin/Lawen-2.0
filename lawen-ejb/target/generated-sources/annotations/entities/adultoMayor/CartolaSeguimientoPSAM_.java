package entities.adultoMayor;

import entities.Paciente;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CartolaSeguimientoPSAM.class)
public abstract class CartolaSeguimientoPSAM_ {

	public static volatile SingularAttribute<CartolaSeguimientoPSAM, String> clasificacion_efam;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, String> clasificacion_yesavage;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, String> valoracion_riesgo;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, String> sospecha_maltrato_obs;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, Boolean> paciente_institucionalizado;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, Date> fechaAtencion;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, String> clasificacion_folstein;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, Integer> edad;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, String> clasificacion_barthel;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, Boolean> realiza_actividadFisica;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, String> estado_nutricional;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, Paciente> paciente;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, Usuario> profesional;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, Boolean> sospecha_maltrato;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, Long> id;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, String> antiguedad_programa;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, String> pertenece_al_programa_mas;
	public static volatile SingularAttribute<CartolaSeguimientoPSAM, String> clasificacion_pfeffer;

}

