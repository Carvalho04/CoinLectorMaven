package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Colecao;
import br.edu.unifacear.classes.Colecao;
import br.edu.unifacear.classes.Colecao;
import br.edu.unifacear.dao.ColecaoDao;
import br.edu.unifacear.dao.ColecaoDao;
import br.edu.unifacear.dao.GenericDao;

public class ColecaoBo {

	
	public ColecaoBo() {	}
	
	public void salvar(Colecao colecao) throws Exception {
	//	validarDadosColecao(colecao);

		// Chamando a DAO Gen�rica
		GenericDao<Colecao> dao  = new GenericDao<Colecao>();
		try {
			dao.salvarOuAtualizar(colecao);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Colecao> consultar() throws Exception{	
		// Chamando a DAO Gen�rica	
		GenericDao<Colecao> dao  = new GenericDao<Colecao>();
		try {
			return dao.list(Colecao.class);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}		
	
	public String deletar(Colecao colecao) throws Exception {
		
		// Chamar a Dao do Colecao para deletar o colecao no BD
		ColecaoDao dao = new ColecaoDao();
		try {
			return dao.deletar(colecao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}		
	
	public List<Colecao> consultar(String nomePesquisa) throws Exception{	
		
		ColecaoDao dao = new ColecaoDao();
		try {
			return dao.consultar(nomePesquisa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

//	private void validarDadosColecao(Colecao colecao) throws Exception {
//		// Valida��o da regra de neg�cio
//		if (colecao.getDescricao().equals("")) {
//			throw new Exception("Nome do colecao n�o pode ficar em branco!");
//		}
		
}

