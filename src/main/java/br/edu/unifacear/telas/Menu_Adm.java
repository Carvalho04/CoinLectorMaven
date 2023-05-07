package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu_Adm extends JFrame{
	
	public Menu_Adm() {
		setTitle("Menu Administrador");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblBemVindo = new JLabel("Bem Vindo");
		lblBemVindo.setForeground(new Color(255, 204, 51));
		lblBemVindo.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblBemVindo.setBounds(162, 11, 171, 75);
		getContentPane().add(lblBemVindo);
		
		JButton btnConsultaCatalogo = new JButton("Consultar Catálogo");
		btnConsultaCatalogo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultaCatalogo.setForeground(new Color(0, 0, 0));
		btnConsultaCatalogo.setBackground(new Color(255, 204, 51));
		btnConsultaCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Catalogo_Adm catalogo = new Catalogo_Adm();
				Menu_Adm.this.dispose();
				
			}
		});
		btnConsultaCatalogo.setBounds(46, 97, 195, 54);
		getContentPane().add(btnConsultaCatalogo);
		
		JButton btnConsultaPerfil = new JButton("Consultar Perfil");
		btnConsultaPerfil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultaPerfil.setForeground(new Color(0, 0, 0));
		btnConsultaPerfil.setBackground(new Color(255, 204, 51));
		btnConsultaPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Perfil_Adm perfil = new Perfil_Adm();
				Menu_Adm.this.dispose();
				
			}
		});
		btnConsultaPerfil.setBounds(251, 97, 195, 54);
		getContentPane().add(btnConsultaPerfil);
		
		JButton btnConsultaColecionador = new JButton("Consultar Colecionadores");
		btnConsultaColecionador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultaColecionador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ConsultarColecionadores_Adm colecionadores = new ConsultarColecionadores_Adm();
				Menu_Adm.this.dispose();
				
			}
		});
		btnConsultaColecionador.setForeground(new Color(0, 0, 0));
		btnConsultaColecionador.setBackground(new Color(255, 204, 51));
		btnConsultaColecionador.setBounds(251, 162, 195, 54);
		getContentPane().add(btnConsultaColecionador);
		
		JButton btnConsultaAdm = new JButton("Consultar Administradores");
		btnConsultaAdm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultaAdm.setForeground(new Color(0, 0, 0));
		btnConsultaAdm.setBackground(new Color(255, 204, 51));
		btnConsultaAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ConsultarAdm_Adm administradores = new ConsultarAdm_Adm();
				Menu_Adm.this.dispose();
				
			}
		});
				
		btnConsultaAdm.setBounds(46, 162, 195, 54);
		getContentPane().add(btnConsultaAdm);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(524, 305);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main (String [] args) {
		
		Menu_Adm menuA = new Menu_Adm();

}

}
