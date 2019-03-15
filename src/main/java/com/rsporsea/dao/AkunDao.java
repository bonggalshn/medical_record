package com.rsporsea.dao;

import java.util.List;

import com.rsporsea.model.Akun;
import com.rsporsea.service.AkunService;
import javax.persistence.*;

//import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AkunDao implements AkunService {
	
	private EntityManagerFactory emf;
	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory eMf){
		this.emf = eMf;
	}	
	
	@Override
	public List<Akun> getAllAkun() {
		EntityManager em = emf.createEntityManager();
		List<Akun> akun = em.createQuery("from Akun", Akun.class).getResultList();
		em.close();
		return akun;
	}

	@Override
	public Akun login(String username, String password) {
		List<Akun> allAkun = getAllAkun();
		Akun akunFind = null;
		for (Akun akun : allAkun){
			if(akun.getUsername().equals(username) && akun.getPassword().equals(password)){
//			if(akun.getUsername().equals(username) && key.decrypt(keys, initVector, akun.getPassword()).equals(password)){
				akunFind = akun;
				break;
			}
		}
		return akunFind;
	}

	@Override
	public Akun saveOrUpdate(Akun akun) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Akun saved = em.merge(akun);
		em.getTransaction().commit();
		em.close();
		return saved;
	}

	@Override
	public Akun getAkun(Integer id_akun) {
		EntityManager em = emf.createEntityManager();
		Akun saved = em.find(Akun.class, id_akun);
		em.close();
		return saved;
	}

	@Override
	public void delete(Integer id_akun) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Akun.class, id_akun));
		em.getTransaction().commit();
		em.close();		
	}

}
