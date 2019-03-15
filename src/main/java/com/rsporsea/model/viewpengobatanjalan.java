package com.rsporsea.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="viewpengobatanjalan")
public class viewpengobatanjalan {
	@Id
	private Integer id;
	private Integer berat;
	private String hasil;
	private String diagnosa;
	private String dokter;
	private String poli;
	private String keterangan;
	private String obat;
	private Integer suhu;
	private Date tanggal;
	private Integer tekanan;
	private String perawatan;
	private Integer id_pasien;
	
	public Integer getId() {
		return id;
	}
	public Integer getBerat() {
		return berat;
	}
	public String getHasil() {
		return hasil;
	}
	public String getDiagnosa() {
		return diagnosa;
	}
	public String getDokter() {
		return dokter;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public String getObat() {
		return obat;
	}
	public Integer getSuhu() {
		return suhu;
	}
	public Date getTanggal() {
		return tanggal;
	}
	public Integer getTekanan() {
		return tekanan;
	}
	public String getPerawatan() {
		return perawatan;
	}
	public Integer getId_pasien() {
		return id_pasien;
	}
	public String getPoli() {
		return poli;
	}
	public void setPoli(String poli) {
		this.poli = poli;
	}
	
	
}
