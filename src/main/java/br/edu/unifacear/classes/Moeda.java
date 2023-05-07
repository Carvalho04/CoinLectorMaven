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
public class Moeda implements EntityBase{
//	
//	
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String descricao;
	private String cunhagem;
	private double peso;
	private double diametro;
	private double espessura;
	private double valor_face;
	private int ano;

	@ManyToOne 
	@JoinColumn(name = "id_Forma")
	private Forma forma;
	@ManyToOne 
	@JoinColumn(name = "id_Distribuicao")
	private Distribuicao distribuicao;
	@ManyToOne 
	@JoinColumn(name = "id_Composicao")
	private Composicao composicao;
	@ManyToOne 
	@JoinColumn(name = "id_Borda")
	private Borda borda;
	@ManyToOne 
	@JoinColumn(name = "id_Pais")
	private Pais pais;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "moeda")
	private List <Colecao> colecoes;
	
	//Properties
	
	public List<Colecao> getMoedas() {
		return colecoes;
	}

	public void setMoedas(List<Colecao> colecoes) {
		this.colecoes = colecoes;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCunhagem() {
		return cunhagem;
	}
	public void setCunhagem(String cunhagem) {
		this.cunhagem = cunhagem;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getDiametro() {
		return diametro;
	}
	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	public double getEspessura() {
		return espessura;
	}
	public void setEspessura(double espessura) {
		this.espessura = espessura;
	}
	public double getValor_face() {
		return valor_face;
	}
	public void setValor_face(double valor_face) {
		this.valor_face = valor_face;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Forma getForma() {
		return forma;
	}
	public void setForma(Forma forma) {
		this.forma = forma;
	}
	public Distribuicao getDistribuicao() {
		return distribuicao;
	}
	public void setDistribuicao(Distribuicao distribuicao) {
		this.distribuicao = distribuicao;
	}
	public Composicao getComposicao() {
		return composicao;
	}
	public void setComposicao(Composicao composicao) {
		this.composicao = composicao;
	}
	public Borda getBorda() {
		return borda;
	}
	public void setBorda(Borda borda) {
		this.borda = borda;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
//	public Colecao getColecao() {
//		return colecao;
//	}
//	public void setColecao(Colecao colecao) {
//		this.colecao = colecao;
//	}
	
	//	//Constructor
//	
//	public Moeda() {
//		forma = new Forma();
//		distribuicao = new Distribuicao();
//		composicao = new Composicao();
//		borda = new Borda();
//		pais = new Pais();
//	}
//	
//	public Moeda(int id, String nome, String descricao, String cunhagem, double peso, double diametro,
//			 double espessura, int valor_face, int ano, Forma forma, 
//			Distribuicao distribuicao, Composicao composicao, Borda borda, Pais pais) {
//		
//		super();
//		this.id = id;
//		this.nome = nome;
//		this.descricao = descricao;
//		this.cunhagem = cunhagem;
//		this.peso = peso;
//		this.diametro = diametro;
//		this.espessura = espessura;
//		this.valor_face = valor_face;
//		this.ano = ano;
//		this.forma = forma;
//		this.distribuicao = distribuicao;
//		this.composicao = composicao;
//		this.borda = borda;
//		this.pais = pais;
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(ano, composicao, cunhagem, descricao, diametro, distribuicao, espessura,
//				forma, id, nome, pais, peso, borda, valor_face);
//	}
//	
//	
//	//Methods
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Moeda other = (Moeda) obj;
//		return Objects.equals(ano, other.ano)
//				&& Objects.equals(composicao, other.composicao) && Objects.equals(cunhagem, other.cunhagem)
//				&& Objects.equals(descricao, other.descricao)
//				&& Double.doubleToLongBits(diametro) == Double.doubleToLongBits(other.diametro)
//				&& Objects.equals(distribuicao, other.distribuicao)
//				&& Double.doubleToLongBits(espessura) == Double.doubleToLongBits(other.espessura)
//				&& Objects.equals(forma, other.forma) && id == other.id && Objects.equals(nome, other.nome)
//				&& Objects.equals(pais, other.pais)
//				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso)
//				&& Objects.equals(borda, other.borda) && valor_face == other.valor_face;
//	}
//	@Override
//	public String toString() {
//		return "Moeda [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", cunhagem=" + cunhagem + ", peso="
//				+ peso + ", diametro=" + diametro + ", espessura=" + espessura + ", valor_face=" + valor_face 
//				+ ", ano=" + ano + ", forma=" + forma.getId() + ", distribuicao=" + distribuicao.getId()
//				+ ", composicao=" + composicao.getId() + ", borda=" + borda.getId() + ", pais=" + pais.getId() + "]";
//	}
//	
//
	public Moeda(int id, String nome, String descricao, String cunhagem, double peso, double diametro, double espessura,
			double valor_face, int ano, Borda borda, Composicao composicao, Distribuicao distribuicao, Forma forma, Pais pais, Colecao colecao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.cunhagem = cunhagem;
		this.peso = peso;
		this.diametro = diametro;
		this.espessura = espessura;
		this.valor_face = valor_face;
		this.ano = ano;
		this.borda = borda;
		this.composicao = composicao;
		this.distribuicao = distribuicao;
		this.forma = forma;
		this.pais = pais;
		//this.colecao = colecao;
	}
	public Moeda() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(ano, borda, composicao, distribuicao, forma, pais, cunhagem, descricao, diametro, espessura, id, nome, peso,
				valor_face);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moeda other = (Moeda) obj;
		return ano == other.ano && Objects.equals(borda, other.borda) && Objects.equals(composicao, other.composicao)
				&& Objects.equals(distribuicao, other.distribuicao) && Objects.equals(forma, other.forma)
//				&& Objects.equals(pais, other.pais)  && Objects.equals(colecao, other.colecao)
				&& Objects.equals(cunhagem, other.cunhagem) && Objects.equals(descricao, other.descricao)
				&& Double.doubleToLongBits(diametro) == Double.doubleToLongBits(other.diametro)
				&& Double.doubleToLongBits(espessura) == Double.doubleToLongBits(other.espessura) && id == other.id
				&& Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso)
				&& Double.doubleToLongBits(valor_face) == Double.doubleToLongBits(other.valor_face);
	}
	
	

	
}
