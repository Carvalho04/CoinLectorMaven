package br.edu.unifacear.testes;

import java.time.LocalDate;
import java.util.List;

import br.edu.unifacear.bo.ColecaoBo;
import br.edu.unifacear.classes.Colecao;
import br.edu.unifacear.classes.Colecao;
import br.edu.unifacear.classes.EstadoConservacao;
import br.edu.unifacear.classes.Moeda;
import br.edu.unifacear.classes.Usuario;

public class Colecao_Teste {

	public static void main(String []args) {
		
		Moeda moeda = new Moeda();
		moeda.setId(4);
		
		Usuario colecionador = new Usuario();
		colecionador.setId(7);
		
		EstadoConservacao estadoConservacao = new EstadoConservacao();
		estadoConservacao.setId(6);
		
		Colecao colecao = new Colecao();
		
		colecao.setAno(12);
		colecao.setColecionador(colecionador);
		colecao.setMoeda(moeda);
		colecao.setEstadoConservacao(estadoConservacao);
		
		ColecaoBo colecaoBo = new ColecaoBo();
		try {
			colecaoBo.salvar(colecao);
			System.out.println("Colecao inserido - " + colecao);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List <Colecao> lista = colecaoBo.consultar("A");
			for (Colecao colecao2 : lista) {
				System.out.println(">>>" + colecao2);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
