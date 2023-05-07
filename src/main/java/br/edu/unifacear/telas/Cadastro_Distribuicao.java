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

import br.edu.unifacear.bo.DistribuicaoBo;
import br.edu.unifacear.bo.DistribuicaoBo;
import br.edu.unifacear.classes.Distribuicao;
import br.edu.unifacear.classes.Distribuicao;
import br.edu.unifacear.telas.Cadastro_Distribuicao.ModelDistribuicao;

public class Cadastro_Distribuicao extends JFrame{
	
	private final String msgSQLErro = "Erro ao acessar os dados\n";
	private JTextField txtNome;
	private ModelDistribuicao modeloDistribuicao;
	private JTable table;
	private JScrollPane barraRolagem;
	
	public Cadastro_Distribuicao() {
		
		try {
			modeloDistribuicao = new ModelDistribuicao(null);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, msgSQLErro + e1.getMessage());
		}
		table = new JTable(modeloDistribuicao);
		barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(20, 186, 411, 176);
		getContentPane().add(barraRolagem);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Duplo click, abrir pra edi��o
				if (e.getClickCount() == 2) {
					pegarLinhaTableParaObjeto();
					Manter_Distribuicao Distribuicao = new Manter_Distribuicao();
					//System.out.println("Teste");
				}
			}
		});

		
		
		setTitle("Cadastro Distribuicao");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblDistribuicao = new JLabel("Distribuicaos");
		lblDistribuicao.setForeground(new Color(255, 204, 51));
		lblDistribuicao.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblDistribuicao.setBounds(133, 48, 181, 96);
		getContentPane().add(lblDistribuicao);
		
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
				Cadastro_Distribuicao.this.dispose();
				
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
				
				Cadastro_Distribuicao.this.dispose();
				Manter_Distribuicao Distribuicao = new Manter_Distribuicao();
				
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
				Distribuicao d = pegarLinhaTableParaObjeto();
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
		
		private Distribuicao pegarLinhaTableParaObjeto() {
			// ler dados do grid
			int line = table.getSelectedRow();
			int id = (Integer) table.getValueAt(line, 0);
			String descricao = (String) table.getValueAt(line, 1);
			// montar objeto com os dados
			Distribuicao d = new Distribuicao(id, descricao);
			return d;
		}
	
		private void atualizaGridTela(String campo) {
			try {
				if (campo.equals("") ) {
					modeloDistribuicao = new ModelDistribuicao(null);
				}	
				else { 
					modeloDistribuicao = new ModelDistribuicao(campo);
				}
					
				table.setModel(modeloDistribuicao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,  msgSQLErro +e.getMessage());
			}
		} // atualizaGridTela

		private void deletarLinhaTabela() {
			Distribuicao d = pegarLinhaTableParaObjeto();
			try {
				int bRemover = JOptionPane.showConfirmDialog(null, "Deseja remover o Distribuicao?");
				if (bRemover == 0) {
					new DistribuicaoBo().deletar(d);
					JOptionPane.showMessageDialog(null, "Distribuicao deletado");
					atualizaGridTela("");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	
	
	
	
	
	
	class ModelDistribuicao extends AbstractTableModel {
		private java.util.List<Distribuicao> listaDistribuicaos = new java.util.ArrayList<Distribuicao>();
		private String colunas[] = { "Id", "Descricao" };
		private Class<?> colClasses[] = { int.class, String.class };

		public ModelDistribuicao(String campo) throws Exception {
			// Exemplo de Lista de Distribuicao Manual - TESTE - Comentado
//			listaDistribuicaos.add(new Distribuicao(1, "g1"));
//			listaDistribuicaos.add(new Distribuicao(2, "g2"));
//			listaDistribuicaos.add(new Distribuicao(3, "g3"));
//			listaDistribuicaos.add(new Distribuicao(4, "g4"));
//			listaDistribuicaos.add(new Distribuicao(5, "g5"));
//			listaDistribuicaos.add(new Distribuicao(6, "g6"));
//			listaDistribuicaos.add(new Distribuicao(7, "g7"));
//			listaDistribuicaos.add(new Distribuicao(8, "g8"));

			// Exemplo de Lista de Distribuicao Puxando do TXT
			// listaDistribuicaos = new Distribuicao().ler();

			// Exemplo de Lista de Distribuicao Puxando do SQL
			if ((campo == null ) || (campo.equals("")) ){
				listaDistribuicaos = new DistribuicaoBo().consultar("");
			}
			else {
				listaDistribuicaos = new DistribuicaoBo().consultar(campo);
			}
		}

		public int getRowCount() {
			return listaDistribuicaos.size();
		}

		public int getColumnCount() {
			return colunas.length;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex == 0) {
				return listaDistribuicaos.get(rowIndex).getId();
			}
			if (columnIndex == 1) {
				return listaDistribuicaos.get(rowIndex).getDescricao();
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
				listaDistribuicaos.get(rowIndex).setId((int) aValue);
			}
			if (columnIndex == 1) {
				listaDistribuicaos.get(rowIndex).setDescricao((String) aValue);
			}
			this.fireTableCellUpdated(rowIndex, columnIndex);
		}
		
		public void removeRow(int row) {
			this.listaDistribuicaos.remove(row);
			fireTableDataChanged();
		}	
		
		public void addRow(Distribuicao distribuicao) {
			this.listaDistribuicaos.add(distribuicao);
			fireTableDataChanged();
		}
		
	}
	
	
	
	public static void main (String []args) {
		Cadastro_Distribuicao distribuicao = new Cadastro_Distribuicao();
	}
	
	
}
