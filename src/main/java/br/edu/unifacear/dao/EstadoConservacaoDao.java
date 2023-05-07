package br.edu.unifacear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.classes.EstadoConservacao;
import br.edu.unifacear.classes.EstadoConservacao;
import br.edu.unifacear.classes.EstadoConservacao;
import br.edu.unifacear.dao.Fabrica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;



public class EstadoConservacaoDao {

	public EstadoConservacaoDao () {}
		
	// excluir
	public String deletar(EstadoConservacao estadoConservacao) throws Exception {
		try {			
			EntityManager em = Fabrica.getEntityManager();
			EstadoConservacao eC = em.find(EstadoConservacao.class, estadoConservacao.getId());
			em.getTransaction().begin();
			em.remove(eC);
			em.getTransaction().commit();			
			return "Ok";			
		} catch(Exception e) {
			throw new Exception("Erro gravando EstadoConservacao: "+e.getMessage());
		}
	}

	// consultar
	public List<EstadoConservacao> consultar(String Pesquisa) throws Exception {		
		EntityManager em = Fabrica.getEntityManager();
				
		Query q;
		if (Pesquisa.equals("")) {
			q = em.createQuery("from EstadoConservacao");			
		}
		else {
			q = em.createQuery("select eC from EstadoConservacao eC"
					+" where descricao like :descricao");
			q.setParameter("descricao", "%" + Pesquisa + "%");		
		}		

		return q.getResultList();
	}

}
