package br.edu.unifacear.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.classes.Moeda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import br.edu.unifacear.classes.Moeda;

public class MoedaDao {

	public MoedaDao () {}

	// excluir
	public String deletar(Moeda moeda) throws Exception {
		try {			
			EntityManager em = Fabrica.getEntityManager();
			Moeda m = em.find(Moeda.class, moeda.getId());
			em.getTransaction().begin();
			em.remove(m);
			em.getTransaction().commit();			
			return "Ok";			
		} catch(Exception e) {
			throw new Exception("Erro gravando Moeda: "+e.getMessage());
		}
	}

	// consultar
	public List<Moeda> consultar(String Pesquisa) throws Exception {		
		EntityManager em = Fabrica.getEntityManager();
				
		Query q;
		if (Pesquisa.equals("")) {
			q = em.createQuery("from Moeda");			
		}
		else {
			q = em.createQuery("select m from Moeda m"
					+" where nome like :nome");
			q.setParameter("nome", "%" + Pesquisa + "%");		
		}		

		return q.getResultList();
	}

}
