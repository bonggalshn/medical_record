package com.rsporsea.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsporsea.model.viewjadwaldokter;
//import com.rsporsea.model.Jadwal;
import com.rsporsea.model.jadwal_dokter;
//import com.rsporsea.model.viewjadwal;
import com.rsporsea.service.JadwalService;

@Service
public class JadwalDao implements JadwalService{
	private EntityManagerFactory emf;

	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	//	@Override
	//	public List<Jadwal> listJadwal() {
	//		EntityManager em = emf.createEntityManager();
	//		List<Jadwal> jadwal = em.createQuery("from Jadwal", Jadwal.class).getResultList();
	//		em.close();
	//		return jadwal;
	//	}

	//	@Override
	//	public List<viewjadwal> listJadwalSpesialis(){
	//		EntityManager em = emf.createEntityManager();
	//		List<viewjadwal> jadwal = em.createQuery("from viewjadwal where spesialis_dokter != 'Umum'", viewjadwal.class).getResultList();
	//		em.close();
	//		return jadwal;
	//	}

	//	JADWAL 2 #########################################################################################################################################################
	
	@Override
	public List<viewjadwaldokter> listJadwalSp(){
		EntityManager em = emf.createEntityManager();
		List<viewjadwaldokter> saved = em.createQuery("from viewjadwaldokter where spesialis!='Umum'", viewjadwaldokter.class).getResultList();
		em.close();
		return saved;
	}

	@Override
	public List<viewjadwaldokter> listJadwalUm(){
		EntityManager em = emf.createEntityManager();
		List<viewjadwaldokter> saved = em.createQuery("from viewjadwaldokter where spesialis='Umum'", viewjadwaldokter.class).getResultList();
		em.close();
		return saved;
	}

	@Override
	public jadwal_dokter saveorUpdate(jadwal_dokter jadwal) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		jadwal.setStatus("Aktif");
		jadwal_dokter saved = em.merge(jadwal);
		em.getTransaction().commit();
		em.close();
		return saved;
	}

	@Override
	public jadwal_dokter getIdJadwal(Integer id_jadwal) {
		EntityManager em = emf.createEntityManager();
		jadwal_dokter saved = em.find(jadwal_dokter.class, id_jadwal);
		em.close();
		return saved;
	}

	//	################################################################################################################################################################################################################################

	//	@Override
	//	public List<viewjadwal> listJadwalUmum(){
	//		EntityManager em = emf.createEntityManager();
	//		List<viewjadwal> jadwal = em.createQuery("from viewjadwal where spesialis_dokter = 'Umum'", viewjadwal.class).getResultList();
	//		em.close();
	//		return jadwal;
	//	}

	//	@Override
	//	public Jadwal saveorUpdate(Jadwal jadwal) {
	//		EntityManager em = emf.createEntityManager();
	//		em.getTransaction().begin();
	//		jadwal.setStatus("Aktif");
	//		Jadwal saved = em.merge(jadwal);
	//		em.getTransaction().commit();
	//		em.close();
	//		return saved;
	//	}

	//	@Override
	//	public Jadwal getIdJadwal(Integer id_jadwal) {
	//		EntityManager em = emf.createEntityManager();
	//		Jadwal saved = em.find(Jadwal.class, id_jadwal);
	//		em.close();
	//		return saved;
	//	}

	@Override
	public viewjadwaldokter getViewJadwal(Integer id_jadwal){
		EntityManager em = emf.createEntityManager();
		viewjadwaldokter saved = em.find(viewjadwaldokter.class, id_jadwal);
		em.close();
		return saved;
	}

	@Override
	public List<viewjadwaldokter> getJadwalbyDokter(Integer id_dokter) {
		EntityManager em = emf.createEntityManager();
		List<viewjadwaldokter> jadwal = em.createQuery("from viewjadwaldokter where id_dokter ="+id_dokter, viewjadwaldokter.class).getResultList();
		em.close();
		return jadwal;
	}

	//	@Override
	//	public void hapusJadwal(Integer id_jadwal) {
	//		EntityManager em = emf.createEntityManager();
	//		em.getTransaction().begin();
	//		em.remove(em.find(Jadwal.class,id_jadwal));
	//		em.getTransaction().commit();		
	//		em.close();
	//	}

	@Override
	public void hapusJadwal(Integer id_jadwal) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		jadwal_dokter a = em.find(jadwal_dokter.class, id_jadwal);
		a.setStatus("Tidak Aktif");
		em.merge(a);
		em.getTransaction().commit();		
		em.close();
	}

	@Override
	public Integer latest() {
		EntityManager em = emf.createEntityManager();
		Integer latest= em.createQuery("from jadwal_dokter order by id_jadwal DESC",jadwal_dokter.class).setMaxResults(1).getSingleResult().getId_jadwal();
		em.close();
		return latest;
	}

	@Override
	public String checkJadwal(jadwal_dokter jadwal) {
		String res = "OK";
		EntityManager em = emf.createEntityManager();
		List<viewjadwaldokter> listJadwal = em.createQuery("from viewjadwaldokter where id_dokter="+jadwal.getNama_dokter()+"AND id_jadwal!="+jadwal.getId_jadwal(), viewjadwaldokter.class).getResultList();
		if(!listJadwal.isEmpty()){
			for(viewjadwaldokter j:listJadwal){
				/*if((j.getSenin()==1 && jadwal.getSenin()!=1) || j.getSenin()!=1){
					if(j.getSelasa()==1 && jadwal.getSelasa()!=1 || j.getSelasa()!=1){
						if(j.getRabu()==1 && jadwal.getRabu()!=1 || j.getRabu()!=1){
							res = "OK";
						}
					}
				}*/
				if((Integer)j.getSenin()==(Integer)1 && (Integer)jadwal.getSenin()==(Integer)1){
					res="not OK";
					return res;
				}
				if((Integer)j.getSelasa()==(Integer)1 && (Integer)jadwal.getSelasa()==(Integer)1){
					res="not OK";
					return res;
				}
				if((Integer)j.getRabu()==(Integer)1 && (Integer)jadwal.getRabu()==(Integer)1){
					res="not OK";
					return res;
				}
				if((Integer)j.getKamis()==(Integer)1 && (Integer)jadwal.getKamis()==(Integer)1){
					res="not OK";
					return res;
				}
				if((Integer)j.getJumat()==(Integer)1 && (Integer)jadwal.getJumat()==(Integer)1){
					res="not OK";
					return res;
				}
				if((Integer)j.getSabtu()==(Integer)1 && (Integer)jadwal.getSabtu()==(Integer)1){
					res="not OK";
					return res;
				}
				if((Integer)j.getMinggu()==(Integer)1 && (Integer)jadwal.getMinggu()==(Integer)1){
					res="not OK";
					return res;
				}
			}
		}

		em.close();
		return res;
	}


}
