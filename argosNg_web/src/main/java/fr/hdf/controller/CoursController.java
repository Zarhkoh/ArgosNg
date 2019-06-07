package fr.hdf.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.hdf.entities.Cours;
import fr.hdf.iservices.ICoursService;

@Controller("coursCtrl")
@Scope("session")
public class CoursController {

@Autowired
private ICoursService coursService;


private Cours cours;
private String intitule;
private List<Cours> listCours;

public void init() {
	listCours = getCoursService().recupCours(); 
}


public void traitementAjoutCours() {
	getCours();
	cours = new Cours();
	cours.setIntituleCours(intitule);
	getCoursService().ajouterCours(cours);
	setIntitule(null);
	listCours = getCoursService().recupCours();
}

public void supprimerCours(Cours cours) {
	getCoursService().supprimerCours(cours);
	listCours = getCoursService().recupCours();
}

public String redirectToCoursPage() {
	init();
	return "/pages/gestionCours.xhtml";
}


public ICoursService getCoursService() {
	return coursService;
}
public void setCoursService(ICoursService coursService) {
	this.coursService = coursService;
}
public Cours getCours() {
	return cours;
}
public void setCours(Cours cours) {
	this.cours = cours;
}
public String getIntitule() {
	return intitule;
}
public void setIntitule(String intitule) {
	this.intitule = intitule;
}
public List<Cours> getListCours() {
	return listCours;
}
public void setListCours(List<Cours> listCours) {
	this.listCours = listCours;
}

}
