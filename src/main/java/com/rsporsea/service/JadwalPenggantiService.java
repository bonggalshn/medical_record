package com.rsporsea.service;

import com.rsporsea.model.Pengganti;
import com.rsporsea.model.viewpengganti;
import java.util.List;

public interface JadwalPenggantiService {
	List<viewpengganti> listJadwalPengganti();
	Pengganti saveorUpdate(Pengganti jadwalPengganti);
	Pengganti getIdJadwalPengganti(Integer id_jadwal_pengganti);
	viewpengganti getViewJadwalPengganti(Integer id_jadwal_pengganti);
	void hapusJadwalPengganti(Integer id_jadwal_pengganti);
	Integer latest();
}
