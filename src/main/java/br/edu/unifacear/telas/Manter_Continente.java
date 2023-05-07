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

import br.edu.unifacear.bo.ContinenteBo;
import br.edu.unifacear.bo.ContinenteBo;
import br.edu.unifacear.bo.ContinenteBo;
import br.edu.unifacear.classes.Continente;
import br.edu.unifacear.classes.Continente;
import br.edu.unifacear.classes.Continente;

public class Manter_Continente extends JFrame{
	
	private JTextField txtNome;
	private JTextField txtId;
	public Manter_Continente() {
		
		setTitle("Manter Continente");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblContinente = new JLabel("Continente");
		lblContinente.setForeground(new Color(255, 204, 51));
		lblContinente.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblContinente.setBounds(104, 48, 165, 96);
		getContentPane().add(lblContinente);
		
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
				
				Cadastro_Continente Continente = new Cadastro_Continente();
				Manter_Continente.this.dispose();
				
			}
		});
		btnVoltar.setBounds(10, 23, 83, 25);
		getContentPane().add(btnVoltar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(255, 204, 51));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				salvarContinente();
				Manter_Continente.this.dispose();
				Cadastro_Continente continenteC = new Cadastro_Continente();
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
	
	public Manter_Continente(Continente c) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String []agrs) {
		
		Manter_Continente continente = new Manter_Continente();
		
	}
	
	
	

	private void salvarContinente() {
		//pegar os dados da tela e colocar no obj continente
		Continente continente = new Continente();
		if (!txtId.getText().equals("")) {
			continente.setId(Integer.parseInt(txtId.getText()));
		}		
		continente.setDescricao(txtNome.getText());
		
		//chamar a BO - o metodo que salva
		ContinenteBo continenteBo = new ContinenteBo();
		try {
			continenteBo.salvar(continente);
			JOptionPane.showMessageDialog(null, "Continente Salvo!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
					"Erro ao Salvar o Continente!\n"+e.getMessage());
		}		
	}
	
	
}
