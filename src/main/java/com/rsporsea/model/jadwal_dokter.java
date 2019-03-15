package com.rsporsea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "jadwal_dokter")
public class jadwal_dokter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_jadwal;
	
	@Column(columnDefinition="default '0'")
	private Integer senin;
	@Column(columnDefinition="default '0'")
	private Integer selasa;
	@Column(columnDefinition="default '0'")
	private Integer rabu;
	@Column(columnDefinition="default '0'")
	private Integer kamis;
	@Column(columnDefinition="default '0'")
	private Integer jumat;
	@Column(columnDefinition="default '0'")
	private Integer sabtu;
	@Column(columnDefinition="default '0'")
	private Integer minggu;
	private Integer nama_dokter;
	private String jam_mulai;
	private String jam_selesai;
	private String keterangan;
	private String status;
	
	@Version
	@Column(name="optVersion", columnDefinition = "integer Default 0")
	private Integer version;

	public Integer getId_jadwal() {
		return id_jadwal;
	}

	public void setId_jadwal(Integer id_jadwal) {
		this.id_jadwal = id_jadwal;
	}

	public Integer getSenin() {
		return senin;
	}

	public void setSenin(Integer senin) {
		this.senin = senin;
	}

	public Integer getSelasa() {
		return selasa;
	}

	public void setSelasa(Integer selasa) {
		this.selasa = selasa;
	}

	public Integer getRabu() {
		return rabu;
	}

	public void setRabu(Integer rabu) {
		this.rabu = rabu;
	}

	public Integer getKamis() {
		return kamis;
	}

	public void setKamis(Integer kamis) {
		this.kamis = kamis;
	}

	public Integer getJumat() {
		return jumat;
	}

	public void setJumat(Integer jumat) {
		this.jumat = jumat;
	}

	public Integer getSabtu() {
		return sabtu;
	}

	public void setSabtu(Integer sabtu) {
		this.sabtu = sabtu;
	}

	public Integer getMinggu() {
		return minggu;
	}

	public void setMinggu(Integer minggu) {
		this.minggu = minggu;
	}

	public Integer getNama_dokter() {
		return nama_dokter;
	}

	public void setNama_dokter(Integer nama_dokter) {
		this.nama_dokter = nama_dokter;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	
}
