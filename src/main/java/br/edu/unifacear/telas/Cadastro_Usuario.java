package br.edu.unifacear.telas;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;

import br.edu.unifacear.bo.PaisBo;
import br.edu.unifacear.bo.UsuarioBo;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.TipoUsuario;
import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.dao.GenericDao.ValidaCPF;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;


public class Cadastro_Usuario extends JFrame {
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtId;
	
	
	public Cadastro_Usuario() {
		txtCpf = new JTextField();
		try{
			javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");
			txtCpf = new javax.swing.JFormattedTextField(cpf);
			}
			catch (Exception e){
				e.getMessage();
			}
		
		setTitle("Cadastro de Colecionadores");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblCadastre = new JLabel("Cadastre-se");
		lblCadastre.setForeground(new Color(255, 204, 51));
		lblCadastre.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblCadastre.setBounds(101, 47, 183, 61);
		getContentPane().add(lblCadastre);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(255, 204, 51));
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf;
				cpf = txtCpf.getText();
				if (ValidaCPF.isCPF(cpf) == true) {
				
					TipoUsuario tipo = new TipoUsuario();
					tipo.setId(2);
					cadastrarColecionador(tipo);
					Cadastro_Usuario.this.dispose();
					TelaLogin login = new TelaLogin();

				} else {
					
					JOptionPane.showMessageDialog(btnCadastrar, "CPF Inválido \n Por Favor Tente Novamente");
					txtId.setText("");
					txtNome.setText("");
					txtCpf.setText("");
					txtEmail.setText("");
					txtLogin.setText("");
					txtSenha.setText("");
					
				}
			}
		});
				
		btnCadastrar.setBounds(123, 400, 132, 23);
		getContentPane().add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(255, 204, 51));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaLogin login = new TelaLogin();
				Cadastro_Usuario.this.dispose();
								
			}
		});
		btnVoltar.setBounds(10, 11, 100, 23);
		getContentPane().add(btnVoltar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblNome.setBounds(23, 117, 46, 30);
		getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(73, 119, 251, 20);
		getContentPane().add(txtNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblCpf.setBounds(23, 166, 46, 25);
		getContentPane().add(lblCpf);
	
		
		txtCpf.setColumns(10);
		txtCpf.setBounds(73, 165, 251, 20);
		getContentPane().add(txtCpf);
		
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblEmail.setBounds(23, 211, 46, 26);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(73, 211, 251, 20);
		getContentPane().add(txtEmail);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblLogin.setBounds(23, 258, 46, 27);
		getContentPane().add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(73, 258, 251, 20);
		getContentPane().add(txtLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblSenha.setBounds(23, 306, 46, 28);
		getContentPane().add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(73, 307, 251, 20);
		getContentPane().add(txtSenha);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(73, 350, 251, 20);
		getContentPane().add(txtId);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblId.setBounds(23, 351, 46, 25);
		getContentPane().add(lblId);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(380, 490);
		this.setResizable(false);		
		this.setVisible(true);	
		
	}
	
	

	
	private void cadastrarColecionador(TipoUsuario tipo) {
		
		Usuario colec= new Usuario();
		if (!txtId.getText().equals("")) {
			colec.setId(Integer.parseInt(txtId.getText()));
		}	
		
		
		colec.setNome(txtNome.getText());
		colec.setCpf(txtCpf.getText());
		colec.setEmail(txtEmail.getText());
		colec.setLogin(txtLogin.getText());
		colec.setSenha(txtSenha.getText());
		colec.setTipoUsuario(tipo);
		
		//chamar a BO - o metodo que salva
		UsuarioBo admBo = new UsuarioBo();
		try {
			admBo.salvar(colec);
			JOptionPane.showMessageDialog(null, "Colecionador Salvo!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
					"Erro ao Salvar o Colecionador!\n"+e.getMessage());
		}		
	}
	
	public static void main (String []args) {
		
		Cadastro_Usuario telaCadastro = new Cadastro_Usuario();
		
	}
}
