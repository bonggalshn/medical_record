package com.rsporsea.dao;

import com.rsporsea.model.Dokter;
//import com.rsporsea.model.Jadwal;
import com.rsporsea.service.DokterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class DokterDao implements DokterService{
	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List<Dokter> listDokter(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Dokter> save = em.createQuery("from Dokter where status='Aktif'", Dokter.class).getResultList();		
		em.getTransaction().commit();
		em.close();
		return save;
	}

	@Override
	public Dokter saveorUpdate(Dokter dokter) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		dokter.setStatus("Aktif");
		Dokter saved = em.merge(dokter);
		em.getTransaction().commit();
		em.close();
		return saved;
	}
	
	@Override
	public List<Dokter> search(String dokter) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Dokter> saved = em.createQuery("from Dokter where status='Aktif' AND (nama_dokter LIKE CONCAT('%"+dokter+"%') OR NIP LIKE CONCAT('%"+dokter+"%') OR spesialis_dokter LIKE CONCAT('%"+dokter+"%'))", Dokter.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return saved;
	}

	@Override
	public Dokter getIdDokter(Integer id) {
		EntityManager em = emf.createEntityManager();
		Dokter saved = em.find(Dokter.class, id);
		em.close();
		return saved;
	}

	@Override
	public void hapusDokter(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Dokter a = em.find(Dokter.class, id);
		a.setStatus("Tidak Aktif");
		em.merge(a);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public Integer latest(){
		EntityManager em = emf.createEntityManager();
		Integer latest = em.createQuery("from Dokter where status='Aktif' order by id_dokter DESC",Dokter.class).setMaxResults(1).getSingleResult().getId_dokter();
		em.close();
		return latest;
	}
	
	@Override
	public List<Dokter> listDokterbySp(String spesialis){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Dokter> save = em.createQuery("from Dokter where status='Aktif' AND spesialis_dokter='"+spesialis+"'", Dokter.class).getResultList();		
		em.getTransaction().commit();
		em.close();
		return save;
	}
}
