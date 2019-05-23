package fr.hdf.iservices;

import java.util.List;

import fr.hdf.entities.Enseignant;

public interface IEnseignantService {
	
	public void ajouterEnseignant(Enseignant en1);
	public List<Enseignant> recupEnseignants();
	public void supprimerEnseignant(Enseignant enseignant);

}
