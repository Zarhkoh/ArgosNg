package fr.hdf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.hdf.dao.IEleveDao;
import fr.hdf.entities.Eleve;
import fr.hdf.iservices.IEleveService;

@Service
@Transactional
public class EleveServiceImpl implements IEleveService {

	@Autowired
	private IEleveDao eleveDao;
	
	public void ajouterEleve(Eleve e1) {
		System.out.println("eleve: " + e1.getNomEleve() + " " + e1.getPrenomEleve()+ " added to dao");
		eleveDao.addEleve(e1);
	}
	public IEleveDao getEleveDao() {
		return eleveDao;
	}
	public void setEleveDao(IEleveDao eleveDao) {
		this.eleveDao = eleveDao;
	}
	public List<Eleve> recupEleves() {
		return eleveDao.getAllEleves();
		
	}
	
}
