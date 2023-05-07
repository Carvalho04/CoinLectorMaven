package br.edu.unifacear.bo;

import java.sql.SQLException;
import java.util.List;

import br.edu.unifacear.classes.Continente;
import br.edu.unifacear.classes.Continente;
import br.edu.unifacear.dao.ContinenteDao;
import br.edu.unifacear.dao.ContinenteDao;
import br.edu.unifacear.dao.GenericDao;

public class ContinenteBo {

	public ContinenteBo () { 	}

	public void salvar(Continente continente) throws Exception {
		validarDadosContinente(continente);

		// Chamando a DAO Gen�rica
		GenericDao<Continente> dao  = new GenericDao<Continente>();
		try {
			dao.salvarOuAtualizar(continente);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Continente> consultar() throws Exception{	
		// Chamando a DAO Gen�rica	
		GenericDao<Continente> dao  = new GenericDao<Continente>();
		try {
			return dao.list(Continente.class);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}		
	
	public String deletar(Continente continente) throws Exception {
		
		// Chamar a Dao do Continente para deletar o continente no BD
		ContinenteDao dao = new ContinenteDao();
		try {
			return dao.deletar(continente);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}		
	
	public List<Continente> consultar(String nomePesquisa) throws Exception{	
		
		ContinenteDao dao = new ContinenteDao();
		try {
			return dao.consultar(nomePesquisa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosContinente(Continente continente) throws Exception {
		// Valida��o da regra de neg�cio
		if (continente.getDescricao().equals("")) {
			throw new Exception("Nome do continente n�o pode ficar em branco!");
		}
		
	}
	
	
}
