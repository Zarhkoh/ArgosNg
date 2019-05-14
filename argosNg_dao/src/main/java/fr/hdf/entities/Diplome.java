package fr.hdf.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Diplome implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idDiplome;
	private String libelleDiplome;
	private Date dateObtentionDiplome;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdDiplome() {
		return idDiplome;
	}
	public void setIdDiplome(Long idDiplome) {
		this.idDiplome = idDiplome;
	}
	public String getLibelleDiplome() {
		return libelleDiplome;
	}
	public void setLibelleDiplome(String libelleDiplome) {
		this.libelleDiplome = libelleDiplome;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDateObtentionDiplome() {
		return dateObtentionDiplome;
	}
	public void setDateObtentionDiplome(Date dateObtentionDiplome) {
		this.dateObtentionDiplome = dateObtentionDiplome;
	}
}
