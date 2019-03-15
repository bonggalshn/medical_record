package com.rsporsea.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsporsea.model.PengobatanJalan;
import com.rsporsea.model.viewpengobatanjalan;
import com.rsporsea.service.PengobatanJalanService;

@Service
public class PengobatanJalanDao implements PengobatanJalanService{
	private EntityManagerFactory emf;

	@Autowired
	public void setEmf(EntityManagerFactory eMF) {
		this.emf = eMF;
	}

//	@Override
//	public List<PengobatanJalan> getAllPengobatanJalan(Integer id_pasien) {
//		EntityManager em = emf.createEntityManager();
//		List<PengobatanJalan> list = em.createQuery("from PengobatanJalan where id_pasien="+id_pasien, PengobatanJalan.class).getResultList();
//		em.close();
//		return list;
//	}
	
	@Override
	public List<viewpengobatanjalan> getAllPengobatanJalan(Integer id_pasien) {
		EntityManager em = emf.createEntityManager();
		List<viewpengobatanjalan> list = em.createQuery("from viewpengobatanjalan where id_pasien="+id_pasien, viewpengobatanjalan.class).getResultList();
		em.close();
		return list;
	}
	
	@Override
	public PengobatanJalan getPengobatanJalanForm (Integer id_pengobatan_jalan){
		EntityManager em = emf.createEntityManager();
		PengobatanJalan find = em.find(PengobatanJalan.class, id_pengobatan_jalan);
		em.close();
		return find;
	}
	
	@Override
	public viewpengobatanjalan getPengobatanJalan (Integer id){
		EntityManager em = emf.createEntityManager();
		viewpengobatanjalan find = em.find(viewpengobatanjalan.class, id);
		em.close();
		return find;
	}

	@Override
	public PengobatanJalan saveorUpdate(PengobatanJalan pengobatanJalan) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		pengobatanJalan.setStatus("Aktif");
		java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		pengobatanJalan.setTanggal_pengobatan_jalan(sqlDate);
		PengobatanJalan saved = em.merge(pengobatanJalan);
		em.getTransaction().commit();
		em.close();
		return saved;
	}

	@Override
	public void hapusPengobatanJalan(Integer id_pengobatan_jalan) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
//		em.remove(em.find(PengobatanJalan.class,id_pengobatan_jalan));
		PengobatanJalan delete = em.find(PengobatanJalan.class, id_pengobatan_jalan);
		delete.setStatus("Tidak Aktif");
		em.merge(delete);
		em.getTransaction().commit();
		em.close();
	}
	
	public Integer latest(Integer id_pasien){
		EntityManager em = emf.createEntityManager();
		Integer latest = em.createQuery("from viewpengobatanjalan where id_pasien="+id_pasien+"order by id DESC", viewpengobatanjalan.class).setMaxResults(1).getSingleResult().getId();
		em.close();
		return latest;
	}

	@Override
	public Date dateNow() {
		java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		return sqlDate;
	}
}
