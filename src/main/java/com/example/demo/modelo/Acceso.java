package com.example.demo.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_acceso")
public class Acceso {


	@Id
	@Column(name = "acceso_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accesoCodigo;


	@Column(name = "acceso_fecha_ingreso", nullable = false, updatable = false)
	private LocalDateTime accesoFechaIngreso = LocalDateTime.now();

	@Column(name = "acceso_fecha_salida", updatable = false)
	private LocalDateTime accesoFechaSalida = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "persona_codigo",foreignKey=@ForeignKey(name = "acceso_fk_persona_codigo", foreignKeyDefinition = "foreign key (persona_codigo) references tb_persona on update restrict on delete restrict"))
	Persona persona;


	@ManyToOne
	@JoinColumn(name = "usuario_codigo",foreignKey=@ForeignKey(name = "acceso_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuario on update restrict on delete restrict"))
	Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "dependencia_codigo",foreignKey=@ForeignKey(name = "dependencia_fk_dependencia_codigo", foreignKeyDefinition = "foreign key (dependencia_codigo) references tb_dependencia on update restrict on delete restrict"))
	Dependencia dependencia;

	@ManyToOne
	@JoinColumn(name = "clase_vehiculo_codigo",foreignKey=@ForeignKey(name = "acceso_fk_clase_vehiculo_codigo", foreignKeyDefinition = "foreign key (clase_vehiculo_codigo) references tb_clase_vehiculo on update restrict on delete restrict"))
	ClaseVehiculo clasevehiculo;

}
