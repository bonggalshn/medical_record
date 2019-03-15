package com.rsporsea.model;

import javax.persistence.*;

@Entity
@Table(name = "t_akun")
public class Akun {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_akun;
	
//	@Column(name = "role")
	private String role;
	private String username;
	private String password;
	
	public Integer getId_akun() {
		return id_akun;
	}
	public void setId_akun(Integer id_akun) {
		this.id_akun = id_akun;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
