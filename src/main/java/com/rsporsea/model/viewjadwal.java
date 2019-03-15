package com.rsporsea.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="viewjadwal")
public class viewjadwal {
	
	@Id
	private Integer id_jadwal;
	private String hari_mulai;
	private String hari_selesai;
	private Integer id_dokter;
	private String jam_mulai;
	private String jam_selesai;
	private String keterangan;
	private String nip;
	private String nama_dokter;
	private String spesialis_dokter;
	
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
	public Integer getId_dokter() {
		return id_dokter;
	}
	public void setId_dokter(Integer id_dokter) {
		this.id_dokter = id_dokter;
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
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
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
	

}
