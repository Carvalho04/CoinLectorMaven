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

public class CatalogoVenda_Usuario extends JFrame{
	
	private JTextField txtCompras;
	private JTable table;
	public CatalogoVenda_Usuario() {
		setTitle("Itens a Venda Colecionadores");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblItensVenda = new JLabel("Itens a Venda");
		lblItensVenda.setForeground(new Color(255, 204, 51));
		lblItensVenda.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblItensVenda.setBounds(132, 11, 247, 99);
		getContentPane().add(lblItensVenda);
		
		txtCompras = new JTextField();
		txtCompras.setBounds(71, 111, 298, 20);
		getContentPane().add(txtCompras);
		txtCompras.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPesquisar.setBackground(new Color(255, 204, 51));
		btnPesquisar.setBounds(379, 110, 100, 23);
		getContentPane().add(btnPesquisar);
		
		JLabel lblMoedas = new JLabel("Moedas");
		lblMoedas.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblMoedas.setBounds(10, 107, 51, 34);
		getContentPane().add(lblMoedas);
		
		table = new JTable();
		table.setBounds(57, 142, 383, 363);
		getContentPane().add(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Catalogo_Usuario Catalogo_Usuario = new Catalogo_Usuario();
				CatalogoVenda_Usuario.this.dispose();
			}
		});
		
		btnVoltar.setBackground(new Color(255, 204, 51));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBounds(10, 11, 89, 23);
		getContentPane().add(btnVoltar);
	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(505, 555);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main (String []args) {
		
		CatalogoVenda_Usuario vendas = new CatalogoVenda_Usuario();
		
	}

}
