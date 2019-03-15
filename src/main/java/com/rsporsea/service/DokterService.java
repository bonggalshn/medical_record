package com.rsporsea.service;

import com.rsporsea.model.Dokter;
import java.util.List;
//import org.springframework.data.repository.CrudRepository;
//extends CrudRepository<Dokter, Long>

public interface DokterService {
	List <Dokter> listDokter();
	Dokter saveorUpdate(Dokter dokter);
	Dokter getIdDokter(Integer id);
	void hapusDokter(Integer id);
	public List<Dokter> search(String dokter);
	Integer latest();
	List<Dokter> listDokterbySp(String spesialis);
}
