package br.edu.unifacear.telas;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class Colecao_Usuario extends JFrame{
	private JTextField txtPesquisa;
	private JTable table;
	public Colecao_Usuario() {
		setTitle("Minha Coleção");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblColecao = new JLabel("Minha Coleção");
		lblColecao.setForeground(new Color(255, 204, 51));
		lblColecao.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblColecao.setBounds(137, 32, 232, 99);
		getContentPane().add(lblColecao);
		
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(71, 111, 298, 20);
		getContentPane().add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(new Color(255, 204, 51));
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPesquisar.setBounds(379, 110, 100, 23);
		getContentPane().add(btnPesquisar);
		
		JLabel lblItens = new JLabel("Meus itens");
		lblItens.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblItens.setBounds(10, 96, 72, 56);
		getContentPane().add(lblItens);
		
		table = new JTable();
		table.setBounds(55, 155, 383, 363);
		getContentPane().add(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(255, 204, 51));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Perfil_Usuario perfil = new Perfil_Usuario();
				Colecao_Usuario.this.dispose();
				
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		getContentPane().add(btnVoltar);
		
		JButton btnCatalogo = new JButton("Catálogo");
		btnCatalogo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCatalogo.setBackground(new Color(255, 204, 51));
		btnCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Catalogo_Usuario catalogo = new Catalogo_Usuario();
				Colecao_Usuario.this.dispose();
				
			}
		});
		btnCatalogo.setBounds(197, 11, 89, 23);
		getContentPane().add(btnCatalogo);
	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(505, 580);
		this.setResizable(false);
		this.setVisible(true);
	}

	
	
	public static void main(String []agrs) {
		
		Colecao_Usuario colecao= new Colecao_Usuario();
		
	}
}
