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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import br.edu.unifacear.bo.UsuarioBo;
import br.edu.unifacear.classes.Borda;
import br.edu.unifacear.classes.Usuario;

public class ConsultarAdm_Adm extends JFrame{

	
	private JTextField txtAdm;
	private JTable table;
	public ConsultarAdm_Adm() {
		setTitle("Consultar Administradores");
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setLayout(null);
		
		JLabel lblAdm = new JLabel("Administradores");
		lblAdm.setForeground(new Color(255, 204, 51));
		lblAdm.setFont(new Font("Rockwell Condensed", Font.PLAIN, 50));
		lblAdm.setBounds(125, 11, 261, 99);
		getContentPane().add(lblAdm);
		
		
		txtAdm = new JTextField();
		txtAdm.setBounds(71, 111, 298, 20);
		getContentPane().add(txtAdm);
		txtAdm.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
//		btnPesquisar.addActionListener(new ActionListener() {
//		
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//					atualizaGridTela(txtAdm.getText());
//				
//			}
//			});
				
		btnPesquisar.setBackground(new Color(255, 204, 51));
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPesquisar.setBounds(379, 110, 100, 23);
		getContentPane().add(btnPesquisar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblNome.setBounds(10, 102, 71, 44);
		getContentPane().add(lblNome);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBackground(new Color(255, 204, 51));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Menu_Adm menu = new Menu_Adm();
				ConsultarAdm_Adm.this.dispose();
				
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		getContentPane().add(btnVoltar);
		
		JButton btnCadastrar = new JButton("Novo");
		btnCadastrar.setBackground(new Color(255, 204, 51));
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastrar.setToolTipText("Adicionar novo administrador");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro_Adm cadastro_adm = new Cadastro_Adm();
				ConsultarAdm_Adm.this.dispose();
				
			}
		});
		btnCadastrar.setBounds(194, 516, 108, 23);
		getContentPane().add(btnCadastrar);
		
		JButton btnTipoUsu = new JButton("Novo Tipo de Usuário");
		btnTipoUsu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTipoUsu.setBackground(new Color(255, 204, 51));
		btnTipoUsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro_TipoUsuario TipoUser = new Cadastro_TipoUsuario();
				ConsultarAdm_Adm.this.dispose();
			}
		});
		btnTipoUsu.setBounds(161, 11, 152, 23);
		getContentPane().add(btnTipoUsu);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditar.setBackground(new Color(255, 204, 51));
		btnEditar.setBounds(57, 516, 100, 23);
		getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExcluir.setBackground(new Color(255, 204, 51));
		btnExcluir.setBounds(340, 517, 100, 23);
		getContentPane().add(btnExcluir);
	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(505, 611);
		this.setResizable(false);
		this.setVisible(true);
	}

	
//	private Usuario pegarLinhaTableParaObjeto() {
//		// ler dados do grid
//		int line = table.getSelectedRow();
//		int id = (Integer) table.getValueAt(line, 0);
//		String nome = (String) table.getValueAt(line, 1);
//		String cpf = (String) table.getValueAt(line, 2);
//		// montar objeto com os dados
//		Usuario b = new Usuario(id, nome, cpf);
//		return b;
//	}
//
//	private void atualizaGridTela(String campo) {
//		try {
//			if (campo.equals("") ) {
//				modeloUsuario = new ModelUsuario(null);
//			}	
//			else { 
//				modeloUsuario = new ModelUsuario(campo);
//			}
//				
//			table.setModel(modeloUsuario);
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null,  msgSQLErro +e.getMessage());
//		}
//	} // atualizaGridTela
//
//	private void deletarLinhaTabela() {
//		Usuario b = pegarLinhaTableParaObjeto();
//		try {
//			int bRemover = JOptionPane.showConfirmDialog(null, "Deseja remover o usuario?");
//			if (bRemover == 0) {
//				new UsuarioBo().deletar(b);
//				JOptionPane.showMessageDialog(null, "Usuario deletado");
//				atualizaGridTela("");
//			}
//		} catch (Exception e1) {
//			JOptionPane.showMessageDialog(null, e1.getMessage());
//		}
//	}
//
//
//
//
//class ModelUsuario extends AbstractTableModel {
//	private java.util.List<Usuario> listaUsuarios = new java.util.ArrayList<Usuario>();
//	private String colunas[] = { "Id", "Nome", "Cpf" };
//	private Class<?> colClasses[] = { int.class, String.class };
//
//	public ModelUsuario(String campo) throws Exception {
//	
//		if ((campo == null ) || (campo.equals("")) ){
//			listaUsuarios = new UsuarioBo().consultar("");
//		}
//		else {
//			listaUsuarios = new UsuarioBo().consultar(campo);
//		}
//	}
//
//	public int getRowCount() {
//		return listaUsuarios.size();
//	}
//
//	public int getColumnCount() {
//		return colunas.length;
//	}
//
//	public Object getValueAt(int rowIndex, int columnIndex) {
//		if (columnIndex == 0) {
//			return listaUsuarios.get(rowIndex).getId();
//		}
//		if (columnIndex == 1) {
//			return listaUsuarios.get(rowIndex).getNome();
//		}
//		if (columnIndex == 2) {
//			return listaUsuarios.get(rowIndex).getCpf();
//		}
//		return null;
//	}
//
//	public String getColumnName(int columnIndex) {
//		return colunas[columnIndex];
//	}
//
//	public Class<?> getColumnClass(int columnIndex) {
//		return colClasses[columnIndex];
//	}
//
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		return true;
//	}
//
//	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//		if (columnIndex == 0) {
//			listaUsuarios.get(rowIndex).setId((int) aValue);
//		}
//		if (columnIndex == 1) {
//			listaUsuarios.get(rowIndex).setNome((String) aValue);
//		}
//		if (columnIndex == 2) {
//			listaUsuarios.get(rowIndex).setCpf((String) aValue);
//		}
//		this.fireTableCellUpdated(rowIndex, columnIndex);
//	}
//	
//	public void removeRow(int row) {
//		this.listaUsuarios.remove(row);
//		fireTableDataChanged();
//	}	
//	
//	public void addRow(Usuario usuario) {
//		this.listaUsuarios.add(usuario);
//		fireTableDataChanged();
//	}
//	
//}
	
	
	
	public static void main (String []args) {
		
		ConsultarAdm_Adm consultaAdm = new ConsultarAdm_Adm();
	}
}
