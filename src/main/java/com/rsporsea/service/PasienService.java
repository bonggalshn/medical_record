package com.rsporsea.service;

import com.rsporsea.model.Pasien;
import com.rsporsea.model.viewtotalpasien;

import java.util.List;

public interface PasienService {
	List <Pasien> listPasien();
	Pasien saveOrUpdate(Pasien pasien);
	Pasien getIdPasien(Integer id_pasien);
	void hapusPasien(Integer id_pasien);
	Integer latest();
	viewtotalpasien totalpasien();
}
