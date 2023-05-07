package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;

public class Moedas_Usuario extends JFrame {
	

		private JTextField txtNome;
		private JTextField txtCunhagem;
		private JTextField txtEmail;
		private JTextField txtPeso;
		private JTextField txtDiametro;
		private JTextField txtEspessura;
		private JTextField txtFimProd;
		private JTextField txtCircunferencia;
		private JTextField txtValorFace;
		private JTextField txtPais;
		private JTextField txtBorda;
		private JTextField txtForma;
		private JTextField txtDistribuicao;
		private JTextField txtComposicao;
		public Moedas_Usuario() {
			setTitle("Moeda");
			getContentPane().setBackground(new Color(255, 255, 204));
			getContentPane().setLayout(null);
			
			JLabel lblMoeda = new JLabel("Moeda");
			lblMoeda.setForeground(new Color(255, 204, 51));
			lblMoeda.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
			lblMoeda.setBounds(320, 28, 108, 96);
			getContentPane().add(lblMoeda);
			
			JLabel lblNome = new JLabel("Nome");
			lblNome.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblNome.setBounds(34, 147, 59, 25);
			getContentPane().add(lblNome);
			
			JLabel lblCpf = new JLabel("Cunhagem");
			lblCpf.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblCpf.setBounds(34, 203, 89, 30);
			getContentPane().add(lblCpf);
			
			JLabel lblAno_Lanca = new JLabel("Ano de Lançamento");
			lblAno_Lanca.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblAno_Lanca.setBounds(34, 259, 153, 25);
			getContentPane().add(lblAno_Lanca);
			
			JLabel lblPeso = new JLabel("Peso");
			lblPeso.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblPeso.setBounds(261, 147, 46, 25);
			getContentPane().add(lblPeso);
			
			JLabel lblDiametro = new JLabel("Diametro");
			lblDiametro.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblDiametro.setBounds(261, 203, 77, 30);
			getContentPane().add(lblDiametro);
			
			JLabel lblEspessura = new JLabel("Espessura");
			lblEspessura.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblEspessura.setBounds(261, 259, 61, 25);
			getContentPane().add(lblEspessura);
			
			txtNome = new JTextField();
			txtNome.setBounds(34, 172, 200, 20);
			getContentPane().add(txtNome);
			txtNome.setColumns(10);
			
			txtCunhagem = new JTextField();
			txtCunhagem.setBounds(34, 228, 200, 20);
			getContentPane().add(txtCunhagem);
			txtCunhagem.setColumns(10);
			
			txtEmail = new JTextField();
			txtEmail.setBounds(34, 284, 200, 20);
			getContentPane().add(txtEmail);
			txtEmail.setColumns(10);
			
			txtPeso = new JTextField();
			txtPeso.setBounds(261, 172, 200, 20);
			getContentPane().add(txtPeso);
			txtPeso.setColumns(10);
			
			txtDiametro = new JTextField();
			txtDiametro.setBounds(261, 228, 200, 20);
			getContentPane().add(txtDiametro);
			txtDiametro.setColumns(10);
			
			txtEspessura = new JTextField();
			txtEspessura.setBounds(261, 284, 200, 20);
			getContentPane().add(txtEspessura);
			txtEspessura.setColumns(10);
			
			JButton btnAdc = new JButton("Adicionar à Coleção");
			btnAdc.setBackground(new Color(255, 204, 51));
			btnAdc.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAdc.setBounds(261, 460, 200, 25);
			getContentPane().add(btnAdc);
			
			JButton btnVoltar = new JButton("Voltar");
			btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnVoltar.setBackground(new Color(255, 204, 51));
			btnVoltar.setBounds(10, 10, 83, 25);
			getContentPane().add(btnVoltar);
			
			txtFimProd = new JTextField();
			txtFimProd.setColumns(10);
			txtFimProd.setBounds(34, 340, 200, 20);
			getContentPane().add(txtFimProd);
			
			JLabel lblFimProd = new JLabel("Fim de Produção");
			lblFimProd.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblFimProd.setBounds(34, 315, 123, 25);
			getContentPane().add(lblFimProd);
			
			JLabel lblCircunferencia = new JLabel("Circunferencia");
			lblCircunferencia.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblCircunferencia.setBounds(261, 315, 89, 25);
			getContentPane().add(lblCircunferencia);
			
			txtCircunferencia = new JTextField();
			txtCircunferencia.setColumns(10);
			txtCircunferencia.setBounds(261, 340, 200, 20);
			getContentPane().add(txtCircunferencia);
			
			txtValorFace = new JTextField();
			txtValorFace.setColumns(10);
			txtValorFace.setBounds(34, 401, 200, 20);
			getContentPane().add(txtValorFace);
			
			JLabel lblValorFace = new JLabel("Valor de Face");
			lblValorFace.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblValorFace.setBounds(34, 376, 89, 25);
			getContentPane().add(lblValorFace);
			
			JLabel lblSituacao = new JLabel("Situação");
			lblSituacao.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblSituacao.setBounds(261, 376, 89, 25);
			getContentPane().add(lblSituacao);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setEnabled(false);
			comboBox.setBounds(261, 400, 200, 21);
			comboBox.addItem("Aprovado");
			comboBox.addItem("Reprovado");
			comboBox.addItem("Em Análise");
			getContentPane().add(comboBox);
			
			JButton btnFotos = new JButton("Fotos");
			btnFotos.setBackground(new Color(255, 204, 51));
			btnFotos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnFotos.setBounds(590, 11, 89, 23);
			getContentPane().add(btnFotos);
			
			JLabel lblPais = new JLabel("Pais");
			lblPais.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblPais.setBounds(481, 147, 46, 25);
			getContentPane().add(lblPais);
			
			txtPais = new JTextField();
			txtPais.setColumns(10);
			txtPais.setBounds(481, 172, 200, 20);
			getContentPane().add(txtPais);
			
			txtBorda = new JTextField();
			txtBorda.setColumns(10);
			txtBorda.setBounds(479, 228, 200, 20);
			getContentPane().add(txtBorda);
			
			JLabel lblBorda = new JLabel("Borda");
			lblBorda.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblBorda.setBounds(479, 203, 46, 30);
			getContentPane().add(lblBorda);
			
			txtForma = new JTextField();
			txtForma.setColumns(10);
			txtForma.setBounds(479, 284, 200, 20);
			getContentPane().add(txtForma);
			
			JLabel lblForma = new JLabel("Forma");
			lblForma.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblForma.setBounds(479, 259, 46, 25);
			getContentPane().add(lblForma);
			
			txtDistribuicao = new JTextField();
			txtDistribuicao.setColumns(10);
			txtDistribuicao.setBounds(479, 340, 200, 20);
			getContentPane().add(txtDistribuicao);
			
			JLabel lblDistribuicao = new JLabel("Distribuição");
			lblDistribuicao.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblDistribuicao.setBounds(479, 315, 68, 25);
			getContentPane().add(lblDistribuicao);
			
			txtComposicao = new JTextField();
			txtComposicao.setColumns(10);
			txtComposicao.setBounds(479, 401, 200, 20);
			getContentPane().add(txtComposicao);
			
			JLabel lblComposicao = new JLabel("Composição");
			lblComposicao.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			lblComposicao.setBounds(479, 376, 68, 25);
			getContentPane().add(lblComposicao);
		
		
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(720, 557);
			this.setResizable(false);
			
			
			
			this.setVisible(true);
		}
		
		public static void main(String []args) {
			
			Moedas_Usuario moedas = new Moedas_Usuario ();
			
		}
}
