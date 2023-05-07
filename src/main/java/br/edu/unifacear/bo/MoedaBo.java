package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Moeda;
import br.edu.unifacear.classes.Moeda;
import br.edu.unifacear.dao.MoedaDao;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.dao.MoedaDao;

public class MoedaBo {

	public MoedaBo() {	}
	
	public void salvar(Moeda moeda) throws Exception {
		validarDadosMoeda(moeda);

		// Chamando a DAO Gen�rica
		GenericDao<Moeda> dao  = new GenericDao<Moeda>();
		try {
			dao.salvarOuAtualizar(moeda);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Moeda> consultar() throws Exception{	
		// Chamando a DAO Gen�rica	
		GenericDao<Moeda> dao  = new GenericDao<Moeda>();
		try {
			return dao.list(Moeda.class);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}		
	
	public String deletar(Moeda moeda) throws Exception {
		
		// Chamar a Dao do Moeda para deletar o moeda no BD
		MoedaDao dao = new MoedaDao();
		try {
			return dao.deletar(moeda);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}		
	
	public List<Moeda> consultar(String nomePesquisa) throws Exception{	
		
		MoedaDao dao = new MoedaDao();
		try {
			return dao.consultar(nomePesquisa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosMoeda(Moeda moeda) throws Exception {
		// Valida��o da regra de neg�cio
		if (moeda.getNome() == "") {
			throw new Exception ("Nome deve estar preenchido");
		}
		if (moeda.getDescricao() == "") {
			throw new Exception ("Descrição deve estar preenchida");
		}
		if (moeda.getCunhagem() == "") {
			throw new Exception ("Cunhagem deve estar preenchido");
		}
		if (moeda.getPeso() == 0.0) {
			throw new Exception ("Peso deve ser superior a zero (0.0)");
		}
		if (moeda.getDiametro() == 0.0) {
			throw new Exception ("Diametro deve ser superior a zero (0.0)");
		}
		if (moeda.getEspessura() == 0.0) {
			throw new Exception ("Espessura deve ser superior a zero (0.0)");
		}
		if (moeda.getValor_face() == 0.0) {
			throw new Exception ("Valor de Face deve ser superior a zero (0.0)");
		}
		if (moeda.getAno() == 0) {
			throw new Exception ("Ano deve ser superior a zero (0)");
		}
		
	}
}
