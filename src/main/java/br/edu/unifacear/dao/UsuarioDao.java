package br.edu.unifacear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.classes.TipoUsuario;
import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.dao.Fabrica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class UsuarioDao {

	public UsuarioDao () {}
	
	// excluir
	public String deletar(Usuario usuario) throws Exception {
		try {			
			EntityManager em = Fabrica.getEntityManager();
			Usuario u = em.find(Usuario.class, usuario.getId());
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();			
			return "Ok";			
		} catch(Exception e) {
			throw new Exception("Erro gravando Usuario: "+e.getMessage());
		}
	}
	
	// consultar
	public List<Usuario> consultar(String nomePesquisa) throws Exception {		
		EntityManager em = Fabrica.getEntityManager();
				
		Query q;
		if (nomePesquisa.equals("")) {
			q = em.createQuery("from Usuario");			
		}
		else {
			q = em.createQuery("select u from Usuario u"
					+" where nome like :nome");
			q.setParameter("nome", "%" + nomePesquisa + "%");		
		}		
	
		return q.getResultList();
	}


}

