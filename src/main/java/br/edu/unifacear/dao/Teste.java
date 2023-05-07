package br.edu.unifacear.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Teste {

	public static void main(String [] args) {
		
		//conexão com MySQL
		//string de conexão
		// jdbc:mysql://ip/nome_banco
		
		Connection conexao;
		try {
			conexao = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/Coinlector?autoReconnect=true&useSSL=false", "root", "admin");
			
			System.out.println("Conectado ao BD");
			conexao.close();
		}catch (SQLException e) {
			System.out.println("Erro ao Conectar no BD\n" + e.getMessage());
		}
		
		
	}
	
	
}
