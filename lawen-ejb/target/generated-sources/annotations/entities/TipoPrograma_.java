package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TipoPrograma.class)
public abstract class TipoPrograma_ {

	public static volatile SingularAttribute<TipoPrograma, Long> id;
	public static volatile ListAttribute<TipoPrograma, Programa> programas;
	public static volatile SingularAttribute<TipoPrograma, String> nombre_programa;

}

