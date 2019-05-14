package fr.hdf.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.hdf.entities.Diplome;
import fr.hdf.entities.Eleve;
import fr.hdf.iservices.IEleveService;

@Controller("eleveCtrl")
@Scope("session")
public class EleveController {
	
	public void supprimerEleve(Eleve eleve) {
		getEleveService().supprimerEleve(eleve);
		listEleves = getEleveService().recupEleves();
	}
	
	@Autowired
	private IEleveService eleveService;
	
	private Eleve eleve;
	
	private String nom;
	private String prenom;
	private Diplome diplome;
	private List<Eleve> listEleves;
	
	@PostConstruct
	public void init() {
		listEleves = getEleveService().recupEleves(); 
	}
	
	public void traitementAjoutEleve() {
		eleve= new Eleve();
		eleve.setNomEleve(nom);
		eleve.setPrenomEleve(prenom);
		eleve.setDiplome(diplome);
		getEleveService().ajouterEleve(eleve);
		setNom(null);
		setPrenom(null);
		System.out.println(eleve.getNomEleve() + " " + eleve.getPrenomEleve() +  " ajouté(e) à la base de donnée.");		
		listEleves = getEleveService().recupEleves(); 
	}
	
	public List<Eleve> getListEleves() {
		return listEleves;
	}

	public void setListEleves(List<Eleve> listEleves) {
		this.listEleves = listEleves;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public IEleveService getEleveService() {
		return eleveService;
	}

	public void setEleveService(IEleveService eleveService) {
		this.eleveService = eleveService;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

}
