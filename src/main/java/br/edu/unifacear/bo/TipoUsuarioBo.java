package br.edu.unifacear.bo;

import java.sql.SQLException;
import java.util.List;

import br.edu.unifacear.classes.TipoUsuario;
import br.edu.unifacear.classes.TipoUsuario;
import br.edu.unifacear.dao.TipoUsuarioDao;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.TipoUsuarioDao;

public class TipoUsuarioBo {

	public TipoUsuarioBo () { 	}
	
	public void salvar(TipoUsuario tipoUsuario) throws Exception {
		validarDadosTipoUsuario(tipoUsuario);

		// Chamando a DAO Gen�rica
		GenericDao<TipoUsuario> dao  = new GenericDao<TipoUsuario>();
		try {
			dao.salvarOuAtualizar(tipoUsuario);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<TipoUsuario> consultar() throws Exception{	
		// Chamando a DAO Gen�rica	
		GenericDao<TipoUsuario> dao  = new GenericDao<TipoUsuario>();
		try {
			return dao.list(TipoUsuario.class);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}		
	
	public String deletar(TipoUsuario tipoUsuario) throws Exception {
		
		// Chamar a Dao do TipoUsuario para deletar o tipoUsuario no BD
		TipoUsuarioDao dao = new TipoUsuarioDao();
		try {
			return dao.deletar(tipoUsuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}		
	
	public List<TipoUsuario> consultar(String nomePesquisa) throws Exception{	
		
		TipoUsuarioDao dao = new TipoUsuarioDao();
		try {
			return dao.consultar(nomePesquisa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosTipoUsuario(TipoUsuario tipoUsuario) throws Exception {
		// Valida��o da regra de neg�cio
		if (tipoUsuario.getTipo().equals("")) {
			throw new Exception ("Tipo deve estar preenchido!");
		}
		
	}
}
