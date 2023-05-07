package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.unifacear.bo.BordaBo;
import br.edu.unifacear.bo.UsuarioBo;
import br.edu.unifacear.classes.Borda;
import br.edu.unifacear.classes.TipoUsuario;
import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.dao.GenericDao.ValidaCPF;

public class Cadastro_Adm extends JFrame{

	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtId;
	
	public Cadastro_Adm() {
		
		txtCpf = new JTextField();
		
		try{
			javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");
			txtCpf = new javax.swing.JFormattedTextField(cpf);
			}
			catch (Exception e){
				e.getMessage();
			}
		
		setTitle("Cadastro de Administradores");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblCadastre = new JLabel("Cadastre-se");
		lblCadastre.setForeground(new Color(255, 204, 51));
		lblCadastre.setBackground(new Color(255, 204, 51));
		lblCadastre.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblCadastre.setBounds(83, 40, 183, 61);
		getContentPane().add(lblCadastre);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblNome.setBounds(20, 112, 46, 30);
		getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblCpf.setBounds(20, 162, 46, 25);
		getContentPane().add(lblCpf);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblEmail.setBounds(20, 207, 46, 26);
		getContentPane().add(lblEmail);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblLogin.setBounds(20, 254, 46, 27);
		getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblSenha.setBounds(20, 302, 46, 28);
		getContentPane().add(lblSenha);
		
		txtNome = new JTextField();
		txtNome.setBounds(61, 114, 252, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		
		txtCpf.setBounds(61, 161, 252, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(61, 207, 252, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(61, 254, 252, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(61, 303, 252, 20);
		getContentPane().add(txtSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(255, 204, 51));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf;
				cpf = txtCpf.getText();
				if (ValidaCPF.isCPF(cpf) == true) {
				TipoUsuario tipo = new TipoUsuario();
				tipo.setId(1);
				cadastrarAdm(tipo);
				Cadastro_Adm.this.dispose();
				ConsultarAdm_Adm adm = new ConsultarAdm_Adm();
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
				
		btnCadastrar.setBounds(105, 405, 132, 23);
		getContentPane().add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(255, 204, 51));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ConsultarAdm_Adm consultar = new ConsultarAdm_Adm();
				Cadastro_Adm.this.dispose();
				
			}
		});
		
		
		btnVoltar.setBounds(10, 11, 88, 23);
		getContentPane().add(btnVoltar);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(61, 346, 252, 20);
		getContentPane().add(txtId);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblId.setBounds(20, 347, 46, 25);
		getContentPane().add(lblId);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(370, 501);
		this.setResizable(false);		
		this.setVisible(true);	
		
	}

	
	private void cadastrarAdm(TipoUsuario tipo) {
		
		Usuario adm= new Usuario();
		if (!txtId.getText().equals("")) {
			adm.setId(Integer.parseInt(txtId.getText()));
		}	
		
		adm.setNome(txtNome.getText());
		adm.setCpf(txtCpf.getText());
		adm.setEmail(txtEmail.getText());
		adm.setLogin(txtLogin.getText());
		adm.setSenha(txtSenha.getText());
		adm.setTipoUsuario(tipo);
		
		//chamar a BO - o metodo que salva
		UsuarioBo admBo = new UsuarioBo();
		try {
			admBo.salvar(adm);
			JOptionPane.showMessageDialog(null, "Administrador Salvo!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
					"Erro ao Salvar o Administrador!\n"+e.getMessage());
		}		
	}
	
	
	public static void main (String []args) {
		
		Cadastro_Adm cadastro_adm = new Cadastro_Adm();
		
	}
}
