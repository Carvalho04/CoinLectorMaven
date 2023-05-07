package br.edu.unifacear.testes;

import java.util.List;

import br.edu.unifacear.bo.EstadoConservacaoBo;
import br.edu.unifacear.classes.EstadoConservacao;
import br.edu.unifacear.classes.EstadoConservacao;

public class EstadoConservacao_Teste {

	public static void main(String []args) {
			
			EstadoConservacao estadoConservacao = new EstadoConservacao();
			
			estadoConservacao.setDescricao("Circular");
			
			EstadoConservacaoBo estadoConservacaoBo = new EstadoConservacaoBo();
			try {
				estadoConservacaoBo.salvar(estadoConservacao);
				System.out.println("EstadoConservacao inserido - " + estadoConservacao);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List <EstadoConservacao> lista = estadoConservacaoBo.consultar("A");
				for (EstadoConservacao estadoConservacao2 : lista) {
					System.out.println(">>>" + estadoConservacao2);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
