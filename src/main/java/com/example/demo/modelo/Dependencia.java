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
@Table(name="tb_dependencia")
public class Dependencia {
	@Id
	@Column(name = "dependencia_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dependenciaCodigo;

	@Column(name = "dependencia_nombre", nullable = false, columnDefinition = "text")
	private String dependenciaNombre;

	@Column(name = "dependencia_fecha_creacion", nullable = false, updatable = false)
	private LocalDateTime dependenciaFechaCreacion = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "usuario_codigo",foreignKey=@ForeignKey(name = "dependencia_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuario on update restrict on delete restrict"))
	Usuario usuario;



	public Dependencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dependencia(Long dependenciaCodigo, String dependenciaNombre, LocalDateTime dependenciaFechaCreacion,
			Usuario usuario) {
		super();
		this.dependenciaCodigo = dependenciaCodigo;
		this.dependenciaNombre = dependenciaNombre;
		this.dependenciaFechaCreacion = dependenciaFechaCreacion;
		this.usuario = usuario;
	}

	public Long getDependenciaCodigo() {
		return dependenciaCodigo;
	}

	public void setDependenciaCodigo(Long dependenciaCodigo) {
		this.dependenciaCodigo = dependenciaCodigo;
	}

	public String getDependenciaNombre() {
		return dependenciaNombre;
	}

	public void setDependenciaNombre(String dependenciaNombre) {
		this.dependenciaNombre = dependenciaNombre;
	}

	public LocalDateTime getDependenciaFechaCreacion() {
		return dependenciaFechaCreacion;
	}

	public void setDependenciaFechaCreacion(LocalDateTime dependenciaFechaCreacion) {
		this.dependenciaFechaCreacion = dependenciaFechaCreacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
