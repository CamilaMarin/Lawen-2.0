package entities.cardiovascular;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CCVMedico.class)
public abstract class CCVMedico_ {

	public static volatile SingularAttribute<CCVMedico, Long> id;
	public static volatile SingularAttribute<CCVMedico, FichaMedico> fichaMed;
	public static volatile SingularAttribute<CCVMedico, CartolaSeguimientoCCV> cartola;
	public static volatile SingularAttribute<CCVMedico, Date> fechaAtencionMed;

}

