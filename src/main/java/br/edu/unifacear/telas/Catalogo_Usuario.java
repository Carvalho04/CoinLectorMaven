package br.edu.unifacear.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class Catalogo_Usuario extends JFrame{
	private JTable table;
	private JTextField textField;
	public Catalogo_Usuario() {
		setTitle("Catálogo Colecionadores");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblCatalogo = new JLabel("Catálogo");
		lblCatalogo.setForeground(new Color(255, 204, 51));
		lblCatalogo.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblCatalogo.setBounds(183, 27, 134, 99);
		getContentPane().add(lblCatalogo);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPesquisar.setBackground(new Color(255, 204, 51));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnPesquisar.setBounds(88, 481, 134, 23);
		getContentPane().add(btnPesquisar);
		
		table = new JTable();
		table.setBounds(57, 166, 383, 304);
		getContentPane().add(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(255, 204, 51));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu_Usuario menu = new Menu_Usuario();
				Catalogo_Usuario.this.dispose();
				
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		getContentPane().add(btnVoltar);
		
		JButton btnSugestão = new JButton("?");
		btnSugestão.setBackground(new Color(255, 204, 51));
		btnSugestão.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSugestão.setToolTipText("Sugerir nova adição de moeda");
		btnSugestão.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Sugestao_Usuario sugestao = new Sugestao_Usuario();
				Catalogo_Usuario.this.dispose();
			}
		});
		btnSugestão.setBounds(273, 481, 134, 23);
		getContentPane().add(btnSugestão);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(57, 137, 362, 20);
		getContentPane().add(textField);
		
		JLabel lblMoedas = new JLabel("Moedas");
		lblMoedas.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblMoedas.setBounds(10, 134, 51, 32);
		getContentPane().add(lblMoedas);
		
		JButton btnFunil = new JButton("Funil");
		btnFunil.setBackground(new Color(255, 204, 51));
		btnFunil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFunil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFunil.setBounds(425, 136, 31, 23);
		getContentPane().add(btnFunil);
		
		JButton btnItensavenda = new JButton("Itens A Venda");
		btnItensavenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CatalogoVenda_Usuario CatalogoVenda = new CatalogoVenda_Usuario();
				Catalogo_Usuario.this.dispose();
			}
		});
		
		btnItensavenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnItensavenda.setBackground(new Color(255, 204, 51));
		btnItensavenda.setBounds(183, 11, 134, 23);
		getContentPane().add(btnItensavenda);
	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(505, 555);
		this.setResizable(false);
		this.setVisible(true);
	}

	
	
	public static void main (String []args) {
		
		Catalogo_Usuario catalogo = new Catalogo_Usuario();
	}
}
