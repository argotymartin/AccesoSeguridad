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
@Table(name= "tb_clase_vehiculo")

public class ClaseVehiculo  {
	@Id
	@Column(name = "clase_vehiculo_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long claseVehiculoCodigo;

	@Column(name = "clase_vehiculo_nombre", nullable = false, columnDefinition = "text")
	private String claseVehiculoNombre;

	@Column(name = "clase_vehiculo_fecha_creacion", nullable = false, updatable = false)
	private LocalDateTime claseVehiculoFechaCreacion = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "usuario_codigo",foreignKey=@ForeignKey(name = "clasevehiculo_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuario on update restrict on delete restrict"))
	Usuario usuario;

	public ClaseVehiculo() {
		super();
	}
	public ClaseVehiculo(Long claseVehiculoCodigo, String claseVehiculoNombre, LocalDateTime claseVehiculoFechaCreacion,
			Usuario usuario) {
		super();
		this.claseVehiculoCodigo = claseVehiculoCodigo;
		this.claseVehiculoNombre = claseVehiculoNombre;
		this.claseVehiculoFechaCreacion = claseVehiculoFechaCreacion;
		this.usuario = usuario;
	}
	public Long getClaseVehiculoCodigo() {
		return claseVehiculoCodigo;
	}
	public void setClaseVehiculoCodigo(Long claseVehiculoCodigo) {
		this.claseVehiculoCodigo = claseVehiculoCodigo;
	}
	public String getClaseVehiculoNombre() {
		return claseVehiculoNombre;
	}
	public void setClaseVehiculoNombre(String claseVehiculoNombre) {
		this.claseVehiculoNombre = claseVehiculoNombre;
	}
	public LocalDateTime getClaseVehiculoFechaCreacion() {
		return claseVehiculoFechaCreacion;
	}
	public void setClaseVehiculoFechaCreacion(LocalDateTime claseVehiculoFechaCreacion) {
		this.claseVehiculoFechaCreacion = claseVehiculoFechaCreacion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
