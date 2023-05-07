package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.unifacear.bo.PaisBo;
import br.edu.unifacear.bo.PaisBo;
import br.edu.unifacear.bo.PaisBo;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.dao.ContinenteDao;
import br.edu.unifacear.dao.Fabrica;
import br.edu.unifacear.dao.GenericDao;
import br.edu.unifacear.classes.Continente;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Pais;

public class Manter_Pais extends JFrame {
	
	private JTextField txtNome;
	private JTextField txtId;
	private JComboBox comboBox;
	public Manter_Pais() {
		
		setTitle("Manter Pais");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setForeground(new Color(255, 204, 51));
		lblPais.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblPais.setBounds(137, 48, 90, 96);
		getContentPane().add(lblPais);
		
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
				
				Cadastro_Pais Pais = new Cadastro_Pais();
				Manter_Pais.this.dispose();
				
			}
		});
		btnVoltar.setBounds(10, 23, 83, 25);
		getContentPane().add(btnVoltar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(255, 204, 51));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				salvarPais();
				Manter_Pais.this.dispose();
				Cadastro_Pais paisC = new Cadastro_Pais();
				}
			
		});
		btnSalvar.setBounds(20, 334, 123, 25);
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
		btnNovo.setBounds(231, 336, 123, 25);
		getContentPane().add(btnNovo);
		
		JLabel lblContinente = new JLabel("Continente");
		lblContinente.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblContinente.setBounds(20, 238, 73, 25);
		getContentPane().add(lblContinente);
		
//		comboBox = new JComboBox();
//			try {
//				CarregarCombo();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		Continente continente = new Continente();
//		continente.getDescricao();
//		comboBox.addItem(continente);
//		comboBox.addItem(new GenericDao<Continente>().consultarTodos(Continente.class));
		comboBox.setBounds(20, 272, 334, 22);
		getContentPane().add(comboBox);
	
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(380, 426);
		this.setResizable(false);
		
		
		
		this.setVisible(true);
	}
	
	public Manter_Pais(Pais p) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String []agrs) {
		
		Manter_Pais pais = new Manter_Pais();
		
	}
	
//	public void CarregarCombo() throws SQLException {
//		comboBox.addItem("");
//		Continente continente = new Continente();
//		ResultSet rs = (ResultSet) new GenericDao<Continente>().consultarTodos(Continente.class);
//		while (rs.next()) {
//			comboBox.addItem(rs.getString("descricao"));
//		}
//		try {
//			rs.close();
//		} catch (SQLException e) {
//			e.getMessage();
//			e.printStackTrace();
//		}
//	}
//	

	private void salvarPais() {
		//pegar os dados da tela e colocar no obj pais
		Pais pais = new Pais();
		if (!txtId.getText().equals("")) {
			pais.setId(Integer.parseInt(txtId.getText()));
		}		
		pais.setNome(txtNome.getText());
		
		//chamar a BO - o metodo que salva
		PaisBo paisBo = new PaisBo();
		try {
			paisBo.salvar(pais);
			JOptionPane.showMessageDialog(null, "Pais Salvo!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
					"Erro ao Salvar o Pais!\n"+e.getMessage());
		}		
	}
}
