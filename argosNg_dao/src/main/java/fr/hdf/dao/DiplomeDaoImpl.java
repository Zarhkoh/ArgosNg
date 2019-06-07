package fr.hdf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.hdf.entities.Diplome;
import fr.hdf.idao.IDiplomeDao;

@Repository
public class DiplomeDaoImpl implements IDiplomeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void addDiplome(Diplome diplome) {
		entityManager.persist(diplome);	
	}
	
	public List<Diplome> getAllDiplomes() {
		
		Query req = entityManager.createQuery("select d from Diplome d");
		List<Diplome> diplomes = new ArrayList<Diplome>();
		diplomes = req.getResultList();
		return diplomes;
	}
	
	public void supprDiplome(Diplome diplome) {
		Diplome dpl = entityManager.merge(diplome);
		entityManager.remove(dpl);
	}

	public void editDiplome(Diplome diplome) {
		entityManager.merge(diplome);

	}

	public Diplome getDiplomeByIdDip(Long idDiplome) {
		Query q = entityManager.createQuery("select d from Diplome d where d.id = :idDip");
		q.setParameter("idDip", idDiplome);
		return (Diplome) q.getSingleResult();
	}
}
