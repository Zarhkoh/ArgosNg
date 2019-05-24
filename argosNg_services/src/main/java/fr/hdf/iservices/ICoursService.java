package fr.hdf.iservices;

import java.util.List;

import fr.hdf.entities.Cours;

public interface ICoursService {
	
	
	public void ajouterCours(Cours c1);
	public List<Cours> recupCours();
	public void supprimerCours (Cours cours);

}
