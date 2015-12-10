package entities.cardiovascular;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ICVNutricionista.class)
public abstract class ICVNutricionista_ {

	public static volatile SingularAttribute<ICVNutricionista, FichaNutricionista> fichaNutri;
	public static volatile SingularAttribute<ICVNutricionista, CartolaSeguimientoCCV> cartolaToNutri;
	public static volatile SingularAttribute<ICVNutricionista, Date> fechaAtencionNutri;
	public static volatile SingularAttribute<ICVNutricionista, Long> id;

}

