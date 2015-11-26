package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Patologia.class)
public abstract class Patologia_ {

	public static volatile SingularAttribute<Patologia, TipoPatologia> patologia;
	public static volatile SingularAttribute<Patologia, Paciente> paciente;
	public static volatile SingularAttribute<Patologia, Long> id;

}

