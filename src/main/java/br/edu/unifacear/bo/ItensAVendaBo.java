package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.ItensAVenda;
import br.edu.unifacear.classes.ItensAVenda;
import br.edu.unifacear.dao.ItensAVendaDao;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.ItensAVendaDao;

public class ItensAVendaBo {


	public ItensAVendaBo() {	}
	
		
		public void salvar(ItensAVenda itensAVenda) throws Exception {
			validarDadosItensAVenda(itensAVenda);

			// Chamando a DAO Gen�rica
			GenericDao<ItensAVenda> dao  = new GenericDao<ItensAVenda>();
			try {
				dao.salvarOuAtualizar(itensAVenda);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		public List<ItensAVenda> consultar() throws Exception{	
			// Chamando a DAO Gen�rica	
			GenericDao<ItensAVenda> dao  = new GenericDao<ItensAVenda>();
			try {
				return dao.list(ItensAVenda.class);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;		
		}		
		
		public String deletar(ItensAVenda itensAVenda) throws Exception {
			
			// Chamar a Dao do ItensAVenda para deletar o itensAVenda no BD
			ItensAVendaDao dao = new ItensAVendaDao();
			try {
				return dao.deletar(itensAVenda);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}		
		}		
		
		public List<ItensAVenda> consultar(String nomePesquisa) throws Exception{	
			
			ItensAVendaDao dao = new ItensAVendaDao();
			try {
				return dao.consultar(nomePesquisa);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}			
		}	

		private void validarDadosItensAVenda(ItensAVenda itensAVenda) throws Exception {
			// Valida��o da regra de neg�cio
			if (itensAVenda.getQuantidade() <= 0) {
				throw new Exception ("Quantidade deve ser superior a zero (0)");
			}
			if (itensAVenda.getValor() <= 0.0) {
				throw new Exception ("Valor deve ser superior a (0)");
			}
			if (itensAVenda.getTotal() <= 0) {
				throw new Exception ("Total deve ser superior a zero (0)");
			}
			
		}
}
