package br.edu.unifacear.bo;

import java.sql.SQLException;
import java.util.List;

import br.edu.unifacear.classes.Distribuicao;
import br.edu.unifacear.classes.Distribuicao;
import br.edu.unifacear.dao.DistribuicaoDao;
import br.edu.unifacear.dao.DistribuicaoDao;
import br.edu.unifacear.dao.GenericDao;

public class DistribuicaoBo {
	
	public DistribuicaoBo() {	}
	
	public void salvar(Distribuicao distribuicao) throws Exception {
		validarDadosDistribuicao(distribuicao);

		// Chamando a DAO Gen�rica
		GenericDao<Distribuicao> dao  = new GenericDao<Distribuicao>();
		try {
			dao.salvarOuAtualizar(distribuicao);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Distribuicao> consultar() throws Exception{	
		// Chamando a DAO Gen�rica	
		GenericDao<Distribuicao> dao  = new GenericDao<Distribuicao>();
		try {
			return dao.list(Distribuicao.class);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}		
	
	public String deletar(Distribuicao distribuicao) throws Exception {
		
		// Chamar a Dao do Distribuicao para deletar o distribuicao no BD
		DistribuicaoDao dao = new DistribuicaoDao();
		try {
			return dao.deletar(distribuicao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}		
	
	public List<Distribuicao> consultar(String nomePesquisa) throws Exception{	
		
		DistribuicaoDao dao = new DistribuicaoDao();
		try {
			return dao.consultar(nomePesquisa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosDistribuicao(Distribuicao distribuicao) throws Exception {
		// Valida��o da regra de neg�cio
		if (distribuicao.getDescricao().equals("")) {
			throw new Exception("Nome do distribuicao n�o pode ficar em branco!");
		}
		
	}
}
