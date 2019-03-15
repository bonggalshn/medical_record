package com.rsporsea.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "t_pengobatan_pasien_rawat_jalan")
public class PengobatanJalan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_pengobatan_pasien_rawat_jalan")
	private Integer id_pengobatan_jalan;
	
	@Column(name="tanggal_pemeriksaan")
	private Date tanggal_pengobatan_jalan;
	
	@Column(name="diagnosa")
	private String diagnosa_jalan;
	
	@Column(name="dokter_pemeriksa")
	private Integer id_dokter_jalan;
	private Double berat_badan;
	private Double suhu_jalan;
	private Integer tekanan_darah_jalan;
	private String poli;
	
	@Column(name="hasil_pemeriksaan")
	private String detail_jalan;
	
	@Column(name="jenis_perawatan_pasien_rawat_jalan")
	private String terapi_jalan;
	private String obat_jalan;
	private String keterangan;
	private Integer id_pasien;
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
	public Integer getId_pengobatan_jalan() {
		return id_pengobatan_jalan;
	}
	public void setId_pengobatan_jalan(Integer id_pengobatan_jalan) {
		this.id_pengobatan_jalan = id_pengobatan_jalan;
	}
	public Date getTanggal_pengobatan_jalan() {
		return tanggal_pengobatan_jalan;
	}
	public void setTanggal_pengobatan_jalan(Date tanggal_pengobatan_jalan) {
		this.tanggal_pengobatan_jalan = tanggal_pengobatan_jalan;
	}
	public String getDiagnosa_jalan() {
		return diagnosa_jalan;
	}
	public void setDiagnosa_jalan(String diagnosa_jalan) {
		this.diagnosa_jalan = diagnosa_jalan;
	}
	public Integer getId_dokter_jalan() {
		return id_dokter_jalan;
	}
	public void setId_dokter_jalan(Integer id_dokter_jalan) {
		this.id_dokter_jalan = id_dokter_jalan;
	}
	public Double getBerat_badan() {
		return berat_badan;
	}
	public void setBerat_badan(Double berat_badan) {
		this.berat_badan = berat_badan;
	}
	public Double getSuhu_jalan() {
		return suhu_jalan;
	}
	public void setSuhu_jalan(Double suhu_jalan) {
		this.suhu_jalan = suhu_jalan;
	}
	public Integer getTekanan_darah_jalan() {
		return tekanan_darah_jalan;
	}
	public void setTekanan_darah_jalan(Integer tekanan_darah_jalan) {
		this.tekanan_darah_jalan = tekanan_darah_jalan;
	}
	public String getDetail_jalan() {
		return detail_jalan;
	}
	public void setDetail_jalan(String detail_jalan) {
		this.detail_jalan = detail_jalan;
	}
	public String getTerapi_jalan() {
		return terapi_jalan;
	}
	public void setTerapi_jalan(String terapi_jalan) {
		this.terapi_jalan = terapi_jalan;
	}
	public String getObat_jalan() {
		return obat_jalan;
	}
	public void setObat_jalan(String obat_jalan) {
		this.obat_jalan = obat_jalan;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
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
	public String getPoli() {
		return poli;
	}
	public void setPoli(String poli) {
		this.poli = poli;
	}
	
	
	
}
