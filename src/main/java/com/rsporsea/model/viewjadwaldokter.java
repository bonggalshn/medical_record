package com.rsporsea.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="viewjadwaldokter")
public class viewjadwaldokter {
	
	@Id
	private Integer id_jadwal;
	private String mulai;
	private String selesai;
	private Integer senin;
	private Integer selasa;
	private Integer rabu;
	private Integer kamis;
	private Integer jumat;
	private Integer sabtu;
	private Integer minggu;
	private String nama_dokter;
	private String spesialis;
	private String status;
	private String keterangan;
	private Integer id_dokter;
	private String nip;
	
	public Integer getId_jadwal() {
		return id_jadwal;
	}
	public String getMulai() {
		return mulai;
	}
	public String getSelesai() {
		return selesai;
	}
	public Integer getSenin() {
		return senin;
	}
	public Integer getSelasa() {
		return selasa;
	}
	public Integer getRabu() {
		return rabu;
	}
	public Integer getKamis() {
		return kamis;
	}
	public Integer getJumat() {
		return jumat;
	}
	public Integer getSabtu() {
		return sabtu;
	}
	public Integer getMinggu() {
		return minggu;
	}
	public String getNama_dokter() {
		return nama_dokter;
	}
	public String getSpesialis() {
		return spesialis;
	}
	public String getStatus() {
		return status;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public Integer getIdDokter() {
		return id_dokter;
	}
	public String getNip() {
		return nip;
	}
	
	

}
