package com.rsporsea.model;

import java.sql.Date;

//import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "t_dokter")
public class Dokter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_dokter;
	
	private String NIP;
	private String nama_dokter;
	private String spesialis_dokter;
	private String jenis_kelamin;
	private String tempat_lahir;
	private Date tanggal_lahir_dokter;
	private String alamat;
	private String no_telepon;
	private String status;
	
	@Version
	@Column(name="optVersion", columnDefinition = "integer Default 0")
	private Integer version;
	
	public String getNIP() {
		return NIP;
	}
	public void setNIP(String nIP) {
		this.NIP = nIP;
	}
	public Integer getId_dokter() {
		return id_dokter;
	}
	public void setId_dokter(Integer id_dokter) {
		this.id_dokter = id_dokter;
	}
	public String getNama_dokter() {
		return nama_dokter;
	}
	public void setNama_dokter(String nama_dokter) {
		this.nama_dokter = nama_dokter;
	}
	public String getSpesialis_dokter() {
		return spesialis_dokter;
	}
	public void setSpesialis_dokter(String spesialis_dokter) {
		this.spesialis_dokter = spesialis_dokter;
	}
	public Date getTanggal_lahir_dokter() {
		return tanggal_lahir_dokter;
	}
	public void setTanggal_lahir_dokter(Date tanggal_lahir_dokter) {
		this.tanggal_lahir_dokter = tanggal_lahir_dokter;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getJenis_kelamin() {
		return jenis_kelamin;
	}
	public void setJenis_kelamin(String jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}
	public String getTempat_lahir() {
		return tempat_lahir;
	}
	public void setTempat_lahir(String tempat_lahir) {
		this.tempat_lahir = tempat_lahir;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getNo_telepon() {
		return no_telepon;
	}
	public void setNo_telepon(String no_telepon) {
		this.no_telepon = no_telepon;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}


