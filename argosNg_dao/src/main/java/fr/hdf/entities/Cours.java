package fr.hdf.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Cours implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CoursPK coursPK;
	private Eleve eleve;
	private Enseignant enseignant;

	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false, name = "idEleve", referencedColumnName = "idEleve")
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false, name = "idEnseignant", referencedColumnName = "idEnseignant")
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	@EmbeddedId
	public CoursPK getCoursPK() {
		return coursPK;
	}
	public void setCoursPK(CoursPK coursPK) {
		this.coursPK = coursPK;
	}
	
	
	private String intituleCours;

	public String getIntituleCours() {
		return intituleCours;
	}
	public void setIntituleCours(String intituleCours) {
		this.intituleCours = intituleCours;
	}

	}
