package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Venda;
import br.edu.unifacear.classes.Venda;
import br.edu.unifacear.dao.VendaDao;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.VendaDao;

public class VendaBo {
	
	public VendaBo () { 	}

	public void salvar(Venda venda) throws Exception {
//		validarDadosVenda(venda);

		// Chamando a DAO Gen�rica
		GenericDao<Venda> dao  = new GenericDao<Venda>();
		try {
			dao.salvarOuAtualizar(venda);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Venda> consultar() throws Exception{	
		// Chamando a DAO Gen�rica	
		GenericDao<Venda> dao  = new GenericDao<Venda>();
		try {
			return dao.list(Venda.class);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}		
	
	public String deletar(Venda venda) throws Exception {
		
		// Chamar a Dao do Venda para deletar o venda no BD
		VendaDao dao = new VendaDao();
		try {
			return dao.deletar(venda);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}		
	
	public List<Venda> consultar(String nomePesquisa) throws Exception{	
		
		VendaDao dao = new VendaDao();
		try {
			return dao.consultar(nomePesquisa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

//	private void validarDadosVenda(Venda venda) throws Exception {
//		// Valida��o da regra de neg�cio
//		if (venda.getDescricao().equals("")) {
//			throw new Exception("Nome do venda n�o pode ficar em branco!");
//		}
		
	

}
