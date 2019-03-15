package com.rsporsea.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="viewjkinap")
public class viewjkinap {
	
	@Id
	private Integer id;
	private Integer jumlah;
	private Integer Pria;
	private Integer Wanita;
	public Integer getId() {
		return id;
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
