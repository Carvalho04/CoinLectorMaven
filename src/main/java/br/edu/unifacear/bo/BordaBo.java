package br.edu.unifacear.bo;

import java.sql.SQLException;
import java.util.*;
import br.edu.unifacear.classes.Borda;
import br.edu.unifacear.classes.Borda;
import br.edu.unifacear.dao.BordaDao;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.BordaDao;

public class BordaBo {
	
	public BordaBo () { 	}
	
	public void salvar(Borda borda) throws Exception {
		validarDadosBorda(borda);

		// Chamando a DAO Gen�rica
		GenericDao<Borda> dao = new GenericDao<Borda>();
		try {
			dao.salvarOuAtualizar(borda);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
//	public List<Borda> consultar() throws Exception{	
//		// Chamando a DAO Gen�rica	
//		GenericDao<Borda> dao  = new GenericDao<Borda>();
//		try {
//			return dao.list(Borda.class);
//		}
//		catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return null;		
//	}		
	
	public String deletar(Borda borda) throws Exception {
		
		// Chamar a Dao do Borda para deletar o borda no BD
		BordaDao dao = new BordaDao();
		try {
			return dao.deletar(borda);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}		
	
	public List<Borda>consultar(String nomePesquisa) throws Exception{	
		
		BordaDao dao = new BordaDao();
		try {
			return dao.consultar(nomePesquisa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosBorda(Borda borda) throws Exception {
		// Valida��o da regra de neg�cio
		if (borda.getDescricao().equals("")) {
			throw new Exception("Nome do borda n�o pode ficar em branco!");
		}
		
	}
}
