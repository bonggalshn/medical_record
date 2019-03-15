package com.rsporsea.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsporsea.model.PengobatanInap;
import com.rsporsea.service.PengobatanInapService;
import com.rsporsea.model.viewpengobataninap;

@Service
public class PengobatanInapDao implements PengobatanInapService{
	private EntityManagerFactory emf;

	@Autowired
	public void setEmf(EntityManagerFactory eMF) {
		this.emf = eMF;
	}

//	@Override
//	public List<PengobatanInap> getAllPengobatanInap(Integer id_pasien) {
//		EntityManager em = emf.createEntityManager();
//		List<PengobatanInap> list = em.createQuery("from PengobatanInap where id_pasien="+id_pasien, PengobatanInap.class).getResultList();
//		em.close();
//		return list;
//	}
	
	@Override
	public List<viewpengobataninap> getAllPengobatanInap(Integer id_pasien){
		EntityManager em = emf.createEntityManager();
		List<viewpengobataninap> list = em.createQuery("from viewpengobataninap where id_pasien="+id_pasien, viewpengobataninap.class).getResultList();
		em.close();
		return list;
	}

	@Override
	public PengobatanInap getPengobatanInap(Integer id_pengobatan_inap) {
		EntityManager em = emf.createEntityManager();
		PengobatanInap find = em.find(PengobatanInap.class, id_pengobatan_inap);
		em.close();
		return find;
	}
	
	@Override
	public viewpengobataninap getViewPengobatanInap(Integer id_inap) {
		EntityManager em = emf.createEntityManager();
		viewpengobataninap find = em.find(viewpengobataninap.class, id_inap);
		em.close();
		return find;
	}

	@Override
	public PengobatanInap saveorUpdate(PengobatanInap pengobatanInap) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		pengobatanInap.setStatus("Aktif");
		java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		pengobatanInap.setTanggal_masuk(sqlDate);
		PengobatanInap saved = em.merge(pengobatanInap);
		em.getTransaction().commit();
		em.close();
		return saved;
	}
	
	@Override
	public void hapusPengobatanInap(Integer id_pengobatan_inap){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		PengobatanInap delete = em.find(PengobatanInap.class, id_pengobatan_inap);
		delete.setStatus("Tidak Aktif");
		em.merge(delete);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public Integer latest(Integer id_pasien){
		EntityManager em = emf.createEntityManager();
		Integer latest = em.createQuery("from viewpengobataninap where id_pasien="+id_pasien+"order by id_inap DESC",viewpengobataninap.class).setMaxResults(1).getSingleResult().getId_inap();
		em.close();
		return latest;
	}
	
	@Override
	public java.sql.Date dateNow(){
//		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//		Date date = new Date();
//		Date dates = dateFormat.parse(dateFormat.format(date));
//		return dateFormat.format(date);
		java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		return sqlDate;
	}

}
