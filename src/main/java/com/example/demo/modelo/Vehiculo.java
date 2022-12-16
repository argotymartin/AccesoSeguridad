//package com.example.demo.modelo;
//
//import java.time.LocalDateTime;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name= "tb_vehicleacceso")
//public class Vehiculo {
//
//	@Id
//	@Column(name = "vehacc_codigo")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long vehaccCodigo;
//
//	@Column(name = "vehacc_placa", nullable = false, columnDefinition = "text")
//	private String vehaccPlaca;
//
//	@Column(name = "vehacc_color", nullable = false, columnDefinition = "text")
//	private String vehaccColor;
//
//
//	@Column(name = "vehacc_fecha_creacion", nullable = false, updatable = false)
//	private LocalDateTime vehaccFechaCreacion = LocalDateTime.now();
//
//
//	@ManyToOne
//	@JoinColumn(name = "clase_vehiculo_codigo",foreignKey=@ForeignKey(name = "vehicleacceso_fk_clase_vehiculo_codigo", foreignKeyDefinition = "foreign key (clase_vehiculo_codigo) references tb_clase_vehiculo on update restrict on delete restrict"))
//	ClaseVehiculo clasevehiculo;
//
//	@ManyToOne
//	@JoinColumn(name = "usuario_codigo"        ,foreignKey=@ForeignKey(name = "vehiculo_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuario on update restrict on delete restrict"))
//	Usuario usuario;
//
//
//	public Vehiculo() {
//		super();
//	}
//
//	public Vehiculo(Long vehaccCodigo, String vehaccPlaca, String vehaccColor, LocalDateTime vehaccFechaCreacion,
//			ClaseVehiculo clasevehiculo, Usuario usuario) {
//		super();
//		this.vehaccCodigo = vehaccCodigo;
//		this.vehaccPlaca = vehaccPlaca;
//		this.vehaccColor = vehaccColor;
//		this.vehaccFechaCreacion = vehaccFechaCreacion;
//		this.clasevehiculo = clasevehiculo;
//		this.usuario = usuario;
//	}
//
//	public Long getVehaccCodigo() {
//		return vehaccCodigo;
//	}
//
//	public void setVehaccCodigo(Long vehaccCodigo) {
//		this.vehaccCodigo = vehaccCodigo;
//	}
//
//	public String getVehaccPlaca() {
//		return vehaccPlaca;
//	}
//
//	public void setVehaccPlaca(String vehaccPlaca) {
//		this.vehaccPlaca = vehaccPlaca;
//	}
//
//	public String getVehaccColor() {
//		return vehaccColor;
//	}
//
//	public void setVehaccColor(String vehaccColor) {
//		this.vehaccColor = vehaccColor;
//	}
//
//	public LocalDateTime getVehaccFechaCreacion() {
//		return vehaccFechaCreacion;
//	}
//
//	public void setVehaccFechaCreacion(LocalDateTime vehaccFechaCreacion) {
//		this.vehaccFechaCreacion = vehaccFechaCreacion;
//	}
//
//	public ClaseVehiculo getClasevehiculo() {
//		return clasevehiculo;
//	}
//
//	public void setClasevehiculo(ClaseVehiculo clasevehiculo) {
//		this.clasevehiculo = clasevehiculo;
//	}
//
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
//
//
//
//
//}
