package fr.hdf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.hdf.entities.Diplome;
import fr.hdf.idao.IDiplomeDao;
import fr.hdf.iservices.IDiplomeService;

@Service
@Transactional
public class DiplomeServiceImpl implements IDiplomeService {

	@Autowired
	private IDiplomeDao diplomeDao;

	public void ajouterDiplome(Diplome d1) {
		diplomeDao.addDiplome(d1);
	}

	public IDiplomeDao getDiplomeDao() {
		return diplomeDao;
	}

	public List<Diplome> recupDiplomes() {
		return diplomeDao.getAllDiplomes();
	}

	public void supprimerDiplome(Diplome diplome) {
		diplomeDao.supprDiplome(diplome);
	}

	public void modifierDiplome(Diplome d1) {

		diplomeDao.editDiplome(d1);
	}

	public Diplome getDiplomeByiD(Long idDiplome) {
		return diplomeDao.getDiplomeByIdDip(idDiplome);
	}

}
