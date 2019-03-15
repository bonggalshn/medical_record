package com.rsporsea.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="viewpengganti")
public class viewpengganti {
	
	@Id
	private Integer id;
	private String berhalangan;
	private String pengganti;
	private String spesialis;
	private Date mulai;
	private Date selesai;
	private String keterangan;
	
	public Integer getId() {
		return id;
	}
	public String getBerhalangan() {
		return berhalangan;
	}
	public String getPengganti() {
		return pengganti;
	}
	public String getSpesialis() {
		return spesialis;
	}
	public Date getMulai() {
		return mulai;
	}
	public Date getSelesai() {
		return selesai;
	}
	public String getKeterangan() {
		return keterangan;
	}
	
	

}
