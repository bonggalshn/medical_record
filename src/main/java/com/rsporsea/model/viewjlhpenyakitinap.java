package com.rsporsea.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="viewjlhpenyakitinap")
public class viewjlhpenyakitinap {
	
	@Id
	private Integer id;
	private String diagnosa;
	private Integer jumlah;
	
	public Integer getId() {
		return id;
	}
	public String getDiagnosa() {
		return diagnosa;
	}
	public Integer getJumlah() {
		return jumlah;
	}
	
	
}
