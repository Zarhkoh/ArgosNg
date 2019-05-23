package fr.hdf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.hdf.entities.Enseignant;
import fr.hdf.idao.IEnseignantDao;
import fr.hdf.iservices.IEnseignantService;

@Service
@Transactional
public class EnseignantServiceImpl implements IEnseignantService {
	
	@Autowired
	private IEnseignantDao enseignantDao;
	

	public IEnseignantDao getEnseignantDao() {
		return enseignantDao;
	}

	public void setEnseignantDao(IEnseignantDao enseignantDao) {
		this.enseignantDao = enseignantDao;
	}

	public void ajouterEnseignant(Enseignant en1) {
		enseignantDao.addEnseignant(en1);
	}

	public List<Enseignant> recupEnseignants() {
		return enseignantDao.getAllEnseignants();
	}

	public void supprimerEnseignant(Enseignant enseignant) {
		enseignantDao.supprEnseignant(enseignant);		
	}

	

}
