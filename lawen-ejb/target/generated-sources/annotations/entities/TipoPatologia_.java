package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TipoPatologia.class)
public abstract class TipoPatologia_ {

	public static volatile ListAttribute<TipoPatologia, Patologia> patologias;
	public static volatile SingularAttribute<TipoPatologia, Long> id;
	public static volatile SingularAttribute<TipoPatologia, String> nombre_patologia;

}

