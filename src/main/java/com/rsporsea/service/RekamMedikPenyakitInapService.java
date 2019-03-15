package com.rsporsea.service;

import java.util.List;

import com.rsporsea.model.pinap;
import com.rsporsea.model.viewgrafikjumlahinap;
import com.rsporsea.model.viewjkinap;
import com.rsporsea.model.viewlaporanumuminap;
import com.rsporsea.model.viewrekappenyakitinap;
import com.rsporsea.model.viewjlhpenyakitinap;

//import com.rsporsea.model.PengobatanJalan;


public interface RekamMedikPenyakitInapService {
	List<pinap> listPenyakit();
	List<viewlaporanumuminap> listLaporan();
	List<viewgrafikjumlahinap> listJumlah();
	public viewjkinap JenisKelamin();
	List<viewrekappenyakitinap> penyakitPerTahun();
	List<viewjlhpenyakitinap> totalPenyakit();
}
