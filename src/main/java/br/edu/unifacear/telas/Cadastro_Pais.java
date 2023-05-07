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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.edu.unifacear.bo.PaisBo;
import br.edu.unifacear.bo.PaisBo;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Continente;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.telas.Cadastro_Pais.ModelPais;

public class Cadastro_Pais extends JFrame{
	
	private final String msgSQLErro = "Erro ao acessar os dados\n";
	private JTextField txtNome;
	private ModelPais modeloPais;
	private JTable table;
	private JScrollPane barraRolagem;
	
	public Cadastro_Pais() {
		
		try {
			modeloPais = new ModelPais(null);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, msgSQLErro + e1.getMessage());
		}
		table = new JTable(modeloPais);
		barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(20, 186, 411, 176);
		getContentPane().add(barraRolagem);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Duplo click, abrir pra edi��o
				if (e.getClickCount() == 2) {
					pegarLinhaTableParaObjeto();
					Manter_Pais pais = new Manter_Pais();
					//System.out.println("Teste");
				}
			}
		});

		
		
		setTitle("Cadastro Pais");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setForeground(new Color(255, 204, 51));
		lblPais.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblPais.setBounds(176, 59, 96, 96);
		getContentPane().add(lblPais);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblNome.setBounds(20, 130, 46, 25);
		getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(20, 155, 305, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBackground(new Color(255, 204, 51));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Moedas_Adm moedas = new Moedas_Adm();
				Cadastro_Pais.this.dispose();
				
			}
		});
		btnVoltar.setBounds(10, 23, 83, 25);
		getContentPane().add(btnVoltar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaGridTela(txtNome.getText());
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPesquisar.setBackground(new Color(255, 204, 51));
		btnPesquisar.setBounds(335, 152, 96, 25);
		getContentPane().add(btnPesquisar);
		

		JButton btnNova = new JButton("Nova");
		btnNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro_Pais.this.dispose();
				Manter_Pais Pais = new Manter_Pais();
				
			}
		});
		btnNova.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNova.setBackground(new Color(255, 204, 51));
		btnNova.setBounds(20, 373, 121, 25);
		getContentPane().add(btnNova);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Pais p = pegarLinhaTableParaObjeto();
				Manter_Pais pais = new Manter_Pais(p);	
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditar.setBackground(new Color(255, 204, 51));
		btnEditar.setBounds(165, 373, 121, 25);
		getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deletarLinhaTabela();
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExcluir.setBackground(new Color(255, 204, 51));
		btnExcluir.setBounds(310, 373, 121, 25);
		getContentPane().add(btnExcluir);
	
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(457, 445);
		this.setResizable(false);
		
		
		this.setVisible(true);
		
		
	}
		
		private Pais pegarLinhaTableParaObjeto() {
			// ler dados do grid
			int line = table.getSelectedRow();
			int id = (Integer) table.getValueAt(line, 0);
			String nome = (String) table.getValueAt(line, 1);
			Continente continente = (Continente) table.getValueAt(line, 2);
			// montar objeto com os dados
			Pais p = new Pais(id, nome, continente);
			return p;
		}
	
		private void atualizaGridTela(String campo) {
			try {
				if (campo.equals("") ) {
					modeloPais = new ModelPais(null);
				}	
				else { 
					modeloPais = new ModelPais(campo);
				}
					
				table.setModel(modeloPais);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,  msgSQLErro +e.getMessage());
			}
		} // atualizaGridTela

		private void deletarLinhaTabela() {
			Pais n = pegarLinhaTableParaObjeto();
			try {
				int bRemover = JOptionPane.showConfirmDialog(null, "Deseja remover o pais?");
				if (bRemover == 0) {
					new PaisBo().deletar(n);
					JOptionPane.showMessageDialog(null, "Pais deletado");
					atualizaGridTela("");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	
	
	
	
	
	
	class ModelPais extends AbstractTableModel {
		private java.util.List<Pais> listaPaiss = new java.util.ArrayList<Pais>();
		private String colunas[] = { "Id", "Descricao" };
		private Class<?> colClasses[] = { int.class, String.class };

		public ModelPais(String campo) throws Exception {
		
			if ((campo == null ) || (campo.equals("")) ){
				listaPaiss = new PaisBo().consultar("");
			}
			else {
				listaPaiss = new PaisBo().consultar(campo);
			}
		}

		public int getRowCount() {
			return listaPaiss.size();
		}

		public int getColumnCount() {
			return colunas.length;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex == 0) {
				return listaPaiss.get(rowIndex).getId();
			}
			if (columnIndex == 1) {
				return listaPaiss.get(rowIndex).getNome();
			}
			return null;
		}

		public String getColumnName(int columnIndex) {
			return colunas[columnIndex];
		}

		public Class<?> getColumnClass(int columnIndex) {
			return colClasses[columnIndex];
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return true;
		}

		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			if (columnIndex == 0) {
				listaPaiss.get(rowIndex).setId((int) aValue);
			}
			if (columnIndex == 1) {
				listaPaiss.get(rowIndex).setNome((String) aValue);
			}
			this.fireTableCellUpdated(rowIndex, columnIndex);
		}
		
		public void removeRow(int row) {
			this.listaPaiss.remove(row);
			fireTableDataChanged();
		}	
		
		public void addRow(Pais pais) {
			this.listaPaiss.add(pais);
			fireTableDataChanged();
		}
		
	}
	
	
	
	public static void main (String []args) {
		Cadastro_Pais pais = new Cadastro_Pais();
	}
	
	
}
