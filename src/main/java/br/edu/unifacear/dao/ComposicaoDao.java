package br.edu.unifacear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import br.edu.unifacear.classes.Composicao;
import br.edu.unifacear.classes.Composicao;
import br.edu.unifacear.classes.Composicao;
import br.edu.unifacear.dao.Fabrica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ComposicaoDao {
	
	public ComposicaoDao () {}
		
	// excluir
	public String deletar(Composicao composicao) throws Exception {
		try {			
			EntityManager em = Fabrica.getEntityManager();
			Composicao c = em.find(Composicao.class, composicao.getId());
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();			
			return "Ok";			
		} catch(Exception e) {
			throw new Exception("Erro gravando Composicao: "+e.getMessage());
		}
	}

	// consultar
	public List<Composicao> consultar(String Pesquisa) throws Exception {		
		EntityManager em = Fabrica.getEntityManager();
				
		Query q;
		if (Pesquisa.equals("")) {
			q = em.createQuery("from Composicao");			
		}
		else {
			q = em.createQuery("select c from Composicao c"
					+" where descricao like :descricao");
			q.setParameter("descricao", "%" + Pesquisa + "%");		
		}		

		return q.getResultList();
	}
	
		
	}
