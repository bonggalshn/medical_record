package com.rsporsea.dao;

//import java.util.Calendar;
//import java.util.Date;
//import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsporsea.model.Pasien;
import com.rsporsea.model.PengobatanInap;
import com.rsporsea.model.PengobatanJalan;
import com.rsporsea.model.viewtotalpasien;
import com.rsporsea.service.PasienService;

@Service
public class PasienDao implements PasienService{

	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public List<Pasien> listPasien() {
		EntityManager em = emf.createEntityManager();
//		List<Pasien> ListPasien = new ArrayList<Pasien>();
//		ListPasien = em.createQuery("from Pasien", Pasien.class).getResultList();
		List<Pasien> ListPasien = em.createQuery("from Pasien where status='Aktif'", Pasien.class).getResultList();
		em.close();
		return ListPasien;
	}

	@Override
	public Pasien saveOrUpdate(Pasien pasien) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		Date today = new Date();
//		Calendar cal = Calendar.getInstance(); 
//		cal.setTime(today); 
//		Integer year=cal.get(Calendar.YEAR);
//	
//		String rm = year.toString().concat(month.toString());
//		rm = rm.concat(day.toString());
//		rm = rm.concat(count.toString());
		
//		SimpleDateFormat("EEEE").format(date1));
//		
//		if(pasien.getNomor_rekam_medik()==null){
//			pasien.setNomor_rekam_medik(num);
//		}
		
		if(pasien.getStatus()!="Aktif")
		{
			pasien.setStatus("Aktif");
		}
		
		Pasien savedPasien = em.merge(pasien);
		em.getTransaction().commit();
		em.close();
		return savedPasien;
	}

	@Override
	public Pasien getIdPasien(Integer id_pasien) {
		EntityManager em = emf.createEntityManager();
		Pasien saved = em.find(Pasien.class, id_pasien);
		em.close();
		return saved;
	}

	@Override
	public void hapusPasien(Integer id_pasien) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pasien set = em.find(Pasien.class, id_pasien);
		List<PengobatanInap> set1 = em.createQuery("from PengobatanInap where id_pasien="+id_pasien,PengobatanInap.class).getResultList();
		List<PengobatanJalan> set2 = em.createQuery("from PengobatanJalan where id_pasien="+id_pasien, PengobatanJalan.class).getResultList();
		
		for(PengobatanInap a:set1){
			a.setStatus("Tidak Aktif");
		}
		
		for(PengobatanJalan b:set2){
			b.setStatus("Tidak Aktif");
		}
		
		set.setStatus("Tidak Aktif");
		em.merge(set);
//		em.remove(em.find(Pasien.class,id_pasien));
		em.getTransaction().commit();
		em.close();
		
	}
	
	@Override
	public Integer latest() {
		EntityManager em = emf.createEntityManager();
		Integer latest  = em.createQuery("from Pasien where status='Aktif' order by id_pasien DESC", Pasien.class).setMaxResults(1).getSingleResult().getId_pasien();
		em.close();
		return latest;
	}
	
	@Override
	public viewtotalpasien totalpasien() {
		EntityManager em = emf.createEntityManager();
		viewtotalpasien res = em.createQuery("from viewtotalpasien", viewtotalpasien.class).getSingleResult();
		em.close();
		return res;
	}
}
