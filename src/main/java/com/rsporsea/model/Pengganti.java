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
@Table(name = "t_jadwal_dokter_pengganti")
public class Pengganti {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_jadwal_pengganti;
	
	@Column(name="nama_dokter_berhalangan")
	private Integer dokter_berhalangan;
//	private String spesialis_pengganti;
	
	@Column(name="nama_dokter_pengganti")
	private Integer dokter_pengganti;
	
	@Column(name="tanggal_pergantian_mulai")
	private Date tanggal_pengganti_mulai;
	
	@Column(name="tanggal_pergantian_selesai")
	private Date tanggal_pengganti_selesai;
	private String keterangan;
	private String status;
	
	@Version
	@Column(name="optVersion", columnDefinition = "integer Default 0")
	private Integer version;
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getId_jadwal_pengganti() {
		return id_jadwal_pengganti;
	}
	public void setId_jadwal_pengganti(Integer id_jadwal_pengganti) {
		this.id_jadwal_pengganti = id_jadwal_pengganti;
	}
	public Integer getDokter_berhalangan() {
		return dokter_berhalangan;
	}
	public void setDokter_berhalangan(Integer dokter_berhalangan) {
		this.dokter_berhalangan = dokter_berhalangan;
	}
//	public String getSpesialis_pengganti() {
//		return spesialis_pengganti;
//	}
//	public void setSpesialis_pengganti(String spesialis_pengganti) {
//		this.spesialis_pengganti = spesialis_pengganti;
//	}
	public Integer getDokter_pengganti() {
		return dokter_pengganti;
	}
	public void setDokter_pengganti(Integer dokter_pengganti) {
		this.dokter_pengganti = dokter_pengganti;
	}
	public Date getTanggal_pengganti_mulai() {
		return tanggal_pengganti_mulai;
	}
	public void setTanggal_pengganti_mulai(Date tanggal_pengganti_mulai) {
		this.tanggal_pengganti_mulai = tanggal_pengganti_mulai;
	}
	public Date getTanggal_pengganti_selesai() {
		return tanggal_pengganti_selesai;
	}
	public void setTanggal_pengganti_selesai(Date tanggal_pengganti_selesai) {
		this.tanggal_pengganti_selesai = tanggal_pengganti_selesai;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
