package com.rsporsea.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.rsporsea.model.PengobatanJalan;
import com.rsporsea.model.pjalan;
import com.rsporsea.model.viewjkjalan;
import com.rsporsea.model.viewjlhpenyakitjalan;
import com.rsporsea.model.viewlaporanumum;
import com.rsporsea.model.viewrekappenyakitjalan;
import com.rsporsea.model.viewgrafikjumlah;
import com.rsporsea.service.RekamMedikPenyakitJalanService;

@Service
public class RekamMedikPenyakitJalanDao implements RekamMedikPenyakitJalanService {

	private EntityManagerFactory emf;

	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List<pjalan> listPenyakit() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<pjalan> save = em.createQuery("from pjalan",pjalan.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return save;
	}
	
//	@Override
//	public Integer Jumlah(){
//		Integer count = 1;
//		return count;
//	}
	
	@Override
	public List<viewlaporanumum> listLaporan(){
		EntityManager em = emf.createEntityManager();
		List<viewlaporanumum> save = em.createQuery("from viewlaporanumum",viewlaporanumum.class).getResultList();
		em.close();
		return save;
	}
	
	@Override
	public List<viewgrafikjumlah> listJumlah(){
		EntityManager em = emf.createEntityManager();
		List<viewgrafikjumlah> save = em.createQuery("from viewgrafikjumlah",viewgrafikjumlah.class).getResultList();
		em.close();
		return save;
	}
	
	@Override
	public viewjkjalan JenisKelamin(){
		EntityManager em = emf.createEntityManager();
		viewjkjalan save = em.createQuery("from viewjkjalan",viewjkjalan.class).getSingleResult();
		em.close();
		return save;
	}

	@Override
	public List<viewrekappenyakitjalan> penyakitPerTahun() {
		EntityManager em = emf.createEntityManager();
		List<viewrekappenyakitjalan> result = em.createQuery("from viewrekappenyakitjalan",viewrekappenyakitjalan.class).getResultList();
		em.close();
		return result;
	}

	@Override
	public List<viewjlhpenyakitjalan> totalPenyakit() {
		EntityManager em = emf.createEntityManager();
		List<viewjlhpenyakitjalan> result = em.createQuery("from viewjlhpenyakitjalan", viewjlhpenyakitjalan.class).getResultList();
		em.close();
		return result;
	}
	
	

}
