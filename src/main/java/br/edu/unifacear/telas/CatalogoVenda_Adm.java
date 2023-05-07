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

public class CatalogoVenda_Adm extends JFrame{
	
	private JTextField txtCompras;
	private JTable table;
	public CatalogoVenda_Adm() {
		setTitle(" Itens a Venda Adm");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblItensVenda = new JLabel("Itens a Venda");
		lblItensVenda.setForeground(new Color(255, 204, 0));
		lblItensVenda.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblItensVenda.setBounds(132, 11, 247, 99);
		getContentPane().add(lblItensVenda);
		
		txtCompras = new JTextField();
		txtCompras.setBounds(71, 111, 298, 20);
		getContentPane().add(txtCompras);
		txtCompras.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(new Color(255, 204, 51));
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPesquisar.setForeground(new Color(0, 0, 0));
		btnPesquisar.setBounds(379, 110, 100, 23);
		getContentPane().add(btnPesquisar);
		
		JLabel lblMoedas = new JLabel("Moedas");
		lblMoedas.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblMoedas.setBounds(10, 110, 51, 21);
		getContentPane().add(lblMoedas);
		
		table = new JTable();
		table.setBounds(57, 142, 383, 363);
		getContentPane().add(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Catalogo_Adm Catalogo_Adm = new Catalogo_Adm();
				CatalogoVenda_Adm.this.dispose();
				
				
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBackground(new Color(255, 204, 51));
		btnVoltar.setBounds(10, 11, 89, 23);
		getContentPane().add(btnVoltar);
		
		JButton btnAdicionarNovo = new JButton("Adicionar Novo");
		btnAdicionarNovo.setBackground(new Color(255, 204, 51));
		btnAdicionarNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdicionarNovo.setBounds(10, 522, 122, 23);
		getContentPane().add(btnAdicionarNovo);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExcluir.setBackground(new Color(255, 204, 51));
		btnExcluir.setBounds(357, 522, 122, 23);
		getContentPane().add(btnExcluir);
	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(505, 595);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main (String []args) {
		
		CatalogoVenda_Adm vendas = new CatalogoVenda_Adm();
		
	}

}
