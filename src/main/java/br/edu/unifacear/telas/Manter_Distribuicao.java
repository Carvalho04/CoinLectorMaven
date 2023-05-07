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

import br.edu.unifacear.bo.DistribuicaoBo;
import br.edu.unifacear.bo.DistribuicaoBo;
import br.edu.unifacear.classes.Distribuicao;
import br.edu.unifacear.classes.Distribuicao;

public class Manter_Distribuicao extends JFrame {
	
	private JTextField txtNome;
	private JTextField txtId;
	public Manter_Distribuicao() {
		
		
		setTitle("Manter Distribuicao");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblDistribuicao = new JLabel("Distribuição");
		lblDistribuicao.setForeground(new Color(255, 204, 51));
		lblDistribuicao.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblDistribuicao.setBounds(84, 48, 189, 96);
		getContentPane().add(lblDistribuicao);
		
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
				
				Cadastro_Distribuicao Distribuicao = new Cadastro_Distribuicao();
				Manter_Distribuicao.this.dispose();
				
			}
		});
		btnVoltar.setBounds(10, 23, 83, 25);
		getContentPane().add(btnVoltar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(255, 204, 51));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				salvarDistribuicao();
				Manter_Distribuicao.this.dispose();
				Cadastro_Distribuicao distribuicaoC = new Cadastro_Distribuicao();
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
	
	public Manter_Distribuicao(Distribuicao d) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String []agrs) {
		
		Manter_Distribuicao distribuicao = new Manter_Distribuicao();
		
	}
	
	
	

	private void salvarDistribuicao() {
		//pegar os dados da tela e colocar no obj distribuicao
		Distribuicao distribuicao = new Distribuicao();
		if (!txtId.getText().equals("")) {
			distribuicao.setId(Integer.parseInt(txtId.getText()));
		}		
		distribuicao.setDescricao(txtNome.getText());
		
		//chamar a BO - o metodo que salva
		DistribuicaoBo distribuicaoBo = new DistribuicaoBo();
		try {
			distribuicaoBo.salvar(distribuicao);
			JOptionPane.showMessageDialog(null, "Distribuicao Salvo!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
					"Erro ao Salvar o Distribuicao!\n"+e.getMessage());
		}		
	}
	
	
}
