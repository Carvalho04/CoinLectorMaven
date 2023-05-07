package br.edu.unifacear.bo;

import java.sql.SQLException;
import java.util.List;

import br.edu.unifacear.classes.Forma;
import br.edu.unifacear.classes.Forma;
import br.edu.unifacear.dao.FormaDao;
import br.edu.unifacear.dao.FormaDao;
import br.edu.unifacear.dao.GenericDao;


public class FormaBo {

	public FormaBo() {	}
	
	public void salvar(Forma forma) throws Exception {
		validarDadosForma(forma);

		// Chamando a DAO Gen�rica
		GenericDao<Forma> dao  = new GenericDao<Forma>();
		try {
			dao.salvarOuAtualizar(forma);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Forma> consultar() throws Exception{	
		// Chamando a DAO Gen�rica	
		GenericDao<Forma> dao  = new GenericDao<Forma>();
		try {
			return dao.list(Forma.class);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}		
	
	public String deletar(Forma forma) throws Exception {
		
		// Chamar a Dao do Forma para deletar o forma no BD
		FormaDao dao = new FormaDao();
		try {
			return dao.deletar(forma);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}		
	
	public List<Forma> consultar(String nomePesquisa) throws Exception{	
		
		FormaDao dao = new FormaDao();
		try {
			return dao.consultar(nomePesquisa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosForma(Forma forma) throws Exception {
		// Valida��o da regra de neg�cio
		if (forma.getDescricao().equals("")) {
			throw new Exception("Nome do forma n�o pode ficar em branco!");
		}
		
	}
}
