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

import br.edu.unifacear.bo.EstadoConservacaoBo;
import br.edu.unifacear.bo.EstadoConservacaoBo;
import br.edu.unifacear.classes.EstadoConservacao;
import br.edu.unifacear.classes.EstadoConservacao;
import br.edu.unifacear.telas.Cadastro_EstadoConservacao.ModelEstadoConservacao;

public class Cadastro_EstadoConservacao extends JFrame{
	
	private final String msgSQLErro = "Erro ao acessar os dados\n";
	private JTextField txtNome;
	private ModelEstadoConservacao modeloEstadoConservacao;
	private JTable table;
	private JScrollPane barraRolagem;
	
	public Cadastro_EstadoConservacao() {
		
		try {
			modeloEstadoConservacao = new ModelEstadoConservacao(null);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, msgSQLErro + e1.getMessage());
		}
		table = new JTable(modeloEstadoConservacao);
		barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(20, 186, 411, 176);
		getContentPane().add(barraRolagem);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Duplo click, abrir pra edi��o
				if (e.getClickCount() == 2) {
					pegarLinhaTableParaObjeto();
					Manter_EstadoConservacao estadoConservacao = new Manter_EstadoConservacao();
					//System.out.println("Teste");
				}
			}
		});

		
		
		setTitle("Cadastro EstadoConservacao");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblEstadoConservacao = new JLabel("EstadoConservacaos");
		lblEstadoConservacao.setForeground(new Color(255, 204, 51));
		lblEstadoConservacao.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblEstadoConservacao.setBounds(165, 48, 106, 96);
		getContentPane().add(lblEstadoConservacao);
		
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
				Cadastro_EstadoConservacao.this.dispose();
				
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
				
				Cadastro_EstadoConservacao.this.dispose();
				Manter_EstadoConservacao EstadoConservacao = new Manter_EstadoConservacao();
				
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
				EstadoConservacao ec = pegarLinhaTableParaObjeto();
				Manter_EstadoConservacao estadoConservacao = new Manter_EstadoConservacao(ec);	
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
		
		private EstadoConservacao pegarLinhaTableParaObjeto() {
			// ler dados do grid
			int line = table.getSelectedRow();
			int id = (Integer) table.getValueAt(line, 0);
			String descricao = (String) table.getValueAt(line, 1);
			// montar objeto com os dados
			EstadoConservacao ec = new EstadoConservacao(id, descricao);
			return ec;
		}
	
		private void atualizaGridTela(String campo) {
			try {
				if (campo.equals("") ) {
					modeloEstadoConservacao = new ModelEstadoConservacao(null);
				}	
				else { 
					modeloEstadoConservacao = new ModelEstadoConservacao(campo);
				}
					
				table.setModel(modeloEstadoConservacao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,  msgSQLErro +e.getMessage());
			}
		} // atualizaGridTela

		private void deletarLinhaTabela() {
			EstadoConservacao ec = pegarLinhaTableParaObjeto();
			try {
				int bRemover = JOptionPane.showConfirmDialog(null, "Deseja remover o estadoConservacao?");
				if (bRemover == 0) {
					new EstadoConservacaoBo().deletar(ec);
					JOptionPane.showMessageDialog(null, "EstadoConservacao deletado");
					atualizaGridTela("");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	
	
	
	
	
	
	class ModelEstadoConservacao extends AbstractTableModel {
		private java.util.List<EstadoConservacao> listaEstadoConservacaos = new java.util.ArrayList<EstadoConservacao>();
		private String colunas[] = { "Id", "Descricao" };
		private Class<?> colClasses[] = { int.class, String.class };

		public ModelEstadoConservacao(String campo) throws Exception {
		
			if ((campo == null ) || (campo.equals("")) ){
				listaEstadoConservacaos = new EstadoConservacaoBo().consultar("");
			}
			else {
				listaEstadoConservacaos = new EstadoConservacaoBo().consultar(campo);
			}
		}

		public int getRowCount() {
			return listaEstadoConservacaos.size();
		}

		public int getColumnCount() {
			return colunas.length;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex == 0) {
				return listaEstadoConservacaos.get(rowIndex).getId();
			}
			if (columnIndex == 1) {
				return listaEstadoConservacaos.get(rowIndex).getDescricao();
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
				listaEstadoConservacaos.get(rowIndex).setId((int) aValue);
			}
			if (columnIndex == 1) {
				listaEstadoConservacaos.get(rowIndex).setDescricao((String) aValue);
			}
			this.fireTableCellUpdated(rowIndex, columnIndex);
		}
		
		public void removeRow(int row) {
			this.listaEstadoConservacaos.remove(row);
			fireTableDataChanged();
		}	
		
		public void addRow(EstadoConservacao estadoConservacao) {
			this.listaEstadoConservacaos.add(estadoConservacao);
			fireTableDataChanged();
		}
		
	}
	
	
	
	public static void main (String []args) {
		Cadastro_EstadoConservacao estadoConservacao = new Cadastro_EstadoConservacao();
	}
	
	
}
