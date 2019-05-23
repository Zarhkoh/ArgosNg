package fr.hdf.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.hdf.entities.Enseignant;
import fr.hdf.iservices.IEnseignantService;

@Controller("enseignantCtrl")
@Scope("session")
public class EnseignantController {

	
	@Autowired
	private IEnseignantService enseignantService;
	
	private Enseignant enseignant;
	
	private String nom;
	private String prenom;
	private String matiere;
	private List<Enseignant> listEnseignants;
	
	@PostConstruct
	public void init() {
		listEnseignants = getEnseignantService().recupEnseignants();
	}
	
	public void traitementAjoutEnseignant() {
		enseignant = new Enseignant();
		enseignant.setNomEnseignant(nom);
		enseignant.setPrenomEnseignant(prenom);
		enseignant.setMatiereEnseignant(matiere);
		getEnseignantService().ajouterEnseignant(enseignant);
		setNom(null);
		setPrenom(null);
		setMatiere(null);
		System.out.println(enseignant.getPrenomEnseignant() + " " + enseignant.getNomEnseignant() + "a été ajouté à la liste des enseignants.");
		listEnseignants = getEnseignantService().recupEnseignants();
	}

	public void supprimerEnseignant(Enseignant enseignant) {
		
		getEnseignantService().supprimerEnseignant(enseignant);
		listEnseignants = getEnseignantService().recupEnseignants();
	}

	public IEnseignantService getEnseignantService() {
		return enseignantService;
	}

	public void setEnseignantService(IEnseignantService enseignantService) {
		this.enseignantService = enseignantService;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
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

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public List<Enseignant> getListEnseignants() {
		return listEnseignants;
	}

	public void setListEnseignants(List<Enseignant> listEnseignants) {
		this.listEnseignants = listEnseignants;
	}
}
