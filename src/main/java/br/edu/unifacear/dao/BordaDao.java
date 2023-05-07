package br.edu.unifacear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import br.edu.unifacear.classes.Borda;
import br.edu.unifacear.classes.Borda;
import br.edu.unifacear.dao.Fabrica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class BordaDao {
	
	public BordaDao() { 	}
	

	// excluir
	public String deletar(Borda borda) throws Exception {
		try {			
			EntityManager em = Fabrica.getEntityManager();
			Borda b = em.find(Borda.class, borda.getId());
			em.getTransaction().begin();
			em.remove(b);
			em.getTransaction().commit();			
			return "Ok";			
		} catch(Exception e) {
			throw new Exception("Erro gravando Borda: "+e.getMessage());
		}
	}

	// consultar
	public List<Borda> consultar(String descricaoPesquisa) throws Exception {		
		EntityManager em = Fabrica.getEntityManager();
		// Apelidos(Alias)
		//Query q = em.createQuery("from Borda");
		//Query q = em.createQuery("from Borda b");
		//Query q = em.createQuery("from Borda as b");
		
		// Campo
		//Query q = em.createQuery("select b from Borda b");
		//Query q = em.createQuery("select b from Borda as b");
		//Query q = em.createQuery("select new Borda(id, descricao) from Borda as b");
		
		
		// Selecionar borda com like
		// Come�a com (SQL -> SELECT * FROM borda WHERE NOME like 'ELETRO%';)
		//Query q = em.createQuery("select b from Borda b"
		//		+" where descricao like :descricao");
		//q.setParameter("descricao", "ELETRO%" );
		
		// Termina com (SQL -> SELECT * FROM borda WHERE NOME like '%ICOS';)
		//Query q = em.createQuery("select b from Borda b"
		//		+" where descricao like :descricao");
		//q.setParameter("descricao", "%ICOS" );
		
		// Contem (SQL -> SELECT * FROM borda WHERE NOME like '%ARR%';)
		//Query q = em.createQuery("select b from Borda b"
		//		+" where descricao like :descricao");
		//q.setParameter("descricao", "%ARR%" );
		
		//Query q = em.createQuery("select b from Borda b"
		//		+" where descricao like :descricao");
		//q.setParameter("descricao", "%" + "ARR" + "%");
		
		Query q;
		if (descricaoPesquisa.equals("")) {
			q = em.createQuery("from Borda");			
		}
		else {
			q = em.createQuery("select b from Borda b"
					+" where descricao like :descricao");
			q.setParameter("descricao", "%" + descricaoPesquisa + "%");		
		}		

		return q.getResultList();
	}
}
