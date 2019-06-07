package fr.hdf.dao;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.hdf.entities.Diplome;
import fr.hdf.entities.Eleve;
import fr.hdf.idao.IDiplomeDao;
import fr.hdf.idao.IEleveDao;

@Repository
public class EleveDaoImpl implements IEleveDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private IDiplomeDao diplomeDao;
	
	
	public void addEleve(Eleve eleve) {
		Eleve e2 = entityManager.merge(eleve);
		if(e2.getDiplomeEleve() != null) {
			
		Diplome diplome = diplomeDao.getDiplomeByIdDip(e2.getDiplomeEleve().getIdDiplome());
			e2.setDiplomeEleve(diplome);			
		}
			entityManager.persist(e2);
		
	}
	
	public List<Eleve> getAllEleves() {
		
		Query req = entityManager.createQuery("select e from Eleve e");
		List<Eleve> eleves = new ArrayList<Eleve>();
		eleves = req.getResultList();
		return eleves;
	}

	public void supprEleve(Eleve eleve) {
		Eleve elv =  entityManager.merge(eleve);
		entityManager.remove(elv);
	}

	public void editEleve(Eleve eleve) {
		entityManager.merge(eleve);
	
		
	}

	public IDiplomeDao getDiplomeDao() {
		return diplomeDao;
	}

	public void setDiplomeDao(IDiplomeDao diplomeDao) {
		this.diplomeDao = diplomeDao;
	}


}
