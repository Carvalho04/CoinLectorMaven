package br.edu.unifacear.classes;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
//@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", 
//initialValue = 1, allocationSize = 1)

public class Usuario implements EntityBase{

	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nome;
	private String cpf;
	private String email;
	private String login;
	private String senha;
	
	@ManyToOne 
	@JoinColumn(name = "id_TpUsuario")
	private TipoUsuario tipoUsuario;
	
	
	//Properties (get e set)
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
	//Constructor
	

	
	public Usuario(int id, String nome, String cpf, String email, String login, String senha, TipoUsuario tipoUsuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}

	
	//Methods
		
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, id, nome, login, senha);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(nome, other.nome) && Objects.equals(login, other.login) && Objects.equals(senha, other.senha) && Objects.equals(tipoUsuario, other.tipoUsuario);
	}

	@Override
	public String toString() {
		return "Usuário [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", login=" + login + ", senha=" + senha + ", tipo usuario=" + tipoUsuario.getId() +"]";
		
	}
	
	
	
}