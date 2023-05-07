package br.edu.unifacear.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.classes.TipoUsuario;
import br.edu.unifacear.classes.TipoUsuario;
import br.edu.unifacear.dao.Fabrica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class TipoUsuarioDao {
	
	public TipoUsuarioDao() { 	}
		
	// excluir
	public String deletar(TipoUsuario tipoUsuario) throws Exception {
		try {			
			EntityManager em = Fabrica.getEntityManager();
			TipoUsuario tpU = em.find(TipoUsuario.class, tipoUsuario.getId());
			em.getTransaction().begin();
			em.remove(tpU);
			em.getTransaction().commit();			
			return "Ok";			
		} catch(Exception e) {
			throw new Exception("Erro gravando TipoUsuario: "+e.getMessage());
		}
	}

	// consultar
	public List<TipoUsuario> consultar(String Pesquisa) throws Exception {		
		EntityManager em = Fabrica.getEntityManager();
				
		Query q;
		if (Pesquisa.equals("")) {
			q = em.createQuery("from TipoUsuario");			
		}
		else {
			q = em.createQuery("select tpU from TipoUsuario tpU"
					+" where tipo like :tipo");
			q.setParameter("tipo", "%" + Pesquisa + "%");		
		}		

		return q.getResultList();
	}

		
}
