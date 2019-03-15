package com.rsporsea.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="viewpengobataninap")
public class viewpengobataninap {
	@Id
	private Integer id_inap;
	private Integer berat;
	private String diagnosa;
	private String dokter;
	private String keterangan;
	private String detail;
	private Integer suhu;
	private Date masuk;
	private Integer darah;
	private String jenis_perawatan;
	private Integer id_pasien;
	private String proses_keluar;
	
	public Integer getId_inap() {
		return id_inap;
	}
	public void setId_inap(Integer id_inap) {
		this.id_inap = id_inap;
	}
	public Date getMasuk() {
		return masuk;
	}
	public void setMasuk(Date masuk) {
		this.masuk = masuk;
	}
	public Integer getDarah() {
		return darah;
	}
	public void setDarah(Integer darah) {
		this.darah = darah;
	}
	public String getJenis_perawatan() {
		return jenis_perawatan;
	}
	public void setJenis_perawatan(String jenis_perawatan) {
		this.jenis_perawatan = jenis_perawatan;
	}	
	public Integer getId() {
		return id_inap;
	}
	public void setId(Integer id) {
		this.id_inap = id;
	}
	public Integer getBerat() {
		return berat;
	}
	public void setBerat(Integer berat) {
		this.berat = berat;
	}
	
	public String getDiagnosa() {
		return diagnosa;
	}
	public void setDiagnosa(String diagnosa) {
		this.diagnosa = diagnosa;
	}
	public String getDokter() {
		return dokter;
	}
	public void setDokter(String dokter) {
		this.dokter = dokter;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public Integer getSuhu() {
		return suhu;
	}
	public void setSuhu(Integer suhu) {
		this.suhu = suhu;
	}
	public Integer getId_pasien() {
		return id_pasien;
	}
	public void setId_pasien(Integer id_pasien) {
		this.id_pasien = id_pasien;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getProses_keluar() {
		return proses_keluar;
	}
	public void setProses_keluar(String proses_keluar) {
		this.proses_keluar = proses_keluar;
	}
	
	
}
