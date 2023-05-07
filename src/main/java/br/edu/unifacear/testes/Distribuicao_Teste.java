package br.edu.unifacear.testes;

import java.util.List;

import br.edu.unifacear.bo.DistribuicaoBo;
import br.edu.unifacear.classes.Distribuicao;
import br.edu.unifacear.classes.Distribuicao;

public class Distribuicao_Teste {

	public static void main (String []args) {
			
			Distribuicao distribuicao = new Distribuicao();
			
			distribuicao.setDescricao("Casa da Moeda RJ");
			
			DistribuicaoBo distribuicaoBo = new DistribuicaoBo();
			try {
				distribuicaoBo.salvar(distribuicao);
				System.out.println("Distribuicao inserido - " + distribuicao);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List <Distribuicao> lista = distribuicaoBo.consultar("A");
				for (Distribuicao distribuicao2 : lista) {
					System.out.println(">>>" + distribuicao2);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
