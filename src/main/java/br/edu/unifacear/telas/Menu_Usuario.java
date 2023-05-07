package br.edu.unifacear.telas;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_Usuario extends JFrame{
	public Menu_Usuario() {
		setTitle("Menu");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblBemVindo = new JLabel("Bem Vindo");
		lblBemVindo.setForeground(new Color(255, 204, 51));
		lblBemVindo.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblBemVindo.setBounds(152, 26, 171, 102);
		getContentPane().add(lblBemVindo);
		
		JButton btnConsultaCatalogo = new JButton("Consultar Catálogo");
		btnConsultaCatalogo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultaCatalogo.setForeground(new Color(0, 0, 0));
		btnConsultaCatalogo.setBackground(new Color(255, 204, 51));
		btnConsultaCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Catalogo_Usuario catalogo = new Catalogo_Usuario();
				Menu_Usuario.this.dispose();
				
			}
		});
		btnConsultaCatalogo.setBounds(55, 131, 144, 64);
		getContentPane().add(btnConsultaCatalogo);
		
		JButton btnConsultaPerfil = new JButton("Consultar Perfil");
		btnConsultaPerfil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultaPerfil.setForeground(new Color(0, 0, 0));
		btnConsultaPerfil.setBackground(new Color(255, 204, 51));
		btnConsultaPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Perfil_Usuario perfil = new Perfil_Usuario();
				Menu_Usuario.this.dispose();
				
			}
		});
		btnConsultaPerfil.setBounds(262, 131, 144, 64);
		getContentPane().add(btnConsultaPerfil);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(505, 305);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main (String [] args) {
		
		Menu_Usuario menuU = new Menu_Usuario();
	}

}
