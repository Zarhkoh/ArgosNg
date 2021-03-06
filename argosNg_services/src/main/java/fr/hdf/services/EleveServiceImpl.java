package fr.hdf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.hdf.entities.Eleve;
import fr.hdf.idao.IEleveDao;
import fr.hdf.iservices.IEleveService;

@Service
@Transactional
public class EleveServiceImpl implements IEleveService {

	@Autowired
	private IEleveDao eleveDao;
	
	public void ajouterEleve(Eleve e1) {
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
	public void supprimerEleve (Eleve eleve) {
		eleveDao.supprEleve(eleve);
	}
	public void modifierEleve(Eleve e1) {
		eleveDao.editEleve(e1);
		
	}
	
}
