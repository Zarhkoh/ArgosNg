package fr.hdf.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CoursPK implements Serializable {

		public Long getIdEleve() {
		return idEleve;
	}
	public void setIdEleve(Long idEleve) {
		this.idEleve = idEleve;
	}
	public Long getIdEnseignant() {
		return idEnseignant;
	}
	public void setIdEnseignant(Long idEnseignant) {
		this.idEnseignant = idEnseignant;
	}
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private Long idEleve;
		private Long idEnseignant;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((idEleve == null) ? 0 : idEleve.hashCode());
			result = prime * result + ((idEnseignant == null) ? 0 : idEnseignant.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CoursPK other = (CoursPK) obj;
			if (idEleve == null) {
				if (other.idEleve != null)
					return false;
			} else if (!idEleve.equals(other.idEleve))
				return false;
			if (idEnseignant == null) {
				if (other.idEnseignant != null)
					return false;
			} else if (!idEnseignant.equals(other.idEnseignant))
				return false;
			return true;
		}


}
