package br.edu.unifacear.bo;

import java.sql.SQLException;
import java.util.List;

import br.edu.unifacear.classes.Composicao;
import br.edu.unifacear.classes.Composicao;
import br.edu.unifacear.classes.Composicao;
import br.edu.unifacear.dao.ComposicaoDao;
import br.edu.unifacear.dao.ComposicaoDao;
import br.edu.unifacear.dao.GenericDao;

public class ComposicaoBo {
	
	public ComposicaoBo() {	}

	public void salvar(Composicao composicao) throws Exception {
		validarDadosComposicao(composicao);

		// Chamando a DAO Gen�rica
		GenericDao<Composicao> dao  = new GenericDao<Composicao>();
		try {
			dao.salvarOuAtualizar(composicao);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Composicao> consultar() throws Exception{	
		// Chamando a DAO Gen�rica	
		GenericDao<Composicao> dao  = new GenericDao<Composicao>();
		try {
			return dao.list(Composicao.class);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}		
	
	public String deletar(Composicao composicao) throws Exception {
		
		// Chamar a Dao do Composicao para deletar o composicao no BD
		ComposicaoDao dao = new ComposicaoDao();
		try {
			return dao.deletar(composicao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}		
	
	public List<Composicao> consultar(String nomePesquisa) throws Exception{	
		
		ComposicaoDao dao = new ComposicaoDao();
		try {
			return dao.consultar(nomePesquisa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosComposicao(Composicao composicao) throws Exception {
		// Valida��o da regra de neg�cio
		if (composicao.getDescricao().equals("")) {
			throw new Exception("Nome do composicao n�o pode ficar em branco!");
		}
		
	}
}
