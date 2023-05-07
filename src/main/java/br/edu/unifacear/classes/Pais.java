package br.edu.unifacear.classes;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pais implements EntityBase{

	//Attribute
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	@ManyToOne 
	@JoinColumn(name = "id_Continente")
	private Continente continente;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "pais")
	private List <Moeda> moedas;
	
	//Properties
	
	public List<Moeda> getMoedas() {
		return moedas;
	}

	public void setMoedas(List<Moeda> moedas) {
		this.moedas = moedas;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Continente getContinente() {
		return continente;
	}
	public void setContinente(Continente continente) {
		this.continente = continente;
	}

	
	//Constructors
	
	public Pais() {
		super();
	}

	public Pais(int id, String nome, Continente continente) {
		super();
		this.id = id;
		this.nome = nome;
		this.continente = continente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(continente, id, nome);
	}

	
	//Methods
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(continente, other.continente) && id == other.id && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", continente=" + continente.getId() + "]";
	}
	
	
}
	