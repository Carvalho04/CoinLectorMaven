package br.edu.unifacear.bo;

import java.sql.SQLException;
import java.util.*;

import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.dao.PaisDao;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.PaisDao;

public class PaisBo {
	
	public PaisBo () {	}

	public void salvar(Pais pais) throws Exception {
		validarDadosPais(pais);

		// Chamando a DAO Gen�rica
		GenericDao<Pais> dao  = new GenericDao<Pais>();
		try {
			dao.salvarOuAtualizar(pais);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Pais> consultar() throws Exception{	
		// Chamando a DAO Gen�rica	
		GenericDao<Pais> dao  = new GenericDao<Pais>();
		try {
			return dao.list(Pais.class);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}		
	
	public String deletar(Pais pais) throws Exception {
		
		// Chamar a Dao do Pais para deletar o pais no BD
		PaisDao dao = new PaisDao();
		try {
			return dao.deletar(pais);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}		
	
	public List<Pais> consultar(String nomePesquisa) throws Exception{	
		
		PaisDao dao = new PaisDao();
		try {
			return dao.consultar(nomePesquisa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosPais(Pais pais) throws Exception {
		// Valida��o da regra de neg�cio
		if (pais.getNome().equals("")) {
			throw new Exception("Nome do pais n�o pode ficar em branco!");
		}
		
	}
}
