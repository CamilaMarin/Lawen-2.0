package entities.pediatria;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CartolaControlesNino.class)
public abstract class CartolaControlesNino_ {

	public static volatile ListAttribute<CartolaControlesNino, ControlNino> controles;
	public static volatile SingularAttribute<CartolaControlesNino, Long> id;
	public static volatile SingularAttribute<CartolaControlesNino, PacienteNino> pacienteNino;

}

