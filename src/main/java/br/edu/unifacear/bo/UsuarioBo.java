package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.dao.UsuarioDao;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.UsuarioDao;

public class UsuarioBo {

public UsuarioBo() {	}

	public void salvar(Usuario usuario) throws Exception {
		validarDadosUsuario(usuario);

		// Chamando a DAO Gen�rica
		GenericDao<Usuario> dao  = new GenericDao<Usuario>();
		try {
			dao.salvarOuAtualizar(usuario);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Usuario> consultar() throws Exception{	
		// Chamando a DAO Gen�rica	
		GenericDao<Usuario> dao  = new GenericDao<Usuario>();
		try {
			return dao.list(Usuario.class);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}		
	
	public String deletar(Usuario usuario) throws Exception {
		
		// Chamar a Dao do Usuario para deletar o usuario no BD
		UsuarioDao dao = new UsuarioDao();
		try {
			return dao.deletar(usuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}		
	
	public List<Usuario> consultar(String nomePesquisa) throws Exception{	
		
		UsuarioDao dao = new UsuarioDao();
		try {
			return dao.consultar(nomePesquisa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosUsuario(Usuario usuario) throws Exception {
		// Valida��o da regra de neg�cio
		if (usuario.getNome() == "") {
			throw new Exception ("Nome deve estar preenchido");
		}
		if (usuario.getCpf() == "") {
			throw new Exception ("CPF deve estar preenchido");
		}
		if (usuario.getEmail() == "") {
			throw new Exception ("E-mail deve estar preenchido");
		}
		if (usuario.getLogin() == "") {
			throw new Exception ("Login deve estar preenchido");
		}
		if (usuario.getSenha() == "") {
			throw new Exception ("Senha deve estar preenchido");
		}
		
	}
}
