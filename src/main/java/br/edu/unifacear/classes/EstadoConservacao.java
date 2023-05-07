package br.edu.unifacear.classes;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class EstadoConservacao implements EntityBase{

		//Attributes
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private int id;
			
			private String descricao;
			
			//@OneToOne (cascade = CascadeType.ALL)
			//private Colecao colecao;
			
			
			//Properties
			
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
			
			public EstadoConservacao() {
				super();
			}
			
			public EstadoConservacao(int id, String descricao) {
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
				EstadoConservacao other = (EstadoConservacao) obj;
				return Objects.equals(descricao, other.descricao) && id == other.id;
			}
			@Override
			public String toString() {
				return "EstadoConservacao [id=" + id + ", descricao=" + descricao + "]";
			}
			
			
}