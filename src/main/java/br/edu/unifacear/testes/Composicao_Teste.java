
package br.edu.unifacear.testes;

import java.util.List;

import br.edu.unifacear.bo.ComposicaoBo;
import br.edu.unifacear.classes.Composicao;

public class Composicao_Teste {

public static void main (String []args) {
		
		Composicao composicao = new Composicao(7,"Cobre");
		
		System.out.println(composicao);

		composicao.setDescricao("Cobre");
		
		ComposicaoBo composicaoBo = new ComposicaoBo();
		try {
			composicaoBo.salvar(composicao);
			System.out.println("Composicao inserido - " + composicao);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List <Composicao> lista = composicaoBo.consultar("A");
			for (Composicao composicao2 : lista) {
				System.out.println(">>>" + composicao2);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
