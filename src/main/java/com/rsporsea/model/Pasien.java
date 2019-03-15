package com.rsporsea.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name = "t_pasien")
public class Pasien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_pasien;
//	private Integer no_rm;
	private String nama_pasien;
	private String jenis_kelamin;
	private String NIK;
	private String tempat_lahir;
	private Date tanggal_lahir;
	private String alamat;
	private String pekerjaan;
	private String status;
	private String nomor_rekam_medik;
	
	@Version
	@Column(name="optVersion", columnDefinition = "integer Default 0")
	private Integer version;
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getId_pasien() {
		return id_pasien;
	}
	public void setId_pasien(Integer id_pasien) {
		this.id_pasien = id_pasien;
	}
	public String getNama_pasien() {
		return nama_pasien;
	}
	public void setNama_pasien(String nama_pasien) {
		this.nama_pasien = nama_pasien;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getJenis_kelamin() {
		return jenis_kelamin;
	}
	public void setJenis_kelamin(String jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}
	public String getNIK() {
		return NIK;
	}
	public void setNIK(String nIK) {
		NIK = nIK;
	}
	public String getTempat_lahir() {
		return tempat_lahir;
	}
	public void setTempat_lahir(String tempat_lahir) {
		this.tempat_lahir = tempat_lahir;
	}
	public Date getTanggal_lahir() {
		return tanggal_lahir;
	}
	public void setTanggal_lahir(Date tanggal_lahir) {
		this.tanggal_lahir = tanggal_lahir;
	}
	public String getPekerjaan() {
		return pekerjaan;
	}
	public void setPekerjaan(String pekerjaan) {
		this.pekerjaan = pekerjaan;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNomor_rekam_medik() {
		return nomor_rekam_medik;
	}
	public void setNomor_rekam_medik(String nomor_rekam_medik) {
		this.nomor_rekam_medik = nomor_rekam_medik;
	}
	
	
	
}
