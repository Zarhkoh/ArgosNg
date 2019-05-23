package fr.hdf.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.hdf.entities.Diplome;
import fr.hdf.entities.Eleve;
import fr.hdf.iservices.IDiplomeService;
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
	@Autowired
	private IDiplomeService diplomeService;
	
	
	private Eleve eleve;
	
	private String nom;
	private String prenom;
	private List<Eleve> listEleves;
	private Diplome diplomeEleve;
	private List<Diplome> listDiplomes;
	private Long idDiplome;
	



	public Long getIdDiplome() {
		return idDiplome;
	}

	public void setIdDiplome(Long idDiplome) {
		this.idDiplome = idDiplome;
	}

	@PostConstruct
	public void init() {
		listEleves = getEleveService().recupEleves(); 
		listDiplomes = getDiplomeService().recupDiplomes();
		eleve = new Eleve();
		diplomeEleve = new Diplome();
	}
	
	public void traitementAjoutEleve() {
		getEleve();
		getDiplomeEleve();
		eleve= new Eleve();
		eleve.setNomEleve(nom);
		eleve.setPrenomEleve(prenom);
		diplomeEleve = diplomeService.getDiplomeByiD(idDiplome);
		eleve.setDiplomeEleve(diplomeEleve);
		getEleveService().ajouterEleve(eleve);
		setNom(null);
		setPrenom(null);
		System.out.println(eleve.getNomEleve() + " " + eleve.getPrenomEleve() +  " ajouté(e) à la base de donnée.");		
		listEleves = getEleveService().recupEleves(); 
		}
	
	
	
	
	public void elevesSansDiplome(){
		for (int i = 0; i < listEleves.size(); i++) {
			Eleve el = listEleves.get(i);
			if (el.getDiplomeEleve() != null) {
				System.out.println(el.getNomEleve().substring(0, 3).concat(el.getPrenomEleve().substring(el.getPrenomEleve().length()-3)).concat("_" + el.getNomEleve().substring(3)));
			}
			
		}		
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

	public Diplome getDiplomeEleve() {
		return diplomeEleve;
	}

	public void setDiplomeEleve(Diplome diplomeEleve) {
		this.diplomeEleve = diplomeEleve;
	}

	public List<Diplome> getListDiplomes() {
		return listDiplomes;
	}

	public void setListDiplomes(List<Diplome> listDiplomes) {
		this.listDiplomes = listDiplomes;
	}

	public IDiplomeService getDiplomeService() {
		return diplomeService;
	}

	public void setDiplomeService(IDiplomeService diplomeService) {
		this.diplomeService = diplomeService;
	}

}
