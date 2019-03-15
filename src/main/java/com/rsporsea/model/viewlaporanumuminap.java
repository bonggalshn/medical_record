package com.rsporsea.model;

//import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="viewlaporanumuminap")
public class viewlaporanumuminap {

	@Id
	private Integer id;
	private Integer tahun;
	private Integer bulan;
	private Integer jumlah;
	private Integer Pria;
	private Integer Wanita;
	
	public Integer getId() {
		return id;
	}
	public Integer getTahun() {
		return tahun;
	}
	public Integer getBulan() {
		return bulan;
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
