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

import br.edu.unifacear.bo.FormaBo;
import br.edu.unifacear.bo.FormaBo;
import br.edu.unifacear.classes.Forma;
import br.edu.unifacear.classes.Forma;
import br.edu.unifacear.telas.Cadastro_Forma.ModelForma;

public class Cadastro_Forma extends JFrame{
	
	private final String msgSQLErro = "Erro ao acessar os dados\n";
	private JTextField txtNome;
	private ModelForma modeloForma;
	private JTable table;
	private JScrollPane barraRolagem;
	
	public Cadastro_Forma() {
		try {
			modeloForma = new ModelForma(null);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, msgSQLErro + e1.getMessage());
		}
		table = new JTable(modeloForma);
		barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(20, 186, 411, 176);
		getContentPane().add(barraRolagem);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Duplo click, abrir pra edi��o
				if (e.getClickCount() == 2) {
					pegarLinhaTableParaObjeto();
					Manter_Forma forma = new Manter_Forma();
					//System.out.println("Teste");
				}
			}
		});

		
		
		setTitle("Cadastro Forma");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblForma = new JLabel("Formas");
		lblForma.setForeground(new Color(255, 204, 51));
		lblForma.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblForma.setBounds(165, 48, 106, 96);
		getContentPane().add(lblForma);
		
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
				Cadastro_Forma.this.dispose();
				
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
		

		JButton btnAdcnova = new JButton("Adicionar Nova");
		btnAdcnova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro_Forma.this.dispose();
				Manter_Forma Forma = new Manter_Forma();
				
			}
		});
		btnAdcnova.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdcnova.setBackground(new Color(255, 204, 51));
		btnAdcnova.setBounds(20, 373, 121, 25);
		getContentPane().add(btnAdcnova);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Forma f = pegarLinhaTableParaObjeto();
				Manter_Forma forma = new Manter_Forma(f);	
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
		
		private Forma pegarLinhaTableParaObjeto() {
			// ler dados do grid
			int line = table.getSelectedRow();
			int id = (Integer) table.getValueAt(line, 0);
			String descricao = (String) table.getValueAt(line, 1);
			// montar objeto com os dados
			Forma f = new Forma(id, descricao);
			return f;
		}
	
		private void atualizaGridTela(String campo) {
			try {
				if (campo.equals("") ) {
					modeloForma = new ModelForma(null);
				}	
				else { 
					modeloForma = new ModelForma(campo);
				}
					
				table.setModel(modeloForma);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,  msgSQLErro +e.getMessage());
			}
		} // atualizaGridTela

		private void deletarLinhaTabela() {
			Forma f = pegarLinhaTableParaObjeto();
			try {
				int bRemover = JOptionPane.showConfirmDialog(null, "Deseja remover o forma?");
				if (bRemover == 0) {
					new FormaBo().deletar(f);
					JOptionPane.showMessageDialog(null, "Forma deletado");
					atualizaGridTela("");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	
	
	
	
	
	
	class ModelForma extends AbstractTableModel {
		private java.util.List<Forma> listaFormas = new java.util.ArrayList<Forma>();
		private String colunas[] = { "Id", "Descricao" };
		private Class<?> colClasses[] = { int.class, String.class };

		public ModelForma(String campo) throws Exception {
		
			if ((campo == null ) || (campo.equals("")) ){
				listaFormas = new FormaBo().consultar("");
			}
			else {
				listaFormas = new FormaBo().consultar(campo);
			}
		}

		public int getRowCount() {
			return listaFormas.size();
		}

		public int getColumnCount() {
			return colunas.length;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex == 0) {
				return listaFormas.get(rowIndex).getId();
			}
			if (columnIndex == 1) {
				return listaFormas.get(rowIndex).getDescricao();
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
				listaFormas.get(rowIndex).setId((int) aValue);
			}
			if (columnIndex == 1) {
				listaFormas.get(rowIndex).setDescricao((String) aValue);
			}
			this.fireTableCellUpdated(rowIndex, columnIndex);
		}
		
		public void removeRow(int row) {
			this.listaFormas.remove(row);
			fireTableDataChanged();
		}	
		
		public void addRow(Forma forma) {
			this.listaFormas.add(forma);
			fireTableDataChanged();
		}
		
	}
	
	
	
	public static void main (String []args) {
		Cadastro_Forma forma = new Cadastro_Forma();
	}
	
	
}
