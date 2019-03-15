package com.rsporsea.service;

import java.util.List;

import com.rsporsea.model.viewjkjalan;
import com.rsporsea.model.pjalan;
import com.rsporsea.model.viewgrafikjumlah;
import com.rsporsea.model.viewlaporanumum;
import com.rsporsea.model.viewrekappenyakitjalan;
import com.rsporsea.model.viewjlhpenyakitjalan;

//import com.rsporsea.model.PengobatanJalan;


public interface RekamMedikPenyakitJalanService {
	List<pjalan> listPenyakit();
//	Integer Jumlah();
	List<viewlaporanumum> listLaporan();
	List<viewgrafikjumlah> listJumlah();
	viewjkjalan JenisKelamin();
	List<viewrekappenyakitjalan> penyakitPerTahun();
	List<viewjlhpenyakitjalan> totalPenyakit();
}
