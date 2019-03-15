package com.rsporsea.service;

import java.util.List;

//import javax.persistence.EntityManager;

//import com.rsporsea.model.Dokter;
import com.rsporsea.model.PengobatanJalan;
import com.rsporsea.model.viewpengobatanjalan;

public interface PengobatanJalanService {

//	List<PengobatanJalan> getAllPengobatanJalan(Integer id_pasien);
	public PengobatanJalan getPengobatanJalanForm (Integer id_pengobatan_jalan);
	List<viewpengobatanjalan> getAllPengobatanJalan(Integer id_pasien);
//	public PengobatanJalan getPengobatanJalan (Integer id_pengobatan_jalan);
	public viewpengobatanjalan getPengobatanJalan (Integer id);
	public PengobatanJalan saveorUpdate(PengobatanJalan pengobatanJalan);
	public void hapusPengobatanJalan(Integer id_pengobatan_jalan);
	Integer latest(Integer id_pasien);
	java.sql.Date dateNow();
}
