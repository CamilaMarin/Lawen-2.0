package entities.cardiovascular;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CCVEnfermero.class)
public abstract class CCVEnfermero_ {

	public static volatile SingularAttribute<CCVEnfermero, Long> id;
	public static volatile SingularAttribute<CCVEnfermero, Date> fechaAtencionEnf;
	public static volatile SingularAttribute<CCVEnfermero, CartolaSeguimientoCCV> cartolaToEnf;
	public static volatile SingularAttribute<CCVEnfermero, FichaEnfermero> fichaEnf;

}

