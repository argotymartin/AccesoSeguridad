package com.example.demo.modelo;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_usuario")

public class Usuario {

	@Id
	@Column(name = "usuario_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioCodigo;

	@Column(name = "usuario_login", nullable = false, columnDefinition = "text")
	private String usuarioLogin;

	@Column(name = "usuario_nombre", nullable = false, columnDefinition = "text")
	private String usuarioNombre;

	@Column(name = "usuario_clave", nullable = false, columnDefinition = "text")
	private String usuarioClave;

	@Column(name = "usuario_fecha_creacion", nullable = false, updatable = false)
	private LocalDateTime usuarioFechaCreacion = LocalDateTime.now();


	@Column(name = "usuario_codigo_creacion", nullable = false)
	private long usuarioCodigoCreacion;


	public Usuario(Long usuarioCodigo, String usuarioLogin, String usuarioNombre, String usuarioClave,
			LocalDateTime usuarioFechaCreacion, long usuarioCodigoCreacion) {
		super();
		this.usuarioCodigo = usuarioCodigo;
		this.usuarioLogin = usuarioLogin;
		this.usuarioNombre = usuarioNombre;
		this.usuarioClave = usuarioClave;
		this.usuarioFechaCreacion = usuarioFechaCreacion;
		this.usuarioCodigoCreacion = usuarioCodigoCreacion;
	}


	public Long getUsuarioCodigo() {
		return usuarioCodigo;
	}


	public void setUsuarioCodigo(Long usuarioCodigo) {
		this.usuarioCodigo = usuarioCodigo;
	}


	public String getUsuarioLogin() {
		return usuarioLogin;
	}


	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}


	public String getUsuarioNombre() {
		return usuarioNombre;
	}


	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}


	public String getUsuarioClave() {
		return usuarioClave;
	}


	public void setUsuarioClave(String usuarioClave) {
		this.usuarioClave = usuarioClave;
	}


	public LocalDateTime getUsuarioFechaCreacion() {
		return usuarioFechaCreacion;
	}


	public void setUsuarioFechaCreacion(LocalDateTime usuarioFechaCreacion) {
		this.usuarioFechaCreacion = usuarioFechaCreacion;
	}


	public long getUsuarioCodigoCreacion() {
		return usuarioCodigoCreacion;
	}


	public void setUsuarioCodigoCreacion(long usuarioCodigoCreacion) {
		this.usuarioCodigoCreacion = usuarioCodigoCreacion;
	}


}
