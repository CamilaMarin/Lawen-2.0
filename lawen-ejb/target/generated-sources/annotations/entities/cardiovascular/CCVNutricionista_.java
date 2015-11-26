package entities.cardiovascular;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CCVNutricionista.class)
public abstract class CCVNutricionista_ {

	public static volatile SingularAttribute<CCVNutricionista, FichaNutricionista> fichaNutri;
	public static volatile SingularAttribute<CCVNutricionista, CartolaSeguimientoCCV> cartolaToNutri;
	public static volatile SingularAttribute<CCVNutricionista, Date> fechaAtencionNutri;
	public static volatile SingularAttribute<CCVNutricionista, Long> id;

}

