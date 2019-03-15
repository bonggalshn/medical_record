package com.rsporsea.service;

//import com.rsporsea.model.Jadwal;
import com.rsporsea.model.jadwal_dokter;
//import com.rsporsea.model.viewjadwal;

import com.rsporsea.model.viewjadwaldokter;

import java.util.List;

public interface JadwalService {
//	List<Jadwal> listJadwal();
//	List<viewjadwal> listJadwalSpesialis();
//	List<viewjadwal> listJadwalUmum();
//	Jadwal saveorUpdate(Jadwal jadwal);
//	Jadwal getIdJadwal(Integer id_jadwal);
	void hapusJadwal(Integer id_jadwal);
	public List<viewjadwaldokter> getJadwalbyDokter(Integer id_dokter);
	public viewjadwaldokter getViewJadwal(Integer id_jadwal);
	
	
	List<viewjadwaldokter> listJadwalSp();
	List<viewjadwaldokter> listJadwalUm();
	jadwal_dokter saveorUpdate(jadwal_dokter jadwal);
	jadwal_dokter getIdJadwal(Integer id_jadwal);
	Integer latest();
	String checkJadwal(jadwal_dokter jadwal);
}
