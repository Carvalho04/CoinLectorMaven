package br.edu.unifacear.classes;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Colecao implements EntityBase{
	
	 //Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	
	 private int ano;
	 
	 @OneToOne (cascade = CascadeType.ALL)
	 private Usuario colecionador;
	 @OneToOne (cascade = CascadeType.ALL)
	 private EstadoConservacao estadoConservacao;
	 @ManyToOne
	 @JoinColumn(name = "id_Moeda")
	 private Moeda moeda; 
	 
	 
	 //Properties
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Usuario getColecionador() {
		return colecionador;
	}
	public void setColecionador(Usuario colecionador) {
		this.colecionador = colecionador;
	}
	public Moeda getMoeda() {
		return moeda;
	}
	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}
	public EstadoConservacao getEstadoConservacao() {
		return estadoConservacao;
	}
	public void setEstadoConservacao(EstadoConservacao estadoConservacao) {
		this.estadoConservacao = estadoConservacao;
	}
	
	//Constructors 
	
	public Colecao() {
		super();
		moeda = new Moeda();
		estadoConservacao = new EstadoConservacao();
		colecionador = new Usuario();
		
	}
	//Usuario colecionador, Moeda moeda,
	public Colecao(int id, int ano, EstadoConservacao estadoConservacao, Usuario colecionador, Moeda moeda) {
		super();
		this.id = id;
		this.ano = ano;
		this.colecionador = colecionador;
		this.moeda = moeda;
		this.estadoConservacao = estadoConservacao;
	}
	
	
	//Methods
	
	@Override
	public int hashCode() {
		return Objects.hash(ano, estadoConservacao, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colecao other = (Colecao) obj;
		return ano == other.ano 
				&& Objects.equals(estadoConservacao, other.estadoConservacao)
				&& Objects.equals(colecionador, other.colecionador)
				&& Objects.equals(moeda, other.moeda)
				&& id == other.id
	;
	}
	@Override
	public String toString() {
		return "Colecao [id=" + id + ", ano=" + ano +  ", colecionador=" + colecionador.getId()
				+ ", moeda=" + moeda.getId()
				+ ", estadoConservacao=" + estadoConservacao.getId() + "]";
	}
	
	  
	  
}
