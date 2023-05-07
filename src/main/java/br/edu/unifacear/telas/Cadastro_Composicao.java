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

import br.edu.unifacear.bo.ComposicaoBo;
import br.edu.unifacear.bo.ComposicaoBo;
import br.edu.unifacear.classes.Composicao;
import br.edu.unifacear.classes.Composicao;
import br.edu.unifacear.telas.Cadastro_Composicao.ModelComposicao;

public class Cadastro_Composicao extends JFrame{
	
	private final String msgSQLErro = "Erro ao acessar os dados\n";
	private JTextField txtNome;
	private ModelComposicao modeloComposicao;
	private JTable table;
	private JScrollPane barraRolagem;
	
	public Cadastro_Composicao() {
		
		try {
			modeloComposicao = new ModelComposicao(null);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, msgSQLErro + e1.getMessage());
		}
		table = new JTable(modeloComposicao);
		barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(20, 186, 411, 176);
		getContentPane().add(barraRolagem);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Duplo click, abrir pra edi��o
				if (e.getClickCount() == 2) {
					pegarLinhaTableParaObjeto();
					Manter_Composicao composicao = new Manter_Composicao();
					//System.out.println("Teste");
				}
			}
		});

		
		
		setTitle("Cadastro Composicao");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblComposicao = new JLabel("Composição");
		lblComposicao.setForeground(new Color(255, 204, 51));
		lblComposicao.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblComposicao.setBounds(124, 48, 181, 96);
		getContentPane().add(lblComposicao);
		
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
				Cadastro_Composicao.this.dispose();
				
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
				
				Cadastro_Composicao.this.dispose();
				Manter_Composicao Composicao = new Manter_Composicao();
				
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
				Composicao c = pegarLinhaTableParaObjeto();
				Manter_Composicao composicao = new Manter_Composicao(c);	
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
		
		private Composicao pegarLinhaTableParaObjeto() {
			// ler dados do grid
			int line = table.getSelectedRow();
			int id = (Integer) table.getValueAt(line, 0);
			String descricao = (String) table.getValueAt(line, 1);
			// montar objeto com os dados
			Composicao c = new Composicao(id, descricao);
			return c;
		}
	
		private void atualizaGridTela(String campo) {
			try {
				if (campo.equals("") ) {
					modeloComposicao = new ModelComposicao(null);
				}	
				else { 
					modeloComposicao = new ModelComposicao(campo);
				}
					
				table.setModel(modeloComposicao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,  msgSQLErro +e.getMessage());
			}
		} // atualizaGridTela

		private void deletarLinhaTabela() {
			Composicao c = pegarLinhaTableParaObjeto();
			try {
				int bRemover = JOptionPane.showConfirmDialog(null, "Deseja remover o composicao?");
				if (bRemover == 0) {
					new ComposicaoBo().deletar(c);
					JOptionPane.showMessageDialog(null, "Composicao deletado");
					atualizaGridTela("");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	
	
	
	
	
	
	class ModelComposicao extends AbstractTableModel {
		private java.util.List<Composicao> listaComposicaos = new java.util.ArrayList<Composicao>();
		private String colunas[] = { "Id", "Descricao" };
		private Class<?> colClasses[] = { int.class, String.class };

		public ModelComposicao(String campo) throws Exception {
			// Exemplo de Lista de Composicao Manual - TESTE - Comentado
//			listaComposicaos.add(new Composicao(1, "g1"));
//			listaComposicaos.add(new Composicao(2, "g2"));
//			listaComposicaos.add(new Composicao(3, "g3"));
//			listaComposicaos.add(new Composicao(4, "g4"));
//			listaComposicaos.add(new Composicao(5, "g5"));
//			listaComposicaos.add(new Composicao(6, "g6"));
//			listaComposicaos.add(new Composicao(7, "g7"));
//			listaComposicaos.add(new Composicao(8, "g8"));

			// Exemplo de Lista de Composicao Puxando do TXT
			// listaComposicaos = new Composicao().ler();

			// Exemplo de Lista de Composicao Puxando do SQL
			if ((campo == null ) || (campo.equals("")) ){
				listaComposicaos = new ComposicaoBo().consultar("");
			}
			else {
				listaComposicaos = new ComposicaoBo().consultar(campo);
			}
		}

		public int getRowCount() {
			return listaComposicaos.size();
		}

		public int getColumnCount() {
			return colunas.length;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex == 0) {
				return listaComposicaos.get(rowIndex).getId();
			}
			if (columnIndex == 1) {
				return listaComposicaos.get(rowIndex).getDescricao();
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
				listaComposicaos.get(rowIndex).setId((int) aValue);
			}
			if (columnIndex == 1) {
				listaComposicaos.get(rowIndex).setDescricao((String) aValue);
			}
			this.fireTableCellUpdated(rowIndex, columnIndex);
		}
		
		public void removeRow(int row) {
			this.listaComposicaos.remove(row);
			fireTableDataChanged();
		}	
		
		public void addRow(Composicao composicao) {
			this.listaComposicaos.add(composicao);
			fireTableDataChanged();
		}
		
	}
	
	
	
	public static void main (String []args) {
		Cadastro_Composicao composicao = new Cadastro_Composicao();
	}
	
	
}
