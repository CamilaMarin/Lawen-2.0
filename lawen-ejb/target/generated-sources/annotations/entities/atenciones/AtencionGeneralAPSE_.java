package entities.atenciones;

import entities.Paciente;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtencionGeneralAPSE.class)
public abstract class AtencionGeneralAPSE_ {

	public static volatile SingularAttribute<AtencionGeneralAPSE, Usuario> profesional_apse;
	public static volatile SingularAttribute<AtencionGeneralAPSE, String> descipcionApse;
	public static volatile SingularAttribute<AtencionGeneralAPSE, Paciente> paciente_apse;
	public static volatile SingularAttribute<AtencionGeneralAPSE, Long> id;
	public static volatile SingularAttribute<AtencionGeneralAPSE, Date> fechaAtencion;
	public static volatile SingularAttribute<AtencionGeneralAPSE, String> nombreApse;

}

