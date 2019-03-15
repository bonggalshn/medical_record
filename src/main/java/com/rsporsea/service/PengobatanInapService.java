package com.rsporsea.service;

import java.util.List;

import com.rsporsea.model.PengobatanInap;
import com.rsporsea.model.viewpengobataninap;

public interface PengobatanInapService {

//	List<PengobatanInap> getAllPengobatanInap(Integer id_pasien);
	List<viewpengobataninap> getAllPengobatanInap(Integer id_pasien);
	public viewpengobataninap getViewPengobatanInap(Integer id_pengobatan_inap);
	public PengobatanInap getPengobatanInap (Integer id_pengobatan_inap);
	public PengobatanInap saveorUpdate(PengobatanInap pengobatanInap);
	public void hapusPengobatanInap(Integer id_pengobatan_inap);
	Integer latest(Integer id_pasien);
	java.sql.Date dateNow();
}
