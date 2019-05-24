
package fr.hdf.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Eleve implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idEleve;
	private String nomEleve;
	private String prenomEleve;
	
	private Diplome diplomeEleve;
	private List<Cours> courses;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(Long idEleve) {
		this.idEleve = idEleve;
	}

	public String getNomEleve() {
		return nomEleve;
	}

	public void setNomEleve(String nomEleve) {
		this.nomEleve = nomEleve;
	}

	public String getPrenomEleve() {
		return prenomEleve;
	}

	public void setPrenomEleve(String prenomEleve) {
		this.prenomEleve = prenomEleve;
	}

	public Eleve(String nomEleve, String prenomEleve) {
		super();
		this.nomEleve = nomEleve;
		this.prenomEleve = prenomEleve;
	}

	public Eleve() {

	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(insertable = true, name = "idDiplome", referencedColumnName = "idDiplome")
	public Diplome getDiplomeEleve() {
		return diplomeEleve;
	}

	public void setDiplomeEleve(Diplome dipElv) {
		this.diplomeEleve = dipElv;
	}

	@OneToMany(mappedBy = "eleve")
	public List<Cours> getCourses() {
		return courses;
	}

	public void setCourses(List<Cours> courses) {
		this.courses = courses;
	}

	public void assignCoursesToThisEleve(List<Cours> courses) {
		this.setCourses(courses);
		for(Cours c : courses) {
			c.setEleve(this);
		}
	}
}
