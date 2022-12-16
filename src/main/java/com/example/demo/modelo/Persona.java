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
@Table(name= "tb_persona")
public class Persona {

	@Id
	@Column(name = "persona_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personaCodigo;

	@Column(name = "persona_tipo_identificacion", length = 3,nullable = false, columnDefinition = "text")
	private String personaTipoIdentificacion ;


	@Column(name = "persona_identificacion", nullable = false, columnDefinition = "text")
	private String personaIdentificacion ;

	@Column(name = "persona_nombre1", nullable = false, columnDefinition = "text")
	private String personaNombre1;

	@Column(name = "persona_nombre2", columnDefinition = "text")
	private String personaNombre2;


	@Column(name = "persona_apellido1",nullable = false ,columnDefinition = "text")
	private String personaApellido1;

	@Column(name = "persona_apellido2",columnDefinition = "text")
	private String personaApellido2;

	@Column(name = "persona_telefono",nullable= false, columnDefinition = "text")
	private String personaTelefono;

	@Column(name = "persona_arl_ruta",columnDefinition = "text")
	private String personaArlRuta;

	@Column(name = "persona_arl_archivo",columnDefinition = "text")
	private String personaArlArchivo;

	@Column(name = "persona_eps_ruta",columnDefinition = "text")
	private String personaEpsRuta;

	@Column(name = "persona_eps_archivo",columnDefinition = "text")
	private String personaEpsArchivo;

	@Column(name = "persona_fecha_creacion", nullable = false, updatable = false)
	private LocalDateTime personaFechaCreacion = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "usuario_codigo",foreignKey=@ForeignKey(name = "persona_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuario on update restrict on delete restrict"))
	Usuario usuario;



	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(Long personaCodigo, String personaTipoIdentificacion, String personaIdentificacion,
			String personaNombre1, String personaNombre2, String personaApellido1, String personaApellido2,
			String personaTelefono, String personaArlRuta, String personaArlArchivo, String personaEpsRuta,
			String personaEpsArchivo, LocalDateTime personaFechaCreacion, Usuario usuario) {
		super();
		this.personaCodigo = personaCodigo;
		this.personaTipoIdentificacion = personaTipoIdentificacion;
		this.personaIdentificacion = personaIdentificacion;
		this.personaNombre1 = personaNombre1;
		this.personaNombre2 = personaNombre2;
		this.personaApellido1 = personaApellido1;
		this.personaApellido2 = personaApellido2;
		this.personaTelefono = personaTelefono;
		this.personaArlRuta = personaArlRuta;
		this.personaArlArchivo = personaArlArchivo;
		this.personaEpsRuta = personaEpsRuta;
		this.personaEpsArchivo = personaEpsArchivo;
		this.personaFechaCreacion = personaFechaCreacion;
		this.usuario = usuario;
	}

	public Long getPersonaCodigo() {
		return personaCodigo;
	}

	public void setPersonaCodigo(Long personaCodigo) {
		this.personaCodigo = personaCodigo;
	}

	public String getPersonaTipoIdentificacion() {
		return personaTipoIdentificacion;
	}

	public void setPersonaTipoIdentificacion(String personaTipoIdentificacion) {
		this.personaTipoIdentificacion = personaTipoIdentificacion;
	}

	public String getPersonaIdentificacion() {
		return personaIdentificacion;
	}

	public void setPersonaIdentificacion(String personaIdentificacion) {
		this.personaIdentificacion = personaIdentificacion;
	}

	public String getPersonaNombre1() {
		return personaNombre1;
	}

	public void setPersonaNombre1(String personaNombre1) {
		this.personaNombre1 = personaNombre1;
	}

	public String getPersonaNombre2() {
		return personaNombre2;
	}

	public void setPersonaNombre2(String personaNombre2) {
		this.personaNombre2 = personaNombre2;
	}

	public String getPersonaApellido1() {
		return personaApellido1;
	}

	public void setPersonaApellido1(String personaApellido1) {
		this.personaApellido1 = personaApellido1;
	}

	public String getPersonaApellido2() {
		return personaApellido2;
	}

	public void setPersonaApellido2(String personaApellido2) {
		this.personaApellido2 = personaApellido2;
	}

	public String getPersonaTelefono() {
		return personaTelefono;
	}

	public void setPersonaTelefono(String personaTelefono) {
		this.personaTelefono = personaTelefono;
	}

	public String getPersonaArlRuta() {
		return personaArlRuta;
	}

	public void setPersonaArlRuta(String personaArlRuta) {
		this.personaArlRuta = personaArlRuta;
	}

	public String getPersonaArlArchivo() {
		return personaArlArchivo;
	}

	public void setPersonaArlArchivo(String personaArlArchivo) {
		this.personaArlArchivo = personaArlArchivo;
	}

	public String getPersonaEpsRuta() {
		return personaEpsRuta;
	}

	public void setPersonaEpsRuta(String personaEpsRuta) {
		this.personaEpsRuta = personaEpsRuta;
	}

	public String getPersonaEpsArchivo() {
		return personaEpsArchivo;
	}

	public void setPersonaEpsArchivo(String personaEpsArchivo) {
		this.personaEpsArchivo = personaEpsArchivo;
	}

	public LocalDateTime getPersonaFechaCreacion() {
		return personaFechaCreacion;
	}

	public void setPersonaFechaCreacion(LocalDateTime personaFechaCreacion) {
		this.personaFechaCreacion = personaFechaCreacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}




}
