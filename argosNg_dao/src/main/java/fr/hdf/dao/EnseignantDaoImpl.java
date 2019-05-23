package fr.hdf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.hdf.entities.Enseignant;
import fr.hdf.idao.IEnseignantDao;

@Repository
public class EnseignantDaoImpl implements IEnseignantDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void addEnseignant(Enseignant enseignant) {
		entityManager.persist(enseignant);
		
	}

	public List<Enseignant> getAllEnseignants() {
		Query req = entityManager.createQuery("select en from Enseignant en" );
		List<Enseignant> enseignants = new ArrayList<Enseignant>();
		enseignants = req.getResultList();
		return enseignants;
	}

	public void supprEnseignant(Enseignant enseignant) {
		Enseignant ens = entityManager.merge(enseignant);
		entityManager.remove(ens);
	}

}
