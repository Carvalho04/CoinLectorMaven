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
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Catalogo_Adm extends JFrame{
	private JTextField txtMoeda;
	private JTable table;
	public Catalogo_Adm() {
		setTitle("Catálogo Adm");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblCatalogo = new JLabel("Catálogo");
		lblCatalogo.setForeground(new Color(255, 204, 51));
		lblCatalogo.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblCatalogo.setBounds(178, 32, 134, 77);
		getContentPane().add(lblCatalogo);
		
		txtMoeda = new JTextField();
		txtMoeda.setBounds(57, 111, 312, 20);
		getContentPane().add(txtMoeda);
		txtMoeda.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(new Color(255, 204, 51));
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPesquisar.setBounds(379, 110, 100, 23);
		getContentPane().add(btnPesquisar);
		
		JLabel lblMoedas = new JLabel("Moedas");
		lblMoedas.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblMoedas.setBounds(10, 108, 51, 32);
		getContentPane().add(lblMoedas);
		
		table = new JTable();
		table.setBounds(57, 142, 383, 363);
		getContentPane().add(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBackground(new Color(255, 204, 51));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Menu_Adm menu = new Menu_Adm();
				Catalogo_Adm.this.dispose();
				
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		getContentPane().add(btnVoltar);
		
		JButton btnSugestão = new JButton("?");
		btnSugestão.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSugestão.setBackground(new Color(255, 204, 51));
		btnSugestão.setForeground(new Color(0, 0, 0));
		btnSugestão.setToolTipText("Consultar sugestões de moedas");
		btnSugestão.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Sugestao_Adm sugestao = new Sugestao_Adm();
				Catalogo_Adm.this.dispose();
				
			}
		});
		btnSugestão.setBounds(274, 528, 156, 23);
		getContentPane().add(btnSugestão);
		
		JButton btnMoedas = new JButton("Manter Moedas");
		btnMoedas.setBackground(new Color(255, 204, 51));
		btnMoedas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMoedas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Moedas_Adm moedas = new Moedas_Adm();
				Catalogo_Adm.this.dispose();
				
			}
		});
		btnMoedas.setBounds(57, 528, 188, 23);
		getContentPane().add(btnMoedas);
		
		JButton btnItensavenda = new JButton("Itens A Venda");
		btnItensavenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CatalogoVenda_Adm CatalogoVenda = new CatalogoVenda_Adm();
				Catalogo_Adm.this.dispose();
				
				
			}
		});
		btnItensavenda.setToolTipText("Consultar sugestões de moedas");
		btnItensavenda.setForeground(Color.BLACK);
		btnItensavenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnItensavenda.setBackground(new Color(255, 204, 51));
		btnItensavenda.setBounds(178, 12, 134, 23);
		getContentPane().add(btnItensavenda);
	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(505, 601);
		this.setResizable(false);
		this.setVisible(true);
	}

	
	
	public static void main (String []args) {
		
		Catalogo_Adm catalogo = new Catalogo_Adm();
	}
}
