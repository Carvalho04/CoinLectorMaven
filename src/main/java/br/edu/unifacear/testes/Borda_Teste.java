package br.edu.unifacear.testes;

import java.util.List;

import br.edu.unifacear.bo.BordaBo;
import br.edu.unifacear.classes.Borda;

public class Borda_Teste {

	public static void main (String []args) {
		
		Borda borda = new Borda();
		
		borda.setDescricao("Serrilhada");
		
		BordaBo bordaBo = new BordaBo();
		try {
			bordaBo.salvar(borda);
			System.out.println("Borda inserido - " + borda);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
//		try {
//			List <Borda> lista = bordaBo.consultar("");
//			for (Borda borda2 : lista) {
//				System.out.println(">>>" + borda2);
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
	}
}
