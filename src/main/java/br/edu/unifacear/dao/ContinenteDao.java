package br.edu.unifacear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.classes.Continente;
import br.edu.unifacear.classes.Continente;
import br.edu.unifacear.classes.Continente;
import br.edu.unifacear.dao.Fabrica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ContinenteDao {


	public ContinenteDao() { 	}
	
	// excluir
	public String deletar(Continente continente) throws Exception {
		try {			
			EntityManager em = Fabrica.getEntityManager();
			Continente c = em.find(Continente.class, continente.getId());
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();			
			return "Ok";			
		} catch(Exception e) {
			throw new Exception("Erro gravando Continente: "+e.getMessage());
		}
	}

	// consultar
	public List<Continente> consultar(String Pesquisa) throws Exception {		
		EntityManager em = Fabrica.getEntityManager();
				
		Query q;
		if (Pesquisa.equals("")) {
			q = em.createQuery("from Continente");			
		}
		else {
			q = em.createQuery("select c from Continente c"
					+" where descricao like :descricao");
			q.setParameter("descricao", "%" + Pesquisa + "%");		
		}		

		return q.getResultList();
	}
	
}
