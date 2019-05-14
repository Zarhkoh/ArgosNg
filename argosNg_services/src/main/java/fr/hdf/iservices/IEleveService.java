package fr.hdf.iservices;

import java.util.List;

import fr.hdf.entities.Eleve;

public interface IEleveService {

	public void ajouterEleve(Eleve e1);
	public List<Eleve> recupEleves();
	public void supprimerEleve(Eleve eleve);
}