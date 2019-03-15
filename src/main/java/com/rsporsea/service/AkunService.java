package com.rsporsea.service;

import java.util.List;

import com.rsporsea.model.Akun;

public interface AkunService {
	List<Akun> getAllAkun();
	Akun login(String username, String password);
	Akun saveOrUpdate(Akun akun);
	Akun getAkun(Integer id_akun);
	void delete(Integer id_akun);
}
