package fr.hdf.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Enseignant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idEnseignant;
	private String nomEnseignant;
	private String prenomEnseignant;
	private String matiereEnseignant;
	
	private List<Eleve> eleves;
	
	public void assignElevesToThisEnseignant(List<Eleve> eleves) {
		
		this.setEleves(eleves);
		for(Eleve e: eleves)
		{
			e.setEnseignant(this);
		}
	}
	
	@OneToMany(mappedBy="enseignant", cascade = CascadeType.ALL)
	public List<Eleve> getEleves() {
		return eleves;
	}
	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdEnseignant() {
		return idEnseignant;
	}
	public void setIdEnseignant(Long idEnseignant) {
		this.idEnseignant = idEnseignant;
	}
	public String getNomEnseignant() {
		return nomEnseignant;
	}
	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}
	public String getPrenomEnseignant() {
		return prenomEnseignant;
	}
	public void setPrenomEnseignant(String prenomEnseignant) {
		this.prenomEnseignant = prenomEnseignant;
	}
	public String getMatiereEnseignant() {
		return matiereEnseignant;
	}
	public void setMatiereEnseignant(String matiereEnseignant) {
		this.matiereEnseignant = matiereEnseignant;
	}

	

}
