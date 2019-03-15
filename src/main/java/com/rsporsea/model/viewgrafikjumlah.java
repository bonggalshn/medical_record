package com.rsporsea.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="viewgrafikjumlah")
public class viewgrafikjumlah {
	
	@Id
	private Integer id;
	private Integer tahun;
	private Integer jumlah;
	private Integer Pria;
	private Integer Wanita;
	public Integer getId() { 
		return id;
	}
	public Integer getTahun() {
		return tahun;
	}
	public Integer getJumlah() {
		return jumlah;
	}
	public Integer getPria() {
		return Pria;
	}
	public Integer getWanita() {
		return Wanita;
	}
	
	
}
