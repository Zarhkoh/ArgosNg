package fr.hdf.idao;

import java.util.List;

import fr.hdf.entities.Enseignant;

public interface IEnseignantDao {

	public void addEnseignant(Enseignant enseignant);
	
	public List<Enseignant> getAllEnseignants();
	
	void supprEnseignant(Enseignant enseignant);
}
