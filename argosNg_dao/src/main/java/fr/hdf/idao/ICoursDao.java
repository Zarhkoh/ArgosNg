package fr.hdf.idao;

import java.util.List;

import fr.hdf.entities.Cours;

public interface ICoursDao {
	public void addCours(Cours cours);
	
	public List<Cours> getAllCours();
	
	void supprCours(Cours cours);
	
	

}
