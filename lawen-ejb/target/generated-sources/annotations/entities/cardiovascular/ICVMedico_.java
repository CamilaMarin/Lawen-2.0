package entities.cardiovascular;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ICVMedico.class)
public abstract class ICVMedico_ {

	public static volatile SingularAttribute<ICVMedico, Long> id;
	public static volatile SingularAttribute<ICVMedico, FichaMedico> fichaMed;
	public static volatile SingularAttribute<ICVMedico, CartolaSeguimientoCCV> cartola;
	public static volatile SingularAttribute<ICVMedico, Date> fechaAtencionMed;

}

