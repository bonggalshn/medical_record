package com.rsporsea.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.rsporsea.model.PengobatanJalan;
import com.rsporsea.model.pinap;
import com.rsporsea.model.viewgrafikjumlahinap;
import com.rsporsea.model.viewjkinap;
import com.rsporsea.model.viewjlhpenyakitinap;
import com.rsporsea.model.viewlaporanumuminap;
import com.rsporsea.model.viewrekappenyakitinap;
import com.rsporsea.service.RekamMedikPenyakitInapService;

@Service
public class RekamMedikPenyakitInapDao implements RekamMedikPenyakitInapService {

	private EntityManagerFactory emf;

	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	
	@Override
	public List<pinap> listPenyakit() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<pinap> saved = em.createQuery("from pinap",pinap.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return saved;
	}
	
//	@Override
//	public Integer Jumlah(){
//		Integer count = 1;
//		return count;
//	}
	
	@Override
	public List<viewlaporanumuminap> listLaporan(){
		EntityManager em = emf.createEntityManager();
		List<viewlaporanumuminap> save = em.createQuery("from viewlaporanumuminap",viewlaporanumuminap.class).getResultList();
		em.close();
		return save;
	}
	
	@Override
	public List<viewgrafikjumlahinap> listJumlah(){
		EntityManager em = emf.createEntityManager();
		List<viewgrafikjumlahinap> save = em.createQuery("from viewgrafikjumlahinap",viewgrafikjumlahinap.class).getResultList();
		em.close();
		return save;
	}
	
	@Override
	public viewjkinap JenisKelamin(){
		EntityManager em = emf.createEntityManager();
		viewjkinap save = em.createQuery("from viewjkinap",viewjkinap.class).getSingleResult();
		em.close();
		return save;
	}

	@Override
	public List<viewrekappenyakitinap> penyakitPerTahun() {
		EntityManager em = emf.createEntityManager();
		List<viewrekappenyakitinap> result = em.createQuery("from viewrekappenyakitinap",viewrekappenyakitinap.class).getResultList();
		em.close();
		return result;
	}

	@Override
	public List<viewjlhpenyakitinap> totalPenyakit() {
		EntityManager em = emf.createEntityManager();
		List<viewjlhpenyakitinap> result = em.createQuery("from viewjlhpenyakitinap", viewjlhpenyakitinap.class).getResultList();
		em.close();
		return result;
	}

}
