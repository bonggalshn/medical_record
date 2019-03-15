package com.rsporsea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "t_jadwal_dokter")
public class Jadwal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_jadwal;
	private String hari_mulai;
	private String hari_selesai;
	private String jam_mulai;
	private String jam_selesai;
	
	@Column(name="nama_dokter")
	private Integer id_dokter;
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
	public Integer getId_jadwal() {
		return id_jadwal;
	}
	public void setId_jadwal(Integer id_jadwal) {
		this.id_jadwal = id_jadwal;
	}
	public String getHari_mulai() {
		return hari_mulai;
	}
	public void setHari_mulai(String hari_mulai) {
		this.hari_mulai = hari_mulai;
	}
	public String getHari_selesai() {
		return hari_selesai;
	}
	public void setHari_selesai(String hari_selesai) {
		this.hari_selesai = hari_selesai;
	}
	public String getJam_mulai() {
		return jam_mulai;
	}
	public void setJam_mulai(String jam_mulai) {
		this.jam_mulai = jam_mulai;
	}
	public String getJam_selesai() {
		return jam_selesai;
	}
	public void setJam_selesai(String jam_selesai) {
		this.jam_selesai = jam_selesai;
	}
	public Integer getId_dokter() {
		return id_dokter;
	}
	public void setId_dokter(Integer id_dokter) {
		this.id_dokter = id_dokter;
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
