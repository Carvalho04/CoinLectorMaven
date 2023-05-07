package br.edu.unifacear.dao;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Query;
import br.edu.unifacear.classes.Colecao;
import br.edu.unifacear.classes.Composicao;
import br.edu.unifacear.classes.Colecao;


public class ColecaoDao {

	public ColecaoDao () {}
	
	// excluir
	public String deletar(Colecao colecao) throws Exception {
		try {			
			EntityManager em = Fabrica.getEntityManager();
			Colecao c = em.find(Colecao.class, colecao.getId());
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();			
			return "Ok";			
		} catch(Exception e) {
			throw new Exception("Erro gravando Colecao: "+e.getMessage());
		}
	}

	// consultar
	public List<Colecao> consultar(String nomePesquisa) throws Exception {		
		EntityManager em = Fabrica.getEntityManager();
				
		Query q;
		if (nomePesquisa.equals("")) {
			q = em.createQuery("from Colecao");			
		}
		else {
			q = em.createQuery("select c from Colecao c"
					+" where usuario like :usuario");
			q.setParameter("usuario", "%" + nomePesquisa + "%");		
		}		

		return q.getResultList();
	}
	
	
}
