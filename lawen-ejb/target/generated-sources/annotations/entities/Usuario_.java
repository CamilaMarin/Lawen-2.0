package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> rut;
	public static volatile SingularAttribute<Usuario, String> apellidoPaterno_usuario;
	public static volatile SingularAttribute<Usuario, String> password;
	public static volatile SingularAttribute<Usuario, TipoUsuario> tipousuario;
	public static volatile SingularAttribute<Usuario, String> correo;
	public static volatile SingularAttribute<Usuario, String> nombres_usuario;
	public static volatile SingularAttribute<Usuario, String> telefono1;
	public static volatile SingularAttribute<Usuario, String> telefono2;
	public static volatile SingularAttribute<Usuario, Long> id;
	public static volatile SingularAttribute<Usuario, Boolean> habilitado;
	public static volatile SingularAttribute<Usuario, String> apellidoMaterno_usuario;

}

