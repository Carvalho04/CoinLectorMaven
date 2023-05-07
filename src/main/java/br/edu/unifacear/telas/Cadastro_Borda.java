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
import br.edu.unifacear.bo.BordaBo;
import br.edu.unifacear.classes.Borda;

public class Cadastro_Borda extends JFrame{
	
	private final String msgSQLErro = "Erro ao acessar os dados\n";
	private JTextField txtNome;
	private ModelBorda modeloBorda;
	private JTable table;
	private JScrollPane barraRolagem;
	
	public Cadastro_Borda() {
		
		try {
			modeloBorda = new ModelBorda(null);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, msgSQLErro + e1.getMessage());
		}
		table = new JTable(modeloBorda);
		barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(20, 186, 411, 176);
		getContentPane().add(barraRolagem);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Duplo click, abrir pra edi��o
				if (e.getClickCount() == 2) {
					Borda b = pegarLinhaTableParaObjeto();
					Manter_Borda borda = new Manter_Borda(b);
					//System.out.println("Teste");
				}
			}
		});

		
		
		setTitle("Cadastro Borda");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblBorda = new JLabel("Borda");
		lblBorda.setForeground(new Color(255, 204, 51));
		lblBorda.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblBorda.setBounds(180, 48, 96, 96);
		getContentPane().add(lblBorda);
		
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
				Cadastro_Borda.this.dispose();
				
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
				
				Cadastro_Borda.this.dispose();
				Manter_Borda Borda = new Manter_Borda();
				
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
				Borda b = pegarLinhaTableParaObjeto();
				Manter_Borda borda = new Manter_Borda(b);	
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
		
		private Borda pegarLinhaTableParaObjeto() {
			// ler dados do grid
			int line = table.getSelectedRow();
			int id = (Integer) table.getValueAt(line, 0);
			String descricao = (String) table.getValueAt(line, 1);
			// montar objeto com os dados
			Borda b = new Borda(id, descricao);
			return b;
		}
	
		private void atualizaGridTela(String campo) {
			try {
				if (campo.equals("") ) {
					modeloBorda = new ModelBorda(null);
				}	
				else { 
					modeloBorda = new ModelBorda(campo);
				}
					
				table.setModel(modeloBorda);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,  msgSQLErro +e.getMessage());
			}
		} // atualizaGridTela

		private void deletarLinhaTabela() {
			Borda b = pegarLinhaTableParaObjeto();
			try {
				int bRemover = JOptionPane.showConfirmDialog(null, "Deseja remover o borda?");
				if (bRemover == 0) {
					new BordaBo().deletar(b);
					JOptionPane.showMessageDialog(null, "Borda deletado");
					atualizaGridTela("");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	
	
	
	
	
	
	class ModelBorda extends AbstractTableModel {
		private java.util.List<Borda> listaBordas = new java.util.ArrayList<Borda>();
		private String colunas[] = { "Id", "Descricao" };
		private Class<?> colClasses[] = { int.class, String.class };

		public ModelBorda(String campo) throws Exception {
		
			if ((campo == null ) || (campo.equals("")) ){
				listaBordas = new BordaBo().consultar("");
			}
			else {
				listaBordas = new BordaBo().consultar(campo);
			}
		}

		public int getRowCount() {
			return listaBordas.size();
		}

		public int getColumnCount() {
			return colunas.length;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex == 0) {
				return listaBordas.get(rowIndex).getId();
			}
			if (columnIndex == 1) {
				return listaBordas.get(rowIndex).getDescricao();
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
				listaBordas.get(rowIndex).setId((int) aValue);
			}
			if (columnIndex == 1) {
				listaBordas.get(rowIndex).setDescricao((String) aValue);
			}
			this.fireTableCellUpdated(rowIndex, columnIndex);
		}
		
		public void removeRow(int row) {
			this.listaBordas.remove(row);
			fireTableDataChanged();
		}	
		
		public void addRow(Borda borda) {
			this.listaBordas.add(borda);
			fireTableDataChanged();
		}
		
	}
	
	
	
	public static void main (String []args) {
		Cadastro_Borda borda = new Cadastro_Borda();
	}
}
