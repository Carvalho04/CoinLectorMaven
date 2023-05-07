package br.edu.unifacear.bo;

import java.sql.SQLException;
import java.util.*;

import br.edu.unifacear.classes.EstadoConservacao;
import br.edu.unifacear.classes.EstadoConservacao;
import br.edu.unifacear.dao.EstadoConservacaoDao;
import br.edu.unifacear.dao.EstadoConservacaoDao;
import br.edu.unifacear.dao.GenericDao;


public class EstadoConservacaoBo {
	
public EstadoConservacaoBo() {	}
		
	public void salvar(EstadoConservacao estadoConservacao) throws Exception {
		validarDadosEstadoConservacao(estadoConservacao);
	
		// Chamando a DAO Gen�rica
		GenericDao<EstadoConservacao> dao  = new GenericDao<EstadoConservacao>();
		try {
			dao.salvarOuAtualizar(estadoConservacao);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<EstadoConservacao> consultar() throws Exception{	
		// Chamando a DAO Gen�rica	
		GenericDao<EstadoConservacao> dao  = new GenericDao<EstadoConservacao>();
		try {
			return dao.list(EstadoConservacao.class);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}		
	
	public String deletar(EstadoConservacao estadoConservacao) throws Exception {
		
		// Chamar a Dao do EstadoConservacao para deletar o estadoConservacao no BD
		EstadoConservacaoDao dao = new EstadoConservacaoDao();
		try {
			return dao.deletar(estadoConservacao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}		
	
	public List<EstadoConservacao> consultar(String nomePesquisa) throws Exception{	
		
		EstadoConservacaoDao dao = new EstadoConservacaoDao();
		try {
			return dao.consultar(nomePesquisa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	
	
	private void validarDadosEstadoConservacao(EstadoConservacao estadoConservacao) throws Exception {
		// Valida��o da regra de neg�cio
		if (estadoConservacao.getDescricao().equals("")) {
			throw new Exception("Nome do estadoConservacao n�o pode ficar em branco!");
		}
	
}
}
	
		
