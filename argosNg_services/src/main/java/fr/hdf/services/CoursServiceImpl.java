package fr.hdf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.hdf.entities.Cours;
import fr.hdf.idao.ICoursDao;
import fr.hdf.iservices.ICoursService;

@Service
@Transactional
public class CoursServiceImpl implements ICoursService {

	@Autowired
	private ICoursDao coursDao;

	public void ajouterCours(Cours c1) {
		coursDao.addCours(c1);

	}

	public List<Cours> recupCours() {
		return coursDao.getAllCours();
	}

	public void supprimerCours(Cours cours) {
		coursDao.supprCours(cours);
	}

}
