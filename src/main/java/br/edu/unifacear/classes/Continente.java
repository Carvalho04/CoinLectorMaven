package br.edu.unifacear.classes;


import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import br.edu.unifacear.classes.Pais;
@Entity
public class Continente implements EntityBase{
	
	//Attributes
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		private String descricao;
		
		@OneToMany (cascade = CascadeType.ALL, mappedBy = "continente")
		private List<Pais> paises;
		
		//Properties
		
		public List<Pais> getPaises() {
			return paises;
		}
		public void setPaises(List<Pais> paises) {
			this.paises = paises;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		
		//Constructor
		
		public Continente() {
			super();
		}
		
		
		public Continente(int id, String descricao) {
			super();
			this.id = id;
			this.descricao = descricao;
		
		}
		
		
		//Methods	
		
		@Override
		public int hashCode() {
			return Objects.hash(descricao, id);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Continente other = (Continente) obj;
			return Objects.equals(descricao, other.descricao) && id == other.id;
		}
		
		
		@Override
		public String toString() {
			return "TipoContinente [id=" + id + ", descricao=" + descricao + "]";
		}


}
