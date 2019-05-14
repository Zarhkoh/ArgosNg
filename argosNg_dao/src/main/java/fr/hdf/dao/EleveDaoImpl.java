package fr.hdf.dao;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.hdf.entities.Eleve;
import fr.hdf.idao.IEleveDao;

@Repository
public class EleveDaoImpl implements IEleveDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void addEleve(Eleve eleve) {
		entityManager.persist(eleve);
		
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
}
