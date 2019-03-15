package com.rsporsea.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "t_pengobatan_pasien_rawat_inap")
public class PengobatanInap {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_pengobatan_rawat_inap")
	private Integer id_pengobatan_inap;
	
	private Date tanggal_masuk;
	
	@Column(name="diagnosa")
	private String diagnosa_inap;
	
	@Column(name="dokter_pemeriksa_rawat_inap")
	private Integer id_dokter_inap;
	private Double berat_inap;
	private Double suhu_inap;
	private Integer tekanan_darah_inap;
	private String detail_inap;
	private String proses_keluar;
	private String keterangan;
	private String status;
	
	@Column(name="jenis_perawatan_pasien_rawat_inap")
	private String jenis_perawatan;
	private Integer id_pasien;
	
	@Version
	@Column(name="optVersion", columnDefinition = "integer Default 0")
	private Integer version;
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public Integer getId_pengobatan_inap() {
		return id_pengobatan_inap;
	}
	public void setId_pengobatan_inap(Integer id_pengobatan_inap) {
		this.id_pengobatan_inap = id_pengobatan_inap;
	}
	public Date getTanggal_masuk() {
		return tanggal_masuk;
	}
	public void setTanggal_masuk(Date tanggal_masuk) {
		this.tanggal_masuk = tanggal_masuk;
	}
	public String getDiagnosa_inap() {
		return diagnosa_inap;
	}
	public void setDiagnosa_inap(String diagnosa_inap) {
		this.diagnosa_inap = diagnosa_inap;
	}
	public Integer getId_dokter_inap() {
		return id_dokter_inap;
	}
	public void setId_dokter_inap(Integer id_dokter_inap) {
		this.id_dokter_inap = id_dokter_inap;
	}
	public Double getBerat_inap() {
		return berat_inap;
	}
	public void setBerat_inap(Double berat_inap) {
		this.berat_inap = berat_inap;
	}
	public Double getSuhu_inap() {
		return suhu_inap;
	}
	public void setSuhu_inap(Double suhu_inap) {
		this.suhu_inap = suhu_inap;
	}
	public Integer getTekanan_darah_inap() {
		return tekanan_darah_inap;
	}
	public void setTekanan_darah_inap(Integer tekanan_darah_inap) {
		this.tekanan_darah_inap = tekanan_darah_inap;
	}
	public String getDetail_inap() {
		return detail_inap;
	}
	public void setDetail_inap(String detail_inap) {
		this.detail_inap = detail_inap;
	}
	public String getProses_keluar() {
		return proses_keluar;
	}
	public void setProses_keluar(String proses_keluar) {
		this.proses_keluar = proses_keluar;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public String getJenis_perawatan() {
		return jenis_perawatan;
	}
	public void setJenis_perawatan(String jenis_perawatan) {
		this.jenis_perawatan = jenis_perawatan;
	}
	public Integer getId_pasien() {
		return id_pasien;
	}
	public void setId_pasien(Integer id_pasien) {
		this.id_pasien = id_pasien;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
