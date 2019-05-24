package fr.hdf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.hdf.entities.Cours;
import fr.hdf.idao.ICoursDao;

@Repository
public class CoursDaoImpl implements ICoursDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void addCours(Cours cours) {
		entityManager.persist(cours);
	}

	public List<Cours> getAllCours() {
		Query q = entityManager.createQuery("select c from Cours c");
		List<Cours> courses = new ArrayList<Cours>();
		courses = q.getResultList();
		return courses;
	}

	public void supprCours(Cours cours) {
		Cours crs = entityManager.merge(cours);
		entityManager.remove(crs);
	}

}
