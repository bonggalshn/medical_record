package com.rsporsea.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pjalan")
public class pjalan {
	@Id
	private Integer id;
	private String penyakit;
	private Integer total;
	private Integer bulan;
	private Integer tahun;
	
	public Integer getId() {
		return id;
	}
	public Integer getTotal() {
		return total;
	}
	public String getPenyakit() {
		return penyakit;
	}
	public Integer getBulan() {
		return bulan;
	}
	public Integer getTahun() {
		return tahun;
	}
	
}
