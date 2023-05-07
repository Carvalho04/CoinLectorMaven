package br.edu.unifacear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.dao.Fabrica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class PaisDao {

	public PaisDao() {   }

	// excluir
	public String deletar(Pais pais) throws Exception {
		try {			
			EntityManager em = Fabrica.getEntityManager();
			Pais p = em.find(Pais.class, pais.getId());
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();			
			return "Ok";			
		} catch(Exception e) {
			throw new Exception("Erro gravando Pais: "+e.getMessage());
		}
	}

	// consultar
	public List<Pais> consultar(String nomePesquisa) throws Exception {		
		EntityManager em = Fabrica.getEntityManager();
				
		Query q;
		if (nomePesquisa.equals("")) {
			q = em.createQuery("from Pais");			
		}
		else {
			q = em.createQuery("select g from Pais p"
					+" where nome like :nome");
			q.setParameter("nome", "%" + nomePesquisa + "%");		
		}		

		return q.getResultList();
	}
}
