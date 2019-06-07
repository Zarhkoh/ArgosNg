package fr.hdf.idao;

import java.util.List;

import fr.hdf.entities.Diplome;
import fr.hdf.entities.Eleve;

public interface IEleveDao {
	public void addEleve(Eleve eleve);
	
	public List<Eleve> getAllEleves();

	void supprEleve(Eleve eleve);
	
	public void editEleve(Eleve eleve);

}
