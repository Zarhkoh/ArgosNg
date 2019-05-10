package fr.hdf.dao;

import java.util.List;

import fr.hdf.entities.Eleve;

public interface IEleveDao {
	public void addEleve(Eleve eleve);
	
	public List<Eleve> getAllEleves();

}
