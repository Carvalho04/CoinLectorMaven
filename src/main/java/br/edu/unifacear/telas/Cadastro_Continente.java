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

import br.edu.unifacear.bo.ContinenteBo;
import br.edu.unifacear.bo.ContinenteBo;
import br.edu.unifacear.classes.Continente;
import br.edu.unifacear.classes.Continente;
import br.edu.unifacear.telas.Cadastro_Continente.ModelContinente;

public class Cadastro_Continente extends JFrame{
	
	private final String msgSQLErro = "Erro ao acessar os dados\n";
	private JTextField txtNome;
	private ModelContinente modeloContinente;
	private JTable table;
	private JScrollPane barraRolagem;
	
	public Cadastro_Continente() {
		
		try {
			modeloContinente = new ModelContinente(null);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, msgSQLErro + e1.getMessage());
		}
		table = new JTable(modeloContinente);
		barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(20, 186, 411, 176);
		getContentPane().add(barraRolagem);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Duplo click, abrir pra edi��o
				if (e.getClickCount() == 2) {
					pegarLinhaTableParaObjeto();
					Manter_Continente Continente = new Manter_Continente();
					//System.out.println("Teste");
				}
			}
		});

		
		
		setTitle("Cadastro Continente");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblContinente = new JLabel("Continentes");
		lblContinente.setForeground(new Color(255, 204, 51));
		lblContinente.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblContinente.setBounds(133, 48, 181, 96);
		getContentPane().add(lblContinente);
		
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
				Cadastro_Continente.this.dispose();
				
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
				
				Cadastro_Continente.this.dispose();
				Manter_Continente Continente = new Manter_Continente();
				
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
				Continente c = pegarLinhaTableParaObjeto();
				Manter_Continente continente = new Manter_Continente(c);	
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
		
		private Continente pegarLinhaTableParaObjeto() {
			// ler dados do grid
			int line = table.getSelectedRow();
			int id = (Integer) table.getValueAt(line, 0);
			String descricao = (String) table.getValueAt(line, 1);
			// montar objeto com os dados
			Continente c = new Continente(id, descricao);
			return c;
		}
	
		private void atualizaGridTela(String campo) {
			try {
				if (campo.equals("") ) {
					modeloContinente = new ModelContinente(null);
				}	
				else { 
					modeloContinente = new ModelContinente(campo);
				}
					
				table.setModel(modeloContinente);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,  msgSQLErro +e.getMessage());
			}
		} // atualizaGridTela

		private void deletarLinhaTabela() {
			Continente c = pegarLinhaTableParaObjeto();
			try {
				int bRemover = JOptionPane.showConfirmDialog(null, "Deseja remover o continente?");
				if (bRemover == 0) {
					new ContinenteBo().deletar(c);
					JOptionPane.showMessageDialog(null, "Continente deletado");
					atualizaGridTela("");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	
	
	
	
	
	
	class ModelContinente extends AbstractTableModel {
		private java.util.List<Continente> listaContinentes = new java.util.ArrayList<Continente>();
		private String colunas[] = { "Id", "Descricao" };
		private Class<?> colClasses[] = { int.class, String.class };

		public ModelContinente(String campo) throws Exception {
			// Exemplo de Lista de Continente Manual - TESTE - Comentado
//			listaContinentes.add(new Continente(1, "g1"));
//			listaContinentes.add(new Continente(2, "g2"));
//			listaContinentes.add(new Continente(3, "g3"));
//			listaContinentes.add(new Continente(4, "g4"));
//			listaContinentes.add(new Continente(5, "g5"));
//			listaContinentes.add(new Continente(6, "g6"));
//			listaContinentes.add(new Continente(7, "g7"));
//			listaContinentes.add(new Continente(8, "g8"));

			// Exemplo de Lista de Continente Puxando do TXT
			// listaContinentes = new Continente().ler();

			// Exemplo de Lista de Continente Puxando do SQL
			if ((campo == null ) || (campo.equals("")) ){
				listaContinentes = new ContinenteBo().consultar("");
			}
			else {
				listaContinentes = new ContinenteBo().consultar(campo);
			}
		}

		public int getRowCount() {
			return listaContinentes.size();
		}

		public int getColumnCount() {
			return colunas.length;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex == 0) {
				return listaContinentes.get(rowIndex).getId();
			}
			if (columnIndex == 1) {
				return listaContinentes.get(rowIndex).getDescricao();
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
				listaContinentes.get(rowIndex).setId((int) aValue);
			}
			if (columnIndex == 1) {
				listaContinentes.get(rowIndex).setDescricao((String) aValue);
			}
			this.fireTableCellUpdated(rowIndex, columnIndex);
		}
		
		public void removeRow(int row) {
			this.listaContinentes.remove(row);
			fireTableDataChanged();
		}	
		
		public void addRow(Continente continente) {
			this.listaContinentes.add(continente);
			fireTableDataChanged();
		}
		
	}
	
	
	
	public static void main (String []args) {
		Cadastro_Continente continente = new Cadastro_Continente();
	}
	
	
}
