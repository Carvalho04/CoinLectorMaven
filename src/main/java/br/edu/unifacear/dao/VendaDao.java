package br.edu.unifacear.dao;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;


import br.edu.unifacear.classes.Venda;
import br.edu.unifacear.classes.Venda;

public class VendaDao {

	
	public VendaDao() { 	}
		
	// excluir
	public String deletar(Venda venda) throws Exception {
		try {			
			EntityManager em = Fabrica.getEntityManager();
			Venda v = em.find(Venda.class, venda.getId());
			em.getTransaction().begin();
			em.remove(v);
			em.getTransaction().commit();			
			return "Ok";			
		} catch(Exception e) {
			throw new Exception("Erro gravando Venda: "+e.getMessage());
		}
	}

	// consultar
	public List<Venda> consultar(String Pesquisa) throws Exception {		
		EntityManager em = Fabrica.getEntityManager();
				
		Query q;
		if (Pesquisa.equals("")) {
			q = em.createQuery("from Venda");			
		}
		else {
			q = em.createQuery("select v from Venda v"
					+" where id like :id");
			q.setParameter("id", "%" + Pesquisa + "%");		
		}		

		return q.getResultList();
	}

}
