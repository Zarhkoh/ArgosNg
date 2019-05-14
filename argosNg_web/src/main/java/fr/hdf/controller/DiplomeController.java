package fr.hdf.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.hdf.entities.Diplome;
import fr.hdf.entities.Eleve;
import fr.hdf.iservices.IDiplomeService;

@Controller("diplomeCtrl")
@Scope("session")
public class DiplomeController {

	@Autowired
	private IDiplomeService diplomeService;
	
	private Diplome diplome;
	private String libelle;
	private Date dateObtention;
	private List<Diplome> listDiplomes;
	
	@PostConstruct
	public void init() {
		listDiplomes = getDiplomeService().recupDiplomes(); 
	}
	

	public void traitementAjoutDiplome() {
		diplome = new Diplome();
		diplome.setLibelleDiplome(libelle);
		diplome.setDateObtentionDiplome(dateObtention);
		getDiplomeService().ajouterDiplome(diplome);
		setLibelle(null);
		setDateObtention(null);
		listDiplomes = getDiplomeService().recupDiplomes();
	}
	
	public void supprimerDiplome(Diplome diplome) {
		getDiplomeService().supprimerDiplome(diplome);
		listDiplomes = getDiplomeService().recupDiplomes();
	}

	public IDiplomeService getDiplomeService() {
		return diplomeService;
	}

	public void setDiplomeService(IDiplomeService diplomeService) {
		this.diplomeService = diplomeService;
	}

	public Diplome getDiplome() {
		return diplome;
	}

	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDateObtention() {
		return dateObtention;
	}

	public void setDateObtention(Date dateObtention) {
		this.dateObtention = dateObtention;
	}

	public List<Diplome> getListDiplomes() {
		return listDiplomes;
	}

	public void setListDiplomes(List<Diplome> listDiplomes) {
		this.listDiplomes = listDiplomes;
	}
}
