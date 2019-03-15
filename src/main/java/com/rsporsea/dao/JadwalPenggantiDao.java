package com.rsporsea.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsporsea.model.Pengganti;
import com.rsporsea.model.viewpengganti;
import com.rsporsea.service.JadwalPenggantiService;

@Service
public class JadwalPenggantiDao implements JadwalPenggantiService{
	private EntityManagerFactory emf;

	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<viewpengganti> listJadwalPengganti() {
		EntityManager em = emf.createEntityManager();
		List<viewpengganti> saved = em.createQuery("from viewpengganti", viewpengganti.class).getResultList();
		em.close();
		return saved;
	}

	@Override
	public Pengganti saveorUpdate(Pengganti jadwalPengganti) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();;
		jadwalPengganti.setStatus("Aktif");
		Pengganti saved = em.merge(jadwalPengganti);
		em.getTransaction().commit();
		em.close();
		return saved;
	}

	@Override
	public Pengganti getIdJadwalPengganti(Integer id_jadwal_pengganti) {
		EntityManager em = emf.createEntityManager();
		Pengganti saved = em.find(Pengganti.class, id_jadwal_pengganti);
		em.close();
		return saved;
	}
	
	@Override
	public viewpengganti getViewJadwalPengganti(Integer id_jadwal_pengganti) {
		EntityManager em = emf.createEntityManager();
		viewpengganti saved = em.find(viewpengganti.class, id_jadwal_pengganti);
		em.close();
		return saved;
	}

	@Override
	public void hapusJadwalPengganti(Integer id_jadwal_pengganti) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pengganti set = em.find(Pengganti.class, id_jadwal_pengganti);
		set.setStatus("Tidak Aktif");
		em.merge(set);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Integer latest() {
		EntityManager em = emf.createEntityManager();
		Integer latest = em.createQuery("from Pengganti where status='Aktif' order by id_jadwal_pengganti DESC", Pengganti.class).setMaxResults(1).getSingleResult().getId_jadwal_pengganti();
		em.close();
		return latest;
	}

}
