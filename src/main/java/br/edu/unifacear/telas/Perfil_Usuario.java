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

public class Perfil_Usuario extends JFrame{
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtConfSenha;
	public Perfil_Usuario() {
		setTitle("Meu Perfil");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblMeuPerfil = new JLabel("Meu Perfil");
		lblMeuPerfil.setForeground(new Color(255, 204, 51));
		lblMeuPerfil.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblMeuPerfil.setBounds(157, 31, 169, 96);
		getContentPane().add(lblMeuPerfil);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblNome.setBounds(34, 147, 46, 30);
		getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblCpf.setBounds(34, 228, 46, 30);
		getContentPane().add(lblCpf);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblEmail.setBounds(34, 308, 46, 30);
		getContentPane().add(lblEmail);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblLogin.setBounds(261, 147, 46, 31);
		getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblSenha.setBounds(261, 228, 46, 30);
		getContentPane().add(lblSenha);
		
		JLabel lblPix = new JLabel("Chave Pix");
		lblPix.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblPix.setBounds(261, 308, 65, 30);
		getContentPane().add(lblPix);
		
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
		btnEditar.setBackground(new Color(255, 204, 51));
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditar.setBounds(75, 400, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(255, 204, 51));
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExcluir.setBounds(309, 400, 89, 23);
		getContentPane().add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBackground(new Color(255, 204, 51));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu_Usuario Menu = new Menu_Usuario();
				Perfil_Usuario.this.dispose();
				
			}
		});
		btnVoltar.setBounds(192, 438, 89, 23);
		getContentPane().add(btnVoltar);
	
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(505, 555);
		this.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.GRAY);
		setJMenuBar(menuBar);
		
		final JMenuItem ItemVendas = new JMenuItem("Meus Itens A Venda");
		ItemVendas.setBackground(new Color(255, 255, 153));
		ItemVendas.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				ItemVendas.setBackground(Color.white);
			}
			public void mouseExited (MouseEvent e) {
				ItemVendas.setBackground(new Color(255, 255, 153));
			}
			public void mousePressed(MouseEvent e) {

				Venda_Usuario venda = new Venda_Usuario();
				Perfil_Usuario.this.dispose();
				
			}
			});
		
		menuBar.add(ItemVendas);
		
		
		
		final JMenuItem ItemMinhaColecao = new JMenuItem("Minha Coleção");
		ItemMinhaColecao.setBackground(new Color(255, 255, 153));
		ItemMinhaColecao.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent e) {
			ItemMinhaColecao.setBackground(Color.white);
		}
		public void mouseExited (MouseEvent e) {
			ItemMinhaColecao.setBackground(new Color(255, 255, 153));
		}
		public void mousePressed(MouseEvent e) {
			
			Colecao_Usuario colecao = new Colecao_Usuario();
			Perfil_Usuario.this.dispose();
			
		}
		});
		
		menuBar.add(ItemMinhaColecao);
		
		
		
		final JMenuItem ItemMinhasCompras = new JMenuItem("Minhas Compras");
		ItemMinhasCompras.setBackground(new Color(255, 255, 153));
		ItemMinhasCompras.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent e) {
			ItemMinhasCompras.setBackground(Color.white);
		}
		public void mouseExited (MouseEvent e) {
			ItemMinhasCompras.setBackground(new Color(255, 255, 153));
		}
		public void mousePressed(MouseEvent e) {
			
			Compras_Usuario compras = new Compras_Usuario();
			Perfil_Usuario.this.dispose();
			
		}
		});
		
		menuBar.add(ItemMinhasCompras);
		
		
		
		this.setVisible(true);
	}
	

	public static void main (String [] args) {
		
		Perfil_Usuario pfU = new Perfil_Usuario();
		
	}
}

