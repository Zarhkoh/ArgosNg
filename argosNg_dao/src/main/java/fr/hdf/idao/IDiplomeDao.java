package fr.hdf.idao;

import java.util.List;

import fr.hdf.entities.Diplome;

public interface IDiplomeDao {
	public void addDiplome(Diplome diplome);

	public List<Diplome> getAllDiplomes();

	void supprDiplome(Diplome diplome);
}
