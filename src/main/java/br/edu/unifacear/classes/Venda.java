package br.edu.unifacear.classes;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Venda implements EntityBase{

	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
//	@Temporal(TemporalType.TIMESTAMP)
	private int data;
	@OneToOne (cascade = CascadeType.ALL)
	private Usuario usuarioComprador;
	@OneToOne (cascade = CascadeType.ALL)
	private Usuario usuarioVendedor;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "venda")
	private List<ItensAVenda> itensVenda;
	
	//Properties
	
	public List<ItensAVenda> getItensAVenda() {
		return itensVenda;
	}
	public void setItensAVenda(List<ItensAVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Usuario getUsuraioComprador() {
		return usuarioComprador;
	}
	public void setUsuraioComprador(Usuario usuarioComprador) {
		this.usuarioComprador = usuarioComprador;
	}
	public Usuario getUsuarioVendedor() {
		return usuarioVendedor;
	}
	public void setUsuarioVendedor(Usuario usuarioVendedor) {
		this.usuarioVendedor = usuarioVendedor;
	}
	
	
	//Constructor
	
	public Venda() {
		super();
		usuarioComprador = new Usuario();
		usuarioVendedor = new Usuario();
	}
	
	public Venda(int id, int data, Usuario usuarioComprador, Usuario usuarioVendedor) {
		super();
		this.id = id;
		this.data = data;
		this.usuarioComprador = usuarioComprador;
		this.usuarioVendedor = usuarioVendedor;
	}
	
	
	//Methods
	
	@Override
	public int hashCode() {
		return Objects.hash(data, id, usuarioComprador, usuarioVendedor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return Objects.equals(data, other.data) && id == other.id
				&& Objects.equals(usuarioComprador, other.usuarioComprador)
				&& Objects.equals(usuarioVendedor, other.usuarioVendedor);
	}
	
	@Override
	public String toString() {
		return "Venda [id=" + id + ", data=" + data + ", usuarioComprador=" + usuarioComprador.getId() + ", usuarioVendedor="
				+ usuarioVendedor.getId() + "]";
	}
		
}