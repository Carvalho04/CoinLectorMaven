package br.edu.unifacear.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.bo.ItensAVendaBo;
import br.edu.unifacear.classes.ItensAVenda;
import br.edu.unifacear.classes.Colecao;
import br.edu.unifacear.classes.Continente;
import br.edu.unifacear.classes.ItensAVenda;
import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.classes.Venda;

public class ItensAVenda_Teste {

	public static void main(String []args) {
		
		Colecao colecao = new Colecao();
		colecao.setId(6);
		
		Usuario colecionador = new Usuario();
		colecionador.setId(7);
		
		Venda venda = new Venda();
		venda.setId(66);
		
		
		List <ItensAVenda> itensAVenda2 = new ArrayList();
		
		ItensAVenda itensAVenda = new ItensAVenda();
		
		itensAVenda.setQuantidade(4);
		itensAVenda.setValor(7.50);
		itensAVenda.setTotal(5.9);
		itensAVenda.setColecionador(colecionador);
		itensAVenda.setColecao(colecao);
		itensAVenda.setVenda(venda);
		itensAVenda2.add(itensAVenda);
		venda.setItensAVenda(itensAVenda2);
	
		
		ItensAVendaBo itensAVendaBo = new ItensAVendaBo();
		try {
			itensAVendaBo.salvar(itensAVenda);
			System.out.println("ItensAVenda inserido - " + itensAVenda);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List <ItensAVenda> lista = itensAVendaBo.consultar("A");
			for (ItensAVenda itensaVenda : lista) {
				System.out.println(">>>" + itensAVenda2);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
