package fr.hdf.iservices;

import java.util.List;

import fr.hdf.entities.Diplome;

public interface IDiplomeService {

	
	
	public void ajouterDiplome(Diplome d1);
	
	public List<Diplome> recupDiplomes();
	
	public void supprimerDiplome (Diplome diplome);

	public void modifierDiplome(Diplome d1);

	public Diplome getDiplomeByiD(Long idDiplome);

}
