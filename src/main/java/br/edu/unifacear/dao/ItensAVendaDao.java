package br.edu.unifacear.dao;

import java.util.ArrayList;
import jakarta.persistence.*;
import java.util.List;


import br.edu.unifacear.classes.ItensAVenda;
import br.edu.unifacear.classes.ItensAVenda;

public class ItensAVendaDao {

	public ItensAVendaDao () {}
		
	// excluir
	public String deletar(ItensAVenda itensAVenda) throws Exception {
		try {			
			EntityManager em = Fabrica.getEntityManager();
			ItensAVenda iV = em.find(ItensAVenda.class, itensAVenda.getId());
			em.getTransaction().begin();
			em.remove(iV);
			em.getTransaction().commit();			
			return "Ok";			
		} catch(Exception e) {
			throw new Exception("Erro gravando ItensAVenda: "+e.getMessage());
		}
	}

	// consultar
	public List<ItensAVenda> consultar(String Pesquisa) throws Exception {		
		EntityManager em = Fabrica.getEntityManager();
				
		Query q;
		if (Pesquisa.equals("")) {
			q = em.createQuery("from ItensAVenda");			
		}
		else {
			q = em.createQuery("select iV from ItensAVenda iV"
					+" where id like :id");
			q.setParameter("id", "%" + Pesquisa + "%");		
		}		

		return q.getResultList();
	}

}
