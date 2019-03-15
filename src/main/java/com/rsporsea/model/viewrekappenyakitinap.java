package com.rsporsea.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="viewrekappenyakitinap")
public class viewrekappenyakitinap {
	
	@Id
	private Integer id;
	private String diagnosa;
	private Integer jumlah;
	private Integer tahun;
	
	public Integer getId() {
		return id;
	}
	public String getDiagnosa() {
		return diagnosa;
	}
	public Integer getJumlah() {
		return jumlah;
	}
	public Integer getTahun() {
		return tahun;
	}
}
