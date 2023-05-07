package br.edu.unifacear.dao;

import java.sql.*;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Fabrica {
	
		static EntityManagerFactory emf = 
				 Persistence.createEntityManagerFactory("coinlectorHibernate");

		public static EntityManager getEntityManager() { // getConnection() {
			return emf.createEntityManager();
		}
		
		public static void main(String[] args) {
			new Fabrica().getEntityManager();
		}
}
