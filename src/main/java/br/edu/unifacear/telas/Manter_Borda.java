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
import br.edu.unifacear.bo.BordaBo;
import br.edu.unifacear.classes.Borda;

public class Manter_Borda extends JFrame {
	
	private JTextField txtNome;
	private JTextField txtId;
	public Manter_Borda() {
		
		setTitle("Manter Borda");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblBorda = new JLabel("Borda");
		lblBorda.setForeground(new Color(255, 204, 51));
		lblBorda.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblBorda.setBounds(137, 48, 90, 96);
		getContentPane().add(lblBorda);
		
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
				
				Cadastro_Borda Borda = new Cadastro_Borda();
				Manter_Borda.this.dispose();
				
			}
		});
		btnVoltar.setBounds(10, 23, 83, 25);
		getContentPane().add(btnVoltar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(255, 204, 51));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				salvarBorda();
				Manter_Borda.this.dispose();
				Cadastro_Borda bordaC = new Cadastro_Borda();
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
	
	public Manter_Borda(Borda b) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String []agrs) {
		
		Manter_Borda borda = new Manter_Borda();
		
	}
	
	
	

	private void salvarBorda() {
		//pegar os dados da tela e colocar no obj borda
		Borda borda = new Borda();
		if (!txtId.getText().equals("")) {
			borda.setId(Integer.parseInt(txtId.getText()));
		}		
		borda.setDescricao(txtNome.getText());
		
		//chamar a BO - o metodo que salva
		BordaBo bordaBo = new BordaBo();
		try {
			bordaBo.salvar(borda);
			JOptionPane.showMessageDialog(null, "Borda Salvo!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
					"Erro ao Salvar o Borda!\n"+e.getMessage());
		}		
	}
	
}
