package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ConsultarColecionadores_Adm extends JFrame{

	private JTextField txtCol;
	private JTable table;
	public ConsultarColecionadores_Adm() {
		setTitle("Consultar Colecionadores");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblAdm = new JLabel("Colecionadores");
		lblAdm.setForeground(new Color(255, 204, 51));
		lblAdm.setBackground(new Color(255, 255, 255));
		lblAdm.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblAdm.setBounds(125, 11, 261, 99);
		getContentPane().add(lblAdm);
		
		txtCol = new JTextField();
		txtCol.setBounds(71, 111, 298, 20);
		getContentPane().add(txtCol);
		txtCol.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(new Color(255, 204, 51));
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPesquisar.setBounds(379, 110, 100, 23);
		getContentPane().add(btnPesquisar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblNome.setBounds(10, 106, 68, 37);
		getContentPane().add(lblNome);
		
		table = new JTable();
		table.setBounds(57, 142, 383, 363);
		getContentPane().add(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBackground(new Color(255, 204, 51));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Menu_Adm menu = new Menu_Adm();
				ConsultarColecionadores_Adm.this.dispose();
				
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		getContentPane().add(btnVoltar);
		
		JButton btnCadastrar = new JButton("Novo");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastrar.setBackground(new Color(255, 204, 51));
		btnCadastrar.setToolTipText("Adicionar novo colecionador");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Cadastro_Usuario usuario = new Cadastro_Usuario();
			ConsultarColecionadores_Adm.this.dispose();
				
			}
		});
		btnCadastrar.setBounds(396, 11, 89, 23);
		getContentPane().add(btnCadastrar);
	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(505, 555);
		this.setResizable(false);
		this.setVisible(true);
	}

	
	
	public static void main (String []args) {
		
		ConsultarColecionadores_Adm consultaCol = new ConsultarColecionadores_Adm();
	}
	
}
