package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.unifacear.bo.TipoUsuarioBo;
import br.edu.unifacear.bo.TipoUsuarioBo;
import br.edu.unifacear.bo.PaisBo;
import br.edu.unifacear.bo.TipoUsuarioBo;
import br.edu.unifacear.classes.TipoUsuario;
import br.edu.unifacear.classes.TipoUsuario;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.TipoUsuario;

public class Manter_TipoUsuario extends JFrame {
	
	private JTextField txtNome;
	private JTextField txtId;
	public Manter_TipoUsuario() {
		
		
		setTitle("Manter TipoUsuario");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblTipoUsuario = new JLabel("Tipo de Usuario");
		lblTipoUsuario.setForeground(new Color(255, 204, 51));
		lblTipoUsuario.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblTipoUsuario.setBounds(58, 48, 257, 96);
		getContentPane().add(lblTipoUsuario);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblNome.setBounds(20, 130, 46, 25);
		getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(20, 155, 334, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBackground(new Color(255, 204, 51));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro_TipoUsuario TipoUsuario = new Cadastro_TipoUsuario();
				Manter_TipoUsuario.this.dispose();
				
			}
		});
		btnVoltar.setBounds(10, 23, 83, 25);
		getContentPane().add(btnVoltar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(255, 204, 51));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				salvarTipoUsuario();
				Manter_TipoUsuario.this.dispose();
				Cadastro_TipoUsuario tipoUsuarioC = new Cadastro_TipoUsuario();
				}
			
		});
		btnSalvar.setBounds(20, 275, 123, 25);
		getContentPane().add(btnSalvar);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(20, 207, 334, 20);
		getContentPane().add(txtId);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblId.setBounds(20, 182, 46, 25);
		getContentPane().add(lblId);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtNome.setText("");
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNovo.setBackground(new Color(255, 204, 51));
		btnNovo.setBounds(231, 277, 123, 25);
		getContentPane().add(btnNovo);
	
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(380, 390);
		this.setResizable(false);
		
		
		
		this.setVisible(true);
	}
	
	public Manter_TipoUsuario(TipoUsuario tu) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String []agrs) {
		
		Manter_TipoUsuario tipoUsuario = new Manter_TipoUsuario();
		
	}
	
	
	

	private void salvarTipoUsuario() {
		//pegar os dados da tela e colocar no obj tipoUsuario
		TipoUsuario tipoUsuario = new TipoUsuario();
		if (!txtId.getText().equals("")) {
			tipoUsuario.setId(Integer.parseInt(txtId.getText()));
		}		
		tipoUsuario.setTipo(txtNome.getText());
		
		//chamar a BO - o metodo que salva
		TipoUsuarioBo tipoUsuarioBo = new TipoUsuarioBo();
		try {
			tipoUsuarioBo.salvar(tipoUsuario);
			JOptionPane.showMessageDialog(null, "TipoUsuario Salvo!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
					"Erro ao Salvar o TipoUsuario!\n"+e.getMessage());
		}		
	}
	
	
	
}
