package br.edu.unifacear.telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import javax.swing.JButton;

public class Perfil_Adm extends JFrame{
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtConfSenha;
	public Perfil_Adm() {
		setTitle("Meu Perfil");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblMeuPerfil = new JLabel("Meu Perfil");
		lblMeuPerfil.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblMeuPerfil.setBounds(157, 31, 169, 96);
		getContentPane().add(lblMeuPerfil);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(34, 147, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(34, 228, 46, 14);
		getContentPane().add(lblCpf);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(34, 308, 46, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(261, 147, 46, 14);
		getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(261, 228, 46, 14);
		getContentPane().add(lblSenha);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(261, 308, 48, 14);
		getContentPane().add(lblCargo);
		
		txtNome = new JTextField();
		txtNome.setBounds(34, 172, 180, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(34, 253, 180, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(34, 333, 180, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(261, 172, 180, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(261, 253, 180, 20);
		getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		txtConfSenha = new JTextField();
		txtConfSenha.setBounds(261, 333, 180, 20);
		getContentPane().add(txtConfSenha);
		txtConfSenha.setColumns(10);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(75, 400, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(309, 400, 89, 23);
		getContentPane().add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Menu_Adm menu = new Menu_Adm();
				Perfil_Adm.this.dispose();
				
			}
		});
		btnVoltar.setBounds(192, 438, 89, 23);
		getContentPane().add(btnVoltar);
	
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(505, 555);
		this.setResizable(false);
		
		
		
		this.setVisible(true);
	}
	

	public static void main (String [] args) {
		
		Perfil_Adm pfU = new Perfil_Adm();
		
	}
}

